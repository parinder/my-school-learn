package com.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gms.pages.profiles.profile.HeaderPage;
import com.gms.pages.profiles.profile.LoyaltyTabPage;
import com.gms.pages.profiles.profile.OverviewTabPage;
import com.gms.tests.addressbook.profiles.BaseProfilesTest;

import org.testng.annotations.BeforeClass;

public class MergeMembershipTest extends BaseProfilesTest {
	protected HeaderPage headerPage;
	protected OverviewTabPage overviewTabPage;
	protected LoyaltyTabPage loyaltyTabPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.headerPage = new HeaderPage(this.driver, config);
		this.overviewTabPage = new OverviewTabPage(this.driver, config);
		this.loyaltyTabPage = new LoyaltyTabPage(this.driver, config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test Merge Membership for profiles enrolled in house program")
	public void testMergeProfilesInHouseProgram() {
		String profile1FirstName = this.randomDataHelper.getRandomFirstName();
		String profile1LastName = this.randomDataHelper.getRandomLastName();
		String profile1NewEmail = this.randomDataHelper.getRandomEmailAddress(profile1FirstName, profile1LastName);

		String profile2FirstName = this.randomDataHelper.getRandomFirstName();
		String profile2LastName = this.randomDataHelper.getRandomLastName();
		String profile2NewEmail = this.randomDataHelper.getRandomEmailAddress(profile2FirstName, profile2LastName);

		this.createNewProfile(profile1FirstName, profile1LastName, "P", profile1NewEmail, "City");// to be merged into
        this.createNewProfile(profile2FirstName, profile2LastName, "P", profile2NewEmail, "City");

		this.enrollProfileInHouseProgram(profile1NewEmail, "Guest Portal", "QATeam-AUTOMATEDTests(DONOTTOUCH)");
		int profile1LoyaltyPoints = Integer.parseInt(this.loyaltyTabPage.getloyaltyPointsCount());
		this.enrollProfileInHouseProgram(profile2NewEmail, "Guest Portal", "AutomationPortal");
		int profile2LoyaltyPoints = Integer.parseInt(this.loyaltyTabPage.getloyaltyPointsCount());

		this.mergeMembership(profile1NewEmail, profile2NewEmail, profile1LoyaltyPoints, profile2LoyaltyPoints, false);

		this.goToProfile(profile2NewEmail);
		Assert.assertEquals(this.overviewTabPage.getHouseMembershipNumber(), profile2NewEmail,
				"After Merge and Delete Profile the house membership number should be " + profile2NewEmail);
		this.headerPage.clickProfileLoyaltyTab();
		this.loyaltyTabPage.waitForPageLoad();
		Assert.assertEquals(this.loyaltyTabPage.getloyaltyPointsCount(), "0", "Profile Points should be 0 after Merge");
	}

	@Test(description = "Test Merge Membership and delete for profiles enrolled in house program")
	public void testMergeAndDeleteProfilesInHouseProgram() {
		String profile1FirstName = this.randomDataHelper.getRandomFirstName();
		String profile1LastName = this.randomDataHelper.getRandomLastName();
		String profile1NewEmail = this.randomDataHelper.getRandomEmailAddress(profile1FirstName, profile1LastName);

		String profile2FirstName = this.randomDataHelper.getRandomFirstName();
		String profile2LastName = this.randomDataHelper.getRandomLastName();
		String profile2NewEmail = this.randomDataHelper.getRandomEmailAddress(profile2FirstName, profile2LastName);

        this.createNewProfile(profile1FirstName, profile1LastName, "P", profile1NewEmail, "City");
        this.createNewProfile(profile2FirstName, profile2LastName, "P", profile2NewEmail, "City");

		this.enrollProfileInHouseProgram(profile1NewEmail, "Guest Portal", "QATeam-AUTOMATEDTests(DONOTTOUCH)");
		int profile1LoyaltyPoints = Integer.parseInt(this.loyaltyTabPage.getloyaltyPointsCount());
		this.enrollProfileInHouseProgram(profile2NewEmail, "Guest Portal", "AutomationPortal");
		int profile2LoyaltyPoints = Integer.parseInt(this.loyaltyTabPage.getloyaltyPointsCount());

		this.mergeMembership(profile1NewEmail, profile2NewEmail, profile1LoyaltyPoints, profile2LoyaltyPoints, true);

		this.goToProfile(profile2NewEmail);
		this.overviewTabPage.waitForHouseMembershipNumberToBeInvisible();
		this.headerPage.clickProfileLoyaltyTab();
		this.loyaltyTabPage.waitForPageLoad();
		this.loyaltyTabPage.waitForLoyaltyMemberNumberToBeInvisible();
	}

	@Test(description = "Test Merge Membership for profiles enrolled in different programs fails.")
	public void testMergeProfilesWithDifferentProgramsError() {
		String profile1FirstName = this.randomDataHelper.getRandomFirstName();
		String profile1LastName = this.randomDataHelper.getRandomLastName();
		String profile1NewEmail = this.randomDataHelper.getRandomEmailAddress(profile1FirstName, profile1LastName);

		String profile2FirstName = this.randomDataHelper.getRandomFirstName();
		String profile2LastName = this.randomDataHelper.getRandomLastName();
		String profile2NewEmail = this.randomDataHelper.getRandomEmailAddress(profile2FirstName, profile2LastName);

        this.createNewProfile(profile1FirstName, profile1LastName, "P", profile1NewEmail, "City");
        this.createNewProfile(profile2FirstName, profile2LastName, "P", profile2NewEmail, "City");

		this.enrollProfileInNonHouseProgram(profile1NewEmail, "GOTHIA");
		this.enrollProfileInHouseProgram(profile2NewEmail, "Guest Portal", "AutomationPortal");

		this.loyaltyTabPage.clickMergeMembershipButton();
		this.loyaltyTabPage.waitForMergeMembershipModalToBeVisible();
		this.loyaltyTabPage.enterMemberNumber(profile1NewEmail);
		this.loyaltyTabPage.clickFindMemberButton();

		Assert.assertTrue(this.loyaltyTabPage.noMemberFoundWithMemberNumberErrorMessageIsVisible(),
				"Error Message 'No member was found with this member number' should be visible.");
	}
}
