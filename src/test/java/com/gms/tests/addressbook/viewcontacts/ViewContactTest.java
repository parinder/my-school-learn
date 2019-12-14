package com.gms.tests.addressbook.viewcontacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gms.pages.addressbook.ViewContactsPage;

public class ViewContactTest extends BaseContactViewTest {

        protected ViewContactsPage viewContactsPage;

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.viewContactsPage = new ViewContactsPage(this.driver, config);
                this.login(this.defaultUsername, this.defaultPassword); // login with default user
        }

        @Test(description = "Test search by all datasources with detailed records displaying email, first name, last name.")
        public void testSearchByAllDatasourcesDetailedRecords() {
                this.viewContactsPage.get();
                this.viewContactsPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas");

                Assert.assertFalse(this.viewContactsPage.searchCriteriaSelectIsEnabled(),
                                "Select Search Criteria dropdown should be disabled.");

                Assert.assertFalse(this.viewContactsPage.sortByDropdownIsEnabled(),
                                "Sort by dropdown should be disabled.");

                this.viewContactsPage.selectSearchBy("All Datasources");
                this.viewContactsPage.selectLevelOfDetail("Detailed Records");

                Assert.assertTrue(this.viewContactsPage.searchCriteriaSelectIsEnabled(),
                                "Select Search Criteria dropdown should be enabled.");

                Assert.assertTrue(this.viewContactsPage.sortByDropdownIsEnabled(),
                                "Sort by dropdown should be enabled.");

                this.selectDateRange("November", "5", "2019", "November", "5", "2019");

                this.viewContactsPage.selectSearchCriteriaSelectOption("Email");
                this.viewContactsPage.selectSearchCriteriaSelectOption("First Name");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Last Name");
                this.viewContactsPage.clickViewContactsButton();

                Assert.assertEquals(this.viewContactsPage.getContactListTableHeaderRowContents(0), "email",
                                "Contact List Table First column Header should be email");
                Assert.assertEquals(this.viewContactsPage.getContactListTableHeaderRowContents(1), "fname",
                                "Contact List Table First column Header should be fname");
                Assert.assertEquals(this.viewContactsPage.getContactListTableHeaderRowContents(2), "lname",
                                "Contact List Table First column Header should be lname");

                Assert.assertEquals(this.viewContactsPage.getContactListTableRowFirstColumnContents(1),
                                "house11@example.com",
                                "Email column First Row should have profile name house11@example.com");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowSecondColumnContents(1), "house11",
                                "Email column First Row should have profile name house11@example.com");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowThirdColumnContents(1), "house11",
                                "Email column First Row should have profile name house11@example.com");
        }

        @Test(description = "Test search by filter with detailed records displaying email")
        public void testSearchByFilterDetailedRecordsEmail() {
                this.viewContactsPage.get();
                this.viewContactsPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas");

                this.viewContactsPage.selectSearchBy("Domain : example.com");
                this.viewContactsPage.selectLevelOfDetail("Detailed Records");
                this.selectDateRange("November", "22", "2019", "November", "22", "2019");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Email");
                this.viewContactsPage.clickViewContactsButton();

                Assert.assertEquals(this.viewContactsPage.getContactListTableRowFirstColumnContents(1),
                                "amaya.feil.76613@example.com",
                                "Row 1 should have email 'amaya.feil.76613@example.com'");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowFirstColumnContents(2),
                                "stephania.purdy.22069@example.com",
                                "Row 2 should have email 'stephania.purdy.22069@example.com'");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowFirstColumnContents(3),
                                "donnell.corwin.63130@example.com",
                                "Row 3 should have email 'donnell.corwin.63130@example.com'");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowFirstColumnContents(4),
                                "maxie.bernier.52389@example.com",
                                "Row 4 should have email 'maxie.bernier.52389@example.com'");
        }

        @Test(description = "Verify Member ID, Points and Member Tier for profile having multiple house program memberships with same tier levels and different Points")
        public void testMemberIdPointsMemberTierForProfileHavingMultipleHouseProgramMembershipsWithDifferentPoints() {
                this.viewContactsPage.get();
                this.viewContactsPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas");

                this.viewContactsPage.selectSearchBy("Domain : TestViewContacts.com");
                this.viewContactsPage.selectLevelOfDetail("Detailed Records");
                this.selectDateRange("November", "22", "2019", "November", "22", "2019");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Email");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member ID");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Points");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member Tier");
                this.viewContactsPage.clickViewContactsButton();

                Assert.assertEquals(this.viewContactsPage.getContactListTableRowFirstColumnContents(1),
                                "automationOneProfile.automated@TestViewContacts.com",
                                "Email column First Row should have profile name automationOneProfile.automated@TestViewContacts.com");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowFirstColumnContents(2),
                                "automationOneProfile.automated@TestViewContacts.com",
                                "Email column Second Row should have profile name automationOneProfile.automated@TestViewContacts.com");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowSecondColumnContents(1),
                                "automationOneProfile.automated@TestViewContacts.co",
                                "Member ID column First Row should have Member ID automationOneProfile.automated@TestViewContacts.co");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowSecondColumnContents(2),
                                "automationTwoProfile.automated@TestViewContacts.co",
                                "Member ID colum Second Row should have Member ID automationTwoProfile.automated@TestViewContacts.co");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowThirdColumnContents(1), "100",
                                "Points column First Row should have 100 Points");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowThirdColumnContents(2), "50",
                                "Points column Second Row should have 50 Points");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowForthColumnContents(1), "Basic",
                                "Member Tier column First Row should have Basic Tier");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowForthColumnContents(2), "Basic",
                                "Member Tier column Second Row should have Basic Tier");
        }

        @Test(description = "Verify View contacts Sort By Member ID functioanlity")
        public void testViewContactsSortByMemberId() {
                this.viewContactsPage.get();
                this.viewContactsPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas"); // switch to canvas frame

                this.viewContactsPage.selectSearchBy("Domain : TestViewContacts.com");
                this.viewContactsPage.selectLevelOfDetail("Detailed Records");
                this.selectDateRange("November", "22", "2019", "November", "22", "2019");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Email");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member ID");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Points");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member Tier");
                this.viewContactsPage.selectSortBy("Member ID");
                this.viewContactsPage.clickViewContactsButton();

                Assert.assertEquals(this.viewContactsPage.getContactListTableRowSecondColumnContents(1),
                                "automationFourProfile.automated@TestViewContacts.c",
                                "After Sort By Member ID , Member ID column First Row should have Member ID automationFourProfile.automated@TestViewContacts.c");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowSecondColumnContents(2),
                                "automationOneProfile.automated@TestViewContacts.co",
                                "After Sort By Member ID , Member ID column Second Row should have Member ID automationOneProfile.automated@TestViewContacts.co");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowSecondColumnContents(3),
                                "automationThreeProfile.automated@TestViewContacts.",
                                "After Sort By Member ID , Member ID column Third Row should have Member ID automationThreeProfile.automated@TestViewContacts.");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowSecondColumnContents(4),
                                "automationTwoProfile.automated@TestViewContacts.co",
                                "After Sort By Member ID , Member ID column Forth Row should have Member ID automationTwoProfile.automated@TestViewContacts.co");
        }

        @Test(description = "Verify View contacts Sort By Points functioanlity")
        public void testViewContactsSortByPoints() {
                this.viewContactsPage.get();
                this.viewContactsPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas"); // switch to canvas frame

                this.viewContactsPage.selectSearchBy("Domain : TestViewContacts.com");
                this.viewContactsPage.selectLevelOfDetail("Detailed Records");
                this.selectDateRange("November", "22", "2019", "November", "22", "2019");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Email");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member ID");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Points");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member Tier");
                this.viewContactsPage.selectSortBy("Points");
                this.viewContactsPage.clickViewContactsButton();

                Assert.assertEquals(this.viewContactsPage.getContactListTableRowThirdColumnContents(1), "50",
                                "After Sort By Points , Points column First Row should have 50 Points");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowThirdColumnContents(2), "50",
                                "After Sort By Points , Points column Second Row should have 50 Points");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowThirdColumnContents(3), "50",
                                "After Sort By Points , Points column Third Row should have 50 Points");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowThirdColumnContents(4), "100",
                                "After Sort By Points , Points column Fourth Row should have 100 Points");
        }

        @Test(description = "Verify View contacts Sort By Member Tier functioanlity")
        public void testViewContactsSortByMemberTier() {
                this.viewContactsPage.get();
                this.viewContactsPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas"); // switch to canvas frame

                this.viewContactsPage.selectSearchBy("Domain : TestViewContacts.com");
                this.viewContactsPage.selectLevelOfDetail("Detailed Records");
                this.selectDateRange("November", "22", "2019", "November", "22", "2019");

                this.viewContactsPage.selectSearchCriteriaSelectOption("Email");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member ID");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Points");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member Tier");
                this.viewContactsPage.selectSortBy("Member Tier");
                this.viewContactsPage.clickViewContactsButton();

                Assert.assertEquals(this.viewContactsPage.getContactListTableRowForthColumnContents(1), "Basic",
                                "After Sort By Member Tier , Member Tier column First Row should have Basic Tier");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowForthColumnContents(2), "Basic",
                                "After Sort By PoinMember Tierts , Member Tier column Second Row should have Basic Tier");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowForthColumnContents(3), "Basic",
                                "After Sort By Member Tier , Member Tier column Third Row should have Basic Tier");
                Assert.assertEquals(this.viewContactsPage.getContactListTableRowForthColumnContents(4), "Silver",
                                "After Sort By Member Tier , Member Tier column Fourth Row should have Silver Tier");
        }

        @Test(description = "Verify Member ID, Points and Member Tier of non house program membership profile are not getting displayed on Contact List table.")
        public void testMemberIdPointsMemberTierForNonHouseProgramMembershipProfileNotDisplayed() {
                this.viewContactsPage.get();
                this.viewContactsPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas"); // switch to canvas frame

                this.viewContactsPage.selectSearchBy("Domain : TestViewContacts.com");
                this.viewContactsPage.selectLevelOfDetail("Detailed Records");
                this.selectDateRange("November", "22", "2019", "November", "22", "2019");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Email");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member ID");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Points");
                this.viewContactsPage.selectSearchCriteriaSelectOption("Member Tier");
                this.viewContactsPage.clickViewContactsButton();

                Assert.assertTrue(
                                this.viewContactsPage.nonHouseProgramMemberIdIsNotPresentInContactListTable(
                                                "NonHouse@TestViewContacts.com"),
                                "Non House Program Member Id Should not be displayed in Contact List Table.");
        }
}