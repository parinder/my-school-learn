package com.myschool.learn.gms.tests.access;

import com.myschool.learn.gms.pages.addressbook.FiltersHomePage;
import com.myschool.learn.gms.pages.addressbook.FiltersListPage;
import com.myschool.learn.gms.pages.addressbook.NavigationBarPage;
import com.myschool.learn.gms.pages.emailcenter.HeaderPage;
import com.myschool.learn.gms.pages.emailcenter.ScheduledEmailsTabPage;
import com.myschool.learn.gms.pages.formscenter.surveylist.ListOfSurveysTabPage;
import com.myschool.learn.gms.pages.pmscenter.PmsRequestPage;
import com.myschool.learn.gms.pages.profiles.ProfilesPage;
import com.myschool.learn.gms.tests.BaseFunctionalTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccessTest extends BaseFunctionalTest {
	protected NavigationBarPage addressBookNavigationBarPage;
	protected FiltersHomePage filtersHomePage;
	protected FiltersListPage filtersListPage;
	protected ProfilesPage profilesPage;
	protected PmsRequestPage pmsCenterPmsRequestPage;
	protected ScheduledEmailsTabPage scheduledEmailsTabPage;
	protected HeaderPage headerPage;
	protected ListOfSurveysTabPage listOfSurveysTabPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.addressBookNavigationBarPage = new NavigationBarPage(this.driver, this.config);
		this.filtersHomePage = new FiltersHomePage(this.driver, this.config);
		this.filtersListPage = new FiltersListPage(this.driver, this.config);
		this.profilesPage = new ProfilesPage(this.driver, this.config);
		this.scheduledEmailsTabPage = new ScheduledEmailsTabPage(this.driver, this.config);
		this.headerPage = new HeaderPage(this.driver, this.config);
		this.listOfSurveysTabPage = new ListOfSurveysTabPage(this.driver, this.config);
		this.pmsCenterPmsRequestPage = new PmsRequestPage(this.driver, this.config);
	}

	@Test(description = "Test Address Book module access.")
	public void testAccessToAddressBook() {
		this.login("qaautomated.addressbook-access", this.defaultPassword);
		Assert.assertTrue(this.homePage.addressBookImageLinkIsVisible(),
				"Address Book module link image should be visible.");
		Assert.assertFalse(this.homePage.emailCenterImageLinkIsVisible(),
				"Email Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.formsCenterImageLinkIsVisible(),
				"Forms Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.reportsImageLinkIsVisible(),
				"Reports module link image should not be visible.");
		Assert.assertFalse(this.homePage.pmsImageLinkIsVisible(), "PMS module link image should not be visible.");
		Assert.assertFalse(this.homePage.workflowImageLinkIsVisible(),
				"Workflow module link image should not be visible.");
		this.logout();
	}

	@Test(description = "Test Email Center module access.")
	public void testAccessToEmailCenter() {
		this.login("qaautomated.emailcenter-access", this.defaultPassword);
		Assert.assertFalse(this.homePage.addressBookImageLinkIsVisible(),
				"Address Book module link image should not be visible.");
		Assert.assertTrue(this.homePage.emailCenterImageLinkIsVisible(),
				"Email Center module link image should be visible.");
		Assert.assertFalse(this.homePage.formsCenterImageLinkIsVisible(),
				"Forms Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.reportsImageLinkIsVisible(),
				"Reports module link image should not be visible.");
		Assert.assertFalse(this.homePage.pmsImageLinkIsVisible(), "PMS module link image should not be visible.");
		Assert.assertFalse(this.homePage.workflowImageLinkIsVisible(),
				"Workflow module link image should not be visible.");
		this.logout();
	}

	@Test(description = "Test Forms Center Book module access.")
	public void testAccessToFormsCenter() {
		this.login("qaautomated.formscenter-access", this.defaultPassword);
		Assert.assertFalse(this.homePage.addressBookImageLinkIsVisible(),
				"Address Book module link image should not be visible.");
		Assert.assertFalse(this.homePage.emailCenterImageLinkIsVisible(),
				"Email Center module link image should not be visible.");
		Assert.assertTrue(this.homePage.formsCenterImageLinkIsVisible(),
				"Forms Center module link image should be visible.");
		Assert.assertFalse(this.homePage.reportsImageLinkIsVisible(),
				"Reports module link image should not be visible.");
		Assert.assertFalse(this.homePage.pmsImageLinkIsVisible(), "PMS module link image should not be visible.");
		Assert.assertFalse(this.homePage.workflowImageLinkIsVisible(),
				"Workflow module link image should not be visible.");
		this.logout();
	}

	@Test(description = "Test PMS module access.")
	public void testAccessToPms() {
		this.login("qaautomated.pms-access", this.defaultPassword);
		Assert.assertFalse(this.homePage.addressBookImageLinkIsVisible(),
				"Address Book module link image should not be visible.");
		Assert.assertFalse(this.homePage.emailCenterImageLinkIsVisible(),
				"Email Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.formsCenterImageLinkIsVisible(),
				"Forms Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.reportsImageLinkIsVisible(),
				"Reports module link image should not be visible.");
		Assert.assertTrue(this.homePage.pmsImageLinkIsVisible(), "PMS module link image should be visible.");
		Assert.assertFalse(this.homePage.workflowImageLinkIsVisible(),
				"Workflow module link image should not be visible.");
		this.logout();
	}

	@Test(description = "Test Reports module access.")
	public void testAccessToReports() {
		this.login("qaautomated.reports-access", this.defaultPassword);
		Assert.assertFalse(this.homePage.addressBookImageLinkIsVisible(),
				"Address Book module link image should not be visible.");
		Assert.assertFalse(this.homePage.emailCenterImageLinkIsVisible(),
				"Email Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.formsCenterImageLinkIsVisible(),
				"Forms Center module link image should not be visible.");
		Assert.assertTrue(this.homePage.reportsImageLinkIsVisible(), "Reports module link image should be visible.");
		Assert.assertFalse(this.homePage.pmsImageLinkIsVisible(), "PMS module link image should not be visible.");
		Assert.assertFalse(this.homePage.workflowImageLinkIsVisible(),
				"Workflow module link image should not be visible.");
		this.logout();
	}

	@Test(description = "Test WorkFlow module access.")
	public void testAccessToWorkflow() {
		this.login("qaautomated.workflow-access", this.defaultPassword);
		Assert.assertFalse(this.homePage.addressBookImageLinkIsVisible(),
				"Address Book module link image should not be visible.");
		Assert.assertFalse(this.homePage.emailCenterImageLinkIsVisible(),
				"Email Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.formsCenterImageLinkIsVisible(),
				"Forms Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.reportsImageLinkIsVisible(),
				"Reports module link image should not be visible.");
		Assert.assertFalse(this.homePage.pmsImageLinkIsVisible(), "PMS module link image should not be visible.");
		Assert.assertTrue(this.homePage.workflowImageLinkIsVisible(), "Workflow module link image should be visible.");
		this.logout();
	}

	@Test(description = "Test no module access.")
	public void testNoModuleAccess() {
		this.login("qaautomated.no-module-access", this.defaultPassword);
		Assert.assertFalse(this.homePage.addressBookImageLinkIsVisible(),
				"Address Book module link image should not be visible.");
		Assert.assertFalse(this.homePage.emailCenterImageLinkIsVisible(),
				"Email Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.formsCenterImageLinkIsVisible(),
				"Forms Center module link image should not be visible.");
		Assert.assertFalse(this.homePage.reportsImageLinkIsVisible(),
				"Reports module link image should not be visible.");
		Assert.assertFalse(this.homePage.pmsImageLinkIsVisible(), "PMS module link image should not be visible.");
		Assert.assertFalse(this.homePage.workflowImageLinkIsVisible(),
				"Workflow module link image should not be visible.");
		this.logout();
	}

	@Test(description = "Test RezQueue module access.")
	public void testRezQueueAccess() {
		this.rezqueueLogin("qaautomated.rezqueue-access", this.defaultPassword);
		this.rezqueueHomePage.waitForPageLoad();
		this.rezqueueHomePage.clickGotoGmsButton(); // back to GMS so that logout takes you to GMS homepage
		this.homePage.waitForPageLoad();
		this.logout();
	}

	@Test(description = "Test no RezQueue module access.")
	public void testNoRezQueueAccess() {
		// Defect DE50130 requires a successsful login to get language cookie 
		this.rezqueueLogin(this.defaultUsername, this.defaultPassword);
		this.rezQueueLogout();
		// the above login will be unecessary once the defect is fixed
		this.rezQueueLoginExpectingError("qaautomated.no-module-access", this.defaultPassword,
				"RezQueue is not set up for that hotel or user.");
	}

	@Test(description = "Test no RezQueue LOP setup access (user has Rezque enabled in their role, but no LOP configured).")
	public void testNoRezQueueLopSetupAccess() {
		// Defect DE50130 requires a successsful login to get language cookie 
		this.rezqueueLogin(this.defaultUsername, this.defaultPassword);
		this.rezQueueLogout();
		// the above login will be unecessary once the defect is fixed
		this.rezQueueLoginExpectingError("qaautomated.no-rezqueue-lop-setup", this.defaultPassword,
				"RezQueue is not set up for that hotel or user.");
	}

	@Test(description = "Test unlimited 'Test Campaign Folder' access.")
	public void testUnlimitedTestCampaignFolderAccess() {
		String testUsername = "qaautomated.emailcenter-access";
		String testFolderName = "Test Campaign Folder";

		this.login(testUsername, this.defaultPassword);

		this.scheduledEmailsTabPage.get();
		this.scheduledEmailsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("canvas");
		this.driver.switchTo().frame("pushFrame");

		Assert.assertTrue(this.scheduledEmailsTabPage.getFolderTableRowContents(1).contains(testFolderName),
				"Second folder should be '" + testFolderName + "'.");
	}

	@Test(description = "Test limited 'Test Campaign Folder' access.")
	public void testLimitedTestCampaignFolderAccess() {
		String testUsername = "qaautomated.test-campaign-folder-access";
		String testFolderName = "Test Campaign Folder";

		this.login(testUsername, this.defaultPassword);

		this.scheduledEmailsTabPage.get();
		this.scheduledEmailsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("canvas");
		this.driver.switchTo().frame("pushFrame");

		Assert.assertTrue(this.scheduledEmailsTabPage.getFolderTableRowContents(1).contains(testFolderName),
				"Second folder should be '" + testFolderName + "'.");
	}

	@Test(description = "Test limited 'Test Campaign Folder' no access.")
	public void testNoLimitedListCampaignNoAccess() {
		String testUsername = "qaautomated.test-campaign-no-access";
		String testFolderName = "Test Campaign Folder";

		this.login(testUsername, this.defaultPassword);

		this.scheduledEmailsTabPage.get();
		this.scheduledEmailsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("canvas");
		this.driver.switchTo().frame("pushFrame");

		Assert.assertFalse(this.scheduledEmailsTabPage.getFolderTableRowContents(1).contains(testFolderName),
				"Folder " + testFolderName + " should not be visible.");
	}

	@Test(description = "Test 'Languages : English' filter access.")
	public void testLimitedListFilterAccess() {
		String testUsername = "qaautomated.filter-access";
		String filterName = "Languages : English";

		this.login(testUsername, this.defaultPassword);

		this.filtersHomePage.get();
		this.filtersListPage.waitForPageLoad();
		this.filtersListPage.enterFiltersSearchInput(filterName);

		Assert.assertTrue(this.filtersListPage.getListOfFiltersTableRowContents(0).contains(filterName),
				"Filter Name " + filterName + " should be displayed");
	}

	@Test(description = "Test 'Languages : English' filter no access.")
	public void testLimitedListFilterNoAccess() {
		String testUsername = "qaautomated.no-filter-access";
		String testFilterName = "Languages : English";

		this.login(testUsername, this.defaultPassword);

		this.filtersHomePage.get();
		this.filtersListPage.waitForPageLoad();
		this.filtersListPage.enterFiltersSearchInput(testFilterName);

		Assert.assertTrue(this.filtersListPage.noRecordsTableItemIsVisible(),
				"No records should be visible after searching for " + testFilterName + ".");
	}

}