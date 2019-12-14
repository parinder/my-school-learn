package com.gms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;

public class ReportsPage extends BasePage {

	public ReportsPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "reports";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.reportsTitle));
	}

	@FindBy(xpath = "//h1[contains(text(),'Reports')]")
	protected WebElement reportsTitle;

	@FindBy(xpath = "//#body > div //*[@id=\"body\"]/div[contains(text(),'Please select a Report from')]")
	protected WebElement directionsText;
}
