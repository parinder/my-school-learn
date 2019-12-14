package com.gms.pages.surveys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class BaseSurveyPage extends BasePage {

	public BaseSurveyPage(WebDriver driver, Config config) {
		super(driver, config);
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailInput));
	}

	// opt in checkbox

	@FindBy(xpath = "//div[@id='optInCheckbox']/div[@class='ui-checkbox']")
	protected WebElement optInCheckbox;

	public void clickOptInCheckbox() {
		this.wait.until(ExpectedConditions.visibilityOf(this.optInCheckbox));
		this.optInCheckbox.click();
	}

	// email element

	@FindBy(xpath = "//div[@id='fieldBlockemailinput']/div/input")
	public WebElement emailInput;

	public void enterEmail(String email) {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailInput));
		this.emailInput.clear();
		this.emailInput.sendKeys(email);
	}

	// date elements

	@FindBy(xpath = "//div[@id='ui-datepicker-div']")
	public WebElement datePickerPopUp;

	public void enterDateAnswer(String fieldId, String date) {
		WebElement dateElement = this.driver.findElement(By.xpath("//input[@id='date" + fieldId + "']"));
		this.wait.until(ExpectedConditions.visibilityOf(dateElement));
		dateElement.sendKeys(date);
		this.wait.until(ExpectedConditions.visibilityOf(this.datePickerPopUp));
		dateElement.sendKeys(Keys.ENTER);
		this.wait.until(ExpectedConditions.invisibilityOf(this.datePickerPopUp));
	}

	// single select

	public void clickSingleAnswer(String fieldId, Integer index) {
		WebElement answerBlockElement = this.driver.findElement(
				By.xpath("//div[@id='answerBlock" + fieldId + "']/fieldset/div[@class='ui-controlgroup-controls ']"));
		List<WebElement> answers = answerBlockElement.findElements(By.xpath("./div[@class='ui-radio']"));
		answers.get(index).click();
	}

	// multiple select

	public void clickMultipleAnswer(String fieldId, Integer index) {
		WebElement answerBlockElement = this.driver.findElement(
				By.xpath("//div[@id='answerBlock" + fieldId + "']/fieldset/div[@class='ui-controlgroup-controls ']"));
		List<WebElement> answers = answerBlockElement.findElements(By.xpath("./div[@class='ui-checkbox']"));
		answers.get(index).click();
	}

	// nps

	@FindBy(xpath = "//div[@id='answerBlock81003']/fieldset/div")
	public WebElement npsScore;

	public void clickNpsAnswer(String fieldId, Integer index) {
		WebElement answerBlockElement = this.driver.findElement(
				By.xpath("//div[@id='answerBlock" + fieldId + "']/fieldset/div[@class='ui-controlgroup-controls ']"));
		List<WebElement> answers = answerBlockElement.findElements(By.xpath("./div[@class='ui-radio']"));
		answers.get(index).click();
	}

	// group question

	public void clickGroupAnswer(String fieldId, Integer questionIndex, Integer answerIndex) {
		WebElement answerBlockElement = this.driver.findElement(By.xpath("//div[@id='answerBlock" + fieldId + "']"));
		List<WebElement> questions = answerBlockElement
				.findElements(By.xpath("./fieldset/div[@class='ui-controlgroup-controls ']"));
		WebElement question = questions.get(questionIndex);
		List<WebElement> answers = question.findElements(By.xpath("./div[@class='ui-radio']"));
		answers.get(answerIndex).click();
	}

	// free form comment

	public void enterFreeFormCommentAnswer(String fieldId, String answer) {
		WebElement freeFormCommentAnswerTextArea = this.driver
				.findElement(By.xpath("//div[@id='answerBlock" + fieldId + "']/textarea"));
		freeFormCommentAnswerTextArea.clear();
		freeFormCommentAnswerTextArea.sendKeys(answer);
	}

	// submit button

	@FindBy(xpath = "//div[@id='submitButton']/button")
	public WebElement submitButton;

	public void clickSubmitButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.submitButton));
		this.submitButton.click();
	}

	// text area

	@FindBy(xpath = "//body/form/div[@id='surveyStart']/div[@class='textBlock']")
	public WebElement thankYouText;

	public boolean textBlockIsVisible(String text) {
		String xpath = "//body/form/div[@id='surveyStart']/div[@class='textBlock' and contains(text(), '" + text
				+ "')]";
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		WebElement textBlockElement = this.driver.findElement(By.xpath(xpath));
		return textBlockElement.isDisplayed();
	}

	// cell phone number (not international)

	@FindBy(xpath = "//div[@id='surveyStart']/div[@id='fieldBlockcellPhone']/div[@id='fieldBlockcellPhoneinput']/div[1]/input")
	public WebElement cellPhoneNumberAreaCode;

	@FindBy(xpath = "//div[@id='surveyStart']/div[@id='fieldBlockcellPhone']/div[@id='fieldBlockcellPhoneinput']/div[2]/input")
	public WebElement cellPhoneNumberFirstDigits;

	@FindBy(xpath = "//div[@id='surveyStart']/div[@id='fieldBlockcellPhone']/div[@id='fieldBlockcellPhoneinput']/div[3]/input")
	public WebElement cellPhoneNumberLastDigits;

	public void enterCellPhoneNumber(String areaCode, String firstDigits, String lastDigits) {

		this.wait.until(ExpectedConditions.visibilityOf(cellPhoneNumberAreaCode));
		cellPhoneNumberAreaCode.clear();
		cellPhoneNumberAreaCode.sendKeys(areaCode);

		this.wait.until(ExpectedConditions.visibilityOf(cellPhoneNumberFirstDigits));
		cellPhoneNumberFirstDigits.clear();
		cellPhoneNumberFirstDigits.sendKeys(firstDigits);

		this.wait.until(ExpectedConditions.visibilityOf(cellPhoneNumberLastDigits));
		cellPhoneNumberLastDigits.clear();
		cellPhoneNumberLastDigits.sendKeys(lastDigits);
	}

	@FindBy(xpath = "//div[@id='surveyStart']/div[@id='fieldBlockcellPhone']/div[@id='fieldBlockcellPhoneinput']/span[@class='inline errorString']")
	public WebElement cellPhoneNumberErrorMessage;

	public String getCellPhoneNumberErrorMessage() {
		this.wait.until(ExpectedConditions.visibilityOf(cellPhoneNumberErrorMessage));
		return cellPhoneNumberErrorMessage.getText();
	}

	public boolean cellPhoneNumberErrorMessageIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(cellPhoneNumberAreaCode));
		String xpath = "//div[@id='surveyStart']/div[@id='fieldBlockcellPhone']/div[@id='fieldBlockcellPhoneinput']/span[@class='inline errorString']";
		return this.driver.findElements(By.xpath(xpath)).size() > 0;
	}

	public void replaceFormActionBaseUrl(String actualUrl, String replacementUrl) {
		// this is a total hack
		// can be removed once we no longer use a prod copy of data in p1
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		String jsCommand = "document.getElementsByTagName('form').item(0).action = "
				+ "document.getElementsByTagName('form').item(0).action.replace('" + actualUrl + "','" + replacementUrl
				+ "');";
		js.executeScript(jsCommand);
	}
}