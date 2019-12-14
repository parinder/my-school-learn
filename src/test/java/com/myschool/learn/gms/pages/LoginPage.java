package com.myschool.learn.gms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "login";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(usernameInput));
		this.wait.until(ExpectedConditions.visibilityOf(passwordInput));
		this.wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));
		this.wait.until(ExpectedConditions.visibilityOf(loginButton));
	}

	// username

	@FindBy(xpath = "//input[@name='user']")
	protected WebElement usernameInput;

	public void enterUsername(String username) {
		this.wait.until(ExpectedConditions.visibilityOf(this.usernameInput));
		this.usernameInput.sendKeys(username);
	}

	// password

	@FindBy(xpath = "//input[@name='pass']")
	protected WebElement passwordInput;

	public void enterPassword(String password) {
		this.wait.until(ExpectedConditions.visibilityOf(this.passwordInput));
		this.passwordInput.sendKeys(password);
	}

	// forgot password

	@FindBy(xpath = "//div[@class='forgotPass']/a")
	protected WebElement forgotPasswordLink;

	// login button

	@FindBy(xpath = "//button[@class='icon_button submit']")
	protected WebElement loginButton;

	public void clickLoginButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loginButton));
		this.loginButton.click();
	}

	// country select

	@FindBy(xpath = "//div[@id='countrySelect']/button[@class='dropbtn']")
	protected WebElement countrySelect;

	// error message

	@FindBy(xpath = "//div[@class='loginError']")
	protected WebElement loginErrorMessage;

	public String getLoginErrorMessage() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loginErrorMessage));
		return this.loginErrorMessage.getText();
	}
}
