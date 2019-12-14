package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class AutoPurgeConfigurationPage extends BasePage {

    public AutoPurgeConfigurationPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "autoPurgeConfig";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.autoPurgeConfigurationTitle));
     }

    @FindBy(xpath = "//div[@id='header']//div//div//div//h1[text()='Auto Purge Configuration']")
    protected WebElement autoPurgeConfigurationTitle;

    public boolean autoPurgeConfigurationTitleIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.autoPurgeConfigurationTitle));
        return this.autoPurgeConfigurationTitle.isDisplayed();
    }

    @FindBy(xpath = "//h2[text()='Purge Options']")
    protected WebElement purgeOptionsLable;

    public boolean purgeOptionsLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.purgeOptionsLable));
        return this.purgeOptionsLable.isDisplayed();
    }

    @FindBy(xpath = "//h2[text()='Data to Purge']")
    protected WebElement dataToPurgeLable;

    public boolean dataToPurgeLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.dataToPurgeLable));
        return this.dataToPurgeLable.isDisplayed();
    }

    @FindBy(xpath = "//button[@class='icon_button']//span[@class='save']")
    protected WebElement saveButton;

    public boolean saveButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
        return this.saveButton.isDisplayed();
    }
}