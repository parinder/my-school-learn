package com.gms.pages.rezqueue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class RezqueueMessengerPage extends BasePage {

	public RezqueueMessengerPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.rezqueue.baseurl") + "messenger/portal";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.rezqueueMessengerTitle));
	}

    @FindBy(xpath = "//h1[contains(text(),'Messenger')]")
	protected WebElement rezqueueMessengerTitle;
    
    @FindBy(xpath = "//span[@id='select2-selectProperty-container']")
    protected WebElement propertyDropdown;
    
    public boolean propertyIsSelected(String propertyName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertyDropdown));
        return propertyDropdown.getAttribute("title").contains(propertyName);
    }

	// send new message modal

	@FindBy(xpath = "//div[@id='sendNewMessage']//div[@class='modal-dialog']")
    protected WebElement sendNewMessageModalDialog;
	
    public boolean sendNewMessageModalDialogIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.sendNewMessageModalDialog));
        return this.sendNewMessageModalDialog.isDisplayed();
    }
	
	@FindBy(xpath = "//h4[contains(@class,'modal-title') and contains(text(),'Send New Message')]")
	protected WebElement sendNewMessageModalTitle;

    public void waitForSendNewMessageModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(sendNewMessageModalTitle));
        this.wait.until(ExpectedConditions.visibilityOf(sendNewMessageModalCloseButton));
    }
    
    public void waitForSendNewMessageModalToBeInVisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(sendNewMessageModalTitle));
        this.wait.until(ExpectedConditions.invisibilityOf(sendNewMessageModalCloseButton));
    }

	@FindBy(xpath = "//span[@data-role='remove']")
    protected WebElement profilesSendingToXButton;

    public void clickProfilesSendingToXButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profilesSendingToXButton));
        this.profilesSendingToXButton.click();
    }

    @FindBy(xpath = "//input[@name='email']")
    protected WebElement emailInput;

    public void enterEmail(String email) {
        this.wait.until(ExpectedConditions.visibilityOf(this.emailInput));
        this.emailInput.sendKeys(email);
    }

    @FindBy(xpath = "//button[@class='btn btn-blue findProfileToSendTo']")
    protected WebElement searchButton;

    public void clickSearchButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchButton));
        this.searchButton.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.resultsTableHeader));
    }

    // results table
    @FindBy(xpath = "//table[@id='searchResultsTable']//thead")
    protected WebElement resultsTableHeader;

    @FindBy(xpath = "//table[@id='searchResultsTable']//tbody")
    protected WebElement resultsTable;

    public List<WebElement> getResultsTableRows() {
        return resultsTable.findElements(By.xpath(".//tr[@class='goToProfile odd' or @class='goToProfile even']"));
    }

    public void clickResultsTableRow(Integer index) {
        List<WebElement> rows = this.getResultsTableRows();
        WebElement row = rows.get(index);
        row.click();
    }

    @FindBy(xpath = "//button[@class='btn btn-default btn-blue nextButton']")
    protected WebElement nextButton;

    public void clickNextButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.nextButton));
        this.nextButton.click();
    }

	@FindBy(xpath = "//div[contains(@class,'modal-footer')]//button[contains(@class,'close') and contains(@data-dismiss,'modal')]")
	protected WebElement sendNewMessageModalCloseButton;

	public void clickSendNewMessageModalClosebutton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.sendNewMessageModalCloseButton));
		this.sendNewMessageModalCloseButton.click();
	}

    @FindBy(xpath = "//div[@id='toast-container']//div[@class='toast fa-exclamation toast-danger']//div[@class='toast-message']")
    protected WebElement errorMessage;

    public String getErrorMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.errorMessage));
        return this.errorMessage.getText();
    }
}