package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 16.05.2018.
 */
public class FlightsPage {

    final WebDriver driver;

    @FindBy(css = ".row-group.jsOfferSection[id*=\"Ida\"][class*=\"row-group jsOfferSection\"]:not([style*=\"display: none\"])")
    public static WebElement FirstTO;

    @FindBy(css = ".row-group.jsOfferSection[id*=\"Vuelta\"][class*=\"row-group jsOfferSection\"]:not([style*=\"display: none\"])")
    public static WebElement FirstBack;

    @FindBy(css = ".nr-cart--buttons--tablet>button")
    public static WebElement SmallContinue;

    @FindBy(css = ".nr-cart--buttons>button")
    public static WebElement BigContinue;





    public FlightsPage(WebDriver driver){

        this.driver = driver;
    }

}
