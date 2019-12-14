package com.myschool.learn.gms.pages.formscenter.survey;

import org.openqa.selenium.WebDriver;
import com.myschool.learn.gms.configuration.Config;

public class ThankYouPagesTabPage extends SurveyPagesTabPage {

	public ThankYouPagesTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "survey";
	}
}