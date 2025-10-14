package org.example.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageLocators {

    @FindBy(id = "username")
    protected WebElement usernameField;

    @FindBy(id = "password")
    protected WebElement passwordField;

    @FindBy(id = "loginBtn")
    protected WebElement loginButton;
}