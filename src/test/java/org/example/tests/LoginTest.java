package org.example.tests;

import com.github.javafaker.Faker;
import org.example.base.BaseTest;
import org.example.pages.CreateAccountPage;
import org.example.pages.HomePage;
import org.example.pages.SignInPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        SignInPage signInPage = new SignInPage(driver);

        Faker faker = new Faker();
        String validEmail = faker.internet().emailAddress();

        homePage.clickSignIn();

        createAccountPage.typeEmailAddress(validEmail);
        createAccountPage.clickCreateAccount();
        signInPage.login("test@example.com", "password");
    }
}
