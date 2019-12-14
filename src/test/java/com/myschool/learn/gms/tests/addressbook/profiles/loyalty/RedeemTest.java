package com.myschool.learn.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import com.myschool.learn.gms.tests.addressbook.profiles.BaseProfilesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RedeemTest extends BaseProfilesTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test redeeming Points by All Properties Based Redeemable Item ")
	public void testRedeemPointsByRedeemableItemBasedOnAllProperty() {
		String profileEmail = "lilly.tamara@loyaltytab.com";
		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");
		this.loyaltyTabPage.goToRedeemSection();

		Assert.assertEquals(this.loyaltyTabPage.getRedeemItemsListHeaderText(), "AUTOMATION_TEST CATEGORY",
				"Redeem items list header should be 'AUTOMATION_TEST CATEGORY'.");
		Assert.assertEquals(this.loyaltyTabPage.getredeemItemsListRowsCount().intValue(), 2,
				"Redeemable items list should have 2 items.");
		Assert.assertEquals(this.loyaltyTabPage.getRedeemItemsListItemName(0), "AllProperty_RedeemItem [Default]",
				" Redeem item should be 'AllProperty_RedeemItem [Default]'.");
		Assert.assertEquals(this.loyaltyTabPage.getRedeemItemsListItemName(1), "PropertySpecific_RedeemItem [Default]",
				"Redeem item should be 'PropertySpecific_RedeemItem [Default]'.");

		this.loyaltyTabPage.clickRedeemItemsListRowsItemRedeemButton(0);
		this.loyaltyTabPage.waitForRedeemConfirmationModalToBeVisible();
		this.loyaltyTabPage.clickRedeemConfirmationModalCancelButton();
		this.loyaltyTabPage.waitForRedeemConfirmationModalToBeInvisible();

		String totalPointsHistoryEntriesString = this.loyaltyTabPage.getPointsHistoryTotalEntries();
		Integer totalPointsHistoryEntriesInt = Integer.parseInt(totalPointsHistoryEntriesString.replace(",", ""));
		String expectedTotalPointsHistoryEntries = NumberFormat.getInstance(Locale.US)
				.format(totalPointsHistoryEntriesInt + 1);

		this.loyaltyTabPage.goToRedeemSection();

		this.loyaltyTabPage.clickRedeemItemsListRowsItemRedeemButton(0);
		this.loyaltyTabPage.waitForRedeemConfirmationModalToBeVisible();
		this.loyaltyTabPage.clickRedeemConfirmationModalNextButton();

		this.loyaltyTabPage.enterRedeemConfirmationModalSpecialInstructions("Special Instructions Here.");
		this.loyaltyTabPage.selectRedeemConfirmationModalPortalDropDown("QATeam-AUTOMATEDTests(DONOTTOUCH)");
		this.loyaltyTabPage.selectRedeemConfirmationModalPropertyDropDown("Property 2");
		this.loyaltyTabPage.clickRedeemConfirmationModalRedeemButton();
		this.loyaltyTabPage.waitForRedeemConfirmationModalToBeInvisible();

		this.loyaltyTabPage.waitForPointsHistoryTotalEntriesToBe(expectedTotalPointsHistoryEntries);
		this.assertPointsHistoryTableRow(1, "-10", "Item Redemption", "AllProperty_RedeemItem [Default]", null,
				this.defaultUsername, "", "Property 2", "0", "0");
	}

	@Test(description = "Test redeeming Points by Specific Property Based Redeemable Item ")
	public void testRedeemPointsByRedeemableItemBasedOnSpecificProperty() {
		String profileEmail = "lilly.tamara@loyaltytab.com";

		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		String totalPointsHistoryEntriesString = this.loyaltyTabPage.getPointsHistoryTotalEntries();
		Integer totalPointsHistoryEntriesInt = Integer.parseInt(totalPointsHistoryEntriesString.replace(",", ""));
		String expectedTotalPointsHistoryEntries = NumberFormat.getInstance(Locale.US)
				.format(totalPointsHistoryEntriesInt + 1);
		this.loyaltyTabPage.goToRedeemSection();

		this.loyaltyTabPage.clickRedeemItemsListRowsItemRedeemButton(1);
		this.loyaltyTabPage.waitForRedeemConfirmationModalToBeVisible();
		this.loyaltyTabPage.clickRedeemConfirmationModalNextButton();

		this.loyaltyTabPage.enterRedeemConfirmationModalShippingAddress("1306 Wellington Street");
		this.loyaltyTabPage.enterRedeemConfirmationModalShippingAddress2("Floor 5th");
		this.loyaltyTabPage.enterRedeemConfirmationModalShippingCity("Ottawa");
		this.loyaltyTabPage.enterRedeemConfirmationModalShippingState("Ontario");
		this.loyaltyTabPage.enterRedeemConfirmationModalShippingZip("B3H4R4");
		this.loyaltyTabPage.enterRedeemConfirmationModalShippingCountry("Canada");
		this.loyaltyTabPage.enterRedeemConfirmationModalSpecialInstructions("Special Instructions Here.");
		this.loyaltyTabPage.selectRedeemConfirmationModalPortalDropDown("QATeam-AUTOMATEDTests(DONOTTOUCH)");

		this.loyaltyTabPage.clickRedeemConfirmationModalRedeemButton();
		this.loyaltyTabPage.waitForRedeemConfirmationModalToBeInvisible();

		this.loyaltyTabPage.waitForPointsHistoryTotalEntriesToBe(expectedTotalPointsHistoryEntries);

		this.assertPointsHistoryTableRow(1, "-15", "Item Redemption", "PropertySpecific_RedeemItem [Default]", null,
				this.defaultUsername, "", "Property 1", "0", "0");
	}
}