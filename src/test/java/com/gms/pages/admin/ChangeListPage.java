package com.gms.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ChangeListPage extends BasePage {

	public ChangeListPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "o/Admin%20Menu//gms/manager/login?submit=changelist";
	}

	public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas");
		this.wait.until(ExpectedConditions.visibilityOf(this.changeListButton));
		this.driver.switchTo().defaultContent();
	}

	// select list

	@FindBy(xpath = "//select[@name='listid']")
	protected WebElement listSelect;

	public void selectList(String list) {
		this.wait.until(ExpectedConditions.visibilityOf(this.listSelect));
		Select select = new Select(listSelect);
		select.selectByVisibleText(list);
	}

	public Integer getListSelectOptionCount(){
		this.wait.until(ExpectedConditions.visibilityOf(this.listSelect));
		Select select = new Select(listSelect);
		return select.getOptions().size();
	}

	public String getListSelectOption( Integer index){
		this.wait.until(ExpectedConditions.visibilityOf(this.listSelect));
		Select select = new Select(listSelect);
		return select.getOptions().get(index.intValue()).getText();
	}

	// change list button

	@FindBy(xpath = "//input[@value='Change List']")
	protected WebElement changeListButton;

    public boolean changeListButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeListButton));
        return this.changeListButton.isDisplayed();
    }

	public void clickChangeListButton(){
		this.wait.until(ExpectedConditions.visibilityOf(this.changeListButton));
		this.changeListButton.click();
	}

}