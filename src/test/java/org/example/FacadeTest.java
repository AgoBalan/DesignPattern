package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FacadeTest extends BaseTest {

    @Test
    public void GooglwithFacetDesign() throws InterruptedException {
        bookingFacade.goToGoogle(2);
    }
    @Test
    public void FacadeRoundTrip() throws InterruptedException {
        bookingFacade.bookRoundTrip("MAA","HYD");
    }

    @Test
    public void testBookingFlow() {
        bookingFacade.bookRoundTrip("NYC", "LAX");
    }

    @Test
    public void testLoginFlow() {
        loginFacade.loginAs("user@example.com", "securePass123");
    }

    @Test
    public void testPaymentFlow() {
        paymentFacade.completePayment("4111111111111111", "12/26", "123");
    }

    @Test
    public void testSearchFlow() {
        searchFacade.searchFor("flights to Tokyo");
    }
 /** Purpose in Framework
    In a test automation framework, the Facade Pattern is used to abstract and
    coordinate multiple Page Object classes and UI components into a single flow-oriented class.
    This allows test cases to express intent without managing low-level interactions.

   🔹 How It’s Implemented
    Each Facade class (e.g., BookingFacade, LoginFacade) encapsulates the logic for a specific business flow.
    It creates and manages relevant Page Object instances internally.
    It exposes high-level methods like bookRoundTrip(), loginAs(), or completePayment() that represent full user journeys.


  🔧 Can You Bring POM into This Design?
  You already have it. But if you want to enhance or formalize it, here’s what you can do:

  ✅ 1. Ensure Each Page Object:
  Has a clear name matching the page it represents
  Encapsulates all locators and actions for that page
  Avoids test logic or flow orchestration

  ✅ 2. Keep Facade Classes Focused on Flows:
  Only use page objects relevant to the flow
  Avoid duplicating page-level logic
  Keep them small and modular (e.g., LoginFacade, SearchFacade)

  ✅ 3. Use a Consistent Package Structure:
  Code
  org.example
  ├── PageObjects       # POM classes
  ├── PageComponents    # Reusable sections (e.g., nav bars)
  ├── Flows             # Facade classes
  ├── Tests             # Test classes


   ***/
  }