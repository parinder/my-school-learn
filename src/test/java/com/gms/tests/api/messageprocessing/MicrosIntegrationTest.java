package com.gms.tests.api.messageprocessing;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gms.apis.messageprocessing.MicrosApi;
import com.gms.tests.BaseIntegrationTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MicrosIntegrationTest extends BaseIntegrationTest {

    protected MicrosApi microsApi;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.microsApi = new MicrosApi(this.config);
    }

    @Test(description = "Verify successful Profile message submission.")
    public void testProfileMessageSuccess() {
        String propertyName = "AUTOMATIONTEST";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String createdDate = formatter.format(new Date());
        String guestFirstName = this.randomDataHelper.getRandomFirstName();
        String guestLastName = this.randomDataHelper.getRandomLastName();
        String guestEmail = this.randomDataHelper.getRandomEmailAddress(guestFirstName, guestLastName);
        String guestId = guestFirstName + "" + guestLastName + RandomStringUtils.random(10, true, true);

        String responseBody = this.microsApi.postProfileMessage(propertyName, createdDate, guestFirstName,
                guestLastName, guestEmail, guestId);
        Assert.assertEquals(responseBody.trim(), "Your message has been processed.");
    }
}