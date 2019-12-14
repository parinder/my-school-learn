package com.gms.tests.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gms.helpers.RandomDataHelper;
import com.gms.pages.admin.ManageUsersPage;
import com.gms.pages.rezqueue.RezqueueHomePage;
import com.gms.pages.rezqueue.RezqueueLoginPage;

public class NewUserTest extends BaseAdminTest {
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

	@Test(description = "Verify new user modal opens.")
	public void testNewUserModal() {
		this.manageUsersPage.get();
		this.manageUsersPage.waitForPageLoad();

		this.manageUsersPage.clickNewUserButton();
		this.manageUsersUserModalPage.waitToBeVisible();

		Assert.assertEquals(this.manageUsersUserModalPage.getheaderTitleText(), "New User",
				"Title should be 'New User'");
	}

	@Test(description = "Verify creation of new all properties user.")
	public void testCreateAllPropertiesUser() {
		String newFirstName = this.randomDataHelper.getRandomFirstName();
		String newLastName = this.randomDataHelper.getRandomLastName();
		String newUserName = this.randomDataHelper.getRandomUsername(newFirstName, newLastName);
		String newEmailAddress = this.randomDataHelper.getEmailAddress(newUserName);
		this.createNewUser(newUserName, this.defaultPassword, newEmailAddress, newFirstName, newLastName, "m", "en",
				"All Properties Admin");
		this.deleteUser(newUserName);
	}

	@Test(description = "Verify creation of new specific property user.")
	public void testCreateSpecificPropertyUser() {
		String newFirstName = this.randomDataHelper.getRandomFirstName();
		String newLastName = this.randomDataHelper.getRandomLastName();
		String newUserName = this.randomDataHelper.getRandomUsername(newFirstName, newLastName);
		String newEmailAddress = this.randomDataHelper.getEmailAddress(newUserName);
		this.createNewUser(newUserName, this.defaultPassword, newEmailAddress, newFirstName, newLastName, "m", "en",
				"Specific Property Role");
		this.deleteUser(newUserName);
	}

}
