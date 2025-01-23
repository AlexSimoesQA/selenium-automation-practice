package org.example.tests;

import com.github.javafaker.Faker;
import org.example.base.BaseTest;
import org.example.pages.CreateAccountPage;
import org.example.pages.HomePage;
import org.example.pages.PersonalInformationPage;
import org.example.pages.SignInPage;
import org.testng.annotations.Test;

import static org.example.enums.TextEnum.*;
import static org.example.utils.StaticValue.*;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        SignInPage signInPage = new SignInPage(driver);

        Faker faker = new Faker();
        String validEmail = faker.internet().emailAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String name = firstName + " " + lastName;

        homePage.clickSignIn();
        createAccountPage.typeEmailAddress(validEmail);
        createAccountPage.clickCreateAccount();

        createAccountPage.waitForAccountCreationPage();

        String heading = createAccountPage.getPageHeading();

        assertEquals(CREATE_ACCOUNT.getText(), heading);

        assertEquals(validEmail, personalInformationPage.getEmailValue());
        personalInformationPage.selectTitle(MR);
        personalInformationPage.enterFirstName(firstName);
        personalInformationPage.enterLastName(lastName);
        personalInformationPage.enterPassword(PASSWORD);
        personalInformationPage.selectDateOfBirth("15", "5", "1990");
        personalInformationPage.subscribeToNewsletter();

        personalInformationPage.clickRegister();

        signInPage.getAccountName();

        signInPage.logout();

        signInPage.login(validEmail, PASSWORD);
        String accountName = signInPage.getAccountName();
        String infoAccountMessage = signInPage.getInfoAccountMessage();
        assertEquals(name, accountName);
        assertEquals(infoAccountMessage, INFO_ACCOUNT_MESSAGE.getText());
    }
}
