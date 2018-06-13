package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 18.05.2018.
 */
public class ExtrasPage {

    final WebDriver driver;

    @FindBy(css = ".nr-cart--buttons>button")
    public static WebElement BigContinue;

    @FindBy(id = "ancillaries-content")
    public static WebElement Seats;

    @FindBy(id = "column-1")
    public static WebElement Column1;




    public ExtrasPage(WebDriver driver){

        this.driver = driver;
    }

}
