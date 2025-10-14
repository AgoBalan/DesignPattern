package org.example.PageComponents.FacadeDesignPages;

import org.example.AbstractComponent.AbstractComponent;
import org.example.AbstractComponent.FacadeAbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacadeNavigationBar extends FacadeAbstractComponent {

    WebDriver driver;
    public FacadeNavigationBar(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By flights =  By.xpath("//a/span[contains(.,'Flights')]");

    public void setFlights() {
        try {
            findElement(flights).click();
        }catch (Exception e){
            System.out.println("Exception occurred while clicking on Flights: " + e.getMessage());
        }
    }
}
