package com.myschool.learn.gms.tests.formscenter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.myschool.learn.gms.helpers.RandomDataHelper;
import com.myschool.learn.gms.pages.profiles.ProfilesPage;
import com.myschool.learn.gms.pages.profiles.profile.HeaderPage;
import com.myschool.learn.gms.pages.profiles.profile.OverviewTabPage;
import com.myschool.learn.gms.pages.profiles.profile.SurveyEntryModalPage;
import com.myschool.learn.gms.pages.profiles.profile.SurveysTabPage;
import com.myschool.learn.gms.pages.profiles.profile.TimelineTabPage;
import com.myschool.learn.gms.pages.surveys.BaseSurveyPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SubmitSurveyTest extends BaseFormsCenterTest {

	protected RandomDataHelper randomDataHelper;

	protected BaseSurveyPage testSubmissionSurveyPage;

	protected ProfilesPage profilesPage;
	protected HeaderPage profileHeaderPage;
	protected OverviewTabPage profileOverviewTabPage;
	protected SurveysTabPage profileSurveysTabPage;
	protected TimelineTabPage profileTimelineTabPage;
	protected SurveyEntryModalPage surveyEntryModalPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.randomDataHelper = new RandomDataHelper();
		this.testSubmissionSurveyPage = new BaseSurveyPage(this.driver, config);
		this.profilesPage = new ProfilesPage(this.driver, config);
		this.profileHeaderPage = new HeaderPage(this.driver, config);
		this.profileOverviewTabPage = new OverviewTabPage(this.driver, config);
		this.profileSurveysTabPage = new SurveysTabPage(this.driver, config);
		this.profileTimelineTabPage = new TimelineTabPage(this.driver, config);
		this.surveyEntryModalPage = new SurveyEntryModalPage(this.driver, config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test submitting survey.")
	public void testSubmitSurvey() {
		String surveyUsername = "daisha.hane.57707@example.com";

		this.goToSurvey(5);

		this.surveyHeaderPage.clickSettingsTab();
		this.settingsTabPage.waitForPageLoad();
		this.driver.switchTo().frame("settingsIframe");
		this.settingsTabPage.clickOpenButton();

		this.testSubmissionSurveyPage.waitForNumberOfWindowsToBe(2);
		this.testSubmissionSurveyPage.switchToNewWindow();
		this.testSubmissionSurveyPage.waitForPageLoad();

		if (this.config.getProperty("environment.name").equals("p1")) {
			// this is a hack
			// edit the url in the form action manually to make it p1 when necessary
			// remove once we no longer use a prod copy of data in p1
			this.testSubmissionSurveyPage.replaceFormActionBaseUrl("www.tcgms.net", "p1.tcgms.net");
		}

		this.testSubmissionSurveyPage.clickOptInCheckbox();
		this.testSubmissionSurveyPage.enterEmail(surveyUsername);
		this.testSubmissionSurveyPage.enterDateAnswer("110266", "10/31/2019");
		this.testSubmissionSurveyPage.clickSingleAnswer("92242", 1);
		this.testSubmissionSurveyPage.clickMultipleAnswer("92245", 1);
		this.testSubmissionSurveyPage.clickMultipleAnswer("92245", 4);
		this.testSubmissionSurveyPage.clickNpsAnswer("81003", 8);
		this.testSubmissionSurveyPage.clickGroupAnswer("110267", 0, 1);
		this.testSubmissionSurveyPage.clickGroupAnswer("110267", 1, 1);
		this.testSubmissionSurveyPage.clickGroupAnswer("110267", 2, 1);

		Date currentDate = new Date();
		SimpleDateFormat dateFormatterVerbose = new SimpleDateFormat("MMMMM dd, yyyy");
		SimpleDateFormat dateFormatterDashes = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

		String testVerboseDate = dateFormatterVerbose.format(currentDate);
		String testDashDate = dateFormatterDashes.format(currentDate);
		String testTime = timeFormatter.format(currentDate).toLowerCase();
		String testIdNumber = this.randomDataHelper.getRandomTestIdNumber();

		String testComment = "This is a test comment made on " + testVerboseDate + " at " + testTime + " with id of " + testIdNumber +  ".";
		this.testSubmissionSurveyPage.enterFreeFormCommentAnswer("80837", testComment);

		this.testSubmissionSurveyPage.clickSubmitButton();
		Assert.assertTrue(this.testSubmissionSurveyPage.textBlockIsVisible("Thank you for submitting!"),
				"Thank you page text 'Thank you for submitting!' should be visible");

		this.testSubmissionSurveyPage.waitForNumberOfWindowsToBe(2);
		this.testSubmissionSurveyPage.closeWindow();
		this.testSubmissionSurveyPage.waitForNumberOfWindowsToBe(1);
		this.testSubmissionSurveyPage.switchToNewWindow();

		this.profilesPage.get();
		this.profilesPage.waitForPageLoad();
		this.profilesPage.enterProfileSearchEmail(surveyUsername);
		this.profilesPage.clickProfileSearchButton();
		this.profileOverviewTabPage.waitForPageLoad();
		Assert.assertTrue(this.profileHeaderPage.getMainProfileInformation().contains(surveyUsername),
				"Profile Email does not contain '" + surveyUsername + "'.");

		// verify submission via surveys tab (enhancement)

		this.profileHeaderPage.clickProfileTimelineTab();
		this.profileTimelineTabPage.waitForPageLoad();
		Assert.assertEquals(this.profileTimelineTabPage.getTimelineListItemTitle(0), "Test Submission Survey 1",
				"Latest timeline item title should be 'Test Submission Survey 1'.");
		Assert.assertEquals(this.profileTimelineTabPage.getTimelineListItemDate(0), testVerboseDate,
				"Latest timeline item date should be '" + testVerboseDate + "'.");
		Assert.assertEquals(this.profileTimelineTabPage.getTimelineListItemTime(0), testTime,
				"Latest timeline item time should be '" + testTime + "'.");

		this.profileTimelineTabPage.clickTimelineListRowsViewSubmissionButton(0);
		this.surveyEntryModalPage.waitToBeVisible();
		Assert.assertEquals(this.surveyEntryModalPage.getSummarySurvey(), "Test Submission Survey 1",
				"Summary survey should be 'Test Submission Survey 1'.");
		Assert.assertEquals(this.surveyEntryModalPage.getSummaryEntryDate(), testDashDate,
				"Summary entry date should be '" + testDashDate + "'.");
		Assert.assertEquals(this.surveyEntryModalPage.getSummaryScore(), "1", "Summary sscore should be '1'.");

		Assert.assertEquals(this.surveyEntryModalPage.getQuestionAnswer("Select 1 of 2"), "Two",
				"Answer should be 'Two'");
		Assert.assertEquals(this.surveyEntryModalPage.getQuestionAnswer("Select Multiple of 5"), "FiveTwo",
				"Answer should be 'FiveTwo'");
		Assert.assertEquals(this.surveyEntryModalPage.getQuestionAnswer("Select Net Promoter Score"),
				"Net Promoter Score : 2 (2)", "Answer should be 'Net Promoter Score : 2 (2)'");
		Assert.assertEquals(this.surveyEntryModalPage.getQuestionAnswer("Enter Free Form Comment"), testComment,
				"Answer should be '" + testComment + "'");
		Assert.assertTrue(
				this.surveyEntryModalPage.getQuestionAnswer("Select Ratings in Group").contains("Item 1 : Bad (0)"),
				"Answer should contain 'Item 1 : Bad (0)'.");
		Assert.assertTrue(
				this.surveyEntryModalPage.getQuestionAnswer("Select Ratings in Group").contains("Item 2 : Bad (0)"),
				"Answer should contain 'Item 2 : Bad (0)'.");
		Assert.assertTrue(
				this.surveyEntryModalPage.getQuestionAnswer("Select Ratings in Group").contains("Item 3 : Bad (0)"),
				"Answer should contain 'Item 3 : Bad (0)'.");

		this.surveyEntryModalPage.clickCloseButton();
		this.surveyEntryModalPage.waitToBeInvisible();
	}

	@Test(description = "Test non-international cell phone number validation in survey submission.")
	public void testNonInternationalCellPhoneNumberValidation() {
		String surveyUsername = "daisha.hane.57707@example.com";

		this.goToSurvey(6);

		this.surveyHeaderPage.clickSettingsTab();
		this.settingsTabPage.waitForPageLoad();
		this.driver.switchTo().frame("settingsIframe");
		this.settingsTabPage.clickOpenButton();

		this.testSubmissionSurveyPage.waitForNumberOfWindowsToBe(2);
		this.testSubmissionSurveyPage.switchToNewWindow();
		this.testSubmissionSurveyPage.waitForPageLoad();

		this.testSubmissionSurveyPage.enterCellPhoneNumber("aaa", "bbb", "ccc");
		this.testSubmissionSurveyPage.clickSubmitButton();
		Assert.assertEquals(this.testSubmissionSurveyPage.getCellPhoneNumberErrorMessage().trim(),
				"*Please enter a valid phone number",
				"Cell phone number error message should be '*Please enter a valid phone number'");

		this.testSubmissionSurveyPage.enterCellPhoneNumber("613", "123", "1234");
		this.testSubmissionSurveyPage.clickSubmitButton();
		Assert.assertFalse(this.testSubmissionSurveyPage.cellPhoneNumberErrorMessageIsVisible(),
				"Cell phone number error message should not be visible");

		this.testSubmissionSurveyPage.enterCellPhoneNumber("aaa", "123", "1234");
		this.testSubmissionSurveyPage.clickSubmitButton();
		Assert.assertTrue(this.testSubmissionSurveyPage.cellPhoneNumberErrorMessageIsVisible(),
				"Cell phone number error message should be visible.");
		Assert.assertEquals(this.testSubmissionSurveyPage.getCellPhoneNumberErrorMessage().trim(),
				"*Please enter a valid phone number",
				"Cell phone number error message should be '*Please enter a valid phone number'");

		this.testSubmissionSurveyPage.enterEmail(surveyUsername);
		this.testSubmissionSurveyPage.enterCellPhoneNumber("613", "123", "1234");
		this.testSubmissionSurveyPage.clickSubmitButton();
		Assert.assertTrue(this.testSubmissionSurveyPage.textBlockIsVisible("Thank you for submitting!"),
				"Thank you page text 'Thank you for submitting!' should be visible");
		
		this.testSubmissionSurveyPage.waitForNumberOfWindowsToBe(2);
		this.testSubmissionSurveyPage.closeWindow();
		this.testSubmissionSurveyPage.waitForNumberOfWindowsToBe(1);
		this.testSubmissionSurveyPage.switchToNewWindow();
	}
}
