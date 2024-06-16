package serenitybdd.pages;

import net.thucydides.core.pages.PageFactory;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends PageObject {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }

}
