package com.myschool.learn.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class FiltersHomePage extends BasePage {

    public FiltersHomePage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "addressBook/filters";
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filtersUseDirections));
    }

    @FindBy(xpath = "//div[@class='use_directions']")
    protected WebElement filtersUseDirections;
    
    public boolean filtersUserDirectionsIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filtersUseDirections));
        return this.filtersUseDirections.isDisplayed();
    }
}