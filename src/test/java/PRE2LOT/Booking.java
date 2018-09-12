package PRE2LOT;

import DDT.ExcelDataConfig;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.*;
import PRE2_pageObjects.HomePage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Booking {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://prodcopy-pre2:MHXozAuh4eeCgK4x6ww6@pre2.book.lot.com/");
        driver.manage().timeouts().implicitlyWait(220, TimeUnit.SECONDS);
        HomePage HomePage =PageFactory.initElements(driver, HomePage.class);
    }


    @Test()
    public void Test_Pr2ShortEU() throws Exception {

        //driver.get("https://pre2.book.lot.com/");

        HomePage.Departure.click();
        HomePage.Today.click();
        HomePage.Return.click();
        HomePage.FirsOfNextMounth.click();
        HomePage.From.sendKeys("WAW");
        HomePage.ListFrom.click();
        HomePage.To.sendKeys("FRA",Keys.ARROW_DOWN,Keys.ENTER);


    }



}