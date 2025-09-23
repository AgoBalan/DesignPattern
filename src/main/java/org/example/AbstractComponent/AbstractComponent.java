package org.example.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebElement sectionElement;
    WebDriver driver;

    public  AbstractComponent(WebDriver driver, By sectionElement) {
        this.sectionElement = driver.findElement(sectionElement); // Initialize
        this.driver = driver;
    }
    public WebElement findElement(By findElementsBy) {
        try {
            return sectionElement.findElement(findElementsBy);
        }catch (Exception e){
            System.out.println("Element not found "+ e.getMessage());
            return null;
        }
    }
    public void click(By findElementsBy) {
        findElement(findElementsBy).click();
    }

    public void waitForElementToDispppear(By findElementsBy) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(findElementsBy));

    }

}
