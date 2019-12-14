package com.myschool.learn.gms.pages.profiles.profile;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class MessengerTabPage extends BasePage {

    public MessengerTabPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.messengerTabContainer));
    }

    @FindBy(xpath = "//div[@id='engagementTab' and contains(@class, 'active')]")
    protected WebElement messengerTabContainer;
    
    @FindBy(xpath = "//div[@id='engagementTab']//button[@class='btn btn-xs specific-user-engagement-button']")
    protected WebElement sendMessageButton;

    public void clickSendMessageButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.sendMessageButton));
        this.sendMessageButton.click();
    }

    // send message to user popup
    
    @FindBy(xpath = "//div[@class='popover fade top in']")
    protected WebElement sendMessageToUserPopup;

    public void waitForSendMessageToUserPopupToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.sendMessageToUserPopup));
        this.wait.until(ExpectedConditions.visibilityOf(this.sendMessageToUserPopupTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.greenCheckIcon));
    }

    public void waitForSendMessageToUserPopUpToBeInVisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.sendMessageToUserPopup));
        this.wait.until(ExpectedConditions.invisibilityOf(this.sendMessageToUserPopupTitle));
        this.wait.until(ExpectedConditions.invisibilityOf(this.greenCheckIcon));
    }

    @FindBy(xpath = "//h3[@class='popover-title']")
    protected WebElement sendMessageToUserPopupTitle;
    
    @FindBy(xpath = "//select[@class='specific-user-engagement-property select2-hidden-accessible']/../span")
    protected WebElement propertySelect;

    public void clickPropertySelect() {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertySelect));
        this.propertySelect.click();
    }

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']")
    protected WebElement propertySearchInput;

    public void selectPropertyViaSearch(String property) {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertySearchInput));
        this.propertySearchInput.sendKeys(property);
        this.propertySearchInput.sendKeys(Keys.ARROW_DOWN);
        this.propertySearchInput.sendKeys(Keys.ENTER);
    }
    
    @FindBy(xpath = "//a[@class='btn btn-circle btn-success btn-xs']//i[@class='fa fa-check']")
    protected WebElement greenCheckIcon;
    
    public void clickSaveButtonIcon() {
        this.wait.until(ExpectedConditions.visibilityOf(this.greenCheckIcon));
        this.greenCheckIcon.click();
    }
}
