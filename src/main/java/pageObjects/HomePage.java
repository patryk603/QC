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
    public static WebElement login;

    @FindBy(css = "#mainlink-1 > a > h3")
    public static WebElement Book;

    @FindBy(css = "#mainlink-2 > a > h3")
    public static WebElement DealsAndOffers;

    @FindBy(css = "#mainlink-3 > a > h3")
    public static WebElement PrepareForTravel;

    @FindBy(css = "#mainlink-4 > a > h3")
    public static WebElement DuringForFlight;

    @FindBy(css = "#mainlink-5 > a > h3")
    public static WebElement CustomerService;

    @FindBy(css = "#menu-main > ul > li:nth-child(6) > a > h3 > span")
    public static WebElement MilesAndMore;

    public HomePage(WebDriver driver){

        this.driver = driver;
    }

}
