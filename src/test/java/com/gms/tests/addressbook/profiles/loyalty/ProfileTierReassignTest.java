package com.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gms.tests.addressbook.profiles.BaseProfilesTest;

public class ProfileTierReassignTest extends BaseProfilesTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test profile tier reassign with member notification.")
	public void testProfileTierReassignWithMemberNotification() {
		String profileEmail = "profiletierreassign.basictosilver@example.com";
		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile Current Tier should be Basic tier.");

		this.profileTierReassign("Basic", "Silver", true, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Silver",
				"Profile should be in Silver tier.");

		this.profileTierReassign("Silver", "Basic", true, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile should be in Basic tier.");
	}

	@Test(description = "Test profile tier reassign without member notification.")
	public void testProfileTierReassignWithoutMemberNotification() {
		String profileEmail = "profiletierreassign.basictosilver@example.com";
		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile Current Tier should be Basic tier.");

		this.profileTierReassign("Basic", "Silver", false, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Silver",
				"Profile should be in Silver tier.");

		this.profileTierReassign("Silver", "Basic", false, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile should be in Basic tier.");
	}

	@Test(description = "Test profile tier reassign with member notification and make tier level permanent.")
	public void testProfileTierReassignSilverToGold() {
		String profileEmail = "profiletierreassign.silvertogold@example.com";
		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Silver",
				"Profile Current Tier should be Silver tier.");

		this.profileTierReassign("Silver", "Gold", true, true);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Gold",
				"Profile should be in Gold tier.");
		Assert.assertTrue(this.loyaltyTabPage.loyaltyMemberTierLevelPermanentLockIsVisible(),
				"Permanent Lock icon should be visible.");

		this.profileTierReassign("Gold", "Silver", false, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Silver",
				"Profile should be in Silver tier.");
	}

	@Test(description = "Test profile tier change when member is set to non permanent tier.")
	public void testProfileTierLevelForNonPermanentTier() {
		String profileEmail = "profiletierreassign.testtierlevels@example.com";
		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile Current Tier should be Basic tier.");

		this.profileTierReassign("Basic", "Silver", true, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Silver",
				"Profile should be in Silver tier.");
		Assert.assertEquals(this.loyaltyTabPage.getloyaltyPointsCount(), "0",
				"Profile should have '0' Loyalty Points.");

		this.pointsRedeemOrAwardByManualPointChange("award", "205", "1", "manual",
				"Award Points By Manual Point Changes");
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Gold",
				"Profile Current Tier should be Gold tier.");
		Assert.assertEquals(this.loyaltyTabPage.getloyaltyPointsCount(), "205",
				"Profile should have '205' Loyalty Points after Redeem action.");

		this.pointsRedeemOrAwardByManualPointChange("redeem", "205", "1", "manual",
				"Award Points By Manual Point Changes");
		Assert.assertEquals(this.loyaltyTabPage.getloyaltyPointsCount(), "0",
				"Profile should have '0' Loyalty Points.");

		this.profileTierReassign("Gold", "Basic", true, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile should be in Basic tier.");
	}

	@Test(description = "Test profile tier doesn't change when member is set to make permanent.")
	public void testProfileTierLevelForMakePermanentTier() {
		String profileEmail = "profiletierreassign.testtierlevels@example.com";
		this.goToProfileLoyaltyTab(profileEmail, "Guest Portal");

		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile Current Tier should be Basic tier.");

		this.profileTierReassign("Basic", "Silver", true, true);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Silver",
				"Profile should be in Silver tier.");
		Assert.assertTrue(this.loyaltyTabPage.loyaltyMemberTierLevelPermanentLockIsVisible(),
				"Permanent Lock icon should be visible.");
		Assert.assertEquals(this.loyaltyTabPage.getloyaltyPointsCount(), "0",
				"Profile should have '0' Loyalty Points.");

		this.pointsRedeemOrAwardByManualPointChange("award", "205", "1", "manual",
				"Award Points By Manual Point Changes");
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Silver",
				"Profile Current Tier should be Silver tier.");
		Assert.assertEquals(this.loyaltyTabPage.getloyaltyPointsCount(), "205",
				"Profile should have '205' Loyalty Points after Redeem action.");

		this.pointsRedeemOrAwardByManualPointChange("redeem", "205", "1", "manual",
				"Award Points By Manual Point Changes");
		Assert.assertEquals(this.loyaltyTabPage.getloyaltyPointsCount(), "0",
				"Profile should have '0' Loyalty Points.");

		this.profileTierReassign("Silver", "Basic", true, false);
		Assert.assertEquals(this.loyaltyTabPage.getLoyaltyMemberProfileTierLevel(), "Level: Basic",
				"Profile should be in Basic tier.");
	}
}