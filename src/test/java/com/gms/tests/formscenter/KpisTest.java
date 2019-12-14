package com.gms.tests.formscenter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KpisTest extends BaseFormsCenterTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test cancelling creating new kpi.")
	public void testFormsCenterKpisTabCreateNewKpiModal() {
		this.listOfSurveysTabPage.get();
		this.listOfSurveysTabPage.waitForLoadingModalIsInvisible();
		this.listOfSurveysTabPage.waitForPageLoad();

		this.surveyListheaderPage.clickKpisTab();
		this.kpisTabPage.waitForLoadingModal();

		this.surveyListheaderPage.waitForPageLoad();
		this.kpisTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.kpisTabIsSelected(), "KPIs tab is not selected.");

		this.kpisTabPage.clickCreateNewKpiButton();
		this.kpisTabPage.waitForLoadingModal();

		this.kpisTabPage.WaitForCreateNewKpiModalToBeVisible();

		this.kpisTabPage.clickCreateNewKpiModalCancelButton();

		this.kpisTabPage.waitForCreateNewKpiModalToBeInvisible();
		this.kpisTabPage.waitForPageLoad();
	}
}
