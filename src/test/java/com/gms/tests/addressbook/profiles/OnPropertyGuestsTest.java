package com.gms.tests.addressbook.profiles;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class OnPropertyGuestsTest extends BaseProfilesTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test select list owner dropdown functionality.")
	public void testSelectListOwner() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		// once we are using a seed, the initial table title can be asserted

		String listOwner = "List Owner PMS 3";
		this.profilesPage.clickListOwnerPropertyDropdownArrow();
		this.profilesPage.selectLopViaSearch(listOwner);
		Assert.assertEquals(this.profilesPage.getOnPropertyGuestsTableTitle(), "On Property Guests for " + listOwner,
				"On Property Guests table title is not 'On Property Guests for " + listOwner + "'.");

		listOwner = "List Owner PMS 4";
		this.profilesPage.clickListOwnerPropertyDropdownArrow();
		this.profilesPage.selectLopViaSearch(listOwner);
		Assert.assertEquals(this.profilesPage.getOnPropertyGuestsTableTitle(), "On Property Guests for " + listOwner,
				"On Property Guests table title is not 'On Property Guests for " + listOwner + "'.");
	}
}