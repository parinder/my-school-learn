package com.gms.pages.emailcenter.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class TestTabPage extends BasePage {

  public TestTabPage(WebDriver driver, Config config) {
    super(driver, config);
    this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
  }

  public void waitForPageLoad() {
    this.wait.until(ExpectedConditions.visibilityOf(this.emailAddressesTextarea));
    this.wait.until(ExpectedConditions.visibilityOf(this.sendButton));
  }

  // success message

  @FindBy(xpath = "//body/div/div/span[contains(text(), 'Your test email has been sent.')]")
  protected WebElement emailSentSuccessMessage;

  public void waitForEmailSentSuccessMessageToBeVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.emailSentSuccessMessage));
  }

  // email addresses

  @FindBy(xpath = "//textarea[@name='testemail']")
  protected WebElement emailAddressesTextarea;

  public void enterEmailAddresses(String email) {
    this.wait.until(ExpectedConditions.visibilityOf(this.emailAddressesTextarea));
    this.emailAddressesTextarea.sendKeys(email);
  }

  // message type

  @FindBy(xpath = "//select[@name='emailtype']")
  protected WebElement messageTypeSelect;

  // send email button
  @FindBy(xpath = "//input[@name='guiButton']")
  protected WebElement sendButton;

  public void clickSendButton() {
    this.wait.until(ExpectedConditions.visibilityOf(this.sendButton));
    this.sendButton.click();
  }
}