package LOT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyBookings;

import java.util.concurrent.TimeUnit;

public class Reservations {
    private WebDriver driver;
    private String baseUrl;
    private String LastName;
    private String BookingNumber;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        LastName = "NOVOSELITSKY";
        BookingNumber = "NZUJ4Z";
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, MyBookings.class);
    }

    @Test(groups=("r1"))
    public void Test_ManageYourBooking() throws Exception {
        driver.get(baseUrl + "pl/en/");
        HomePage.ManageBooking.click();
        HomePage.LastName.sendKeys(LastName);
        HomePage.BookingNumber.sendKeys(BookingNumber);
        HomePage.NextBtn.click();
        String BookingNr = MyBookings.ReservationNumber.getText();
        Assert.assertEquals(BookingNr , BookingNumber);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();
    }

}
