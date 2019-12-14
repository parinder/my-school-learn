package com.gms.pages.addressbook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ViewContactsPage extends BasePage {

    public ViewContactsPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl")
                   + "addressBook/profiles/o//gms/manager/datamanager?submit=viewdata_adv";
    }

    public void waitForPageLoad() {
		this.driver.switchTo().frame("canvas"); // switch to canvas frame
        this.wait.until(ExpectedConditions.visibilityOf(this.viewContactsLabel));
        this.wait.until(ExpectedConditions.visibilityOf(this.viewContactsButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.searchCriteriaSelectLabel));
		this.driver.switchTo().defaultContent(); // leave canvas iFrame
    }

    @FindBy(xpath = "//strong[(text()='View Contacts')]")
    protected WebElement viewContactsLabel;

    public boolean viewContactsLabelIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.viewContactsLabel));
        return this.viewContactsLabel.isDisplayed();
    }

    @FindBy(xpath = "//select[@name='filterid']")
    protected WebElement searchByDropdown;

    public void selectSearchBy(String searchByCriteria) {
        Select select = new Select(searchByDropdown);
        select.selectByVisibleText(searchByCriteria);
    }

    @FindBy(xpath = "//select[@name='detail']")
    protected WebElement levelOfDetailDropdown;

    public void selectLevelOfDetail(String levelOfDetailCriteria) {
        Select select = new Select(levelOfDetailDropdown);
        select.selectByVisibleText(levelOfDetailCriteria);
    }

    @FindBy(xpath = "//select[@name='min_month']")
    protected WebElement startDateMonthDropdown;

    public void selectStartDateMonth(String startDateMonth) {
        Select select = new Select(startDateMonthDropdown);
        select.selectByVisibleText(startDateMonth);
    }

    @FindBy(xpath = "//select[@name='min_day']")
    protected WebElement startDateDayDropdown;

    public void selectStartDateDay(String startDateDay) {
        Select select = new Select(startDateDayDropdown);
        select.selectByVisibleText(startDateDay);
    }

    @FindBy(xpath = "//select[@name='min_year']")
    protected WebElement startDateYearDropdown;

    public void selectStartDateYear(String startDateYear) {
        Select select = new Select(startDateYearDropdown);
        select.selectByVisibleText(startDateYear);
    }

    @FindBy(xpath = "//select[@name='max_month']")
    protected WebElement endDateMonthDropdown;

    public void selectEndDateMonth(String endDateMonth) {
        Select select = new Select(endDateMonthDropdown);
        select.selectByVisibleText(endDateMonth);
    }

    @FindBy(xpath = "//select[@name='max_day']")
    protected WebElement endDateDayDropdown;

    public void selectEndDateDay(String endDateDay) {
        Select select = new Select(endDateDayDropdown);
        select.selectByVisibleText(endDateDay);
    }

    @FindBy(xpath = "//select[@name='max_year']")
    protected WebElement endDateYearDropdown;

    public void selectEndDateYear(String endDateYear) {
        Select select = new Select(endDateYearDropdown);
        select.selectByVisibleText(endDateYear);
    }

    @FindBy(xpath = "//input[@name='view_contacts']")
    protected WebElement viewContactsButton;

    public boolean viewContactsButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.viewContactsButton));
        return this.viewContactsButton.isDisplayed();
    }

    public void clickViewContactsButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.viewContactsButton));
        this.viewContactsButton.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.contactListTableCaption));
    }
    
    @FindBy(xpath = "//strong[(text()='Select Search Criteria ')]")
	protected WebElement searchCriteriaSelectLabel;
    
    public boolean searchCriteriaSelectLabelIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchCriteriaSelectLabel));
        return this.searchCriteriaSelectLabel.isDisplayed();
    }

    @FindBy(xpath = "//select[@name='available_report_fields']")
	protected WebElement searchCriteriaSelect;

	public String getSearchCriteriaSelectOption(Integer index) {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchCriteriaSelect));
		Select select = new Select(searchCriteriaSelect);
        return select.getOptions().get(index.intValue()).getText();
    }

	public void selectSearchCriteriaSelectOption(String searchCriteriaSelectOption) {
		Select select = new Select(searchCriteriaSelect);
		select.selectByVisibleText(searchCriteriaSelectOption);
    }

	public boolean searchCriteriaSelectIsEnabled() {
		String outerHTML = searchCriteriaSelect.getAttribute("outerHTML");
        return !outerHTML.contains("disabled");
    }

    @FindBy(xpath = "//select[@name='sort']")
    protected WebElement sortByDropdown;

    public String getSortByDropdownOptions(Integer index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.sortByDropdown));
        Select select = new Select(sortByDropdown);
        return select.getOptions().get(index.intValue()).getText();
    }

    public boolean sortByDropdownIsEnabled() {
        String outerHTML = sortByDropdown.getAttribute("outerHTML");
        return !outerHTML.contains("disabled");
    }
    
    public void selectSortBy(String sortByOption) {
		Select select = new Select(sortByDropdown);
		select.selectByVisibleText(sortByOption);
    }

    // GMS report viewer

    // contact list table
    @FindBy(xpath = "//div[text()='Contacts List']")
    protected WebElement contactListTableCaption;

    @FindBy(xpath = "//table[@id='__bookmark_1']//tbody")
    protected WebElement contactListTable;

    public List<WebElement> getContactListTableHeaderRows() {
        this.wait.until(ExpectedConditions
            .visibilityOf(this.contactListTable.findElement(By.tagName("th"))));
        return contactListTable.findElements(By.tagName("th"));
    }

    public String getContactListTableHeaderRowContents(Integer index) {
        List<WebElement> rows = this.getContactListTableHeaderRows();
        WebElement rowHeader = rows.get(index);
        return rowHeader.getText();
    }

    public List<WebElement> getContactListTableRows() {
        this.wait.until(ExpectedConditions
            .visibilityOf(this.contactListTable.findElement(By.tagName("tr"))));
        return contactListTable.findElements(By.tagName("tr"));
    }
    
    public List<WebElement> getContactListTableColumns() {
        this.wait.until(ExpectedConditions
            .visibilityOf(this.contactListTable.findElement(By.tagName("td"))));
        return contactListTable.findElements(By.tagName("td"));
    }

    public Integer getContactListTableRowsCount() {
        List<WebElement> rows = this.getContactListTableRows();
        return rows.size();
    }

    public String getContactListTableRowFirstColumnContents(Integer index) {
        List<WebElement> rows = this.getContactListTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td/div"));
        return columns.getText();
    }

    public String getContactListTableRowSecondColumnContents(Integer index) {
        List<WebElement> rows = this.getContactListTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[2]/div"));
        return columns.getText();
    }

    public String getContactListTableRowThirdColumnContents(Integer index) {
        List<WebElement> rows = this.getContactListTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[3]/div"));
        return columns.getText();
    }

    public String getContactListTableRowForthColumnContents(Integer index) {
        List<WebElement> rows = this.getContactListTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[4]/div"));
        return columns.getText();
    }
    
    
    public boolean nonHouseProgramMemberIdIsNotPresentInContactListTable(String expectedNonHouseProgramMemberId) {
        boolean nonHouseProgramMemberIdIsNotPresent = true;
        for (WebElement cell : getContactListTableColumns()) {
            String houseProgramMemberId = cell.getText();
            if (houseProgramMemberId.equalsIgnoreCase(expectedNonHouseProgramMemberId)) {
            	nonHouseProgramMemberIdIsNotPresent = false;
            }
        }
        return nonHouseProgramMemberIdIsNotPresent;
    } 

}