package com.gms.pages.formscenter.surveylist;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class QuestionManagerTabPage extends BasePage {

	public QuestionManagerTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "survey/list";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.questionListTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.questionListSearchIcon));
		this.wait.until(ExpectedConditions.visibilityOf(this.questionListSearchInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.questionListSearchCleanButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionButton));
	}

	// question list title

	@FindBy(xpath = "//div[@id='questionManager']/div/div/h2[contains(text(),'Your List of Questions')]")
	protected WebElement questionListTitle;

	@FindBy(xpath = "//div[@id='questionManager']/div/div/div[@class='searchFilter']/span[contains(@class,'lupa')]")
	protected WebElement questionListSearchIcon;

	@FindBy(xpath = "//div[@id='questionManager']/div/div/div[@class='searchFilter']/input[@id='librarySearch']")
	protected WebElement questionListSearchInput;

	public void enterQuestionListSearchInputText(String searchText) {
		this.wait.until(ExpectedConditions.visibilityOf(this.questionListSearchInput));
		questionListSearchInput.sendKeys(searchText);
	}

	@FindBy(xpath = "//div[@id='questionManager']/div/div/div[@class='searchFilter']/a[@id='cleanSearch']")
	protected WebElement questionListSearchCleanButton;

	@FindBy(xpath = "//div[@id='questionManager']/div/div/a[@title='Create a new Question']")
	protected WebElement createNewQuestionButton;

	public void clickCreateNewQuestionButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionButton));
		this.createNewQuestionButton.click();
	}

	// new question modal

	@FindBy(xpath = "//div[contains(@class,'ui-dialog')]/div[@id='dialog']")
	protected WebElement createNewQuestionModal;

	public void waitForCreateNewQuestionModalToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionModal));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionModalTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionModalNextButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionModalCancelButton));
	}

	public void waitForCreateNewQuestionModalToBeInvisible() {
		// the the invisibilityof expected condition is not working properly
		// new WebDriverWait(this.driver,
		// 25).until(ExpectedConditions.invisibilityOf(this.createNewQuestionModal));
		// used this instead and it works
		this.wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-dialog')]/div[@id='dialog']")));
	}

	@FindBy(xpath = "//span[@id='ui-dialog-title-dialog']")
	protected WebElement createNewQuestionModalTitle;

	@FindBy(xpath = "//form[@id='newQuestion']/div[@id='wizard_nav_bar']/a[contains(@class,'next')]")
	protected WebElement createNewQuestionModalNextButton;

	public boolean createNewQuestionModalNextButtonIsDisabled() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionModalNextButton));
		return this.createNewQuestionModalNextButton.getAttribute("class").contains("disabled");
	}

	public void clickCreateNewQuestionModalNextButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionModalCancelButton));
		this.createNewQuestionModalCancelButton.click();
	}

	@FindBy(xpath = "//form[@id='newQuestion']/div[@id='wizard_nav_bar']/a[contains(@class,'cancel')]")
	protected WebElement createNewQuestionModalCancelButton;

	public void clickCreateNewQuestionModalCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.createNewQuestionModalCancelButton));
		this.createNewQuestionModalCancelButton.click();
	}

	@FindBy(xpath = "//form[@id='newQuestion']/div[@id='first']/div[@class='leftDiv']")
	protected WebElement questionTypeRadioButtonList;

	public List<WebElement> getQuestionTypes() {
		this.wait.until(
				ExpectedConditions.visibilityOf(this.questionTypeRadioButtonList.findElement(By.tagName("div"))));
		return questionTypeRadioButtonList.findElements(By.tagName("div"));
	}

	public Integer getQuestionTypeCount() {
		List<WebElement> rows = this.getQuestionTypes();
		return rows.size();
	}

	public String getQuestionTypeText(Integer index) {
		List<WebElement> rows = this.getQuestionTypes();
		WebElement row = rows.get(index);
		WebElement span = row.findElement(By.tagName("span"));
		return span.getText();
	}

	public void clickQuestionType(Integer index) {
		List<WebElement> rows = this.getQuestionTypes();
		WebElement row = rows.get(index);
		row.click();
	}

	// Loading Modal
	@FindBy(xpath = "//div[@id='console']")
	protected WebElement loadingModal;

	public void waitForLoadingModal() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loadingModal));
		this.wait.until(ExpectedConditions.invisibilityOf(this.loadingModal));
	}
}