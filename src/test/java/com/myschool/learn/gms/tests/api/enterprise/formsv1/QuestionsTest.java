package com.myschool.learn.gms.tests.api.enterprise.formsv1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class QuestionsTest extends BaseFormsV1IntegrationTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
    }

    @Test(description = "Test entries questions endpoint.")
    public void testGetQuestions() {
        String authToken = this.authApi.getAuthTokenViaLogin(this.defaultUsername, this.defaultPassword, false);
        JsonPath responseJsonPath = formsV1Api.getEntriesQuestions(authToken, "56181", "11992862", "92242");
        Assert.assertEquals(responseJsonPath.get("name"), "Select 1 of 2", "Response name should be 'Select 1 of 2'.");
        Assert.assertEquals(responseJsonPath.get("answers[0]"), "Two", "Response answers should be 'Two'.");
        Assert.assertEquals(responseJsonPath.get("id"), "92242", "Response id should be '92242'.");
        Assert.assertEquals(responseJsonPath.get("text"), "1", "Response text should be '1'.");
        Assert.assertEquals(responseJsonPath.get("type"), "One Answer", "Response type should be 'One Answer'.");
        Assert.assertEquals(responseJsonPath.get("choices[0]"), "One", "Response choice should be 'One'.");
        Assert.assertEquals(responseJsonPath.get("choices[1]"), "Two", "Response choice should be 'Two'.");
        Assert.assertFalse(responseJsonPath.get("mandatory"), "Response mandatory should be false.");
    }
}