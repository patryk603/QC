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


    @Test(dataProvider = "dataEU")
    public void Test_Pr2ShortEU(String localization, String from, String to, XSSFCell departuredata, XSSFCell returndata) throws Exception {

        //driver.get("https://pre2.book.lot.com/");
        /*
        HomePage.Departure.click();
        HomePage.Today.click();
        HomePage.Return.click();
        HomePage.FirsOfNextMounth.click();
        HomePage.From.sendKeys(from);
        HomePage.ListFrom.click();
        HomePage.To.sendKeys(to,Keys.ARROW_DOWN,Keys.ENTER);
*/

    }

    @DataProvider(name ="dataEU")
    public Object[][] passDataEU()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Public\\LOT\\PRE2Short.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data=new Object[rows][5];

        for(int i=0;i<rows;i++){
            data[i][0]=config.getData(0,i,0);
            data[i][1]=config.getData(0,i,1);
            data[i][2]=config.getData(0,i,2);
            data[i][3]=config.getNumber(0,i,3);
            data[i][4]=config.getNumber(0,i,4);
        }
        return data;
    }



}