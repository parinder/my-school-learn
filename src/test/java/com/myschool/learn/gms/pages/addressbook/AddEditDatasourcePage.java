package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class AddEditDatasourcePage extends BasePage {

    public AddEditDatasourcePage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/manager/datamanager?submit=add_datasource_screen";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewDatasourceLable));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//td//b[text() = 'Add New Datasource']")
    protected WebElement addNewDatasourceLable;

    public boolean addNewDatasourceLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewDatasourceLable));
        return this.addNewDatasourceLable.isDisplayed();
    }

    @FindBy(xpath = "//input[@value='Add']")
    protected WebElement addButtonIcon;

    public boolean addButtonIconIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addButtonIcon));
        return this.addButtonIcon.isDisplayed();
    }

    @FindBy(xpath = "//b[text()='Categories']")
    protected WebElement categoriesLable;

    public boolean categoriesLableIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.categoriesLable));
        return this.categoriesLable.isDisplayed();
    }
}