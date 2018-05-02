package LOT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyBookings;

import java.util.concurrent.TimeUnit;

public class Reservations_test {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, MyBookings.class);
    }

    @Test(dataProvider = "data")
    public void Test_ManageYourBooking(String username, String password) throws Exception {
        driver.get(baseUrl + "pl/en/");
        HomePage.ManageBooking.click();
        HomePage.LastName.sendKeys(username);
        HomePage.BookingNumber.sendKeys(password);
        HomePage.NextBtn.click();
        String BookingNr = MyBookings.ReservationNumber.getText();
        Assert.assertEquals(BookingNr , password,"Reservation not find");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @DataProvider(name ="data")
    public Object[][] passData()
    {
        Object[][] data=new Object[3][2];

        data[0][0]="NOVOSELITSKY";
        data[0][1]="NZUJ4Z2";
        data[1][0]="NOVOSELITSKY";
        data[1][1]="NZUJ4Z";
        data[2][0]="NOVOSELITSKY";
        data[2][1]="NZUJ4Z";

        return data;
    }

}
