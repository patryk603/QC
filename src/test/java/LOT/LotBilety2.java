package LOT;

import DDT.ExcelDataConfig;
import Main.MainTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ExtrasPage;
import pageObjects.FlightsPage;
import pageObjects.HomePage;
import pageObjects.PassengersPage;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LotBilety2 extends MainTest {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, FlightsPage.class);
        PageFactory.initElements(driver, PassengersPage.class);

    }



    @Test(dataProvider = "data",groups=("BuyTickets"))
    public void Test_BuyTickets(String localization, String from, String to, String departure, String back) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(baseUrl + localization);
        ImplicitWait(driver);

        HomePage.FromList.click();
        HomePage.FromToText.sendKeys(from,Keys.ENTER);
        HomePage.Lot.click();
        HomePage.ToList.click();
        HomePage.FromToText.sendKeys(to,Keys.ENTER);
        HomePage.Lot.click();
        HomePage.DepartureDate.clear();
        HomePage.DepartureDate.sendKeys(departure);
        HomePage.ReturnDate.clear();
        HomePage.ReturnDate.sendKeys(back);
        HomePage.Submit.submit();
        FlightsPage.FirstTO.click();
        FlightsPage.FirstBack.click();
        wait.until(ExpectedConditions.elementToBeClickable(FlightsPage.BigContinue));
        //Thread.sleep(5000);
        FlightsPage.BigContinue.click();

        //Selecting title
        PassengersPage.Title.click();
        Select title = new Select(PassengersPage.Title);
        title.selectByIndex(1);
        //Selecting title

        PassengersPage.FirstName.sendKeys("Test");
        PassengersPage.Surname.sendKeys("Test");

        //DATE OF BIRTH
        PassengersPage.DayOfBirth.click();
        Select day = new Select(PassengersPage.DayOfBirth);
        day.selectByIndex(11);

        PassengersPage.MonthOfBirth.click();
        Select mouth = new Select(PassengersPage.MonthOfBirth);
        mouth.selectByIndex(5);

        PassengersPage.YearOfBirth.click();
        Select year = new Select(PassengersPage.YearOfBirth);
        year.selectByIndex(72);
        //DATE OF BIRTH

        PassengersPage.Email.sendKeys("test@niepodam.pl");
        PassengersPage.Phone.sendKeys("777777777");
        wait.until(ExpectedConditions.elementToBeClickable(PassengersPage.CheckboxAccept));
        PassengersPage.CheckboxAccept.click();
        PassengersPage.BigContinue.click();
        //wait.until(ExpectedConditions.elementToBeClickable(PassengersPage.PopupAccept));
        //PassengersPage.PopupAccept.click();
        //wait.until(ExpectedConditions.elementToBeClickable(ExtrasPage.BigContinue));
        //Thread.sleep(5000);
        ExtrasPage.BigContinue.click();

        //HomePage.lotlogo.click();


    }
    @DataProvider(name ="data")
    public Object[][] passData()
    {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\30001236\\IdeaProjects\\LOTests\\testData\\LOT.xlsx");
        int rows = config.getRowCount(1);
        Object[][] data=new Object[rows][5];

        for(int i=0;i<rows;i++){
            data[i][0]=config.getData(1,i,0);
            data[i][1]=config.getData(0,i,1);
            data[i][2]=config.getData(0,i,2);
            data[i][3]=config.getData(0,i,3);
            data[i][4]=config.getData(0,i,4);
        }
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {

        driver.manage().deleteAllCookies();
        //driver.quit();
    }

}
