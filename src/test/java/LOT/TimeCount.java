package LOT;

import DDT.ExcelDataConfig;
import Main.GetScreenshot;
import Main.MainTest;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeCount extends MainTest{
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


    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, FlightsPage.class);
        PageFactory.initElements(driver, PassengersPage.class);
        PageFactory.initElements(driver, ExtrasPage.class);
        PageFactory.initElements(driver, PaymentPage.class);
    }


    @Test(dataProvider = "data",groups=("BuyTickets"))
    public void Test_BuyTicketsEU(String localization, String from, String to, XSSFCell departuredata, XSSFCell returndata) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
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

        //Given Date in String format
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());

        // Printing Data
        //System.out.println(timeStamp);

        //Specifying date format that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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
        //System.out.println("Date after Addition/ Departure: " + newDate);
        //System.out.println("Date after Addition/ Return: " + newDate2);
        //TIME

        //TEST START
        String startdata = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("Lokalizacja: "+localization+" | Lot z: " +from+ " | Lot do: "+to+" | Data wylotu: "+newDate+" | Data powrotu: "+newDate2+"  Start testu: "+startdata);
        //Take screenshot

        //HomePage
        //Selecting From Flight
        wait.until(ExpectedConditions.elementToBeClickable(HomePage.FromListButton));
        HomePage.FromListButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(HomePage.FromToText));
        HomePage.FromToText.sendKeys(from);

        driver.findElement(By.cssSelector(".select2-results__options > li > ul > li[id*="+from+"]")).click();
        //Click on home page

        Thread.sleep(1000);

        //Selecting To Flight

        HomePage.Lot.click();
        wait.until(ExpectedConditions.elementToBeClickable(HomePage.ToList));
        HomePage.ToList.click();
        wait.until(ExpectedConditions.elementToBeClickable(HomePage.ToToText));
        HomePage.ToToText.sendKeys(to);
        driver.findElement(By.cssSelector(".select2-results__options > li > ul > li[id*="+to+"]")).click();



        //Click on home page
        HomePage.Lot.click();

        //Selecting Departure Data
        HomePage.DepartureDate.clear();
        HomePage.DepartureDate.sendKeys(newDate);

        //Selecting Return Date
        HomePage.ReturnDate.clear();
        HomePage.ReturnDate.sendKeys(newDate2);
        HomePage.Lot.click();

        //Submit Button go from Home Page to Flight Page + time
        long start = System.currentTimeMillis();
        HomePage.Submit.submit();

        //FlightPage
        try {
            wait.until(ExpectedConditions.visibilityOf(FlightsPage.Cart));
        } catch (Exception e) {
            System.out.println(localization+"/"+from+"->"+to+"/ Zbyt dlugi czas oczekiwania przejscia z bookera na step 2- flights : "+ e.getMessage());
        }
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;

        System.out.println("Czas ladowania strony w sekundach to: "+totalTime/1000 + " dla " + from +"->"+ to+" "+localization);
        System.out.println("Czas ladowania strony w milisekundach to: "+totalTime + " dla " + from +"->"+ to+" "+localization);
    }

    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Public\\LOT\\TimeCount.xlsx");
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

    @AfterTest(alwaysRun = true)
    public void tearDown1() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
