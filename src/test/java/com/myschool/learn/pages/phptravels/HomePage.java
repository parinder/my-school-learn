package com.myschool.learn.pages.phptravels;

import com.myschool.learn.configurations.ConfigPhpTravels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='header-logo go-right']//a//img")
    public WebElement homePageTitle;


    public HomePage(WebDriver driver, ConfigPhpTravels configPhpTravels) {
        super(driver, configPhpTravels);
        this.url = this.configPhpTravels.getProperty("app.phptravels.baseurl");
    }

    public void waitForPageLoad() {

        this.wait.until(ExpectedConditions.visibilityOf(this.homePageTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.homeMenuItem));
        this.wait.until(ExpectedConditions.visibilityOf(this.blogMenuItem));
        this.wait.until(ExpectedConditions.visibilityOf(this.offersMenuItem));
        this.wait.until(ExpectedConditions.visibilityOf(this.companyMenuItem));
    }

    public boolean homePageTitleIsVisible() {
        return this.homePageTitle.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]")
    public WebElement homeMenuItem;

    public void clickHome() {
        this.homeMenuItem.click();
    }

    public boolean homeMenuItemIsVisible() {
        return this.homeMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]")
    public WebElement blogMenuItem;

    public void clickBlog() {
        this.blogMenuItem.click();
    }

    public boolean blogMenuItemIsVisible() {
        return this.blogMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")
    public WebElement offersMenuItem;

    public void clickOffers() {
        this.offersMenuItem.click();
    }

    public boolean offersMenuItemIsVisible() {
        return this.offersMenuItem.isDisplayed();
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div/div/div/div[1]/nav/ul/li[4]/a")
    public WebElement companyMenuItem;

    @FindBy(xpath = "//span[@class='arrow-indicator']")
    public WebElement companyMenuItemListArrow;

    public void hoverOverCompanyDropDownList() {
        Actions action=new Actions(this.driver);
        action.moveToElement(companyMenuItem).click().build().perform();
        this.wait.until(ExpectedConditions.visibilityOf(this.privacyPolicyMenuItem));
    }

    public boolean companyMenuItemIsVisible() {
        return this.companyMenuItem.isDisplayed();
    }

    public void clickCompanyArrowIndictor() {
        this.companyMenuItemListArrow.click();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[1]/a")
    public WebElement AboutUsMenuItem;

    public void clickAboutUs() {
        this.AboutUsMenuItem.click();
    }

    public boolean AboutUsMenuItemIsVisible() {
        return this.AboutUsMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[2]/a")
    public WebElement contactUsMenuItem;

    public void clickContactUs() {
        this.contactUsMenuItem.click();
    }

    public boolean contactUsMenuItemIsVisible() {
        return this.contactUsMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[3]/a")
    public WebElement termsAndConditionsMenuItem;

    public void clickTermsAndConditions() {
        this.termsAndConditionsMenuItem.click();
    }

    public boolean termsAndConditionsMenuItemIsVisible() {
        return this.termsAndConditionsMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[4]/a")
    public WebElement privacyPolicyMenuItem;

    public void clickPrivacyPolicy() {
        this.privacyPolicyMenuItem.click();
    }

    public boolean privacyPolicyMenuItemIsVisible() {
        return this.privacyPolicyMenuItem.isDisplayed();
    }
}

