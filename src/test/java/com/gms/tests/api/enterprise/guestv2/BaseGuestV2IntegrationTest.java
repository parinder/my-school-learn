package com.gms.tests.api.enterprise.guestv2;

import java.io.IOException;

import com.gms.apis.enterprise.AuthApi;
import com.gms.apis.enterprise.GuestV2Api;
import com.gms.tests.BaseIntegrationTest;
import org.testng.annotations.BeforeClass;

public class BaseGuestV2IntegrationTest extends BaseIntegrationTest {

    protected AuthApi authApi;
    protected GuestV2Api guestV2Api;


    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.authApi = new AuthApi(this.config);
        this.guestV2Api = new GuestV2Api(this.config);
    }
}