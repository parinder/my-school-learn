package com.gms.pages.emailcenter;

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
		this.wait.until(ExpectedConditions.visibilityOf(this.emailCenterIframe));
		this.driver.switchTo().frame("canvas"); // switch to content frame
		this.wait.until(ExpectedConditions.visibilityOf(this.emailCenterTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduledEmailsTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.eventDrivenEmailsTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.templatesTab));
		this.driver.switchTo().defaultContent(); // leave emailCenter iFrame
	}

	// iframe

	@FindBy(xpath = "//iframe[@id='canvas']")
	protected WebElement emailCenterIframe;

	// title

	@FindBy(xpath = "//h1[contains(text(),'Email Center')]")
	protected WebElement emailCenterTitle;

	public boolean emailCenterTitleIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailCenterTitle));
		return this.emailCenterTitle.isDisplayed();
	}

	// scheduled emails tab

	@FindBy(xpath = "//li[contains(@class,'ui-corner-top')]/a[@id='scheduled']/..")
	protected WebElement scheduledEmailsTab;

	public boolean scheduledEmailsTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduledEmailsTab));
		return this.scheduledEmailsTab.getAttribute("class").contains("ui-tabs-selected ui-state-active");
	}

	public boolean scheduledEmailsTabIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduledEmailsTab));
		return this.scheduledEmailsTab.isDisplayed();
	}

	public void clickScheduledEmailsTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.scheduledEmailsTab));
		this.scheduledEmailsTab.click();
	}

	// event driven emails tab

	@FindBy(xpath = "//li[contains(@class,'ui-corner-top')]/a[@id='eventDriven']/..")
	protected WebElement eventDrivenEmailsTab;

	public boolean eventDrivenEmailsTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.eventDrivenEmailsTab));
		return this.eventDrivenEmailsTab.getAttribute("class").contains("ui-tabs-selected ui-state-active");
	}

	public boolean eventDrivenEmailsTabIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.eventDrivenEmailsTab));
		return this.eventDrivenEmailsTab.isDisplayed();
	}

	public void clickEventDrivenEmailsTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.eventDrivenEmailsTab));
		this.eventDrivenEmailsTab.click();
	}

	// templates tab

	@FindBy(xpath = "//li[contains(@class,'ui-corner-top')]/a[@id='templates']/..")
	protected WebElement templatesTab;

	public boolean templatesTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.templatesTab));
		return this.templatesTab.getAttribute("class").contains("ui-tabs-selected ui-state-active");
	}

	public boolean templatesTabIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.templatesTab));
		return this.templatesTab.isDisplayed();
	}

	public void clickTemplatesTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.templatesTab));
		this.templatesTab.click();
	}
}