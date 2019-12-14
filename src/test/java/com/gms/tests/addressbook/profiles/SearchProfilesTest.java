package com.gms.tests.addressbook.profiles;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchProfilesTest extends BaseProfilesTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test profile search naviagtion.")
	public void testSearchNavigation() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		// profile search is open by default
		this.profilesPage.waitForProfileSearchSectionToBeOpen();

		// profile search advanced options is closed by default
		this.profilesPage.waitForProfileSearchAdvancedOptionsSectionToBeClosed();

		// show advanced options
		this.profilesPage.clickAdvancedOptionsLink();
		this.profilesPage.waitForProfileSearchAdvancedOptionsSectionToBeOpen();

		// hide advanced options
		this.profilesPage.clickHideAdvancedOptionsLink();
		this.profilesPage.waitForProfileSearchAdvancedOptionsSectionToBeClosed();

		// click profile to close the profile section
		this.profilesPage.clickProfileSearchExpandMenu();
		this.profilesPage.waitForProfileSearchSectionToBeClosed();
		this.profilesPage.waitForLoyaltySearchSectionToBeClosed();
		this.profilesPage.waitForCommentSearchSectionToBeClosed();
		this.profilesPage.waitForReservationSearchSectionToBeClosed();

		// click profile and to open profile section
		this.profilesPage.clickProfileSearchExpandMenu();
		this.profilesPage.waitForProfileSearchSectionToBeOpen();
		this.profilesPage.waitForLoyaltySearchSectionToBeClosed();
		this.profilesPage.waitForCommentSearchSectionToBeClosed();
		this.profilesPage.waitForReservationSearchSectionToBeClosed();

		// click loyalty to open loyalty section
		this.profilesPage.clickLoyaltySearchExpandMenu();
		this.profilesPage.waitForProfileSearchSectionToBeClosed();
		this.profilesPage.waitForLoyaltySearchSectionToBeOpen();
		this.profilesPage.waitForCommentSearchSectionToBeClosed();
		this.profilesPage.waitForReservationSearchSectionToBeClosed();

		// click comment and to open comment section
		this.profilesPage.clickCommentSearchExpandMenuMenu();
		this.profilesPage.waitForProfileSearchSectionToBeClosed();
		this.profilesPage.waitForLoyaltySearchSectionToBeClosed();
		this.profilesPage.waitForCommentSearchSectionToBeOpen();
		this.profilesPage.waitForReservationSearchSectionToBeClosed();

		// click reservation to open reservation section
		this.profilesPage.clickReservationsSearchExpandMenu();
		this.profilesPage.waitForProfileSearchSectionToBeClosed();
		this.profilesPage.waitForLoyaltySearchSectionToBeClosed();
		this.profilesPage.waitForCommentSearchSectionToBeClosed();
		this.profilesPage.waitForReservationSearchSectionToBeOpen();
	}

	@Test(description = "Test profile search by email no results.")
	public void testSearchByEmailNoResults() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		// search by invalid email
		this.profilesPage.enterProfileSearchEmail("noresultingprofile@noresult.com");
		this.profilesPage.clickProfileSearchButton();

		// assert no profiles foudn result appears
		Assert.assertEquals(this.profilesPage.getProfileSearchResultTableRowCount().intValue(), 1,
				"Should have 1 search result.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("No profiles found"),
				"Should have no profiles found.");
	}

	@Test(description = "Test profile search by email.")
	public void testSearchByEmailWithResults() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		this.profilesPage.enterProfileSearchEmail("searchy.onesington@example.com");
		this.profilesPage.clickProfileSearchButton();

		Assert.assertEquals(this.profilesPage.getProfileSearchResultTableRowCount().intValue(), 1,
				"Should have 1 search result.");

		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("Searchy Onesington"),
				"Search results should have 'Searchy Onesington'.");
		Assert.assertTrue(
				this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("searchy.onesington@example.com"),
				"Search results should have 'searchy.onesington@example.com'.");

		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");

		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy Onesington"), "");
		Assert.assertTrue(this.headerPage.getMainProfileInformation().contains("searchy.onesington@example.com"),
				"Profile Email does not contain 'searchy.onesington@example.com'");
	}

	@Test(description = "Test profile search by name no results.")
	public void testSearchByNameNoResults() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		this.profilesPage.enterProfileSearchFirstName("noresultsfirstname");
		this.profilesPage.clickProfileSearchButton();

		Assert.assertEquals(this.profilesPage.getProfileSearchResultTableRowCount().intValue(), 1,
				"Should have 1 search result.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("No profiles found"),
				"Should have no profiles found.");
	}

	@Test(description = "Test profile search by name.")
	public void testSearchByNameWithResults() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		this.profilesPage.enterProfileSearchFirstName("Searchy");
		this.profilesPage.clickProfileSearchButton();

		Assert.assertEquals(this.profilesPage.getProfileSearchResultTableRowCount().intValue(), 4,
				"Should have 4 search results.");

		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("Searchy"),
				"Search results should contain 'Searchy'.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(1).contains("Searchy"),
				"Search results should contain 'Searchy'.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(2).contains("Searchy"),
				"Search results should contain 'Searchy'.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(3).contains("Searchy"),
				"Search results should contain 'Searchy'.");

		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");

		this.profilesPage.clickProfileSearchResultTableRow(0);
		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");
		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy"),
				"Profile full name does not contain 'Searchy'");

		this.profilesPage.clickProfileSearchResultTableRow(1);
		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");
		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy"),
				"Profile full name does not contain 'Searchy'");

		this.profilesPage.clickProfileSearchResultTableRow(2);
		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");
		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy"),
				"Profile full name does not contain 'Searchy'");

		this.profilesPage.clickProfileSearchResultTableRow(3);
		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");
		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy"),
				"Profile full name does not contain 'Searchy'");
	}

	@Test(description = "Test profile search by member number.")
	public void testLoyaltySearchByMemberNumber() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		this.profilesPage.clickLoyaltySearchExpandMenu();

		this.profilesPage.enterLoyaltySearchMemberNumber("searchy.twosington@example.com");
		this.profilesPage.selectAndEnterProgram("Guest Portal");
		this.profilesPage.clickLoyaltySearchButton();

		Assert.assertEquals(this.profilesPage.getProfileSearchResultTableRowCount().intValue(), 1,
				"Should have 1 search result.");

		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("Searchy Twosington"),
				"Search results should contain 'Searchy Twosington'.");
		Assert.assertTrue(
				this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("searchy.twosington@example.com"),
				"Search results should contain 'searchy.twosington@example.com'.");

		this.loyaltyTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileLoyaltyTabIsSelected(), "Loyalty tab should be selected by default.");

		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy Twosington"),
				"Profile full name does not contain 'Searchy Twosington'");
		Assert.assertTrue(this.headerPage.getMainProfileInformation().contains("searchy.twosington@example.com"),
				"Profile Email does not contain 'searchy.twosington@example.com'");
	}

	@Test(description = "Test profile search by comment.")
	public void testSearchByComment() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		this.profilesPage.clickCommentSearchExpandMenuMenu();
		this.profilesPage.waitForCommentSearchSectionToBeOpen();

		this.profilesPage.enterCommentSearchComment("My email is searchy.threesington@example.com.");
		this.profilesPage.clickCommentSearchButton();

		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");

		Assert.assertEquals(this.profilesPage.getProfileSearchResultTableRowCount().intValue(), 5,
				"Should have 5 search results.");

		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("Searchy Threesington"),
				"Search results should contain 'Searchy Threesington'.");
		Assert.assertTrue(
				this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("Enter Free Form Comment"),
				"Search results should contain 'Enter Free Form Comment'.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("My email is"),
				"Search results should contain 'My email is'.");
		// assume 1-3 are all the same
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(4).contains("Searchy Threesington"),
				"Search results should contain 'Searchy Threesington'.");
		Assert.assertTrue(
				this.profilesPage.getProfileSearchResultsTableRowContents(4).contains("Enter Free Form Comment"),
				"Search results should contain 'Enter Free Form Comment'.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(4).contains("My email is"),
				"Search results should contain 'My email is'.");

		this.profilesPage.clickProfileSearchResultTableRow(0);
		this.overviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileOverviewTabIsSelected(),
				"Overview tab should be selected by default.");

		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy Threesington"),
				"Profile full name does not contain 'Searchy Threesington'");
		Assert.assertTrue(this.headerPage.getMainProfileInformation().contains("searchy.threesington@example.com"),
				"Profile Email does not contain 'searchy.threesington@example.com'");
	}

	@Test(description = "Test profile search by reservation number.")
	public void testSearchByReservationNumber() {
		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();

		this.profilesPage.clickReservationsSearchExpandMenu();

		this.profilesPage.enterReservationSearchReservationNumber("5120324");
		this.profilesPage.clickReservationSearchButton();

		this.reservationsTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileReservationsTabIsSelected(),
				"Reservations tab should be selected by default.");

		Assert.assertEquals(this.profilesPage.getProfileSearchResultTableRowCount().intValue(), 1,
				"Should have 1 search result.");

		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("Searchy Threesington"),
				"Search results should contain 'Searchy Threesington'.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("#5120324"),
				"Search results should contain '#5120324'.");
		Assert.assertTrue(this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("Property 3"),
				"Search results should contain 'Property 3'.");
		Assert.assertTrue(
				this.profilesPage.getProfileSearchResultsTableRowContents(0).contains("2019-06-19 to 2019-06-24"),
				"Search results should contain '2019-06-19 to 2019-06-24'.");

		this.profilesPage.clickProfileSearchResultTableRow(0);
		this.reservationsTabPage.waitForPageLoad();
		Assert.assertTrue(this.headerPage.profileReservationsTabIsSelected(),
				"Reservations tab should be selected by default.");

		Assert.assertTrue(this.headerPage.getMainProfileFullName().contains("Searchy Threesington"),
				"Profile full name does not contain 'Searchy Threesington'");
		Assert.assertTrue(this.headerPage.getMainProfileInformation().contains("searchy.threesington@example.com"),
				"Profile Email does not contain 'searchy.threesington@example.com'");
	}
}