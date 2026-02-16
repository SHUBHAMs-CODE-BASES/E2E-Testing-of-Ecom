package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(id = "gender-male")
    WebElement genderMale;

    @FindBy(id = "FirstName")
    WebElement firstNameInput;

    @FindBy(id = "LastName")
    WebElement lastNameInput;

    @FindBy(name = "DateOfBirthDay")
    WebElement dayDrp;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthDrp;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearDrp;

    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(id = "Password")
    WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(className = "result")
    WebElement successMessage;

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void registerUser(String fName, String lName, String email, String password) {
        genderMale.click();
        firstNameInput.sendKeys(fName);
        lastNameInput.sendKeys(lName);

        // Select Date of Birth (Optional - using defaults or random for now example)
        new Select(dayDrp).selectByValue("10");
        new Select(monthDrp).selectByValue("6");
        new Select(yearDrp).selectByValue("1990");

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        registerButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
