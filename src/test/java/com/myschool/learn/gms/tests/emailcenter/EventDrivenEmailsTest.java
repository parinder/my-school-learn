package com.myschool.learn.gms.tests.emailcenter;

import java.io.IOException;
import com.myschool.learn.gms.pages.emailcenter.EventDrivenEmailsTabPage;
import com.myschool.learn.gms.pages.emailcenter.HeaderPage;
import com.myschool.learn.gms.tests.BaseFunctionalTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventDrivenEmailsTest extends BaseFunctionalTest {

	protected EventDrivenEmailsTabPage eventDrivenEmailsTabPage;
	protected HeaderPage headerPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.headerPage = new HeaderPage(this.driver, config);
		this.eventDrivenEmailsTabPage = new EventDrivenEmailsTabPage(this.driver, config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Verify event driven emails tab folder contents.")
	public void testEventDrivenEmailsTabFolderContents() {
		this.homePage.clickEmailCenterImageLink();
		this.headerPage.waitForPageLoad();

		this.driver.switchTo().frame("canvas");
		this.headerPage.clickEventDrivenEmailsTab();
		this.eventDrivenEmailsTabPage.waitForPageLoad();

		this.driver.switchTo().frame("canvas");
		this.driver.switchTo().frame("eventFrame");
		Assert.assertTrue(this.eventDrivenEmailsTabPage.getFolderTableRowCount().intValue() > 0,
				"Folder table should have at least 1 row.");
	}
}