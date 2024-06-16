package serenitybdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MyAccountPage extends BasePage {

    @FindBy(linkText = "My Account")
    private WebElement myAccountMenu;

    @FindBy(id = "reg_email")
    private WebElement emailAddressField;

    @FindBy(id = "reg_password")
    private WebElement passwordField;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout")
    private WebElement logoutLink;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickMyAccountMenu() {
        myAccountMenu.click();
    }

    public void enterEmailAddress(String email) {
        emailAddressField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            // Wait until the logout link is displayed on the page
            return logoutLink.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Registration not successful: " + e.getMessage());
            return false;
        }
    }
}
