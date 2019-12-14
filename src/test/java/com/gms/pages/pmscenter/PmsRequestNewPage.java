package com.gms.pages.pmscenter;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class PmsRequestNewPage extends BasePage {

    @FindBy(xpath = "//div[@id='title_container']/div[@class='margins']/h1")
    public WebElement pmsTitle;

    public PmsRequestNewPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "pmsCenter/pmsRequest/new";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPmsDropdown));
        this.wait.until(ExpectedConditions.visibilityOf(this.pmsRequestTypeDropdown));
        this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
    }

    // list owner pms dropdown

    @FindBy(xpath = "//form[@name='pmsRequestForm']/p/span/span/span[@class='select2-selection select2-selection--single']")
    protected WebElement listOwnerPmsDropdown;

    public boolean listOwnerPmsDropdownIsVisible() {
        return this.listOwnerPmsDropdown.isDisplayed();
    }

    @FindBy(xpath = "//input[@class='select2-search__field']")
    protected WebElement listOwnerPmsInput;

    public void selectListOwnerDropdownOption(String listOwnerPmsName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPmsDropdown));
        this.listOwnerPmsDropdown.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPmsInput));
        this.listOwnerPmsInput.sendKeys(listOwnerPmsName);
        this.listOwnerPmsInput.sendKeys(Keys.ARROW_DOWN);
        this.listOwnerPmsInput.sendKeys(Keys.ENTER);
    }

    // pms request type dropdown

    @FindBy(xpath = "//select[@id='pmsRequestType']")
    protected WebElement pmsRequestTypeDropdown;

    public void selectPmsRequestType(String type) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pmsRequestTypeDropdown));
        Select select = new Select(pmsRequestTypeDropdown);
        select.selectByVisibleText(type);
    }

    // pms request name

    @FindBy(xpath = "//input[@name='name']")
    protected WebElement nameInput;

    public void enterPmsRequestName(String pmsRequestName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
        this.nameInput.clear();
        this.nameInput.sendKeys(pmsRequestName);
    }

    public void xclearPmsRequestNameInput() {
        this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
        this.nameInput.clear();
    }

    public void waitForPmsRequestNameToContainText(String expectedText) {
        this.wait.until(ExpectedConditions.attributeContains(nameInput, "value", expectedText));
    }

    // save button

    @FindBy(xpath = "//form[@name='pmsRequestForm']/p/button[@class='icon_button']/span[@class='save']")
    protected WebElement saveButton;

    public void clickSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
        this.saveButton.click();
    }

    // cancel button

    @FindBy(xpath = "//form[@name='pmsRequestForm']/p/a[@class='icon_button']/span[@class='cancel']")
    protected WebElement cancelButton;

    public void clickCancelButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.cancelButton));
        this.cancelButton.click();
    }
}
