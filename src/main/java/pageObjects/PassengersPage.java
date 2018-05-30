package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 16.05.2018.
 */
public class PassengersPage {

    final WebDriver driver;

    @FindBy(css = ".custom-select:nth-child(2)>select[id$=title]")
    public static WebElement Title;

    @FindBy(css = ".autofillWrapper>input[id$=\"1_name\"]")
    public static WebElement FirstName;

    @FindBy(css = ".autofillWrapper>input[id$=surname]")
    public static WebElement Surname;

    @FindBy(css = ".custom-select:nth-child(2)>select[id$=day]")
    public static WebElement DayOfBirth;

    @FindBy(css = ".custom-select:nth-child(2)>select[id$=month]")
    public static WebElement MonthOfBirth;

    @FindBy(css = ".custom-select:nth-child(2)>select[id$=year]")
    public static WebElement YearOfBirth;

    @FindBy(css = ".custom-input>input[id$=\"email\"]")
    public static WebElement Email;

    @FindBy(css = ".custom-input>input[id$=\"phone\"]")
    public static WebElement Phone;

    @FindBy(css = ".checkbox>input[id$=\"termsUseCheckboxCheckbox\"]")
    public static WebElement CheckboxAccept;

    @FindBy(css = ".nr-cart--buttons>button")
    public static WebElement BigContinue;

    @FindBy(css = ".nr-cart--buttons--tablet>button")
    public static WebElement SmallContinue;

    @FindBy(css = ".btn.btn-type3[onclick*=\"accept\"]")
    public static WebElement PopupAccept;


    public PassengersPage(WebDriver driver){

        this.driver = driver;
    }

}
