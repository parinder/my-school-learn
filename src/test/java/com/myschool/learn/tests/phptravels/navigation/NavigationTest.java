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
}
