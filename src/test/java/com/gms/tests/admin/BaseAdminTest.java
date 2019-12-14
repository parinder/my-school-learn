package com.gms.tests.admin;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.gms.helpers.RandomDataHelper;
import com.gms.pages.admin.ManageUsersPage;
import com.gms.pages.admin.ManageUsersRoleModalPage;
import com.gms.pages.admin.ManageUsersUserModalPage;
import com.gms.tests.BaseFunctionalTest;

public class BaseAdminTest extends BaseFunctionalTest {
        protected RandomDataHelper randomDataHelper;
        protected ManageUsersPage manageUsersPage;
        protected ManageUsersRoleModalPage manageUsersRoleModalPage;
        protected ManageUsersUserModalPage manageUsersUserModalPage;

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.randomDataHelper = new RandomDataHelper();
                this.manageUsersPage = new ManageUsersPage(this.driver, this.config);
                this.manageUsersRoleModalPage = new ManageUsersRoleModalPage(this.driver, this.config);
                this.manageUsersUserModalPage = new ManageUsersUserModalPage(this.driver, this.config);
        }

        public void createNewUser(String newUserName, String password, String emailAddress, String firstName,
                        String lastName, String middleName, String language, String role) {
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

                this.manageUsersPage.clickNewUserButton();
                this.manageUsersUserModalPage.waitToBeVisible();

                this.manageUsersUserModalPage.enterUserName(newUserName);
                this.manageUsersUserModalPage.enterPassword(password);
                this.manageUsersUserModalPage.enterEmailAddress(emailAddress);
                this.manageUsersUserModalPage.enterFirstName(firstName);
                this.manageUsersUserModalPage.enterLastName(lastName);
                this.manageUsersUserModalPage.enterMiddleName(middleName);
                this.manageUsersUserModalPage.selectLanguage(language);

                this.manageUsersUserModalPage.clickRoleTab();
                this.manageUsersUserModalPage.waitForRoleTabToBeVisible();
                this.manageUsersUserModalPage.enterRolesTableFilterInput(role);
                this.manageUsersUserModalPage.clickRolesTableItemRadioBox(0);

                this.manageUsersUserModalPage.clickSaveButton();
                this.manageUsersPage.waitForToastToBeVisible();
                Assert.assertEquals(this.manageUsersPage.getToastMessageText(), "Saved User",
                                "Toast message should be 'Saved User'.");

                // load page instead of messing with the toast
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();
        }

        public void deleteUser(String userName) {
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

                this.manageUsersPage.enterUsersTableSearchInput("qaautomated." + userName);
                this.manageUsersPage.clickUsersTableItemEditLink(0); // click edit link
                this.manageUsersUserModalPage.waitToBeVisible();

                this.manageUsersUserModalPage.clickDeleteButton();
                this.manageUsersPage.waitForToastToBeVisible();
                Assert.assertEquals(this.manageUsersPage.getToastMessageText(), "User has been deleted",
                                "Toast message should be 'User has been deleted'.");

                // load page instead of messing with the toast
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();
        }

        public void editRoleEnableModuleAccess(String role, String module) {
                this.editRoleModuleAccess(role, module, true);
        }

        public void editRoleDisableModuleAccess(String role, String module) {
                this.editRoleModuleAccess(role, module, false);
        }

        public void editRoleModuleAccess(String role, String module, boolean enable) {
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

                this.manageUsersPage.enterRolesSearchInput(role); // search role
                this.manageUsersPage.clickRolesTableItemEditLink(0); // click edit
                this.manageUsersRoleModalPage.waitToBeVisible();
                this.manageUsersRoleModalPage.clickModuleAccessTab(); // click module assess tab

                switch (module) {
                case "addressBook":
                        if (enable) {
                                if (!this.manageUsersRoleModalPage.moduleAccessTabAddressBookCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabAddressBookCheckbox();
                                }
                                Assert.assertTrue(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabAddressBookCheckboxIsSelected(),
                                                "Address Book checkbox on Module Access Tab should be selected after enabling it.");
                        } else {
                                if (this.manageUsersRoleModalPage.moduleAccessTabAddressBookCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabAddressBookCheckbox();
                                }
                                Assert.assertFalse(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabAddressBookCheckboxIsSelected(),
                                                "Address Book checkbox on Module Access Tab should not be selected after disabling it.");
                        }
                        break;
                case "emailCenter":
                        if (enable) {
                                if (!this.manageUsersRoleModalPage.moduleAccessTabEmailCenterCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabEmailCenterCheckbox();
                                }
                                Assert.assertTrue(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabEmailCenterCheckboxIsSelected(),
                                                "Email Center checkbox on Module Access Tab should be selected after enabling it.");
                        } else {
                                if (this.manageUsersRoleModalPage.moduleAccessTabEmailCenterCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabEmailCenterCheckbox();
                                }
                                Assert.assertFalse(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabEmailCenterCheckboxIsSelected(),
                                                "Email Center checkbox on Module Access Tab should not be selected after disabling it.");
                        }
                        break;
                case "formsCenter":
                        if (enable) {
                                if (!this.manageUsersRoleModalPage.moduleAccessTabFormCenterCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabFormCenterCheckbox();
                                }
                                Assert.assertTrue(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabFormCenterCheckboxIsSelected(),
                                                "Form Center checkbox on Module Access Tab should be selected after enabling it.");
                        } else {
                                if (this.manageUsersRoleModalPage.moduleAccessTabFormCenterCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabFormCenterCheckbox();
                                }
                                Assert.assertFalse(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabFormCenterCheckboxIsSelected(),
                                                "Form Center checkbox on Module Access Tab should not be selected after disabling it.");
                        }
                        break;
                case "reports":
                        if (enable) {
                                if (!this.manageUsersRoleModalPage.moduleAccessTabReportsCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabReportsCheckbox();
                                }
                                Assert.assertTrue(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabReportsCheckboxIsSelected(),
                                                "Reports checkbox on Module Access Tab should be selected after enabling it.");
                                break;
                        } else {
                                if (this.manageUsersRoleModalPage.moduleAccessTabReportsCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabReportsCheckbox();
                                }
                                Assert.assertFalse(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabReportsCheckboxIsSelected(),
                                                "Reports checkbox on Module Access Tab should not be selected after disabling it.");
                                break;
                        }
                case "pms":
                        if (enable) {
                                if (!this.manageUsersRoleModalPage.moduleAccessTabPmsCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabPmsCheckbox();
                                }
                                Assert.assertTrue(this.manageUsersRoleModalPage.moduleAccessTabPmsCheckboxIsSelected(),
                                                "PMS checkbox on Module Access Tab should be selected after enabling it.");
                        } else {
                                if (this.manageUsersRoleModalPage.moduleAccessTabPmsCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabPmsCheckbox();
                                }
                                Assert.assertFalse(this.manageUsersRoleModalPage.moduleAccessTabPmsCheckboxIsSelected(),
                                                "PMS checkbox on Module Access Tab should not be selected after disabling it.");
                        }
                        break;
                case "workflow":
                        if (enable) {
                                if (!this.manageUsersRoleModalPage.moduleAccessTabWorkflowCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabWorkflowCheckbox();
                                }
                                Assert.assertTrue(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabWorkflowCheckboxIsSelected(),
                                                "Workflow checkbox on Module Access Tab should be selected after enabling it.");
                        } else {
                                if (this.manageUsersRoleModalPage.moduleAccessTabWorkflowCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabWorkflowCheckbox();
                                }
                                Assert.assertFalse(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabWorkflowCheckboxIsSelected(),
                                                "Workflow checkbox on Module Access Tab should not be selected after disabling it.");
                        }
                        break;
                case "rezqueue":
                        if (enable) {
                                if (!this.manageUsersRoleModalPage.moduleAccessTabRezqueueCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabRezqueueCheckbox();
                                }
                                Assert.assertTrue(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabRezqueueCheckboxIsSelected(),
                                                "Rezqueue checkbox on Module Access Tab should be selected after enabling it.");
                        } else {
                                if (this.manageUsersRoleModalPage.moduleAccessTabRezqueueCheckboxIsSelected()) {
                                        this.manageUsersRoleModalPage.clickModuleAccessTabRezqueueCheckbox();
                                }
                                Assert.assertFalse(
                                                this.manageUsersRoleModalPage
                                                                .moduleAccessTabRezqueueCheckboxIsSelected(),
                                                "Rezqueue checkbox on Module Access Tab should not be selected after disabling it.");
                        }
                        break;
                }

                this.manageUsersRoleModalPage.clickModuleAccessTabSaveModulesButton();
                this.manageUsersPage.waitForToastToBeVisible();

                Assert.assertEquals(this.manageUsersPage.getToastMessageText(), "Saved!",
                                "Toast message should be 'Saved!'.");

                // load page instead of messing with the toast
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();
        }

        public void editUserSelectRole(String userName, String role) {
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

                this.manageUsersPage.enterUsersTableSearchInput(userName);
                this.manageUsersPage.clickUsersTableItemEditLink(0);
                this.manageUsersUserModalPage.waitToBeVisible();

                this.manageUsersUserModalPage.clickRoleTab();
                this.manageUsersUserModalPage.waitForRoleTabToBeVisible();

                this.manageUsersUserModalPage.enterRolesTableFilterInput(role);
                this.manageUsersUserModalPage.clickRolesTableItemRadioBox(0);

                this.manageUsersUserModalPage.clickSaveButton();
                this.manageUsersPage.waitForToastToBeVisible();
                Assert.assertEquals(this.manageUsersPage.getToastMessageText(), "Updated User",
                                "Toast message should be 'Updated User'.");

                // load page instead of messing with the toast
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();
        }

        public void editUserRezQueueEnableListOwnerPms(String userName, String listOwnerPmsName) {
                this.editUserRezqueueListOwnerPmsEdit(userName, listOwnerPmsName, true);
        }

        public void editUserRezQueueDisableListOwnerPms(String userName, String listOwnerPmsName) {
                this.editUserRezqueueListOwnerPmsEdit(userName, listOwnerPmsName, false);
        }

        public void editUserRezqueueListOwnerPmsEdit(String userName, String listOwnerPmsName, boolean enable) {
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

                this.manageUsersPage.enterUsersTableSearchInput(userName);
                this.manageUsersPage.clickUsersTableItemEditLink(0);
                this.manageUsersUserModalPage.waitToBeVisible();

                this.manageUsersUserModalPage.clickRezqueueTab();
                this.manageUsersUserModalPage.enterListOwnerPmsName(listOwnerPmsName);

                if (enable) {
                        if (!this.manageUsersUserModalPage.listOwnerPmsTableItemCheckBoxIsSelected(0)) {
                                this.manageUsersUserModalPage.clickListOwnerPmsTableItemCheckBox(0);
                        }
                        Assert.assertTrue(this.manageUsersUserModalPage.listOwnerPmsTableItemCheckBoxIsSelected(0),
                                        "List Owner PMS  : " + listOwnerPmsName
                                                        + " should be selected after enabling it.");
                } else {
                        if (this.manageUsersUserModalPage.listOwnerPmsTableItemCheckBoxIsSelected(0)) {
                                this.manageUsersUserModalPage.clickListOwnerPmsTableItemCheckBox(0);
                        }
                        Assert.assertFalse(this.manageUsersUserModalPage.listOwnerPmsTableItemCheckBoxIsSelected(0),
                                        "List Owner PMS  : " + listOwnerPmsName
                                                        + " should not be selected after disabling it.");
                }

                this.manageUsersUserModalPage.clickSaveButton();
                this.manageUsersPage.waitForToastToBeVisible();
                Assert.assertEquals(this.manageUsersPage.getToastMessageText(), "Updated User",
                                "Toast message should be 'Updated User'.");

                // load page instead of messing with the toast
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();
        }

        public void editRoleListAccessLimitedEnableCampaign(String role, String folderName) {
                this.editRoleListAccessLimitedCampaignEdit(role, folderName, true);
        }

        public void editRoleListAccessLimitedDisableCampaign(String role, String folderName) {
                this.editRoleListAccessLimitedCampaignEdit(role, folderName, false);
        }

        public void editRoleListAccessLimitedCampaignEdit(String role, String folderName, boolean enable) {
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

                this.manageUsersPage.enterRolesSearchInput(role);
                this.manageUsersPage.clickRolesTableItemEditLink(0);
                this.manageUsersRoleModalPage.waitToBeVisible();

                this.manageUsersRoleModalPage.clickListAccessTab();
                this.manageUsersRoleModalPage.clickQaAutomatedListPanel();
                this.manageUsersRoleModalPage.waitForCollapsedPanelToBeVisible();
                this.manageUsersRoleModalPage.clickCampaignAccrodion();
                this.manageUsersRoleModalPage.waitForCampaignTableToBeVisible();
                this.manageUsersRoleModalPage.enterFolderName(folderName);

                // enable/disable folder access to role
                if (enable) {
                        if (!this.manageUsersRoleModalPage.campaignTableItemCheckBoxIsSelected(0)) {
                                this.manageUsersRoleModalPage.clickCampaignTableItemCheckBox(0);
                        }
                        Assert.assertTrue(this.manageUsersRoleModalPage.campaignTableItemCheckBoxIsSelected(0),
                                        "Checkbox for : " + folderName
                                                        + " should be selected before attempting to deselect it.");
                } else {
                        if (this.manageUsersRoleModalPage.campaignTableItemCheckBoxIsSelected(0)) {
                                this.manageUsersRoleModalPage.clickCampaignTableItemCheckBox(0);
                        }
                        Assert.assertFalse(this.manageUsersRoleModalPage.campaignTableItemCheckBoxIsSelected(0),
                                        "Checkbox for : " + folderName + " should not be selected after disabling it.");
                }

                this.manageUsersRoleModalPage.clickSaveCampaignButton();
                this.manageUsersPage.waitForToastToBeVisible();
                Assert.assertEquals(this.manageUsersPage.getToastMessageText(), "Updated!",
                                "Toast message should be 'Updated!'.");

                // load page instead of messing with the toast
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

        }

        public void editRoleListAccessLimitedEnableFilter(String role, String filterName) {
                this.editRoleListAccessLimitedFilterEdit(role, filterName, true);
        }

        public void editRoleListAccessLimitedDisableFilter(String role, String filterName) {
                this.editRoleListAccessLimitedFilterEdit(role, filterName, false);
        }

        public void editRoleListAccessLimitedFilterEdit(String role, String filterName, boolean enable) {
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

                this.manageUsersPage.enterRolesSearchInput(role);
                this.manageUsersPage.clickRolesTableItemEditLink(0);
                this.manageUsersRoleModalPage.waitToBeVisible();

                this.manageUsersRoleModalPage.clickListAccessTab();
                this.manageUsersRoleModalPage.clickQaAutomatedListPanel();
                this.manageUsersRoleModalPage.waitForCollapsedPanelToBeVisible();
                this.manageUsersRoleModalPage.clickFilterAccrodion();
                this.manageUsersRoleModalPage.waitForFilterTableToBeVisible();
                this.manageUsersRoleModalPage.enterFilterName(filterName);

                if (enable) {
                        if (!this.manageUsersRoleModalPage.filterTableItemCheckBoxIsSelected(0)) {
                                this.manageUsersRoleModalPage.clickFilterTableItemCheckBox(0);
                        }
                        Assert.assertTrue(this.manageUsersRoleModalPage.filterTableItemCheckBoxIsSelected(0),
                                        "Checkbox for : " + filterName
                                                        + " should be selected before attempting to deselect it.");
                } else {
                        if (this.manageUsersRoleModalPage.filterTableItemCheckBoxIsSelected(0)) {
                                this.manageUsersRoleModalPage.clickFilterTableItemCheckBox(0);
                        }
                        Assert.assertFalse(this.manageUsersRoleModalPage.filterTableItemCheckBoxIsSelected(0),
                                        "Checkbox for : " + filterName + " should not be selected after disabling it.");
                }

                this.manageUsersRoleModalPage.clickSaveFilterButton();
                this.manageUsersPage.waitForToastToBeVisible();
                Assert.assertEquals(this.manageUsersPage.getToastMessageText(), "Updated!",
                                "Toast message should be 'Updated!'.");

                // load page instead of messing with the toast
                this.manageUsersPage.get();
                this.manageUsersPage.waitForPageLoad();

        }
}
