package com.gms.tests.addressbook.profiles;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gms.pages.profiles.profile.HeaderPage;
import com.gms.pages.profiles.profile.MessengerTabPage;
import com.gms.pages.rezqueue.RezqueueMessengerPage;

public class SendMessageTest extends BaseProfilesTest {

        protected HeaderPage headerPage;
        protected MessengerTabPage messengerTabPage;
        protected RezqueueMessengerPage rezqueueMessengerPage;

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.headerPage = new HeaderPage(this.driver, config);
                this.messengerTabPage = new MessengerTabPage(this.driver, config);
                this.rezqueueMessengerPage = new RezqueueMessengerPage(this.driver, config);
                this.login(this.defaultUsername, this.defaultPassword);
        }

        @Test(description = "Test navigation to rezqueue messenger via Send Message button")
        public void testSendMessage() {
                this.profilesPage.get();
                this.profilesPage.waitForPageLoad();

                this.profilesPage.clickSendMessageButton();
                this.profilesPage.switchToNewWindow(); // switch to newly opened window
                this.rezqueueMessengerPage.waitForSendNewMessageModalToBeVisible(); // modal opens automatically

                this.rezqueueMessengerPage.clickSendNewMessageModalClosebutton();
                this.rezqueueMessengerPage.waitForPageLoad(); // modal is now gone
                this.driver.close(); // close the second window
                this.profilesPage.switchToNewWindow(); // switch back to original window
        }

        @Test(description = "Test sending message from Guest Messenger for profile without message channel configured")
        public void testGuestMessengerForProfileWithNoMessageChannelConfigured() {
                this.goToProfile("guestmessenger.withoutchannel@example.com"); // profile with no message channel
                                                                               // configured
                this.headerPage.clickProfileMessengerTab();
                this.messengerTabPage.waitForPageLoad();

                this.messengerTabPage.clickSendMessageButton();
                this.messengerTabPage.waitForSendMessageToUserPopupToBeVisible();
                this.messengerTabPage.clickPropertySelect();

                this.messengerTabPage.selectPropertyViaSearch("Property 3");
                this.messengerTabPage.clickSaveButtonIcon();
                this.profilesPage.switchToNewWindow(); // switch to newly opened window
                this.rezqueueMessengerPage.waitForSendNewMessageModalToBeVisible(); // modal opens automatically

                Assert.assertTrue(this.driver.getCurrentUrl() // assert navigation to rezqueue url
                                .startsWith(this.config.getProperty("app.rezqueue.baseurl")),
                                "URL should start with " + this.config.getProperty("app.rezqueue.baseurl"));

                Assert.assertTrue(this.rezqueueMessengerPage.sendNewMessageModalDialogIsVisible(),
                                "Send New Message modal should be visible.");

                Assert.assertEquals(this.rezqueueMessengerPage.getErrorMessage(),
                                "This profile does not have a supported communication channel.",
                                "Error Message should be This profile does not have a supported communication channel");
                this.driver.close(); // close the second window
                this.profilesPage.switchToNewWindow(); // switch back to original window
        }

        @Test(description = "Test sending message from Guest Messenger for profile with message channel configured")
        public void testGuestMessengerForProfileWithMessageChannelConfigured() {
                String propertyName = "Property 3";
                this.goToProfile("guestmessenger.withchannel@example.com"); // profile with message channel configured
                this.headerPage.clickProfileMessengerTab();
                this.messengerTabPage.waitForPageLoad();

                this.messengerTabPage.clickSendMessageButton();
                this.messengerTabPage.waitForSendMessageToUserPopupToBeVisible();
                this.messengerTabPage.clickPropertySelect();

                this.messengerTabPage.selectPropertyViaSearch(propertyName);
                this.messengerTabPage.clickSaveButtonIcon();
                this.profilesPage.switchToNewWindow(); // switch to newly opened window
                this.rezqueueMessengerPage.waitForSendNewMessageModalToBeVisible(); // modal opens automatically

                Assert.assertTrue(this.driver.getCurrentUrl() // assert navigation to rezqueue url
                                .startsWith(this.config.getProperty("app.rezqueue.baseurl")),
                                "URL should start with " + this.config.getProperty("app.rezqueue.baseurl"));

                Assert.assertTrue(this.rezqueueMessengerPage.sendNewMessageModalDialogIsVisible(),
                                "Send New Message modal should be visible.");

                this.rezqueueMessengerPage.clickSendNewMessageModalClosebutton();
                this.rezqueueMessengerPage.waitForSendNewMessageModalToBeInVisible();

                // IMPORTAMT: remove or replace mobile number for profile before testing actual
                // message send

                Assert.assertTrue(this.rezqueueMessengerPage.propertyIsSelected(propertyName),
                                propertyName + " should be selected in dropdown on rezqueue messenger page.");
                this.driver.close(); // close the second window
                this.profilesPage.switchToNewWindow(); // switch back to original window
        }
}