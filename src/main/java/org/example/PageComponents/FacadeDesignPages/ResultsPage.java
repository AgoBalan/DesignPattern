package org.example.PageComponents.FacadeDesignPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class ResultsPage {
    private WebDriver driver;

    private By resultItems = By.cssSelector(".result-item");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyResultsDisplayed() {
        List<?> results = driver.findElements(resultItems);
        if (results.isEmpty()) {
            throw new AssertionError("No search results found.");
        }
    }

    public int getResultCount() {
        return driver.findElements(resultItems).size();
    }

    public String getFirstResultText() {
        return driver.findElements(resultItems).get(0).getText();
    }
}
