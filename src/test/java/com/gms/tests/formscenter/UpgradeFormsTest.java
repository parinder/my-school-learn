package com.gms.tests.formscenter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class UpgradeFormsTest extends BaseFormsCenterTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test new upgrade form modal")
	public void testNewUpgradeForm() {
		this.listOfSurveysTabPage.get();
		this.listOfSurveysTabPage.waitForLoadingModalIsInvisible();
		this.listOfSurveysTabPage.waitForPageLoad();

		this.surveyListheaderPage.clickUpgradeFormsTab();
		this.upgradeFormsTabPage.waitForLoadingModal();

		this.surveyListheaderPage.waitForPageLoad();
		this.upgradeFormsTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.upgradeFormsTabIsSelected(), "Upgrade forms tab should be selected.");

		this.upgradeFormsTabPage.clickCreateNewFormButton();
		this.upgradeFormsTabPage.waitForLoadingModal();
		this.upgradeFormsTabPage.waitForNewUpgradeFormModalToBeVisible();

		this.upgradeFormsTabPage.clickNewUpgradeFormModalCancelButton();
		this.upgradeFormsTabPage.waitForNewUpgradeFormModalToBeInvisible();

		this.surveyListheaderPage.waitForPageLoad();
		this.upgradeFormsTabPage.waitForPageLoad();
	}
}
