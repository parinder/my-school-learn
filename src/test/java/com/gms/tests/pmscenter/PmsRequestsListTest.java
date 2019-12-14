package com.gms.tests.pmscenter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gms.pages.listownerpms.ListOwnerPmsEditPage;
import com.gms.pages.pmscenter.PmsRequestEditPage;
import com.gms.pages.pmscenter.PmsRequestNewPage;
import com.gms.pages.pmscenter.PmsRequestPage;
import com.gms.tests.BaseFunctionalTest;

public class PmsRequestsListTest extends BaseFunctionalTest {
        protected PmsRequestEditPage pmsCenterPmsRequestEditPage;
        protected PmsRequestPage pmsCenterPmsRequestPage;
        protected PmsRequestNewPage pmsCenterPmsRequestNewPage;
        protected ListOwnerPmsEditPage listOwnerPmsEditPage;

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.pmsCenterPmsRequestEditPage = new PmsRequestEditPage(this.driver, config);
                this.pmsCenterPmsRequestNewPage = new PmsRequestNewPage(this.driver, config);
                this.pmsCenterPmsRequestPage = new PmsRequestPage(this.driver, config);
                this.listOwnerPmsEditPage = new ListOwnerPmsEditPage(this.driver, config);
                this.login(this.defaultUsername, this.defaultPassword);
        }

        @Test(description = "Test search with no results.")
        public void testSearchNoResults() {
                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                // assert newly created pms request is deleted
                this.pmsCenterPmsRequestPage.enterPmsRequestSearch("No such PMS request with this name exists.");
                Assert.assertTrue(this.pmsCenterPmsRequestPage.noRecordsTableItemIsVisible(),
                                "Row containing No matching records found text should be visible.");
        }

        @Test(description = "Test clicking List Owner PMS.")
        public void testClickListOwnerPMS() {
                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                this.pmsCenterPmsRequestPage.clickListOwnerPmsName(4);
                this.pmsCenterPmsRequestPage.waitForNumberOfWindowsToBe(2);
                this.pmsCenterPmsRequestPage.switchToNewWindow();
                this.listOwnerPmsEditPage.waitForPageLoad();

                Assert.assertTrue(this.listOwnerPmsEditPage.getCurrentUrl().contains("17043"),
                                "Url should contain List Owner PMS ID '17043'.");
        }

        @Test(description = "Test creating a new update pms request.")
        public void testCreateUpdatePmsRequest() {
                String newPmsRequestName = "New Update PMS Request";

                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                Integer pmsRequestCount = this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount();

                this.pmsCenterPmsRequestPage.clickCreateNewPmsRequestButton();
                this.pmsCenterPmsRequestNewPage.waitForPageLoad();

                this.pmsCenterPmsRequestNewPage.selectListOwnerDropdownOption("List Owner PMS 1");
                this.pmsCenterPmsRequestNewPage.waitForPmsRequestNameToContainText("List Owner PMS 1");
                this.pmsCenterPmsRequestNewPage.selectPmsRequestType("Upgrade");
                this.pmsCenterPmsRequestNewPage.waitForPmsRequestNameToContainText("Upgrade");

                this.pmsCenterPmsRequestNewPage.enterPmsRequestName(newPmsRequestName);
                this.pmsCenterPmsRequestNewPage.clickSaveButton();
                this.pmsCenterPmsRequestEditPage.waitForPageLoad();

                this.pmsCenterPmsRequestEditPage.enterStartDate("2019-07-15");
                this.pmsCenterPmsRequestEditPage.clickSaveButton();
                Assert.assertTrue(
                                this.pmsCenterPmsRequestEditPage.getSuccessAlertMessageText()
                                                .contains("Your changes have been saved!"),
                                "Success Alert Message did not appear.");

                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();
                Integer newPmsRequestCount = pmsRequestCount + 1;
                Assert.assertEquals(this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount().intValue(),
                                newPmsRequestCount.intValue(),
                                "Pms request table row count is not increased to " + newPmsRequestCount + ".");
                Assert.assertTrue(
                                this.pmsCenterPmsRequestPage.getPmsRequestsTableRowContents(0)
                                                .contains(newPmsRequestName),
                                "Pms Request table row 0 is not '" + newPmsRequestName + "'");

                this.pmsCenterPmsRequestPage.hoverOverPmsRequestName(0);
                this.pmsCenterPmsRequestPage.clickDeleteButton(0);
                this.pmsCenterPmsRequestPage.clickConfirmationRequiredModalOkButton();
                this.pmsCenterPmsRequestPage.waitForDialogBoxIsInvisible();

                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();
                Assert.assertEquals(this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount().intValue(),
                                pmsRequestCount.intValue(),
                                "Pms request table row count is not decreased back to " + pmsRequestCount + ".");
                Assert.assertFalse(
                                this.pmsCenterPmsRequestPage.getPmsRequestsTableRowContents(0)
                                                .contains(newPmsRequestName),
                                "Pms Request table row 0 is still '" + newPmsRequestName + "'");
        }

        @Test(description = "Test creating a new confirmation pms request.")
        public void testCreateConfirmationPmsRequest() {
                String newPmsRequestName = "New Confirmation PMS Request";

                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                Integer pmsRequestCount = this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount();

                this.pmsCenterPmsRequestPage.clickCreateNewPmsRequestButton();
                this.pmsCenterPmsRequestNewPage.waitForPageLoad();

                this.pmsCenterPmsRequestNewPage.selectListOwnerDropdownOption("List Owner PMS 1");
                this.pmsCenterPmsRequestNewPage.waitForPmsRequestNameToContainText("List Owner PMS 1");
                this.pmsCenterPmsRequestNewPage.selectPmsRequestType("Confirmation");
                this.pmsCenterPmsRequestNewPage.waitForPmsRequestNameToContainText("Confirmation");

                this.pmsCenterPmsRequestNewPage.enterPmsRequestName(newPmsRequestName);
                this.pmsCenterPmsRequestNewPage.clickSaveButton();
                this.pmsCenterPmsRequestEditPage.waitForPageLoad();

                this.pmsCenterPmsRequestEditPage.enterStartDate("2019-07-15");
                this.pmsCenterPmsRequestEditPage.clickSaveButton();
                Assert.assertTrue(
                                this.pmsCenterPmsRequestEditPage.getSuccessAlertMessageText()
                                                .contains("Your changes have been saved!"),
                                "Success Alert Message is not visible");

                this.pmsCenterPmsRequestEditPage.clickCancelButton();
                this.pmsCenterPmsRequestPage.waitForPageLoad();
                Integer newPmsRequestCount = pmsRequestCount + 1;
                Assert.assertEquals(this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount().intValue(),
                                newPmsRequestCount.intValue(),
                                "Pms request table row count is not increased to " + newPmsRequestCount + ".");
                Assert.assertTrue(
                                this.pmsCenterPmsRequestPage.getPmsRequestsTableRowContents(0)
                                                .contains(newPmsRequestName),
                                "Pms Request table row 0 is not '" + newPmsRequestName + "'");

                this.pmsCenterPmsRequestPage.hoverOverPmsRequestName(0);
                this.pmsCenterPmsRequestPage.clickDeleteButton(0);
                this.pmsCenterPmsRequestPage.clickConfirmationRequiredModalOkButton();
                this.pmsCenterPmsRequestPage.waitForDialogBoxIsInvisible();

                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();
                Assert.assertEquals(this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount().intValue(),
                                pmsRequestCount.intValue(),
                                "Pms request table row count is not decreased back to " + pmsRequestCount + ".");
                Assert.assertFalse(
                                this.pmsCenterPmsRequestPage.getPmsRequestsTableRowContents(0)
                                                .contains(newPmsRequestName),
                                "Pms Request table row 0 is still '" + newPmsRequestName + "'");
        }

        @Test(description = "Test cancelling creating a new pms request.")
        public void testCancelNewPmsRequest() {
                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                Integer pmsRequestCount = this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount();

                this.pmsCenterPmsRequestPage.clickCreateNewPmsRequestButton();
                this.pmsCenterPmsRequestNewPage.waitForPageLoad();

                this.pmsCenterPmsRequestNewPage.clickCancelButton();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                Assert.assertEquals(this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount().intValue(),
                                pmsRequestCount.intValue(),
                                "Pms request table row count should still be " + pmsRequestCount + ".");
        }

        @Test(description = "Test cancelling deleting a pms request.")
        public void testCancelDeletePmsRequest() {
                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                Integer pmsRequestCount = this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount();

                this.pmsCenterPmsRequestPage.hoverOverPmsRequestName(0);
                this.pmsCenterPmsRequestPage.clickDeleteButton(0);

                this.pmsCenterPmsRequestPage.clickConfirmationRequiredModalCancelButton();
                this.pmsCenterPmsRequestPage.waitForDialogBoxIsInvisible();

                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                Assert.assertEquals(this.pmsCenterPmsRequestPage.getPmsRequestsTableRowCount().intValue(),
                                pmsRequestCount.intValue(),
                                "Pms request table row count should still be " + pmsRequestCount + ".");
        }

        @Test(description = "Test editing a pms request.")
        public void testEditPmsRequest() {
                this.pmsCenterPmsRequestPage.get();
                this.pmsCenterPmsRequestPage.waitForPageLoad();

                Assert.assertTrue(
                                this.pmsCenterPmsRequestPage.getPmsRequestsTableRowContents(0)
                                                .contains("InnsistTest Confirmation"),
                                "Pms Request table row 1 does not have expected text of 'InnsistTest Confirmation'");

                this.pmsCenterPmsRequestPage.hoverOverPmsRequestName(0);
                this.pmsCenterPmsRequestPage.clickEditButton(0);
                this.pmsCenterPmsRequestEditPage.waitForPageLoad();

                Assert.assertTrue(this.pmsCenterPmsRequestEditPage.editPmsRequestTitleIsVisible(),
                                "Edit Pms Requests title should be visible.");

                this.pmsCenterPmsRequestEditPage.enterName("Renamed InnsistTest Confirmation");
                this.pmsCenterPmsRequestEditPage.clickSaveButton();

                Assert.assertTrue(
                                this.pmsCenterPmsRequestEditPage.getSuccessAlertMessageText()
                                                .contains("Your changes have been saved!"),
                                "Success Alert Message should be visible");
                this.pmsCenterPmsRequestEditPage.clickSuccessAlertCloseIcon();

                this.pmsCenterPmsRequestEditPage.clickCancelButton();
                this.pmsCenterPmsRequestPage.waitForPageLoad();
                this.pmsCenterPmsRequestPage.listOfPmsRequestsTitleIsVisible();

                Assert.assertTrue(
                                this.pmsCenterPmsRequestPage.getPmsRequestsTableRowContents(0)
                                                .contains("Renamed InnsistTest Confirmation"),
                                "Pms Request table row 1 should have expected text of 'Renamed InnsistTest Confirmation'");

                this.pmsCenterPmsRequestPage.hoverOverPmsRequestName(0);
                this.pmsCenterPmsRequestPage.clickEditButton(0);
                this.pmsCenterPmsRequestEditPage.waitForPageLoad();

                Assert.assertTrue(this.pmsCenterPmsRequestEditPage.editPmsRequestTitleIsVisible(),
                                "Edit Pms Requests title should be visible.");

                this.pmsCenterPmsRequestEditPage.enterName("InnsistTest Confirmation");
                this.pmsCenterPmsRequestEditPage.clickSaveButton();

                Assert.assertTrue(
                                this.pmsCenterPmsRequestEditPage.getSuccessAlertMessageText()
                                                .contains("Your changes have been saved!"),
                                "Success Alert Message should be visible");
                this.pmsCenterPmsRequestEditPage.clickSuccessAlertCloseIcon();

                this.pmsCenterPmsRequestEditPage.clickCancelButton();
                this.pmsCenterPmsRequestPage.waitForPageLoad();
                this.pmsCenterPmsRequestPage.listOfPmsRequestsTitleIsVisible();

                Assert.assertTrue(
                                this.pmsCenterPmsRequestPage.getPmsRequestsTableRowContents(0)
                                                .contains("InnsistTest Confirmation"),
                                "Pms Request table row 1 should have expected text of 'InnsistTest Confirmation'");
        }
}