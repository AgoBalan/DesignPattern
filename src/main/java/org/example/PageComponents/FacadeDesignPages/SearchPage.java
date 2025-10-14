package org.example.PageComponents.FacadeDesignPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;

    private By searchInput = By.id("searchBox");
    private By searchButton = By.id("searchBtn");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://yourapp.com/search");
    }

    public void enterSearchTerm(String keyword) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(keyword);
    }

    public void submitSearch() {
        driver.findElement(searchButton).click();
    }
}
