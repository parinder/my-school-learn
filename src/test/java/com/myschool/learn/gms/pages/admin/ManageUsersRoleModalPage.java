package com.myschool.learn.gms.pages.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class ManageUsersRoleModalPage extends BasePage {

    public ManageUsersRoleModalPage(WebDriver driver, Config config) {
        super(driver, config);
        this.url = this.config.getProperty("app.gms.baseurl") + "manageUsers";
    }

    public void waitToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.detailsTab));
    }

    public void waitToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.headerTitle));
        this.wait.until(ExpectedConditions.invisibilityOf(this.detailsTab));
    }

    // title

    @FindBy(xpath = "//div[@class='modal-header']/h4[@class='modal-title']")
    protected WebElement headerTitle;

    public String getheaderTitleText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.headerTitle));
        return this.headerTitle.getText();
    }

    // close button

    @FindBy(xpath = "//button[@class='bootbox-close-button close']")
    protected WebElement headerCloseButton;

    public void clickHeaderCloseButton() {
        new WebDriverWait(this.driver, 100).until(ExpectedConditions.visibilityOf(this.headerCloseButton));
        this.headerCloseButton.click();
    }

    // details tab

    @FindBy(xpath = "//a[@id='viewRoleTabButton-details']")
    protected WebElement detailsTab;

    // Module Access tab

    @FindBy(xpath = "//a[@id='viewRoleTabButton-module']")
    protected WebElement moduleAccessTab;

    public void clickModuleAccessTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTab));
        this.moduleAccessTab.click();
    }

    // Address Book Check box

    @FindBy(xpath = "//div[@id='module-accordion']//div[@data-name='Address Book']")
    protected WebElement moduleAccessTabAddressBookCheckbox;

    public void clickModuleAccessTabAddressBookCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabAddressBookCheckbox));
        this.moduleAccessTabAddressBookCheckbox.click();
    }

    public boolean moduleAccessTabAddressBookCheckboxIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabAddressBookCheckbox));
        return moduleAccessTabAddressBookCheckbox.getAttribute("class").contains("bg-success");
    }

    // Email Center check box

    @FindBy(xpath = "//div[@id='module-accordion']//div[@data-name='Email Center']")
    protected WebElement moduleAccessTabEmailCenterCheckbox;

    public void clickModuleAccessTabEmailCenterCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabEmailCenterCheckbox));
        this.moduleAccessTabEmailCenterCheckbox.click();
    }

    public boolean moduleAccessTabEmailCenterCheckboxIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabEmailCenterCheckbox));
        return moduleAccessTabEmailCenterCheckbox.getAttribute("class").contains("bg-success");
    }

    // Form Center check box

    @FindBy(xpath = "//div[@id='module-accordion']//div[@data-name='Form Center']")
    protected WebElement moduleAccessTabFormCenterCheckbox;

    public void clickModuleAccessTabFormCenterCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabFormCenterCheckbox));
        this.moduleAccessTabFormCenterCheckbox.click();
    }

    public boolean moduleAccessTabFormCenterCheckboxIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabFormCenterCheckbox));
        return moduleAccessTabFormCenterCheckbox.getAttribute("class").contains("bg-success");
    }

    // Reports check box

    @FindBy(xpath = "//div[@id='module-accordion']//div[@data-name='Reports']")
    protected WebElement moduleAccessTabReportsCheckbox;

    public void clickModuleAccessTabReportsCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabReportsCheckbox));
        this.moduleAccessTabReportsCheckbox.click();
    }

    public boolean moduleAccessTabReportsCheckboxIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabReportsCheckbox));
        return moduleAccessTabReportsCheckbox.getAttribute("class").contains("bg-success");
    }

    // PMS check box

    @FindBy(xpath = "//div[@id='module-accordion']//div[@data-name='PMS']")
    protected WebElement moduleAccessTabPmsCheckbox;

    public void clickModuleAccessTabPmsCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabPmsCheckbox));
        this.moduleAccessTabPmsCheckbox.click();
    }

    public boolean moduleAccessTabPmsCheckboxIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabPmsCheckbox));
        return moduleAccessTabPmsCheckbox.getAttribute("class").contains("bg-success");
    }

    // Workflow check box

    @FindBy(xpath = "//div[@id='module-accordion']//div[@data-name='Workflow']")
    protected WebElement moduleAccessTabWorkflowCheckbox;

    public void clickModuleAccessTabWorkflowCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabWorkflowCheckbox));
        this.moduleAccessTabWorkflowCheckbox.click();
    }

    public boolean moduleAccessTabWorkflowCheckboxIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabWorkflowCheckbox));
        return moduleAccessTabWorkflowCheckbox.getAttribute("class").contains("bg-success");
    }

    // Rezqueue check box

    @FindBy(xpath = "//div[@id='module-accordion']//div[@data-name='Rezqueue']")
    protected WebElement moduleAccessTabRezqueueCheckbox;

    public void clickModuleAccessTabRezqueueCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabRezqueueCheckbox));
        this.moduleAccessTabRezqueueCheckbox.click();
    }

    public boolean moduleAccessTabRezqueueCheckboxIsSelected() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabRezqueueCheckbox));
        return moduleAccessTabRezqueueCheckbox.getAttribute("class").contains("bg-success");
    }

    @FindBy(xpath = "//a[@id='saveModules']")
    protected WebElement moduleAccessTabSaveModulesButton;

    public void clickModuleAccessTabSaveModulesButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.moduleAccessTabSaveModulesButton));
        this.moduleAccessTabSaveModulesButton.click();
    }

    // delete button

    @FindBy(xpath = "//div[@class='modal-footer']/button[@data-bb-handler='Delete']")
    protected WebElement deleteButton;

    public void clickDeleteButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.deleteButton));
        this.deleteButton.click();
    }

    // role modal list access tab

    @FindBy(xpath = "//a[@id='viewRoleTabButton-listAccess']")
    protected WebElement listAccessTab;

    public void clickListAccessTab() {
        this.wait.until(ExpectedConditions.visibilityOf(this.listAccessTab));
        this.listAccessTab.click();
    }

    @FindBy(xpath = "//a[normalize-space(text()) ='QA Team - AUTOMATED Tests (DO NOT TOUCH)']")
    protected WebElement qaAutomatedListPanel;

    public void clickQaAutomatedListPanel() {
        this.wait.until(ExpectedConditions.visibilityOf(this.qaAutomatedListPanel));
        this.qaAutomatedListPanel.click();
    }

    // campaign accordion

    @FindBy(xpath = "//div[@class='panel-heading ']//a[normalize-space(text()) ='QA Team - AUTOMATED Tests (DO NOT TOUCH)']/../../following-sibling::div//div[@class='accordion']//a[normalize-space(text()) ='campaign']")
    protected WebElement campaignAccrodion;

    public void clickCampaignAccrodion() {
        this.wait.until(ExpectedConditions.visibilityOf(this.campaignAccrodion));
        this.campaignAccrodion.click();
    }

    @FindBy(xpath = "//div[@class='panel-heading ']//a[normalize-space(text()) ='QA Team - AUTOMATED Tests (DO NOT TOUCH)']/../../following-sibling::div//div[@class='accordion']/div//a[normalize-space(text()) ='campaign']/../../following-sibling::div//input[@class='form-control input-sm']")
    protected WebElement campaignAccrodionSearchInput;

    public void enterFolderName(String folderName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.campaignAccrodionSearchInput));
        this.campaignAccrodionSearchInput.sendKeys(folderName);
    }

    @FindBy(xpath = "//div[@class='panel-heading ']//a[normalize-space(text()) ='QA Team - AUTOMATED Tests (DO NOT TOUCH)']/../../following-sibling::div//div[@class='accordion']/div//a[normalize-space(text()) ='campaign']/../../following-sibling::div//tbody")
    protected WebElement campaignTable;

    public void waitForCampaignTableToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.campaignTable));
    }

    @FindBy(xpath = "//div[@class='panel-collapse collapse in' and @aria-expanded='true']")
    protected WebElement collapsedPanel;

    public void waitForCollapsedPanelToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.collapsedPanel));
    }

    public List<WebElement> getCampaignTableRows() {
        return campaignTable.findElements(By.xpath(".//tr[@class='odd' or @class='even']"));
    }

    public void clickCampaignTableItemCheckBox(Integer index) {
        List<WebElement> rows = this.getCampaignTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[@class='sorting_1']"));
        WebElement checkBox = columns.findElement(By.xpath(".//label"));
        checkBox.click();
    }

    public boolean campaignTableItemCheckBoxIsSelected(Integer index) {
        List<WebElement> rows = this.getCampaignTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[@class='sorting_1']"));
        WebElement selectedCampaignTableItemCheckBox = columns.findElement(By.xpath(".//label//input"));
        String outerHTML = selectedCampaignTableItemCheckBox.getAttribute("outerHTML");
        return outerHTML.contains("checked");
    }

    @FindBy(xpath = "//a[@class='btn btn-blue saveItems' and text()='Save campaign']")
    protected WebElement saveCampaignButton;

    public void clickSaveCampaignButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveCampaignButton));
        this.saveCampaignButton.click();
    }

    // filter accordion

    @FindBy(xpath = "//div[@class='panel-heading ']//a[normalize-space(text()) ='QA Team - AUTOMATED Tests (DO NOT TOUCH)']/../../following-sibling::div//div[@class='accordion']//a[normalize-space(text()) ='filter']")
    protected WebElement filterAccrodion;

    public void clickFilterAccrodion() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filterAccrodion));
        this.filterAccrodion.click();
    }

    @FindBy(xpath = "//div[@class='panel-heading ']//a[normalize-space(text()) ='QA Team - AUTOMATED Tests (DO NOT TOUCH)']/../../following-sibling::div//div[@class='accordion']/div//a[normalize-space(text()) ='filter']/../../following-sibling::div//input[@class='form-control input-sm']")
    protected WebElement filterAccrodionSearchInput;

    public void enterFilterName(String filterName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.filterAccrodionSearchInput));
        this.filterAccrodionSearchInput.sendKeys(filterName);
    }

    @FindBy(xpath = "//div[@class='panel-heading ']//a[normalize-space(text()) ='QA Team - AUTOMATED Tests (DO NOT TOUCH)']/../../following-sibling::div//div[@class='accordion']/div//a[normalize-space(text()) ='filter']/../../following-sibling::div//tbody")
    protected WebElement filterTable;

    public void waitForFilterTableToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.filterTable));
    }

    public List<WebElement> getFilterTableRows() {
        return filterTable.findElements(By.xpath(".//tr[@class='odd' or @class='even']"));
    }

    public void clickFilterTableItemCheckBox(Integer index) {
        List<WebElement> rows = this.getFilterTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[@class='sorting_1']"));
        WebElement checkBox = columns.findElement(By.xpath(".//label"));
        checkBox.click();
    }

    public boolean filterTableItemCheckBoxIsSelected(Integer index) {
        List<WebElement> rows = this.getFilterTableRows();
        WebElement row = rows.get(index);
        WebElement columns = row.findElement(By.xpath(".//td[@class='sorting_1']"));
        WebElement selectedFilterTableItemCheckBox = columns.findElement(By.xpath(".//label//input"));
        String outerHTML = selectedFilterTableItemCheckBox.getAttribute("outerHTML");
        return outerHTML.contains("checked");
    }

    @FindBy(xpath = "//a[@class='btn btn-blue saveItems' and text()='Save filter']")
    protected WebElement saveFilterButton;

    public void clickSaveFilterButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveFilterButton));
        this.saveFilterButton.click();
    }
}
