package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 04.04.2018.
 */
public class RegisterPage {

    final WebDriver driver;

    @FindBy(id = "email")
    public static WebElement email;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(id = "passwordConfirmation")
    public static WebElement passwordConfirmation;

    @FindBy(css = "#consentRegulations-lot-checkbox > span")
    public static WebElement confirm;



    public RegisterPage(WebDriver driver){

        this.driver = driver;
    }

}
