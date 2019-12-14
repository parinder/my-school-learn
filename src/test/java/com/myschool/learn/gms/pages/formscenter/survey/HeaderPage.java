package com.myschool.learn.gms.pages.formscenter.survey;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class HeaderPage extends BasePage {

	public HeaderPage(WebDriver driver, Config config) {
		super(driver, config);
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.formsCenterTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyNameSubTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.renameSurveyIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyPagesTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.thankYouPagesTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.settingsTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.reportsTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.questionManagerIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyListIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.listOfSurveysDropdown));
	}

	// forms center title

	@FindBy(xpath = "//div[@id='header']/div[@id='header2']/div[@id='title_container']/div[@class='margins twoLines']/h1")
	protected WebElement formsCenterTitle;

	// survey name subtitle

	@FindBy(xpath = "//div[@id='header']/div[@id='header2']/div[@id='title_container']/div[@class='margins twoLines']/h2")
	protected WebElement surveyNameSubTitle;

	public String getSurveyNameSubtitleText() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyNameSubTitle));
		return this.surveyNameSubTitle.getText();
	}

	@FindBy(xpath = "//div[@id='header']/div[@id='header2']/div[@id='title_container']/div[@class='margins twoLines']/a/img")
	protected WebElement renameSurveyIcon;

	public void clickRenameSurveyIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(this.renameSurveyIcon));
		this.renameSurveyIcon.click();
	}

	// header survey pages tab

	@FindBy(xpath = "//div[@id='tab_survey_pages']")
	protected WebElement surveyPagesTab;

	public void clickSurveyPagesTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyPagesTab));
		this.surveyPagesTab.click();
	}

	public boolean surveyPagesTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyPagesTab));
		return this.surveyPagesTab.getAttribute("class").contains("current");
	}

	// header thank you pages tab

	@FindBy(xpath = "//div[@id='tab_thankyou_pages']")
	protected WebElement thankYouPagesTab;

	public void clickThankYouPagesTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.thankYouPagesTab));
		this.thankYouPagesTab.click();
	}

	public boolean thankYouPagesTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.thankYouPagesTab));
		return this.thankYouPagesTab.getAttribute("class").contains("current");
	}

	// header settings tab

	@FindBy(xpath = "//div[@id='tab_settings']")
	protected WebElement settingsTab;

	public void clickSettingsTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.settingsTab));
		this.settingsTab.click();
	}

	public boolean settingsTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.settingsTab));
		return this.settingsTab.getAttribute("class").contains("current");
	}

	// header reports tab

	@FindBy(xpath = "//div[@id='tab_reports']")
	protected WebElement reportsTab;

	public void clickReportsTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.reportsTab));
		this.reportsTab.click();
	}

	public boolean reportsTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.reportsTab));
		return this.reportsTab.getAttribute("class").contains("current");
	}

	// header question manager icon

	@FindBy(xpath = "//span[@class='questMan']")
	protected WebElement questionManagerIcon;

	public void clickQuestionManagerIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(this.questionManagerIcon));
		this.questionManagerIcon.click();
	}

	@FindBy(xpath = "//span[@class='surveyList']")
	protected WebElement surveyListIcon;

	public void clickSurveyListIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyListIcon));
		this.surveyListIcon.click();
	}

	// list of surveys dropdown

	@FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
	protected WebElement listOfSurveysDropdown;

	@FindBy(xpath = "//span[contains(@class,'dropdown')]//span//input[contains(@type,'search')]")
	protected WebElement listofSurveysInput;

	public void selectListOFSurveysDropdwonOption(String surveyName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.listOfSurveysDropdown));
		this.listOfSurveysDropdown.click();
		this.listofSurveysInput.sendKeys(surveyName);
		this.listofSurveysInput.sendKeys(Keys.ARROW_DOWN);
		this.listofSurveysInput.sendKeys(Keys.ENTER);
	}
}