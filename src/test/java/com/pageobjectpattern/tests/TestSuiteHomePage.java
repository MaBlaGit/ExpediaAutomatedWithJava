package com.pageobjectpattern.tests;

import com.pageobjectpattern.pages.BasePage;
import com.pageobjectpattern.utilities.Utilities;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;


public class TestSuiteHomePage extends BasePage {

    private Utilities utilities;

    public void setUp(){
        super.setUp();
        utilities = new Utilities(driver);
    }

    @Test
    public void homePageFlightsTab() {
        homePage.flightButton();
        homePage.originTextBoxField("Chicago");
        homePage.destinationTextBoxField("Denver");
        homePage.departureDate(27);
        homePage.returnDate(20);
        homePage.addHotel();
        homePage.setAdvancedOptions();
        homePage.searchButton();
        assertNotNull(utilities.waitForElement(resultsPage.headerLogo(), 20));
    }

    public void tearDown() throws IOException {
        utilities.screenshot();
        super.tearDown();
    }
}
