package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class PostalContactsPage extends BasePage {

    public PostalContactsPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/manager/datamanager?submit=postal_mail";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.createPostalMailingListLable));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//strong[(text()='Create Postal Mailing List')]")
    protected WebElement createPostalMailingListLable;

    public boolean createPostalMailingListLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.createPostalMailingListLable));
        return this.createPostalMailingListLable.isDisplayed();
    }
    
    @FindBy(xpath = "//input[@name='create_list']")
    protected WebElement createListButtonIcon;

    public boolean createListButtonIconIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.createListButtonIcon));
        return this.createListButtonIcon.isDisplayed();
    }

    @FindBy(xpath = "//strong[(text()='Select Search Criteria ')]") // there is space in HTML code
    protected WebElement selectSearchCriteriaLable;

    public boolean selectSearchCriteriaLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.selectSearchCriteriaLable));
        return this.selectSearchCriteriaLable.isDisplayed();
    }
}