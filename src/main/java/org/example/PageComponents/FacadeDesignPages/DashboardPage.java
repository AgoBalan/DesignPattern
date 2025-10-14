package org.example.PageComponents.FacadeDesignPages;

import org.example.AbstractComponent.FacadeAbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage  extends FacadeAbstractComponent {
    private WebDriver driver;

    private By welcomeMessage = By.id("welcome");

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyLoginSuccess() {
        String message ="";
        click(welcomeMessage);
        if (!message.contains("Welcome")) {
            throw new AssertionError("Login failed or welcome message not found.");
        }
    }
}
