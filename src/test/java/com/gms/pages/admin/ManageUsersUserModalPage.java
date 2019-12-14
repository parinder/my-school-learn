package com.gms.pages.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ManageUsersUserModalPage extends BasePage {

	public ManageUsersUserModalPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "manageUsers";
	}

	public void waitToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.detailsTab));
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
	}

	// title

	@FindBy(xpath = "//div[@class='modal-header']/h4[@class='modal-title']")
	protected WebElement headerTitle;

	public String getheaderTitleText() {
		this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
		return this.headerTitle.getText();
	}

	// close button

	@FindBy(xpath = "//div[@class='modal-header']/button[@class='bootbox-close-button close']")
	protected WebElement headerCloseButton;

	public void clickHeaderCloseButton() {
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.headerCloseButton));
		this.headerCloseButton.click();
	}

	// details tab

	@FindBy(xpath = "//a[@id='viewLoginTabButton-details']")
	protected WebElement detailsTab;

	// username

	@FindBy(xpath = "//input[@id='username']")
	protected WebElement userNameInput;

	public void enterUserName(String userName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.userNameInput));
		this.userNameInput.clear();
		this.userNameInput.sendKeys(userName);
	}

	// password

	@FindBy(xpath = "//input[@id='password']")
	protected WebElement passwordInput;

	public void enterPassword(String password) {
		this.wait.until(ExpectedConditions.visibilityOf(this.passwordInput));
		this.passwordInput.clear();
		this.passwordInput.sendKeys(password);
	}

	// email address

	@FindBy(xpath = "//input[@id='user-email']")
	protected WebElement emailAddressInput;

	public void enterEmailAddress(String email) {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailAddressInput));
		this.emailAddressInput.clear();
		this.emailAddressInput.sendKeys(email);
	}

	// first name

	@FindBy(xpath = "//input[@id='user-first-name']")
	protected WebElement firstNameInput;

	public void enterFirstName(String firstName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameInput));
		this.firstNameInput.clear();
		this.firstNameInput.sendKeys(firstName);
	}

	// last name

	@FindBy(xpath = "//input[@id='user-last-name']")
	protected WebElement lastNameInput;

	public void enterLastName(String lastName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.lastNameInput));
		this.lastNameInput.sendKeys(lastName);
	}

	@FindBy(xpath = "//input[@id='user-middle-initial']")
	protected WebElement middleNameInput;

	public void enterMiddleName(String middleName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.middleNameInput));
		this.middleNameInput.sendKeys(middleName);
	}

	@FindBy(xpath = "//select[@name='languageCode']")
	protected WebElement languageDropdown;

	public void selectLanguage(String languageCode) {
		Select select = new Select(languageDropdown);
		select.selectByValue(languageCode);
	}

	// role tab

	@FindBy(xpath = "//a[@id='viewLoginTabButton-role']")
	protected WebElement roleTab;

	public void clickRoleTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.roleTab));
		this.roleTab.click();
	}

	public void waitForRoleTabToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.rolesTable));
	}

	// roles table search

	@FindBy(xpath = "//div[@id='rolesListTable_filter']/label/input[@class='form-control input-sm']")
	protected WebElement rolesTableFilterInput;

	public void enterRolesTableFilterInput(String role) {
		this.wait.until(ExpectedConditions.visibilityOf(this.rolesTableFilterInput));
		this.rolesTableFilterInput.sendKeys(role);
	}

	@FindBy(xpath = "//table[@id='rolesListTable']/tbody")
	protected WebElement rolesTable;

	public List<WebElement> getRolesTableRows() {
		return rolesTable.findElements(By.xpath(".//tr[@class='odd' or @class='even']"));
	}

	public Integer getRolesTableRowCount() {
		List<WebElement> rows = this.getRolesTableRows();
		return rows.size();
	}

	public void clickRolesTableItemRadioBox(Integer index) {
		List<WebElement> rows = this.getRolesTableRows();
		WebElement row = rows.get(index);
		WebElement columns = row.findElement(By.xpath(".//td[@class='sorting_1']"));
		WebElement radioBox = columns.findElement(By.xpath(".//label"));
		radioBox.click();
	}

	// Rezqueue tab

	@FindBy(xpath = "//a[@id='viewLoginTabButton-rezq']")
	protected WebElement rezqueueTab;

	public void clickRezqueueTab() {
		this.wait.until(ExpectedConditions.visibilityOf(this.rezqueueTab));
		this.rezqueueTab.click();
		this.wait.until(ExpectedConditions.visibilityOf(this.rezqueueTabSelectAllButton));
	}

	@FindBy(xpath = "//div[@id='rezqListTable_filter']/label/input[@class='form-control input-sm']")
	protected WebElement listOwnerPmsNameSearchInput;

	public void enterListOwnerPmsName(String listOwnerPmsName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPmsNameSearchInput));
		this.listOwnerPmsNameSearchInput.sendKeys(listOwnerPmsName);
	}

	// rezqueue tab list owner pms table

	@FindBy(xpath = "//table[@id='rezqListTable']/tbody")
	protected WebElement listOwnerPmsTable;

	public List<WebElement> getListOwnerPmsTableRows() {
		return listOwnerPmsTable.findElements(By.xpath(".//tr[@class='odd' or @class='even']"));
	}

	public Integer getListOwnerPmsTableRowsCount() {
		List<WebElement> rows = this.getListOwnerPmsTableRows();
		return rows.size();
	}

	public void clickListOwnerPmsTableItemCheckBox(Integer index) {
		List<WebElement> rows = this.getListOwnerPmsTableRows();
		WebElement row = rows.get(index);
		WebElement columns = row.findElement(By.xpath(".//td[@class='sorting_1']"));
		WebElement checkBox = columns.findElement(By.xpath(".//label"));
		checkBox.click();
	}

	public boolean listOwnerPmsTableItemCheckBoxIsSelected(Integer index) {
		List<WebElement> rows = this.getListOwnerPmsTableRows();
		WebElement row = rows.get(index);
		WebElement columns = row.findElement(By.xpath(".//td[@class='sorting_1']"));
		WebElement listOwnerPmsTableItemSelectedCheckBoxIsVisible = columns.findElement(By.xpath(".//label//input"));
		return listOwnerPmsTableItemSelectedCheckBoxIsVisible.getAttribute("class").contains("checked");
	}

	@FindBy(xpath = "//table[@id='rezqListTable']/tbody/tr/td[@class='dataTables_empty']")
	protected WebElement noRecordsTableItem;

	public boolean listOwnerPmsTableNoRecordsTableItemIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.noRecordsTableItem));
		return this.noRecordsTableItem.isDisplayed();
	}

	// rezqueue tab select all button

	@FindBy(xpath = "//a[@id='addAllLOP']")
	protected WebElement rezqueueTabSelectAllButton;

	// rezqueue tab deselect all button

	@FindBy(xpath = "//a[@id='removeAllLOP']")
	protected WebElement rezqueueTabRemoveAllButton;

	// save button

	// @FindBy(xpath =
	// "//div[@class='modal-footer']/button[@data-bb-handler='Save']")
	@FindBy(xpath = "//div[@class='modal-footer']/button[contains(text(), 'Save')]")
	protected WebElement saveButton;

	public void clickSaveButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.saveButton));
		this.saveButton.click();
	}

	// disable button

	@FindBy(xpath = "//div[@class='modal-footer']/button[@data-bb-handler='Disable']")
	protected WebElement disableButton;

	public void clickDisableButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.disableButton));
		this.disableButton.click();
	}

	// delete button

	@FindBy(xpath = "//div[@class='modal-footer']/button[@data-bb-handler='Delete']")
	protected WebElement deleteButton;

	public void clickDeleteButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.deleteButton));
		this.deleteButton.click();
	}

	// cancel button

	@FindBy(xpath = "//div[@class='modal-footer']/button[@data-bb-handler='Cancel']")
	protected WebElement cancelButton;

	public void clickCancelButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.cancelButton));
		this.cancelButton.click();
	}
}
