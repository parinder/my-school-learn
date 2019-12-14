package com.gms.tests.emailcenter;

import java.io.IOException;

import com.gms.pages.emailcenter.HeaderPage;
import com.gms.pages.emailcenter.TemplatesTabPage;
import com.gms.tests.BaseFunctionalTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TemplatesTest extends BaseFunctionalTest {

	protected TemplatesTabPage templatesTabPage;
	protected HeaderPage headerPage;

	@BeforeClass
	public void setup() throws IOException {
		super.setup();
		this.templatesTabPage = new TemplatesTabPage(this.driver, config);
		this.headerPage = new HeaderPage(this.driver, config);
		this.login(this.defaultUsername, this.defaultPassword);
	}

	@Test(description = "Test templates tab folder contents.")
	public void testTemplatesTabNavigation() {
		this.homePage.clickEmailCenterImageLink();
		this.headerPage.waitForPageLoad();

		this.driver.switchTo().frame("canvas");
		this.headerPage.clickTemplatesTab();
		this.templatesTabPage.waitForPageLoad();

		this.driver.switchTo().frame("canvas");
		Assert.assertFalse(this.headerPage.eventDrivenEmailsTabIsSelected(),
				"Event driven emails tab should not be selected.");

		this.templatesTabPage.waitForPageLoad();

		// assert generic templates contents

		// assert templates contents in main section once some data is added
	}
}