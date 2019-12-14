package com.gms.pages.formscenter;

import org.openqa.selenium.WebDriver;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ThankYouPreviewPage extends BasePage {

	public ThankYouPreviewPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "survey";
	}
}