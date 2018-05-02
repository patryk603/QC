package LOT;

import DDT.ExcelDataConfig;
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

public class Reservations {
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
        driver.quit();
    }

    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\30001236\\IdeaProjects\\LOTests\\testData\\Data.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data=new Object[rows][2];

        for(int i=0;i<rows;i++){
            data[i][0]=config.getData(0,i,0);
            data[i][1]=config.getData(0,i,1);
        }
        return data;
    }
}
