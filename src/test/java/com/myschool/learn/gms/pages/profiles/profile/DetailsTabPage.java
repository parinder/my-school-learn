package com.myschool.learn.gms.pages.profiles.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class DetailsTabPage extends BasePage {

    public DetailsTabPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.detailsTabContainer));
    }

    @FindBy(xpath = "//div[@id='detailsTab' and contains(@class, 'active')]")
    protected WebElement detailsTabContainer;

    // profile details

    // mobile phone

    @FindBy(xpath = "//div[contains(@class, 'form-group cell-phone-group')]")
    protected WebElement mobilePhoneDiv;

    @FindBy(xpath = "//div[contains(@class, 'form-group cell-phone-group')]/span/input[@id='profile-mobile-phone']")
    protected WebElement mobilePhoneInput;

    @FindBy(xpath = "//div[@id='cell-phone-error-message']")
    protected WebElement mobilePhonePopupValidationMessage;

    public void enterMobilePhone(String mobilePhoneNumber) {
        this.wait.until(ExpectedConditions.visibilityOf(this.mobilePhoneInput));
        this.mobilePhoneInput.clear();
        this.mobilePhoneInput.sendKeys(mobilePhoneNumber);
    }

    public void  waitForMobilePhoneToHaveNoValidationError() {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(mobilePhoneDiv, "class", "has-error")));
    }

    public void  waitForMobilePhoneToHaveValidationError() {
        this.wait.until(ExpectedConditions.attributeContains(mobilePhoneDiv, "class", "has-error"));
    }

    public void hoverOverMobilePhone() {
        Actions action = new Actions(this.driver);
        action.moveToElement(this.mobilePhoneInput).build().perform();
    }

    public String getMobilePhoneValidationMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mobilePhonePopupValidationMessage));
        return this.mobilePhonePopupValidationMessage.getText();
    }

    // save button

    @FindBy(xpath = "//form[@class='profile-fields-form']/button[@class='btn btn-blue save-btn']")
    protected WebElement saveButton;

    public void clickSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
        this.wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));
        this.saveButton.click();
    }

    // success message

    @FindBy(xpath = "//div[@class='alert  alert-success fade in']/span[@class='message']")
    protected WebElement successMessage;

    public void waitForSuccessMessageToBeVisible(){
        this.wait.until(ExpectedConditions.visibilityOf(this.successMessage));
    }

    @FindBy(xpath = "//div[@class='alert  alert-success fade in']/button[@class='close']")
    protected WebElement successMessageCloseButton;

    public void clickSuccessMessageCloseButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.successMessageCloseButton));
        this.successMessageCloseButton.click();
    }
}
