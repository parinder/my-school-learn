package com.myschool.learn.gms.tests.api.enterprise.guest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class MembershipTest extends BaseGuestIntegrationTest {

	@Test(description = "Verify sign up with an english user.")
	public void testSignupWithEnglish() throws IOException {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic", this.defaultPassword,
				false);
		String newFirstName = this.randomDataHelper.getRandomFirstName();
		String newLastName = this.randomDataHelper.getRandomLastName();
		String newEmail = this.randomDataHelper.getRandomEmailAddress(newFirstName, newLastName);
		String signupJson = this.guestApiJsonHelper.getSignupJson(newFirstName, newLastName, newEmail, "en");
		this.guestApi.postProgramGuestMembership(signupJson, authToken);
		this.verifyGuest(newFirstName, newLastName, newEmail, authToken);
	}

	@Test(description = "Verify sign up with a french user.")
	public void testSignupWithFrench() throws IOException {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-basic",
				this.defaultPassword, false);
		String newFirstName = this.randomDataHelper.getRandomFirstName();
		String newLastName = this.randomDataHelper.getRandomLastName();
		String newEmail = this.randomDataHelper.getRandomEmailAddress(newFirstName, newLastName);
		String signupJson = this.guestApiJsonHelper.getSignupJson(newFirstName, newLastName, newEmail, "fr");
		this.guestApi.postProgramGuestMembership(signupJson, authToken);
		this.verifyGuest(newFirstName, newLastName, newEmail, authToken);
	}

	public void verifyGuest(String firstName, String lastName, String email, String authToken) {

		String bodyJson = this.guestApiJsonHelper.getEmailJson(email);

		JsonPath searchResponseJsonPath = null;

		// try until you get the new user back in the search
		for (int i = 0; i < 50; i++) {
			searchResponseJsonPath = this.guestApi.getProfileSearch(bodyJson, "MEMBERSHIPBASIC", authToken);

			if (searchResponseJsonPath.getList("profiles").size() > 0) {
				System.out.println("Found profile " + email + " in " + i + " search attempts.");
				break;
			}

			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// literally do nothing
			}
		}

		Assert.assertEquals(searchResponseJsonPath.getList("profiles").size(), 1,
				"Should be only 1 profile in search response.");
		Assert.assertEquals(searchResponseJsonPath.get("profiles[0].name.firstName"), firstName, "");
		Assert.assertEquals(searchResponseJsonPath.get("profiles[0].name.lastName"), lastName, "");
		Assert.assertEquals(searchResponseJsonPath.get("profiles[0].email"), email, "");
	}
}
