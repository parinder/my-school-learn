package com.myschool.learn.gms.pages.formscenter.surveylist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class KpisTabPage extends BasePage {

	public KpisTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "survey/list";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.kpiListTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.kpiListSearchIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.kpiListSearchInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.kpiListSearchCleanButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewKpiButton));
	}

	// kpi table title

	@FindBy(xpath = "//div[@id='kpiManager']/div/div/h2[contains(text(),'List of KPI')]")
	protected WebElement kpiListTitle;

	@FindBy(xpath = "//div[@id='kpiManager']/div/div/div[@class='searchFilter']/span[contains(@class,'lupa')]")
	protected WebElement kpiListSearchIcon;

	@FindBy(xpath = "//div[@id='kpiManager']/div/div/div[@class='searchFilter']/input[@id='librarySearch']")
	protected WebElement kpiListSearchInput;

	public void enterKpiListSearchInputText(String searchText) {
		this.wait.until(ExpectedConditions.visibilityOf(this.kpiListSearchInput));
		kpiListSearchInput.sendKeys(searchText);
	}

	@FindBy(xpath = "//div[@id='kpiManager']/div/div/div[@class='searchFilter']/a[@id='cleanSearch']")
	protected WebElement kpiListSearchCleanButton;

	// kpis list

	// create new kpi button

	@FindBy(xpath = "//a[@title = 'Create New KPI']")
	protected WebElement createNewKpiButton;

	public void clickCreateNewKpiButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewKpiButton));
		this.createNewKpiButton.click();
	}

	// create new kpi modal

	@FindBy(xpath = "//div[@id='dialog']/form[@id='newKpi']")
	protected WebElement createNewKpiModal;

	public void WaitForCreateNewKpiModalToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewKpiModal));
	}

	public void waitForCreateNewKpiModalToBeInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.createNewKpiModal));
	}

	// create new kpi modal kpi name

	@FindBy(xpath = "//div[@id='dialog']/form[@id='newKpi']/input")
	protected WebElement createNewKpiModalKpiNameInput;

	public void enterCreateNewKpiModalKpiName(String name) {
		this.wait.until(ExpectedConditions.invisibilityOf(this.createNewKpiModal));
		this.createNewKpiModal.sendKeys(name);
	}

	// create new kpi modal save button

	@FindBy(xpath = "//div[@id='dialog']/form[@id='newKpi']/div[@id='wizard_nav_bar']/a[@class='icon_button saveAjaxPost']")
	protected WebElement createNewKpiModalKpiSaveButton;

	// create new kpi modal cancel button

	@FindBy(xpath = "//div[@id='dialog']/form[@id='newKpi']/div[@id='wizard_nav_bar']/a[@class='icon_button cancel']")
	protected WebElement createNewKpiModalCancelButton;

	public void clickCreateNewKpiModalCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewKpiModalCancelButton));
		this.createNewKpiModalCancelButton.click();
	}

	// Loading Modal

	@FindBy(xpath = "//div[@id='console']")
	protected WebElement loadingModal;

	public void waitForLoadingModal() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loadingModal));
		this.wait.until(ExpectedConditions.invisibilityOf(this.loadingModal));
	}
}