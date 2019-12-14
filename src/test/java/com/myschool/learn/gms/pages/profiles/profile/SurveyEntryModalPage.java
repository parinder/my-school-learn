package com.myschool.learn.gms.pages.profiles.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class SurveyEntryModalPage extends BasePage {

	public SurveyEntryModalPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "manageUsers";
	}

	public void waitToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.headerXButton));
	}

	public void waitToBeInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.headerTitle));
		this.wait.until(ExpectedConditions.invisibilityOf(this.headerXButton));
	}

	// title

	@FindBy(xpath = "//div[@class='modal-header']/h4[@class='modal-title' and contains(text(),'Survey Entry')]")
	protected WebElement headerTitle;

	// header 'x' button

	@FindBy(xpath = "//div[@class='modal-header']/button[@class='close']")
	protected WebElement headerXButton;

	public void clickHeaderXButton() {
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.headerXButton));
		this.headerXButton.click();
	}

	// details tab

	@FindBy(xpath = "//div[@class='modal-body']/ul[@id='viewSurveyEntryTab']/li/a[contains(text(),'Details')]")
	protected WebElement detailsTab;

	public void clickDetailsTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.detailsTab));
		this.detailsTab.click();
	}

	// communications tab

	@FindBy(xpath = "//div[@class='modal-body']/ul[@id='viewSurveyEntryTab']/li/a[contains(text(),'Communications')]")
	protected WebElement communicationsTab;

	public void clickCommunicationsTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.detailsTab));
		this.detailsTab.click();
	}

	// summary

	// name

	@FindBy(xpath = "//div[@id='viewSurveyEntryTab-details']/table[1]/tbody/tr[1]/td[2]")
	protected WebElement surveyName;

	public String getSummarySurvey() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyName));
		return this.surveyName.getText();
	}

	// date

	@FindBy(xpath = "//div[@id='viewSurveyEntryTab-details']/table[1]/tbody/tr[2]/td[2]")
	protected WebElement surveyDate;

	public String getSummaryEntryDate() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyDate));
		return this.surveyDate.getText();
	}

	// score

	@FindBy(xpath = "//div[@id='viewSurveyEntryTab-details']/table[1]/tbody/tr[3]/td[2]")
	protected WebElement surveyScore;

	public String getSummaryScore() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyScore));
		return this.surveyScore.getText();
	}

	// response details

	public String getQuestionAnswer(String questionText) {
		String xpath = "//div[@id='viewSurveyEntryTab-details']/table[2]/tbody/tr/td[contains(text(), '" + questionText
				+ "')]/../td[2]";
		WebElement element = this.driver.findElement(By.xpath(xpath));
		return element.getText();
	}

	// close button

	@FindBy(xpath = "//div[@class='modal-footer']/button[@class='btn btn-default btn-close']")
	protected WebElement closeButton;

	public void clickCloseButton() {
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.closeButton));
		this.closeButton.click();
	}
}
