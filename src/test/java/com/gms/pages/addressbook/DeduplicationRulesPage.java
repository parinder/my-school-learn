package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class DeduplicationRulesPage extends BasePage {

    public DeduplicationRulesPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/viewdeduplicationrulecontroller.spr";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.editDeduplicationSettingsLink));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }
    
    @FindBy(xpath = "//h1[starts-with(text(),'Deduplication Rules')]")
    protected WebElement headerTitle;

    public String getHeaderTitleText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
        return this.headerTitle.getText();
    }

    @FindBy(xpath = "//div[@id='basic-modal']//a[text()='Edit Deduplication Settings']")
    protected WebElement editDeduplicationSettingsLink;

    public boolean editDeduplicationSettingsLinkIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.editDeduplicationSettingsLink));
        return this.editDeduplicationSettingsLink.isDisplayed();
    }
    
}