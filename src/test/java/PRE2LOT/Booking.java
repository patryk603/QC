package PRE2LOT;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PRE2_pageObjects.HomePage;

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
        driver.manage().timeouts().implicitlyWait(2220, TimeUnit.SECONDS);
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

        String cena = driver.findElement(By.id("_availabilityportlet_WAR_lotairwaysportlet_precio-1-EUPINKTAN-3")).getAttribute("value");
        System.out.println(cena);

        //HomePage.LotEconomySaver.getText();
        //HomePage.LotEconomySaver.click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
       // driver.quit();

    }

}
