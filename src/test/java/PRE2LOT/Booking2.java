package PRE2LOT;

import PRE2_pageObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Booking2 {
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

    @Test(groups=("pre2"))
    public void Test_From_WAW_TO_JFK_prices() throws Exception {

        driver.get("https://pre2.book.lot.com/");
        HomePage.Departure.click();
        driver.findElement(By.cssSelector("a.ui-state-default:contains(\"29\")"));
        //HomePage.Today.click();
        //HomePage.Return.click();
        //HomePage.FirsOfNextMounth.click();
        //HomePage.From.sendKeys("Waw");
        //HomePage.ListFrom.click();
        //HomePage.To.sendKeys("JFK",Keys.ARROW_DOWN,Keys.ENTER);

    }

}