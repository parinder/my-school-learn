package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class OBWSetupPage extends BasePage {

    public OBWSetupPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "o/Address%20Book//gms/manager/obwmanager";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.addSavePackageButtonIcon));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//td[normalize-space(text()) ='Booking Wizards Configuration']")
    protected WebElement bookingWizardsConfigurationLable;

    public boolean bookingWizardsConfigurationLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.bookingWizardsConfigurationLable));
        return this.bookingWizardsConfigurationLable.isDisplayed();
    }

    @FindBy(xpath = "//td[normalize-space(text()) ='Add/Edit Booking Wizard']")
    protected WebElement addEditBookingWizardLable;

    public boolean addEditBookingWizardLableLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addEditBookingWizardLable));
        return this.addEditBookingWizardLable.isDisplayed();
    }

    @FindBy(xpath = "//td[normalize-space(text()) ='Select Resources:']")
    protected WebElement selectResourcesLable;

    public boolean selectResourcesLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.selectResourcesLable));
        return this.selectResourcesLable.isDisplayed();
    }

    @FindBy(xpath = "//input[@value='Add / Save Package']")
    protected WebElement addSavePackageButtonIcon;

    public boolean addSavePackageButtonIconIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addSavePackageButtonIcon));
        return this.addSavePackageButtonIcon.isDisplayed();
    }
}