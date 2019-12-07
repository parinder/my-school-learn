package com.myschool.learn.tests.phptravels.navigation;

import com.myschool.learn.pages.phptravels.HomePage;
import com.myschool.learn.tests.phptravels.BaseFunctionalTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationTest extends BaseFunctionalTest {
    protected HomePage homepage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.homepage = new HomePage(this.driver, configPhpTravels);
    }

    @Test(description = "Test Navigate to Homepage")
    public void testNavigationToHomepage() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        Assert.assertTrue(this.homepage.homePageTitleIsVisible(), "Homepage Title is Visible");
        Assert.assertTrue(this.homepage.homePageTitle.getAttribute("alt").contains("PHPTRAVELS | Travel Technology Partner"), "HomePage Title is Valid");

    }

    @Test(description = "Test Navigate to Home ")
    public void testNavigationToHome() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        this.homepage.clickHome();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net"), "Home Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Blog ")
    public void testNavigationToBlog() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        this.homepage.clickBlog();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/blog"), "Blog Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Offers ")
    public void testNavigationToOffers() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        this.homepage.clickOffers();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/offers"), "Offers Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to About Us ")
    public void testNavigationToAboutUs() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        this.homepage.hoverOverCompanyDropDownList();
        this.homepage.clickAboutUs();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/about-Us"), "About Us Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Contact Us ")
    public void testNavigationToContactUs() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        this.homepage.hoverOverCompanyDropDownList();
        this.homepage.clickContactUs();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/contact-Us"), "Contact Us Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Terms & Conditions ")
    public void testNavigationToTermsAndConditions() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        this.homepage.hoverOverCompanyDropDownList();
        this.homepage.clickTermsAndConditions();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/terms-of-use"), "Terms & Conditions Menu Item Url is Valid");
    }

    @Test(description = "Test Navigate to Privacy Policy ")
    public void testNavigationToPrivacyPolicy() {
        this.homepage.get();
        this.homepage.waitForPageLoad();
        this.homepage.hoverOverCompanyDropDownList();
        this.homepage.clickPrivacyPolicy();
       Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/privacy-policy"), "Privacy Policy Menu Item Url is Valid");
    }
}
