package com.gms.tests.api.enterprise.jobsv1;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JobScheduledResetPasswordTest extends BaseJobsV1IntegrationTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
    }

    @Test(description = "Test job/scheduleResetPassword endpoint.")
    public void testGetQuestions() {
        String authToken = this.authApi.getAuthTokenViaLogin(this.defaultUsername, this.defaultPassword, false);
        JsonPath responseJsonPath = jobsV1Api.getJobScheduleResetPassword(authToken);
        List<Object> jobsList = responseJsonPath.getList("jobs");
        Assert.assertEquals(jobsList.size(), 0, " Response should have 0 jobs.");
        Assert.assertEquals(responseJsonPath.getInt("totalJobs"), 0, "Response totalJobs should be 0.");
    }
}