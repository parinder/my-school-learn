package com.myschool.learn.gms.pages.profiles.profile;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class LoyaltyTabPage extends BasePage {

    public LoyaltyTabPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        // NEEDS FIX:
        // - change timeout back to 25 once the slow loyalty profile load is fixed
        new WebDriverWait(this.driver, 50).until(ExpectedConditions.visibilityOf(this.loyaltyTabContainer));
    }

    @FindBy(xpath = "//div[@id='loyaltyTab' and contains(@class, 'active')]")
    protected WebElement loyaltyTabContainer;

    // enroll new program button

    @FindBy(xpath = "//div[@id='loyaltyTab']//div[1]/div[2]//button[@class='btn btn-blue btn-orange enroll-new-program']")
    protected WebElement enrollNewProgramButton;

    public void clickEnrollNewProgramButton() {
        this.enrollNewProgramButton.click();
    }

    // enroll new program modal

    public void waitForEnrollNewProgramModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalMemberNumberInput));
    }

    // enroll new program modal title

    @FindBy(xpath = "//div[@id='enrollNewProgram']/div/div/div[1]//h4[@class='modal-title']")
    protected WebElement enrollNewProgramModalTitle;

    // enroll new program modalmember number input

    @FindBy(xpath = "//input[@id='member-number']")
    protected WebElement enrollNewProgramModalMemberNumberInput;

    public String getEnrollNewProgramModalMemberNumber() {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalMemberNumberInput));
        return this.enrollNewProgramModalMemberNumberInput.getAttribute("value");
    }

    // enroll new program modal program to enroll dropdown

    @FindBy(xpath = "//div[@id='enrollNewProgram']//div[@class='modal-body']/form[1]/div[2]/div[2]/div[1]/span[1]/span[1]/span[1]/span[1]/span[1]")
    protected WebElement enrollNewProgramModalProgramToEnrollDropdown;

    public void clickEnrollNewProgramModalProgramToEnrollDropdown() {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalProgramToEnrollDropdown));
        this.enrollNewProgramModalProgramToEnrollDropdown.click();
    }

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
    protected WebElement enrollNewProgramModalProgramToEnrollSearchInput;

    public void enterEnrollNewProgramModalProgramToEnrollSearch(String guestProgramName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalProgramToEnrollSearchInput));
        this.enrollNewProgramModalProgramToEnrollSearchInput.sendKeys(guestProgramName);
        this.enrollNewProgramModalProgramToEnrollSearchInput.sendKeys(Keys.ARROW_DOWN);
        this.enrollNewProgramModalProgramToEnrollSearchInput.sendKeys(Keys.ENTER);
    }

    // enroll new program modal guest portal to enroll in dropdown

    @FindBy(xpath = "//div[@id='enrollNewProgram']//div[@class='modal-body']/form[1]/div[3]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]/span[1]")
    protected WebElement enrollNewProgramModalGuestPortalToEnrollInDropdown;

    public void clickEnrollNewProgramModalGuestPortalToEnrollInDropdown() {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalGuestPortalToEnrollInDropdown));
        this.enrollNewProgramModalGuestPortalToEnrollInDropdown.click();
    }

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
    protected WebElement enrollNewProgramModalGuestPortalToEnrollInSearchInput;

    public void enterEnrollNewProgramModalGuestPortalToEnrollInSearch(String guestProgramName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalGuestPortalToEnrollInSearchInput));
        this.enrollNewProgramModalGuestPortalToEnrollInSearchInput.sendKeys(guestProgramName);
        this.enrollNewProgramModalGuestPortalToEnrollInSearchInput.sendKeys(Keys.ARROW_DOWN);
        this.enrollNewProgramModalGuestPortalToEnrollInSearchInput.sendKeys(Keys.ENTER);
    }

    // enroll new program modal close button

    @FindBy(xpath = "//div[@id='enrollNewProgram']//div[@class='modal-dialog']//button[@class='btn btn-default btn-close']")
    protected WebElement enrollNewProgramModalCloseButton;

    public void clickEnrollNewProgramModalCloseButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalCloseButton));
        this.enrollNewProgramModalCloseButton.click();
    }

    // enroll new program modal save button

    @FindBy(xpath = "//div[@id='enrollNewProgram']//div[@class='modal-dialog']//button[@class='btn btn-default btn-save btn-success']")
    protected WebElement enrollNewProgramModalSaveButton;

    public void clickEnrollNewProgramModalSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollNewProgramModalSaveButton));
        this.enrollNewProgramModalSaveButton.click();
    }

    // enroll new program modal save button

    @FindBy(xpath = "//button[@class='btn btn-warning close-error-modal']")
    protected WebElement membershipActivationEmailSentSaveButton;

    public void clickMembershipActivationEmailSentSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.membershipActivationEmailSentSaveButton));
        this.membershipActivationEmailSentSaveButton.click();
    }

    // loyalty programs dropdown / label

    @FindBy(xpath = "//div[@id='loyaltyTab']/div[1]/div[1]//select[@class='form-control changeLoyaltyProgram']")
    protected WebElement enrolledProgramsNameDropDown;

    public void selectEnrolledProgramName(String enrolledProgramName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrolledProgramsNameDropDown));
        this.enrolledProgramsNameDropDown.click();
        Select selectEnrolledProgramType = new Select(this.enrolledProgramsNameDropDown);
        selectEnrolledProgramType.selectByVisibleText(enrolledProgramName);
    }

    // member card

    @FindBy(xpath = "//div[contains(@class, 'membershipAdmin')]/span[@class='databox-header carbon no-margin']")
    protected WebElement loyaltyMemberNumber;

    public String getLoyaltyMemberNumber() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyMemberNumber));
        return this.loyaltyMemberNumber.getText();
    }

    public void waitForLoyaltyMemberNumberToBeInvisible(){
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'membershipAdmin')]/span[@class='databox-header carbon no-margin']")));
    }

    // loyalty member tier level

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//a[@class='btn btn-orange btn-sm']")
    protected WebElement loyaltyMemberTierLevel;

    public String getLoyaltyMemberProfileTierLevel() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyMemberTierLevel));
        return this.loyaltyMemberTierLevel.getText();
    }

    // permanent lock icon

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//a[@class='btn btn-orange btn-sm']//i[@class='fa fa-lock permanentLock']")
    protected WebElement loyaltyMemberTierLevelPermanentLock;

    public boolean loyaltyMemberTierLevelPermanentLockIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyMemberTierLevelPermanentLock));
        return this.loyaltyMemberTierLevelPermanentLock.isDisplayed();
    }

    // change username

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//a[@class='btn btn-blue btn-sm changeUsername']")
    protected WebElement changeLoyaltyMemberUserNameButton;

    public void clickChangeLoyaltyMemberUserNameButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeLoyaltyMemberUserNameButton));
        this.changeLoyaltyMemberUserNameButton.click();
    }

    @FindBy(xpath = "//div[@id='changeUsernameDialog']//div[@class='modal-dialog']")
    protected WebElement changeUsernameModalDialog;

    public void waitForChangeUsernameModalDialogToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeUsernameModalDialog));
    }

    @FindBy(xpath = "//div[@id='changeUsernameDialog']//input[@id='newUsername']")
    protected WebElement changeUsernameModalDialogInput;

    public void enterNewUsernameInChangeUsernameDialog(String newUsername) {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeUsernameModalDialogInput));
        this.changeUsernameModalDialogInput.sendKeys(newUsername);

    }

    @FindBy(xpath = "//div[@id='changeUsernameDialog']//div[@class='modal-footer']//button[@class='btn btn-default btn-save btn-success']")
    protected WebElement changeUsernameModalDialogSaveButton;

    public void clickToSaveNewUsername() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeUsernameModalDialogSaveButton));
        this.changeUsernameModalDialogSaveButton.click();

    }

    @FindBy(xpath = "//div[@id='error-dialog']//div[@class='modal-dialog']")
    protected WebElement changeUsernameConfirmationModal;

    public void waitForChangeUsernameConfirmationModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeUsernameConfirmationModal));
    }

    @FindBy(xpath = "//div[@id='error-dialog']//div[@class='modal-dialog']")
    protected WebElement changeUsernameConfirmationModalTitle;

    public String getChangeUsernameConfirmationModalTitle() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeUsernameConfirmationModalTitle));
        return this.changeUsernameConfirmationModalTitle.getText();
    }

    @FindBy(xpath = "//div[@id='error-dialog']//div[@class='modal-footer']//button[@class='btn btn-warning close-error-modal']")
    protected WebElement changeUsernameConfirmationModalCloseButton;

    public void clickChangeUsernameConfirmationModalCloseButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changeUsernameConfirmationModalCloseButton));
        this.changeUsernameConfirmationModalCloseButton.click();

    }

    // change password button

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//a[@class='btn btn-blue btn-sm changePassword']")
    protected WebElement changePasswordButton;

    public void clickChangeLoyaltyMemberPasswordButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordButton));
        this.changePasswordButton.click();
    }

    // change password dialog

    @FindBy(xpath = "//div[@id='changePasswordDialog']//div[@class='modal-dialog']")
    protected WebElement changePasswordModal;

    public void waitForChangePasswordModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalXButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalNewPasswordInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalNewPasswordAgainInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalCloseButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalSaveButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModal));
    }

    public void waitForChangePasswordModalToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.changePasswordModalTitle));
        this.wait.until(ExpectedConditions.invisibilityOf(this.changePasswordModalXButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.changePasswordModalNewPasswordInput));
        this.wait.until(ExpectedConditions.invisibilityOf(this.changePasswordModalNewPasswordAgainInput));
        this.wait.until(ExpectedConditions.invisibilityOf(this.changePasswordModalCloseButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.changePasswordModalSaveButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.changePasswordModal));

    }

    // change password modal title

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/h4")
    protected WebElement changePasswordModalTitle;

    // change password modal x button

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button")
    protected WebElement changePasswordModalXButton;

    public void clickChangePasswordModalXButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalXButton));
        this.changePasswordModalXButton.click();
    }

    // change password modal new password

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div[@class='form-group']/input[@id='newUsernamePassword']")
    protected WebElement changePasswordModalNewPasswordInput;

    public void enterChangePasswordModalNewPassword(String password) {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalNewPasswordInput));
        this.changePasswordModalNewPasswordInput.clear();
        this.changePasswordModalNewPasswordInput.sendKeys(password);
    }

    // change password modal new password again

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div[@class='form-group']/input[@id='newUsernamePassword2']")
    protected WebElement changePasswordModalNewPasswordAgainInput;

    public void enterChangePasswordModalNewPasswordAgain(String password) {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalNewPasswordAgainInput));
        this.changePasswordModalNewPasswordAgainInput.clear();
        this.changePasswordModalNewPasswordAgainInput.sendKeys(password);
    }

    // change password modal passwords do not match error message

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div[@class='alert passwordDontMatch alert-danger fade in']")
    protected WebElement changePasswordModalPasswordsDoNotMatchMessage;

    public boolean changePasswordModalPasswordsDoNOtMatchMessageTextContains(String expectedText) {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalPasswordsDoNotMatchMessage));
        return this.changePasswordModalPasswordsDoNotMatchMessage.getText().contains(expectedText);
    }

    // change password modal general error message

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div[@class='alert generalError alert-danger fade in']")
    protected WebElement changePasswordModalGeneralErrorMessage;

    public boolean changePasswordModalGeneralErrorMessageTextContains(String expectedText) {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalGeneralErrorMessage));
        return this.changePasswordModalGeneralErrorMessage.getText().contains(expectedText);
    }

    // change password modal close button

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/button[contains(text(),'Close')]")
    protected WebElement changePasswordModalCloseButton;

    public void clickChangePasswordModalCloseButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalCloseButton));
        this.changePasswordModalCloseButton.click();
    }

    // change password modal save button

    @FindBy(xpath = "//div[@id='changePasswordDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/button[contains(text(),'Save')]")
    protected WebElement changePasswordModalSaveButton;

    public void clickChangePasswordModalSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.changePasswordModalSaveButton));
        this.changePasswordModalSaveButton.click();
    }

    // merge membership button

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//a[@class='btn btn-blue btn-sm mergeMemberships']")
    protected WebElement mergeMembershipButton;

    public void clickMergeMembershipButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeMembershipButton));
        this.mergeMembershipButton.click();
    }

    // merge membership dialog

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']//div[@class='modal-dialog']")
    protected WebElement mergeMembershipModal;

    public void waitForMergeMembershipModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeMembershipModalTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeMembershipModalXButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeMembershipModalMemberNumberInput));
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeMembershipModalDeleteMemberAfterMergeCheckbox));
        this.wait.until(ExpectedConditions.visibilityOf(this.findMemberButton));
    }

    public void waitForMergeMembershipModalToBeInVisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.mergeMembershipModalTitle));
        this.wait.until(ExpectedConditions.invisibilityOf(this.mergeMembershipModalXButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.mergeMembershipModalMemberNumberInput));
        this.wait.until(ExpectedConditions.invisibilityOf(this.mergeMembershipModalDeleteMemberAfterMergeCheckbox));
        this.wait.until(ExpectedConditions.invisibilityOf(this.findMemberButton));
    }

    // merge membership modal title

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/h4")
    protected WebElement mergeMembershipModalTitle;

    // merge membership modal x button

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button")
    protected WebElement mergeMembershipModalXButton;

    // merge membership member number merging into Input

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']//div[@class='modal-dialog']//input[@id='memberNumberMergingInto']")
    protected WebElement mergeMembershipModalMemberNumberInput;

    public void enterMemberNumber(String firstProfile) {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeMembershipModalMemberNumberInput));
        this.mergeMembershipModalMemberNumberInput.sendKeys(firstProfile);
    }

    // merge membership delete member after merge check box

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']//div[@class='modal-dialog']//div[@class='checkbox']//label//input[@id='deleteMemberAfterMerge']/..")
    protected WebElement mergeMembershipModalDeleteMemberAfterMergeCheckbox;

    public void clickDeleteMemberAfterMergeCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeMembershipModalDeleteMemberAfterMergeCheckbox));
        this.mergeMembershipModalDeleteMemberAfterMergeCheckbox.click();
    }

    @FindBy(xpath = "//span[contains(text(),'No member was found with this member number')]")
    protected WebElement noMemberFoundWithMemberNumberErrorMessage;

    public boolean noMemberFoundWithMemberNumberErrorMessageIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.noMemberFoundWithMemberNumberErrorMessage));
        return this.noMemberFoundWithMemberNumberErrorMessage.isDisplayed();
    }

    // merge membership modal find member button

    @FindBy(xpath = "//button[@id='findMemberNumber']")
    protected WebElement findMemberButton;

    public void clickFindMemberButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.findMemberButton));
        this.findMemberButton.click();
    }

    // confirm merge dialog

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']//div[@class='modal-dialog']")
    protected WebElement confirmMergeModal;

    public void waitForConfirmMergeModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmMergeModalTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmMergeModalXButton));
    }

    // confirm merge modal title

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/h4")
    protected WebElement confirmMergeModalTitle;

    // confirm merge modal x button

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button")
    protected WebElement confirmMergeModalXButton;

    // confirm merge modal merging into message

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/b[1]")
    protected WebElement confirmMergeModalMergingMessage;

    public String getMergingIntoMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmMergeModalMergingMessage));
        return confirmMergeModalMergingMessage.getText();
    }

    // confirm merge modal merge summary table

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/table[@class='mergeSummary']/tbody/tr[1]/td[3]")
    protected WebElement mergeSummaryTableMergedIntoProfilePoints;

    public String getMergeSummaryTableMergedIntoProfilePoints() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergeSummaryTableMergedIntoProfilePoints));
        return mergeSummaryTableMergedIntoProfilePoints.getText();
    }

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/table[@class='mergeSummary']/tbody/tr[1]/td[2]")
    protected WebElement mergedProfilePoints;

    public String getMergeSummaryTableMergedProfilePoints() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergedProfilePoints));
        return mergedProfilePoints.getText();
    }

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/table[@class='mergeSummary']/tbody/tr[2]/td[2]")
    protected WebElement mergedProfileYtdPoints;

    public String getMergeSummaryTableMergedProfileYtdPoints() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergedProfileYtdPoints));
        return mergedProfileYtdPoints.getText();
    }

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/table[@class='mergeSummary']/tbody/tr[3]/td[2]")
    protected WebElement mergedProfileStaysCount;

    public String getMergeSummaryTableMergedProfileStaysCount() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergedProfileStaysCount));
        return mergedProfileStaysCount.getText();
    }

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/table[@class='mergeSummary']/tbody/tr[4]/td[2]")
    protected WebElement mergedProfileNightsCount;

    public String getMergeSummaryTableMergedProfileNightsCount() {
        this.wait.until(ExpectedConditions.visibilityOf(this.mergedProfileNightsCount));
        return mergedProfileNightsCount.getText();
    }

    // confirm merge modal points log message textarea

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/textarea[@class='pointsLogMessage']")
    protected WebElement confirmMergeModalPointsLogMessageTextarea;

    // confirm merge modal merge button

    @FindBy(xpath = "//div[@id='mergeMembershipsDialog']//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/button[@class='btn btn-default btn-save btn-success']")
    protected WebElement confirmMergeModalMergeButton;

    public void clickConfirmMergeModalMergeButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmMergeModalMergeButton));
        this.confirmMergeModalMergeButton.click();
    }

    // reassign tier button

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//a[@class='btn btn-blue btn-sm reassignTier']")
    protected WebElement reassignTierButton;

    public void clickReassignTierButtonButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierButton));
        this.reassignTierButton.click();
    }

    // reassign tier dialog

    @FindBy(xpath = "//div[@id='reassignTierDialog']//div[@class='modal-dialog']")
    protected WebElement reassignTierModal;

    public void waitForReassignTierModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalTitle));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalXButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalSelectTierDropdown));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalMakePermanentCheckbox));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalNotifyMemberOfLevelChangeCheckbox));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalCloseButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalSaveButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModal));
    }

    public void waitForReassignTierModalToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModalTitle));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModalXButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModalSelectTierDropdown));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModalMakePermanentCheckbox));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModalNotifyMemberOfLevelChangeCheckbox));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModalCloseButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModalSaveButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierModal));
    }

    // reassign tier modal title

    @FindBy(xpath = "//div[@id='reassignTierDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/h4")
    protected WebElement reassignTierModalTitle;

    // reassign tier modal x button

    @FindBy(xpath = "//div[@id='reassignTierDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button")
    protected WebElement reassignTierModalXButton;

    // select tier dropdown

    @FindBy(xpath = "//select[@id='newTier']/..")
    protected WebElement reassignTierModalSelectTierDropdown;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    protected WebElement reassignTierModalProgramTierInput;

    public void selectProfileTierViaSearch(String profileTier) {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalSelectTierDropdown));
        this.reassignTierModalSelectTierDropdown.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalProgramTierInput));
        reassignTierModalProgramTierInput.sendKeys(profileTier);
        reassignTierModalProgramTierInput.sendKeys(Keys.ARROW_DOWN);
        reassignTierModalProgramTierInput.sendKeys(Keys.ENTER);
    }

    // make permanent checkbox

    @FindBy(xpath = "//div[@id='permanent-Selection']//div[@class='form-group']//div[@class='checkbox']//label")
    protected WebElement reassignTierModalMakePermanentCheckbox;

    public void clickReassignTierModalMakePermanentCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalMakePermanentCheckbox));
        this.reassignTierModalMakePermanentCheckbox.click();
    }

    // notify member of level change checkbox

    @FindBy(xpath = "//div[@id='email-sending']//div[@class='form-group']//div[@class='checkbox']//label")
    protected WebElement reassignTierModalNotifyMemberOfLevelChangeCheckbox;

    public void clickReassignTierModalNotifyMemberOfLevelChangeCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalNotifyMemberOfLevelChangeCheckbox));
        this.reassignTierModalNotifyMemberOfLevelChangeCheckbox.click();
    }

    // notify member of level change checkbox lable

    @FindBy(xpath = "//input[@id='sendTierChange']")
    protected WebElement reassignTierModalNotifyMemberOfLevelChangeCheckboxLabel;

    public boolean reassignTierModalNotifyMemberOfLevelChangeCheckboxLabelIsDisabled() {
        String label = reassignTierModalNotifyMemberOfLevelChangeCheckboxLabel.getAttribute("outerHTML");
        return label.contains("disabled");
    }

    // reassign tier modal close button

    @FindBy(xpath = "//div[@id='reassignTierDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/button[contains(text(),'Close')]")
    protected WebElement reassignTierModalCloseButton;

    // reassign tier modal save button

    @FindBy(xpath = "//div[@id='reassignTierDialog']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/button[contains(text(),'Save')]")
    protected WebElement reassignTierModalSaveButton;

    public void clickReassignTierModalSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierModalSaveButton));
        this.reassignTierModalSaveButton.click();
    }

    // reassign tier confirmation dialog

    @FindBy(xpath = "//div[@id='confirm-dialog']//div[@class='modal-dialog']")
    protected WebElement reassignTierConfirmationModal;

    public void waitForReassignTierConfirmationModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierConfirmationModal));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierConfirmationModalYesButton));
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierConfirmationModalCancelButton));
    }

    public void waitForReassignTierConfirmationModalToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierConfirmationModalYesButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierConfirmationModalCancelButton));
        this.wait.until(ExpectedConditions.invisibilityOf(this.reassignTierConfirmationModal));
    }

    @FindBy(xpath = "//div[@id='confirm-dialog']//div[@class='modal-dialog']//div[@class='modal-footer']//button[@id='ok-confirm-btn']")
    protected WebElement reassignTierConfirmationModalYesButton;

    public void clickReassignTierConfirmationModalYesButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierConfirmationModalYesButton));
        this.reassignTierConfirmationModalYesButton.click();
    }

    @FindBy(xpath = "//div[@id='confirm-dialog']//div[@class='modal-dialog']//div[@class='modal-footer']//button[@id='cancel-confirm-btn']")
    protected WebElement reassignTierConfirmationModalCancelButton;

    public void clickReassignTierConfirmationModalCancelButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.reassignTierConfirmationModalCancelButton));
        this.reassignTierConfirmationModalCancelButton.click();
    }

    // toast

    public void waitForToastToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.toastContainer));
        this.wait.until(ExpectedConditions.visibilityOf(this.toast));
        this.wait.until(ExpectedConditions.visibilityOf(this.toastMessage));
        this.wait.until(ExpectedConditions.visibilityOf(this.toastMessageCloseButton));
    }

    public void waitForToastToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.toastContainer));
        this.wait.until(ExpectedConditions.invisibilityOf(this.toast));
        this.wait.until(ExpectedConditions.invisibilityOf(this.toastMessage));
        this.wait.until(ExpectedConditions.invisibilityOf(this.toastMessageCloseButton));
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

    // loyalty cards

    // membership points card

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//div[2]//div[@class='databox radius-bordered databox-shadowed databox-vertical']")
    protected WebElement membershipPointsCard;

    public boolean loyaltymembershipPointsCardIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.membershipPointsCard));
        return this.membershipPointsCard.isDisplayed();
    }

    // loyalty points card

    @FindBy(xpath = "//div[@id='loyalty-points-row']//span[@class='databox-number lightcarbon numOfPoints']")
    protected WebElement loyaltyPointsCard;

    public void clickLoyaltyPointsCard() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyPointsCard));
        this.loyaltyPointsCard.click();
    }

    public String getloyaltyPointsCount() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyPointsCard));
        return this.loyaltyPointsCard.getText();
    }

    @FindBy(xpath = "//div[@id='pointCurrencyDialog']//div//div//div[1]//h4[@class='modal-title']")
    protected WebElement loyaltyPointsCardTitleDialog;

    public void waitForLoyaltyPointsCardTitleDialogToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyPointsCardTitleDialog));
    }

    @FindBy(xpath = "//div[@id='pointCurrencyDialog']//div[@class='modal-dialog']//button[@class='btn btn-default btn-close']")
    protected WebElement loyaltyPointsCardDialogCloseButton;

    public void clickLoyaltyPointsCardDialogCloseButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyPointsCardDialogCloseButton));
        this.loyaltyPointsCardDialogCloseButton.click();
    }

    @FindBy(xpath = "//div[@id='loyalty-points-row']//span[@class='databox-number lightcarbon ytdPoints']")
    protected WebElement loyaltyYTDPointsCard;

    public void clickLoyaltyYTDPointsCard() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyYTDPointsCard));
        this.loyaltyYTDPointsCard.click();
    }

    @FindBy(xpath = "//div[@id='ytdPointCurrencyDialog']//div//div//div[1]//h4[@class='modal-title']")
    protected WebElement loyaltyYTDPointsCardTitleDialog;

    public void waitForLoyaltyYTDPointsCardTitleDialogToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyYTDPointsCardTitleDialog));
    }

    @FindBy(xpath = "//div[@id='ytdPointCurrencyDialog']//div[@class='modal-dialog']//button[@class='btn btn-default btn-close']")
    protected WebElement loyaltyYTDPointsCardDialogCloseButton;

    public void clickLoyaltyYTDPointsCardDialogCloseButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyYTDPointsCardDialogCloseButton));
        this.loyaltyYTDPointsCardDialogCloseButton.click();
    }

    // stays card

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//div[3]//div[@class='databox radius-bordered databox-shadowed databox-vertical']")
    protected WebElement staysCard;

    public boolean loyaltyStaysCardIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.staysCard));
        return this.staysCard.isDisplayed();
    }

    // points expiry card

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//div[4]//div[@class='databox radius-bordered databox-shadowed databox-vertical']")
    protected WebElement pointExpiringCard;

    public boolean loyaltyPointExpiringCardIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointExpiringCard));
        return this.pointExpiringCard.isDisplayed();
    }

    @FindBy(xpath = "//div[@id='loyalty-points-expiry-row']//span[@class='databox-text sonic-silver no-margin']")
    protected WebElement loyaltyPointsExpiringCard;

    public void clickLoyaltyPointsExpiringCard() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyPointsExpiringCard));
        this.loyaltyPointsExpiringCard.click();
    }

    @FindBy(xpath = "//div[@id='expiringPointsDialog']//div//div//div[1]//h4[@class='modal-title']")
    protected WebElement loyaltyPointsExpiringCardTitleDialog;

    public void waitForLoyaltyPointsExpiringCardTitleToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyPointsExpiringCardTitleDialog));
    }

    @FindBy(xpath = "//div[@id='expiringPointsDialog']//div[@class='modal-dialog']//button[@class='btn btn-default btn-close']")
    protected WebElement loyaltyPointsExpiringCardDialogCloseButton;

    public void clickLoyaltyPointsExpiringCardDialogCloseButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loyaltyPointsExpiringCardDialogCloseButton));
        this.loyaltyPointsExpiringCardDialogCloseButton.click();
    }

    // dollars spent card

    @FindBy(xpath = "//div[@id='chosenMembershipOnProfile']//div[5]//div[@class='databox radius-bordered databox-shadowed databox-vertical']")
    protected WebElement dollarSpentCard;

    public boolean loyaltyDollarSpentCardIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.dollarSpentCard));
        return this.dollarSpentCard.isDisplayed();
    }

    // points history table

    @FindBy(xpath = "//table[@id='pointsLogOverview']")
    protected WebElement pointsHistoryTable;

    public String getPointsHistoryTablePoints(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[1]")).getText();
    }

    public String getPointsHistoryTableEventType(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[2]")).getText();
    }

    public String getPointsHistoryTableReason(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[3]")).getText();
    }

    public String getPointsHistoryTableDate(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[4]")).getText();
    }

    public String getPointsHistoryTableUserName(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[5]")).getText();
    }

    public String getPointsHistoryTableReservationNumber(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[6]")).getText();
    }

    public String getPointsHistoryTableProperty(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[7]")).getText();
    }

    public String getPointsHistoryTableNights(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[8]")).getText();
    }

    public String getPointsHistoryTableDollarSpent(Integer Index) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTable));
        return this.pointsHistoryTable.findElement(By.xpath("./tbody/tr[" + Index + "]/td[9]")).getText();
    }

    @FindBy(xpath = "//div[@id='pointsLogOverview_info']")
    protected WebElement pointsHistoryTableEntries;

    public String getPointsHistoryTotalEntries() {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTableEntries));
        String fullMessage = this.pointsHistoryTableEntries.getText();
        return StringUtils.substringBetween(fullMessage, " of ", " entries");
    }

    public void waitForPointsHistoryTotalEntriesToBe(String currentText) {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsHistoryTableEntries));
        this.wait.until(ExpectedConditions.textToBePresentInElement(pointsHistoryTableEntries, "of " + currentText));
    }

    // manage points

    // manage points redeem or award dropdown

    @FindBy(xpath = "//select[@id='loyaltyRedeemOrAward']")
    protected WebElement managePointsRedeemOrAwardDropdown;

    public void selectManagePointsType(String managePointsType) {
        this.wait.until(ExpectedConditions.visibilityOf(this.managePointsRedeemOrAwardDropdown));
        this.managePointsRedeemOrAwardDropdown.click();
        Select selectManagePointsType = new Select(this.managePointsRedeemOrAwardDropdown);
        selectManagePointsType.selectByValue(managePointsType);

    }

    // manage points number of points

    @FindBy(xpath = "//input[contains(@name,'points')]")
    protected WebElement numberOfPointsAwardOrRedeemInput;

    public void enterPointsForAwardOrRedeem(String numberOfPoints) {
        this.wait.until(ExpectedConditions.visibilityOf(this.numberOfPointsAwardOrRedeemInput));
        this.numberOfPointsAwardOrRedeemInput.sendKeys(numberOfPoints);
    }

    // manage points number of nights

    @FindBy(xpath = "//input[contains(@name,'nights')]")
    protected WebElement numberOfNightsInput;

    public void enterNumberOfNights(String numberOfNights) {
        this.wait.until(ExpectedConditions.visibilityOf(this.numberOfNightsInput));
        this.numberOfNightsInput.sendKeys(numberOfNights);
    }

    // manage points or nights apply towards level of progress checkbox

    @FindBy(xpath = "//div[@class='checkbox']//label//input[@class='inverted applyTowardLevelProgress']/..")
    protected WebElement managePointsOrNightsApplyTowardsLevelOfProgressCheckbox;

    public void clickManagePointsOrNightsApplyTowardsLevelOfProgressCheckbox() {
        this.wait.until(ExpectedConditions.visibilityOf(this.managePointsOrNightsApplyTowardsLevelOfProgressCheckbox));
        this.managePointsOrNightsApplyTowardsLevelOfProgressCheckbox.click();
    }

    // manage points apply towards level progress checkbox

    // manage points change type

    @FindBy(xpath = "//select[@id='loyaltyPointsChangeType']")
    protected WebElement managePointsChangeTypeDropDown;

    public void selectChangeType(String managePointsType) {
        this.wait.until(ExpectedConditions.visibilityOf(this.managePointsChangeTypeDropDown));
        this.managePointsChangeTypeDropDown.click();
        Select selectChangeType = new Select(this.managePointsChangeTypeDropDown);
        selectChangeType.selectByValue(managePointsType);

    }

    // manage points list reservation id dropdown

    @FindBy(xpath = "//select[@id='listReservationIdToAssociate']")
    protected WebElement listReservationIdDropDown;

    public void selectListReservationId(String reservationNumber) {
        this.wait.until(ExpectedConditions.visibilityOf(this.listReservationIdDropDown));
        this.listReservationIdDropDown.click();
        Select selectListReservationId = new Select(this.listReservationIdDropDown);
        selectListReservationId.selectByVisibleText(reservationNumber);
    }

    // manage points property id dropdown

    @FindBy(xpath = "//select[contains(@id,'propertyIdToAssociate')]")
    protected WebElement propertyIdDropDown;

    public void selectPropertyId(String propertyName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.propertyIdDropDown));
        this.propertyIdDropDown.click();
        Select selectProperty = new Select(this.propertyIdDropDown);
        selectProperty.selectByVisibleText(propertyName);
    }

    // manage points reason

    @FindBy(xpath = "//textarea[@id='loyaltyPointsReason']")
    protected WebElement reasonForAwardOrRedeemPointsInput;

    public void enterReasonForAwardOrRedeemPoints(String reasonForAwardOrRedeemPoints) {
        this.wait.until(ExpectedConditions.visibilityOf(this.reasonForAwardOrRedeemPointsInput));
        this.reasonForAwardOrRedeemPointsInput.sendKeys(reasonForAwardOrRedeemPoints);
    }

    // manage points apply button

    @FindBy(xpath = "//button[@id='applyPointsToMembership']")
    protected WebElement pointsApplyButton;

    public void clickPointsApplyButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.pointsApplyButton));
        this.pointsApplyButton.click();
    }

    // manage points success message

    @FindBy(xpath = "//div[@class='alert successModifyingPoints alert-success fade in']")
    protected WebElement successMessage;

    public String getPointsAppliedSuccessMessage() {
        // NEEDS FIX: change timeout back to 25 when issue is resolved
        new WebDriverWait(this.driver, 50).until(ExpectedConditions.visibilityOf(this.successMessage));
        return this.successMessage.getText();
    }

    // redeem section

    @FindBy(xpath = "//div[@class='widget-header bordered-top borderedOrangWithBlue']/span[@class='widget-caption']/b[contains(text(), 'Redeem')]")
    protected WebElement redeemSectionHeader;

    public void goToRedeemSection() {
        JavascriptExecutor executor = (JavascriptExecutor) this.driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", this.redeemSectionHeader);
        Actions actions = new Actions(this.driver);
        actions.moveToElement(this.redeemSectionHeader).perform();
    }

    // redeem categories

    // redeem items list header

    @FindBy(xpath = "//div[@id='itemsBox']/div[@class='tab-pane  active ']/h1")
    protected WebElement redeemItemsListHeader;

    public String getRedeemItemsListHeaderText() {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemItemsListHeader));
        return redeemItemsListHeader.getText();
    }

    // redeem items list

    @FindBy(xpath = "//div[@id='itemsBox']/div[@class='tab-pane  active ']/ul")
    protected WebElement redeemItemsList;

    public List<WebElement> getredeemItemsListRows() {
        return this.redeemItemsList.findElements(By.xpath(".//li"));
    }

    public Integer getredeemItemsListRowsCount() {
        List<WebElement> rows = this.getredeemItemsListRows();
        return rows.size();
    }

    public String getRedeemItemsListItemName(Integer index) {
        List<WebElement> rows = this.getredeemItemsListRows();
        WebElement row = rows.get(index);
        WebElement nameElement = row.findElement(By.xpath(".//div[@class='media-body']/h4"));
        String name = nameElement.getText();
        return name;
    }

    public void clickRedeemItemsListRowsItemRedeemButton(Integer index) {
        List<WebElement> rows = this.getredeemItemsListRows();
        WebElement row = rows.get(index);
        WebElement redeemButton = row.findElement(By.xpath(".//div[@class='pull-left']/button"));
        redeemButton.click();
    }

    // redeem confirmation modal header

    @FindBy(xpath = "//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/h4[contains(text(), 'Confirmation')]")
    protected WebElement redeemConfirmationModalHeader;

    public void waitForRedeemConfirmationModalToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalHeader));
    }

    public void waitForRedeemConfirmationModalToBeInvisible() {
        this.wait.until(ExpectedConditions.invisibilityOf(this.redeemConfirmationModalHeader));
    }

    // redeem confirmation modal next button

    @FindBy(xpath = "//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div/button[@class='btn btn-default btn-success next']")
    protected WebElement redeemConfirmationModalNextButton;

    public void clickRedeemConfirmationModalNextButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalNextButton));
        this.redeemConfirmationModalNextButton.click();
    }

    // redeem confirmation modal cancel button

    @FindBy(xpath = "//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div/button[@class='btn btn-default btn-close']")
    protected WebElement redeemConfirmationModalCancelButton;

    public void clickRedeemConfirmationModalCancelButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalCancelButton));
        this.redeemConfirmationModalCancelButton.click();
    }

    // redeem confirmation modal shipping address

    @FindBy(xpath = "//div[@id='addressForm']/div/div/div/input[@placeholder='Address']")
    protected WebElement redeemConfirmationModalShippingAddressInput;

    public void enterRedeemConfirmationModalShippingAddress(String address) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalShippingAddressInput));
        this.redeemConfirmationModalShippingAddressInput.sendKeys(address);
    }

    @FindBy(xpath = "//div[@id='addressForm']/div/div/div/input[@placeholder='Address 2']")
    protected WebElement redeemConfirmationModalShippingAddress2Input;

    public void enterRedeemConfirmationModalShippingAddress2(String address2) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalShippingAddress2Input));
        this.redeemConfirmationModalShippingAddress2Input.sendKeys(address2);
    }

    @FindBy(xpath = "//div[@id='addressForm']/div/div/div/input[@placeholder='City']")
    protected WebElement redeemConfirmationModalShippingCityInput;

    public void enterRedeemConfirmationModalShippingCity(String cityName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalShippingCityInput));
        this.redeemConfirmationModalShippingCityInput.sendKeys(cityName);
    }

    @FindBy(xpath = "//div[@id='addressForm']/div/div/div/input[@placeholder='State']")
    protected WebElement redeemConfirmationModalShippingStateInput;

    public void enterRedeemConfirmationModalShippingState(String stateName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalShippingStateInput));
        this.redeemConfirmationModalShippingStateInput.sendKeys(stateName);
    }

    @FindBy(xpath = "//div[@id='addressForm']/div/div/div/input[@placeholder='Zip']")
    protected WebElement redeemConfirmationModalShippingZipInput;

    public void enterRedeemConfirmationModalShippingZip(String zipCode) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalShippingZipInput));
        this.redeemConfirmationModalShippingZipInput.sendKeys(zipCode);
    }

    @FindBy(xpath = "//div[@id='addressForm']/div/div/div/input[@placeholder='Country']")
    protected WebElement redeemConfirmationModalShippingCountryInput;

    public void enterRedeemConfirmationModalShippingCountry(String countryName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalShippingCountryInput));
        this.redeemConfirmationModalShippingCountryInput.sendKeys(countryName);
    }

    // redeem confirmation modal special instructions

    @FindBy(xpath = "//textarea[@id='specialInstructions']")
    protected WebElement redeemConfirmationModalSpecialInstructionsInput;

    public void enterRedeemConfirmationModalSpecialInstructions(String text) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalSpecialInstructionsInput));
        this.redeemConfirmationModalSpecialInstructionsInput.sendKeys(text);
    }

    // redeem confirmation modal portal

    @FindBy(xpath = "//select[@id='landingPageGroupSelect']")
    protected WebElement redeemConfirmationModalPortalDropDown;

    public void selectRedeemConfirmationModalPortalDropDown(String portalName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalPortalDropDown));
        this.redeemConfirmationModalPortalDropDown.click();
        Select selectPortal = new Select(this.redeemConfirmationModalPortalDropDown);
        selectPortal.selectByValue(portalName);
    }

    // redeem confirmation modal property

    @FindBy(xpath = "//select[@id='propertiesSelect']")
    protected WebElement redeemConfirmationModalPropertyDropDown;

    public void selectRedeemConfirmationModalPropertyDropDown(String propertyName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModalPropertyDropDown));
        this.redeemConfirmationModalPropertyDropDown.click();
        Select selectProperty = new Select(this.redeemConfirmationModalPropertyDropDown);
        selectProperty.selectByVisibleText(propertyName);
    }

    // redeem confirmation modal redeem button

    @FindBy(xpath = "//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div[@class='confirmShipping']/div/button[@class='btn btn-default btn-save btn-success']")
    protected WebElement clickRedeemConfirmationModalRedeemButton;

    public void clickRedeemConfirmationModalRedeemButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.clickRedeemConfirmationModalRedeemButton));
        this.clickRedeemConfirmationModalRedeemButton.click();
    }

    // redeem confirmation modal screen 2 cancel button (different than 1st cancel)

    @FindBy(xpath = "//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']/div[@class='confirmShipping']/div/button[@class='btn btn-default btn-close']")
    protected WebElement redeemConfirmationModal2CancelButton;

    public void clickRedeemConfirmationModal2CancelButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.redeemConfirmationModal2CancelButton));
        this.redeemConfirmationModal2CancelButton.click();
    }

}
