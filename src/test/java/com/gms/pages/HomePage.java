package com.gms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gms.configuration.Config;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl");
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.homePageTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.homePageSubTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.gotoRezqueueButton));
	}

	@FindBy(xpath = "//h1[contains(text(),'Home Page')]")
	public WebElement homePageTitle;

	public boolean homePageTitleIsVisible(){
		return this.homePageTitle.isDisplayed();
	}

	@FindBy(xpath = "//h2[contains(text(),'Please select a section')]")
	public WebElement homePageSubTitle;

	@FindBy(xpath = "//div[@id='panelContainer']//h1[text()='Address Book']")
	protected WebElement addressbookImageLink;

	public void clickAddressBookImageLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addressbookImageLink));
		this.addressbookImageLink.click();
	}

	public boolean addressBookImageLinkIsVisible() {
		try {
			return this.addressbookImageLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@FindBy(xpath = "//div[@id='panelContainer']//h1[text()='Email Center']")
	protected WebElement emailCenterImageLink;

	public void clickEmailCenterImageLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailCenterImageLink));
		this.emailCenterImageLink.click();
	}

	public boolean emailCenterImageLinkIsVisible() {
		try {
			return this.emailCenterImageLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@FindBy(xpath = "//div[@id='panelContainer']//h1[text()='Forms Center']")
	protected WebElement formsCenterImageLink;

	public void clickFormsCenterImageLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.formsCenterImageLink));
		this.formsCenterImageLink.click();
	}

	public boolean formsCenterImageLinkIsVisible() {
		try {
			return this.formsCenterImageLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@FindBy(xpath = "//div[@id='panelContainer']//h1[text()='Reports']")
	protected WebElement reportsImageLink;

	public void clickReportsImageLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.reportsImageLink));
		this.reportsImageLink.click();
	}

	public boolean reportsImageLinkIsVisible() {
		try {
			return this.reportsImageLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@FindBy(xpath = "//div[@id='panelContainer']//h1[text()='PMS']")
	protected WebElement pmsImageLink;

	public void clickPmsImageLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsImageLink));
		this.pmsImageLink.click();
	}

	public boolean pmsImageLinkIsVisible() {
		try {
			return this.pmsImageLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@FindBy(xpath = "//div[@id='panelContainer']/a/div/h1[text()='Workflow']")
	protected WebElement workflowImageLink;

	public void clickWorkflowImageLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.workflowImageLink));
		this.workflowImageLink.click();
	}

	public boolean workflowImageLinkIsVisible() {
		try {
			return this.workflowImageLink.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@FindBy(xpath = "//span[@class='redo']")
	protected WebElement gotoRezqueueButton;

	public void clickGotoRezqueueButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.gotoRezqueueButton));
		this.gotoRezqueueButton.click();
	}

	// Select a customer contents

	@FindBy(xpath = "//form[@id='search']/input")
	protected WebElement listOwnerSearchInput;

	public void enterListOwnerSearch(String listOwnerName) {
		new WebDriverWait(this.driver, 200).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//ul[@id='customers']//li/ul[@class='listOwners']/li/a[text()='" + listOwnerName + "']")));
		this.listOwnerSearchInput.sendKeys(listOwnerName);
	}

	public void clickListOwnerLink(String listOwnerName) {
		this.driver
				.findElement(By.xpath(
						"//ul[@id='customers']//li/ul[@class='listOwners']/li/a[text()='" + listOwnerName + "']"))
				.click();
	}
}
