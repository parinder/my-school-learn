package com.gms.tests.formscenter;

import java.io.IOException;
import com.gms.pages.formscenter.ThankYouPreviewPage;
import com.gms.pages.formscenter.PdfReportPage;
import com.gms.pages.formscenter.SurveyRenderPage;
import com.gms.pages.formscenter.survey.ReportsTabPage;
import com.gms.pages.formscenter.survey.SettingsTabPage;
import com.gms.pages.formscenter.survey.SurveyPagesTabPage;
import com.gms.pages.formscenter.survey.ThankYouPagesTabPage;
import com.gms.pages.formscenter.surveylist.ListOfSurveysTabPage;
import com.gms.pages.formscenter.surveylist.UpgradeFormsTabPage;
import com.gms.pages.formscenter.surveylist.QuestionManagerTabPage;
import com.gms.pages.formscenter.surveylist.KpisTabPage;
import com.gms.tests.BaseFunctionalTest;
import org.testng.annotations.BeforeClass;

public class BaseFormsCenterTest extends BaseFunctionalTest {

	protected com.gms.pages.formscenter.survey.HeaderPage surveyHeaderPage;
	protected ReportsTabPage reportsTabPage;
	protected SettingsTabPage settingsTabPage;
	protected SurveyPagesTabPage surveyPagesTabPage;
	protected ThankYouPagesTabPage thankYouPagesTabPage;

	protected SurveyRenderPage surveyRenderPage;
	protected ThankYouPreviewPage thankYouPreviewPage;
	protected PdfReportPage pdfReportPage;

	protected com.gms.pages.formscenter.surveylist.HeaderPage surveyListheaderPage;
	protected ListOfSurveysTabPage listOfSurveysTabPage;
	protected UpgradeFormsTabPage upgradeFormsTabPage;
	protected QuestionManagerTabPage questionManagerTabPage;
	protected KpisTabPage kpisTabPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();

		this.surveyHeaderPage = new com.gms.pages.formscenter.survey.HeaderPage(this.driver, config);
		this.reportsTabPage = new ReportsTabPage(this.driver, config);
		this.settingsTabPage = new SettingsTabPage(this.driver, config);
		this.surveyPagesTabPage = new SurveyPagesTabPage(this.driver, config);
		this.thankYouPagesTabPage = new ThankYouPagesTabPage(this.driver, config);

		this.surveyRenderPage = new SurveyRenderPage(this.driver, config);
		this.thankYouPreviewPage = new ThankYouPreviewPage(this.driver, config);
		this.pdfReportPage = new PdfReportPage(this.driver, config);

		this.surveyListheaderPage = new com.gms.pages.formscenter.surveylist.HeaderPage(this.driver, config);
		this.listOfSurveysTabPage = new ListOfSurveysTabPage(this.driver, config);
		this.upgradeFormsTabPage = new UpgradeFormsTabPage(this.driver, config);
		this.questionManagerTabPage = new QuestionManagerTabPage(this.driver, config);
		this.kpisTabPage = new KpisTabPage(this.driver, config);
	}

	public void goToSurvey(Integer index) {
		this.listOfSurveysTabPage.get();
		this.listOfSurveysTabPage.waitForLoadingModalIsInvisible();
		this.listOfSurveysTabPage.waitForPageLoad();
		this.listOfSurveysTabPage.clickSurveyListRowName(index);
		this.surveyHeaderPage.waitForPageLoad();
		this.surveyPagesTabPage.waitForPageLoad();
	}
}
