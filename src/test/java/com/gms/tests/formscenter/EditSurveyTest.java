package com.gms.tests.formscenter;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditSurveyTest extends BaseFormsCenterTest {

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test edit survey page tab navigation.")
	public void testTabsNavigation() {
		this.goToSurvey(0);

		this.surveyHeaderPage.waitForPageLoad();
		this.surveyPagesTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyHeaderPage.surveyPagesTabIsSelected(), "'Survey pages' tab should appear selected.");

		this.surveyHeaderPage.clickThankYouPagesTab();
		this.thankYouPagesTabPage.waitForLoadingModal();
		this.surveyHeaderPage.waitForPageLoad();
		this.thankYouPagesTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyHeaderPage.thankYouPagesTabIsSelected(),
				"'Thank you pages' tab should appear selected.");

		this.surveyHeaderPage.clickSettingsTab();
		this.settingsTabPage.waitForLoadingOverlay();
		this.surveyHeaderPage.waitForPageLoad();
		this.settingsTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyHeaderPage.settingsTabIsSelected(), "'Settings' tab should appear selected.");

		this.surveyHeaderPage.clickReportsTab();
		this.surveyHeaderPage.waitForPageLoad();
		this.reportsTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyHeaderPage.reportsTabIsSelected(), "'Reports' tab should appear selected.");

		this.surveyHeaderPage.clickSurveyPagesTab();
		this.surveyPagesTabPage.waitForLoadingModal();
		this.surveyHeaderPage.waitForPageLoad();
		this.surveyPagesTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyHeaderPage.surveyPagesTabIsSelected(), "'Survey pages' tab should appear selected.");
	}

	@Test(description = "Test edit survey page 'Click to Open Question Manager' link.")
	public void testQuestionManagerLink() {
		this.goToSurvey(0);

		this.surveyHeaderPage.clickQuestionManagerIcon();
		this.questionManagerTabPage.waitForLoadingModal();

		this.surveyListheaderPage.waitForPageLoad();
		this.questionManagerTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.questionManagerTabIsSelected(),
				"Question manager tab should be selected.");
	}

	@Test(description = "Test edit survey page 'Click to Open List of Surveys Screen' link.")
	public void testSurveyListLink() {
		this.goToSurvey(0);

		this.surveyHeaderPage.clickSurveyListIcon();
		this.listOfSurveysTabPage.waitForLoadingModal();

		this.surveyListheaderPage.waitForPageLoad();
		this.listOfSurveysTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyListheaderPage.listOfSurveysTabIsSelected(),
				"List of surveys tab should be selected.");
	}

	@Test(description = "Test edit survey 'List of Surveys' dropdown.")
	public void testListOfSurveysDropdownNavigation() {
		this.goToSurvey(0);

		this.surveyHeaderPage.selectListOFSurveysDropdwonOption("Test Edit Survey 2");
		this.surveyPagesTabPage.waitForLoadingModal();
		this.surveyHeaderPage.waitForPageLoad();
		this.surveyPagesTabPage.waitForPageLoad();
		Assert.assertEquals(this.surveyHeaderPage.getSurveyNameSubtitleText(), "Test Edit Survey 2",
				"Survey header subtitle should be 'Test Edit Survey 2'.");

		this.surveyHeaderPage.selectListOFSurveysDropdwonOption("Test Edit Survey 1");
		this.surveyPagesTabPage.waitForLoadingModal();
		this.surveyHeaderPage.waitForPageLoad();
		this.surveyPagesTabPage.waitForPageLoad();
		Assert.assertEquals(this.surveyHeaderPage.getSurveyNameSubtitleText(), "Test Edit Survey 1",
				"Survey header subtitle should be 'Test Edit Survey 1'.");
	}

	@Test(description = "Test edit survey 'Survey pages' tab contents.")
	public void testPagesTabContents() {
		this.goToSurvey(4);

		this.surveyPagesTabPage.waitForControlPanelToBeVisible();
		this.surveyPagesTabPage.waitForFormElementsStylePanelToBeVisible();
		this.surveyPagesTabPage.waitForAdvancedStylePanelToBeVisible();
		this.surveyPagesTabPage.waitForPalettePanelToBeVisible();
		this.surveyPagesTabPage.waitForQuestionLibraryPanelToBeVisible();
		this.surveyPagesTabPage.waitForRegistrationFieldsPanelToBeVisible();
		this.surveyPagesTabPage.waitForPageLoad();
		Assert.assertEquals(this.surveyPagesTabPage.getSurveyPageButtonCount().intValue(), 3,
				"Survey should show 3 pages.");
	}

	@Test(description = "Test edit survey 'Survey pages' tab add page.")
	public void testAddPage() {
		this.goToSurvey(3);
		Integer initialPageCount = this.surveyPagesTabPage.getSurveyPageButtonCount();
		this.surveyPagesTabPage.clickAddPageButton();
		this.surveyPagesTabPage.waitForLoadingModal();
		this.goToSurvey(3); // to avoid any timing issues
		Assert.assertEquals(this.surveyPagesTabPage.getSurveyPageButtonCount().intValue(), initialPageCount + 1,
				"Page button count should be one more than " + initialPageCount + " after adding a page.");
	}

	@Test(description = "Test edit survey 'Survey pages' tab delete page.")
	public void testDeletePage() {
		this.goToSurvey(3);
		Integer initialPageCount = this.surveyPagesTabPage.getSurveyPageButtonCount();
		this.surveyPagesTabPage.clickSurveyPageButton(2);
		this.surveyPagesTabPage.waitForLoadingModal();
		Assert.assertTrue(this.surveyPagesTabPage.surveyPageButtonIsSelected(2),
				"Page button with index 2 should be selected.");
		this.surveyPagesTabPage.clickDeletePageButton();
		this.surveyPagesTabPage.waitForLoadingModal();
		this.surveyPagesTabPage.waitForDeleteCurrentPageDialogIsVisible();
		this.surveyPagesTabPage.clickDeleteCurrentPageDialogDeleteButton();
		// waiting for the loading modal gets stale elemnt reference issues
		this.goToSurvey(3); // to avoid any timing issues
		Assert.assertEquals(this.surveyPagesTabPage.getSurveyPageButtonCount().intValue(),
				initialPageCount.intValue() - 1, "Page button count should be one less than "
						+ Integer.toString(initialPageCount) + " after deleting page.");
	}

	@Test(description = "Test edit survey 'Survey pages' tab 'Preview Survey Page' button.")
	public void testPreviewSurvey() {
		this.goToSurvey(0);
		this.surveyPagesTabPage.clickPreviewSurveyPageButton();
		this.surveyPagesTabPage.waitForNumberOfWindowsToBe(2);
		this.surveyPagesTabPage.switchToNewWindow();
		this.surveyRenderPage.waitForPageLoad();

		this.surveyRenderPage.waitForNumberOfWindowsToBe(2);
		this.surveyRenderPage.closeWindow();
		this.surveyRenderPage.waitForNumberOfWindowsToBe(1);
		this.surveyRenderPage.switchToNewWindow();
	}

	@Test(description = "Test edit survey 'Survey pages' tab 'Edit Question Display Types' button.")
	public void testEditQuestionDisplayTypes() {
		this.goToSurvey(0);

		this.surveyPagesTabPage.clickEditQuestionDisplayTypesButton();
		this.listOfSurveysTabPage.waitForLoadingModal();
		this.surveyPagesTabPage.waitForEditQuestionDisplayTypesModalToBeVisible();
		this.surveyPagesTabPage.clickEditQuestionDisplayTypesModalCancelButton();
	}

	@Test(description = "Test edit survey 'Survey pages' tab 'Thank you pages' tab contents.")
	public void testThankYouPagesTabContents() {
		this.goToSurvey(0);

		this.surveyHeaderPage.clickThankYouPagesTab();
		this.thankYouPagesTabPage.waitForLoadingModal();
		this.surveyHeaderPage.waitForPageLoad();
		this.thankYouPagesTabPage.waitForPageLoad();
		this.thankYouPagesTabPage.waitForControlPanelToBeVisible();
		this.surveyPagesTabPage.waitForAdvancedStylePanelToBeVisible();
		this.surveyPagesTabPage.waitForPalettePanelToBeVisible();
		this.surveyPagesTabPage.waitForPageLoad();
		Assert.assertEquals(this.surveyPagesTabPage.getSurveyPageButtonCount().intValue(), 1,
				"Survey should have 1 page.");
	}

	@Test(description = "Test edit survey 'Settings' tab section navigation.")
	public void testSettingsTabSectionNavigation() {
		this.goToSurvey(0);

		this.surveyHeaderPage.clickSettingsTab(); // click on settings tab
		this.settingsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("settingsIframe"); // switch to frame

		Assert.assertFalse(this.settingsTabPage.surveyStatusSectionIsCollapsed(),
				"Survey status section should be open by default.");

		this.settingsTabPage.clickSurveyStatusSectionHeader();
		this.settingsTabPage.waitForSurevyStatusSectionToBeClosed();
		Assert.assertTrue(this.settingsTabPage.surveyStatusSectionIsCollapsed(),
				"Survey status section should be closed.");

		this.settingsTabPage.clickSurveyStatusSectionHeader();
		this.settingsTabPage.waitForSurevyStatusSectionToBeOpen();
		Assert.assertFalse(this.settingsTabPage.surveyStatusSectionIsCollapsed(),
				"Survey status section should be open.");
	}

	@Test(description = "Test edit survey 'Settings' tab 'Save' button.")
	public void testSettingsTabSaveSettings() {
		this.goToSurvey(0);

		this.surveyHeaderPage.clickSettingsTab(); // click on settings tab
		this.settingsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("settingsIframe"); // switch to frame

		this.settingsTabPage.clickAllowOnlyFirstSubmissionRadioButton();
		this.settingsTabPage.clickSubmitBrandNewSubmissionRadioButton();

		this.settingsTabPage.clickSurveyCancelButton();

		this.settingsTabPage.clickAllowOnlyFirstSubmissionRadioButton();
		this.settingsTabPage.clickSubmitBrandNewSubmissionRadioButton();

		this.settingsTabPage.clickSurveySaveButton();
		this.settingsTabPage.clickToastCloseButton();
	}

	@Test(description = "Test edit survey 'Reports' tab contents.")
	public void testReportsTabContents() {
		this.goToSurvey(0);
		this.surveyHeaderPage.clickReportsTab();
		this.reportsTabPage.waitForPageLoad();
		Assert.assertTrue(this.surveyHeaderPage.reportsTabIsSelected(), "Reports tab should appear selected.");
	}

	@Test(description = "Test edit survey 'Reports' tab pdf report link.")
	public void testPdfReport() {
		this.goToSurvey(0);

		this.surveyHeaderPage.clickReportsTab();
		this.reportsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("reportIframe"); // switch to frame

		this.reportsTabPage.clickPdfReportViewerIcon();

		this.reportsTabPage.waitForNumberOfWindowsToBe(2);
		this.reportsTabPage.switchToNewWindow();
		this.pdfReportPage.waitForPageLoad();

		Assert.assertTrue(pdfReportPage.getCurrentUrl().contains("_report"), "URL should contain '_report'.");
		Assert.assertTrue(pdfReportPage.getCurrentUrl().contains("format=pdf"), "URL should contain 'format=pdf'.");

		this.pdfReportPage.closeWindow();
		this.pdfReportPage.waitForNumberOfWindowsToBe(1);
		this.reportsTabPage.switchToNewWindow();
	}

	@Test(description = "Test edit survey 'Reports' tab XLS report link.")
	public void testXlsReport() {
		this.goToSurvey(0);

		this.surveyHeaderPage.clickReportsTab();
		this.reportsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("reportIframe");

		this.reportsTabPage.clickXlsReportViewerIcon();

		this.reportsTabPage.waitForNumberOfWindowsToBe(2);
		this.reportsTabPage.switchToNewWindow();

		// assert xls report download not possible?

		this.reportsTabPage.closeWindow();
		this.reportsTabPage.waitForNumberOfWindowsToBe(1);
		this.reportsTabPage.switchToNewWindow();
	}
}
