package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 04.04.2018.
 */
public class MyBookings {

    final WebDriver driver;


    @FindBy(css = "#nr-your-ticket > div.nr-your-ticket--header > div.nr-your-ticket--group > p")
    public static WebElement ReservationNumber;



    public MyBookings(WebDriver driver){

        this.driver = driver;
    }

}
