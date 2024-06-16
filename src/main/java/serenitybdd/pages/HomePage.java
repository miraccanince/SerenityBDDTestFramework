package serenitybdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends BasePage {

    @FindBy(linkText = "My Account")
    private WebElement myAccountLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMyAccount() {
        myAccountLink.click();
    }
    // Method to verify if the homepage is loaded
    public boolean isHomePageLoaded() {
        return myAccountLink.isDisplayed();
    }
    public String getHomePageTitle() {
        return driver.getTitle();
    }


}
