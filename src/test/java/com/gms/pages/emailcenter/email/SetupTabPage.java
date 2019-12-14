package com.gms.pages.emailcenter.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class SetupTabPage extends BasePage {

	public SetupTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.subjectLineInput));
	}

	// name

	@FindBy(how = How.ID, using = "name")
	protected WebElement nameInput;

	public boolean nameInputIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
		return this.nameInput.isDisplayed();
	}

	public void enterName(String name) {
		this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
		this.nameInput.sendKeys(name);
	}

	// subject line

	@FindBy(how = How.ID, using = "subject")
	protected WebElement subjectLineInput;

	public void enterSubjectLine(String subjectLine) {
		this.wait.until(ExpectedConditions.visibilityOf(this.subjectLineInput));
		this.subjectLineInput.sendKeys(subjectLine);
	}

	// from name

	@FindBy(how = How.ID, using = "fromName")
	protected WebElement fromNameInput;

	public String getFromNameValue() {
		this.wait.until(ExpectedConditions.visibilityOf(this.fromNameInput));
		return this.fromNameInput.getAttribute("value");
	}

	public void enterFromName(String text) {
		this.wait.until(ExpectedConditions.visibilityOf(this.fromNameInput));
		this.fromNameInput.sendKeys(text);
	}

	// from email address

	@FindBy(how = How.ID, using = "fromEmail")
	protected WebElement fromEmailAddressInput;

	public String getFromEmailAddressValue() {
		this.wait.until(ExpectedConditions.visibilityOf(this.fromEmailAddressInput));
		return this.fromEmailAddressInput.getAttribute("value");
	}

	public void enterFromEmailAddress(String text) {
		this.wait.until(ExpectedConditions.visibilityOf(this.fromEmailAddressInput));
		this.fromEmailAddressInput.sendKeys(text);
	}

	// reply to override

	@FindBy(how = How.ID, using = "push.replyToOverride")
	protected WebElement replyToOverrideInput;

	public String getReplyToOverrideValue() {
		this.wait.until(ExpectedConditions.visibilityOf(this.replyToOverrideInput));
		return this.replyToOverrideInput.getAttribute("value");
	}

	public void enterReplyToOverride(String text) {
		this.wait.until(ExpectedConditions.visibilityOf(this.replyToOverrideInput));
		this.replyToOverrideInput.sendKeys(text);
	}

	// sending domain

	// Campaign Folder section

	// Folder

	@FindBy(how = How.ID, using = "campaignSelect")
	protected WebElement folderSelect;

	public void selectFolder(String optionToSelect) {
		this.wait.until(ExpectedConditions.visibilityOf(this.folderSelect));
		new Select(this.folderSelect).selectByVisibleText(optionToSelect);
	}

	public String getSelectedFolder() {
		this.wait.until(ExpectedConditions.visibilityOf(this.folderSelect));
		return new Select(this.folderSelect).getFirstSelectedOption().getText();
	}

	// sub folder

	@FindBy(how = How.ID, using = "folderSelect")
	protected WebElement subFolderSelect;

	public void selectSubFolder(String optionToSelect) {
		this.wait.until(ExpectedConditions.visibilityOf(this.subFolderSelect));
		new Select(this.subFolderSelect).selectByVisibleText(optionToSelect);
	}

	public String getSelectedSubFolder() {
		this.wait.until(ExpectedConditions.visibilityOf((WebElement) this.subFolderSelect));
		return new Select(this.subFolderSelect).getFirstSelectedOption().getText();
	}

	// Forward to a Friend section

	@FindBy(how = How.ID, using = "referSubject")
	protected WebElement forwardToAFriendSubjectLineInput;

	public String getForwardToAFriendSubjectLineValue(String expectedText) {
		this.wait.until(ExpectedConditions.visibilityOf(this.forwardToAFriendSubjectLineInput));
		return this.forwardToAFriendSubjectLineInput.getAttribute("value");
	}

	public void enterForwardToAFriendSubjectLine(String text) {
		this.wait.until(ExpectedConditions.visibilityOf(this.forwardToAFriendSubjectLineInput));
		this.forwardToAFriendSubjectLineInput.sendKeys(text);
	}

	// save all button

	@FindBy(how = How.ID, using = "saveAll")
	protected WebElement saveAllButton;

	public void clickSaveAllButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.saveAllButton));
		this.saveAllButton.click();
	}
}
