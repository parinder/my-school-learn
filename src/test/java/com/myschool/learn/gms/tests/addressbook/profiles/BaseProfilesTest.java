package com.myschool.learn.gms.tests.addressbook.profiles;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.myschool.learn.gms.helpers.RandomDataHelper;
import com.myschool.learn.gms.pages.addressbook.FiltersHomePage;
import com.myschool.learn.gms.pages.addressbook.FiltersListPage;
import com.myschool.learn.gms.pages.addressbook.NavigationBarPage;
import com.myschool.learn.gms.pages.profiles.AddNewProfileModalPage;
import com.myschool.learn.gms.pages.profiles.ProfilesPage;
import com.myschool.learn.gms.pages.profiles.profile.ConsentModalPage;
import com.myschool.learn.gms.pages.profiles.profile.DetailsTabPage;
import com.myschool.learn.gms.pages.profiles.profile.HeaderPage;
import com.myschool.learn.gms.pages.profiles.profile.LoyaltyTabPage;
import com.myschool.learn.gms.pages.profiles.profile.OverviewTabPage;
import com.myschool.learn.gms.pages.profiles.profile.ReservationsTabPage;
import com.myschool.learn.gms.pages.rezqueue.RezqueueMessengerPage;
import com.myschool.learn.gms.tests.BaseFunctionalTest;

public class BaseProfilesTest extends BaseFunctionalTest {

        protected RandomDataHelper randomDataHelper;

        protected NavigationBarPage addressBookNavigationBarPage;
        protected FiltersHomePage filtersHomePage;
        protected ProfilesPage profilesPage;
        protected HeaderPage headerPage;
        protected ConsentModalPage consentModalPage;

        protected OverviewTabPage overviewTabPage;
        protected DetailsTabPage detailsTabPage;
        protected ReservationsTabPage reservationsTabPage;
        protected LoyaltyTabPage loyaltyTabPage;
        protected AddNewProfileModalPage addNewProfileModalPage;
        protected FiltersListPage filtersListPage;

