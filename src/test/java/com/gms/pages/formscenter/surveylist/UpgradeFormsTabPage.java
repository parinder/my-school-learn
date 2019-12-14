package com.gms.pages.formscenter.surveylist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class UpgradeFormsTabPage extends BasePage {

	public UpgradeFormsTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "survey/list";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.upgradeFormsListTitle));
		// Enhance to assert upgrade forms list
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewFormButton));
	}

	// upgrade forms list

	// upgrade forms list title

	@FindBy(xpath = "//div[@id='listOfSurveys']/div/div/h2[contains(text(),'List of Upgrade Forms')]")
	protected WebElement upgradeFormsListTitle;

	// upgrade forms create new form button

	@FindBy(xpath = "//a[@id='chooseSurveyDomain']")
	protected WebElement createNewFormButton;

	public void clickCreateNewFormButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewFormButton));
		this.createNewFormButton.click();
	}

	// new upgrade form modal

	@FindBy(xpath = "//div[contains(@class,'ui-dialog')]/div[@id='dialog']")
	protected WebElement newUpgradeFormModal;

	public void waitForNewUpgradeFormModalToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.newUpgradeFormModal));
		this.wait.until(ExpectedConditions.visibilityOf(this.newUpgradeFormModalTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.newUpgradeFormModalDomainSelect));
		this.wait.until(ExpectedConditions.visibilityOf(this.newUpgradeFormModalPropertySelect));
		this.wait.until(ExpectedConditions.visibilityOf(this.newUpgradeFormModalSaveButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.newUpgradeFormModalCancelButton));
	}

	public void waitForNewUpgradeFormModalToBeInvisible() {
		// the the invisibilityof expected condition is not working properly
		// this.wait.until(ExpectedConditions.invisibilityOf(this.createNewQuestionModal));
		// used this instead and it works
		this.wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-dialog')]/div[@id='dialog']")));
	}

	// new upgrade form modal title

	@FindBy(xpath = "//span[@id='ui-dialog-title-dialog']")
	protected WebElement newUpgradeFormModalTitle;

	// new upgrade form modal domain
	@FindBy(xpath = "//form[@id='chooseProperty']/div[@class='droplist selector']")
	protected WebElement newUpgradeFormModalDomainSelect;

	// new upgrade form modal property

	@FindBy(xpath = "//form[@id='chooseProperty']/div[@class='property']")
	protected WebElement newUpgradeFormModalPropertySelect;

	// new upgrade form modal save button

	@FindBy(xpath = "//a[@id='create_survey_with_domain']")
	protected WebElement newUpgradeFormModalSaveButton;

	// new upgrade form modal cancel button

	@FindBy(xpath = "//form[@id='chooseProperty']/div[@id='form_nav_bar']/a[contains(@class,'cancel')]")
	protected WebElement newUpgradeFormModalCancelButton;

	public void clickNewUpgradeFormModalCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.newUpgradeFormModalCancelButton));
		this.newUpgradeFormModalCancelButton.click();
	}

	// Loading Modal

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
}