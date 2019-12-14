package com.myschool.learn.phptravels.tests.navigation;

import com.myschool.learn.phptravels.pages.HomePage;
import com.myschool.learn.phptravels.tests.BaseFunctionalTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationTest extends BaseFunctionalTest {
    protected HomePage homePage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.homePage = new HomePage(this.driver, configPhpTravels);
    }

    @Test(description = "Test Navigate to Homepage")
    public void testNavigationToHomepage() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        Assert.assertTrue(this.homePage.homePageTitleIsVisible(), "Homepage Title is Visible");
        Assert.assertTrue(this.homePage.homePageTitle.getAttribute("alt").contains("PHPTRAVELS | Travel Technology Partner"), "HomePage Title is Valid");

    }

    @Test(description = "Test Navigate to Home via Homepage ")
    public void testNavigationToHome() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.clickHome();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net"), "Home Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Blog ")
    public void testNavigationToBlog() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.clickBlog();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/blog"), "Blog Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Offers ")
    public void testNavigationToOffers() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.clickOffers();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/offers"), "Offers Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to About Us ")
    public void testNavigationToAboutUs() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.hoverOverCompanyDropDownList();
        this.homePage.clickAboutUs();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/about-Us"), "About Us Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Contact Us ")
    public void testNavigationToContactUs() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.hoverOverCompanyDropDownList();
        this.homePage.clickContactUs();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/contact-Us"), "Contact Us Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Terms & Conditions ")
    public void testNavigationToTermsAndConditions() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.hoverOverCompanyDropDownList();
        this.homePage.clickTermsAndConditions();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/terms-of-use"), "Terms & Conditions Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Privacy Policy ")
    public void testNavigationToPrivacyPolicy() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.hoverOverCompanyDropDownList();
        this.homePage.clickPrivacyPolicy();
       Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/privacy-policy"), "Privacy Policy Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Login Page ")
    public void testNavigationToLogin() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.clickMyAccount();
        this.homePage.selectLoginOption();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/login"), "Login Page Url is Valid");
    }

    @Test(description = "Test Navigate to SignUp Page ")
    public void testNavigationToSignUp() {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.clickMyAccount();
        this.homePage.selectSignUpOption();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/register"), "SignUp Page Url is Valid");
    }
}
