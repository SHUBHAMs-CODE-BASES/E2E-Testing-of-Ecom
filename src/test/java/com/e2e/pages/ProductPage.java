package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.product-name h1")
    WebElement productName;

    @FindBy(id = "add-to-cart-button-4")
    // Note: ID might be dynamic like add-to-cart-button-4 in NopCommerce demo
    // (Apple MacBook Pro 13-inch)
    // For generic implementation we might need dynamic XPath or specific product
    // IDs
    WebElement addToCartButton;

    @FindBy(className = "content")
    WebElement notificationMessage;

    @FindBy(css = "span.close")
    WebElement closeNotification;

    @FindBy(className = "ico-cart")
    WebElement cartLink;

    public String getProductName() {
        return productName.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getNotificationMessage() {
        return notificationMessage.getText();
    }

    public void closeNotification() {
        try {
            closeNotification.click();
            Thread.sleep(1000); // Wait for animation
        } catch (Exception e) {
        }
    }

    public void goToCart() {
        cartLink.click();
    }
}
