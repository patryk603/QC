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

    @FindBy(css = ".nr-anc__seats__content__right>div>table>tbody>tr>th>table>tbody>tr>td[id*=\"tdSeat_flight_1\"]:not([class*=\"disabled\"])")
    public static WebElement SeatsOnPlain;

    @FindBy(css = ".popover>div>div>a[class$=add]")
    public static WebElement AddSeatsButton;

    @FindBy(css = ".nr-anc__seats__content__right>div>table>tbody>tr>th>table>tbody>tr>td[id*=\"tdSeat_flight_1\"]:not([class*=\"disabled\"])")
    public static WebElement Flight1;

    @FindBy(css = ".nr-anc__seats__content__right>div>table>tbody>tr>th>table>tbody>tr>td[id*=\"tdSeat_flight_2\"]:not([class*=\"disabled\"])")
    public static WebElement Flight2;

    @FindBy(css = ".nr-anc__seats__content__right>div>table>tbody>tr>th>table>tbody>tr>td[id*=\"tdSeat_flight_3\"]:not([class*=\"disabled\"])")
    public static WebElement Flight3;

    @FindBy(css = ".nr-anc__seats__content__right>div>table>tbody>tr>th>table>tbody>tr>td[id*=\"tdSeat_flight_4\"]:not([class*=\"disabled\"])")
    public static WebElement Flight4;


    public ExtrasPage(WebDriver driver){

        this.driver = driver;
    }

}
