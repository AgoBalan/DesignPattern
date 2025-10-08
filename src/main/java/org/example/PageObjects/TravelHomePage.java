package org.example.PageObjects;

import org.example.AbstractComponent.PageFactory;
import org.example.AbstractComponent.SearchFlight;
import org.example.PageComponents.FooterNavigationBar;
import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.NavigationBar;
import org.example.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.time.Duration;
import java.util.HashMap;

public class TravelHomePage {
    // This is the main page from here user can navigate to other pages.Single page responsibility principle.
    private WebDriver driver;
    By sectionElement= By.id("traveller-home");
    By topSectionElement= By.xpath("//div[@class='search-buttons-heading']");

    SearchFlight searchFlight;
    String type;


    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
       // WebDriver driver = DriverManager.getDriver();
        System.out.println("Travel start");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Travel end");

    }
    public void goToGoogle(int i) throws InterruptedException {
      // WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        System.out.println("Google start, Thread: "+i);
        Thread.sleep(2000);
        System.out.println("Google end , Thread: "+i);
    }


    public NavigationBar getNavigationBar() {
        System.out.println("Welcome to the Travel Home Page!");
        return new NavigationBar(driver,topSectionElement);
    }
    public FooterNavigationBar getFooterNavigation() {
        System.out.println("Welcome to the Travel Home Page!");
        return new FooterNavigationBar(driver, sectionElement);
    }

    public MultiTrip getMultiTrip() {
        By secElement= By.id("flightSearchContainer");
        return new MultiTrip(driver, secElement);
    }
    public RoundTrip getRoundTrip() {
        By secElement= By.id("flightSearchContainer");
        return new RoundTrip(driver, secElement);
    }

    public void setBookingStrategy(SearchFlight implementedClassObject){
        this.searchFlight = implementedClassObject;
    }

    public void setBookingStrategyWithPageFactory(String type){

        PageFactory pageFactory = new PageFactory(driver);
        this.searchFlight =  pageFactory.createInstance(type);
    }


    public void bookFlight(String from, String to){
        searchFlight.checkFlightAvailability(from,to);
    }

    public void bookFlight(HashMap<String,String> reservationDetails){
        searchFlight.checkFlightAvailability2(reservationDetails);
    }
}
