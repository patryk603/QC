package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by PTeledzinski on 06.08.2018.
 */
public class MMBPage {

    final WebDriver driver;

    @FindBy(css = ".confirmation-your-ticket-code strong")
    public static WebElement MMBNumber;



    public MMBPage(WebDriver driver){

        this.driver = driver;
    }

}
