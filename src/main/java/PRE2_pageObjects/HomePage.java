package PRE2_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PTeledzinski on 04.04.2018.
 */
public class HomePage {

    final WebDriver driver;

    @FindBy(id = "_bookingportlet_WAR_lotairwaysportlet_INSTANCE_wl9jlWyYLKBg_origin_1")
    public static WebElement From;

    @FindBy(id = "_bookingportlet_WAR_lotairwaysportlet_INSTANCE_wl9jlWyYLKBg_destination_1")
    public static WebElement To;

    @FindBy(css = ".user")
    public static WebElement ListFrom;

    @FindBy(css = "#_bookingportlet_WAR_lotairwaysportlet_INSTANCE_wl9jlWyYLKBg_departingPicker > div > div > button > img")
    public static WebElement Departure;

    @FindBy(css = "#_bookingportlet_WAR_lotairwaysportlet_INSTANCE_wl9jlWyYLKBg_returningPicker > div > div > button")
    public static WebElement Return;

    @FindBy(css = "#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(2) > td.ui-datepicker-days-cell-over.ui-datepicker-current-day.ui-datepicker-today > a")
    public static WebElement Today;

    @FindBy(css = "#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-last > table > tbody > tr:nth-child(1) > td:nth-child(3) > a")
    public static WebElement FirsOfNextMounth;

    @FindBy(id = "_availabilityportlet_WAR_lotairwaysportlet_precioFormatAdult-1-EUPINKTAN-3")
    public static WebElement LotEconomySaver;











    public HomePage(WebDriver driver){

        this.driver = driver;
    }

}
