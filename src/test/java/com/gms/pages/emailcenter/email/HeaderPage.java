package com.gms.pages.emailcenter.email;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

	public HeaderPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
	}

	public void waitForPageLoad() {
		// this.wait.until(ExpectedConditions.visibilityOf(this.canvasIframe));
		// this.driver.switchTo().frame("canvas"); // switch to content frame
		this.wait.until(ExpectedConditions.visibilityOf(this.emailCenterTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.setupTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.htmlTab));
		// add other tabs as they are implemented
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleEmailTab));
		// this.driver.switchTo().defaultContent(); // leave emailCenter iFrame
	}

	// iframe

	@FindBy(xpath = "//iframe[@id='canvas']")
	protected WebElement canvasIframe;

	// title

	@FindBy(xpath = "//h1[contains(text(),'Email Center')]")
	protected WebElement emailCenterTitle;

	public boolean emailCenterTitleIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailCenterTitle));
		return this.emailCenterTitle.isDisplayed();
	}

	// setup tab

	@FindBy(xpath = "//li[contains(@class,'ui-corner-top')]/a[@id='optionsAnchor']/..")
	protected WebElement setupTab;

	public boolean setupTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.setupTab));
		return this.setupTab.getAttribute("class").contains("ui-tabs-selected ui-state-active");
	}

	public boolean setupTabIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.setupTab));
		return this.setupTab.isDisplayed();
	}

	public void clickSetupTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.setupTab));
		this.setupTab.click();
	}

	// html tab

	@FindBy(xpath = "//li[contains(@class,'ui-corner-top')]/a[@id='htmlAnchor']/..")
	protected WebElement htmlTab;

	public boolean htmlTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.htmlTab));
		return this.htmlTab.getAttribute("class").contains("ui-tabs-selected ui-state-active");
	}

	public boolean htmlTabIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.htmlTab));
		return this.htmlTab.isDisplayed();
	}

	public void clickHtmlTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.htmlTab));
		this.htmlTab.click();
	}

	// text

	// mobile

	// forward to a friend

	// test

	@FindBy(xpath = "//li[contains(@class,'ui-corner-top')]/a[@id='testAnchor']/..")
	protected WebElement testTab;

	public boolean testTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.testTab));
		return this.testTab.getAttribute("class").contains("ui-tabs-selected ui-state-active");
	}

	public boolean testTabIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.testTab));
		return this.testTab.isDisplayed();
	}

	public void clickTestTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.testTab));
		this.testTab.click();
	}

	// schedule email tab

	@FindBy(xpath = "//li[contains(@class,'ui-corner-top')]/a[@id='scheduleAnchor']/..")
	protected WebElement scheduleEmailTab;

	public boolean scheduleEmailTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleEmailTab));
		return this.scheduleEmailTab.getAttribute("class").contains("ui-tabs-selected ui-state-active");
	}

	public boolean scheduleEmailTabIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleEmailTab));
		return this.scheduleEmailTab.isDisplayed();
	}

	public void clickScheduleEmailTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduleEmailTab));
		this.scheduleEmailTab.click();
	}
}