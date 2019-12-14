package com.myschool.learn.gms.tests.api.loyalty.v1;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;

public class LoyaltyV1LoginPageTest extends BaseLoyaltyV1IntegrationTest {

	@Test(description = "Verify that a user can login and log out.")
	public void testProfileLoginAndLogout() {
		JsonPath loginResponseJsonPath = this.loyaltyV1Api.postLogin("loyal.tannenbaum@example.com",
				this.defaultPassword, this.config.getProperty("api.loyalty.v1.appsecretkey"));
		Assert.assertTrue(loginResponseJsonPath.get("success"));

		JsonPath logoutResponseJsonPath = this.loyaltyV1Api.postLogout("loyal.tannenbaum@example.com",
				this.defaultPassword, this.config.getProperty("api.loyalty.v1.appsecretkey"));
		Assert.assertTrue(logoutResponseJsonPath.get("success"));
	}
}