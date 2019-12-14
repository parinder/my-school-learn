package com.myschool.learn.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;

import com.myschool.learn.gms.apis.LoyaltyV2Api;
import com.myschool.learn.gms.tests.addressbook.profiles.BaseProfilesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ChangePasswordTest extends BaseProfilesTest {

    protected LoyaltyV2Api loyaltyV2Api;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.loyaltyV2Api = new LoyaltyV2Api(this.config);
        this.login(this.defaultUsername, this.defaultPassword);
    }

    @Test(description = "Verify change password password validation")
    public void testNewPasswordValidation() {
        this.goToProfileLoyaltyTab("yasmin.monahan.35140@example.com", "Guest Portal");

        this.loyaltyTabPage.clickChangeLoyaltyMemberPasswordButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeVisible();
        this.loyaltyTabPage.enterChangePasswordModalNewPassword("a");
        this.loyaltyTabPage.enterChangePasswordModalNewPasswordAgain("a");
        this.loyaltyTabPage.clickChangePasswordModalSaveButton();
        Assert.assertTrue(
                this.loyaltyTabPage.changePasswordModalGeneralErrorMessageTextContains(
                        "Your password must be between 8 and 18 characters."),
                "Error message should contain 'Your password must be between 8 and 18 characters.'.");
        Assert.assertTrue(this.loyaltyTabPage.changePasswordModalGeneralErrorMessageTextContains(
                "It must consist of a number, a lowercase character, an uppercase character and a special character"),
                "Error message should contain 'It must consist of a number, a lowercase character, an uppercase character and a special character'.");

        this.loyaltyTabPage.clickChangePasswordModalXButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeInvisible();
        
        this.loyaltyTabPage.clickChangeLoyaltyMemberPasswordButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeVisible();
        this.loyaltyTabPage.enterChangePasswordModalNewPassword("newpassworda");
        this.loyaltyTabPage.enterChangePasswordModalNewPasswordAgain("newpasswordb");
        this.loyaltyTabPage.clickChangePasswordModalSaveButton();
        Assert.assertTrue(this.loyaltyTabPage.changePasswordModalPasswordsDoNOtMatchMessageTextContains(
                "The passwords do not match"), "Error message should contain 'The passwords do not match'.");

        this.loyaltyTabPage.clickChangePasswordModalCloseButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeInvisible();
    }

    @Test(description = "Verify change password")
    public void testChangePassword() {
        String memberId = "yazmin.zieme.95116@example.com";
        String originalPassword = this.defaultPassword;
        String newPassword = "NewPassword1!";

        String oauthToken = this.loyaltyV2Api.postOathTokenAndReturnToken();

        JsonPath responseJsonPath = this.loyaltyV2Api.postAuth(memberId, originalPassword, oauthToken);
        Assert.assertEquals(responseJsonPath.getString("profile.memberInfo.memberID"), memberId,
                "Member ID should be " + memberId);

        this.goToProfileLoyaltyTab(memberId, "Guest Portal");
        this.loyaltyTabPage.clickChangeLoyaltyMemberPasswordButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeVisible();
        this.loyaltyTabPage.enterChangePasswordModalNewPassword(newPassword);
        this.loyaltyTabPage.enterChangePasswordModalNewPasswordAgain(newPassword);
        this.loyaltyTabPage.clickChangePasswordModalSaveButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeInvisible();

        JsonPath responseJsonPath2 = this.loyaltyV2Api.postAuth(memberId, newPassword, oauthToken);
        Assert.assertEquals(responseJsonPath2.getString("profile.memberInfo.memberID"), memberId,
                "Member ID should be " + memberId);

        this.goToProfileLoyaltyTab(memberId, "Guest Portal");
        this.loyaltyTabPage.clickChangeLoyaltyMemberPasswordButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeVisible();
        this.loyaltyTabPage.enterChangePasswordModalNewPassword(originalPassword);
        this.loyaltyTabPage.enterChangePasswordModalNewPasswordAgain(originalPassword);
        this.loyaltyTabPage.clickChangePasswordModalSaveButton();
        this.loyaltyTabPage.waitForChangePasswordModalToBeInvisible();
    }
}