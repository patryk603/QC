package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 18.05.2018.
 */
public class PaymentPage {

    final WebDriver driver;

    @FindBy(css = ".custom-select:nth-child(2)>select[id$=title]")
    public static WebElement Continue;

    public PaymentPage(WebDriver driver){

        this.driver = driver;
    }

}
