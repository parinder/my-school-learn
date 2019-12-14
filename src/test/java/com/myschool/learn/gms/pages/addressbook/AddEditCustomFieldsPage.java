package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class AddEditCustomFieldsPage extends BasePage {

    public AddEditCustomFieldsPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/manager/datamanager?submit=custom_field";
    }

    public void waitForPageLoad() {
        this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.newCustomFieldInput));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//b[text()='Add New Custom Field']")
    protected WebElement addNewCustomFieldLable;

    public boolean addNewCustomFieldLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewCustomFieldLable));
        return this.addNewCustomFieldLable.isDisplayed();
    }

    @FindBy(xpath = "//input[@name='new_custom_field']")
    protected WebElement newCustomFieldInput;

    public boolean newCustomFieldInputIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.newCustomFieldInput));
        return this.newCustomFieldInput.isDisplayed();
    }

    @FindBy(xpath = "//input[@value='Add Field']")
    protected WebElement addFieldButtonIcon;

    public boolean addFieldButtonIconIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addFieldButtonIcon));
        return this.addFieldButtonIcon.isDisplayed();
    }
    

    @FindBy(xpath = "//b[text()='Existing Fields']")
    protected WebElement existingFieldsLable;

    public boolean existingFieldsLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.existingFieldsLable));
        return this.existingFieldsLable.isDisplayed();
    }
}