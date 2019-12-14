package com.gms.pages.propertymanager;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homeLink));
        this.wait.until(ExpectedConditions.visibilityOf(this.homeLink));
        this.wait.until(ExpectedConditions.visibilityOf(this.homeLink));
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']/li/a[contains(text(),'Home')]")
    protected WebElement homeLink;

    public void clickHomeLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homeLink));
        this.homeLink.click();
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']/li/a[contains(text(),'PMS')]")
    protected WebElement pmsLink;

    public void clickPmsLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homeLink));
        this.pmsLink.click();
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']/li/a[contains(text(),'Property Manager')]")
    protected WebElement propertyManagerLink;

    public void clickPropertyManagerLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.homeLink));
        this.propertyManagerLink.click();
    }
}