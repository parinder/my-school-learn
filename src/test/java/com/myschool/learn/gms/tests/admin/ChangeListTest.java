package com.myschool.learn.gms.tests.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myschool.learn.gms.pages.admin.ChangeListPage;
import com.myschool.learn.gms.pages.admin.ManageUsersPage;
import com.myschool.learn.gms.pages.rezqueue.RezqueueHomePage;
import com.myschool.learn.gms.pages.rezqueue.RezqueueLoginPage;

public class ChangeListTest extends BaseAdminTest {
	protected ManageUsersPage manageUsersPage;
	protected RezqueueLoginPage rezqueueLoginPage;
	protected RezqueueHomePage rezqueueHomePage;
	protected ChangeListPage changeListPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.changeListPage = new ChangeListPage(this.driver, this.config);
	}

	@Test(description = "Verify changing between lists.")
	public void testChangeList() {
		String testUsername = "qaautomated.multiple-list";
		String defaultList = "QA Team - AUTOMATED Tests (DO NOT TOUCH)";
		String otherList = "QA Team - RES AUTOMATED Tests (DO NOT TOUCH)";

		this.login(testUsername, this.defaultPassword);

		this.changeListPage.get();
		this.changeListPage.waitForPageLoad();
		this.driver.switchTo().frame("canvas");

		Assert.assertEquals(this.changeListPage.getListSelectOptionCount().intValue(), 3,
				"Select List dropdown should have 3 options.");
		Assert.assertEquals(this.changeListPage.getListSelectOption(0), "Select A List",
				"First Select List dropdown option should be 'Select A List'.");
		Assert.assertEquals(this.changeListPage.getListSelectOption(1), defaultList,
				"Second Select List dropdown option should be '" + defaultList + "'.");
		Assert.assertEquals(this.changeListPage.getListSelectOption(2), otherList,
				"Third Select List dropdown option should be '" + otherList + "'.");

		this.driver.switchTo().defaultContent(); // leave canvas iFrame

		Assert.assertTrue(this.navigationBarPage.getListName().contains(defaultList),
				"User should be in '" + defaultList + "' by default.");

		this.changeList(otherList);

		this.homePage.get();
		this.homePage.waitForPageLoad();
		Assert.assertTrue(this.navigationBarPage.getListName().contains(otherList),
				"User should be in '" + otherList + "' after changing lists.");

		this.changeList(defaultList);

		this.homePage.get();
		this.homePage.waitForPageLoad();
		Assert.assertTrue(this.navigationBarPage.getListName().contains(defaultList),
				"User should be in '" + defaultList + "' after chnaging lists back to default.");

		this.logout();
	}

	public void changeList(String listName) {
		this.changeListPage.get();
		this.changeListPage.waitForPageLoad();
		this.driver.switchTo().frame("canvas");
		this.changeListPage.selectList(listName);
		this.changeListPage.clickChangeListButton();
		this.driver.switchTo().defaultContent();
	}
}
