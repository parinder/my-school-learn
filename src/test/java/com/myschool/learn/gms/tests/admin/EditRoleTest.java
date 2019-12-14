package com.myschool.learn.gms.tests.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.myschool.learn.gms.pages.admin.ManageUsersPage;

public class EditRoleTest extends BaseAdminTest {
	protected ManageUsersPage manageUsersPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.manageUsersPage = new ManageUsersPage(this.driver, this.config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test edit role modal.")
	public void testEditRoleModal() {
		String role = "All Modules Access Role";

		this.manageUsersPage.get();
		this.manageUsersPage.waitForPageLoad();

		this.manageUsersPage.enterRolesSearchInput(role);
		this.manageUsersPage.clickRolesTableItemEditLink(0);
		this.manageUsersRoleModalPage.waitToBeVisible();

		Assert.assertEquals(this.manageUsersRoleModalPage.getheaderTitleText(), "Edit " + role,
				"Title should be 'Edit " + role + "");

		this.manageUsersRoleModalPage.clickHeaderCloseButton();
		this.manageUsersRoleModalPage.waitToBeInvisible();
	}

	@Test(description = "Test edit role Address Book access.")
	public void testEditAddressBookAccess() {
		this.editRoleEnableModuleAccess("Test Editing Access Role", "addressBook"); // adds addressbook access
		this.editRoleDisableModuleAccess("Test Editing Access Role", "addressBook"); // removes address book access
	}

	@Test(description = "Test edit role Email Center access.")
	public void testEditEmailCenterAccess() {
		this.editRoleEnableModuleAccess("Test Editing Access Role", "emailCenter");
		this.editRoleDisableModuleAccess("Test Editing Access Role", "emailCenter");
	}

	@Test(description = "Test edit role Forms Center access.")
	public void testEditFormsCenterAccess() {
		this.editRoleEnableModuleAccess("Test Editing Access Role", "formsCenter");
		this.editRoleDisableModuleAccess("Test Editing Access Role", "formsCenter");
	}

	@Test(description = "Test edit role Reports access.")
	public void testEditReportsModuleAccess() {
		this.editRoleEnableModuleAccess("Test Editing Access Role", "reports"); // adds
		this.editRoleDisableModuleAccess("Test Editing Access Role", "reports"); // removes
	}

	@Test(description = "Test edit role PMS access.")
	public void testEditPmsModuleAccess() {
		this.editRoleEnableModuleAccess("Test Editing Access Role", "pms");
		this.editRoleDisableModuleAccess("Test Editing Access Role", "pms");
	}

	@Test(description = "Test edit role Workflow access.")
	public void testEditWorkflowModuleAccess() {
		this.editRoleEnableModuleAccess("Test Editing Access Role", "workflow");
		this.editRoleDisableModuleAccess("Test Editing Access Role", "workflow");
	}

	@Test(description = "Test edit role rezQueue access.")
	public void testEditRezqueueAccess() {
		String testRoleName = "Test Editing Access Role";
		String testUsername = "qaautomated.edit-access-role-user";

		this.editRoleEnableModuleAccess(testRoleName, "rezqueue");
		this.editUserRezQueueEnableListOwnerPms(testUsername, "IH1134");

		this.editUserRezQueueDisableListOwnerPms(testUsername, "IH1134"); // return to initial state
		this.editRoleDisableModuleAccess(testRoleName, "rezqueue"); // return to initial state
	}

	@Test(enabled = false, description = "Test edit role for limited list access for campaign section.")
	public void testEditRoleAssignCampaignSectionLimitedListAccess() {
		// DEFECT: Test disabled due to bug casuing fragility
		// - role search matches any words instead of exact string match
		// - role list access section sometimes yields no results

		String testRoleName = "Campaign Edit Access Role";
		String folderName = "Test Campaign Folder";

		this.editRoleListAccessLimitedEnableCampaign(testRoleName, folderName);

		this.editRoleListAccessLimitedDisableCampaign(testRoleName, folderName); // return to initial state
	}

	@Test(enabled = false, description = "Test edit role for limited list access for filter section.")
	public void testEditRoleAssignFilterSectionLimitedListAccess() {
		// DEFECT: Test disabled due to bug casuing fragility (same as above)
		// - role search matches any words instead of exact string match
		// - role list access section sometimes yields no results

		String testRoleName = "xxx Filter Edit Access Role";
		String testFilterName = "Languages : English";

		this.editRoleListAccessLimitedEnableFilter(testRoleName, testFilterName);

		this.editRoleListAccessLimitedDisableFilter(testRoleName, testFilterName); // return to initial state

	}
}
