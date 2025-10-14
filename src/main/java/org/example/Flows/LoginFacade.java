package org.example.Flows;

import org.example.PageComponents.FacadeDesignPages.LoginPage;
import org.example.PageComponents.FacadeDesignPages.DashboardPage;
import org.openqa.selenium.WebDriver;

public class LoginFacade {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public LoginFacade(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    public void loginAs(String username, String password) {
        loginPage.goTo();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.submit();
        dashboardPage.verifyLoginSuccess();
    }
}
