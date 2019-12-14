package com.myschool.learn.gms.tests.api.loyalty.v1;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LoyaltyV1ProfilePageTest extends BaseLoyaltyV1IntegrationTest {

	@Test(description = "Verify that the user gets all the details of the profile")
	public void testGetProfile() {
		String authToken = this.loyaltyV1Api.postLoginAndReturnAuthToken("loyal.tannenbaum@example.com",
				this.defaultPassword, this.config.getProperty("api.loyalty.v1.appsecretkey"));
		JsonPath profileJsonPath = this.loyaltyV1Api.getProfile(authToken,
				this.config.getProperty("api.loyalty.v1.appsecretkey"));

		Assert.assertTrue(profileJsonPath.get("success"));
		Assert.assertNull(profileJsonPath.get("errorCode"));
		Assert.assertNull(profileJsonPath.get("errorMessage"));

		Assert.assertEquals(profileJsonPath.get("data.memberId"), "loyal.tannenbaum@example.com");
		Assert.assertEquals(profileJsonPath.get("data.privateOfferCode"), "bronze");

		Assert.assertFalse(profileJsonPath.get("data.member.smsOptin"));
		Assert.assertEquals(profileJsonPath.get("data.member.optedIn").toString(), "0");
		Assert.assertEquals(profileJsonPath.get("data.member.consents"), new ArrayList<>()); // empty array

		Assert.assertEquals(profileJsonPath.get("data.member.email"), "loyal.tannenbaum@example.com");
		Assert.assertEquals(profileJsonPath.get("data.member.firstName"), "Loyal");
		Assert.assertEquals(profileJsonPath.get("data.member.lastName"), "Tannenbaum");
		Assert.assertEquals(profileJsonPath.get("data.member.middleName"), "R");
		Assert.assertNull(profileJsonPath.get("data.member.nameSuffix"));
		Assert.assertEquals(profileJsonPath.get("data.member.salutation"), "Mister");

		Assert.assertEquals(profileJsonPath.get("data.member.gender"), "Male");
		Assert.assertEquals(profileJsonPath.get("data.member.birthday"), "1989-01-01");
		Assert.assertEquals(profileJsonPath.get("data.member.citizenship"), "Can");

		Assert.assertEquals(profileJsonPath.get("data.member.address"), "1 Test Street");
		Assert.assertEquals(profileJsonPath.get("data.member.address2"), "Unit 1");
		Assert.assertEquals(profileJsonPath.get("data.member.city"), "Ottawa");
		Assert.assertEquals(profileJsonPath.get("data.member.state"), "Ontario");
		Assert.assertEquals(profileJsonPath.get("data.member.zip"), "A1A1A1");
		Assert.assertEquals(profileJsonPath.get("data.member.country"), "CA");

		Assert.assertEquals(profileJsonPath.get("data.member.homePhoneNumber"), "5555550201");
		Assert.assertEquals(profileJsonPath.get("data.member.cellPhoneNumber"), "5555550202");
		Assert.assertEquals(profileJsonPath.get("data.member.officePhoneNumber"), "5555550204");
		Assert.assertEquals(profileJsonPath.get("data.member.fax"), "5555550203");

		Assert.assertEquals(profileJsonPath.get("data.member.title"), "Matriarch");
		Assert.assertEquals(profileJsonPath.get("data.member.company"), "WesCo");

		Assert.assertEquals(profileJsonPath.get("data.member.createdDate"), "2019-06-12");
	}
}
