package LOT;

import DDT.ExcelDataConfig;
import Main.MainTest;
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

public class BuyTickets extends MainTest {
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, MyBookings.class);
    }

    @Test(dataProvider = "data",groups=("Reservation"))
    public void Test_ManageYourBooking(String localization, String from, String to) throws Exception {
        driver.get(baseUrl + localization);
        HomePage.FromList.click();
        HomePage.FromToText.sendKeys(from);
        HomePage.ToList.click();
        HomePage.FromToText.sendKeys(to);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\30001236\\IdeaProjects\\LOTests\\testData\\Tickets.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data=new Object[rows][3];

        for(int i=0;i<rows;i++){
            data[i][0]=config.getData(0,i,0);
            data[i][1]=config.getData(0,i,1);
            data[i][2]=config.getData(0,i,2);
        }
        return data;
    }
}
