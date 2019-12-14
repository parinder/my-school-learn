package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class LoyaltyDashboardPage extends BasePage {

    public LoyaltyDashboardPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "loyalty/membershipPrograms/";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.membershipProgramsTitle));
     }

    @FindBy(xpath = "//div[@id='title_container']//div//h1[text()='Membership Programs']")
    protected WebElement membershipProgramsTitle;

    public boolean membershipProgramsTitleIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.membershipProgramsTitle));
        return this.membershipProgramsTitle.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='theList']")
    protected WebElement programsListContainer;

    public boolean programsListContainerIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.programsListContainer));
        return this.programsListContainer.isDisplayed();
    }
}