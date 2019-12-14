package com.myschool.learn.gms.pages.emailcenter.email;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class ScheduleEmailTabPage extends BasePage {

	public ScheduleEmailTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleDateInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleTimeInput));
	}

	// date

	@FindBy(xpath = "//input[@id='gms_schedule_date']")
	protected WebElement scheduleDateInput;

	public void enterScheduleDate(String date) {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleDateInput));
		this.scheduleDateInput.clear();
		this.scheduleDateInput.sendKeys(date);
	}

	// time

	@FindBy(xpath = "//input[@id='gms_schedule_time']")
	protected WebElement scheduleTimeInput;

	public void enterScheduleTime(String time) {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleTimeInput));
		this.scheduleTimeInput.clear();
		this.scheduleTimeInput.sendKeys(time);
	}

	// clear schedule button

	@FindBy(xpath = "//button[contains(@class,'clear-schedule')]")
	protected WebElement clearScheduleButton;

	// filter select

	@FindBy(xpath = "//span[@id='select2-gms_filter_select-container']")
	protected WebElement filterSelect;

	public void clickFilterSelect() {
		this.wait.until(ExpectedConditions.visibilityOf(this.filterSelect));
		this.filterSelect.click();
	}

	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']")
	protected WebElement filterSelectSearchInput;

	public void enterFilterSelect(String filter) {
		this.wait.until(ExpectedConditions.visibilityOf(this.filterSelectSearchInput));
		this.filterSelectSearchInput.sendKeys(filter);
		// this.filterSelect.sendKeys(Keys.ARROW_DOWN);
		this.filterSelectSearchInput.sendKeys(Keys.ENTER);
	}

	// bcc

	@FindBy(xpath = "//input[@placeholder='Select emails to BCC']")
	protected WebElement bccInput;

	public void enterBcc(String bcc) {
		this.wait.until(ExpectedConditions.visibilityOf(this.bccInput));
		this.bccInput.sendKeys(bcc);
	}

	// override

	@FindBy(xpath = "//input[@id='overrideLimiterFlag']")
	protected WebElement overrideEmailLimiterInput;

	// save button

	@FindBy(xpath = "//button[@id='save-schedule-email']")
	protected WebElement saveButton;

	public void clickSaveButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.saveButton.click();
	}

	// confirm dialog

	@FindBy(xpath = "//div[@id='confirmDialog']")
	protected WebElement confirmModal;

	public void waitForConfirmDialogToBeInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.confirmModal));
	}

	public void waitForConfirmDialogToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmModal));
	}

	// confirm dialog save button

	@FindBy(xpath = "//div[@id='confirmDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/button[contains(@class,'btn-save')]")
	protected WebElement confirmModalSaveButton;

	public void clickConfirmModalSaveButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmModalSaveButton));
		this.confirmModalSaveButton.click();
	}

	// confirm dialog cancel button

	@FindBy(xpath = "//div[@id='confirmDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/button[contains(@class,'btn-close')]")
	protected WebElement confirmModalCancelButton;

	public void clickConfirmModalCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmModalCancelButton));
		this.confirmModalCancelButton.click();
	}
}
