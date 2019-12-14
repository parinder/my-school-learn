package com.myschool.learn.gms.tests.addressbook.filters;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import com.myschool.learn.gms.pages.addressbook.EditFilterPage;
import com.myschool.learn.gms.pages.addressbook.NavigationBarPage;
import com.myschool.learn.gms.pages.addressbook.NewFilterPage;
import com.myschool.learn.gms.pages.profiles.ProfilesPage;

public class AddNewFilterTest extends BaseFiltersTest {

	protected NavigationBarPage addressBookNavigationBarPage;
	protected NewFilterPage newFilterPage;
	protected EditFilterPage editFilterPage;
	protected ProfilesPage profilesPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.addressBookNavigationBarPage = new NavigationBarPage(this.driver, config);
		this.newFilterPage = new NewFilterPage(this.driver, config);
		this.editFilterPage = new EditFilterPage(this.driver, config);
		this.profilesPage = new ProfilesPage(this.driver, config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test add new filter.")
	public void testAddNewFilter() {
		this.filtersHomePage.get();
		this.filtersHomePage.waitForPageLoad();

		this.addressBookNavigationBarPage.clickAddNewFilterButton();
		this.driver.switchTo().frame("canvas");
		this.newFilterPage.waitForPageLoad();

		this.newFilterPage.clickcitySelectOption();
		this.newFilterPage.clickSelectFieldsButton();
		this.editFilterPage.waitForPageLoad();

		Assert.assertTrue(this.editFilterPage.cityIncludingFieldsDropdownIsVisible(),
				"City including fields dropdown should be visible.");
		Assert.assertTrue(this.editFilterPage.cityIncludingFieldsInputIsVisible(),
				"City including fields input should be visible.");
		Assert.assertTrue(this.editFilterPage.cityExcludingFieldsDropdownIsVisible(),
				"City excluding fields dropdown should be visible.");
		Assert.assertTrue(this.editFilterPage.cityExcludingFieldsInputIsVisible(),
				"City excluding fields input should be visible.");
				
		this.driver.switchTo().defaultContent();
		
		this.addressBookNavigationBarPage.clickFiltersTab();
		this.filtersListPage.enterFiltersSearchInput("City");
		this.filtersListPage.clickListOfFiltersTableRow(0);

		this.driver.switchTo().frame("canvas");
		this.editFilterPage.waitForPageLoad();

		Assert.assertTrue(this.editFilterPage.cityIncludingFieldsDropdownIsVisible(),
				"City including fields dropdown should be visible.");
		Assert.assertTrue(this.editFilterPage.cityIncludingFieldsInputIsVisible(),
				"City including fields input should be visible.");
		Assert.assertTrue(this.editFilterPage.cityExcludingFieldsDropdownIsVisible(),
				"City excluding fields dropdown should be visible.");
		Assert.assertTrue(this.editFilterPage.cityExcludingFieldsInputIsVisible(),
				"City excluding fields input should be visible.");

		// actually creating new filter(s) should be tested
	}
}