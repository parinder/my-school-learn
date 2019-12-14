package com.gms.pages.profiles.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ConsentModalPage extends BasePage {

    public ConsentModalPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    @FindBy(xpath = "//div[@id='viewOptInnModal']//div[@class='modal-dialog']//div[@class='consent-dialog']")
    protected WebElement consentModal;

    public void waitForConsentModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.consentModal));
        this.wait.until(ExpectedConditions.visibilityOf(this.consentModalHeaderXButton));
    }

    public void waitForConsentModalToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.consentModal));
        this.wait.until(ExpectedConditions.invisibilityOf(this.consentModalHeaderXButton));
    }
    
    // consent modal title
    @FindBy(xpath = "//div[@id='viewOptInnModal']/div[@class='modal-Modal']/div[@class='modal-content']/div[@class='modal-header']/h4")
    protected WebElement consentModalTitle;
    
    // consent modal X button
    @FindBy(xpath = "//div[@id='viewOptInnModal']//button[@class='close']")
    protected WebElement consentModalHeaderXButton;

    public void clickConsentModalHeaderXButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.consentModalHeaderXButton));
        this.consentModalHeaderXButton.click();
    }

    // Email section
    @FindBy(xpath = "//span[normalize-space(text()) ='FOR EMAIL']/..//preceding-sibling::a[@data-opted-in='false']")
    protected WebElement consentModalOptedOutLink;

    public void clickConsentModalOptedOutLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.consentModalOptedOutLink));
        this.consentModalOptedOutLink.click();
    }

    public void waitForConsentModalOptedOutLinkToBeInVisible() {
        this.wait.until(ExpectedConditions
            .invisibilityOfElementLocated(By.xpath("//span[normalize-space(text()) ='FOR EMAIL']/..//preceding-sibling::a[@data-opted-in='false']")));
    }

    public boolean consentModalOptedOutLinkIsVisible() {
        return this.consentModalOptedOutLink.isDisplayed();
    }

    @FindBy(xpath = "//span[normalize-space(text()) ='FOR EMAIL']/..//preceding-sibling::a[@data-opted-in='true']")
    protected WebElement consentModalOptedInLink;

    public boolean consentModalOptedInLinkIsVisible() {
        return this.consentModalOptedInLink.isDisplayed();
    }
    
    // confirm Modal
    
    @FindBy(xpath = "//div[@id='changeOptInBox']//div[@class='modal-dialog']")
    protected WebElement confirmModal;

    public void waitForConfirmModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmModal));
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmModalSaveButton));
    }

    public void waitForConfirmModalToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.confirmModal));
        this.wait.until(ExpectedConditions.invisibilityOf(this.confirmModalSaveButton));
    }
    
    @FindBy(xpath = "//div[@id='changeOptInBox']//button[@class='btn btn-default btn-save btn-success']")
    protected WebElement confirmModalSaveButton;

    public void clickConfirmModalSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmModalSaveButton));
        this.confirmModalSaveButton.click();
    }
}