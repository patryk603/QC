package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 04.04.2018.
 */
public class LoginPage {

    final WebDriver driver;

    @FindBy(id = "login")
    public static WebElement email;

    @FindBy(id = "pass")
    public static WebElement password;

    @FindBy(css = "#login > div:nth-child(1) > div:nth-child(3) > a")
    public static WebElement register;




    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

}
