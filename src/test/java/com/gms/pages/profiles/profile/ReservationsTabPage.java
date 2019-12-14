package com.gms.pages.profiles.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ReservationsTabPage extends BasePage {

    public ReservationsTabPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reservationsTabContainer));
    }

    @FindBy(xpath = "//div[@id='reservationsTab' and contains(@class, 'active')]")
    protected WebElement reservationsTabContainer;
}
