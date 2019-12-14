package com.myschool.learn.gms.tests.api.enterprise.guest;

import java.io.IOException;

import com.myschool.learn.gms.apis.enterprise.AuthApi;
import com.myschool.learn.gms.apis.enterprise.GuestApi;
import com.myschool.learn.gms.helpers.GuestApiJsonHelper;
import com.myschool.learn.gms.tests.BaseIntegrationTest;

import org.testng.annotations.BeforeClass;

public class BaseGuestIntegrationTest extends BaseIntegrationTest {

    protected AuthApi authApi;
    protected GuestApi guestApi;
    protected GuestApiJsonHelper guestApiJsonHelper;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.authApi = new AuthApi(this.config);
        this.guestApi = new GuestApi(this.config);
        this.guestApiJsonHelper = new GuestApiJsonHelper();
    }
}