package com.myschool.learn.gms.tests.addressbook.filters;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.myschool.learn.gms.pages.addressbook.FiltersHomePage;
import com.myschool.learn.gms.pages.addressbook.FiltersListPage;

import com.myschool.learn.gms.tests.BaseFunctionalTest;

public class BaseFiltersTest extends BaseFunctionalTest {

        protected FiltersHomePage filtersHomePage;
        protected FiltersListPage filtersListPage;

        @BeforeClass
        public void setup() throws IOException {
                super.setup();
                this.filtersHomePage = new FiltersHomePage(this.driver, config);
                this.filtersListPage = new FiltersListPage(this.driver, config);
        }

        public String getFilterCount(String filterName) {
                this.filtersHomePage.get();
                this.filtersListPage.waitForPageLoad();
                this.filtersListPage.enterFiltersSearchInput(filterName);
                this.filtersListPage.clickFiltersTableRowIconRefresh(0);
                return this.filtersListPage.getListOfFiltersTableRowFilterCount(0);
        }

        public void assertFilterCountEquals(String filterName, String expectedFilterCount) {
                Assert.assertEquals(this.getFilterCount(filterName), expectedFilterCount,
                                "Count for filter '" + filterName + "' should be " + expectedFilterCount + ".");
        }

        public void assertFilterCountIsGreaterThan(String filterName, int expectedFilterCount) {
                Assert.assertTrue(Integer.parseInt(this.getFilterCount(filterName)) > expectedFilterCount, "Filter should have count > " + expectedFilterCount + ".");

        }
}