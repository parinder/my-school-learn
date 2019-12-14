package com.gms.tests.formscenter;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationTest extends BaseFormsCenterTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test Forms Center tabs navigation.")
	public void testFormsCenterTabsNavigation() {
		this.listOfSurveysTabPage.get();
		this.listOfSurveysTabPage.waitForLoadingModal();

		this.surveyListheaderPage.waitForPageLoad();
		this.listOfSurveysTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.listOfSurveysTabIsSelected(),
				"List of Surveys tab should appear selected.");

		this.surveyListheaderPage.clickUpgradeFormsTab();
		this.upgradeFormsTabPage.waitForLoadingModal();

		this.surveyListheaderPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.upgradeFormsTabIsSelected(), "Upgrade forms tab should be selected.");

		this.surveyListheaderPage.clickQuestionManagerTab();
		this.questionManagerTabPage.waitForLoadingModal();
		this.surveyListheaderPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.questionManagerTabIsSelected(),
				"Question manager tab should be selected.");

		this.surveyListheaderPage.clickKpisTab();
		this.kpisTabPage.waitForLoadingModal();

		this.surveyListheaderPage.waitForPageLoad();
		this.kpisTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.kpisTabIsSelected(), "KPIs tab should be selected.");

		this.surveyListheaderPage.clickListOfSurveysTab();
		this.listOfSurveysTabPage.waitForLoadingModal();
		this.surveyListheaderPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.listOfSurveysTabIsSelected(),
				"List of Surveys tab should appear selected.");
	}
}
