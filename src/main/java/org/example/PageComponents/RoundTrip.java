package org.example.PageComponents;

import org.example.AbstractComponent.AbstractComponent;
import org.example.AbstractComponent.SearchFlight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlight {

    private By roundTripElement = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By fromElement = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By toElement = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By army = By.id("ctl00_mainContent_chk_IndArm");
    private By seachButton = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType) {

        System.out.println("RoundTrip booking strategy selected");
    }
    @Override
    public void checkFlightAvailability(String from, String to) {

        System.out.println("Checking roundTrip-city flight availability from " + from + " to " + to);
        click(roundTripElement);
        click(fromElement);
        selectOriginCity(from);
        click(toElement);
        selectDestCity(to);
        click(army);
        click(seachButton);
    }
    public void checkFlightAvailability2(HashMap<String,String> reservationData) {

        System.out.println("Checking roundTrip-city flight availabil");
    }

    public void selectOriginCity(String origin) {
        click(fromElement);
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }
    public void selectDestCity(String origin) {
        click(fromElement);
        findElement(By.xpath("(//a[@value='" + origin + "'])[2]")).click();
    }
}
