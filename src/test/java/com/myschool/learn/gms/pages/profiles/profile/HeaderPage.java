package com.myschool.learn.gms.pages.profiles.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    @FindBy(xpath = "//div[@id='profileHeader']/div[@class='profile-header row']/div/div[@class='header-fullname']")
    protected WebElement mainProfileFullName;

    public String getMainProfileFullName() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mainProfileFullName));
        return this.mainProfileFullName.getText();
    }

    @FindBy(xpath = "//div[@id='profileHeader']/div[@class='profile-header row']/div/div[@class='information-text']")
    protected WebElement mainProfileInformation;

    public String getMainProfileInformation() {
        new WebDriverWait(this.driver, 50).until(ExpectedConditions.visibilityOf(this.mainProfileInformation));
        return this.mainProfileInformation.getText();
    }
    
    @FindBy(xpath = "//span[@class='opt-in-status opted-out']//a[@class='opt-in-btn']")
    protected WebElement optedOutLink;

    public void clickOptedOutLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.optedOutLink));
        this.optedOutLink.click();
    }

    public boolean optedOutLinkIsVisible() {
        return this.optedOutLink.isDisplayed();
    }

    @FindBy(xpath = "//span[@class='opt-in-status ']//a[@class='opt-in-btn']")
    protected WebElement optedInLink;

    public void clickOptedInLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.optedInLink));
        this.optedInLink.click();
    }

    public boolean optedInLinkIsVisible() {
        return this.optedInLink.isDisplayed();
    }

    @FindBy(xpath = "//a[@class='merge-profile']")
    protected WebElement mergeProfileLink;

    public void clickMergeProfileLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeProfileLink));
        this.mergeProfileLink.click();
    }

    @FindBy(xpath = "//li[@id='overviewTabLi']")
    protected WebElement profileOverviewTab;

    public boolean profileOverviewTabIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileOverviewTab));
        return this.profileOverviewTab.getAttribute("class").contains("active");
    }

    public void clickProfileOverviewTab() {
	this.wait.until(ExpectedConditions.visibilityOf(this.profileOverviewTab));
	this.profileOverviewTab.click();
    }

    @FindBy(xpath = "//li[@id='detailsTabLi']")
    protected WebElement profileDetailsTab;

    public void clickProfileDetailsTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileDetailsTab));
        this.profileDetailsTab.click();
    }

    @FindBy(xpath = "//li[@id='surveysTabLi']")
    protected WebElement profileSurveysTab;

    public void clickProfileSurveysTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileSurveysTab));
        this.profileSurveysTab.click();
    }

    @FindBy(xpath = "//li[@id='marketingTabLi']")
    protected WebElement profileTimelineTab;

    public void clickProfileTimelineTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileTimelineTab));
        this.profileTimelineTab.click();
    }

    @FindBy(xpath = "//li[@id='reservationsTabLi']")
    protected WebElement profileReservationsTab;

    public boolean profileReservationsTabIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileReservationsTab));
        return this.profileReservationsTab.getAttribute("class").contains("active");
    }

    @FindBy(xpath = "//li[@id='loyaltyTabLi']")
    protected WebElement profileloyaltyTab;

    public void clickProfileLoyaltyTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileloyaltyTab));
        this.profileloyaltyTab.click();
    }

    public boolean profileLoyaltyTabIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileloyaltyTab));
        return this.profileloyaltyTab.getAttribute("class").contains("active");
    }

    @FindBy(xpath = "//li[@id='engagementTabLi']")
    protected WebElement profileMessengerTab;

    public void clickProfileMessengerTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileMessengerTab));
        this.profileMessengerTab.click();
    }
}