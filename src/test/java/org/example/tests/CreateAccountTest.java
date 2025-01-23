package org.example.tests;

import com.github.javafaker.Faker;
import org.example.base.BaseTest;
import org.example.pages.CreateAccountPage;
import org.example.pages.HomePage;
import org.example.pages.SignInPage;
import org.testng.annotations.Test;

import static org.example.enums.ExceptionEnum.*;
import static org.example.enums.TextEnum.*;
import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {

    @Test
    public void testCreateAccountWithBlankEmail() {
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.clickSignIn();
        createAccountPage.clickCreateAccount();
        String errorMessage = createAccountPage.getErrorMessage();

        assertEquals(INVALID_EMAIL_ADDRESS.getException(), errorMessage);
    }

    @Test
    public void testCreateAccountWithValidEmail() {
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        SignInPage signInPage = new SignInPage(driver);

        Faker faker = new Faker();
        String validEmail = faker.internet().emailAddress();

        homePage.clickSignIn();
        createAccountPage.typeEmailAddress(validEmail);
        createAccountPage.clickCreateAccount();

        createAccountPage.waitForAccountCreationPage();

        String heading = createAccountPage.getPageHeading();

        assertEquals(CREATE_ACCOUNT.getText(), heading);
    }
}
