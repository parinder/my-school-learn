package com.gms.pages.formscenter.surveylist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class HeaderPage extends BasePage {

	public HeaderPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "survey/list";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.formsCenterTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.listOfSurveysTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.upgradeFormsTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.questionManagerTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.kpisTab));
	}

	// Forms Center title

	@FindBy(xpath = "//h1[contains(text(),'Forms Center')]")
	protected WebElement formsCenterTitle;

	// header list of surveys tab

	@FindBy(how = How.ID, using = "tab_list_surveys")
	protected WebElement listOfSurveysTab;

	public boolean listOfSurveysTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.listOfSurveysTab));
		String classes = listOfSurveysTab.getAttribute("class");
		return classes.contains("current");
	}

	public void clickListOfSurveysTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.listOfSurveysTab));
		this.listOfSurveysTab.click();
	}

	// header upgrade forms tab

	@FindBy(how = How.ID, using = "tab_list_upgrade_forms")
	protected WebElement upgradeFormsTab;

	public boolean upgradeFormsTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.upgradeFormsTab));
		String classes = upgradeFormsTab.getAttribute("class");
		return classes.contains("current");
	}

	public void clickUpgradeFormsTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.upgradeFormsTab));
		this.upgradeFormsTab.click();
	}

	// header question manager tab

	@FindBy(how = How.ID, using = "tab_question_manager")
	protected WebElement questionManagerTab;

	public boolean questionManagerTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.questionManagerTab));
		String classes = questionManagerTab.getAttribute("class");
		return classes.contains("current");
	}

	public void clickQuestionManagerTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.questionManagerTab));
		this.questionManagerTab.click();
	}

	// header kpis Tab

	@FindBy(how = How.ID, using = "tab_question_kpi")
	protected WebElement kpisTab;

	public boolean kpisTabIsSelected() {
		this.wait.until(ExpectedConditions.visibilityOf(this.kpisTab));
		String classes = kpisTab.getAttribute("class");
		return classes.contains("current");
	}

	public void clickKpisTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.kpisTab));
		this.kpisTab.click();
	}
}