package com.gms.tests.admin;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gms.pages.admin.ChangeListPage;
import com.gms.pages.admin.ManageUsersPage;
import com.gms.pages.rezqueue.RezqueueHomePage;
import com.gms.pages.rezqueue.RezqueueLoginPage;

public class EditUserTest extends BaseAdminTest {
	protected ManageUsersPage manageUsersPage;
	protected RezqueueLoginPage rezqueueLoginPage;
	protected RezqueueHomePage rezqueueHomePage;
	protected ChangeListPage changeListPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.manageUsersPage = new ManageUsersPage(this.driver, this.config);
		this.rezqueueLoginPage = new RezqueueLoginPage(this.driver, this.config);
		this.rezqueueHomePage = new RezqueueHomePage(this.driver, this.config);
		this.changeListPage = new ChangeListPage(this.driver, this.config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test editing user role.")
	public void testEditUserRole() {
		String testUsername = "qaautomated.edit-role-user";
		this.editUserSelectRole(testUsername, "All Properties Admin");
		this.editUserSelectRole(testUsername, "No Modules Access Role");
	}

	@Test(description = "Test editing user rezQueue LOP.")
	public void testEditUserRezqueueAccessViaLopConfiguration() {
		String testUsername = "qaautomated.rezqueue-edit-user";
		String testLop = "IH1128";
		this.editUserRezQueueEnableListOwnerPms(testUsername, testLop);
		this.editUserRezQueueDisableListOwnerPms(testUsername, testLop);
	}
}
