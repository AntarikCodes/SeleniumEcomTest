package Testcase;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pageEvents.*;

import java.io.IOException;

public class addProducts extends BaseClass {
    loginPageEvents loginPage= new loginPageEvents();
    productsPageEvents productsPage = new productsPageEvents();
    cartPageEvents cart = new cartPageEvents();
    checkoutPageEvents checkout = new checkoutPageEvents();
    overviewPageEvents overviewPage= new overviewPageEvents();
    orderPageEvents order= new orderPageEvents();

    @Test
    public void addProduct() throws IOException {
        logger.log(Status.INFO, "Verifying login page...");
        loginPage.verifyLoginPage();

        logger.log(Status.INFO, "Logging in ");
        loginPage.login();

        logger.log(Status.INFO, "Verifying Products page...");
        productsPage.verifyProductsPage();

        logger.log(Status.INFO, "Adding products to cart...");
        productsPage.backpackAdd();
        productsPage.fleeceJacketAdd();
        productsPage.bikeLightAdd();
        productsPage.boltTshirtAdd();
        productsPage.cart();

        logger.log(Status.INFO, "Verifying cart page...");
        cart.verifyCartPage();

        logger.log(Status.INFO, "Proceeding to checkout...");
        cart.proceedToCheckout();

        logger.log(Status.INFO,"Entering details");
        checkout.verifyCheckoutPage();
        checkout.addDetails();
        logger.log(Status.INFO, "Proceeding to overview page...");

        overviewPage.verifyOverviewPage();
        overviewPage.totalPrice();
        overviewPage.clickFinish();
        logger.log(Status.INFO, "Proceeding to order success page...");

        order.verifyOrder();
    }
}
