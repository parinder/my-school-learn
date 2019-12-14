package com.myschool.learn.gms.tests.api.enterprise.adminv1;

import java.io.IOException;
import com.myschool.learn.gms.apis.enterprise.AdminV1Api;
import com.myschool.learn.gms.apis.enterprise.AuthApi;
import com.myschool.learn.gms.tests.BaseIntegrationTest;
import org.testng.annotations.BeforeClass;

public class BaseAdminV1IntegrationTest extends BaseIntegrationTest {

    protected AdminV1Api adminV1Api;
    protected AuthApi authApi;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.adminV1Api = new AdminV1Api(this.config);
        this.authApi = new AuthApi(this.config);
    }
}