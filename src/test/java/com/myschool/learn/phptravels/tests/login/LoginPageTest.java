package com.myschool.learn.phptravels.tests.login;

import com.myschool.learn.phptravels.pages.login.LoginPage;
import com.myschool.learn.phptravels.tests.BaseFunctionalTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends BaseFunctionalTest {
    protected LoginPage loginPage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.loginPage = new LoginPage(this.driver, configPhpTravels);
    }

    @Test(description = "Test to Login With Existing Profile")
    public void testLoginWithExistingProfile() {
        this.loginPage.get();
        this.loginPage.waitForPageLoad();
        this.loginPage.enterEmail("lilly.tamara@example.com");
        this.loginPage.enterPassword("Quality1!");
        this.loginPage.clickLoginButton();
        this.loginPage.getSuccessLoginUrl();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/account/"), "Login success Url is Valid");
        Assert.assertTrue(this.loginPage.getFirstLastName().contains("Hi, Lilly Tamara"), "Profile Contains the Valid First & Last Name");
    }

    @Test(description = "Test to Login With Non Existing Profile")
    public void testLoginWithNonExistingProfile() {
        this.loginPage.get();
        this.loginPage.waitForPageLoad();
        this.loginPage.enterEmail("xxxx.xxxx@xxx.com");
        this.loginPage.enterPassword("xxxxx!");
        this.loginPage.clickLoginButton();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/login"), "Login Un-success Url is Valid");
        Assert.assertTrue(this.loginPage.getLoginErrorMessage().contains("Invalid Email or Password"), "Login Contains Invalid email & password");
    }
}
