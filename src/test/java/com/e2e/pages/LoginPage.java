package com.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(id = "Password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'message-error')]")
    WebElement errorMessage;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Log out")
    WebElement logoutLink;

    @FindBy(linkText = "Forgot password?")
    WebElement forgotPasswordLink;

    public void clickLoginLink() {
        loginLink.click();
    }

    public void login(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isLogoutLinkDisplayed() {
        try {
            return logoutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        if (isLogoutLinkDisplayed()) {
            logoutLink.click();
        }
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }
}
