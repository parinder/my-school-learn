package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class DataUploadPage extends BasePage {

    public DataUploadPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/manager/datamanager?submit=uploaddata";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.uploadFileLable));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//b//span[@class='CampaignName']")
    protected WebElement headerTitle;

    public String getHeaderTitleText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
        return this.headerTitle.getText();
    }

    @FindBy(xpath = "//th[normalize-space(text()) ='Upload File']")
    protected WebElement uploadFileLable;

    public boolean uploadFileLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.uploadFileLable));
        return this.uploadFileLable.isDisplayed();
    }

    @FindBy(xpath = "//td[normalize-space(text()) ='Available Fields']")
    protected WebElement availableFieldsLable;

    public boolean availableFieldsLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.availableFieldsLable));
        return this.availableFieldsLable.isDisplayed();
    }

    @FindBy(xpath = "//td[normalize-space(text()) ='Upload File Format']")
    protected WebElement uploadFileFormatLable;

    public boolean uploadFileFormatLableLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.uploadFileFormatLable));
        return this.uploadFileFormatLable.isDisplayed();
    }

    @FindBy(xpath = "//input[@name='submit' and @value='Upload Data']")
    protected WebElement uploadDataButtonIcon;

    public boolean uploadDataButtonIconIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.uploadDataButtonIcon));
        return this.uploadDataButtonIcon.isDisplayed();
    }
}