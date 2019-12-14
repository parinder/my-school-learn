package com.gms.tests.api.loyalty.v1;

import java.io.IOException;
import com.gms.apis.LoyaltyV1Api;
import com.gms.tests.BaseIntegrationTest;
import org.testng.annotations.BeforeClass;

public class BaseLoyaltyV1IntegrationTest extends BaseIntegrationTest {

    protected LoyaltyV1Api loyaltyV1Api;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.loyaltyV1Api = new LoyaltyV1Api(this.config);
    }
}