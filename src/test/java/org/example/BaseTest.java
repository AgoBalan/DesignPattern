package org.example;

import org.example.Flows.BookingFacade;
import org.example.Flows.LoginFacade;
import org.example.Flows.PaymentFacade;
import org.example.Flows.SearchFacade;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.example.utils.DriverManager;

public class BaseTest {

    protected  WebDriver driver;
    protected TravelHomePage travelHomePage;
    protected BookingFacade bookingFacade;
    protected LoginFacade loginFacade;
    protected PaymentFacade paymentFacade;
    protected SearchFacade searchFacade;

    @BeforeMethod
    public void setup() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Setup");
        driver = DriverManager.getDriver();
        travelHomePage = new TravelHomePage(driver);
        bookingFacade = new BookingFacade(driver);
        loginFacade = new LoginFacade(driver);
        paymentFacade = new PaymentFacade(driver);
        searchFacade = new SearchFacade(driver);
      }

    @AfterMethod()
    public void tearDown(){
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Teardown");
        DriverManager.quitDriver();
    }
}

