package com.myschool.learn.pages.phptravels;

import com.myschool.learn.configurations.ConfigPhpTravels;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    public boolean blogMenuItemIsVisible()
    {
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

    public void clickCompanyArrowIndictor()
    {
        this.companyMenuItemListArrow.click();
    }

    @FindBy(xpath = "//header[@id='header-waypoint-sticky']/div[2]/div/div/div/div[1]/nav/ul/li[4]/ul/li[1]/a")
    protected WebElement AboutUsMenuItem;

    public void clickAboutUs()
    {
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

    @FindBy(xpath = "//a[@class='text-center hotels active']")
    protected WebElement searchHotels;

    public void clickSearchHotels() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchHotels));
        this.searchHotels.click();
    }

    @FindBy(xpath = "//a[contains(@class,'text-center flights')]")
    protected WebElement searchFlights;

    public void clickSearchFlights() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchFlights));
        this.searchFlights.click();
    }

    public boolean flightSearchFormIsVisible() {
        return this.searchFlights.isDisplayed();
    }

    @FindBy(xpath = "//label[contains(text(),'One Way')]")
    protected WebElement oneWayTrip;

    public void clickOneWayTrip() {
        this.wait.until(ExpectedConditions.visibilityOf(this.oneWayTrip));
        this.oneWayTrip.click();
    }

    @FindBy(xpath = "//label[contains(text(),'Round Trip')]")
    protected WebElement roundTrip;

    public void clickRoundTrip() {
        this.wait.until(ExpectedConditions.visibilityOf(this.roundTrip));
        this.roundTrip.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Economy')]")
    protected WebElement cabinClass;

    public void selectCabinClass(String cabinClass) {
        this.wait.until(ExpectedConditions.visibilityOf(this.cabinClass));
        Select select = new Select(this.cabinClass);
        select.selectByVisibleText(cabinClass);
    }

    @FindBy(xpath = "//div[@id='s2id_location_from']//a[@class='select2-choice']")
    protected WebElement fromCityAirportField;

    public void clickFromCityAirportField() {
        this.fromCityAirportField.click();
    }

    @FindBy(xpath = "//input[@class='select2-input select2-focused']")
    protected WebElement fromCityAirport;

    public void enterFromCityAirport(String fromCity) {
        this.fromCityAirport.sendKeys(fromCity);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'(EWR)')]")));
        this.fromCityAirport.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//div[@id='s2id_location_to']//a[@class='select2-choice']")
    protected WebElement toCityAirportField;

    public void clickToCityAirportField() {
        this.toCityAirportField.click();
    }

    @FindBy(xpath = "//input[@class='select2-input select2-focused']")
    protected WebElement toCityAirport;

    public void enterToCityAirport(String toCity) {
        this.toCityAirport.sendKeys(toCity);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'(DEL)')]")));
        this.toCityAirport.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath="//input[@id='FlightsDateStart']")
    protected WebElement departDateField;

    public void clickDepartDateField() {
        this.wait.until(ExpectedConditions.visibilityOf(this.departDateField));
        this.departDateField.click();
    }

    @FindBy(xpath="//input[@id='FlightsDateEnd']")
    protected WebElement returnDateField;

    public void clickReturnDateField() {
        this.wait.until(ExpectedConditions.visibilityOf(this.returnDateField));
        this.returnDateField.click();
    }

    @FindBy(xpath="//div[7]//nav[1]//div[2]")
    protected WebElement currentYearMonth;

    public String getCurrentMonthYear() {
    }

    @FindBy(xpath="//div[@id='datepickers-container']")
    protected WebElement datePicker;

    public void setDepartDate() {
        this.wait.until(ExpectedConditions.visibilityOf(this.datePicker));
    }

    @FindBy(xpath = "//a[contains(@class,'text-center tours')]")
    protected WebElement searchTours;

    public void clickSearchTours() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTours));
        this.searchTours.click();
    }

    @FindBy(xpath = "//a[contains(@class,'text-center transfer')]")
    protected WebElement searchTransfer;

    public void clickSearchTransfer() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTransfer));
        this.searchTransfer.click();
    }

    @FindBy(xpath = "//a[contains(@class,'text-center visa')]")
    protected WebElement searchVisa;

    public void clickSearchVisa() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchVisa));
        this.searchVisa.click();
    }
}

