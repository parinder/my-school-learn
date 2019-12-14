package com.gms.tests.pmscenter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gms.pages.pmscenter.PmsRequestPage;
import com.gms.pages.propertymanager.HeaderPage;
import com.gms.pages.propertymanager.PropertyManagerPage;
import com.gms.pages.propertymanager.PropertyManagerPropertyPage;
import com.gms.tests.BaseFunctionalTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatePropertyTest extends BaseFunctionalTest {

    protected PmsRequestPage pmsCenterPmsRequestPage;
    protected HeaderPage propertyManagerHeaderPage;
    protected PropertyManagerPage propertyManagerPage;
    protected PropertyManagerPropertyPage propertyPage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.pmsCenterPmsRequestPage = new PmsRequestPage(this.driver, config);
        this.propertyManagerHeaderPage = new HeaderPage(this.driver, config);
        this.propertyManagerPage = new PropertyManagerPage(this.driver, config);
        this.propertyPage = new PropertyManagerPropertyPage(this.driver, config);
        this.login(this.defaultUsername, this.defaultPassword);
    }

    @Test(description = "Create new property.")
    public void testCreateNewProperty() {
        String newTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String newPropertyName = "Test New Property " + newTimeStamp;

        this.propertyManagerPage.get();
        this.propertyManagerPage.waitForPageLoad();

        this.propertyManagerPage.clickNewPropertyButton();
        this.propertyPage.waitForPageLoad();

        this.driver.switchTo().frame("propertyIFrame");
        this.propertyPage.enterName(newPropertyName);
        this.propertyPage.clickSaveButton();
        this.driver.switchTo().defaultContent();
        this.propertyPage.waitForToastMessageToBeVisible();

        this.propertyManagerPage.get();
        this.propertyManagerPage.waitForPageLoad();
        this.propertyManagerPage.clickPropertyDropdown();
        this.propertyManagerPage.enterPropertyDropdownSearch(newPropertyName);
        Assert.assertEquals(this.propertyManagerPage.getPropertyDropdownListRowCount().intValue(), 1,
                "Should be only one result in property dropdown results list after searching for: " + newPropertyName);
        Assert.assertEquals(this.propertyManagerPage.getPropertyDropdownListRowName(0), newPropertyName,
                "Should be " + newPropertyName + " in property dropdown result list row.");
    }
}