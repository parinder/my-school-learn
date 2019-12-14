package com.gms.pages.rezqueue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class RezqueueLoginPage extends BasePage {

	public RezqueueLoginPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.rezqueue.baseurl");
	}

	public void get() {
		driver.get(this.url);
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(usernameInput));
	}

	@FindBy(xpath = "//input[@name='user']")
	protected WebElement usernameInput;

	public void enterUsername(String username) {
		this.wait.until(ExpectedConditions.visibilityOf(this.usernameInput));
		this.usernameInput.clear();
		this.usernameInput.sendKeys(username);
	}

	public void clearUsernameInput() {
		this.usernameInput.clear();
	}

	@FindBy(xpath = "//input[@name='pass']")
	protected WebElement passwordInput;

	public void enterPassword(String password) {
		this.wait.until(ExpectedConditions.visibilityOf(this.passwordInput));
		this.passwordInput.clear();
		this.passwordInput.sendKeys(password);
	}

	public void clearPasswordInput() {
		this.passwordInput.clear();
	}

	@FindBy(xpath = "//a[@class='icon_button submit']")
	protected WebElement rezqueLoginButton;

	public void clickRezqueLoginButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.rezqueLoginButton));
		this.rezqueLoginButton.click();
	}

	@FindBy(xpath = "//div[@id='languageSelect']/button[@class='dropbtn']")
	protected WebElement countrySelect;

	@FindBy(xpath = "//div[@class='loginError']")
	protected WebElement loginErrorMessage;

	public String getLoginErrorMessage() {
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.loginErrorMessage));
		return this.loginErrorMessage.getText();
	}

}
