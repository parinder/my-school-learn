package com.myschool.learn.pages.phptravels;

import com.myschool.learn.configurations.ConfigPhpTravels;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, ConfigPhpTravels configPhpTravels) {
        super(driver, configPhpTravels);
        this.url = this.configPhpTravels.getProperty("app.phptravels.baseurl");
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homePageTitle));
    }

    @FindBy(xpath="//div[@class='header-logo go-right']//a//img")
    public WebElement homePageTitle;

    public boolean homePageTitleIsVisible(){
        return this.homePageTitle.isDisplayed();
    }
}
