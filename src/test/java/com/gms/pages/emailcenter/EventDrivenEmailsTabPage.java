package com.gms.pages.emailcenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;

public class EventDrivenEmailsTabPage extends ScheduledEmailsTabPage {

	public EventDrivenEmailsTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.eventIframe));
		this.driver.switchTo().frame("eventFrame"); // switch to content frame
		this.wait.until(ExpectedConditions.visibilityOf(this.folderSortArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.subFolderSortArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.emailSortArrow));
		this.driver.switchTo().defaultContent(); // leave emailCenter iFrame
	}
}
