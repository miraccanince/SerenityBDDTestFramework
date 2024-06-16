package serenitybdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import serenitybdd.pages.MyAccountPage;
import java.security.SecureRandom;
import java.util.UUID;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class MyAccountPageSteps {

    private WebDriver driver;
    private MyAccountPage myAccountPage;

    public MyAccountPageSteps() {
        this.driver = new ChromeDriver();
        this.myAccountPage = new MyAccountPage(driver);
    }

    @Given("User opens the browser")
    public void user_opens_the_browser() {
        // Browser opening step is handled in the constructor
    }

    @When("User enters the URL {string}")
    public void user_enters_the_url(String url) {
        driver.get(url);
    }

    @When("User clicks on My Account Menu")
    public void user_clicks_on_my_account_menu() {
        myAccountPage.clickMyAccountMenu();
    }

    @When("User enters registered Email Address in Email-Address textbox")
    public void user_enters_registered_email_address_in_email_address_textbox() {
        String generatedEmail = generateUniqueEmail(); // Generate unique email
        myAccountPage.enterEmailAddress(generatedEmail);
    }

    @When("User enters strong password in password textbox")
    public void user_enters_strong_password_in_password_textbox() {
        String password = generateStrongPassword();
        myAccountPage.enterPassword(password);
    }

    private String generateUniqueEmail() {
        return "test" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }


    @When("User enters weak password in password textbox")
    public void user_enters_weak_password_in_password_textbox() {
        String password = "weakpassword";  // Example of a weak password
        myAccountPage.enterPassword(password);
    }

    private String generateStrongPassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[{]}|;:',<.>/?";

        String combinedChars = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Generate a password with a minimum length of 12 characters
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(combinedChars.length());
            password.append(combinedChars.charAt(index));
        }
        return password.toString();
    }

    @When("User clicks on Register button")
    public void user_clicks_on_register_button() {
        myAccountPage.clickRegisterButton();
    }

    @Then("Registration should succeed with strong password")
    public void registration_should_succeed_with_strong_password() {
        assertTrue("Registration not successful", myAccountPage.isRegistrationSuccessful());

        if (driver != null) {
            driver.quit();
        }
    }

    @Then("Registration should fail with weak password")
    public void registration_should_fail_with_weak_password() {
        assertFalse("Registration should fail with weak password", myAccountPage.isRegistrationSuccessful());

        if (driver != null) {
            driver.quit();
        }
    }

}
