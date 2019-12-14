package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class ProfileCompletenessSetupPage extends BasePage {

    public ProfileCompletenessSetupPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "profileCompleteness";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCompletenessSetupLink));
     }

    @FindBy(xpath = "//ul[@class='breadcrumb']//li//a[text()='Profile Completeness Setup']")
    protected WebElement profileCompletenessSetupLink;

    public boolean profileCompletenessSetupLinkIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCompletenessSetupLink));
        return this.profileCompletenessSetupLink.isDisplayed();
    }

    @FindBy(xpath = "//a[@id='addGroupBtn']")
    protected WebElement addCategoryLink;

    public boolean addCategoryLinkIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addCategoryLink));
        return this.addCategoryLink.isDisplayed();
    }
}