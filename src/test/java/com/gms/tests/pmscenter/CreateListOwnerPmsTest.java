package com.gms.tests.pmscenter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gms.pages.listownerpms.ListOwnerPmsManagerPage;
import com.gms.pages.listownerpms.ListOwnerPmsCreatePage;
import com.gms.pages.pmscenter.PmsRequestEditPage;
import com.gms.pages.pmscenter.PmsRequestNewPage;
import com.gms.pages.pmscenter.PmsRequestPage;
import com.gms.tests.BaseFunctionalTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateListOwnerPmsTest extends BaseFunctionalTest {

    protected PmsRequestPage pmsCenterPmsRequestPage;
    protected ListOwnerPmsManagerPage listOwnerPmsManagerPage;
    protected ListOwnerPmsCreatePage listOwnerPmsCreatePage;
    protected PmsRequestNewPage pmsRequestNewPage;
    protected PmsRequestEditPage pmsRequestEditPage;
    protected PmsRequestPage pmsRequestPage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.pmsCenterPmsRequestPage = new PmsRequestPage(this.driver, config);
        this.listOwnerPmsManagerPage = new ListOwnerPmsManagerPage(this.driver, config);
        this.listOwnerPmsCreatePage = new ListOwnerPmsCreatePage(this.driver, config);
        this.pmsRequestNewPage = new PmsRequestNewPage(this.driver, config);
        this.pmsRequestEditPage = new PmsRequestEditPage(this.driver, config);
        this.pmsRequestPage = new PmsRequestPage(this.driver, config);
        this.login(this.defaultUsername, this.defaultPassword);
    }

    @Test(description = "Create new List Owner PMS.")
    public void testCreateNewListOwnerPms() {
        this.createListOwnerPmsWithPmsRequest("MICROS (id 8)", "Upgrade");
    }

    public void createListOwnerPmsWithPmsRequest(String pmsType, String pmsRequestType) {
        String newTimeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String newListOwnerPmsName = "Test LOPMS " + newTimeStamp;
        String newPmsRequestName = newListOwnerPmsName + " " + pmsRequestType;
        String newPmsRequestStartDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        this.listOwnerPmsManagerPage.get();
        this.listOwnerPmsManagerPage.waitForPageLoad();

        this.driver.switchTo().frame("canvas");
        this.listOwnerPmsManagerPage.clickNewButton();
        this.driver.switchTo().defaultContent();
        this.listOwnerPmsCreatePage.waitForPageLoad();

        this.driver.switchTo().frame("canvas");
        this.listOwnerPmsCreatePage.enterName(newListOwnerPmsName);
        this.listOwnerPmsCreatePage.selectPmsType(pmsType);

        this.listOwnerPmsCreatePage.clickSaveButton();
        this.driver.switchTo().defaultContent();
        this.pmsRequestNewPage.waitForPageLoad();

        this.pmsRequestNewPage.selectListOwnerDropdownOption(newListOwnerPmsName);
        this.pmsRequestNewPage.waitForPmsRequestNameToContainText(newListOwnerPmsName);

        this.pmsRequestNewPage.selectPmsRequestType(pmsRequestType);
        this.pmsRequestNewPage.waitForPmsRequestNameToContainText(newPmsRequestName);

        this.pmsRequestNewPage.clickSaveButton();
        this.pmsRequestEditPage.waitForPageLoad();

        this.pmsRequestEditPage.enterStartDate(newPmsRequestStartDate);
        this.pmsRequestEditPage.clickName(); // to close date div
        this.pmsRequestEditPage.clickSaveButton();
        this.pmsRequestEditPage.getSuccessAlertMessageText(); // need to assert it?
        this.pmsRequestEditPage.clickSuccessAlertCloseIcon();

        this.pmsRequestPage.get();
        this.pmsRequestPage.waitForPageLoad();
        this.pmsRequestPage.enterPmsRequestSearch(newPmsRequestName);
        Assert.assertTrue(this.pmsRequestPage.getPmsRequestsTableRowCount().intValue() > 0,
                "At least one Pms Request result exists.");

        this.pmsRequestPage.clickDeleteButton(0);
        this.pmsRequestPage.clickConfirmationRequiredModalOkButton();
        this.pmsRequestPage.waitForDialogBoxIsInvisible();
    }
}
