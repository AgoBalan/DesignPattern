package org.example.PageComponents;

import org.example.AbstractComponent.AbstractComponent;
import org.example.AbstractComponent.SearchFlight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlight {
    private By multitripMsgOkButton = By.id("MultiCityModelAlert");
    private By multiTripElement = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By fromElement = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By toElement = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By seachButton = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void checkFlightAvailability(String from, String to) {
        System.out.println("Checking roundTrip-city flight availability from " + from + " to " + to);
        /**************Without execute around pattern
        *click(multiTripElement);
        *click(multitripMsgOkButton);
        *selectOriginCity(from);
        **********************************************/
        //With execute around pattern
        makeStateReady(x->selectOriginCity(from)); // lambda expression

        selectDestCity(to);
        /*As per abstract contract this method has to deal only parameterized values
        But multi trip has to have multiple destination, So we hard  code BLR
        Thus breaking the contract
        */
        selectDestCity2("BLR");

        //Checkavailability2 method is gid with hashmap wihtout breaking the contract
        click(seachButton);
    }

    public void checkFlightAvailability2(HashMap<String,String> reservationData) {
        makeStateReady(x->selectOriginCity(reservationData.get("from"))); // lambda expression
        selectDestCity(reservationData.get("to"));
        selectDestCity2(reservationData.get("to2"));
        click(seachButton);
    }

    public void selectOriginCity(String origin) {
        click(fromElement);
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }
    public void selectDestCity(String origin) {
        click(fromElement);
        findElement(By.xpath("(//a[@value='" + origin + "'])[1]")).click();
    }
    public void selectDestCity2(String origin) {
        click(fromElement);
        findElement(By.xpath("(//a[@value='" + origin + "'])[2]")).click();
    }
    public void makeStateReady(Consumer<MultiTrip> consumer){
        //prereequisite steps to make the state ready
        click(multiTripElement);
        click(multitripMsgOkButton);
        waitForElementToDispppear(multitripMsgOkButton);
        //consumer.selectDestCity(this); // makeStateready only for selectDestineyMethod
        consumer.accept(this); // accepts any method inside teh class
    }
}
