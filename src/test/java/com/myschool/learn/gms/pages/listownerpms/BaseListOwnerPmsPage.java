package com.myschool.learn.gms.pages.listownerpms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class BaseListOwnerPmsPage extends BasePage {

	public BaseListOwnerPmsPage(WebDriver driver, Config config) {
		super(driver, config);
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsTitle));
		this.driver.switchTo().frame("canvas");
		this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.driver.switchTo().defaultContent();
	}

	// header

	@FindBy(xpath = "//div[@id='title_container']/div[@class='margins']/h1")
	public WebElement pmsTitle;

	// in canvas iframe

	// name input

	@FindBy(xpath = "//input[@id='name']")
	public WebElement nameInput;

	public void enterName(String name) {
		this.wait.until(ExpectedConditions.visibilityOf(this.nameInput));
		this.nameInput.clear();
		this.nameInput.sendKeys(name);
	}

	// pms type

	@FindBy(xpath = "//select[@id='pms']")
	protected WebElement pmsTypeDropdown;

	public void selectPmsType(String type) {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsTypeDropdown));
		Select select = new Select(pmsTypeDropdown);
		select.selectByVisibleText(type);
	}

	// save button

	@FindBy(xpath = "//input[@value='Save']")
	public WebElement saveButton;

	public void clickSaveButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.saveButton.click();
	}
}
