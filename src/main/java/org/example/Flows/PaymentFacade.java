package org.example.Flows;

import org.example.PageComponents.FacadeDesignPages.CartPage;
import org.example.PageComponents.FacadeDesignPages.PaymentPage;
import org.example.PageComponents.FacadeDesignPages.ConfirmationPage;
import org.openqa.selenium.WebDriver;

public class PaymentFacade {
    private CartPage cartPage;
    private PaymentPage paymentPage;
    private ConfirmationPage confirmationPage;

    public PaymentFacade(WebDriver driver) {
        cartPage = new CartPage(driver);
        paymentPage = new PaymentPage(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    public void completePayment(String cardNumber, String expiry, String cvv) {
        cartPage.goTo();
        cartPage.proceedToCheckout();
        paymentPage.enterCardDetails(cardNumber, expiry, cvv);
        paymentPage.submitPayment();
        confirmationPage.verifyPaymentSuccess();
    }
}
