package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by PTeledzinski on 20.08.2018.
 */
public class LuggageComplaintPage {

    final WebDriver driver;

    @FindBy(css = "span.g-font-1.small-hide")
    public static WebElement CloseCoockieSpam;

    //Step 1
    @FindBy(css = "#form-gender [href]")
    public static WebElement Gender;

    @FindBy(css = ".fwselect-menu-listitem:not([class*=\"focus\"]")
    public static WebElement GenderL;

    @FindBy(css = "#name")
    public static WebElement Name;

    @FindBy(css = "#surname")
    public static WebElement Surname;

    @FindBy(css = "#city")
    public static WebElement City;

    @FindBy(css = "#zipCode")
    public static WebElement ZipCode;

    @FindBy(css = "#street")
    public static WebElement Street;

    @FindBy(css = "#number")
    public static WebElement Number;

    @FindBy(css = "#phoneNumber")
    public static WebElement PhoneNumber;

    @FindBy(css = "#flightDate")
    public static WebElement FlightDate;

    @FindBy(css = "#route")
    public static WebElement Route;

    @FindBy(id = "milesNMoreMember-button")
    public static WebElement MilesAndMore;

    @FindBy(css = ".milesNMoreMember [data-index=\"2\"]")
    public static WebElement MilesAndMoreNo;

    @FindBy(css = "#email")
    public static WebElement Email;

    @FindBy(css = ".next-step")
    public static WebElement NextStep1;

    @FindBy(id = "flightNumber")
    public static WebElement FlightNumber;

    //Step 2

    @FindBy(id = "postedLuggageQuantity")
    public static WebElement LuggageQuantityPosted;

    @FindBy(id = "complaintLuggageQuantity")
    public static WebElement LuggageQuantityComplaint;

    @FindBy(id = "excessLuggagePenalty-button")
    public static WebElement LuggagePenalty;

    @FindBy(css = ".excessLuggagePenalty [tabindex=\"-1\"]:nth-of-type(3) .fwselect-menu-listitem")
    public static WebElement LuggagePenaltyNo;

    @FindBy(css = "#luggageComplaintForm > div:nth-child(3) > div.f-buttons > span.right.btn > input[type=\"submit\"]")
    public static WebElement NextStep2;

    @FindBy(css = "#complaint-reason-0-5-lot-checkbox > span")
    public static WebElement LuggageDelay;

    @FindBy(id = "luggageDamageDetails0")
    public static WebElement DamageDetails;




    public LuggageComplaintPage(WebDriver driver){

        this.driver = driver;
    }

}
