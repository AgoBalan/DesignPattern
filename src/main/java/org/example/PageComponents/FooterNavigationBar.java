package org.example.PageComponents;

import org.example.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigationBar extends AbstractComponent {
    WebDriver driver;

    public FooterNavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        this.driver = driver;
    }

    By flights =  By.xpath("//a/span[@text()='Flights']");

     public void setFlights() {
         try{
         findElement(flights).click();
            }catch (Exception e){
                System.out.println("Exception occurred while clicking on Flights: " + e.getMessage());
            }
     }
}
