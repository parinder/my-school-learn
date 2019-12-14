package com.myschool.learn.gms.pages.profiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.myschool.learn.gms.configuration.Config;
import com.myschool.learn.gms.pages.BasePage;

public class AddNewProfileModalPage extends BasePage {

    protected String tableEntriesMessage;

    public AddNewProfileModalPage(WebDriver driver, Config config) {
        super(driver, config);
    }

    public void waitForPageLoad() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewProfileDialog));
        this.wait.until(ExpectedConditions.visibilityOf(this.profileFirstNameInput));
    }

    @FindBy(xpath = "//div[@id='addNewProfile']//div[@class='modal-dialog']")
    protected WebElement addNewProfileDialog;

    @FindBy(xpath = "//input[@id='profile-first-name']")
    protected WebElement profileFirstNameInput;

    public void enterProfileFirstName(String firstName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileFirstNameInput));
        this.profileFirstNameInput.sendKeys(firstName);
    }

    @FindBy(xpath = "//input[@id='profile-last-name']")
    protected WebElement profileLastNameInput;

    public void enterProfileLastName(String lastName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileLastNameInput));
        this.profileLastNameInput.sendKeys(lastName);
    }

    @FindBy(xpath = "//div[@id='addNewProfile']//form[1]//input[@placeholder='Salutation']")
    protected WebElement profileSalutationInput;

    public void enterProfileSalutation(String Salutation) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileSalutationInput));
        this.profileSalutationInput.sendKeys(Salutation);
    }

    @FindBy(xpath = "//input[@id='profile-middle-initial']")
    protected WebElement profileMiddleIntialInput;

    public void enterProfileMiddleIntialInput(String middleIntial) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileMiddleIntialInput));
        this.profileMiddleIntialInput.sendKeys(middleIntial);
    }

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-12']//span[@class='input-icon icon-right']//input[1]")
    protected WebElement profileBirthdayInput;

    public void enterProfileBirthdayInput(String dateOfBirth) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileBirthdayInput));
        this.profileBirthdayInput.sendKeys(dateOfBirth);
    }

    @FindBy(xpath = "//input[@id='profile-email']")
    protected WebElement profileEmailInput;

    public String enterProfileEmailInput(String emailAddress) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileEmailInput));
        this.profileEmailInput.click();
        this.profileEmailInput.sendKeys(emailAddress);
        return emailAddress;
    }

    @FindBy(xpath = "//span[contains(text(),'Enroll Membership')]")
    protected WebElement enrollMembershipToggle;

    public void clickEnrollMembershipToggle() {
        this.wait.until(ExpectedConditions.visibilityOf(this.enrollMembershipToggle));
        this.enrollMembershipToggle.click();
    }

    @FindBy(xpath = "//span[@id='select2-profile-memberships-add-profile-container']")
    protected WebElement programEnroll;

    public void clickToEnrollProgram() {
        this.wait.until(ExpectedConditions.visibilityOf(this.programEnroll));
        this.programEnroll.click();
    }

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
    protected WebElement programEnrollInput;

    public void enterNameOfGuestProgram(String guestProgramName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.programEnrollInput));
        this.programEnrollInput.sendKeys(guestProgramName);
        this.programEnrollInput.sendKeys(Keys.ARROW_DOWN);
        this.programEnrollInput.sendKeys(Keys.ENTER);

    }

    @FindBy(xpath = "//span[@id='select2-profile-portals-add-profile-container']")
    protected WebElement guestPortalToEnroll;

    public void clickToEnrollGuestPortalForProgram() {
        this.wait.until(ExpectedConditions.visibilityOf(this.guestPortalToEnroll));
        this.guestPortalToEnroll.click();
    }

    @FindBy(xpath = "//ul[@id='select2-profile-portals-add-profile-results']//li[2]")
    protected WebElement guestPortalInput;

    public void clickToAddGuestPortal() {
        this.wait.until(ExpectedConditions.visibilityOf(this.guestPortalInput));
        this.guestPortalInput.click();

    }

    @FindBy(xpath = "//input[@id='is-mail-opt")
    protected WebElement emailOptInToggleButton;

    public void clickToEmailOptInToggleButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.emailOptInToggleButton));
        this.emailOptInToggleButton.click();
    }

    @FindBy(xpath = "//span[@id='select2-profile-language-code-container']")
    protected WebElement profileLanguage;

    public void clickToProfileLanguage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileLanguage));
        this.profileLanguage.click();
    }

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
    protected WebElement profileLanguageInput;

    public void enterProfileLanguage(String language) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileLanguageInput));
        this.profileLanguageInput.sendKeys(language);
        this.programEnrollInput.sendKeys(Keys.ARROW_DOWN);
        this.profileLanguageInput.sendKeys(Keys.ENTER);

    }

    @FindBy(xpath = "//div[@class='form-group']//select[@name='gender']")
    protected WebElement profileGenderDropDown;

    public void selectProfileGender(String gender) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileGenderDropDown));
        this.profileGenderDropDown.click();
        Select selectGenderType = new Select(this.profileGenderDropDown);
        selectGenderType.selectByValue(gender);

    }

    @FindBy(xpath = "//input[@id='profile-address']")
    protected WebElement profileAddressInput;

    public void enterProfileAddress(String address) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileAddressInput));
        this.profileAddressInput.sendKeys(address);

    }

    @FindBy(xpath = "//a[@class='showAdvanced']")
    protected WebElement showMoreFieldsLink;

    public void clickToOpenProfileAdditionalFields() {
        this.wait.until(ExpectedConditions.visibilityOf(this.showMoreFieldsLink));
        this.showMoreFieldsLink.click();

    }

    @FindBy(xpath = "//input[@id='profile-address-2']")
    protected WebElement profileAddress2Input;

    public void enterProfileAddress2(String address2) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileAddress2Input));
        this.profileAddress2Input.sendKeys(address2);

    }

    @FindBy(xpath = "//input[@id='profile-city']")
    protected WebElement profileCityInput;

    public void enterProfileCity(String cityName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCityInput));
        this.profileCityInput.sendKeys(cityName);

    }

    @FindBy(xpath = "//input[@id='profile-state']")
    protected WebElement profileStateInput;

    public void enterProfileState(String stateName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileStateInput));
        this.profileStateInput.sendKeys(stateName);

    }

    @FindBy(xpath = "//input[@id='profile-zip']")
    protected WebElement profileZipInput;

    public void enterProfileZip(String zipCode) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileZipInput));
        this.profileZipInput.sendKeys(zipCode);

    }

    @FindBy(xpath = "//span[@id='select2-profile-country-container']")
    protected WebElement profileCountry;

    public void clickToProfileCountry() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCountry));
        this.profileCountry.click();
    }

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
    protected WebElement profileCountryInput;

    public void enterProfileCountry(String countryName) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCountryInput));
        this.profileCountryInput.sendKeys(countryName);
        this.profileCountryInput.sendKeys(Keys.ARROW_DOWN);
        this.profileCountryInput.sendKeys(Keys.ENTER);

    }

    @FindBy(xpath = "//input[@id='profile-citizenship']")
    protected WebElement profileCitizenInput;

    public void enterProfileCitizenship(String citizenship) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCitizenInput));
        this.profileCitizenInput.sendKeys(citizenship);

    }

    @FindBy(xpath = "//input[@id='profile-home-phone']")
    protected WebElement profileHomePhoneInput;

    public void enterProfileHomePhone(String homePhoneNumber) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileHomePhoneInput));
        this.profileHomePhoneInput.sendKeys(homePhoneNumber);

    }

    @FindBy(xpath = "//input[@id='profile-mobile-phone']")
    protected WebElement profileCellPhoneInput;

    public void enterProfileCellPhone(String cellPhoneNumber) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCellPhoneInput));
        this.profileCellPhoneInput.sendKeys(cellPhoneNumber);

    }

    @FindBy(xpath = "//input[@id='profile-work-phone']")
    protected WebElement profileWorkPhoneInput;

    public void enterProfileWorkPhone(String workPhoneNumber) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileWorkPhoneInput));
        this.profileWorkPhoneInput.sendKeys(workPhoneNumber);

    }

    @FindBy(xpath = "//input[@id='profile-fax']")
    protected WebElement profileFaxInput;

    public void enterProfileFax(String faxNumber) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileFaxInput));
        this.profileFaxInput.sendKeys(faxNumber);

    }

    @FindBy(xpath = "//input[@id='profile-work-title']")
    protected WebElement profileWorkTitleInput;

    public void enterProfileWorkTitle(String workTitle) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileWorkTitleInput));
        this.profileWorkTitleInput.sendKeys(workTitle);

    }

    @FindBy(xpath = "//input[@id='profile-company']")
    protected WebElement profileCompanyNameInput;

    public void enterProfileComapnyName(String company) {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileCompanyNameInput));
        this.profileCompanyNameInput.sendKeys(company);

    }

    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-default btn-save btn-success']")
    protected WebElement profileDetailsSaveButton;

    public void clickProfileDetailsSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileDetailsSaveButton));
        this.profileDetailsSaveButton.click();

    }

    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-default btn-close']")
    protected WebElement profileDialogCloseButton;

    public void clickToCloseAddNewProfileDialog() {
        this.wait.until(ExpectedConditions.visibilityOf(this.profileDialogCloseButton));
        this.profileDialogCloseButton.click();

    }

}