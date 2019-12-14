package com.gms.tests.api.enterprise.jobsv1;

import java.io.IOException;
import com.gms.apis.enterprise.AuthApi;
import com.gms.apis.enterprise.JobsV1Api;
import com.gms.tests.BaseIntegrationTest;
import org.testng.annotations.BeforeClass;

public class BaseJobsV1IntegrationTest extends BaseIntegrationTest {

    protected AuthApi authApi;
    protected JobsV1Api jobsV1Api;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.authApi = new AuthApi(this.config);
        this.jobsV1Api = new JobsV1Api(this.config);
    }
}