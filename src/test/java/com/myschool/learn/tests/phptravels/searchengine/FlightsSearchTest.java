package com.myschool.learn.tests.phptravels.searchengine;

import com.myschool.learn.pages.phptravels.HomePage;
import com.myschool.learn.tests.phptravels.BaseFunctionalTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class FlightsSearchTest extends BaseFunctionalTest {
    protected HomePage homePage;

    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        this.homePage = new HomePage(this.driver, configPhpTravels);
    }

    @Test(description = "Test To Get the Flights Search Fields")
    public void testToGetFlightsSearchFields(){
        this.homePage.get();
        this.homePage.clickSearchFlights();
        this.homePage.flightSearchFormIsVisible();
    }

    @Test(description = "Test To Get the Flights Search Fields")
    public void testToGetFlightsSearchFields1(){
        this.homePage.get();
        this.homePage.clickSearchFlights();
        this.homePage.flightSearchFormIsVisible();
        this.homePage.clickOneWayTrip();
        this.homePage.clickFromCityAirportField();
        this.homePage.enterFromCityAirport("New York");
        this.homePage.clickDepartDateField();


    }
}
