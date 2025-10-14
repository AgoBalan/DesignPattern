package org.example.Flows;

import org.example.PageComponents.FacadeDesignPages.SearchPage;
import org.example.PageComponents.FacadeDesignPages.ResultsPage;
import org.openqa.selenium.WebDriver;

public class SearchFacade {
    private SearchPage searchPage;
    private ResultsPage resultsPage;

    public SearchFacade(WebDriver driver) {
        searchPage = new SearchPage(driver);
        resultsPage = new ResultsPage(driver);
    }

    public void searchFor(String keyword) {
        searchPage.goTo();
        searchPage.enterSearchTerm(keyword);
        searchPage.submitSearch();
        resultsPage.verifyResultsDisplayed();
    }
}
