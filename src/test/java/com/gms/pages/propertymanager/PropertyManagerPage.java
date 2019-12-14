package com.gms.pages.propertymanager;

import java.util.List;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PropertyManagerPage extends BasePage {

    public PropertyManagerPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "propertyManager";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.editPropertyButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.newPropertyButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.editCategoryButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.newCategoryButton));
    }

    // property dropdown

    @FindBy(xpath = "//span[@id='select2-edit-property-select-container']")
    protected WebElement propertyDropdown;

    public void clickPropertyDropdown() {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertyDropdown));
        this.propertyDropdown.click();
    }

    // property dropdown search input

    @FindBy(xpath = "//span[@class='select2-dropdown select2-dropdown--below']/span[@class='select2-search select2-search--dropdown']/input")
    protected WebElement propertyDropdownSearchInput;

    public void enterPropertyDropdownSearch(String text) {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertyDropdownSearchInput));
        this.propertyDropdownSearchInput.clear();
        this.propertyDropdownSearchInput.sendKeys(text);
    }

    // property dropdown results

    @FindBy(xpath = "//ul[@id='select2-edit-property-select-results']")
    protected WebElement propertyDropdownResultsList;

    public List<WebElement> getPropertyDropdownListRows() {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertyDropdownResultsList));
        return propertyDropdownResultsList.findElements(By.xpath(".//li"));
    }

    public Integer getPropertyDropdownListRowCount() {
        List<WebElement> rows = this.getPropertyDropdownListRows();
        return rows.size();
    }

    public String getPropertyDropdownListRowName(Integer index) {
        List<WebElement> rows = this.getPropertyDropdownListRows();
        WebElement row = rows.get(index);
        return row.getText();
    }

    public void clickPropertyDropdownListRow(Integer index) {
        List<WebElement> rows = this.getPropertyDropdownListRows();
        WebElement row = rows.get(index);
        row.click();
    }

    // edit property button

    @FindBy(xpath = "//button[@id='edit-property-btn']")
    protected WebElement editPropertyButton;

    public void clickEditPropertyButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.editPropertyButton));
        this.editPropertyButton.click();
    }

    // new property button

    @FindBy(xpath = "//button[@id='add-property-btn']")
    protected WebElement newPropertyButton;

    public void clickNewPropertyButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.newPropertyButton));
        this.newPropertyButton.click();
    }

    // edit category button

    @FindBy(xpath = "//button[@id='edit-category-btn']")
    protected WebElement editCategoryButton;

    public void clickEditCategoryButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.editCategoryButton));
        this.editCategoryButton.click();
    }

    @FindBy(xpath = "//button[@id='add-category-btn']")
    protected WebElement newCategoryButton;

    public void clickNewCategoryyButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.newCategoryButton));
        this.newCategoryButton.click();
    }
}