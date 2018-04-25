package PRE2LOT;

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

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://prodcopy-pre2:MHXozAuh4eeCgK4x6ww6@pre2.book.lot.com/");
        driver.manage().timeouts().implicitlyWait(220, TimeUnit.SECONDS);
        HomePage HomePage =PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod() throws Exception {
        driver.get("https://prodcopy-pre2:MHXozAuh4eeCgK4x6ww6@pre2.book.lot.com/");

    }

    @AfterMethod(alwaysRun = true)
    public void browserSetUp() {
        driver.manage().deleteAllCookies();
    }
    @AfterClass(alwaysRun = true)
    public void shutDownSelenium() {
        driver.close();
    }

    @Test//(groups=("p1"))
    public void Test_From_WAW_TO_JFK_prices() throws Exception {

        driver.get("https://pre2.book.lot.com/");
        HomePage.Departure.click();
        HomePage.Today.click();
        HomePage.Return.click();
        HomePage.FirsOfNextMounth.click();
        HomePage.From.sendKeys("Waw");
        HomePage.ListFrom.click();
        HomePage.To.sendKeys("JFK",Keys.ARROW_DOWN,Keys.ENTER);

        //Lista cen
        List<String> Ceny = new ArrayList<String>();
        List<WebElement> Cena = driver.findElements(
                By.name("precio"));
        for (WebElement w : Cena) {
            Ceny.add(w.getAttribute("value"));
        }
        System.out.println(Ceny);
        Reporter.log(String.valueOf(Ceny));
        Reporter.getCurrentTestResult();
        //Lista cen

    }

    @Test//(groups=("p1"))
    public void Test_From_WAW_TO_ICN_prices() throws Exception {

        driver.get("https://pre2.book.lot.com/");
        HomePage.Departure.click();
        HomePage.Today.click();
        HomePage.Return.click();
        HomePage.FirsOfNextMounth.click();
        HomePage.From.sendKeys("Waw");
        HomePage.ListFrom.click();
        HomePage.To.sendKeys("ICN",Keys.ARROW_DOWN,Keys.ENTER);

        //Lista cen
        List<String> Ceny = new ArrayList<String>();
        List<WebElement> Cena = driver.findElements(
                By.name("precio"));
        for (WebElement w : Cena) {
            Ceny.add(w.getAttribute("value"));
        }
        System.out.println(Ceny);
        Reporter.log(String.valueOf(Ceny));
        Reporter.getCurrentTestResult();
        //Lista cen

    }

    @Test//(groups=("p1"))
    public void Test_From_WAW_TO_LUX_prices() throws Exception {

        driver.get("https://pre2.book.lot.com/");
        HomePage.Departure.click();
        HomePage.Today.click();
        HomePage.Return.click();
        HomePage.FirsOfNextMounth.click();
        HomePage.From.sendKeys("Waw");
        HomePage.ListFrom.click();
        HomePage.To.sendKeys("LUX",Keys.ARROW_DOWN,Keys.ENTER);

        //Lista cen
        List<String> Ceny = new ArrayList<String>();
        List<WebElement> Cena = driver.findElements(
                By.name("precio"));
        for (WebElement w : Cena) {
            Ceny.add(w.getAttribute("value"));
        }
        System.out.println(Ceny);
        Reporter.log(String.valueOf(Ceny));
        Reporter.getCurrentTestResult();
        //Lista cen

    }

    @Test//(groups=("p1"))
    public void Test_From_WAW_TO_BCN_prices() throws Exception {

        driver.get("https://pre2.book.lot.com/");
        HomePage.Departure.click();
        HomePage.Today.click();
        HomePage.Return.click();
        HomePage.FirsOfNextMounth.click();
        HomePage.From.sendKeys("Waw");
        HomePage.ListFrom.click();
        HomePage.To.sendKeys("BCN",Keys.ARROW_DOWN,Keys.ENTER);

        //Lista cen
        List<String> Ceny = new ArrayList<String>();
        List<WebElement> Cena = driver.findElements(
                By.name("precio"));
        for (WebElement w : Cena) {
            Ceny.add(w.getAttribute("value"));
        }
        System.out.println(Ceny);
        Reporter.log(String.valueOf(Ceny));
        Reporter.getCurrentTestResult();
        //Lista cen

    }

}