package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement emailField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;

    @FindBy(css = "h1.page-heading")
    private WebElement pageHeading;

    public void typeEmailAddress(String text) {
        type(emailField, text);
    }

    public void clickCreateAccount() {
        click(createAccountButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public String getPageHeading() {
        return getText(pageHeading);
    }

    public void waitForAccountCreationPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("account-creation"));
    }
}
