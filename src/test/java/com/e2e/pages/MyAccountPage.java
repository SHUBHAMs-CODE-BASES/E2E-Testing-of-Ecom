package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Addresses")
    WebElement addressesLink;

    @FindBy(linkText = "Customer info")
    WebElement customerInfoLink;

    @FindBy(linkText = "Orders")
    WebElement ordersLink;

    public void clickAddresses() {
        addressesLink.click();
    }

    public void clickCustomerInfo() {
        customerInfoLink.click();
    }
}
