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

    @FindBy(css = "#lastName")
    public static WebElement MMBLastName;

    @FindBy(css = "#bookingNumber")
    public static WebElement MMBBookingNumber;

    @FindBy(css = "[type=\"submit\"]")
    public static WebElement MMBSubmit;

    @FindBy(css = ".nr-managemybooking__conditions > p > a")
    public static WebElement FareConditions;

    @FindBy(id = "nr-your-ticket--content")
    public static WebElement ticket;


    public MMBPage(WebDriver driver){

        this.driver = driver;
    }

}