        protected RezqueueMessengerPage rezqueueMessengerPage;
        // protected String newEmail;

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.randomDataHelper = new RandomDataHelper();
                this.profilesPage = new ProfilesPage(this.driver, config);
                this.overviewTabPage = new OverviewTabPage(this.driver, config);
                this.detailsTabPage = new DetailsTabPage(this.driver, config);
                this.reservationsTabPage = new ReservationsTabPage(this.driver, config);
                this.loyaltyTabPage = new LoyaltyTabPage(this.driver, config);
                this.headerPage = new HeaderPage(this.driver, config);
                this.consentModalPage = new ConsentModalPage(this.driver, config);
                this.addNewProfileModalPage = new AddNewProfileModalPage(this.driver, config);
                this.addressBookNavigationBarPage = new NavigationBarPage(this.driver, config);
                this.filtersHomePage = new FiltersHomePage(this.driver, config);
                this.rezqueueMessengerPage = new RezqueueMessengerPage(this.driver, config);
                this.filtersListPage = new FiltersListPage(this.driver, config);
        }

        public void goToProfile(String email) {
                this.profilesPage.get();
                this.profilesPage.waitForPageLoad();
                this.profilesPage.enterProfileSearchEmail(email);
                this.profilesPage.clickProfileSearchButton();
                this.overviewTabPage.waitForPageLoad();
        }

        public void goToProfileLoyaltyTab(String memberEmail, String memberProgram) {
                this.profilesPage.get();
                this.profilesPage.waitForPageLoad();

                // click Loyalty and assert only Loyalty is visible
                this.profilesPage.clickLoyaltySearchExpandMenu();
                this.profilesPage.waitForLoyaltySearchSectionToBeOpen();

                // search Profile by Loyalty Search & Navigate to Loyalty Tab
                this.profilesPage.enterLoyaltySearchMemberNumber(memberEmail);
                this.profilesPage.selectAndEnterProgram(memberProgram);
                this.profilesPage.clickLoyaltySearchButton();

                this.loyaltyTabPage.waitForPageLoad();
                Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberNumber(), memberEmail,
                                "Member number should be '" + memberEmail + "'.");
        }

        public void assertPointsHistoryTableRow(Integer index, String points, String eventType, String reason,
                        String date, String user, String reservationNumber, String property, String nights,
                        String dollarSpent) {
                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTablePoints(index), points,
                                "Points should be '" + points + "'.");

                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableEventType(index), eventType,
                                "Event type should be '" + eventType + "'.");

                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableReason(index), reason,
                                "Reason type should be '" + reason + "'.");

                if (date != null) {
                        Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableDate(index), date,
                                        "Date type should be '" + date + "'.");
                }

                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableUserName(index), user,
                                "User should be '" + user + "'.");
                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableReservationNumber(index),
                                reservationNumber, "Reservation number should be '" + reservationNumber + "'.");
                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableProperty(index), property,
                                "Property should be '" + property + "'.");
                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableNights(index), nights,
                                "Nights should be '" + nights + "'.");
                Assert.assertEquals(this.loyaltyTabPage.getPointsHistoryTableDollarSpent(index), dollarSpent,
                                "Dollar Spent should be '" + dollarSpent + "'.");
        }

        public void profileTierReassign(String currentTier, String switchToTier, Boolean notifyMemberLevelChange,
                        Boolean makePermanent) {

                this.loyaltyTabPage.clickReassignTierButtonButton();
                this.loyaltyTabPage.waitForReassignTierModalToBeVisible();
                Assert.assertTrue(
                                this.loyaltyTabPage.reassignTierModalNotifyMemberOfLevelChangeCheckboxLabelIsDisabled(),
                                "Notify Member of Level Change label should be disabled.");
                this.loyaltyTabPage.selectProfileTierViaSearch(switchToTier);
                Assert.assertFalse(
                                this.loyaltyTabPage.reassignTierModalNotifyMemberOfLevelChangeCheckboxLabelIsDisabled(),
                                "Notify Member of Level Change label should be enabled.");
                if (notifyMemberLevelChange) {
                        this.loyaltyTabPage.clickReassignTierModalNotifyMemberOfLevelChangeCheckbox();
                }
                if (makePermanent) {
                        this.loyaltyTabPage.clickReassignTierModalMakePermanentCheckbox();
                }

                this.loyaltyTabPage.clickReassignTierModalSaveButton();

                this.loyaltyTabPage.waitForReassignTierConfirmationModalToBeVisible();

                this.loyaltyTabPage.clickReassignTierConfirmationModalYesButton();

                this.loyaltyTabPage.waitForToastToBeVisible();

                Assert.assertEquals(this.loyaltyTabPage.getToastMessageText(), "Saved",
                                "Toast message should be 'Saved'.");

                this.loyaltyTabPage.clickToastCloseButton();

                this.loyaltyTabPage.waitForReassignTierModalToBeInvisible();
        }

        public void pointsRedeemOrAwardByManualPointChange(String managePointsType, String points, String nights,
                        String eventType, String reason) {
                this.loyaltyTabPage.selectManagePointsType(managePointsType);
                this.loyaltyTabPage.enterPointsForAwardOrRedeem(points);
                this.loyaltyTabPage.enterNumberOfNights(nights);
                this.loyaltyTabPage.clickManagePointsOrNightsApplyTowardsLevelOfProgressCheckbox();
                this.loyaltyTabPage.selectChangeType(eventType);
                this.loyaltyTabPage.enterReasonForAwardOrRedeemPoints(reason);
                this.loyaltyTabPage.clickPointsApplyButton();

                Assert.assertTrue(
                                this.loyaltyTabPage.getPointsAppliedSuccessMessage()
                                                .contains("Success The points were applied"),
                                "Message should be 'Success The points were applied'");
        }

        public void createNewProfile(String firstName, String lastName, String middleInitial, String email,
                        String cityName) {
                this.profilesPage.get();
                this.profilesPage.waitForPageLoad();
                this.profilesPage.clickAddNewProfileButton();
                this.addNewProfileModalPage.waitForPageLoad();
                this.addNewProfileModalPage.enterProfileFirstName(firstName);
                this.addNewProfileModalPage.enterProfileLastName(lastName);
                this.addNewProfileModalPage.enterProfileMiddleIntialInput(middleInitial);
                this.addNewProfileModalPage.enterProfileEmailInput(email);
                this.addNewProfileModalPage.clickToOpenProfileAdditionalFields();
                this.addNewProfileModalPage.enterProfileCity(cityName);
                this.addNewProfileModalPage.clickProfileDetailsSaveButton();
                Assert.assertTrue(this.headerPage.getMainProfileInformation().contains(email),
                                "Profile Email does not have expected text of 'newEmail'");
        }

        public void enrollProfileInHouseProgram(String email, String programToEnroll, String guestPortalToEnrollIn) {
                this.goToProfile(email);
                this.headerPage.clickProfileLoyaltyTab();
                this.loyaltyTabPage.waitForPageLoad();
                this.loyaltyTabPage.clickEnrollNewProgramButton();
                this.loyaltyTabPage.waitForEnrollNewProgramModalToBeVisible();
                Assert.assertEquals(this.loyaltyTabPage.getEnrollNewProgramModalMemberNumber(), email,
                                "Enroll new program modal member number should default to: '" + email + "'.");
                this.loyaltyTabPage.clickEnrollNewProgramModalProgramToEnrollDropdown();
                this.loyaltyTabPage.enterEnrollNewProgramModalProgramToEnrollSearch(programToEnroll);
                this.loyaltyTabPage.clickEnrollNewProgramModalGuestPortalToEnrollInDropdown();
                this.loyaltyTabPage.enterEnrollNewProgramModalGuestPortalToEnrollInSearch(guestPortalToEnrollIn);
                this.loyaltyTabPage.clickEnrollNewProgramModalSaveButton();
                this.loyaltyTabPage.clickMembershipActivationEmailSentSaveButton();
                Assert.assertTrue(this.loyaltyTabPage.loyaltymembershipPointsCardIsVisible(),
                                "Membership card is not visible");
        }

        public void enrollProfileInNonHouseProgram(String email, String programToEnroll) {
                this.goToProfile(email);
                this.headerPage.clickProfileLoyaltyTab();
                this.loyaltyTabPage.waitForPageLoad();
                this.loyaltyTabPage.clickEnrollNewProgramButton();
                this.loyaltyTabPage.waitForEnrollNewProgramModalToBeVisible();
                Assert.assertEquals(this.loyaltyTabPage.getEnrollNewProgramModalMemberNumber(), email,
                                "Enroll new program modal member number should default to: '" + email + "'.");
                this.loyaltyTabPage.clickEnrollNewProgramModalProgramToEnrollDropdown();
                this.loyaltyTabPage.enterEnrollNewProgramModalProgramToEnrollSearch(programToEnroll);
                this.loyaltyTabPage.clickEnrollNewProgramModalSaveButton();
                Assert.assertTrue(this.loyaltyTabPage.loyaltymembershipPointsCardIsVisible(),
                                "Membership card is not visible");
        }

        public void mergeMembership(String emailToMergeInto, String emailToBeMerged,
                        Integer profileToMergeIntoLoyaltyPoints, Integer profileToBeMergedLoyaltyPoints,
                        boolean deleteMemberAfterMerge) {

                this.goToProfile(emailToBeMerged);
                this.headerPage.clickProfileLoyaltyTab();
                this.loyaltyTabPage.waitForPageLoad();

                this.loyaltyTabPage.clickMergeMembershipButton();
                this.loyaltyTabPage.waitForMergeMembershipModalToBeVisible();
                this.loyaltyTabPage.enterMemberNumber(emailToMergeInto);
                if (deleteMemberAfterMerge) {
                        this.loyaltyTabPage.clickDeleteMemberAfterMergeCheckbox();
                }
                this.loyaltyTabPage.clickFindMemberButton();
                this.loyaltyTabPage.waitForConfirmMergeModalToBeVisible();
                Assert.assertEquals(this.loyaltyTabPage.getMergingIntoMessage(),
                                "Merging [" + emailToBeMerged + "] into [" + emailToMergeInto + "]",
                                "Merging Message should be : '" + this.loyaltyTabPage.getMergingIntoMessage() + "'.");
                Assert.assertEquals(this.loyaltyTabPage.getMergeSummaryTableMergedProfilePoints(), "0",
                                "Profile Points should be 0 after Merge");
                Assert.assertEquals(this.loyaltyTabPage.getMergeSummaryTableMergedProfileYtdPoints(), "0",
                                "Profile YTD Points should be 0 after Merge");
                Assert.assertEquals(this.loyaltyTabPage.getMergeSummaryTableMergedProfileStaysCount(), "0",
                                "Profile stays should be 0 after Merge");
                Assert.assertEquals(this.loyaltyTabPage.getMergeSummaryTableMergedProfileNightsCount(), "0",
                                "Profile Nights should be 0 after Merge");

                int actualTotalPoints = Integer
                                .parseInt(this.loyaltyTabPage.getMergeSummaryTableMergedIntoProfilePoints());
                int expectedTotalPoints = profileToMergeIntoLoyaltyPoints + profileToBeMergedLoyaltyPoints;
                Assert.assertEquals(actualTotalPoints, expectedTotalPoints,
                                "Total points should be: " + expectedTotalPoints + ".");
                this.loyaltyTabPage.clickConfirmMergeModalMergeButton();

                if (deleteMemberAfterMerge) {
                        this.overviewTabPage.waitForPageLoad();// profile defaults to overview because no loyalty
                } else {
                        this.loyaltyTabPage.waitForPageLoad(); // profile is still on loyalty tab
                }
        }

        public void profileOptedIn(String email) {
                this.profilesPage.get();
                this.profilesPage.waitForPageLoad();

                this.profilesPage.enterProfileSearchEmail(email);
                this.profilesPage.clickProfileSearchButton();
                this.overviewTabPage.waitForPageLoad();

                Assert.assertTrue(this.headerPage.optedOutLinkIsVisible(),
                                "Profile should have opted-out status before attempting to make opted-in on profile header.");

                this.headerPage.clickOptedOutLink();

                this.consentModalPage.waitForConsentModalToBeVisible();

                Assert.assertTrue(this.consentModalPage.consentModalOptedOutLinkIsVisible(),
                                "Profile email consent status should be opted-out before attempting to make opted-in on Consent dialog.");

                this.consentModalPage.clickConsentModalOptedOutLink();
                this.consentModalPage.clickConfirmModalSaveButton();
                this.consentModalPage.waitForConfirmModalToBeInvisible();
                this.consentModalPage.waitForConsentModalToBeVisible();
                this.consentModalPage.waitForConsentModalOptedOutLinkToBeInVisible();

                Assert.assertTrue(this.consentModalPage.consentModalOptedInLinkIsVisible(),
                                "Profile email consent status should changed to opted-in on Consent dialog after profile opted-out.");

                this.consentModalPage.clickConsentModalHeaderXButton();

                this.consentModalPage.waitForConsentModalToBeInvisible();

                Assert.assertTrue(this.headerPage.optedInLinkIsVisible(),
                                "Profile consent status should changed to opted-in after profile opted-out.");
        }
}