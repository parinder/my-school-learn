package com.myschool.learn.gms.pages.pmscenter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class PmsRequestPage extends BasePage {

	@FindBy(xpath = "//div[@id='title_container']/div[@class='margins']/h1")
	public WebElement pmsTitle;

	public PmsRequestPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "pmsCenter/pmsRequest";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.listOfPmsRequestsTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewPmsRequestButton));
		this.wait.until(ExpectedConditions
				.visibilityOf(this.pmsRequestsTable.findElement(By.xpath(".//tr[@class='odd' or @class='even']"))));
	}

	@FindBy(xpath = "//div[@id='body']/div[@id='listOfSurveys']/div[@class='centerFixedColumn']/div[@class='greyBox']/a[@class='icon_button']")
	public WebElement createNewPmsRequestButton;

	public void clickCreateNewPmsRequestButton() {
		this.createNewPmsRequestButton.click();
	}

	public boolean createNewPmsRequestButtonIsVisible() {
		return this.createNewPmsRequestButton.isDisplayed();
	}

	@FindBy(xpath = "//div[@id='body']/div[@id='listOfSurveys']/div/div/h2")
	public WebElement listOfPmsRequestsTitle;

	public boolean listOfPmsRequestsTitleIsVisible() {
		return this.listOfPmsRequestsTitle.isDisplayed();
	}

	@FindBy(xpath = "//table[@id='listOfPmsRequests']/tbody")
	protected WebElement pmsRequestsTable;

	public List<WebElement> getPmsRequestsTableRows() {
		return pmsRequestsTable.findElements(By.xpath(".//tr[@class='odd' or @class='even']"));
	}

	public Integer getPmsRequestsTableRowCount() {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		return rows.size();
	}

	public String getPmsRequestsTableRowContents(Integer index) {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		WebElement row = rows.get(index);
		return row.getText();
	}

	// search functionality

	@FindBy(xpath = "//div[@id='listOfPmsRequests_filter']/label/input")
	public WebElement pmsRequestsSearchInput;

	public void enterPmsRequestSearch(String pmsRequestName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.pmsRequestsSearchInput));
		this.pmsRequestsSearchInput.sendKeys(pmsRequestName);
	}

	// editing

	public void hoverOverPmsRequestName(Integer index) {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		WebElement row = rows.get(index);
		Actions action = new Actions(this.driver);
		action.moveToElement(row).build().perform();
	}

	public boolean editActionButtonIsVisible(Integer index) {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//td[@class='actions']"));
		WebElement editButton = actions.findElement(By.xpath(".//a[@title='Click to edit']"));
		return editButton.isDisplayed();
	}

	public boolean deleteActionButtonIsVisible(Integer index) {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//td[@class='actions']"));
		WebElement deleteButton = actions.findElement(By.xpath(".//a[@title='Click to delete']"));
		return deleteButton.isDisplayed();
	}

	public void clickEditButton(Integer index) {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//td[@class='actions']"));
		WebElement editButton = actions.findElement(By.xpath(".//a[@title='Click to edit']"));
		editButton.click();
	}

	public void clickDeleteButton(Integer index) {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//td[@class='actions']"));
		WebElement deleteButton = actions.findElement(By.xpath(".//a[@title='Click to delete']"));
		deleteButton.click();
	}

	public void clickListOwnerPmsName(Integer index) {
		List<WebElement> rows = this.getPmsRequestsTableRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//td[@class='listOwnerPms  sorting_1']"));
		WebElement pmsRequestName = actions.findElement(By.xpath(".//a[@target='_blank']"));
		pmsRequestName.click();
	}

	// confirmation modal

	@FindBy(xpath = "//div[@id='dialog']/div[@id='buttons_nav_bar']/a[@class='icon_button ok']/span[@class='save']")
	public WebElement confirmationRequiredModalOkButton;

	public void clickConfirmationRequiredModalOkButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmationRequiredModalOkButton));
		this.confirmationRequiredModalOkButton.click();
	}

	@FindBy(xpath = "//div[@id='dialog']/div[@id='buttons_nav_bar']/a[@class='icon_button cancel']/span[@class='cancel']")
	public WebElement confirmationRequiredModalCancelButton;

	public void clickConfirmationRequiredModalCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmationRequiredModalCancelButton));
		this.confirmationRequiredModalCancelButton.click();
	}

	// table contents empty

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	protected WebElement noRecordsTableItem;

	public boolean noRecordsTableItemIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.noRecordsTableItem));
		return this.noRecordsTableItem.isDisplayed();
	}

	// wait till dialogbox is invisible

	public void waitForDialogBoxIsInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='dialog']")));
	}

}
