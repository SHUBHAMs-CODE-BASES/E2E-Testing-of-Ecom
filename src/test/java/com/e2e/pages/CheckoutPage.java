package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Billing Address
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryDropdown;

    @FindBy(id = "BillingNewAddress_City")
    WebElement cityInput;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1Input;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipInput;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneInput;

    @FindBy(xpath = "//button[@onclick='Billing.save()']")
    WebElement billingContinueButton;

    // Shipping Method
    @FindBy(xpath = "//button[@onclick='ShippingMethod.save()']")
    WebElement shippingMethodContinueButton;

    // Payment Method
    @FindBy(xpath = "//button[@onclick='PaymentMethod.save()']")
    WebElement paymentMethodContinueButton;

    // Payment Info
    @FindBy(xpath = "//button[@onclick='PaymentInfo.save()']")
    WebElement paymentInfoContinueButton;

    // Confirm Order
    @FindBy(xpath = "//button[@onclick='ConfirmOrder.save()']")
    WebElement confirmOrderButton;

    @FindBy(tagName = "h1")
    WebElement thankYouHeader;

    @FindBy(xpath = "//button[contains(@class,'order-completed-continue-button')]")
    WebElement orderCompletedContinueButton;

    public void enterBillingAddress(String country, String city, String address, String zip, String phone) {
        // Only if new address form is visible, otherwise just click continue
        try {
            Select countrySelect = new Select(countryDropdown);
            countrySelect.selectByVisibleText(country);
            cityInput.sendKeys(city);
            address1Input.sendKeys(address);
            zipInput.sendKeys(zip);
            phoneInput.sendKeys(phone);
        } catch (Exception e) {
            // Element might not be interactable if pre-filled
        }
        billingContinueButton.click();
    }

    public void clickShippingMethodContinue() {
        shippingMethodContinueButton.click();
    }

    public void clickPaymentMethodContinue() {
        paymentMethodContinueButton.click();
    }

    public void clickPaymentInfoContinue() {
        paymentInfoContinueButton.click();
    }

    public void clickConfirmOrder() {
        confirmOrderButton.click();
    }

    public String getThankYouText() {
        return thankYouHeader.getText();
    }
}
