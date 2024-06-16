package serenitybdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import serenitybdd.pages.HomePage;
import static org.testng.AssertJUnit.assertEquals;


public class HomePageSteps {
    private WebDriver driver;
    private HomePage homePage;

    public HomePageSteps() {
        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver); // Pass driver to the HomePage constructor
    }
    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/");
    }
    @Then("the home page should be loaded successfully")
    public void the_home_page_should_be_loaded_successfully() {

        String expectedTitle = "Automation Practice Site";
        String actualTitle = homePage.getHomePageTitle();
        assertEquals(expectedTitle,actualTitle);

        if (driver!=null){
            driver.quit();
        }
    }
}
