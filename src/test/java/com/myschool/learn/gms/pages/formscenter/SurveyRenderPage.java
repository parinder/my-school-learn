package com.myschool.learn.gms.pages.formscenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class SurveyRenderPage extends BasePage {

	public SurveyRenderPage(WebDriver driver, Config config) {
		super(driver, config);
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.submitButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.emailInput));
	}

	// email input

	@FindBy(xpath = "//div[@id='fieldBlockemailinput']/div[@class='ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset']/input")
	protected WebElement emailInput;

	// submit button

	@FindBy(xpath = "//div[@id='submitButton']/button")
	protected WebElement submitButton;
}