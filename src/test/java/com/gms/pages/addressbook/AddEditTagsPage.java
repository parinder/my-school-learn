package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class AddEditTagsPage extends BasePage {

    public AddEditTagsPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/tags.spr";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.newTagNameInput));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//h2['ZMail-category' and text()='Add a New Tag']")
    protected WebElement addNewTagLable;

    public boolean addNewTagLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewTagLable));
        return this.addNewTagLable.isDisplayed();
    }

    @FindBy(xpath = "//input[@id='newName']")
    protected WebElement newTagNameInput;

    public boolean newTagNameInputIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.newTagNameInput));
        return this.newTagNameInput.isDisplayed();
    }

    @FindBy(xpath = "//h2['ZMail-category' and text()='Edit Existing Tags']")
    protected WebElement editExistingTagsLable;

    public boolean editExistingTagsLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.editExistingTagsLable));
        return this.editExistingTagsLable.isDisplayed();
    }
}