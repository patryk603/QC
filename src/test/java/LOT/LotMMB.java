package LOT;

import DDT.ExcelDataConfig;
import Main.MainTest;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;

public class LotMMB extends MainTest {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(23, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(22,SECONDS);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, FlightsPage.class);
        PageFactory.initElements(driver, PassengersPage.class);

    }


    @Test(dataProvider = "data",groups=("MMB"))
    public void Test_BuyTickets(String lastname, String bookinrexcel) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl + "/pl/pl/moja-rezerwacja");
        ImplicitWait(driver);


        //TestStart
        //Enter Surname
        WebElement surname = HomePage.MMBLastName;
        surname.sendKeys(lastname);
        WebElement book = HomePage.MMBBookingNumber;
        book.sendKeys(bookinrexcel);
        HomePage.MMBSubmit.click();
        //Thread.sleep(7000);
        String bookingnr = driver.findElement(By.cssSelector(".confirmation-your-ticket-code strong")).getText();
        String bookinrexcel2 = bookinrexcel;
        System.out.println(bookingnr);
        System.out.println(bookinrexcel);
        //Booking Number check
        assertEquals(bookinrexcel2, bookingnr);
        if (Objects.equals(bookinrexcel2, bookingnr)) {
            System.out.println("Booking Number is ok:" + bookinrexcel);
        } else {
            System.out.println("Booking Number not found");
        }

    }



    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Public\\LOT\\MMB.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data=new Object[rows][2];

        for(int i=0;i<rows;i++){
            data[i][0]=config.getData(0,i,0);
            data[i][1]=config.getData(0,i,1);
        }
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();
        //driver.manage().deleteAllCookies();
    }

}
