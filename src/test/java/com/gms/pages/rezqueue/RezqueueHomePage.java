package com.gms.pages.rezqueue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class RezqueueHomePage extends BasePage {

	public RezqueueHomePage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.rezqueue.baseurl") + "home";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(rezQueueHomePageTitle));
		this.wait.until(ExpectedConditions.visibilityOf(rezQueueHomePageSubTitle));
		this.wait.until(ExpectedConditions.visibilityOf(goToGmsButton));
	}

	@FindBy(how = How.ID, using = "zdirect_logo")
	protected WebElement rezqueueLogo;

	@FindBy(xpath = "//h1[contains(text(),'RezQueue')]")
	public WebElement rezQueueHomePageTitle;

	public boolean rezQueueHomePageTitleIsVisible(){
		return this.rezQueueHomePageTitle.isDisplayed();
	}

	@FindBy(xpath = "//h2[contains(text(),'Please select a section')]")
	public WebElement rezQueueHomePageSubTitle;

	@FindBy(xpath = "//span[contains(@class,'redo')]")
	protected WebElement goToGmsButton;

	public void clickGotoGmsButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.goToGmsButton));
		this.goToGmsButton.click();
	}
}