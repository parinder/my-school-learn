package com.myschool.learn.gms.pages.emailcenter.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class HtmlTabPage extends BasePage {

	public HtmlTabPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "emailCenter";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addRowButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.cancelButton));
	}

	@FindBy(how = How.ID, using = "htmlIframe")
	protected WebElement htmlIframe;

	public boolean htmlIframeIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.htmlIframe));
		return this.htmlIframe.isDisplayed();
	}

	// content table

	@FindBy(xpath = "//center[@id='zdEditorHtmlContent']/table[contains(@class,'zdEditor widthAdjuster bodyColorAdjuster')]/tbody")
	protected WebElement htmlContentTable;

	public List<WebElement> getHtmlContentTableRows() {
		this.wait.until(ExpectedConditions.visibilityOf(this.htmlContentTable.findElement(By.tagName("tr"))));
		return htmlContentTable.findElements(By.tagName("tr"));
	}

	public Integer getHtmlContentTableRowCount() {
		List<WebElement> rows = this.getHtmlContentTableRows();
		return rows.size();
	}

	public String getHtmlContentTableRowContents(Integer index) {
		List<WebElement> rows = this.getHtmlContentTableRows();
		WebElement row = rows.get(index);
		return row.getText();
	}

	public void clickHtmlContentTableRow(Integer index) {
		List<WebElement> rows = this.getHtmlContentTableRows();
		WebElement row = rows.get(index);
		row.click();
	}

	public void enterHtmlContentTableRowText(Integer index, String text) {
		List<WebElement> rows = this.getHtmlContentTableRows();
		WebElement row = rows.get(index);
		WebElement input = row.findElement(By.className("cke_editable"));
		input.sendKeys(text);
	}

	// add row button

	@FindBy(xpath = "//a[contains(@class, 'addRow')]")
	protected WebElement addRowButton;

	public boolean addRowButtonIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addRowButton));
		return this.addRowButton.isDisplayed();
	}

	public void clickAddRowButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addRowButton));
		this.addRowButton.click();
	}

	// save button

	@FindBy(how = How.ID, using = "saveHtml")
	protected WebElement saveButton;

	public void clickSaveButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.saveButton.click();
	}

	// cancel button

	@FindBy(xpath = "//a[contains(@class, 'icon_button')]/span[contains(@class, 'cancel')]")
	protected WebElement cancelButton;

	public void clickCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.cancelButton));
		this.cancelButton.click();
	}

	// loading modal

	@FindBy(how = How.ID, using = "loadingCover")
	protected WebElement loadingModal;

	public void waitForLoadingModal() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loadingModal));
		this.wait.until(ExpectedConditions.invisibilityOf(this.loadingModal));
	}

	// flash Message

	@FindBy(xpath = "//div[contains(@class, 'flashMessage')]")
	protected WebElement flashMessage;

	public void waitForFlashMessageToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.flashMessage));
	}

	public String getFlashMessageContents() {
		this.wait.until(ExpectedConditions.visibilityOf(this.flashMessage));
		return flashMessage.getText();
	}
}
