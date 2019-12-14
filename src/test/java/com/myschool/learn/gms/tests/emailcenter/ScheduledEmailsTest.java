package com.myschool.learn.gms.tests.emailcenter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.myschool.learn.gms.pages.emailcenter.email.HtmlTabPage;
import com.myschool.learn.gms.pages.emailcenter.email.ScheduleEmailTabPage;
import com.myschool.learn.gms.pages.emailcenter.ScheduledEmailsTabPage;
import com.myschool.learn.gms.pages.emailcenter.email.SetupTabPage;
import com.myschool.learn.gms.pages.emailcenter.email.TestTabPage;
import com.myschool.learn.gms.tests.BaseFunctionalTest;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScheduledEmailsTest extends BaseFunctionalTest {

        protected ScheduledEmailsTabPage scheduledEmailsTabPage;
        protected com.myschool.learn.gms.pages.emailcenter.HeaderPage emailCenterHeaderPage;
        protected com.myschool.learn.gms.pages.emailcenter.email.HeaderPage emailHeaderPage;
        protected SetupTabPage setupTabPage;
        protected HtmlTabPage htmlTabPage;
        protected TestTabPage testTabPage;
        protected ScheduleEmailTabPage scheduleEmailTabPage;

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.emailCenterHeaderPage = new com.myschool.learn.gms.pages.emailcenter.HeaderPage(this.driver, config);
                this.scheduledEmailsTabPage = new ScheduledEmailsTabPage(this.driver, config);
                this.emailHeaderPage = new com.myschool.learn.gms.pages.emailcenter.email.HeaderPage(this.driver, config);
                this.setupTabPage = new SetupTabPage(this.driver, config);
                this.htmlTabPage = new HtmlTabPage(this.driver, config);
                this.testTabPage = new TestTabPage(this.driver, config);
                this.scheduleEmailTabPage = new ScheduleEmailTabPage(this.driver, config);
                this.login(this.defaultUsername, this.defaultPassword);
        }

        @Test(description = "Test scheduled emails tab folder contents.")
        public void testScheduledEmailsTabFolderContents() {
                this.scheduledEmailsTabPage.get();
                this.emailCenterHeaderPage.waitForPageLoad();
                this.scheduledEmailsTabPage.waitForPageLoad();

                this.driver.switchTo().frame("canvas");
                this.driver.switchTo().frame("pushFrame");

                Assert.assertTrue(this.scheduledEmailsTabPage.getFolderTableRowCount().intValue() > 0,
                                "There should be at least 1 folder.");
                Assert.assertTrue(this.scheduledEmailsTabPage.getFolderTableRowContents(0).contains("AutomationFolder"),
                                "First folder should be 'AutomationFolder'");

                scheduledEmailsTabPage.clickFolderTableRow(0);

                this.scheduledEmailsTabPage.waitForTextToBeInEmailTable("dcfvbgdgfh");
                Assert.assertTrue(this.scheduledEmailsTabPage.getEmailTableRowCount().intValue() > 0,
                                "Email table should have at least 1 row.");
                Assert.assertEquals(this.scheduledEmailsTabPage.getEmailTableRowName(0), "dcfvbgdgfh",
                                "Email table row 0 name should be 'dcfvbgdgfh'");

                Assert.assertTrue(this.scheduledEmailsTabPage.getSubFolderTableRowCount().intValue() > 0,
                                "Subfolder table should have at least 1 row.");
                Assert.assertTrue(
                                this.scheduledEmailsTabPage.getSubFolderTableRowContents(0)
                                                .contains("AutomationSubFolder"),
                                "Sub folder table row 0 should be 'AutomationSubFolder'");
        }

        @Test(description = "Test new scheduled email prefills.")
        public void testNewScheduledEmailPrefills() {
                this.scheduledEmailsTabPage.get();
                this.emailCenterHeaderPage.waitForPageLoad();

                this.navigationBarPage.waitForPageLoad();
                this.navigationBarPage.hoverOverCreateEmailMenuItem();
                this.navigationBarPage.clickCreateEmailNewScheduledEmailMenuItem();

                this.driver.switchTo().frame("canvas");
                this.setupTabPage.waitForPageLoad();

                Assert.assertEquals(this.setupTabPage.getFromNameValue(), "QA Functional test",
                                "From name should contain prefill of 'QA Functional test'.");
                Assert.assertEquals(this.setupTabPage.getFromEmailAddressValue(), "arai@travelclick.com",
                                "From email address should contain prefill of 'arai@travelclick.com'.");
                Assert.assertEquals(this.setupTabPage.getReplyToOverrideValue(), "Click to enter",
                                "Reply to override should contain prefill of 'Click to enter'.");
                Assert.assertEquals(this.setupTabPage.getSelectedFolder(), "Select",
                                "Folder should contain prefill of 'Select'.");
                Assert.assertEquals(this.setupTabPage.getSelectedSubFolder(), "No Folder",
                                "Subfolder should contain prefill of 'No Folder'.");
        }

        @Test(description = "Test new scheduled email field validation.")
        public void testNewScheduledEmailAllFieldValidation() {
                this.scheduledEmailsTabPage.get();
                this.emailCenterHeaderPage.waitForPageLoad();

                this.navigationBarPage.waitForPageLoad();
                this.navigationBarPage.hoverOverCreateEmailMenuItem();
                this.navigationBarPage.clickCreateEmailNewScheduledEmailMenuItem();

                this.driver.switchTo().frame("canvas");
                this.setupTabPage.waitForPageLoad();

                this.setupTabPage.clickSaveAllButton();

                Assert.assertTrue(this.setupTabPage.getAlertText().contains("You have 4 errors:"),
                                "Alert should contain text 'You have 4 errors:'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Name"),
                                "Alert should contain text 'Name'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Folder"),
                                "Alert should contain text 'Folder'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Subject"),
                                "Alert should contain text 'Subject'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Refer a friend subject"),
                                "Alert should contain text 'Refer a friend subject'.");
                this.setupTabPage.clickAlertOk();

                this.enterNewEmailData("Test Name", null, null, null, null);
                this.setupTabPage.clickSaveAllButton();

                Assert.assertTrue(this.setupTabPage.getAlertText().contains("You have 3 errors:"),
                                "Alert should contain text 'You have 3 errors:'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Folder"),
                                "Alert should contain text 'Folder'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Subject"),
                                "Alert should contain text 'Subject'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Refer a friend subject"),
                                "Alert should contain text 'Refer a friend subject'.");
                this.setupTabPage.clickAlertOk();

                this.enterNewEmailData("Test Name", "AutomationFolder", null, null, null);
                this.setupTabPage.clickSaveAllButton();

                Assert.assertTrue(this.setupTabPage.getAlertText().contains("You have 2 errors:"),
                                "Alert should contain text 'You have 2 errors:'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Subject"),
                                "Alert should contain text 'Subject'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Refer a friend subject"),
                                "Alert should contain text 'Refer a friend subject'.");
                this.setupTabPage.clickAlertOk();

                this.enterNewEmailData("Test Name", "AutomationFolder", null, "Test Subject", null);
                this.setupTabPage.clickSaveAllButton();

                Assert.assertTrue(this.setupTabPage.getAlertText().contains("You have one error:"),
                                "Alert should contain text 'You have one error:'.");
                Assert.assertTrue(this.setupTabPage.getAlertText().contains("Refer a friend subject"),
                                "Alert should contain text 'Refer a friend subject'.");
                this.setupTabPage.clickAlertOk();
        }

        @Test(description = "Test new scheduled email creation.")
        public void testNewScheduledEmailCreation() {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String testDate = formatter.format(new Date());
                String testEmailName = "Test Email " + testDate;
                String testEmailSubject = "Subject " + testDate;
                String testEmailForwardSubject = "Forward Subject " + testDate;
                String testContent = "Test content for email. The date and time is " + testDate;

                this.scheduledEmailsTabPage.get();
                this.emailCenterHeaderPage.waitForPageLoad();

                this.navigationBarPage.waitForPageLoad();
                this.navigationBarPage.hoverOverCreateEmailMenuItem();
                this.navigationBarPage.clickCreateEmailNewScheduledEmailMenuItem();
                this.driver.switchTo().frame("canvas");
                this.setupTabPage.waitForPageLoad();

                this.enterNewEmailData(testEmailName, "AutomationFolder", "AutomationSubFolder", testEmailSubject,
                                testEmailForwardSubject);

                this.setupTabPage.clickSaveAllButton();

                Assert.assertTrue(this.htmlTabPage.htmlIframeIsVisible(), "Html Iframe should be visible.");
                this.driver.switchTo().frame("htmlIframe");
                this.htmlTabPage.waitForLoadingModal();
                this.htmlTabPage.waitForPageLoad();

                Assert.assertEquals(this.htmlTabPage.getHtmlContentTableRowCount().intValue(), 2,
                                "Html content table should have 2 rows.");
                Assert.assertTrue(
                                this.htmlTabPage.getHtmlContentTableRowContents(1)
                                                .contains("Forward to a friend or colleague"),
                                "Html content row 1 should contain text 'Forward to a friend or colleague'");

                this.htmlTabPage.clickAddRowButton();
                this.htmlTabPage.waitForLoadingModal();
                Assert.assertEquals(this.htmlTabPage.getHtmlContentTableRowCount().intValue(), 3,
                                "Html content table should have 3 rows.");
                this.htmlTabPage.clickAddRowButton();
                this.htmlTabPage.waitForLoadingModal();
                Assert.assertEquals(this.htmlTabPage.getHtmlContentTableRowCount().intValue(), 4,
                                "Html content table should have 4 rows.");

                this.htmlTabPage.enterHtmlContentTableRowText(0, testContent);
                Assert.assertTrue(this.htmlTabPage.getHtmlContentTableRowContents(0).contains(testContent),
                                "Html content row 1 should contain text '" + testContent + "'.");

                this.htmlTabPage.enterHtmlContentTableRowText(2, "Added row 1");
                Assert.assertTrue(this.htmlTabPage.getHtmlContentTableRowContents(2).contains("Added row 1"),
                                "Html content row 1 should contain text 'Added row 1'.");

                this.htmlTabPage.enterHtmlContentTableRowText(3, "Added row 2");
                Assert.assertTrue(this.htmlTabPage.getHtmlContentTableRowContents(3).contains("Added row 2"),
                                "Html content row 1 should contain text 'Added row 2'.");

                this.htmlTabPage.clickSaveButton();
                this.htmlTabPage.waitForLoadingModal();
                this.htmlTabPage.waitForFlashMessageToBeVisible();
                Assert.assertTrue(this.htmlTabPage.getFlashMessageContents().contains("Your changes have been saved"),
                                "Flash message should contain text 'Your changes have been saved'.");

                this.driver.switchTo().defaultContent();
                this.scheduledEmailsTabPage.get();
                this.emailCenterHeaderPage.waitForPageLoad();

                this.driver.switchTo().frame("canvas");
                Assert.assertTrue(emailCenterHeaderPage.scheduledEmailsTabIsSelected(),
                                "Scheduled emails tab should be selected.");
                this.driver.switchTo().defaultContent();

                this.scheduledEmailsTabPage.waitForPageLoad();

                this.driver.switchTo().frame("canvas"); // switch to content frame
                this.driver.switchTo().frame("pushFrame"); // switch to content frame

                this.scheduledEmailsTabPage.enterSearch(testEmailName);
                this.scheduledEmailsTabPage.clickSearchIcon();
                this.scheduledEmailsTabPage.waitForTextToBeInEmailTable(testEmailName);

                Assert.assertEquals(this.scheduledEmailsTabPage.getEmailTableRowName(1), testEmailName,
                                "Email row 0 should have name '" + testEmailName + "'.");
                Assert.assertEquals(this.scheduledEmailsTabPage.getEmailTableRowDescription(1), "Not yet scheduled",
                                "Email row 0 should have description 'Not yet scheduled'.");

                // delete newly created email
                this.scheduledEmailsTabPage.clickEmailTableRowDeleteIcon(1);
                Alert alert = this.driver.switchTo().alert();
                alert.accept();
        }

        @Test(description = "Verify new scheduled email creation and scheduling.")
        public void testNewScheduledEmailCreationAndScheduling() {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String testDate = formatter.format(new Date());
                String testEmailName = "Test Email (created " + testDate + ")";
                String testEmailSubject = "Subject (created " + testDate + ")";
                String testEmailForwardSubject = "Forward Subject (created " + testDate + ")";
                String testContent = "Test content for email. The date and time cretaed is " + testDate;
                String scheduleDate = "2049-10-31"; // the distant future
                String scheduleDateWithSlashes = "2049/10/31";
                String scheduleTime = "9:15 AM";
                String scheduleFilter = "City : Ottawa";

                this.scheduledEmailsTabPage.get();
                this.emailCenterHeaderPage.waitForPageLoad();

                this.navigationBarPage.waitForPageLoad();
                this.navigationBarPage.hoverOverCreateEmailMenuItem();
                this.navigationBarPage.clickCreateEmailNewScheduledEmailMenuItem();
                this.driver.switchTo().frame("canvas");
                this.setupTabPage.waitForPageLoad();

                this.enterNewEmailData(testEmailName, "AutomationFolder", "Scheduled Emails", testEmailSubject,
                                testEmailForwardSubject);

                this.setupTabPage.clickSaveAllButton();
                Assert.assertTrue(this.htmlTabPage.htmlIframeIsVisible(), "Html Iframe is not visible.");
                this.driver.switchTo().frame("htmlIframe");
                this.htmlTabPage.waitForLoadingModal();
                this.htmlTabPage.waitForPageLoad();

                this.htmlTabPage.enterHtmlContentTableRowText(0, testContent);
                Assert.assertTrue(this.htmlTabPage.getHtmlContentTableRowContents(0).contains(testContent),
                                "Html content row 1 does not contain text '" + testContent + "'.");

                this.htmlTabPage.clickSaveButton();
                this.htmlTabPage.waitForLoadingModal();
                this.htmlTabPage.waitForFlashMessageToBeVisible();
                Assert.assertTrue(this.htmlTabPage.getFlashMessageContents().contains("Your changes have been saved"),
                                "Flash message does not contain text 'Your changes have been saved'.");

                this.driver.switchTo().defaultContent();
                this.driver.switchTo().frame("canvas");
                this.emailHeaderPage.clickTestTab();
                this.driver.switchTo().frame("testIframe");
                this.driver.switchTo().frame("testIframeInner");
                this.testTabPage.waitForPageLoad();
                this.testTabPage.enterEmailAddresses("test@example.com");
                this.testTabPage.clickSendButton();
                this.testTabPage.waitForEmailSentSuccessMessageToBeVisible();

                this.driver.switchTo().defaultContent();
                this.driver.switchTo().frame("canvas");
                this.emailHeaderPage.clickScheduleEmailTab();
                this.driver.switchTo().frame("scheduleIframe");
                this.scheduleEmailTabPage.waitForPageLoad();

                this.scheduleEmailTabPage.enterScheduleDate(scheduleDate);
                this.scheduleEmailTabPage.enterScheduleTime(scheduleTime);
                this.scheduleEmailTabPage.clickFilterSelect();
                this.scheduleEmailTabPage.enterFilterSelect(scheduleFilter); // Test McTesterson
                this.scheduleEmailTabPage.clickSaveButton();
                this.scheduleEmailTabPage.waitForConfirmDialogToBeVisible();
                this.scheduleEmailTabPage.clickConfirmModalSaveButton();
                this.scheduleEmailTabPage.waitForConfirmDialogToBeInvisible();

                this.driver.switchTo().defaultContent();
                this.scheduledEmailsTabPage.get();
                this.emailCenterHeaderPage.waitForPageLoad();
                this.scheduledEmailsTabPage.waitForPageLoad();
                this.driver.switchTo().frame("canvas"); // switch to content frame
                this.driver.switchTo().frame("pushFrame"); // switch to content frame

                this.scheduledEmailsTabPage.enterSearch(testEmailName);
                this.scheduledEmailsTabPage.clickSearchIcon();
                this.scheduledEmailsTabPage.waitForTextToBeInEmailTable(testEmailName);

                Assert.assertEquals(this.scheduledEmailsTabPage.getEmailTableRowName(1), testEmailName,
                                "Email should have name '" + testEmailName + "'.");

                Assert.assertTrue(this.scheduledEmailsTabPage.getEmailTableRowDescription(1).contains(scheduleFilter),
                                "Email description should contain filter '" + scheduleFilter + "'");
                Assert.assertTrue(
                                this.scheduledEmailsTabPage.getEmailTableRowDescription(1)
                                                .contains(scheduleDateWithSlashes),
                                "Email description should contain schedule date of'" + scheduleDateWithSlashes + "'");
                Assert.assertTrue(this.scheduledEmailsTabPage.getEmailTableRowDescription(1).contains(scheduleTime),
                                "Email description should contain scheduled time of '" + scheduleTime + "'");
        }

        public void enterNewEmailData(String name, String folder, String subFolder, String subject,
                        String forwardToAFriendSubject) {
                if (name != null) {
                        this.setupTabPage.enterName(name);
                }

                if (folder != null) {
                        this.setupTabPage.selectFolder(folder);
                }

                if (subFolder != null) {
                        this.setupTabPage.selectSubFolder(subFolder);
                }

                if (subject != null) {
                        this.setupTabPage.enterSubjectLine(subject);
                }

                if (forwardToAFriendSubject != null) {
                        this.setupTabPage.enterForwardToAFriendSubjectLine(forwardToAFriendSubject);
                }
        }
}