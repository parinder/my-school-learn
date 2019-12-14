package com.gms.tests.api.enterprise.adminv1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ChainsCategoryTest extends BaseAdminV1IntegrationTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
    }

    @Test(description = "Test chains/category endpoint.")
    public void testGetChainsCategory() {
        String authToken = this.authApi.getAuthTokenViaLogin(this.defaultUsername, this.defaultPassword, false);
        JsonPath responseJsonPath = adminV1Api.getChainsCategory(authToken);

        Assert.assertNull(responseJsonPath.get("[0].lastUpdateDateTime"),
                "Response 'lastUpdateDateTime' should be null.");
        Assert.assertEquals(responseJsonPath.get("[0].chain.chainName"), "QA Team - AUTOMATED Tests (DO NOT TOUCH)",
                "Response chain.chainName should be 'QA Team - AUTOMATED Tests (DO NOT TOUCH)'.");
        Assert.assertEquals(responseJsonPath.get("[0].chain.chainId"), "9477",
                "Response chain.chainId should be '9477'.");
        Assert.assertEquals(responseJsonPath.get("[0].chain.chainCode"), "9477",
                "Response chain.chainCode should be '9477'.");
        Assert.assertNull(responseJsonPath.get("[0].chain.creationBy"), "Response 'chain.creationBy' should be null.");
        Assert.assertNull(responseJsonPath.get("[0].chain.status"), "Response 'chain.status' should be null.");

        Assert.assertNull(responseJsonPath.get("[0].categoryGroups[0].lastUpdateDateTime"),
                "Response 'categoryGroups[0].lastUpdateDateTime' should be null.");

        // FUTURE: assert the rest of the payload
    }
}