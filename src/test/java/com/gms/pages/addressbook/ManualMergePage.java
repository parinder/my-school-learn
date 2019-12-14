package com.gms.pages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ManualMergePage extends BasePage {

    public ManualMergePage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/viewdeduplicationcandidatecontroller.spr";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.RezqueueMergeCandidatesButton));
 		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//form[@id='listOwner']//h1")
    protected WebElement headerTitle;

    public String getHeaderTitleText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
        return this.headerTitle.getText();
    }

    @FindBy(xpath = "//button[@id='_requeue']//span[contains(text(),'Re-queue merge candidates.')]")
    protected WebElement RezqueueMergeCandidatesButton;

    public boolean rezqueueMergeCandidatesButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.RezqueueMergeCandidatesButton));
        return this.RezqueueMergeCandidatesButton.isDisplayed();
    }
}