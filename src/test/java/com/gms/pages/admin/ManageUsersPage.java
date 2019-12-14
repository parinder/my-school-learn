package com.gms.pages.admin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ManageUsersPage extends BasePage {

	public ManageUsersPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "manageUsers";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.newRoleButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.rolesTable));
        this.wait.until(ExpectedConditions.visibilityOf(this.rolesTableEditLink));
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.newUserButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.usersTable));
	    this.wait.until(ExpectedConditions.visibilityOf(this.usersTableEditLink));
	}

	// new role button

	@FindBy(xpath = "//a[@id='newRole']")
	protected WebElement newRoleButton;

	public boolean newRoleButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.newRoleButton));
        return this.newRoleButton.isDisplayed();
    }
	
	public void clickNewRoleButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.newRoleButton));
		this.newRoleButton.click();
	}

	// roles search input

	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input[@class='form-control input-sm']")
	protected WebElement rolesSearchInput;

	public void enterRolesSearchInput(String role) {
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.rolesSearchInput));
		this.rolesSearchInput.sendKeys(role);
	}

	// roles table

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody")
	protected WebElement rolesTable;

	public List<WebElement> getRolesTableRows() {
		return rolesTable.findElements(By.xpath(".//tr[@class='roleListRow odd' or @class='roleListRow even']"));
	}

	public Integer getRolesTableRowsCount() {
		List<WebElement> rows = this.getRolesTableRows();
		return rows.size();
	}
	
	 public void waitForTextToBeInRolesTable(String expectedText) {
		this.wait.until(ExpectedConditions.textToBePresentInElement(rolesTable, expectedText));
	 }

	 @FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody//tr[@class='roleListRow odd' or @class='roleListRow even']//td/a[@class='rolePopup']")
	 protected WebElement rolesTableEditLink;

	public void clickRolesTableItemEditLink(Integer index) {
		List<WebElement> rows = this.getRolesTableRows();
		WebElement row = rows.get(index);
		WebElement editLink = row.findElement(By.xpath(".//td/a[@class='rolePopup']"));
		editLink.click();
	}

	@FindBy(xpath = "//div[starts-with(text(),'Showing 1 to 1 of 1 entries') and @id='DataTables_Table_0_info']")
    protected WebElement rolesDataTableInfoLable;

    public void waitForRolesDataTableInfoLableToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.rolesDataTableInfoLable));
    }
    
	// new user button

	@FindBy(xpath = "//a[@id='newUser']")
	protected WebElement newUserButton;

	public void clickNewUserButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.newUserButton));
		this.newUserButton.click();
	}

	public void waitForNewUserButtonToBeVisible() {
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.newUserButton));
	}

	// users search input

	@FindBy(xpath = "//div[@class='widget-body min-h-150 users-list']//div//input[@class='form-control input-sm']")
	protected WebElement usersSearchInput;

	public void enterUsersTableSearchInput(String userName) {
		new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.usersSearchInput));
		this.usersSearchInput.sendKeys(userName);
	}

	// users table

	@FindBy(xpath = "//table[@id='DataTables_Table_1']/tbody")
	protected WebElement usersTable;

	public List<WebElement> getUsersTableRows() {
		return this.usersTable.findElements(By.xpath(".//tr[@class='roleListRow odd' or @class='roleListRow even']"));
	}

	public Integer getUsersTableRowsCount() {
		List<WebElement> rows = this.getUsersTableRows();
		return rows.size();
	}

	public String getUsersTableItemName(Integer index) {
		List<WebElement> rows = this.getUsersTableRows();
		WebElement row = rows.get(index);
		WebElement usernameElement = row.findElement(By.xpath(".//td[@class='sorting_1']"));
		String username = usernameElement.getText();
		return username;
	}
	
	@FindBy(xpath = "//table[@id='DataTables_Table_1']/tbody//tr[@class='roleListRow odd' or @class='roleListRow even']//td/a[@class='userPopup']")
    protected WebElement usersTableEditLink;

	public void clickUsersTableItemEditLink(Integer index) {
		List<WebElement> rows = this.getUsersTableRows();
		WebElement row = rows.get(index);
		WebElement editLink = row.findElement(By.xpath(".//td/a[@class='userPopup']"));
		editLink.click();
	}

	@FindBy(xpath = "//table[@id='DataTables_Table_12']/tbody/tr/td[@class='dataTables_empty']")
	protected WebElement usersTableNoRecordsItem;

	public boolean usersTableNoRecordsItemIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.usersTableNoRecordsItem));
		return this.usersTableNoRecordsItem.isDisplayed();
	}

	@FindBy(xpath = "//div[starts-with(text(),'Showing 1 to 1 of 1 entries') and @id='DataTables_Table_1_info']")
    protected WebElement usersDataTableInfoLable;

    public void waitForUsersDataTableInfoLableToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.usersDataTableInfoLable));
    }
	
	// toast

	public void waitForToastToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.toastContainer));
		this.wait.until(ExpectedConditions.visibilityOf(this.toast));
		this.wait.until(ExpectedConditions.visibilityOf(this.toastMessage));
		this.wait.until(ExpectedConditions.visibilityOf(this.toastMessageCloseButton));
	}

	public void waitForToastToBeInvisible() {
		// NEEDS FIX:
		// forced to use implicit wait as toast wait for invisibility will not be
		// recognized
		// currently we just reload the manageUsers page after asserting the toast
		// message
		// instead of messing with this toast
		// needs to be replaced with better solution
		this.implicitlyWait(10);
	}

	@FindBy(xpath = "//div[@id='toast-container']")
	protected WebElement toastContainer;

	@FindBy(xpath = "//div[@id='toast-container']/div")
	protected WebElement toast;

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@class='toast-message']")
	protected WebElement toastMessage;

	public String getToastMessageText() {
		this.wait.until(ExpectedConditions.visibilityOf(this.toastMessage));
		return this.toastMessage.getText();
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/button[@class='toast-close-button']")
	protected WebElement toastMessageCloseButton;

	public void clickToastCloseButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.toastMessageCloseButton));
		this.toastMessageCloseButton.click();
	}
}
