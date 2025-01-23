package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(css = "a.account span")
    private WebElement accountField;

    @FindBy(css = "p.alert-success")
    private WebElement successMessage;

    @FindBy(css = "a.logout")
    private WebElement logoutButton;

    @FindBy(css = "p.info-account")
    private WebElement infoAccountMessage;

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }

    public String getAccountName() {
        return getText(accountField);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public void logout() {
        click(logoutButton);
    }

    public String getInfoAccountMessage() {
        return getText(infoAccountMessage);
    }
}
