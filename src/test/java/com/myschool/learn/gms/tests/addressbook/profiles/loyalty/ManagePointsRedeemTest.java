package com.myschool.learn.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;
import com.myschool.learn.gms.tests.addressbook.profiles.BaseProfilesTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManagePointsRedeemTest extends BaseProfilesTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test redeeming points via Manual Points Change.")
	public void testRedeemPointsByManualPointChange() {
		String profileEmail = "Rito.Bember.p0@example.com";

		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		this.loyaltyTabPage.selectManagePointsType("redeem");
		this.loyaltyTabPage.enterPointsForAwardOrRedeem("5");
		this.loyaltyTabPage.enterNumberOfNights("1");
		this.loyaltyTabPage.selectChangeType("manual");
		this.loyaltyTabPage.enterReasonForAwardOrRedeemPoints("Redeem Points By Manual Point Changes");
		this.loyaltyTabPage.clickPointsApplyButton();

		Assert.assertTrue(
				this.loyaltyTabPage.getPointsAppliedSuccessMessage().contains("Success The points were applied"),
				"Message should be 'Success The points were applied'");

		this.assertPointsHistoryTableRow(1, "-5", "Manual Point Adjustment", "Redeem Points By Manual Point Changes",
				null, this.defaultUsername, "", "", "-1", "0");
	}

	@Test(description = "Test redeeming points via Manual Points Change for Reservation.")
	public void testRedeemPointsByManualPointChangeForReservation() {
		String profileEmail = "Rito.Bember.p1@example.com";
		String reservationNumber = "99677764";

		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		this.loyaltyTabPage.selectManagePointsType("redeem");
		this.loyaltyTabPage.enterPointsForAwardOrRedeem("5");
		this.loyaltyTabPage.enterNumberOfNights("1");
		this.loyaltyTabPage.selectChangeType("reservation");
		this.loyaltyTabPage.selectListReservationId("Property 3: #" + reservationNumber);
		this.loyaltyTabPage.enterReasonForAwardOrRedeemPoints("Redeem Points By Manual Point Changes for Reservation");
		this.loyaltyTabPage.clickPointsApplyButton();

		Assert.assertTrue(
				this.loyaltyTabPage.getPointsAppliedSuccessMessage().contains("Success The points were applied"),
				"Message should be 'Success The points were applied'");

		this.assertPointsHistoryTableRow(1, "-5", "Reservation",
				"Redeem Points By Manual Point Changes for Reservation", null, this.defaultUsername, reservationNumber,
				"Property 3", "-1", "0");
	}

	@Test(description = "Test redeeming points via Manual Points Change for Property.")
	public void testRedeemPointsByManualPointChangeForProperty() {
		String profileEmail = "Rito.Bember.p2@example.com";

		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		this.loyaltyTabPage.selectManagePointsType("redeem");
		this.loyaltyTabPage.enterPointsForAwardOrRedeem("5");
		this.loyaltyTabPage.enterNumberOfNights("1");
		this.loyaltyTabPage.selectChangeType("property");
		this.loyaltyTabPage.selectPropertyId("Property 3");
		this.loyaltyTabPage.enterReasonForAwardOrRedeemPoints("Redeem Points By Manual Point Changes for Property");
		this.loyaltyTabPage.clickPointsApplyButton();

		Assert.assertTrue(
				this.loyaltyTabPage.getPointsAppliedSuccessMessage().contains("Success The points were applied"),
				"Message should be 'Success The points were applied'");

		this.assertPointsHistoryTableRow(1, "-5", "Manual Point Adjustment",
				"Redeem Points By Manual Point Changes for Property", null, this.defaultUsername, "", "Property 3",
				"-1", "0");
	}
}