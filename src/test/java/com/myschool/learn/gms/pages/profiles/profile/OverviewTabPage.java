package com.myschool.learn.gms.pages.profiles.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class OverviewTabPage extends BasePage {

    public OverviewTabPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.overviewTabContainer));
        this.wait.until(ExpectedConditions.visibilityOf(this.gssSurveyEntries));
        this.wait.until(ExpectedConditions.visibilityOf(this.ytdEmails));
        this.wait.until(ExpectedConditions.visibilityOf(this.worflows));
    }

    @FindBy(xpath = "//div[@id='overviewTab' and contains(@class, 'active')]")
    protected WebElement overviewTabContainer;

    // GSS survey entries

    @FindBy(xpath = "//div/span[@class='databox-text sonic-silver no-margin' and contains(text(),'GSS SURVEY ENTRIES')]/../span[@class='databox-number lightcarbon']")
    protected WebElement gssSurveyEntries;

    // ytd emails

    @FindBy(xpath = "//div/span[@class='databox-text sonic-silver no-margin' and contains(text(),'YTD EMAILS')]/../span[@class='databox-number lightcarbon']")
    protected WebElement ytdEmails;

    // workflows

    @FindBy(xpath = "//div/span[@class='databox-text sonic-silver no-margin' and contains(text(),'WORKFLOWS')]/../span[@class='databox-number lightcarbon']")
    protected WebElement worflows;

    // house mebership number

    @FindBy(xpath = "//div/span[@class='databox-text sonic-silver no-margin' and contains(text(),'HOUSE MEMBERSHIP NUMBER')]/../span[@class='databox-number lightcarbon']")
    protected WebElement houseMembershipNumber;

    public String getHouseMembershipNumber() {
        this.wait.until(ExpectedConditions.visibilityOf(this.houseMembershipNumber));
        return this.houseMembershipNumber.getText().trim();
    }

    public void waitForHouseMembershipNumberToBeInvisible(){
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div/span[@class='databox-text sonic-silver no-margin' and contains(text(),'HOUSE MEMBERSHIP NUMBER')]/../span[@class='databox-number lightcarbon']")));
    }
    
    // most visited property name

    @FindBy(xpath = "//div/span[@class='databox-text sonic-silver no-margin' and text()='MOST VISITED PROPERTY']/../span[@class='databox-number lightcarbon']")
    protected WebElement mostVisitedProperty;

    public String getMostVisitedPropertyName() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mostVisitedProperty));
        return this.mostVisitedProperty.getText().trim();
    }
}
