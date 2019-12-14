package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class DataDownloadPage extends BasePage {

    public DataDownloadPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/manager/datamanager?submit=downloaddata";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.downloadListLable));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//td//b[normalize-space(text()) ='Download List']")
    protected WebElement downloadListLable;

    public boolean downloadListLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.downloadListLable));
        return this.downloadListLable.isDisplayed();
    }

    @FindBy(xpath = "//input[@value='Download List']")
    protected WebElement downloadListButtonIcon;

    public boolean downloadListButtonIconIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.downloadListButtonIcon));
        return this.downloadListButtonIcon.isDisplayed();
    }
}