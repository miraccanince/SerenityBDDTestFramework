package serenitybdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/serenitybdd/features",
        glue = "serenitybdd.steps",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner {
    @Managed(driver = "chrome")
    public static WebDriver chromeDriver;

    @Managed(driver = "firefox")
    public static WebDriver firefoxDriver;

    @Managed(driver = "edge")
    public static WebDriver edgeDriver;

    static {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");

        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
        edgeDriver = new EdgeDriver();
    }
}
