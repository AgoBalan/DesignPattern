package org.example.PageComponents.FacadeDesignPages;

import org.example.AbstractComponent.FacadeAbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage  extends FacadeAbstractComponent {
    private WebDriver driver;

    private By confirmationMessage = By.id("confirmation");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyPaymentSuccess() {
        String message = "";
        click(confirmationMessage);
        if (!message.contains("Thank you")) {
            throw new AssertionError("Payment confirmation not found.");
        }
    }
}
