package com.myschool.learn.gms.pages.profiles.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class SurveysTabPage extends BasePage {

    public SurveysTabPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.surveysTabContainer));
        this.wait.until(ExpectedConditions.visibilityOf(this.gssSurveyEntries));
        this.wait.until(ExpectedConditions.visibilityOf(this.guestSatisfactionEntriesSectionHeader));
        this.wait.until(ExpectedConditions.visibilityOf(this.formSubmissionsSectionHeader));
    }

    @FindBy(xpath = "//div[@id='surveysTab' and contains(@class, 'active')]")
    protected WebElement surveysTabContainer;

    // GSS survey entries

    @FindBy(xpath = "//div[@id='surveysTab']/div/div[1]/div[1]/div/div[2]/div/div/span[1]")
    protected WebElement gssSurveyEntries;

    public String getGssSurveyEntriesText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.gssSurveyEntries));
        return this.gssSurveyEntries.getText();
    }

    // guest satisfaction entries

    @FindBy(xpath = "//div[@class='widget-header bg-blue']/span/b[contains(text(), 'Guest Satisfaction Entries')]")
    protected WebElement guestSatisfactionEntriesSectionHeader;

    // form submissions section

    @FindBy(xpath = "//div[@class='widget-header bg-blue']/span/b[contains(text(), 'Form Submissions')]")
    protected WebElement formSubmissionsSectionHeader;
}
