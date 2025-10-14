package org.example.PageComponents.FacadeDesignPages;

import org.example.AbstractComponent.AbstractComponent;
import org.example.PageLocators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginPageLocators {
    private WebDriver driver;
    ///One minus of using @findBY is that we cant use the Abstractcompjnet class where we written our own click methods, need to use default selenium methods

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes inherited @FindBy fields
    }

    public void goTo() {
        driver.get("https://yourapp.com/login");
    }

    public void enterUsername(String username) {
        (usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submit() {
        loginButton.click();
    }
}
