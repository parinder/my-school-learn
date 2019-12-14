package com.gms.pages.emailcenter;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

import java.util.List;

public class ScheduledEmailsTabPage extends BasePage {

	public ScheduledEmailsTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.canvasIframe));
		this.driver.switchTo().frame("canvas"); // switch to content frame
		this.wait.until(ExpectedConditions.visibilityOf(this.pushIframe));
		this.driver.switchTo().frame("pushFrame"); // switch to content frame

		this.wait.until(ExpectedConditions.visibilityOf(this.searchByNameInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.searchIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.newFolderButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.folderSortArrow));

		this.wait.until(ExpectedConditions.visibilityOf(this.folderSortArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.subFolderSortArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.emailSortArrow));
		this.wait.until(ExpectedConditions.visibilityOf(this.folderTable));
		// new WebDriverWait(this.driver,
		// 25).until(ExpectedConditions.visibilityOf(this.subFolderTable));
		this.driver.switchTo().defaultContent(); // leave emailCenter iFrame
	}

	@FindBy(xpath = "//iframe[@id='canvas']")
	protected WebElement canvasIframe;

	@FindBy(xpath = "//iframe[@id='pushFrame']")
	protected WebElement pushIframe;

	@FindBy(xpath = "//iframe[@id='eventFrame']")
	protected WebElement eventIframe;

	@FindBy(xpath = "//iframe[@id='templatesFrame']")
	protected WebElement templatesIframe;

	@FindBy(xpath = "//img[contains(@src,'arrow_up') and contains(@id,'campaignSortOrderArrow')]")
	protected WebElement folderSortArrow;

	@FindBy(xpath = "//img[contains(@src,'arrow_up') and contains(@id,'folderSortOrderArrow')]")
	protected WebElement subFolderSortArrow;

	@FindBy(xpath = "//img[contains(@id,'pushSortOrderArrow')]")
	protected WebElement emailSortArrow;

	public boolean emailSortArrowIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailSortArrow));
		return this.emailSortArrow.isDisplayed();
	}

	public void clickEmailSortArrow() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailSortArrow));
		this.emailSortArrow.click();
	}

	@FindBy(xpath = "//a[contains(@id,'showCal')]//img[contains(@src,'calendar')]")
	protected WebElement calendarIconLink;

	@FindBy(xpath = "//img[contains(@id,'helpImg')]")
	protected WebElement helpIconLink;

	@FindBy(how = How.ID, using = "displayDropDown")
	protected WebElement displaySortDropdown;

	@FindBy(how = How.ID, using = "searchBox")
	protected WebElement searchByNameInput;

	public void enterSearch(String searchText) {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchByNameInput));
		this.searchByNameInput.clear();
		this.searchByNameInput.sendKeys(searchText);
	}

	@FindBy(xpath = "//a[contains(@onclick,'searchByName')]//i[contains(@class,'search')]")
	protected WebElement searchIcon;

	public void clickSearchIcon() {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchIcon));
		this.searchIcon.click();
	}

	@FindBy(how = How.ID, using = "newCampaignLink")
	protected WebElement newFolderButton;

	@FindBy(how = How.ID, using = "newFolderLink")
	protected WebElement newSubFolderButton;

	// folder table

	@FindBy(xpath = "//div[@id='campaignColumn']/table/tbody")
	protected WebElement folderTable;

	public List<WebElement> getFolderTableRows() {
		this.wait.until(ExpectedConditions.visibilityOf(this.folderTable.findElement(By.tagName("tr"))));
		return folderTable.findElements(By.tagName("tr"));
	}

	public Integer getFolderTableRowCount() {
		List<WebElement> rows = this.getFolderTableRows();
		return rows.size();
	}

	public String getFolderTableRowContents(Integer index) {
		List<WebElement> rows = this.getFolderTableRows();
		WebElement row = rows.get(index);
		return row.getText();
	}

	public void clickFolderTableRow(Integer index) {
		List<WebElement> rows = this.getFolderTableRows();
		WebElement row = rows.get(index);
		row.click();
	}

	// subfolder table

	@FindBy(xpath = "//div[@id='folderColumn']/table/tbody")
	protected WebElement subFolderTable;

	public List<WebElement> getSubFolderTableRows() {
		this.wait.until(ExpectedConditions.visibilityOf(this.subFolderTable.findElement(By.tagName("tr"))));
		return subFolderTable.findElements(By.tagName("tr"));
	}

	public Integer getSubFolderTableRowCount() {
		List<WebElement> rows = this.getSubFolderTableRows();
		return rows.size();
	}

	public String getSubFolderTableRowContents(Integer index) {
		List<WebElement> rows = this.getSubFolderTableRows();
		WebElement row = rows.get(index);
		return row.getText();
	}

	public void clickSubFolderTableRow(Integer index) {
		List<WebElement> rows = this.getSubFolderTableRows();
		WebElement row = rows.get(index);
		row.click();
	}

	// main email list

	@FindBy(xpath = "//div[@id='pushColumn']/table[contains(@class,'pushTable')]/tbody")
	protected WebElement emailTable;

	public List<WebElement> getEmailTableRows() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailTable.findElement(By.tagName("tr"))));
		return emailTable.findElements(By.tagName("tr"));
	}

	public Integer getEmailTableRowCount() {
		List<WebElement> rows = this.getEmailTableRows();
		return rows.size();
	}

	public String getEmailTableRowName(Integer index) {
		List<WebElement> rows = this.getEmailTableRows();
		WebElement row = rows.get(index);
		WebElement nameSpan = row.findElement(By.xpath(".//td/div/span[@class='pushName']"));
		return nameSpan.getText();
	}

	public String getEmailTableRowDescription(Integer index) {
		List<WebElement> rows = this.getEmailTableRows();
		WebElement row = rows.get(index);
		WebElement nameSpan = row.findElement(By.xpath(".//td/div/div[@class='push-desc']"));
		return nameSpan.getText();
	}

	public void clickEmailTableRow(Integer index) {
		List<WebElement> rows = this.getEmailTableRows();
		WebElement row = rows.get(index);
		row.click();
	}

	public void clickEmailTableRowDeleteIcon(Integer index) {
		List<WebElement> rows = this.getEmailTableRows();
		WebElement row = rows.get(index);
		WebElement deleteIcon = row.findElement(By.xpath("//td/div/img[@class='deleteIcon']"));
		deleteIcon.click();
	}

	public void waitForTextToBeInEmailTable(String expectedText) {
		this.wait.until(ExpectedConditions.textToBePresentInElement(emailTable, expectedText));
	}

}
