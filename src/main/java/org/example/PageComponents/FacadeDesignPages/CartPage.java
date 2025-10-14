package org.example.PageComponents.FacadeDesignPages;

import org.example.AbstractComponent.AbstractComponent;
import org.example.AbstractComponent.FacadeAbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends FacadeAbstractComponent {
    private WebDriver driver;

    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://yourapp.com/cart");
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }
}
