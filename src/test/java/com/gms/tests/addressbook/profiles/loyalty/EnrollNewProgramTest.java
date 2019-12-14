package com.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gms.tests.addressbook.profiles.BaseProfilesTest;

public class EnrollNewProgramTest extends BaseProfilesTest {

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.login(this.defaultUsername, this.defaultPassword);
        }

        @Test(description = "Verify enroll in guest program.")
        public void testEnrollmentHouseProgramToNewProfileInLoyaltyTab() {
                String newFirstName = this.randomDataHelper.getRandomFirstName();
                String newLastName = this.randomDataHelper.getRandomLastName();
                String newEmail = this.randomDataHelper.getRandomEmailAddress(newFirstName, newLastName);

                this.createNewProfile(newFirstName, newLastName, "P", newEmail, "City");

                this.headerPage.clickProfileLoyaltyTab();
                this.loyaltyTabPage.waitForPageLoad();
                this.loyaltyTabPage.clickEnrollNewProgramButton();
                this.loyaltyTabPage.waitForEnrollNewProgramModalToBeVisible();
                Assert.assertEquals(this.loyaltyTabPage.getEnrollNewProgramModalMemberNumber(), newEmail,
                                "Enroll new program modal Mmmber number should default to: '" + newEmail + "'.");

                this.loyaltyTabPage.clickEnrollNewProgramModalProgramToEnrollDropdown();
                this.loyaltyTabPage.enterEnrollNewProgramModalProgramToEnrollSearch("Guest Portal");

                this.loyaltyTabPage.clickEnrollNewProgramModalGuestPortalToEnrollInDropdown();
                this.loyaltyTabPage.enterEnrollNewProgramModalGuestPortalToEnrollInSearch("QA");

                this.loyaltyTabPage.clickEnrollNewProgramModalSaveButton();

                Assert.assertTrue(this.profilesPage.membershipActivationEmailHasBeenSentModalIsVisible(),
                                "Membership activation email has been sent modal is not visible");
                this.profilesPage.clickMembershipActivationEmailHasBeenSentModalCloseButton();

                Assert.assertTrue(this.loyaltyTabPage.loyaltymembershipPointsCardIsVisible(),
                                "Membership card is not visible");
                Assert.assertTrue(this.loyaltyTabPage.loyaltyStaysCardIsVisible(), "Loyalty card is not visible");
                Assert.assertTrue(this.loyaltyTabPage.loyaltyPointExpiringCardIsVisible(),
                                "Point Expiring Card is not visible");
                Assert.assertTrue(this.loyaltyTabPage.loyaltyDollarSpentCardIsVisible(),
                                "Loyalty Dollar spent card is not visible");
                Assert.assertTrue(
                                this.loyaltyTabPage.getPointsHistoryTableReason(1)
                                                .contains("Points awarded for signing up."),
                                "Point History table row 1 - Reason does not contain text 'Points awarded for signing up.'");
        }

        @Test(description = "Verify enroll in non-house program.")
        public void testEnrollmentNonHouseProgramToNewProfileInLoyaltyTab() {
                String newFirstName = this.randomDataHelper.getRandomFirstName();
                String newLastName = this.randomDataHelper.getRandomLastName();
                String newEmail = this.randomDataHelper.getRandomEmailAddress(newFirstName, newLastName);

                this.createNewProfile(newFirstName, newLastName, "P", newEmail, "City");

                this.headerPage.clickProfileLoyaltyTab();
                this.loyaltyTabPage.waitForPageLoad();
                this.loyaltyTabPage.clickEnrollNewProgramButton();
                this.loyaltyTabPage.waitForEnrollNewProgramModalToBeVisible();
                Assert.assertEquals(this.loyaltyTabPage.getEnrollNewProgramModalMemberNumber(), newEmail,
                                "Enroll new program modal member number should default to: '" + newEmail + "'.");
                this.loyaltyTabPage.clickEnrollNewProgramModalProgramToEnrollDropdown();
                this.loyaltyTabPage.enterEnrollNewProgramModalProgramToEnrollSearch("Aeroplan");
                this.loyaltyTabPage.clickEnrollNewProgramModalSaveButton();
                Assert.assertTrue(this.loyaltyTabPage.loyaltymembershipPointsCardIsVisible(),
                                "Membership card is not visible");
        }


}