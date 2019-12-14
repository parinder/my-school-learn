package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class NavigationBarPage extends BasePage {

    public NavigationBarPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addressbookTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.filtersTab));
        this.wait.until(ExpectedConditions.visibilityOf(this.profilesTab));
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewFilterButton));
    }

    // Address Book title

    @FindBy(xpath = "//h1[contains(text(),'Address Book')]")
    protected WebElement addressbookTitle;

    // Filters Tab

    @FindBy(xpath = "//div[@id='tab_filters']")
    protected WebElement filtersTab;

    public void clickFiltersTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filtersTab));
        this.filtersTab.click();
    }

    // Profiles Tab

    @FindBy(xpath = "//div[@id='tab_profiles']")
    protected WebElement profilesTab;

    public void clickProfilesTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profilesTab));
        this.profilesTab.click();
    }

    @FindBy(xpath = "//div[@class='margins']//a[contains(@class,'icon_button')]")
    protected WebElement addNewFilterButton;

    public void clickAddNewFilterButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewFilterButton));
        this.addNewFilterButton.click();
    }
}