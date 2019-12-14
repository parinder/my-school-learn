package com.myschool.learn.gms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myschool.learn.gms.configuration.Config;

public class NavigationBarPage extends BasePage {

    public NavigationBarPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homeMenuItem));
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutMenuItem));
        this.wait.until(ExpectedConditions.visibilityOf(this.helpMenuItem));
    }

    public void waitForRezQueuePageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.sectionsMenuItem));
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutMenuItem));
        this.wait.until(ExpectedConditions.visibilityOf(this.helpMenuItem));
    }

    // Home
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='home']")
    protected WebElement homeMenuItem;

    public boolean homeMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homeMenuItem));
        return this.helpMenuItem.isDisplayed();
    }

    public void clickHome() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homeMenuItem));
        this.homeMenuItem.click();
    }

    // Sections
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='sections']")
    protected WebElement sectionsMenuItem;

    public boolean sectionsMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.sectionsMenuItem));
        return this.sectionsMenuItem.isDisplayed();
    }

    // Campaign
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='Campaign']")
    protected WebElement campaignMenuItem;

    public boolean campaignMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.campaignMenuItem));
        return this.campaignMenuItem.isDisplayed();
    }

    // Create Email
    @FindBy(xpath = "//a[contains(text(),'Create Email')]")
    protected WebElement createEmailMenuItem;

    public boolean createEmailMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.createEmailMenuItem));
        return this.createEmailMenuItem.isDisplayed();
    }

    public void hoverOverCreateEmailMenuItem() {
        this.wait.until(ExpectedConditions.visibilityOf(this.createEmailMenuItem));
        Actions action = new Actions(this.driver);
        action.moveToElement(this.createEmailMenuItem).perform();
    }

    @FindBy(xpath = "//a[contains(text(),'New Scheduled Email')]")
    protected WebElement createEmailNewScheduledEmailMenuItem;

    public void clickCreateEmailNewScheduledEmailMenuItem() {
        this.wait.until(ExpectedConditions.visibilityOf(this.createEmailNewScheduledEmailMenuItem));
        this.createEmailNewScheduledEmailMenuItem.click();
    }

    // File

    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='File']")
    protected WebElement fileMenuItem;

    public boolean fileMenuItemIsVisible() {
        return this.fileMenuItem.isDisplayed();
    }

    public void hoverOverFileMenuItem() {
        this.wait.until(ExpectedConditions.visibilityOf(this.fileMenuItem));
        Actions action = new Actions(this.driver);
        action.moveToElement(this.fileMenuItem).perform();
    }

    // File --> List Owner PMS Manager

    @FindBy(xpath = "//ul[@class='secondLevel']/li/a[contains(text(),'List Owner PMS Manager')]")
    protected WebElement fileListOwnerPmsManagerMenuItem;

    public void clickFileListOwnerPmsManagerMenuItem() {
        this.wait.until(ExpectedConditions.visibilityOf(this.fileListOwnerPmsManagerMenuItem));
        this.fileListOwnerPmsManagerMenuItem.click();
    }

    // File --> Property Manager

    @FindBy(xpath = "//ul[@class='secondLevel']/li/a[contains(text(),'Property Manager')]")
    protected WebElement filePropertyManagerMenuItem;

    public void clickFilePropertyManagerMenuItem() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filePropertyManagerMenuItem));
        this.filePropertyManagerMenuItem.click();
    }

    // Libraries
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='Libraries']")
    protected WebElement librariesMenuItem;

    public boolean librariesMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.librariesMenuItem));
        return this.librariesMenuItem.isDisplayed();
    }

    // Preferences
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='Preferences']")
    protected WebElement preferencesMenuItem;

    public boolean preferencesMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.preferencesMenuItem));
        return this.preferencesMenuItem.isDisplayed();
    }

    // Admin
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='Admin']")
    protected WebElement adminMenuItem;

    public boolean adminMenuItemIsVisible() {
        return this.adminMenuItem.isDisplayed();
    }

    public void hoverOverAdminMenuItem() {
        this.wait.until(ExpectedConditions.visibilityOf(this.adminMenuItem));
        Actions action = new Actions(this.driver);
        action.moveToElement(this.adminMenuItem).build().perform();
    }

    public void clickAdminMenuItem() {
        this.wait.until(ExpectedConditions.visibilityOf(this.adminMenuItem));
        this.adminMenuItem.click();
    }

    // Manage users
    @FindBy(xpath = "//ul[@class='secondLevel']/li/a[text()='Manage Users']")
    protected WebElement manageUsersSubMenuItem;

    public void clickManageUsersSubmenuItem() {
        new WebDriverWait(this.driver, 50).until(ExpectedConditions.visibilityOf(this.manageUsersSubMenuItem));
        this.manageUsersSubMenuItem.click();
    }

    // List Settings
    @FindBy(xpath = "//ul[@class='secondLevel']/li/a[text()='List Settings']")
    protected WebElement listSettingsSubMenuItem;

    public void clickListSettingsSubMenuItem() {
        new WebDriverWait(this.driver, 50).until(ExpectedConditions.visibilityOf(this.listSettingsSubMenuItem));
        this.listSettingsSubMenuItem.click();
    }

    // Logout
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a[text()='Logout']")
    protected WebElement logoutMenuItem;

    public boolean logoutMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutMenuItem));
        return this.logoutMenuItem.isDisplayed();
    }

    public void clickLogoutMenuItem() {
        new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.logoutMenuItem));
        this.logoutMenuItem.click();
    }

    // Help
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='Help']")
    protected WebElement helpMenuItem;

    // Reports
    @FindBy(xpath = "//div[@id='zdirect_bar']/ul/li/a/span[@class='Reports']")
    protected WebElement reportsMenuItem;

    public boolean reportsMenuItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reportsMenuItem));
        return this.reportsMenuItem.isDisplayed();
    }

    // List Name
    @FindBy(xpath = "//li[@class='listName']")
    protected WebElement listName;

    public String getListName() {
        this.wait.until(ExpectedConditions.visibilityOf(this.listName));
        return this.listName.getText();
    }
}
