package com.gms.pages.listownerpms;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListOwnerPmsManagerPage extends BasePage {

	public ListOwnerPmsManagerPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "pmsCenter/o//gms/editobject.spr?className=ListOwnerPms";

	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsTitle));
		this.driver.switchTo().frame("canvas");
		this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPmsDropdownArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.editButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.newButton));
		this.driver.switchTo().defaultContent();
	}

	// header

	@FindBy(xpath = "//div[@id='title_container']/div[@class='margins']/h1")
	public WebElement pmsTitle;

	// edit title - Please select a ListOwnerPms to edit and click "Edit", or click
	// "New" to create a new object."

	// listownerpms dropdown

	@FindBy(xpath = "//span[@class='select2-selection__arrow']")
	protected WebElement listOwnerPmsDropdownArrow;

	public void clickListOwnerPmsDropdownArrow() {
		this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPmsDropdownArrow));
		this.listOwnerPmsDropdownArrow.click();
	}

	@FindBy(xpath = "//input[contains(@class,'select2-search__field') and contains(@type,'search')]")
	protected WebElement listOwnerPmsSearchInput;

	public void selectLopViaSearch(String listOwnerPmsName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPmsSearchInput));
		listOwnerPmsSearchInput.sendKeys(listOwnerPmsName);
		listOwnerPmsSearchInput.sendKeys(Keys.ARROW_DOWN);
		listOwnerPmsSearchInput.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//b[contains(@class,'results-title')]")
	protected WebElement onPropertyGuestsTableTitle;

	public String getOnPropertyGuestsTableTitle() {
		this.wait.until(ExpectedConditions.visibilityOf(this.onPropertyGuestsTableTitle));
		return this.onPropertyGuestsTableTitle.getText();
	}

	// edit button

	@FindBy(xpath = "//input[@type='submit' and @value='Edit']")
	protected WebElement editButton;

	public void clickEditButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.editButton));
		this.editButton.click();
	}

	// new button

	@FindBy(xpath = "//input[@type='submit' and @value='New']")
	protected WebElement newButton;

	public void clickNewButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.newButton));
		this.newButton.click();
	}
}
