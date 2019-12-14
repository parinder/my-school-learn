package com.gms.pages.pmscenter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class PmsRequestEditPage extends BasePage {

	@FindBy(xpath = "//div[@id='title_container']/div[@class='margins twoLines']/h1")
	public WebElement pmsTitle;

	@FindBy(xpath = "//div[@id='list_container']/div[@class='margins']/select")
	public WebElement pmsRequestsDropdownCaption;

	public PmsRequestEditPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "pmsCenter/pmsRequest";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.editPmsRequestTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerName));
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.cancelButton));
	}

	// loading modal

	@FindBy(xpath = "//div[@id='console']")
	protected WebElement loadingModal;

	public void waitForLoadingModalIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loadingModal));
	}

	public void waitForLoadingModalIsInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.loadingModal));
	}

	public void waitForLoadingModal() {
		this.waitForLoadingModalIsVisible();
		this.waitForLoadingModalIsInvisible();
	}

	// ******* PMS Request details on the left section********//

	// edit pms request page details on the left

	@FindBy(xpath = "//div[@class='sidebar']/h1[text()='Edit Pms Request']")
	protected WebElement editPmsRequestTitle;

	public boolean editPmsRequestTitleIsVisible() {
		return this.editPmsRequestTitle.isDisplayed();
	}

	public void clickEditPmsRequestTitle() {
		this.editPmsRequestTitle.click();
	}

	// list owner name

	@FindBy(xpath = "//div[@class='sidebar']/h2")
	protected WebElement listOwnerName;

	public String getListOwnerName() {
		return this.listOwnerName.getText();
	}

	// pms request name

	public String getPmsRequestName() {
		return this.listOwnerName.getText();
	}

	// pms request type

	@FindBy(xpath = "//div[@class='sidebar']/p[1]")
	protected WebElement pmsRequestType;

	public String pmsRequestType() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsRequestType));
		return this.pmsRequestType.getText();
	}

	@FindBy(xpath = "//div[@class='sidebar']/p/a[@class='icon_button']/span[@class='log']")
	protected WebElement showLogButton;

	public boolean showLogButtonIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.showLogButton));
		return this.showLogButton.isDisplayed();
	}

	// details on the right section

	// success alert

	@FindBy(xpath = "//div[@class='alert alert-success']")
	protected WebElement successAlert;

	public String getSuccessAlertMessageText() {
		this.wait.until(ExpectedConditions.visibilityOf(this.successAlert));
		return this.successAlert.getText();
	}

	@FindBy(xpath = "//div[@class='alert alert-success']/a[@class='close']")
	protected WebElement successAlertCloseIcon;

	public void clickSuccessAlertCloseIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(this.successAlert));
		this.successAlertCloseIcon.click();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@class='droplist selector statusSelector']/a/span[contains(@class,'status')]")
	protected WebElement statusDroplist;

	public String getStatus() {
		this.wait.until(ExpectedConditions.visibilityOf(this.statusDroplist));
		return this.statusDroplist.getText();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p[@id='testEmail']/input[@id='testEmailAddress']")
	protected WebElement testEmailAddressInput;

	public void EnterTestEmailAddress(String email) {
		this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				"//form[@id='pmsRequest']/div[@class='droplist selector statusSelector']/ul/li/a/span[@class='status off']")));
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form[@id='pmsRequest']/p[@id='testEmail']/input[@id='testEmailAddress']")));
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("document.getElementById('testEmailAddress').value='" + email + "';");
	}

	public void hoverOverStatusDroplist() {
		Actions action = new Actions(this.driver);
		action.moveToElement(statusDroplist).build().perform();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@class='droplist selector statusSelector']/ul/li/a/span[@class='status on']")
	protected WebElement onStatus;

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@class='droplist selector statusSelector']/ul/li/a/span[@class='status off']")
	protected WebElement offStatus;

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@class='droplist selector statusSelector']/ul/li/a/span[@class='status test']")
	protected WebElement testStatus;

	public void selectStatus(String status, String email, String messageType) {
		if (status.equalsIgnoreCase("On")) {
			this.onStatus.click();
			this.hoverOverMessageDroplist();
			this.clickMessage(messageType);
		} else if (status.equalsIgnoreCase("Off")) {
			this.offStatus.click();
		} else if (status.equalsIgnoreCase("Test")) {
			this.testStatus.click();
			this.EnterTestEmailAddress(email);
			this.hoverOverMessageDroplist();
			this.clickMessage(messageType);
		}
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@id='name']")
	protected WebElement pmsRequestNameInput;

	public void clickName() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsRequestNameInput));
		this.pmsRequestNameInput.click();
	}

	public void enterName(String pmsName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsRequestNameInput));
		this.pmsRequestNameInput.clear();
		this.pmsRequestNameInput.sendKeys(pmsName);
	}

	public String getName() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsRequestNameInput));
		return this.pmsRequestNameInput.getAttribute("value");
	}

	@FindBy(xpath = "//div[@id='ui-datepicker-div']")
	protected WebElement startDatePopup;

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@id='startDate']")
	protected WebElement startDateInput;

	public void enterStartDate(String startDate) {
		this.wait.until(ExpectedConditions.visibilityOf(this.startDateInput));
		this.startDateInput.clear();
		this.startDateInput.sendKeys(startDate);
		this.startDateInput.sendKeys(Keys.ENTER);
		this.wait.until(ExpectedConditions.invisibilityOf(this.startDatePopup));

	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/div[@class='droplist selector messageSelector']")
	protected WebElement messageDroplist;

	public boolean messageIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.messageDroplist));
		return this.messageDroplist.isDisplayed();
	}

	public void hoverOverMessageDroplist() {
		Actions action = new Actions(this.driver);
		action.moveToElement(messageDroplist).build().perform();
	}

	public void clickMessage(String messageType) {
		this.driver.findElement(
				By.xpath("//form[@id='pmsRequest']/p/div[@class='droplist selector messageSelector']/ul/li/a[text()='"
						+ messageType + "']"))
				.click();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/div[@class='droplist selector badEmail']")
	protected WebElement badEmailDroplist;

	public boolean badEmailDroplistIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.badEmailDroplist));
		return this.badEmailDroplist.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@name='bccEmail']")
	protected WebElement bccMessageToInput;

	public String getBccMessageToEmail() {
		this.wait.until(ExpectedConditions.visibilityOf(this.bccMessageToInput));
		return this.bccMessageToInput.getAttribute("value");
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/div[@class='droplist selector ']/a")
	protected WebElement bookerLogicDroplist;

	public boolean bookerLogicDroplistIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.bookerLogicDroplist));
		return this.bookerLogicDroplist.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@name='delayedSendMinutes']")
	protected WebElement delaySendInput;

	public boolean delaySendInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.delaySendInput));
		return this.delaySendInput.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@name='minOfDaysBetweenEmails']")
	protected WebElement minimumDaysBetweenEmailsInput;

	public boolean minimumDaysBetweenEmailsInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.minimumDaysBetweenEmailsInput));
		return this.minimumDaysBetweenEmailsInput.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@name='bounceReportEmail']")
	protected WebElement immediateBounceNotificationEmailAddressInput;

	public boolean immediateBounceNotificationEmailAddressInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.immediateBounceNotificationEmailAddressInput));
		return this.immediateBounceNotificationEmailAddressInput.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@name='queuedEmailNotificationHours']")
	protected WebElement pendingQueueAgeAlertInput;

	public boolean pendingQueueAgeAlertEmailAddressInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pendingQueueAgeAlertInput));
		return this.pendingQueueAgeAlertInput.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@id='queuedEmailNotificationEmails']")
	protected WebElement pendingQueueAgeAlertEmailAddressInput;

	public boolean pendingQueueAgeAlertInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pendingQueueAgeAlertEmailAddressInput));
		return this.pendingQueueAgeAlertEmailAddressInput.isDisplayed();
	}

	// checkbox section
	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@id='queue_emails']")
	protected WebElement queueMessagesBeforeSendingCheckbox;

	public boolean queueMessagesBeforeSendingCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.queueMessagesBeforeSendingCheckbox));
		return this.queueMessagesBeforeSendingCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@id='ical_template_content']/input[@id='attachICal']")
	protected WebElement attachiCalFileInEmailsCheckbox;

	public boolean attachiCalFileInEmailsCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.attachiCalFileInEmailsCheckbox));
		return this.attachiCalFileInEmailsCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/input[@id='attach_passbook']")
	protected WebElement attachApplePassbookFileInEmailsCheckbox;

	public boolean attachApplePassbookFileInEmailsCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.attachApplePassbookFileInEmailsCheckbox));
		return this.attachApplePassbookFileInEmailsCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/input[@id='attach_google_now']")
	protected WebElement AttachGoogleNowButtonInEmailsCheckbox;

	public boolean attachGoogleNowButtonInEmailsCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.AttachGoogleNowButtonInEmailsCheckbox));
		return this.AttachGoogleNowButtonInEmailsCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@class='greyWrap ']/input[@id='attachWeatherForecast']")
	protected WebElement weatherForecastCheckbox;

	public boolean weatherForecastCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.weatherForecastCheckbox));
		return this.weatherForecastCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@class='greyWrap ']/input[@id='attach_events']")
	protected WebElement attachEventsInEmailsCheckbox;

	public boolean attachEventsInEmailsCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.attachEventsInEmailsCheckbox));
		return this.attachEventsInEmailsCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/div[@class='greyWrap ']/input[@id='market_metrix']")
	protected WebElement enrollIntoWorkflowCheckbox;

	public boolean enrollIntoWorkflowCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.enrollIntoWorkflowCheckbox));
		return this.enrollIntoWorkflowCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/button[@type='submit']")
	protected WebElement saveButton;

	public void clickSaveButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.saveButton.click();
	}

	@FindBy(xpath = "//form[@id='pmsRequest']/p/a[@class='icon_button']/span[@class='cancel']")
	protected WebElement cancelButton;

	public void clickCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.cancelButton));
		this.cancelButton.click();
	}

	// ************** MultiTracks section ******************* //
	@FindBy(xpath = "//a[@id='addRule']")
	protected WebElement addMultiTrackButton;

	public void clickAddMultiTrackButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addMultiTrackButton));
		this.addMultiTrackButton.click();
	}

	@FindBy(xpath = "//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/span[@id='ui-dialog-title-dialog']")
	protected WebElement createMultiTrackDialogTitle;

	public boolean createMultiTrackDialogTitleIsVisible() {
		waitForLoadingModal();
		this.wait.until(ExpectedConditions.visibilityOf(this.createMultiTrackDialogTitle));
		return this.createMultiTrackDialogTitle.isDisplayed();
	}

	@FindBy(xpath = "//table[@id='multitracks']/tbody")
	protected WebElement multiTracksTable;

	public List<WebElement> getMultiTracksTableRows() {
		this.wait.until(ExpectedConditions.visibilityOf(this.multiTracksTable.findElement(By.tagName("tr"))));
		return multiTracksTable.findElements(By.tagName("tr"));
	}

	public Integer getMutliTracksTableRowCount() {
		List<WebElement> rows = this.getMultiTracksTableRows();
		return rows.size();
	}

	public String getMultiTracksRowContents(Integer index) {
		List<WebElement> rows = this.getMultiTracksTableRows();
		WebElement row = rows.get(index);
		return row.getText();
	}

	// create multi track dialog section

	@FindBy(xpath = "//form[@id='createRule']/table/tbody/tr/td/input[@id='name']")
	protected WebElement ruleNameInput;

	public boolean ruleNameInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.ruleNameInput));
		return this.ruleNameInput.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table/tbody/tr/td/div[@id='push']")
	protected WebElement emailDroplist;

	public boolean emailDroplistIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailDroplist));
		return this.emailDroplist.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table/tbody/tr/td/div[@id='uniform-queueFlag']")
	protected WebElement queueBeforeSendingCheckbox;

	public boolean queueBeforeSendingCheckboxIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.queueBeforeSendingCheckbox));
		return this.queueBeforeSendingCheckbox.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table/tbody/tr/td/div[@id='isAnd']")
	protected WebElement typeOfEvaluationDroplist;

	public boolean typeOfEvaluationDroplistIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.typeOfEvaluationDroplist));
		return this.typeOfEvaluationDroplist.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table/tbody/tr/td/input[@id='priority']")
	protected WebElement priorityInput;

	public boolean priorityInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.priorityInput));
		return this.priorityInput.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table[@class='conditions']/tbody/tr[@class='condition']/td/select[@class='pms_data']")
	protected WebElement mappingDroplist;

	public boolean mappingDroplistIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.mappingDroplist));
		return this.mappingDroplist.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table[@class='conditions']/tbody/tr[@class='condition']/td/select[@class='operator']")
	protected WebElement operatorDroplist;

	public boolean operatorDroplistIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.operatorDroplist));
		return this.operatorDroplist.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table[@class='conditions']/tbody/tr[@class='condition']/td/select[@class='pms_data_answer']")
	protected WebElement codeDroplist;

	public boolean codeDroplistIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.codeDroplist));
		return this.codeDroplist.isDisplayed();
	}

	@FindBy(xpath = "//form[@id='createRule']/table[@class='conditions']/tbody/tr[@class='condition']/td[@class='center']/a[@class='only_icon_button deleteCondition']/span[@class='delete']")
	protected WebElement deleteConditionIcon;

	public boolean deleteConditionIconIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.deleteConditionIcon));
		return this.deleteConditionIcon.isDisplayed();
	}

	@FindBy(xpath = "//button[@id='add-condition']")
	protected WebElement addConditionButton;

	public boolean addConditionButtonIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addConditionButton));
		return this.addConditionButton.isDisplayed();
	}

	@FindBy(xpath = "//button[@id='save']")
	protected WebElement createMultiTrackSaveButton;

	public boolean createMultiTrackSaveButtonIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createMultiTrackSaveButton));
		return this.createMultiTrackSaveButton.isDisplayed();
	}

	@FindBy(xpath = "//button[@id='cancel']")
	protected WebElement createMultiTrackCancelButton;

	public void clickCreateMultiTrackCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createMultiTrackCancelButton));
		this.createMultiTrackCancelButton.click();
	}
}
