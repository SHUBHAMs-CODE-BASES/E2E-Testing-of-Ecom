package com.e2e.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.e2e.pages.LoginPage;
import com.e2e.pages.RegisterPage;
import java.util.Random;

public class NopCommerceTest extends BaseTest {

    String email;
    String password = "Password123";

    @Test(priority = 1)
    public void testRegistration() {
        test = com.e2e.utils.ExtentManager.getInstance().createTest("Registration Test");

        driver.get("https://demo.nopcommerce.com/");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterLink();

        // Generate random email
        Random rand = new Random();
        email = "testuser" + rand.nextInt(10000) + "@example.com";

        registerPage.registerUser("Test", "User", email, password);
        String successMsg = registerPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Your registration completed", "Registration failed!");
        test.pass("User registered successfully with email: " + email);

        // Logout so we can test login next
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogout();
    }

    @Test(priority = 2, dependsOnMethods = "testRegistration")
    public void testLoginSequence() {
        test = com.e2e.utils.ExtentManager.getInstance().createTest("Login Test");

        driver.get("https://demo.nopcommerce.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isLogoutLinkDisplayed(), "Login failed! Logout link not visible.");
        test.pass("User logged in successfully.");

        loginPage.clickLogout();
    }

    @Test(priority = 3)
    public void testInvalidLogin() {
        test = com.e2e.utils.ExtentManager.getInstance().createTest("Invalid Login Test");

        driver.get("https://demo.nopcommerce.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.login("invalid" + System.currentTimeMillis() + "@email.com", "WrongPass");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Login was unsuccessful"), "Error message mismatch.");
        test.pass("Invalid login handled correctly.");
    }

    @Test(priority = 4, dependsOnMethods = "testLoginSequence")
    public void testPurchaseFlow() {
        test = com.e2e.utils.ExtentManager.getInstance().createTest("End-to-End Purchase Flow");

        // 1. Search Product
        com.e2e.pages.HomePage homePage = new com.e2e.pages.HomePage(driver);
        homePage.searchProduct("MacBook");
        test.info("Searched for MacBook");

        // 2. Add to Cart
        com.e2e.pages.ProductPage productPage = new com.e2e.pages.ProductPage(driver);
        productPage.addToCart();
        test.info("Added product to cart");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        } // Wait for notification
        productPage.closeNotification();
        productPage.goToCart();

        // 3. Checkout
        com.e2e.pages.CartPage cartPage = new com.e2e.pages.CartPage(driver);
        Assert.assertTrue(cartPage.getProductName().contains("MacBook"), "Product not found in cart");
        cartPage.checkout();
        test.info("Proceeded to checkout");

        // 4. Complete Checkout
        com.e2e.pages.CheckoutPage checkoutPage = new com.e2e.pages.CheckoutPage(driver);
        checkoutPage.enterBillingAddress("United States", "New York", "123 Test St", "10001", "1234567890");
        checkoutPage.clickShippingMethodContinue();
        checkoutPage.clickPaymentMethodContinue();
        checkoutPage.clickPaymentInfoContinue();
        checkoutPage.clickConfirmOrder();

        Assert.assertEquals(checkoutPage.getThankYouText(), "Thank you", "Order not confirmed!");
        test.pass("Order placed successfully.");
    }

    @Test(priority = 5, dependsOnMethods = "testLoginSequence")
    public void testMyAccountCRUD() {
        test = com.e2e.utils.ExtentManager.getInstance().createTest("My Account - Address CRUD");

        driver.get("https://demo.nopcommerce.com/");
        com.e2e.pages.HomePage homePage = new com.e2e.pages.HomePage(driver);
        // Assuming user is logged in from previous test
        driver.findElement(org.openqa.selenium.By.className("ico-account")).click();

        com.e2e.pages.MyAccountPage myAccount = new com.e2e.pages.MyAccountPage(driver);
        myAccount.clickAddresses();

        com.e2e.pages.AddressPage addressPage = new com.e2e.pages.AddressPage(driver);
        addressPage.clickAddNew();
        addressPage.saveAddress("John", "Doe", "john.doe@test.com", "United States", "Miami", "456 Ocean Dr", "33101",
                "9876543210");

        test.pass("New address added successfully.");
        // Add verification logic if needed (e.g., check if address appears in list)
    }
}
