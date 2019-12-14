package com.myschool.learn.gms.pages.propertymanager;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PropertyManagerPropertyPage extends BasePage {

    public PropertyManagerPropertyPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertyIframe));
        this.driver.switchTo().frame("propertyIFrame");
        this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.imageUrlTextArea));
        this.wait.until(ExpectedConditions.visibilityOf(this.checkInTimeInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.checkOutTimeInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
        this.driver.switchTo().defaultContent();
    }

    @FindBy(xpath = "//iframe[@id='propertyIFrame']")
    protected WebElement propertyIframe;

    // name

    @FindBy(xpath = "//input[@id='name']")
    protected WebElement nameInput;

    public void enterName(String name) {
        this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
        this.nameInput.clear();
        this.nameInput.sendKeys(name);
    }

    // image url

    @FindBy(xpath = "//textarea[@id='imgTextarea']")
    protected WebElement imageUrlTextArea;

    // checkin time

    @FindBy(xpath = "//input[@id='checkInTime']")
    protected WebElement checkInTimeInput;

    // checkout time

    @FindBy(xpath = "//input[@id='checkOutTime']")
    protected WebElement checkOutTimeInput;

    // checkout policy

    @FindBy(xpath = "//textarea[@id='checkOutPolicy']")
    protected WebElement checkOutPolicyTextArea;

    public void enterCheckOutPolicy(String text) {
        this.wait.until(ExpectedConditions.visibilityOf(this.checkOutPolicyTextArea));
        this.checkOutPolicyTextArea.clear();
        this.checkOutPolicyTextArea.sendKeys(text);
    }

    // crs hotel id

    @FindBy(xpath = "//input[@id='crsHotelId']")
    protected WebElement crsHotelIdInput;

    public void enterCrsHotelId(String text) {
        this.wait.until(ExpectedConditions.visibilityOf(this.crsHotelIdInput));
        this.crsHotelIdInput.clear();
        this.crsHotelIdInput.sendKeys(text);
    }

    // save button

    @FindBy(xpath = "//form[@id='property']/button[@id='_submit']")
    protected WebElement saveButton;

    public void clickSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
        // this.saveButton.click();
        // I am clueless as to why the click does nothing but sendkeys of enter works
        this.saveButton.sendKeys(Keys.ENTER);
    }

    // toast message

    @FindBy(xpath = "//button[@class='toast-close-button']")
    protected WebElement toastMessageCloseButton;

    public void waitForToastMessageToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.toastMessageCloseButton));
    }
}