package org.example.AbstractComponent;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    By secElement= By.id("flightSearchContainer");

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlight createInstance(String type){
        if(type.equals("MultiTrip")){
          return   new MultiTrip(driver,secElement);
        } else if (type.equals("RoundTrip")) {
            return   new RoundTrip(driver,secElement);
        }else{
            return null;
        }

    }
}
