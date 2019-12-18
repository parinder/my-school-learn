package com.myschool.learn.gms.tests.smoke;

import com.myschool.learn.gms.pages.addressbook.*;
import com.myschool.learn.gms.pages.profiles.MergeProfilePage;
import com.myschool.learn.gms.pages.profiles.ProfilesPage;
import com.myschool.learn.gms.pages.profiles.profile.HeaderPage;
import com.myschool.learn.gms.pages.profiles.profile.MessengerTabPage;
import com.myschool.learn.gms.pages.profiles.profile.OverviewTabPage;
import com.myschool.learn.gms.pages.rezqueue.RezqueueMessengerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddressBookSmokeTest extends BaseSmokeTest{
    protected NavigationBarPage addressBookNavigationBarPage;
    protected FiltersListPage filtersListPage;
    protected FiltersHomePage filtersHomePage;
    protected NewFilterPage newFilterPage;
    protected EditFilterPage editFilterPage;

    protected PostalContactsPage postalContactsPage;
    protected DataUploadPage dataUploadPage;
    protected DataDownloadPage dataDownloadPage;
    protected ViewContactsPage viewContactsPage;
    protected AddEditDatasourcePage addEditDatasourcePage;
    protected AddEditCustomFieldsPage addEditCustomFieldsPage;
    protected EditMembershipProgramsPage editMembershipProgramsPage;
    protected DeduplicationRulesPage deduplicationRulesPage;
    protected ManualMergePage manualMergePage;  
    protected AddEditTagsPage addEditTagsPage;  
    protected AutoPurgeConfigurationPage autoPurgeConfigurationPage;    
    protected ProfileCompletenessSetupPage profileCompletenessSetupPage;
    protected GuestPortalsPage guestPortalsPage;
    protected LoyaltyDashboardPage loyaltyDashboardPage;
    protected OBWSetupPage oBWSetupPage;
        
    protected ProfilesPage profilesPage;
    protected OverviewTabPage overviewTabPage;
    protected HeaderPage headerPage;
    protected MergeProfilePage mergeProfilePage;
    protected MessengerTabPage messengerTabPage;
    protected RezqueueMessengerPage rezqueueMessengerPage;    
    
    @BeforeClass
    public void setup() throws IOException {
            super.setup();
            this.addressBookNavigationBarPage = new NavigationBarPage(this.driver, config);
            this.filtersListPage = new FiltersListPage(this.driver, config);
            this.filtersHomePage = new FiltersHomePage(this.driver, config);
            this.newFilterPage = new NewFilterPage(this.driver, config);
            this.editFilterPage = new EditFilterPage(this.driver, config);

            this.postalContactsPage = new PostalContactsPage(this.driver, config);
            this.dataUploadPage = new DataUploadPage(this.driver, config);
            this.dataDownloadPage = new DataDownloadPage(this.driver, config);
            this.viewContactsPage = new ViewContactsPage(this.driver, config);
            this.addEditDatasourcePage = new AddEditDatasourcePage(this.driver, config);
            this.addEditCustomFieldsPage = new AddEditCustomFieldsPage(this.driver, config);
            this.editMembershipProgramsPage = new EditMembershipProgramsPage(this.driver, config);
            this.deduplicationRulesPage = new DeduplicationRulesPage(this.driver, config);
            this.manualMergePage = new ManualMergePage(this.driver, config);
            this.addEditTagsPage = new AddEditTagsPage(this.driver, config);
            this.autoPurgeConfigurationPage = new AutoPurgeConfigurationPage(this.driver, config);
            this.profileCompletenessSetupPage = new ProfileCompletenessSetupPage(this.driver, config);
            this.guestPortalsPage = new GuestPortalsPage(this.driver, config);
            this.loyaltyDashboardPage = new LoyaltyDashboardPage(this.driver, config);
            this.oBWSetupPage = new OBWSetupPage(this.driver, config);
            
            this.profilesPage = new ProfilesPage(this.driver, config);
            this.overviewTabPage = new OverviewTabPage(this.driver, config);
            this.headerPage = new HeaderPage(this.driver, config);
            this.mergeProfilePage = new MergeProfilePage(this.driver, config);
            this.messengerTabPage = new MessengerTabPage(this.driver, config);
            this.rezqueueMessengerPage = new RezqueueMessengerPage(this.driver, config);
    }
    
    // filter section
    
    @Test(description = "Test filter home page")
    public void testFiltersHomePage() {
            this.filtersHomePage.get();
            this.filtersHomePage.waitForPageLoad();
            Assert.assertTrue(this.filtersHomePage.filtersUserDirectionsIsVisible(),
                            "Filters User Directions should be visible on filters Home Page.");
    }
    
    @Test(description = "Test filter list page")
    public void testFiltersListPage() {
            this.filtersHomePage.get();
            this.filtersListPage.waitForPageLoad();
            Assert.assertTrue(this.filtersListPage.filtersSearchInputIsVisible(),
                            "Filters seach input should be visible on filters list Page.");
    }
    
    @Test(description = "Test add new filter page")
    public void testNewFilterPage() {
            this.filtersHomePage.get();
            this.filtersHomePage.waitForPageLoad();

            this.addressBookNavigationBarPage.clickAddNewFilterButton();
            this.driver.switchTo().frame("canvas");
            this.newFilterPage.waitForPageLoad();
                       
            Assert.assertTrue(this.newFilterPage.availableFieldsListIsVisible(),
                            "Available Fields Lable should be visible on new filter Page.");
    }
    
    @Test(description = "Test edit filter page")
    public void testEditFilterPage() {
            this.filtersHomePage.get();
            this.filtersHomePage.waitForPageLoad();

            this.addressBookNavigationBarPage.clickAddNewFilterButton();
            this.driver.switchTo().frame("canvas");
            this.newFilterPage.waitForPageLoad();
            
            this.newFilterPage.clickcitySelectOption();
            this.newFilterPage.clickSelectFieldsButton();
            this.editFilterPage.waitForPageLoad();
            Assert.assertTrue(this.editFilterPage.saveFilterButtonIsVisible(),
                            "Save Filter button should be visible on edit filter Page.");
    }

    // file menu section
    
    @Test(description = "Test postal contacts page")
    public void testPostalContactsPage() {
            this.postalContactsPage.get();
            this.postalContactsPage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertTrue(this.postalContactsPage.createPostalMailingListLableIsVisible(),
                            "Create Postal Mailing List Lable should be visible on postal contacts Page.");
            Assert.assertTrue(this.postalContactsPage.createListButtonIconIsVisible(),
                            "Create List button should be visible on postal contact Page.");
            Assert.assertTrue(this.postalContactsPage.selectSearchCriteriaLableIsVisible(),
                            "Select Search Criteria Label should be visible on postal contact Page.");
    }
    
    @Test(description = "Test data upload page")
    public void testDataUploadPage() {
            String ListOwnerName = "QA Team - AUTOMATED Tests (DO NOT TOUCH)";
            this.dataUploadPage.get();
            this.dataUploadPage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertEquals(this.dataUploadPage.getHeaderTitleText(), "Upload Contacts to: " + ListOwnerName,
                                "Title should be 'Upload Contacts to: " + ListOwnerName + ""); // assert list owner name in title
            Assert.assertTrue(this.dataUploadPage.uploadFileLableIsVisible(),
                            "Upload File Lable should be visible on data upload Page.");
            Assert.assertTrue(this.dataUploadPage.uploadDataButtonIconIsVisible(),
                            "Upload Data button should be visible on data upload Page.");
            Assert.assertTrue(this.dataUploadPage.availableFieldsLableIsVisible(),
                            "Available Fields Lable should be visible on data upload Page.");
            Assert.assertTrue(this.dataUploadPage.uploadFileFormatLableLableIsVisible(),
                            "Upload File Format Lable should be visible on data upload Page.");
    }
    
    @Test(description = "Test data download page")
    public void testDataDownloadPage() {
            this.dataDownloadPage.get();
            this.dataDownloadPage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertTrue(this.dataDownloadPage.downloadListLableIsVisible(),
                            "Download List Lable should be visible on data download Page.");
            Assert.assertTrue(this.dataDownloadPage.downloadListButtonIconIsVisible(),
                            "Download List button should be visible on data download Page.");
    }
    
    @Test(description = "Test view contacts page")
    public void testViewContactsPage() {
            this.viewContactsPage.get();
            this.viewContactsPage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertTrue(this.viewContactsPage.viewContactsLabelIsVisible(),
                            "View contacts Lable should be visible on view contacts page.");
            Assert.assertFalse(this.viewContactsPage.searchCriteriaSelectIsEnabled(),
                            "Select Search Criteria dropdown should be disabled on view contacts page.");
            Assert.assertTrue(this.viewContactsPage.viewContactsButtonIsVisible(),
                            "View Contacts button should be visible on view contacts page.");
            Assert.assertTrue(this.viewContactsPage.searchCriteriaSelectLabelIsVisible(),
                            "Select Search Criteria Lable should be visible on view contacts page.");
    }
    
    @Test(description = "Test add edit datasource page")
    public void testAddEditDatasourcePage() {
            this.addEditDatasourcePage.get();
            this.addEditDatasourcePage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertTrue(this.addEditDatasourcePage.addNewDatasourceLableIsVisible(),
                            "Add New Datasource Lable should be visible on add edit datasource Page.");
            Assert.assertTrue(this.addEditDatasourcePage.addButtonIconIsVisible(),
                            "Add button should be visible on add edit datasource Page.");
            Assert.assertTrue(this.addEditDatasourcePage.categoriesLableIsVisible(),
                            "Categories Lable should be visible on add edit datasource Page.");
    }
    
    @Test(description = "Test add edit custom fields page")
    public void testAddEditCustomFieldsPage() {
            this.addEditCustomFieldsPage.get();
            this.addEditCustomFieldsPage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertTrue(this.addEditCustomFieldsPage.addNewCustomFieldLableIsVisible(),
                            "Add Edit Custom Field lable should be visible on Add Edit Custom Fields Page.");
            Assert.assertTrue(this.addEditCustomFieldsPage.newCustomFieldInputIsVisible(),
                            "New Custom field Input should be visible on Add Edit Custom Fields Page.");
            Assert.assertTrue(this.addEditCustomFieldsPage.addFieldButtonIconIsVisible(),
                            "Add Field Input should be visible on Add Edit Custom Fields Page.");
            Assert.assertTrue(this.addEditCustomFieldsPage.existingFieldsLableIsVisible(),
                            "Existing Fields lable should be visible on Add Edit Custom Fields Page.");
    }
    
    @Test(description = "Test edit membership programs page")
    public void testEditMembershipProgramsPage() {
            this.editMembershipProgramsPage.get();
            this.editMembershipProgramsPage.waitForPageLoad();
            Assert.assertTrue(this.editMembershipProgramsPage.editMembershipProgramsTitleIsVisible(),
                            "Edit Membership Programs title should be visible on Edit Membership Programs Page.");
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertTrue(this.editMembershipProgramsPage.addProgramButtonIsVisible(),
                            "Add Program button should be visible on Edit Membership Programs Page.");
            Assert.assertTrue(this.editMembershipProgramsPage.guestPortalProgramIsVisible(),
                            "Guest Portal Program name should be visible on Edit Membership Programs Page.");
    }
    
    @Test(description = "Test deduplication rules page")
    public void testDeduplicationRulesPage() {
            String ListOwnerName = "QA Team - AUTOMATED Tests (DO NOT TOUCH)";
            this.deduplicationRulesPage.get();
            this.deduplicationRulesPage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertEquals(this.deduplicationRulesPage.getHeaderTitleText(), "Deduplication Rules for " + ListOwnerName,
                            "Title should be 'Deduplication Rules for " + ListOwnerName + ""); // assert list owner name in title
            Assert.assertTrue(this.deduplicationRulesPage.editDeduplicationSettingsLinkIsVisible(),
                            "Edit Deduplication Settings Link should be visible on Dedulication Rules Page.");
    }
        
    @Test(description = "Test manual merge page")
    public void testManualMergePage() {
            String ListOwnerName = "QA Team - AUTOMATED Tests (DO NOT TOUCH)";
            this.manualMergePage.get();
            this.manualMergePage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertEquals(this.manualMergePage.getHeaderTitleText(), "Choose Merging Candidate for " + ListOwnerName,
                                "Title should be Choose Merging Candidate for " + ListOwnerName + ""); // assert list owner name in title
            Assert.assertTrue(this.manualMergePage.rezqueueMergeCandidatesButtonIsVisible(),
                            "Rezqueue Merge Candidates Button should be visible on Manual Merge Page.");
    }
    
    @Test(description = "Test add edit tags page")
    public void testAddEditTagsPage() {
            this.addEditTagsPage.get();
            this.addEditTagsPage.waitForPageLoad();
            this.driver.switchTo().frame("canvas"); // switch to canvas frame
            Assert.assertTrue(this.addEditTagsPage.addNewTagLableIsVisible(),
                            "Add a New Tag Lable should be visible on Add Edit Tags Page.");
            Assert.assertTrue(this.addEditTagsPage.newTagNameInputIsVisible(),
                            "New Tag Name Input should be visible on Add Edit Tags Page.");
            Assert.assertTrue(this.addEditTagsPage.editExistingTagsLableIsVisible(),
                            "Edit Existing Tags Lable should be visible on Add Edit Tags Page.");
    }
    
    @Test(description = "Test auto purge configuration page")
    public void testAutoPurgeConfigurationPage() {
            this.autoPurgeConfigurationPage.get();
            this.autoPurgeConfigurationPage.waitForPageLoad();
            Assert.assertTrue(this.autoPurgeConfigurationPage.autoPurgeConfigurationTitleIsVisible(),
                            "Auto Purge Configuration title should be visible on Auto Purge Configuration Page.");
            Assert.assertTrue(this.autoPurgeConfigurationPage.purgeOptionsLableIsVisible(),
                            "Purge Options Lable should be visible on Auto Purge Configuration Page.");
            Assert.assertTrue(this.autoPurgeConfigurationPage.dataToPurgeLableIsVisible(),
                            "Data To Purge Configuration title should be visible on Auto Purge Configuration Page.");
            Assert.assertTrue(this.autoPurgeConfigurationPage.saveButtonIsVisible(),
                             "Save button should be visible on Auto Purge Configuration Page.");
    }
    
    @Test(description = "Test profile completeness setup page")
    public void testProfileCompletenessSetupPage() {
            this.profileCompletenessSetupPage.get();
            this.profileCompletenessSetupPage.waitForPageLoad();
            Assert.assertTrue(this.profileCompletenessSetupPage.profileCompletenessSetupLinkIsVisible(),
                            "Profile Completeness Setup Link should be visible on profile completeness setup Page.");
            Assert.assertTrue(this.profileCompletenessSetupPage.addCategoryLinkIsVisible(),
                             "Add Category Link should be visible on profile completeness setup Page.");
    }

    @Test(description = "Test guest portals page")
    public void testGuestPortalsPage() {
        this.guestPortalsPage.get();
        this.guestPortalsPage.waitForPageLoad();
        Assert.assertTrue(this.guestPortalsPage.guestPortalsTitleIsVisible(),
                        "Guest Portals title should be visible on guest portals Page.");
        Assert.assertTrue(this.guestPortalsPage.createNewPortalButtonIconIsVisible(),
                        "Create New Portal button should be visible on guest portals Page.");
    }
    
    @Test(description = "Test loyalty dashboard page")
    public void testLoyaltyDashboardPage() {
        this.loyaltyDashboardPage.get();
        this.loyaltyDashboardPage.waitForPageLoad();
        Assert.assertTrue(this.loyaltyDashboardPage.membershipProgramsTitleIsVisible(),
                        "Membeship Programs title should be visible on Loyalty Dashboard page.");
        Assert.assertTrue(this.loyaltyDashboardPage.programsListContainerIsVisible(),
                        "Programs list container should be visible on Loyalty Dashboard page.");
    }

    @Test(description = "Test OBW setup page")
    public void testOBWSetupPage() {
        this.oBWSetupPage.get();
        this.oBWSetupPage.waitForPageLoad();
        this.driver.switchTo().frame("canvas"); // switch to canvas frame
        Assert.assertTrue(this.oBWSetupPage.bookingWizardsConfigurationLableIsVisible(),
                        "Booking Wizard Label should be visible on OBW Setup page.");
        Assert.assertTrue(this.oBWSetupPage.addEditBookingWizardLableLableIsVisible(),
                        "Add Edit Booking Wizard Label should be visible on OBW Setup page.");
        Assert.assertTrue(this.oBWSetupPage.selectResourcesLableIsVisible(),
                        "Select Resource Label should be visible on OBW Setup page.");
        
        Assert.assertTrue(this.oBWSetupPage.addSavePackageButtonIconIsVisible(),
                          "add save package button should be visible on OBW Setup page.");
    }
    
    // profiles section
    
    @Test(description = "Test profiles page")
    public void testProfilesPage() {
        this.profilesPage.get();
        this.profilesPage.waitForPageLoad();
        Assert.assertTrue(this.profilesPage.addNewProfileButtonIsVisible(),
                         "Add New Profile button should be visible on profiles page.");
    }
    
    @Test(description = "Test merge profile page")
    public void testMergeProfilePage() {
        String email = "testy.mctesterson@example.com";
        String ListOwnerName = "QA Team - AUTOMATED Tests (DO NOT TOUCH)";
        
        this.profilesPage.get();
        this.profilesPage.waitForPageLoad();

        this.profilesPage.enterProfileSearchEmail(email); // search email
        this.profilesPage.clickProfileSearchButton();

        this.overviewTabPage.waitForPageLoad();
        this.headerPage.clickMergeProfileLink();
        this.profilesPage.switchToNewWindow();
        
        this.mergeProfilePage.waitForPageLoad();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/manualmergecontroller.spr?"),
                          "URL should contain /manualmergecontroller.spr?"); // assert new page link
        Assert.assertEquals(this.mergeProfilePage.getHeaderTitleText(), "Potential Matches for " + ListOwnerName,
                          "Title should be 'Potential Matches for " + ListOwnerName + ""); // assert list owner name in title       
        Assert.assertTrue(this.mergeProfilePage.selectAllButtonIsVisible(),
                          "Select All button should be visible on merge profile page.");
        
        this.driver.close(); // close the second window
        this.profilesPage.switchToNewWindow(); // switch back to original window
    }
    
}

