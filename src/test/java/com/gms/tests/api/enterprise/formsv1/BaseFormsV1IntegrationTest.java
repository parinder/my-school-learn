package com.gms.tests.api.enterprise.formsv1;

import java.io.IOException;
import com.gms.apis.enterprise.AuthApi;
import com.gms.apis.enterprise.FormsV1Api;
import com.gms.tests.BaseIntegrationTest;
import org.testng.annotations.BeforeClass;

public class BaseFormsV1IntegrationTest extends BaseIntegrationTest {

    protected AuthApi authApi;
    protected FormsV1Api formsV1Api;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.authApi = new AuthApi(this.config);
        this.formsV1Api = new FormsV1Api(this.config);
    }
}