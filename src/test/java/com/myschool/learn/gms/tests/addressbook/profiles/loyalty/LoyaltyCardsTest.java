package com.myschool.learn.gms.tests.addressbook.profiles.loyalty;

import java.io.IOException;

import com.myschool.learn.gms.tests.addressbook.profiles.BaseProfilesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoyaltyCardsTest extends BaseProfilesTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.login(this.defaultUsername, this.defaultPassword);
    }

    @Test(description = "Verify loyalty tab cards.")
    public void testLoyaltyTabCards() {
        this.goToProfileLoyaltyTab("test.profile@test.com", "Guest Portal");

        Assert.assertTrue(this.loyaltyTabPage.loyaltymembershipPointsCardIsVisible(), "Points card is not visible");
        this.loyaltyTabPage.clickLoyaltyPointsCard();
        this.loyaltyTabPage.waitForLoyaltyPointsCardTitleDialogToBeVisible();
        this.loyaltyTabPage.clickLoyaltyPointsCardDialogCloseButton();

        Assert.assertTrue(this.loyaltyTabPage.loyaltyStaysCardIsVisible(), "Stays card is not visible");
        this.loyaltyTabPage.clickLoyaltyYTDPointsCard();
        this.loyaltyTabPage.waitForLoyaltyYTDPointsCardTitleDialogToBeVisible();
        this.loyaltyTabPage.clickLoyaltyYTDPointsCardDialogCloseButton();

        Assert.assertTrue(this.loyaltyTabPage.loyaltyDollarSpentCardIsVisible(), "Dollar Spent card is not visible");

        Assert.assertTrue(this.loyaltyTabPage.loyaltyPointExpiringCardIsVisible(),
                "Points Expiring card should be visible");
        this.loyaltyTabPage.clickLoyaltyPointsExpiringCard();
        this.loyaltyTabPage.waitForLoyaltyPointsExpiringCardTitleToBeVisible();
        this.loyaltyTabPage.clickLoyaltyPointsExpiringCardDialogCloseButton();
    }
}