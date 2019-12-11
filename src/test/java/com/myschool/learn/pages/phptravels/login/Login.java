package com.myschool.learn.pages.phptravels.login;

import com.myschool.learn.configurations.ConfigPhpTravels;
import com.myschool.learn.pages.phptravels.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends BasePage {

    public Login(WebDriver driver, ConfigPhpTravels configPhpTravels) {
        super(driver, configPhpTravels);
        this.url = this.configPhpTravels.getProperty("app.phptravels.login");
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.emailInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.passwordInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.loginButton));
    }

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailInput;

    public void enterEmail(String email) {
        this.emailInput.sendKeys(email);
    }

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordInput;

    public void enterPassword(String password) {
        this.passwordInput.sendKeys(password);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block loginbtn']")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@class='text-align-left']")
    WebElement firstLastNameMessage;

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public String getFirstLastName() {
        this.wait.until(ExpectedConditions.visibilityOf(this.firstLastNameMessage));
        return this.firstLastNameMessage.getText();

    }

    public void getSuccessLoginUrl() {
        this.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/account/"));
    }

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement loginErrorMessage;

    public String getLoginErrorMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loginErrorMessage));
        return this.loginErrorMessage.getText();
    }
}
