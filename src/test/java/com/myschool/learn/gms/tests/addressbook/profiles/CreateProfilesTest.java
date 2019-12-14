package com.myschool.learn.gms.tests.addressbook.profiles;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateProfilesTest extends BaseProfilesTest {

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.login(this.defaultUsername, this.defaultPassword);
        }

        @Test(description = "Test creating a profile without any program enrollment")
        public void testCreateProfileWithoutProgramEnrollment() {
                String newFirstName = this.randomDataHelper.getRandomFirstName();
                String newLastName = this.randomDataHelper.getRandomLastName();
                String newEmail = this.randomDataHelper.getRandomEmailAddress(newFirstName, newLastName);

                this.profilesPage.get();
                this.profilesPage.waitForPageLoad();

                this.profilesPage.clickAddNewProfileButton();
                this.addNewProfileModalPage.waitForPageLoad();

                this.addNewProfileModalPage.enterProfileFirstName(newFirstName);
                this.addNewProfileModalPage.enterProfileLastName(newLastName);
                this.addNewProfileModalPage.enterProfileMiddleIntialInput("P");
                this.addNewProfileModalPage.enterProfileBirthdayInput("18021992");
                this.addNewProfileModalPage.enterProfileEmailInput(newEmail);
                this.addNewProfileModalPage.clickToProfileLanguage();
                this.addNewProfileModalPage.enterProfileLanguage("English");
                this.addNewProfileModalPage.selectProfileGender("MALE");

                this.addNewProfileModalPage.clickProfileDetailsSaveButton();

                Assert.assertTrue(this.headerPage.getMainProfileInformation().contains(newEmail),
                                "Profile Email does not have expected text of " + newEmail);
        }

        @Test(description = "Test creating a profile with House program enrollment")
        public void testCreateProfileWithGuestProgramEnrollment() {
                String newFirstName = this.randomDataHelper.getRandomFirstName();
                String newLastName = this.randomDataHelper.getRandomLastName();
                String newEmail = this.randomDataHelper.getRandomEmailAddress(newFirstName, newLastName);

                this.profilesPage.get();
                this.profilesPage.waitForPageLoad();

                // Create a profile with no enrollment
                this.profilesPage.clickAddNewProfileButton();
                this.addNewProfileModalPage.waitForPageLoad();

                this.addNewProfileModalPage.enterProfileFirstName(newFirstName);
                this.addNewProfileModalPage.enterProfileLastName(newLastName);
                this.addNewProfileModalPage.enterProfileMiddleIntialInput("P");
                this.addNewProfileModalPage.enterProfileEmailInput(newEmail);
                this.addNewProfileModalPage.clickEnrollMembershipToggle();
                this.addNewProfileModalPage.clickToEnrollGuestPortalForProgram();
                this.addNewProfileModalPage.clickToAddGuestPortal();

                this.addNewProfileModalPage.clickProfileDetailsSaveButton();

                Assert.assertTrue(this.profilesPage.membershipActivationEmailHasBeenSentModalIsVisible(),
                                "Membership Activation Email dialog is not visible");

                this.profilesPage.clickMembershipActivationEmailHasBeenSentModalCloseButton();

                Assert.assertTrue(this.headerPage.getMainProfileInformation().contains(newEmail),
                                "Profile Email does not have expected text of " + newEmail);

                this.headerPage.clickProfileLoyaltyTab();
                this.loyaltyTabPage.waitForPageLoad();

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
}