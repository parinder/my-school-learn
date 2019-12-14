package com.gms.pages.addressbook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class FiltersListPage extends BasePage {

    public FiltersListPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.listOfFiltersTable));
    }

    @FindBy(xpath = "//div[@class='dataTables_filter']/label/input[@aria-controls='listOfFilters']")
    protected WebElement filtersSearchInput;

    public void enterFiltersSearchInput(String searchString) {
        this.wait.until(ExpectedConditions.visibilityOf(this.filtersSearchInput));
        this.filtersSearchInput.clear();
        this.filtersSearchInput.sendKeys(searchString);
    }
    
    public boolean filtersSearchInputIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filtersSearchInput));
        return this.filtersSearchInput.isDisplayed();
    }

    @FindBy(xpath = "//table[@id='listOfFilters']/tbody")
    protected WebElement listOfFiltersTable;

    public List<WebElement> getListOfFiltersTableRows() {
        this.wait.until(ExpectedConditions.visibilityOf(this.listOfFiltersTable.findElement(By.tagName("tr"))));
        return listOfFiltersTable.findElements(By.tagName("tr"));
    }

    public Integer getListOfFiltersTableRowCount() {
        List<WebElement> rows = this.getListOfFiltersTableRows();
        return rows.size();
    }

    public String getListOfFiltersTableRowContents(Integer index) {
        List<WebElement> rows = this.getListOfFiltersTableRows();
        WebElement row = rows.get(index);
        return row.getText();
    }

    public void clickListOfFiltersTableRow(Integer index) {
        List<WebElement> rows = this.getListOfFiltersTableRows();
        WebElement row = rows.get(index);
        row.click();
    }

    public void clickFiltersTableRowIconRefresh(Integer index) {
        List<WebElement> rows = this.getListOfFiltersTableRows();
        WebElement row = rows.get(index);
        row.click();
        WebElement columns = row.findElement(By.xpath(".//td"));
        WebElement doCountFilter = columns.findElement(By.xpath("//a[@class='doCountFilter']"));
        WebElement iconRefresh = doCountFilter.findElement(By.xpath("//i[@class='icon-refresh']"));
        iconRefresh.click();
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
                "//table[@id='listOfFilters']/tbody//td//a[@class='doCountFilter']//i[@class='icon-refresh icon-spin']")));
    }

    public String getListOfFiltersTableRowFilterCount(Integer index) {
        List<WebElement> rows = this.getListOfFiltersTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[@class='count ']")); // this space is on HTML page
        WebElement filterCount = columns.findElement(By.xpath(".//span"));
        return filterCount.getText();
    }

    @FindBy(xpath = "//td[@class='dataTables_empty']")
    protected WebElement noRecordsTableItem;

    public boolean noRecordsTableItemIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.noRecordsTableItem));
        return this.noRecordsTableItem.isDisplayed();
    }
}