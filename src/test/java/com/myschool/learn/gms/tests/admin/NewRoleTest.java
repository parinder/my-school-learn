package com.myschool.learn.gms.tests.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myschool.learn.gms.helpers.RandomDataHelper;
import com.myschool.learn.gms.pages.admin.ManageUsersPage;
import com.myschool.learn.gms.pages.rezqueue.RezqueueHomePage;
import com.myschool.learn.gms.pages.rezqueue.RezqueueLoginPage;

public class NewRoleTest extends BaseAdminTest {
	protected RandomDataHelper randomDataHelper;
	protected ManageUsersPage manageUsersPage;
	protected RezqueueLoginPage rezqueueLoginPage;
	protected RezqueueHomePage rezqueueHomePage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.randomDataHelper = new RandomDataHelper();
		this.manageUsersPage = new ManageUsersPage(this.driver, this.config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Verify new role modal opens and closes.")
	public void testNewRoleModal() {
		this.manageUsersPage.get();
		this.manageUsersPage.waitForPageLoad();

		this.manageUsersPage.clickNewRoleButton();
		this.manageUsersRoleModalPage.waitToBeVisible();

		Assert.assertEquals(this.manageUsersRoleModalPage.getheaderTitleText(), "New Role",
				"Title should be 'New Role'");

		this.manageUsersRoleModalPage.clickHeaderCloseButton();
		this.manageUsersRoleModalPage.waitToBeInvisible();
	}
}
