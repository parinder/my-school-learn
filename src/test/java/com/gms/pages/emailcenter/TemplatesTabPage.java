package com.gms.pages.emailcenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;

public class TemplatesTabPage extends ScheduledEmailsTabPage {

	public TemplatesTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.templatesIframe));
		this.driver.switchTo().frame("templatesFrame"); // switch to content frame
		this.wait.until(ExpectedConditions.visibilityOf(this.folderSortArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.subFolderSortArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.templatesTitle));

		this.wait.until(ExpectedConditions.visibilityOf(this.newFolderButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.newSubFolderButton));

		this.driver.switchTo().defaultContent(); // leave emailCenter iFrame
	}

	// templates title (main section)

	@FindBy(xpath = "//th[@id='pushColHead']")
	protected WebElement templatesTitle;
}
