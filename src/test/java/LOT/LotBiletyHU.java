package LOT;

import DDT.ExcelDataConfig;
import Main.GetScreenshot;
import Main.MainTest;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.Keys;
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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class LotBiletyHU extends MainTest{
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    String name = "Test";
    String surname = "Test";
    String email = "TestLot@niepodam.pl";
    String phone = "532752626";
    //--------
    String creditcard = "41111111111111111"; //MasterCard
    String cvv= "737";
    String city = "Warsaw";
    String zipcode = "02-444";
    String street = "Obrony robotników 43";

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
    public void Test_BuyTickets(String localization, String from, String to, XSSFCell departuredata, XSSFCell returndata) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl + localization);
        ImplicitWait(driver);

        //TIME
        String dat1 = String.valueOf(departuredata);
        if (dat1.length() > 0) {
            dat1 = dat1.substring(0, (dat1.length() - 2));
        }

        String dat2 = String.valueOf(returndata);
        if (dat2.length() > 0) {
            dat2 = dat2.substring(0, (dat2.length() - 2));
        }

        System.out.println(departuredata);
        System.out.println(returndata);
        System.out.println(dat1);
        System.out.println(dat2);

        //Given Date in String format
        String timeStamp = new SimpleDateFormat("yy.MM.dd").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);

        //Specifying date format that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
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
        System.out.println("Date after Addition/ Departure: "+newDate);
        System.out.println("Date after Addition/ Return: "+newDate2);
        //TIME

        //TestStart
        //HomePage
        try {
            GetScreenshot.capture("HomePage " +localization +from +to +departuredata +returndata);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HomePage.FromList.click();
        HomePage.FromToText.sendKeys(from,Keys.ENTER);
        HomePage.Lot.click();
        HomePage.ToList.click();
        HomePage.FromToText.sendKeys(to,Keys.ENTER);
        HomePage.Lot.click();
        HomePage.DepartureDate.clear();
        HomePage.DepartureDate.sendKeys(newDate);
        HomePage.ReturnDate.clear();
        HomePage.ReturnDate.sendKeys(newDate2);
        HomePage.Submit.submit();
        //FlightPage
        try {
            FlightsPage.FirstTO.click();
        } catch (Exception e) {
            System.out.println("Other tickets : "+ e.getMessage());
            FlightsPage.FirstTO1.click();
        }

        try {
            FlightsPage.FirstBack.click();
        } catch (Exception e) {
            System.out.println("Other tickets : "+ e.getMessage());
            FlightsPage.FirstBack2.click();
        }

        try {
            wait.until(ExpectedConditions.visibilityOf(FlightsPage.BigContinue));
            FlightsPage.BigContinue.click();
        } catch (Exception e) {
            System.out.println("No Element Continue : "+ e.getMessage());
        }

        //Selecting title
        PassengersPage.Title.click();
        Select title = new Select(PassengersPage.Title);
        title.selectByIndex(1);
        //Selecting title

        PassengersPage.FirstName.sendKeys(name);
        PassengersPage.Surname.sendKeys(surname);

        //DATE OF BIRTH
        try {
            PassengersPage.DayOfBirth.click();
            Select day = new Select(PassengersPage.DayOfBirth);
            day.selectByIndex(11);

            PassengersPage.MonthOfBirth.click();
            Select mouth = new Select(PassengersPage.MonthOfBirth);
            mouth.selectByIndex(5);

            PassengersPage.YearOfBirth.click();
            Select year = new Select(PassengersPage.YearOfBirth);
            year.selectByIndex(72);
        } catch (Exception e) {
            System.out.println("Short haul : "+ e.getMessage());
        }
        //DATE OF BIRTH

        PassengersPage.Email.sendKeys(email);
        PassengersPage.Phone.sendKeys(phone);
        wait.until(ExpectedConditions.elementToBeClickable(PassengersPage.CheckboxAccept));
        PassengersPage.CheckboxAccept.click();
        wait.until(ExpectedConditions.elementToBeClickable(PassengersPage.BigContinue));
        PassengersPage.BigContinue.click();
        try {
            PassengersPage.PopupAccept.click();
        }catch (Exception e){

            System.out.println("No Popup : "+ e.getMessage());
        }
        //Extra Page
        //wait.until(ExpectedConditions.visibilityOf(ExtrasPage.Seats));
        try {
            wait.until(ExpectedConditions.visibilityOf(ExtrasPage.BigContinue));
            ExtrasPage.BigContinue.click();
        } catch (Exception e) {
            System.out.println("No Element Continue : "+ e.getMessage());
        }
        //Extra Page

        //Payment Page

        //BookingNumber
        String BookNumber = PaymentPage.BookNr.getText();
        System.out.println(BookNumber);
        //BookingNumber

        //Credit Card
        //Text
        PaymentPage.CardNr.sendKeys(creditcard);
        PaymentPage.Cvc.sendKeys(cvv);
        PaymentPage.Name.sendKeys(name);
        PaymentPage.City.sendKeys(city);
        PaymentPage.PostalCode.sendKeys(zipcode);
        PaymentPage.Street.sendKeys(street);
        //Text

        //DropdownLists
        PaymentPage.Month.click();
        Select mounth = new Select(PaymentPage.Month);
        mounth.selectByIndex(5);

        PaymentPage.Year.click();
        Select cardyear = new Select(PaymentPage.Year);
        cardyear.selectByIndex(5);

        PaymentPage.Country.click();
        Select country = new Select(PaymentPage.Country);
        country.selectByIndex(167);
        PaymentPage.Lot.click();
        //DropdownLists
        //Credit Card

        try {
            wait.until(ExpectedConditions.visibilityOf(PaymentPage.BigContinue));
            PaymentPage.BigContinue.click();
        } catch (Exception e) {
            System.out.println("Problem with Continue button : "+ e.getMessage());
        }


    }
    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\30001236\\IdeaProjects\\LOTests\\testData\\LOT.xlsx");
        int rows = config.getRowCount(2);
        Object[][] data=new Object[rows][5];

        for(int i=0;i<rows;i++){
            data[i][0]=config.getData(2,i,0);
            data[i][1]=config.getData(2,i,1);
            data[i][2]=config.getData(2,i,2);
            data[i][3]=config.getNumber(2,i,3);
            data[i][4]=config.getNumber(2,i,4);
        }
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
