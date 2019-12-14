package com.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;
import com.gms.tests.addressbook.profiles.BaseProfilesTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SelectProgramTest extends BaseProfilesTest {

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.login(this.defaultUsername, this.defaultPassword);
        }

        @Test(description = "Test select program.")
        public void testEnrolledProgramTest() {
                String profileEmail = "jemmy.walkie@test.com";
                this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

                this.loyaltyTabPage.selectEnrolledProgramName("Guest Portal (jemmy.walkie@test.com)");
                Assert.assertTrue(this.loyaltyTabPage.loyaltymembershipPointsCardIsVisible(),
                                "Membership card is not visible");
                Assert.assertTrue(this.loyaltyTabPage.loyaltyStaysCardIsVisible(), "Loyalty card is not visible");
                Assert.assertTrue(this.loyaltyTabPage.loyaltyPointExpiringCardIsVisible(),
                                "Point Expiring Card is not visible");
                Assert.assertTrue(this.loyaltyTabPage.loyaltyDollarSpentCardIsVisible(),
                                "Loyalty Dollar spent card is not visible");

                this.loyaltyTabPage.selectEnrolledProgramName("Aeroplan (jemmy.walkie@test.com)");
                Assert.assertTrue(this.loyaltyTabPage.loyaltymembershipPointsCardIsVisible(),
                                "Membership card is not visible");
        }
}