package com.myschool.learn.gms.tests.api.enterprise.auth;

import java.io.IOException;

import com.myschool.learn.gms.apis.enterprise.AuthApi;
import com.myschool.learn.gms.tests.BaseIntegrationTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class AuthTest extends BaseIntegrationTest {

    protected AuthApi authApi;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.authApi = new AuthApi(this.config);
    }

    @Test(description = "Test enterprise auth endpoint.")
    public void testAuth() throws IOException {
        JsonPath responseJsonPath = this.authApi.postAuth("qaautomated.guest-api-user-basic", this.defaultPassword, false);

        String accessToken = responseJsonPath.get("accessToken");
        Assert.assertTrue(accessToken.startsWith("Bearer "), "Auth response 'accessToken' should start with 'Bearer '.");
        Assert.assertEquals(responseJsonPath.get("token_type"), "bearer", "Auth response 'token_type' should be 'bearer'.");
        int expiresIn = responseJsonPath.get("expires_in");
        Assert.assertEquals(expiresIn, 40, "Auth response 'expires_in' should be 40.");
    }

    @Test(description = "Test enterprise auth endpoint for all properties user.")
    public void testAuthAllProperties() throws IOException {
        JsonPath responseJsonPath = this.authApi.postAuth("qaautomated.guest-api-user-all", this.defaultPassword, true);

        String accessToken = responseJsonPath.get("accessToken");
        Assert.assertTrue(accessToken.startsWith("Bearer "), "Auth response 'accessToken' should start with 'Bearer '.");
        Assert.assertEquals(responseJsonPath.get("token_type"), "bearer", "Auth response 'token_type' should be 'bearer'.");
        int expiresIn = responseJsonPath.get("expires_in");
        Assert.assertEquals(expiresIn, 40, "Auth response 'expires_in' should be 40.");
    }
}