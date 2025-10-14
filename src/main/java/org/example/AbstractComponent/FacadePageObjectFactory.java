package org.example.Factory;

import org.example.PageComponents.FacadeDesignPages.FacadeRoundTrip;
import org.example.PageComponents.FacadeDesignPages.LoginPage;
import org.example.PageComponents.FacadeDesignPages.SearchPage;
import org.openqa.selenium.WebDriver;

public class FacadePageObjectFactory {
    private WebDriver driver;

    public FacadePageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public FacadeRoundTrip getRoundTripPage() {
        return new FacadeRoundTrip(driver);
    }

    // Add more page object getters here as needed
     public LoginPage getLoginPage() { return new LoginPage(driver); }
     public SearchPage getSearchPage() { return new SearchPage(driver); }

}
