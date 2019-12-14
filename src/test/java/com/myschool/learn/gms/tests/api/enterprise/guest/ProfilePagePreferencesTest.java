package com.myschool.learn.gms.tests.api.enterprise.guest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class ProfilePagePreferencesTest extends BaseGuestIntegrationTest {

	@Test(description = "Verify getting guest profile preferences.")
	public void testGetPreferences() {
		String authToken = this.authApi.getAuthTokenViaLogin("qaautomated.guest-api-user-all", this.defaultPassword,
				true);
		JsonPath responseJsonPath = this.guestApi.getProfilePreferences(authToken, "315u1cy1d018914i19416m14800");

		// this data came form reservations created via postman, may not be legit
		Assert.assertEquals(responseJsonPath.get("preferences[0].name"), "Enter Free Form Comment");
		Assert.assertEquals(responseJsonPath.getList("preferences[0].answers").size(), 0, "Did not get 0 answers");
		Assert.assertEquals(responseJsonPath.get("preferences[0].ID"), "80837");
		Assert.assertEquals(responseJsonPath.get("preferences[0].text"), "Enter Free Form Comment");
		Assert.assertEquals(responseJsonPath.get("preferences[0].type"), "TEXT");

		Assert.assertEquals(responseJsonPath.get("preferences[1].name"), "Gender");
		Assert.assertEquals(responseJsonPath.getList("preferences[1].answers").size(), 0, "Did not get 0 answers");
		Assert.assertEquals(responseJsonPath.get("preferences[1].ID"), "90821");
		Assert.assertEquals(responseJsonPath.get("preferences[1].text"), "Gender");
		Assert.assertEquals(responseJsonPath.get("preferences[1].type"), "MULTIPLE");
		Assert.assertEquals(responseJsonPath.getList("preferences[1].choices").size(), 2, "Did not get 2 choices");
	}
}