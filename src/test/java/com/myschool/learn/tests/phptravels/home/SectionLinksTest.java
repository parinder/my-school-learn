package com.myschool.learn.tests.phptravels.home;

import com.myschool.learn.pages.phptravels.HomePage;
import com.myschool.learn.tests.phptravels.BaseFunctionalTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SectionLinksTest extends BaseFunctionalTest {
    protected HomePage homePage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.homePage = new HomePage(this.driver, configPhpTravels);
    }

    @Test(description = "Test Select User Currency From Currency DropDown")
    public void testChooseUserCurrency(){
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.clickCurrency();
        this.homePage.selectCurrency("INR");
    }
    @Test(description = "Test Select User Currency From Currency DropDown")
    public void testChooseUserLanguage() throws InterruptedException {
        this.homePage.get();
        this.homePage.waitForPageLoad();
        this.homePage.clickLanguage();
        this.homePage.selectLanguage("ru");
        System.out.println(this.driver.getCurrentUrl());
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://www.phptravels.net/ru"), "Russian Language Url is Valid");

    }

}
