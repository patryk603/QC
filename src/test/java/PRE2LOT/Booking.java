package PRE2LOT;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        HomePage HomePage =PageFactory.initElements(driver, HomePage.class);
    }

    @Test(groups=("p1"))
    public void Test_From_WAW_TO_JFK() throws Exception {

        HomePage.Departure.click();
        HomePage.Today.click();
        HomePage.Return.click();
        HomePage.FirsOfNextMounth.click();
        HomePage.From.sendKeys("Waw");
        HomePage.ListFrom.click();
        HomePage.To.sendKeys("JFK",Keys.ARROW_DOWN,Keys.ENTER);
    }

    @Test(groups=("p1"))
    public void Test_From_WAW_TO_JFK_prices() throws Exception {

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
        //Lista cen

    }

    @Test(groups=("p1"))
    public void Test_From_WAW_TO_ICN_prices() throws Exception {

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
        //Lista cen
    }



    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
       // driver.quit();

    }

}
