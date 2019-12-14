package com.myschool.learn.gms.pages.formscenter.survey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class SettingsTabPage extends BasePage {

	public SettingsTabPage(WebDriver driver, Config config) {
		super(driver, config);
	}

	public void waitForPageLoad() {
		this.driver.switchTo().frame("settingsIframe"); // switch to frame
		this.wait.until(ExpectedConditions.visibilityOf(this.surveySettingsTitle));
		this.driver.switchTo().defaultContent();
	}

	// survey settings title

	@FindBy(xpath = "//div[@class='centerFixedColumn']/h1[contains(text(),'Survey Settings')]")
	protected WebElement surveySettingsTitle;

	// survey status

	@FindBy(xpath = "//a[contains(@class,'accordion-toggle') and contains(text(),'Survey Status')]")
	protected WebElement surveyStatusSectionHeader;

	public void clickSurveyStatusSectionHeader() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyStatusSectionHeader));
		this.surveyStatusSectionHeader.click();
	}

	public boolean surveyStatusSectionIsCollapsed() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyStatusSectionHeader));
		return this.surveyStatusSectionHeader.getAttribute("class").contains("collapsed");
	}

	public void waitForSurevyStatusSectionToBeOpen() {
		this.wait.until(ExpectedConditions.visibilityOf(this.openButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.getCodeButton));
	}

	public void waitForSurevyStatusSectionToBeClosed() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.openButton));
		this.wait.until(ExpectedConditions.invisibilityOf(this.getCodeButton));
	}

	@FindBy(xpath = "//div[contains(@class,'status-on-off')]")
	protected WebElement currentStatusSlider;

	@FindBy(xpath = "//a[@id='surveyUrlOpen']")
	protected WebElement openButton;

	public void clickOpenButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.openButton));
		this.openButton.click();
	}

	@FindBy(xpath = "//a[@id='showCode']")
	protected WebElement getCodeButton;

	@FindBy(xpath = "//a[contains(@class,'switchSslSecure')]")
	protected WebElement secureUrlButton;

	@FindBy(xpath = "//a[contains(@class,'switchSslUnsecure')]")
	protected WebElement standardUrlButton;

	@FindBy(xpath = "//input[@name='doubleOptIn' and @value='0']/..")
	protected WebElement noOptInRadioButton;

	@FindBy(xpath = "//input[@name='doubleOptIn' and @value='1']/..")
	protected WebElement singleOptInRadioButton;

	@FindBy(xpath = "//input[@name='doubleOptIn' and @value='2']/..")
	protected WebElement confirmedOptInRadioButton;

	@FindBy(xpath = "//input[@name='profileFlagEnable' and @value='1']/..")
	protected WebElement profileUpdatingEnabledRadioButton;

	@FindBy(xpath = "//input[@name='profileFlagEnable' and @value='0']/..")
	protected WebElement profileUpdatingDisabledRadioButton;

	@FindBy(xpath = "//input[@name='alwaysNewSubmissionFlagEnable' and @value='2']/..")
	protected WebElement allowOnlyFirstSubmissionRadioButton;

	public void clickAllowOnlyFirstSubmissionRadioButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.allowOnlyFirstSubmissionRadioButton));
		this.allowOnlyFirstSubmissionRadioButton.click();
	}

	@FindBy(xpath = "//input[@name='alwaysNewSubmissionFlagEnable' and @value='1']/..")
	protected WebElement submitBrandNewSubmissionRadioButton;

	public void clickSubmitBrandNewSubmissionRadioButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.submitBrandNewSubmissionRadioButton));
		this.submitBrandNewSubmissionRadioButton.click();
	}

	@FindBy(xpath = "//input[@name='alwaysNewSubmissionFlagEnable' and @value='0']/..")
	protected WebElement updatePreviousSubmissionRadioButton;

	// multi list functionality radio buttons

	@FindBy(xpath = "//input[contains(@name,'multiListEnable')]/following-sibling::span[contains(text(),'Enabled')]")
	protected WebElement multiListFunctionalityEnabledRadioButton;

	@FindBy(xpath = "//input[contains(@name,'multiListEnable')]/following-sibling::span[contains(text(),'Disabled')]")
	protected WebElement multiListFunctionalityDisabledRadioButton;

	// survey cancel button

	@FindBy(xpath = "//button[contains(@rel,'survey-status') and contains(@class,'cancel')]")
	protected WebElement surveyCancelButton;

	public void clickSurveyCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyCancelButton));
		this.surveyCancelButton.click();
	}

	// survey save button

	@FindBy(xpath = "//button[contains(@rel,'survey-status') and contains(@class,'save')]")
	protected WebElement surveySaveButton;

	public void clickSurveySaveButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveySaveButton));
		this.surveySaveButton.click();
	}

	// saved toast

	@FindBy(xpath = "//button[contains(@class,'toast-close-button')]")
	protected WebElement toastCloseButton;

	public void clickToastCloseButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.toastCloseButton));
		this.toastCloseButton.click();
	}

	// submission actions section

	// 3rd party integration section

	// daily email alert configuration section

	// overlay

	@FindBy(xpath = "//div[@id='loading-overlay']")
	protected WebElement loadingOverlay;

	public void waitForLoadingOverlayToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loadingOverlay));
	}

	public void waitForLoadingOverlayToBeInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
	}

	public void waitForLoadingOverlay() {
		this.waitForLoadingOverlayToBeVisible();
		this.waitForLoadingOverlayToBeInvisible();
	}
}