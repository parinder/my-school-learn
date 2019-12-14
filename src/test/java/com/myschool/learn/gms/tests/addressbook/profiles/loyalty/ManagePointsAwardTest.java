package com.myschool.learn.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;

import com.myschool.learn.gms.tests.addressbook.profiles.BaseProfilesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManagePointsAwardTest extends BaseProfilesTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test awarding points via Manual Points Change.")
	public void testAwardPointsByManualPointChange() {
		String profileEmail = "Aelu.lollies.p0@example.com";

		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		this.loyaltyTabPage.selectManagePointsType("award");
		this.loyaltyTabPage.enterPointsForAwardOrRedeem("10");
		this.loyaltyTabPage.enterNumberOfNights("1");
		this.loyaltyTabPage.selectChangeType("manual");
		this.loyaltyTabPage.enterReasonForAwardOrRedeemPoints("Award Points By Manual Point Changes");
		this.loyaltyTabPage.clickPointsApplyButton();

		Assert.assertTrue(
				this.loyaltyTabPage.getPointsAppliedSuccessMessage().contains("Success The points were applied"),
				"Message should be 'Success The points were applied'");

		this.assertPointsHistoryTableRow(1, "10", "Manual Point Adjustment", "Award Points By Manual Point Changes",
				null, this.defaultUsername, "", "", "1", "0");
	}

	@Test(description = "test awarding Points via Manual Points Change for Reservation.")
	public void testAwardPointsByManualPointChangeForReservation() {
		String profileEmail = "Aelu.lollies.p2@example.com";
		String reservationNumber = "41906379";

		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		this.loyaltyTabPage.selectManagePointsType("award");
		this.loyaltyTabPage.enterPointsForAwardOrRedeem("10");
		this.loyaltyTabPage.enterNumberOfNights("1");
		this.loyaltyTabPage.selectChangeType("reservation");
		this.loyaltyTabPage.selectListReservationId("Property 3: #" + reservationNumber);
		this.loyaltyTabPage.enterReasonForAwardOrRedeemPoints("Award Points By Manual Point Changes for Reservation");
		this.loyaltyTabPage.clickPointsApplyButton();

		Assert.assertTrue(
				this.loyaltyTabPage.getPointsAppliedSuccessMessage().contains("Success The points were applied"),
				"Message should be 'Success The points were applied'");

		this.assertPointsHistoryTableRow(1, "10", "Reservation", "Award Points By Manual Point Changes for Reservation",
				null, this.defaultUsername, reservationNumber, "Property 3", "1", "0");
	}

	@Test(description = "Test awarding Points via Manual Points Change for Specific Property.")
	public void testAwardPointsByManualPointChangeForProperty() {
		String profileEmail = "Aelu.lollies.p1@example.com";

		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		this.loyaltyTabPage.selectManagePointsType("award");
		this.loyaltyTabPage.enterPointsForAwardOrRedeem("10");
		this.loyaltyTabPage.enterNumberOfNights("1");
		this.loyaltyTabPage.selectChangeType("property");
		this.loyaltyTabPage.selectPropertyId("Property 3");
		this.loyaltyTabPage.enterReasonForAwardOrRedeemPoints("Award Points By Manual Point Changes for Property");
		this.loyaltyTabPage.clickPointsApplyButton();

		Assert.assertTrue(
				this.loyaltyTabPage.getPointsAppliedSuccessMessage().contains("Success The points were applied"),
				"Message should be 'Success The points were applied'");

		this.assertPointsHistoryTableRow(1, "10", "Manual Point Adjustment",
				"Award Points By Manual Point Changes for Property", null, this.defaultUsername, "", "Property 3", "1",
				"0");
	}
}