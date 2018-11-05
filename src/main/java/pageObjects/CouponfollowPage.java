package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by PTeledzinski on 05.11.2018.
 */
public class CouponfollowPage {

    final WebDriver driver;

    @FindBy(css = "#search > input.searchField")
    public static WebElement searchField;

    //first result
    @FindBy(xpath = "//*[@id=\"search\"]/ul/li[1]/a")
    public static WebElement dominospizza;
    //first coupon
    @FindBy(css = "body > main > section.cont.master > div.content > section > article:nth-child(1) > div.deal > div.deal-desc > div.cr > a")
    public static WebElement coupon;

    @FindBy(id = "copy-button")
    public static WebElement copybutton;

    @FindBy(id = "coupon-code")
    public static WebElement couponCode;


    public CouponfollowPage(WebDriver driver){

        this.driver = driver;
    }

}
