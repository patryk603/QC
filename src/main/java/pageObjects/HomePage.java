package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PTeledzinski on 04.04.2018.
 */
public class HomePage {

    final WebDriver driver;


    @FindBy(xpath = "//*[@id='menu-settings']/a/span")
    public static WebElement zalogujsie;





    public HomePage(WebDriver driver){

        this.driver = driver;
    }

}
