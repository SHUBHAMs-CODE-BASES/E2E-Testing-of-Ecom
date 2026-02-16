package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "termsofservice")
    WebElement termsOfServiceCheckbox;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "product-name")
    WebElement productNameInCart;

    public String getProductName() {
        return productNameInCart.getText();
    }

    public void checkout() {
        termsOfServiceCheckbox.click();
        checkoutButton.click();
    }
}
