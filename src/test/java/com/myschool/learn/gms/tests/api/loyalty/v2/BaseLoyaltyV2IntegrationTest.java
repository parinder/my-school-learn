package com.myschool.learn.gms.tests.api.loyalty.v2;

import java.io.IOException;

import com.myschool.learn.gms.apis.LoyaltyV2Api;
import com.myschool.learn.gms.helpers.LoyaltyV2ApiJsonHelper;
import com.myschool.learn.gms.tests.BaseIntegrationTest;

import org.testng.annotations.BeforeClass;

public class BaseLoyaltyV2IntegrationTest extends BaseIntegrationTest {

    protected LoyaltyV2Api loyaltyV2Api;
    protected LoyaltyV2ApiJsonHelper loyaltyV2ApiJsonHelper;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.loyaltyV2Api = new LoyaltyV2Api(this.config);
        this.loyaltyV2ApiJsonHelper = new LoyaltyV2ApiJsonHelper();
    }
}