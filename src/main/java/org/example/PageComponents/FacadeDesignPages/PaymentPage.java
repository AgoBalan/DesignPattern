package org.example.PageComponents.FacadeDesignPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;

    private By cardNumberField = By.id("cardNumber");
    private By expiryField = By.id("expiry");
    private By cvvField = By.id("cvv");
    private By payButton = By.id("payNow");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCardDetails(String cardNumber, String expiry, String cvv) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(expiryField).sendKeys(expiry);
        driver.findElement(cvvField).sendKeys(cvv);
    }

    public void submitPayment() {
        driver.findElement(payButton).click();
    }
}
