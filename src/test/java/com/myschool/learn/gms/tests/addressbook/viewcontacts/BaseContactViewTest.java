package com.myschool.learn.gms.tests.addressbook.viewcontacts;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import com.myschool.learn.gms.pages.addressbook.ViewContactsPage;
import com.myschool.learn.gms.tests.BaseFunctionalTest;

public class BaseContactViewTest extends BaseFunctionalTest {

    protected ViewContactsPage viewContactsPage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.viewContactsPage = new ViewContactsPage(this.driver, config);
    }

    public void selectDateRange(String startDateMonth, String StartDateDay, String StartDateYear, String endDateMonth,
            String endDateDay, String endDateYear) {

        this.viewContactsPage.selectStartDateMonth(startDateMonth);
        this.viewContactsPage.selectStartDateDay(StartDateDay);
        this.viewContactsPage.selectStartDateYear(StartDateYear);

        this.viewContactsPage.selectEndDateMonth(endDateMonth);
        this.viewContactsPage.selectEndDateDay(endDateDay);
        this.viewContactsPage.selectEndDateYear(endDateYear);
    }
}
