package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalInformationPage extends BasePage {

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    private WebElement titleMr;

    @FindBy(id = "id_gender2")
    private WebElement titleMrs;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement dayDropdown;

    @FindBy(id = "months")
    private WebElement monthDropdown;

    @FindBy(id = "years")
    private WebElement yearDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    // Métodos para interagir com o formulário

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            clickUsingJavaScript(titleMr);
        } else if (title.equalsIgnoreCase("Mrs")) {
            clickUsingJavaScript(titleMrs);
        }
    }

    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    public String getEmailValue() {
        return getInputValue(emailField);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        selectFromDropdownByValue(dayDropdown, day);
        selectFromDropdownByValue(monthDropdown, month);
        selectFromDropdownByValue(yearDropdown, year);
    }

    public void subscribeToNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
            clickUsingJavaScript(newsletterCheckbox);
        }
    }

    public void clickRegister() {
        click(registerButton);
    }
}
