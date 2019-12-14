package com.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;

import com.gms.tests.addressbook.profiles.BaseProfilesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeUsernameTest extends BaseProfilesTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.login(this.defaultUsername, this.defaultPassword);
    }

    @Test(description = "Test change Username for Loyalty Member")
    public void testChangeUsername() {
        String profileEmail = "bees.toxios@example.com";

        this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

        this.loyaltyTabPage.clickChangeLoyaltyMemberUserNameButton();
        this.loyaltyTabPage.waitForChangeUsernameModalDialogToBeVisible();
        this.loyaltyTabPage.enterNewUsernameInChangeUsernameDialog("newusername@example.com");
        this.loyaltyTabPage.clickToSaveNewUsername();
        this.loyaltyTabPage.waitForChangeUsernameConfirmationModalToBeVisible();
        Assert.assertTrue(
                this.loyaltyTabPage.getChangeUsernameConfirmationModalTitle()
                        .contains("Email has been sent to verify the new email."),
                "Change username confirmation modal title should contain 'Email has been sent to verify the new email.'.");
        this.loyaltyTabPage.clickChangeUsernameConfirmationModalCloseButton();
    }
}