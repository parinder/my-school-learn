package com.myschool.learn.pages.phptravels;

import com.myschool.learn.configurations.ConfigPhpTravels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
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
        this.wait.until(ExpectedConditions.visibilityOf(this.currencyDropDown));
        this.wait.until(ExpectedConditions.visibilityOf(this.languageDropDown));
        this.wait.until(ExpectedConditions.visibilityOf(this.myAccountOptions));
    }

    @FindBy(xpath = "//div[@class='header-logo go-right']//a//img")
    public WebElement homePageTitle;

    public boolean homePageTitleIsVisible() {
        return this.homePageTitle.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]")
    protected WebElement homeMenuItem;

    public void clickHome() {
        this.homeMenuItem.click();
    }

    public boolean homeMenuItemIsVisible() {
        return this.homeMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]")
    protected WebElement blogMenuItem;

    public void clickBlog() {
        this.blogMenuItem.click();
    }

    public boolean blogMenuItemIsVisible() {
        return this.blogMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")
    protected WebElement offersMenuItem;

    public void clickOffers() {
        this.offersMenuItem.click();
    }

    public boolean offersMenuItemIsVisible() {
        return this.offersMenuItem.isDisplayed();
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div/div/div/div[1]/nav/ul/li[4]/a")
    protected WebElement companyMenuItem;

    @FindBy(xpath = "//span[@class='arrow-indicator']")
    protected WebElement companyMenuItemListArrow;

    public void hoverOverCompanyDropDownList() {
        Actions action = new Actions(this.driver);
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
    protected WebElement AboutUsMenuItem;

    public void clickAboutUs() {
        this.AboutUsMenuItem.click();
    }

    public boolean AboutUsMenuItemIsVisible() {
        return this.AboutUsMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[2]/a")
    protected WebElement contactUsMenuItem;

    public void clickContactUs() {
        this.contactUsMenuItem.click();
    }

    public boolean contactUsMenuItemIsVisible() {
        return this.contactUsMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[3]/a")
    protected WebElement termsAndConditionsMenuItem;

    public void clickTermsAndConditions() {
        this.termsAndConditionsMenuItem.click();
    }

    public boolean termsAndConditionsMenuItemIsVisible() {
        return this.termsAndConditionsMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[4]/a")
    protected WebElement privacyPolicyMenuItem;

    public void clickPrivacyPolicy() {
        this.privacyPolicyMenuItem.click();
    }

    public boolean privacyPolicyMenuItemIsVisible() {
        return this.privacyPolicyMenuItem.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='dropdown dropdown-currency']//a[@id='dropdownCurrency']")
    protected WebElement currencyDropDown;

    public void clickCurrency() {
        this.currencyDropDown.click();
    }

    public void selectCurrency(String currencyCode) {
        Actions action = new Actions(this.driver);
        WebElement languageCode = this.driver.findElement(By.xpath("//a[contains(text(),'" + currencyCode + "')]"));
        action.moveToElement(languageCode).click().build().perform();
    }

    @FindBy(xpath = "//div[@class='dropdown dropdown-language']")
    protected WebElement setLanguage;

    public void clickLanguage() {
        this.setLanguage.click();
    }

    @FindBy(xpath = "//a[@id='dropdownLangauge']")
    protected WebElement languageDropDown;


    public void selectLanguage(String langCode) {
        this.wait.until(ExpectedConditions.visibilityOf(this.languageDropDown));
        Actions action = new Actions(this.driver);
        WebElement languageCode = this.driver.findElement(By.xpath("//a[@id='" + langCode + "']"));
        action.moveToElement(languageCode).click().build().perform();
        this.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/" + langCode + ""));
    }

    @FindBy(xpath = "//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")
    protected WebElement myAccountOptions;

    public void clickMyAccount() {
        this.myAccountOptions.click();
    }

    @FindBy(xpath = "//a[@class='dropdown-item active tr']")
    protected WebElement myAccountLogin;


    public void selectLoginOption() {
        this.wait.until(ExpectedConditions.visibilityOf(this.myAccountLogin));
        Actions action = new Actions(this.driver);
        action.moveToElement(myAccountLogin).click().build().perform();
        this.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/login"));
    }

    @FindBy(xpath = "//a[@class='dropdown-item tr']")
    protected WebElement myAccountSignUp;


    public void selectSignUpOption() {
        this.wait.until(ExpectedConditions.visibilityOf(this.myAccountSignUp));
        Actions action = new Actions(this.driver);
        action.moveToElement(myAccountSignUp).click().build().perform();
        this.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/register"));
    }
}

