package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

    WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@class,'add-address-button')]")
    WebElement addNewButton;

    @FindBy(id = "Address_FirstName")
    WebElement firstNameInput;

    @FindBy(id = "Address_LastName")
    WebElement lastNameInput;

    @FindBy(id = "Address_Email")
    WebElement emailInput;

    @FindBy(id = "Address_CountryId")
    WebElement countryDropdown;

    @FindBy(id = "Address_City")
    WebElement cityInput;

    @FindBy(id = "Address_Address1")
    WebElement address1Input;

    @FindBy(id = "Address_ZipPostalCode")
    WebElement zipInput;

    @FindBy(id = "Address_PhoneNumber")
    WebElement phoneInput;

    @FindBy(xpath = "//button[contains(@class,'save-address-button')]")
    WebElement saveButton;

    @FindBy(className = "close")
    WebElement closeNotification;

    public void clickAddNew() {
        addNewButton.click();
    }

    public void saveAddress(String fName, String lName, String email, String country, String city, String address,
            String zip, String phone) {
        firstNameInput.clear();
        firstNameInput.sendKeys(fName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lName);
        emailInput.clear();
        emailInput.sendKeys(email);

        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(country);

        cityInput.sendKeys(city);
        address1Input.sendKeys(address);
        zipInput.sendKeys(zip);
        phoneInput.sendKeys(phone);

        saveButton.click();
    }
}
