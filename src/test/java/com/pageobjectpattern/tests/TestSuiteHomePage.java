package com.pageobjectpattern.tests;

import com.pageobjectpattern.pages.BasePage;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;


public class TestSuiteHomePage extends BasePage {

    public void setUp(){
        super.setUp();
    }

    @Test
    public void findSelectedFlightTest() {
        homePage.flightButton();
        homePage.originTextBoxField("Warsaw, Poland (WAW-Frederic Chopin)");
        homePage.destinationTextBoxField("Moscow, Russia (SVO-Sheremetyevo)");
        homePage.departureDate(27);
        homePage.returnDate(20);
        homePage.addHotel();
        homePage.setAdvancedOptions();
        homePage.setPredefinedAirline("Air Canada");
        homePage.searchButtonFlight();
        assertNotNull(utilities.waitForElement(resultsFlightsPage.headerLogo(), 20));
    }

    @Test
    public void flightCannotBeFoundTooGenericAirportNamesAlertTest(){
        homePage.flightButton();
        homePage.originTextBoxField("Warsaw");
        homePage.destinationTextBoxField("Moscow");
        homePage.departureDate(27);
        homePage.returnDate(20);
        homePage.addHotel();
        homePage.setAdvancedOptions();
        homePage.setPredefinedAirline("Japan Airlines");
        homePage.searchButtonFlight();
        assertEquals(utilities.waitForElement(resultsFlightsPage.alertMessage(), 20).getText(),
                "Looks like we need a bit more information.");
    }

    @Test
    public void findHotelTest(){
        homePage.hotelsButton();
        homePage.destinationPlaceName("New York");
        homePage.hotelCheckInDate(28);
        homePage.hotelCheckOutDate(1);
        homePage.searchButtonHotel();
        assertNotNull(utilities.waitForElement(resultsFlightsPage.headerLogo(), 20));
    }

    public void tearDown() throws IOException {
        utilities.screenshot();
        super.tearDown();
    }
}
