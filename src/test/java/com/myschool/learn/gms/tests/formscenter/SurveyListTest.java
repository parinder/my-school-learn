package com.myschool.learn.gms.tests.formscenter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class SurveyListTest extends BaseFormsCenterTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test List of Surveys tab contents.")
	public void testListOfSurveysTab() {
		this.listOfSurveysTabPage.get();
		this.listOfSurveysTabPage.waitForLoadingModalIsInvisible();
		this.listOfSurveysTabPage.waitForPageLoad();

		// verify list contents
		Assert.assertTrue(this.listOfSurveysTabPage.getSurveyListRowCount().intValue() >= 6,
				"Survey list row count should be at least 6.");

		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowName(0), "Test Edit Survey 1",
				"Survey list name in row 0 should be 'Test Edit Survey 1'.");
		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowStatus(0), "on",
				"Survey list status in row 0 should be 'on'.");

		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowName(1), "Test Edit Survey 2",
				"Survey list name in row 1 should be 'Test Edit Survey 2'.");
		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowStatus(1), "on",
				"Survey list status in row 1 should be 'on'.");

		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowName(2), "Test Subscription Survey",
				"Survey list name in row 2 should be 'Test Subscription Survey'.");
		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowLiveSince(2), "",
				"Survey list live since in row 2 should be blank.");
		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowStatus(2), "off",
				"Survey list status in row 2 should be 'off'.");

		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowName(3), "Test Add Delete Pages Survey",
				"Survey list name in row 3 should be 'Test Add Delete Pages Survey'.");
		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowStatus(3), "on",
				"Survey list status in row 3 should be 'on'.");

		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowName(4), "Test 3 Page Survey",
				"Survey list name in row 4 should be 'Test 3 Page Survey'.");
		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowStatus(4), "on",
				"Survey list status in row 4 should be 'on'.");

		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowName(5), "Test Submission Survey 1",
				"Survey list name in row 5 should be 'Test Submission Survey 1'.");
		Assert.assertEquals(this.listOfSurveysTabPage.getSurveyListRowStatus(5), "on",
				"Survey list status in row 5 should be 'on'.");
	}
}
