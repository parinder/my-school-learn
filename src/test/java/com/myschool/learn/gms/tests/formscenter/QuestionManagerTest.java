package com.myschool.learn.gms.tests.formscenter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class QuestionManagerTest extends BaseFormsCenterTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test forms center question manager tab.")
	public void testCreateNewQuestionModal() {
		this.listOfSurveysTabPage.get();
		this.listOfSurveysTabPage.waitForLoadingModalIsInvisible();
		this.listOfSurveysTabPage.waitForPageLoad();

		this.surveyListheaderPage.clickQuestionManagerTab();
		this.questionManagerTabPage.waitForLoadingModal();

		this.questionManagerTabPage.waitForPageLoad();

		// Enhance to assert question list and search

		this.questionManagerTabPage.clickCreateNewQuestionButton();

		this.questionManagerTabPage.waitForCreateNewQuestionModalToBeVisible();
		Assert.assertTrue(this.questionManagerTabPage.createNewQuestionModalNextButtonIsDisabled(),
				"Next button should be disabled.");

		Assert.assertEquals(this.questionManagerTabPage.getQuestionTypeCount().intValue(), 6,
				"Number of question types should be 6");
		Assert.assertTrue(this.questionManagerTabPage.getQuestionTypeText(0).contains("One Answer"),
				"Question type 0 should be 'One Answer'");
		Assert.assertTrue(this.questionManagerTabPage.getQuestionTypeText(1).contains("Multiple Answers"),
				"Question type 1 should be 'Multiple Answers'");
		Assert.assertTrue(this.questionManagerTabPage.getQuestionTypeText(2).contains("Free Form Comment"),
				"Question type 2 should be 'Free Form Comment'");
		Assert.assertTrue(this.questionManagerTabPage.getQuestionTypeText(3).contains("Date Answer"),
				"Question type 3 should be 'Date Answer'");
		Assert.assertTrue(this.questionManagerTabPage.getQuestionTypeText(4).contains("Question Group"),
				"Question type 4 should be 'Question Group'");
		Assert.assertTrue(this.questionManagerTabPage.getQuestionTypeText(5).contains("Net Promoter Score"),
				"Question type 5 should be 'Net Promoter Score'");

		this.questionManagerTabPage.clickQuestionType(0);
		Assert.assertFalse(this.questionManagerTabPage.createNewQuestionModalNextButtonIsDisabled(),
				"Next button should be enabled.");

		// Enhance to fill the whole new question form

		this.questionManagerTabPage.clickCreateNewQuestionModalCancelButton();
		this.questionManagerTabPage.waitForCreateNewQuestionModalToBeInvisible();

		this.surveyListheaderPage.waitForPageLoad();
		this.questionManagerTabPage.waitForPageLoad();
	}
}
