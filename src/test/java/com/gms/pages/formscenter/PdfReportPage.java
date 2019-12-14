package com.gms.pages.formscenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class PdfReportPage extends BasePage {

	public PdfReportPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl");
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.urlContains("_report"));
	}
}