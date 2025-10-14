package org.example.Flows;

import org.example.PageComponents.*;
import org.example.PageComponents.FacadeDesignPages.FacadeNavigationBar;
import org.example.PageComponents.FacadeDesignPages.FacadeRoundTrip;
import org.example.PageComponents.FacadeDesignPages.LoginPage;
import org.example.PageComponents.FacadeDesignPages.SearchPage;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;

public class BookingFacade {
    private TravelHomePage homePage;
    private FacadeNavigationBar navBar;
    private FooterNavigationBar footer;
    //private FacadeRoundTrip multiTrip;
    private FacadeRoundTrip roundTrip;
    org.example.Factory.FacadePageObjectFactory factory;
    private LoginPage loginPage;;
    private SearchPage searchPage;

    public BookingFacade(WebDriver driver) {
        homePage = new TravelHomePage(driver);
        navBar = homePage.getFacadeNavigationBar();
        roundTrip = homePage.getFacadeRoundTrip();

        /** By implemting PageOject Factory
         factory = new org.example.Factory.FacadePageObjectFactory(driver);
        loginPage = factory.getLoginPage();
        searchPage = factory.getSearchPage(); ***/
    }

    public void bookRoundTrip(String from, String to) {
        homePage.goTo();
        roundTrip.checkFlightAvailability(from,to);

    }

    public void bookMultiTrip(String from, String to) {
        homePage.goTo();
     //   multiTrip.checkFlightAvailability(from, to);
    }
    public void goToGoogle(int i) throws InterruptedException {
        homePage.goToGoogle(i);
    }
}
