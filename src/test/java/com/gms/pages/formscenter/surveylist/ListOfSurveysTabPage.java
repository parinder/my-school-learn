package com.gms.pages.formscenter.surveylist;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ListOfSurveysTabPage extends BasePage {

	public ListOfSurveysTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "survey/list";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.surveyListTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewSurveyButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewFolderButton));
	}

	// list of surevys title

	@FindBy(xpath = "//div[@id='listOfSurveys']/div[@class='centerFixedColumn']/div[@class='box']/h2")
	protected WebElement surveyListTitle;

	// create new survey button

	@FindBy(xpath = "//a[@id='createSurvey']")
	protected WebElement createNewSurveyButton;

	// create new folder button

	@FindBy(xpath = "//a[@id='createFolder']")
	protected WebElement createNewFolderButton;

	// survey list

	@FindBy(xpath = "//div[@id='listOfSurveys']/div[@class='centerFixedColumn']/div[@class='box']/div[@class = 'theList ui-sortable']")
	protected WebElement surveyList;

	public List<WebElement> getSurveyListRows() {
		this.wait.until(
				ExpectedConditions.visibilityOf(this.surveyList.findElement(By.xpath(".//div[@class='aSurvey']"))));
		return surveyList.findElements(By.xpath(".//div[@class='aSurvey']"));
	}

	public Integer getSurveyListRowCount() {
		List<WebElement> rows = this.getSurveyListRows();
		return rows.size();
	}

	public void clickSurveyListRowPreviewSurveyActionButton(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//div[@class='actions']"));
		WebElement button = actions.findElement(By.xpath(".//a[@title='Preview Survey']"));
		button.click();
	}

	public void clickSurveyListRowEditSurveyActionButton(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//div[@class='actions']"));
		WebElement button = actions.findElement(By.xpath(".//a[@title='Edit Survey']"));
		button.click();
	}

	public void clickSurveyListRowRenameSurveyActionButton(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//div[@class='actions']"));
		WebElement button = actions.findElement(By.xpath(".//a[@title='Rename Survey']"));
		button.click();
	}

	public void clickSurveyListRowCopySurveyActionButton(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//div[@class='actions']"));
		WebElement button = actions.findElement(By.xpath(".//form/a[@title='Copy Survey']"));
		button.click();
	}

	public void clickSurveyListRowDeleteSurveyActionButton(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement actions = row.findElement(By.xpath(".//div[@class='actions']"));
		WebElement button = actions.findElement(By.xpath(".//a[@title='Delete Survey']"));
		button.click();
	}

	public String getSurveyListRowName(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement status = row.findElement(By.xpath(".//div[@class='name']/a"));
		return status.getText();
	}

	public void clickSurveyListRowName(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement nameLink = row.findElement(By.xpath(".//div[@class='name']/a"));
		nameLink.click();
	}

	public String getSurveyListRowLiveSince(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement created = row.findElement(By.xpath(".//div[@class='created']"));
		return created.getText();
	}

	public String getSurveyListRowLastModified(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement modified = row.findElement(By.xpath(".//div[@class='modified']"));
		return modified.getText();
	}

	public String getSurveyListRowStatus(Integer index) {
		List<WebElement> rows = this.getSurveyListRows();
		WebElement row = rows.get(index);
		WebElement status = row.findElement(By.xpath(".//div[@class='status']/span"));
		return status.getAttribute("class");
	}

	// Loading Modal

	@FindBy(xpath = "//div[@id='console']")
	protected WebElement loadingModal;

	public void waitForLoadingModalIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loadingModal));
	}

	public void waitForLoadingModalIsInvisible() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.loadingModal));
	}

	public void waitForLoadingModal() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loadingModal));
		this.wait.until(ExpectedConditions.invisibilityOf(this.loadingModal));
	}
}