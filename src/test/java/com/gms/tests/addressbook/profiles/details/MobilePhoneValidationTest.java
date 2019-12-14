package com.gms.tests.addressbook.profiles.details;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import com.gms.pages.profiles.ProfilesPage;
import com.gms.tests.addressbook.profiles.BaseProfilesTest;

public class MobilePhoneValidationTest extends BaseProfilesTest {

	protected ProfilesPage profilesPage;

	protected String mobilePhoneValidationMessage = "Phone numbers must be in valid E.164 format.";

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.profilesPage = new ProfilesPage(this.driver, config);
	}

	@Test(description = "Test mobile phone validation of valid phone number.")
	public void testMobilePhoneValidationValidNumber() {
		String testProfileEmail = "xander.larkin.49615@example.com";

		this.login(this.defaultUsername, this.defaultPassword);

		this.goToProfile(testProfileEmail);
		this.headerPage.clickProfileDetailsTab();
		this.detailsTabPage.waitForPageLoad();

		this.detailsTabPage.enterMobilePhone("16133214321");
		this.detailsTabPage.clickSaveButton();
		this.detailsTabPage.waitForSuccessMessageToBeVisible();
		this.detailsTabPage.clickSuccessMessageCloseButton();
		this.detailsTabPage.waitForMobilePhoneToHaveNoValidationError();
	}

	@Test(description = "Test mobile phone validation of blank value.")
	public void testMobilePhoneValidationBlank() {
		String testProfileEmail = "xander.larkin.49615@example.com";

		this.login(this.defaultUsername, this.defaultPassword);

		this.goToProfile(testProfileEmail);
		this.headerPage.clickProfileDetailsTab();
		this.detailsTabPage.waitForPageLoad();

		this.detailsTabPage.enterMobilePhone("");
		this.detailsTabPage.clickSaveButton();
		this.detailsTabPage.waitForSuccessMessageToBeVisible();
		this.detailsTabPage.clickSuccessMessageCloseButton();
		this.detailsTabPage.waitForMobilePhoneToHaveNoValidationError();
	}

	@Test(description = "Test mobile phone validation of invalid characters.")
	public void testMobilePhoneValidationInvalidCharacters() {
		String testProfileEmail = "xander.larkin.49615@example.com";

		this.login(this.defaultUsername, this.defaultPassword);

		this.goToProfile(testProfileEmail);
		this.headerPage.clickProfileDetailsTab();
		this.detailsTabPage.waitForPageLoad();

		this.detailsTabPage.enterMobilePhone("abc");
		this.detailsTabPage.clickSaveButton();
		// save success does not appear

		this.detailsTabPage.waitForMobilePhoneToHaveValidationError();
		this.detailsTabPage.hoverOverMobilePhone();
		Assert.assertTrue(this.detailsTabPage.getMobilePhoneValidationMessage().contains(mobilePhoneValidationMessage),
				"Mobile phone validation message should say '" + mobilePhoneValidationMessage + "'");
	}

	@Test(description = "Test mobile phone validation of invalid area code.")
	public void testMobilePhoneValidationInvalidAreaCode() {
		String testProfileEmail = "xander.larkin.49615@example.com";

		this.login(this.defaultUsername, this.defaultPassword);

		this.goToProfile(testProfileEmail);
		this.headerPage.clickProfileDetailsTab();
		this.detailsTabPage.waitForPageLoad();

		this.detailsTabPage.enterMobilePhone("11235554321");
		this.detailsTabPage.clickSaveButton();
		this.detailsTabPage.waitForSuccessMessageToBeVisible();
		this.detailsTabPage.clickSuccessMessageCloseButton();

		this.detailsTabPage.waitForMobilePhoneToHaveValidationError();
		this.detailsTabPage.hoverOverMobilePhone();
		Assert.assertTrue(this.detailsTabPage.getMobilePhoneValidationMessage().contains(mobilePhoneValidationMessage),
				"Mobile phone validation message should say '" + mobilePhoneValidationMessage + "'");
	}
}