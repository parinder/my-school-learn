package com.myschool.learn.gms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;

public class WorkflowPage extends BasePage {

	public WorkflowPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "workflow/";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.workflowTitle));
	}

	@FindBy(xpath = "//h1[contains(text(),'Workflow')]")
	public WebElement workflowTitle;
}
