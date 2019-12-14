package com.myschool.learn.gms.tests.addressbook.filters;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilterCountTest extends BaseFiltersTest {

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.login(this.defaultUsername, this.defaultPassword);
    }

    @Test(description = "Test Birth Month filter count.")
    public void testBirthMonthFilterCount() {
        this.assertFilterCountEquals("Birth Month : January", "1");
    }

    @Test(description = "Test City filter count.")
    public void testCityFilterCount() {
        this.assertFilterCountIsGreaterThan("City : Ottawa", 110);
    }

    @Test(description = "Test Most Visited Property filter count.")
    public void testMostVisitedPropertyFilterCount() {
        this.assertFilterCountEquals("MVP : Property 4", "9");
    }

    @Test(description = "Test State/Province filter count.")
    public void testStateProvinceFilterCount() {
        this.assertFilterCountEquals("State/Province : Alaska", "0");
    }
}