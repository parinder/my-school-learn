package com.gms.tests.api.loyalty.v2;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;

public class LoyaltyV2AuthTest extends BaseLoyaltyV2IntegrationTest {

	@Test(description = "Verify auth/recaptcha endpoint.")
	public void testRecaptcha() {
		String oauthToken = this.loyaltyV2Api.postOathTokenAndReturnToken();
		JsonPath responseJsonPath = this.loyaltyV2Api.getAuthRecaptcha(oauthToken);
		Assert.assertEquals(responseJsonPath.getString("reCaptchaEnabled"), "false");
	}

	@Test(description = "Verify login.")
	public void testLogin() {
		String memberId = "loyal.tannenbaum@example.com";
		String memberPassword = this.defaultPassword;

		String oauthToken = this.loyaltyV2Api.postOathTokenAndReturnToken();
		JsonPath responseJsonPath = this.loyaltyV2Api.postAuth(memberId, memberPassword, oauthToken);
		Assert.assertEquals(responseJsonPath.getString("profile.memberInfo.memberID"), "loyal.tannenbaum@example.com",
				"Member ID should be " + memberId);
	}
}