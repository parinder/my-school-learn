package com.myschool.learn.gms.pages.formscenter.survey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class ReportsTabPage extends BasePage {

	public ReportsTabPage(WebDriver driver, Config config) {
		super(driver, config);
	}

	public void waitForPageLoad() {
		this.driver.switchTo().frame("reportIframe");
		this.wait.until(ExpectedConditions.visibilityOf(this.pdfReportViewerIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.xlsReportViewerIcon));
		this.driver.switchTo().defaultContent();
	}

	// reports tab

	@FindBy(xpath = "//a[contains(@href,'format=pdf')]/img")
	protected WebElement pdfReportViewerIcon;

	public void clickPdfReportViewerIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pdfReportViewerIcon));
		this.pdfReportViewerIcon.click();
	}

	@FindBy(xpath = "//a[contains(@href,'_format=xls')]/img")
	protected WebElement xlsReportViewerIcon;

	public void clickXlsReportViewerIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(this.xlsReportViewerIcon));
		this.xlsReportViewerIcon.click();
	}
}