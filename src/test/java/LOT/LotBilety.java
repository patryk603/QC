package LOT;

import java.sql.Driver;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import DDT.ExcelDataConfig;
import Main.MainTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePage;

public class LotBilety extends MainTest {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(13, SECONDS);
        PageFactory.initElements(driver, HomePage.class);

    }


    @Test(dataProvider = "data",groups=("BuyTickets"))
    public void Test_BuyTickets(String localization, String from, String to, String departure, String back) throws Exception {
        driver.get(baseUrl + localization);
        HomePage.FromList.click();
        HomePage.FromToText.sendKeys(from,Keys.ENTER);
        HomePage.ToList.click();
        HomePage.FromToText.sendKeys(to,Keys.ENTER);
        HomePage.DepartureDate.sendKeys(departure);
        HomePage.ReturnDate.sendKeys(back);

        HomePage.Submit.submit();

        HomePage.lotlogo.click();
    }

    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\30001236\\IdeaProjects\\LOTests\\testData\\LOT.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data=new Object[rows][5];

        for(int i=0;i<rows;i++){
            data[i][0]=config.getData(0,i,0);
            data[i][1]=config.getData(0,i,1);
            data[i][2]=config.getData(0,i,2);
            data[i][3]=config.getData(0,i,3);
            data[i][4]=config.getData(0,i,4);
        }
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();
        driver.manage().deleteAllCookies();
    }

}
