package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class EditFilterPage extends BasePage {

    public EditFilterPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "addressBook/filters";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filterNameInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.saveFilterButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.saveAndTagFilterbutton));
    }

    @FindBy(xpath = "//input[@name='filter_name']")
    protected WebElement filterNameInput;

    @FindBy(name = "any_criteria_flag")
    protected WebElement criteriaMetDropdown;

    @FindBy(xpath = "//input[@name='submit']")
    protected WebElement saveFilterButton;

    public boolean saveFilterButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveFilterButton));
        return this.saveFilterButton.isDisplayed();
    }

    @FindBy(xpath = "//input[@name='saveAndTag']")
    protected WebElement saveAndTagFilterbutton;

    // city field

    @FindBy(xpath = "(//select[contains(@name,'city_operator')])[1]")
    protected WebElement cityIncludingFieldsDropdown;

    public boolean cityIncludingFieldsDropdownIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.cityIncludingFieldsDropdown));
        return this.cityIncludingFieldsDropdown.isDisplayed();
    }

    @FindBy(xpath = "(//input[contains(@name,'city_text')])[1]")
    protected WebElement cityIncludingFieldsInput;

    public boolean cityIncludingFieldsInputIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.cityIncludingFieldsInput));
        return this.cityIncludingFieldsInput.isDisplayed();
    }

    @FindBy(xpath = "(//select[contains(@name,'city_operator')])[2]")
    protected WebElement cityExcludingFieldsDropdown;

    public boolean cityExcludingFieldsDropdownIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.cityExcludingFieldsDropdown));
        return this.cityExcludingFieldsDropdown.isDisplayed();
    }

    @FindBy(xpath = "(//input[contains(@name,'city_text')])[2]")
    protected WebElement cityExcludingFieldsInput;

    public boolean cityExcludingFieldsInputIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.cityExcludingFieldsInput));
        return this.cityExcludingFieldsInput.isDisplayed();
    }
}