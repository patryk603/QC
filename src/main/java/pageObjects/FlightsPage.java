package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 16.05.2018.
 */
public class FlightsPage {

    final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"flights-table__table_1\"]/tbody/tr[2]/td[1]")
    public static WebElement FirstTO;

    @FindBy(xpath = "//*[@id=\"flights-table__table_2\"]/tbody/tr[2]/td[1]")
    public static WebElement FirstBack;

    @FindBy(css = ".nr-cart--buttons--tablet>button")
    public static WebElement SmallContinue;

    @FindBy(css = ".nr-cart--buttons>button")
    public static WebElement BigContinue;





    public FlightsPage(WebDriver driver){

        this.driver = driver;
    }

}
