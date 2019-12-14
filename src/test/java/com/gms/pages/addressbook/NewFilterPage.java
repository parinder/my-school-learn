package com.gms.pages.addressbook;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewFilterPage extends BasePage {

  public NewFilterPage(WebDriver driver, Config config) {
    super(driver, config);
    this.url = this.config.getProperty("app.gms.baseurl") + "addressBook/filters";
  }

  public void waitForPageLoad() {
    this.wait.until(ExpectedConditions.visibilityOf(this.availableFieldsSelect));
    this.wait.until(ExpectedConditions.visibilityOf(this.selectFieldsButton));
  }
  
  @FindBy(xpath = "//td[normalize-space(text()) ='Available Fields']")
  protected WebElement availableFieldsLabel;

  public boolean availableFieldsLabelIsVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.availableFieldsLabel));
    return this.availableFieldsLabel.isDisplayed();
  }

  @FindBy(xpath = "//select[@name='available']")
  protected WebElement availableFieldsSelect;

  public boolean availableFieldsListIsVisible() {
    this.wait.until(ExpectedConditions.visibilityOf(this.availableFieldsSelect));
    return this.availableFieldsSelect.isDisplayed();
  }

  @FindBy(xpath = "//option[contains(@value,'city')]")
  protected WebElement citySelectOption;

  public void clickcitySelectOption() {
    this.wait.until(ExpectedConditions.visibilityOf(this.citySelectOption));
    this.citySelectOption.click();
  }

  @FindBy(xpath = "//input[contains(@name,'submit')]")
  protected WebElement selectFieldsButton;

  public void clickSelectFieldsButton() {
    this.wait.until(ExpectedConditions.visibilityOf(this.selectFieldsButton));
    this.selectFieldsButton.click();
  }
}