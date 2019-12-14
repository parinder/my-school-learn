package com.gms.pages.profiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class MergeProfilePage extends BasePage {

    public MergeProfilePage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
     }

    @FindBy(xpath = "//h1[starts-with(text(),'Potential Matches')]")
    protected WebElement headerTitle;

    public String getHeaderTitleText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
        return this.headerTitle.getText();
    }

    @FindBy(xpath = "//span[@class='button-selectAll']")
    protected WebElement selectAllButton;

    public boolean selectAllButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.selectAllButton));
        return this.selectAllButton.isDisplayed();
    }
}