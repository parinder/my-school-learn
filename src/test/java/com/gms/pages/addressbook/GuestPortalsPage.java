package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class GuestPortalsPage extends BasePage {

    public GuestPortalsPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "landingPageGroups/";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.guestPortalsTitle));
     }

    @FindBy(xpath = "//h1[text()='Guest Portals']")
    protected WebElement guestPortalsTitle;

    public boolean guestPortalsTitleIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.guestPortalsTitle));
        return this.guestPortalsTitle.isDisplayed();
    }

    @FindBy(xpath = "//a[@class='ajaxDialog icon_button']")
    protected WebElement createNewPortalButtonIcon;

    public boolean createNewPortalButtonIconIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.createNewPortalButtonIcon));
        return this.createNewPortalButtonIcon.isDisplayed();
    }
}