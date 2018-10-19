package Selenium.Saucelabs;

import DDT.ExcelDataConfig;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static Main.MainTest.ImplicitWait;

public class LotBiletyAllshortSauceLabsTEST {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    //All Static Data
    String name = "Test";
    String surname = "Test";
    String email = "TestLot@niepodam.pl";
    String phone = "532752626";
    String DayOfBirth = String.valueOf(11);
    String MonthOfBirth = String.valueOf(05);
    String YearOfBirth = String.valueOf(1989);
    //--------CreditCard
    String creditcard = "41111111111111111"; //MasterCard
    String cvv= "737";
    String city = "Warsaw";
    String zipcode = "02-444";
    String street = "Obrony robotników 43";
    String Month = String.valueOf(05);
    String Year = String.valueOf(2020);
    //--------CreditCard

    //--------SauceLabs
    public static final String USERNAME = "lotek603";
    public static final String ACCESS_KEY = "32d9b4c8-3977-4781-aa35-91098dfcf36a";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    /**
     * ThreadLocal variable which contains the  {@link WebDriver} instance which is used to perform browser interactions with.
     */
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    /**
     * ThreadLocal variable which contains the Sauce Job Id.
     */
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();
    private RemoteWebDriver driver;

    /**
     * DataProvider that explicitly sets the browser combinations to be used.
     *
     * @param
     * @return Two dimensional array of objects with browser, version, and platform information
     */
    //--------SauceLabs


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setCapability("platform", "OS X 10.10");
        caps.setCapability("version", "8.0");
        caps.setCapability("screenResolution", "1920x1080");
        caps.setCapability("name", "Safari 8 | OS X 10.10");

        driver = new RemoteWebDriver(new URL(URL), caps);
        baseUrl = "http://www.lot.com/";
    }


    @Test(dataProvider = "data",groups=("BuyTickets"))
    public void Test_BuyTickets(String localization, String from, String to, XSSFCell departuredata, XSSFCell returndata) throws Exception {


        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, FlightsPage.class);
        PageFactory.initElements(driver, PassengersPage.class);
        PageFactory.initElements(driver, ExtrasPage.class);
        PageFactory.initElements(driver, PaymentPage.class);

        driver.get(baseUrl + localization);
        ImplicitWait(driver);
        //TIME Configuration
        String dat1 = String.valueOf(departuredata);
        if (dat1.length() > 0) {
            dat1 = dat1.substring(0, (dat1.length() - 2));
        }

        String dat2 = String.valueOf(returndata);
        if (dat2.length() > 0) {
            dat2 = dat2.substring(0, (dat2.length() - 2));
        }

        //Data Formats
        String eutime = "dd.MM.yyyy";
        String hutime = "yy.MM.dd";
        String ustime = "MM.dd.yyyy";

        String actualtime;
        if (localization.contains("us")) {
            actualtime = ustime;
        }   else if (localization.startsWith("hu/hu")) {
            actualtime = hutime;
        }   else {
            actualtime = eutime;
        }

        //Given Date in String format
        String timeStamp = new SimpleDateFormat(actualtime).format(Calendar.getInstance().getTime());

        //Specifying date format that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat(actualtime);


        Calendar c = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        try {
            //Setting the date to the given date
            c.setTime(sdf.parse(timeStamp));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            //Setting the date to the given date
            b.setTime(sdf.parse(timeStamp));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(String.valueOf(dat1)));
        b.add(Calendar.DAY_OF_MONTH, Integer.parseInt(String.valueOf(dat2)));

        //Date after adding the days to the given date
        String newDate = sdf.format(c.getTime());
        String newDate2 = sdf.format(b.getTime());

        //Displaying the new Date after addition of Days
        System.out.println("Data wylotu: " + newDate);
        System.out.println("Data powrotu: " + newDate2);
        //TIME

        //TEST START
        String start = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("Lokalizacja: "+localization+" | Lot z: " +from+ " | Lot do: "+to+" | Data wylotu: "+newDate+" | Data powrotu: "+newDate2+"  Start testu: "+start);


        //Selecting From Flight
        wait.until(ExpectedConditions.elementToBeClickable(HomePage.FromListButton));
        HomePage.FromListButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(HomePage.FromToText));
        HomePage.FromToText.sendKeys(from);

        driver.findElement(By.cssSelector(".select2-results__options > li > ul > li[id*=" + from + "]")).click();
        //Click on home page

        Thread.sleep(1000);

        //END OF TEST


    }

    //Excel configuration
    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Public\\Selenium\\Selenium.xlsx");
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

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        System.out.println("SauceOnDemandSessionID=" + driver.getSessionId() + " job-name=" + result.getName());
        driver.quit();
    }
    protected void annotate(String text) {
        ((JavascriptExecutor) driver).executeScript("sauce:context=" + text);
    }

}