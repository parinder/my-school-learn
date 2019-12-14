package com.gms.tests.home;

import java.io.IOException;

import com.gms.pages.ReportsPage;
import com.gms.pages.WorkflowPage;
import com.gms.pages.addressbook.FiltersHomePage;
import com.gms.pages.addressbook.NavigationBarPage;
import com.gms.pages.emailcenter.HeaderPage;
import com.gms.pages.emailcenter.ScheduledEmailsTabPage;

import com.gms.pages.formscenter.surveylist.ListOfSurveysTabPage;
import com.gms.pages.pmscenter.PmsRequestPage;
import com.gms.pages.profiles.ProfilesPage;
import com.gms.pages.rezqueue.RezqueueHomePage;
import com.gms.tests.BaseFunctionalTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SectionLinkTest extends BaseFunctionalTest {
	protected NavigationBarPage addressBookNavigationBarPage;
	protected FiltersHomePage filtersHomePage;
	protected ProfilesPage profilesPage;
	protected PmsRequestPage pmsCenterPmsRequestPage;
	protected ScheduledEmailsTabPage scheduledEmailsTabPage;
	protected HeaderPage headerPage;
	protected ListOfSurveysTabPage listOfSurveysTabPage;
	protected ReportsPage reportsPage;
	protected WorkflowPage workflowPage;
	protected RezqueueHomePage rezqueueHomePage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.addressBookNavigationBarPage = new NavigationBarPage(this.driver, config);
		this.filtersHomePage = new FiltersHomePage(this.driver, config);
		this.profilesPage = new ProfilesPage(this.driver, config);
		this.scheduledEmailsTabPage = new ScheduledEmailsTabPage(this.driver, config);
		this.headerPage = new HeaderPage(this.driver, config);
		this.listOfSurveysTabPage = new ListOfSurveysTabPage(this.driver, config);
		this.pmsCenterPmsRequestPage = new PmsRequestPage(this.driver, config);
		this.reportsPage = new ReportsPage(this.driver, config);
		this.workflowPage = new WorkflowPage(this.driver, config);
		this.rezqueueHomePage = new RezqueueHomePage(this.driver, config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test navigation to 'Address book' via homepage image link.")
	public void testNavigationToAddressBook() {
		this.homePage.get();
		this.homePage.clickAddressBookImageLink();
		this.addressBookNavigationBarPage.waitForPageLoad();
		this.filtersHomePage.waitForPageLoad();
		this.navigationBarPage.waitForPageLoad();
		this.assertCommonNavigationBarItems();
		Assert.assertTrue(this.navigationBarPage.fileMenuItemIsVisible(), "'File' menu item should be visible.");
	}

	@Test(description = "Test navigation to 'Email center' via homepage image link.")
	public void testNavigationToEmailCenter() {
		this.homePage.get();
		this.homePage.clickEmailCenterImageLink();
		this.headerPage.waitForPageLoad();
		this.navigationBarPage.waitForPageLoad();
		this.assertCommonNavigationBarItems();
		Assert.assertTrue(this.navigationBarPage.campaignMenuItemIsVisible(),
				"'Campaign' menu item should be visible.");
		Assert.assertTrue(this.navigationBarPage.createEmailMenuItemIsVisible(),
				"'Create Email' menu item should be visible.");
		Assert.assertTrue(this.navigationBarPage.librariesMenuItemIsVisible(),
				"'Libraries' menu item should be visible.");
		Assert.assertTrue(this.navigationBarPage.preferencesMenuItemIsVisible(),
				"'Preferences' menu item should be visible.");
	}

	@Test(description = "Test navigation to Forms center via homepage image link.")
	public void testNavigationToFormsCenter() {
		this.homePage.get();
		this.homePage.clickFormsCenterImageLink();
		this.listOfSurveysTabPage.waitForPageLoad();
		this.navigationBarPage.waitForPageLoad();
		this.assertCommonNavigationBarItems();
		Assert.assertTrue(this.navigationBarPage.fileMenuItemIsVisible(), "'File' menu item should be visible.");
	}

	@Test(description = "Test navigation to Reports via homepage image link.")
	public void testNavigationToReports() {
		this.homePage.get();
		this.homePage.clickReportsImageLink();
		this.reportsPage.waitForPageLoad();
		this.navigationBarPage.waitForPageLoad();
		this.assertCommonNavigationBarItems();
		Assert.assertTrue(this.navigationBarPage.reportsMenuItemIsVisible(),
				"Reports menu item should be visible on Reports page.");
	}

	@Test(description = "Test navigation to PMS via homepage image link.")
	public void testNavigationToPms() {
		this.homePage.get();
		this.homePage.clickPmsImageLink();
		this.pmsCenterPmsRequestPage.waitForPageLoad();
		this.navigationBarPage.waitForPageLoad();
		this.assertCommonNavigationBarItems();
		Assert.assertTrue(this.navigationBarPage.fileMenuItemIsVisible(), "'File' menu item should be visible.");
	}

	@Test(description = "Test navigation to Workflow via homepage image link.")
	public void testNavigationToWorkflow() {
		this.homePage.get();
		this.homePage.clickWorkflowImageLink();
		this.workflowPage.waitForPageLoad();
		this.navigationBarPage.waitForPageLoad();
		this.assertCommonNavigationBarItems();
		Assert.assertTrue(this.navigationBarPage.fileMenuItemIsVisible(), "'File' menu nitem should be visible.");
	}

	@Test(description = "Test navigation to RezQueue via homepage button.")
	public void verifyNavigationToRezQueue() {
		this.homePage.get();
		this.homePage.clickGotoRezqueueButton();
		this.rezqueueHomePage.waitForPageLoad();
		this.navigationBarPage.waitForRezQueuePageLoad();
		this.assertRezQueueCommonNavigationBarItems();
	}

	public void assertCommonNavigationBarItems() {
		Assert.assertTrue(this.navigationBarPage.homeMenuItemIsVisible(), "'Home' menu item should be visible.");
		Assert.assertTrue(this.navigationBarPage.sectionsMenuItemIsVisible(),
				"'Sections' menu item should be visible.");
		Assert.assertTrue(this.navigationBarPage.adminMenuItemIsVisible(), "'Admin' menu item should be visible.");
		Assert.assertTrue(this.navigationBarPage.logoutMenuItemIsVisible(), "'Logout' menu item should be visible.");
	}

	public void assertRezQueueCommonNavigationBarItems() {
		Assert.assertTrue(this.navigationBarPage.sectionsMenuItemIsVisible(),
				"'Sections' menu item should be visible.");
		Assert.assertTrue(this.navigationBarPage.logoutMenuItemIsVisible(), "'Logout' menu item should be visible.");
	}
}