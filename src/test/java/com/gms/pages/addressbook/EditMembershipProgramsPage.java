package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class EditMembershipProgramsPage extends BasePage {

    public EditMembershipProgramsPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "o/Edit%20Membership%20Programs//gms/app/membership";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.editMembershipProgramsTitle));
     }

    @FindBy(xpath = "//h1[text()='Edit Membership Programs']")
    protected WebElement editMembershipProgramsTitle;

    public boolean editMembershipProgramsTitleIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.editMembershipProgramsTitle));
        return this.editMembershipProgramsTitle.isDisplayed();
    }

    @FindBy(xpath = "//button[@id='action-new-program']")
    protected WebElement addProgramButton;

    public boolean addProgramButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addProgramButton));
        return this.addProgramButton.isDisplayed();
    }

    @FindBy(xpath = "//div[@id='programs']//a[normalize-space(text()) ='Guest Portal']")
    protected WebElement guestPortalProgram;

    public boolean guestPortalProgramIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.guestPortalProgram));
        return this.guestPortalProgram.isDisplayed();
    }
}