package com.gms.pages.profiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gms.configuration.Config;
import com.gms.pages.BasePage;

public class ProfilesPage extends BasePage {

	public ProfilesPage(WebDriver driver, Config config) {
		super(driver, config);
		this.url = this.config.getProperty("app.gms.baseurl") + "profiles";
	}

	public void waitForPageLoad() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addNewProfileButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchButton));

		this.wait.until(ExpectedConditions.visibilityOf(this.navigationBarHomeLink));
		this.wait.until(ExpectedConditions.visibilityOf(this.navigationBarAddressBookLink));
		this.wait.until(ExpectedConditions.visibilityOf(this.navigationBarProfilesLink));
	}

	// Navigation Bar

	@FindBy(xpath = "//div[contains(@class,'breadcrumbs')]//ul//li//i[contains(@class,'home')]/following-sibling::a[contains(@href,'gms')]")
	protected WebElement navigationBarHomeLink;

	public void clickNavigationBarHomeLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.navigationBarHomeLink));
		this.navigationBarHomeLink.click();
	}

	@FindBy(xpath = "//div[contains(@class,'breadcrumbs')]//ul//li//a[contains(@href,'addressBook') and contains(@href,'filters')]")
	protected WebElement navigationBarAddressBookLink;

	public void clickNavigationBarAddresBookLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.navigationBarAddressBookLink));
		this.navigationBarAddressBookLink.click();
	}

	@FindBy(xpath = "//div[contains(@class,'breadcrumbs')]//ul//li//a[contains(@href,'profiles')]")
	protected WebElement navigationBarProfilesLink;

	public void clickNavigationBarProfilesLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.navigationBarProfilesLink));
		this.navigationBarProfilesLink.click();
	}

	// Left Search Section

	@FindBy(xpath = "//button[contains(@class,'add-new-profile')]")
	protected WebElement addNewProfileButton;

    public boolean addNewProfileButtonIsVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addNewProfileButton));
        return this.addNewProfileButton.isDisplayed();
    }

	public void clickAddNewProfileButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addNewProfileButton));
		this.addNewProfileButton.click();
	}

	// Left Profile Search Section

	public void waitForProfileSearchSectionToBeOpen() {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchFirstNameInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchLastNameInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchEmailInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchButton));
	}

	public void waitForProfileSearchSectionToBeClosed() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchFirstNameInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchLastNameInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchEmailInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchButton));
	}

	@FindBy(xpath = "//a//i[contains(@class,'user')]")
	protected WebElement profileSearchExpandMenu;

	public void clickProfileSearchExpandMenu() {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchExpandMenu));
		this.profileSearchExpandMenu.click();
	}

	@FindBy(xpath = "//input[@id='profileSearchFirstName']")
	protected WebElement profileSearchFirstNameInput;

	public void enterProfileSearchFirstName(String firstName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchFirstNameInput));
		this.profileSearchFirstNameInput.clear();
		this.profileSearchFirstNameInput.sendKeys(firstName);
	}

	@FindBy(xpath = "//input[@id='profileSearchLastName']")
	protected WebElement profileSearchLastNameInput;

	public void enterProfileSearchLastName(String lastName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchLastNameInput));
		this.profileSearchLastNameInput.clear();
		this.profileSearchLastNameInput.sendKeys(lastName);
	}

	@FindBy(xpath = "//input[@id='profileSearchEmail']")
	protected WebElement profileSearchEmailInput;

	public void enterProfileSearchEmail(String profileEmail) {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchEmailInput));
		this.profileSearchEmailInput.clear();
		this.profileSearchEmailInput.sendKeys(profileEmail);
	}

	@FindBy(xpath = "//a[@id='showAdvancedSearch']")
	protected WebElement profileSearchAdvancedOptionsLink;

	public void clickAdvancedOptionsLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchAdvancedOptionsLink));
		this.profileSearchAdvancedOptionsLink.click();
	}

	// Left Profile Search Advanced options section

	public void waitForProfileSearchAdvancedOptionsSectionToBeOpen() {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchCompanyInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchStateInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchCityInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchCountryDropdown));
	}

	public void waitForProfileSearchAdvancedOptionsSectionToBeClosed() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchCompanyInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchStateInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchCityInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.profileSearchCountryDropdown));
	}

	@FindBy(xpath = "//div[not(contains(@class,'hidden')) and contains(@class,'advanced')]/following-sibling::a")
	protected WebElement profileSearchHideAdvancedOptionsLink;

	public void clickHideAdvancedOptionsLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchAdvancedOptionsLink));
		this.profileSearchAdvancedOptionsLink.click();
	}

	@FindBy(xpath = "//input[contains(@name,'company')]")
	protected WebElement profileSearchCompanyInput;

	@FindBy(xpath = "//input[contains(@name,'state')]")
	protected WebElement profileSearchStateInput;

	@FindBy(xpath = "//input[contains(@name,'city')]")
	protected WebElement profileSearchCityInput;

	@FindBy(xpath = "//span[contains(@class,'icon')]//select[contains(@name,'country')]")
	protected WebElement profileSearchCountryDropdown;

	@FindBy(xpath = "//button[@id='profileSearch']")
	protected WebElement profileSearchButton;

	public void clickProfileSearchButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSearchButton));
		this.profileSearchButton.click();
	}

	// Left Sidebar Loyalty Search Section

	public void waitForLoyaltySearchSectionToBeOpen() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loyaltySearchMemberNumberInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.loyaltySearchprogramDropdown));
		this.wait.until(ExpectedConditions.visibilityOf(this.loyaltySearchButton));
	}

	public void waitForLoyaltySearchSectionToBeClosed() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.loyaltySearchMemberNumberInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.loyaltySearchprogramDropdown));
		this.wait.until(ExpectedConditions.invisibilityOf(this.loyaltySearchButton));
	}

	@FindBy(xpath = "//a//i[contains(@class,'heart')]")
	protected WebElement loyaltySearchExpandMenu;

	public void clickLoyaltySearchExpandMenu() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loyaltySearchExpandMenu));
		this.loyaltySearchExpandMenu.click();
	}

	@FindBy(xpath = "//input[@id='profileSearchMemberNumber']")
	protected WebElement loyaltySearchMemberNumberInput;

	public void enterLoyaltySearchMemberNumber(String memberNumber) {
		this.wait.until(ExpectedConditions.visibilityOf(this.loyaltySearchMemberNumberInput));
		this.loyaltySearchMemberNumberInput.clear();
		this.loyaltySearchMemberNumberInput.sendKeys(memberNumber);
	}

	@FindBy(xpath = "//label[contains(@for,'memberhsip-search-program')]/following-sibling::span")
	protected WebElement loyaltySearchprogramDropdown;

	public void selectAndEnterProgram(String program) {
		this.wait.until(ExpectedConditions.visibilityOf(this.loyaltySearchprogramDropdown));
		this.loyaltySearchprogramDropdown.click();
		programDropdownInput.sendKeys(program);
		programDropdownInput.sendKeys(Keys.ARROW_DOWN);
		programDropdownInput.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//span[contains(@class,'select')]//span[contains(@class,'dropdown')]//span//input[contains(@type,'search')]")
	protected WebElement programDropdownInput;

	@FindBy(how = How.ID, using = "membershipSearch")
	protected WebElement loyaltySearchButton;

	public void clickLoyaltySearchButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.loyaltySearchButton));
		this.loyaltySearchButton.click();
	}

	// Left Sidebar Comment Search Section

	public void waitForCommentSearchSectionToBeOpen() {
		this.wait.until(ExpectedConditions.visibilityOf(this.commentSearchcommentInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.commentSearchButton));
	}

	public void waitForCommentSearchSectionToBeClosed() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.commentSearchcommentInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.commentSearchButton));
	}

	@FindBy(xpath = "//a//i[contains(@class,'comments')]")
	protected WebElement commentSearchExpandMenu;

	public void clickCommentSearchExpandMenuMenu() {
		this.wait.until(ExpectedConditions.visibilityOf(this.commentSearchExpandMenu));
		this.commentSearchExpandMenu.click();
	}

	@FindBy(xpath = "//input[contains(@name,'comment')]")
	protected WebElement commentSearchcommentInput;

	public void enterCommentSearchComment(String comment) {
		this.wait.until(ExpectedConditions.visibilityOf(this.commentSearchcommentInput));
		this.commentSearchcommentInput.sendKeys(comment);
	}

	@FindBy(xpath = "//button[@id='commentsSearch']")
	protected WebElement commentSearchButton;

	public void clickCommentSearchButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.commentSearchButton));
		this.commentSearchButton.click();
	}

	// Left Sidebar Reservation Search Section

	public void waitForReservationSearchSectionToBeOpen() {
		this.wait.until(ExpectedConditions.visibilityOf(this.reservationSearchReservationNumberInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.reservationSearchButton));
	}

	public void waitForReservationSearchSectionToBeClosed() {
		this.wait.until(ExpectedConditions.invisibilityOf(this.reservationSearchReservationNumberInput));
		this.wait.until(ExpectedConditions.invisibilityOf(this.reservationSearchButton));
	}

	@FindBy(xpath = "//a//i[contains(@class,'hotel')]")
	protected WebElement reservationsSearchExpandMenu;

	public void clickReservationsSearchExpandMenu() {
		this.wait.until(ExpectedConditions.visibilityOf(this.reservationsSearchExpandMenu));
		this.reservationsSearchExpandMenu.click();
	}

	@FindBy(xpath = "//input[contains(@name,'reservationId')]")
	protected WebElement reservationSearchReservationNumberInput;

	public void enterReservationSearchReservationNumber(String reservationNumber) {
		this.wait.until(ExpectedConditions.visibilityOf(this.reservationSearchReservationNumberInput));
		this.reservationSearchReservationNumberInput.sendKeys(reservationNumber);
	}

	@FindBy(xpath = "//button[@id='reservationsSearch']")
	protected WebElement reservationSearchButton;

	public void clickReservationSearchButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.reservationSearchButton));
		this.reservationSearchButton.click();
	}

	@FindBy(xpath = "//input[@id='reservations-from-date']")
	protected WebElement profileReservationFromDateInput;

	@FindBy(xpath = "//input[@id='reservations-to-date']")
	protected WebElement profileReservationToDateInput;

	// Left Sidebar Results Section

	@FindBy(xpath = "//input[contains(@aria-controls,'searchResultsTable')]")
	protected WebElement searchResultFilterInput;

	public void enterSearchResultFilter(String filterString) {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchResultFilterInput));
		this.searchResultFilterInput.sendKeys(filterString);
	}

	@FindBy(xpath = "//table[@id='searchResultsTable']/tbody")
	protected WebElement searchResultTable;

	public List<WebElement> getProfileSearchResultTableRows() {
		this.wait.until(ExpectedConditions.visibilityOf(this.searchResultTable));
		this.wait.until(ExpectedConditions.visibilityOf(this.searchResultTable.findElement(By.tagName("tr"))));
		return searchResultTable.findElements(By.tagName("tr"));
	}

	public Integer getProfileSearchResultTableRowCount() {
		List<WebElement> rows = this.getProfileSearchResultTableRows();
		return rows.size();
	}

	public String getProfileSearchResultsTableRowContents(Integer index) {
		List<WebElement> rows = this.getProfileSearchResultTableRows();
		WebElement row = rows.get(index);
		return row.getText();
	}

	public void clickProfileSearchResultTableRow(Integer index) {
		List<WebElement> rows = this.getProfileSearchResultTableRows();
		WebElement row = rows.get(index);
		row.click();
	}

	// *********** Main Section List Owner DropDown ************** //

	@FindBy(xpath = "//select[contains(@class,'on-property-lop-select')]/../../..//preceding-sibling::span/following-sibling::span")
	protected WebElement listOwnerPropertyDropdownArrow;

	public void clickListOwnerPropertyDropdownArrow() {
		this.wait.until(ExpectedConditions.visibilityOf(this.listOwnerPropertyDropdownArrow));
		this.listOwnerPropertyDropdownArrow.click();
	}

	@FindBy(xpath = "//select[contains(@class,'on-property-lop-select')]/following-sibling::span")
	protected WebElement select;

	@FindBy(xpath = "//input[contains(@class,'search') and contains(@type,'search')]")
	protected WebElement lopSearchInput;

	public void selectLopViaSearch(String lopName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.lopSearchInput));
		lopSearchInput.sendKeys(lopName);
		lopSearchInput.sendKeys(Keys.ARROW_DOWN);
		lopSearchInput.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//b[contains(@class,'results-title')]")
	protected WebElement onPropertyGuestsTableTitle;

	public String getOnPropertyGuestsTableTitle() {
		this.wait.until(ExpectedConditions.visibilityOf(this.onPropertyGuestsTableTitle));
		return this.onPropertyGuestsTableTitle.getText();
	}

	// *********** Main Section On Properties Guest List Section ************** //

	@FindBy(xpath = "//i[contains(@class,'mobile')]")
	protected WebElement sendMessageButton;

    public void clickSendMessageButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.sendMessageButton));
		this.sendMessageButton.click();
	}

	// *********** New Profile Modal ************** //

	public void waitForAddNewProfileModalToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addNewProfileModalTitle));
		this.wait.until(ExpectedConditions.visibilityOf(this.newProfileModalFirstNameInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.newProfileModalLastNameInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.middleInitialInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.birthdayInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.emailAddressInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.languageDropdown));
		this.wait.until(ExpectedConditions.visibilityOf(this.genderDropdown));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileCloseButton));
		this.wait.until(ExpectedConditions.visibilityOf(this.profileSaveButton));
	}

	public void waitForAddNewProfileModalMoreFieldsToBeVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.addressInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.cityInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.stateInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.zipPostalCodeInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.countryDropdown));
		this.wait.until(ExpectedConditions.visibilityOf(this.homePhoneInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.mobilePhoneInput));
		this.wait.until(ExpectedConditions.visibilityOf(this.companyInput));
	}

	@FindBy(xpath = "//h4[contains(@class,'modal-title')]")
	protected WebElement addNewProfileModalTitle;

	@FindBy(xpath = "//a[contains(@class,'showAdvanced')]")
	protected WebElement newProfileModalShowMoreFieldsLink;

	public void clickNewProfileModalShowMoreFieldsLink() {
		this.wait.until(ExpectedConditions.visibilityOf(this.newProfileModalShowMoreFieldsLink));
		this.newProfileModalShowMoreFieldsLink.click();
	}

	@FindBy(xpath = "//input[contains(@id,'profile-first-name')]")
	protected WebElement newProfileModalFirstNameInput;

	@FindBy(xpath = "//input[contains(@id,'profile-last-name')]")
	protected WebElement newProfileModalLastNameInput;

	@FindBy(xpath = "//input[contains(@id,'profile-middle-initial')]")
	protected WebElement middleInitialInput;

	@FindBy(xpath = "//span[contains(@class,'icon')]//input[contains(@data-date-hidden-input-name,'birthday')]")
	protected WebElement birthdayInput;

	@FindBy(xpath = "//input[contains(@id,'profile-email')]")
	protected WebElement emailAddressInput;

	@FindBy(xpath = "//select[contains(@name,'twoLetterLanguageCode')]/../../..//preceding-sibling::span/following-sibling::span")
	protected WebElement languageDropdown;

	@FindBy(xpath = "//select[contains(@name,'gender')]")
	protected WebElement genderDropdown;

	@FindBy(xpath = "//div[contains(@class,'form-title')]/..//following-sibling::input[contains(@id,'profile-address')]")
	protected WebElement addressInput;

	@FindBy(xpath = "//div[contains(@class,'form-title')]/..//following-sibling::input[contains(@id,'profile-city')]")
	protected WebElement cityInput;

	@FindBy(xpath = "//div[contains(@class,'form-title')]/..//following-sibling::input[contains(@id,'profile-state')]")
	protected WebElement stateInput;

	@FindBy(xpath = "//div[contains(@class,'form-title')]/..//following-sibling::input[contains(@id,'profile-zip')]")
	protected WebElement zipPostalCodeInput;

	@FindBy(xpath = "(//select[contains(@id,'profile-country')])[1]")
	protected WebElement countryDropdown;

	@FindBy(xpath = "//input[contains(@id,'profile-home-phone')]")
	protected WebElement homePhoneInput;

	@FindBy(xpath = "//input[contains(@id,'profile-mobile-phone')]")
	protected WebElement mobilePhoneInput;

	@FindBy(xpath = "//input[contains(@id,'profile-company')]")
	protected WebElement companyInput;

	@FindBy(xpath = "//div[contains(@class,'modal-footer')]//button[contains(@class,'close')]")
	protected WebElement profileCloseButton;

	public void clickProfileCloseButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.profileCloseButton));
		this.profileCloseButton.click();
	}

	@FindBy(xpath = "//div[contains(@class,'modal-footer')]//button[contains(@class,'save')]")
	protected WebElement profileSaveButton;

	// membership activation email dialog

	@FindBy(xpath = "//div[@id='error-dialog']//div[@class='modal-dialog']")
	protected WebElement membershipActivationEmailHasBeenSentModal;

	public boolean membershipActivationEmailHasBeenSentModalIsVisible() {
		this.wait.until(ExpectedConditions.visibilityOf(this.membershipActivationEmailHasBeenSentModal));
		return this.membershipActivationEmailHasBeenSentModal.isDisplayed();

	}

	@FindBy(xpath = "//div[@id='error-dialog']//div[@class='modal-dialog']//button[@class='btn btn-warning close-error-modal']")
	protected WebElement membershipActivationEmailHasBeenSentModalCloseButton;

	public void clickMembershipActivationEmailHasBeenSentModalCloseButton() {
		this.wait.until(ExpectedConditions.visibilityOf(this.membershipActivationEmailHasBeenSentModal));
		this.membershipActivationEmailHasBeenSentModalCloseButton.click();

	}

}
