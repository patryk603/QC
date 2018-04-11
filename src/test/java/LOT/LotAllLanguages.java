package LOT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class LotAllLanguages {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        HomePage HomePage =PageFactory.initElements(driver, HomePage.class);
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_PL() throws Exception {
        driver.get(baseUrl + "pl/pl/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
        HomePage.MilesAndMore.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_AM() throws Exception {
        driver.get(baseUrl + "am/en/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_AT() throws Exception {
        driver.get(baseUrl + "at/de/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_BE() throws Exception {
        driver.get(baseUrl + "be/fr/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_BY() throws Exception {
        driver.get(baseUrl + "by/ru/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_GB() throws Exception {
        driver.get(baseUrl + "gb/en/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_CA() throws Exception {
        driver.get(baseUrl + "ca/en/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_CN() throws Exception {
        driver.get(baseUrl + "cn/zh/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }

    @Test(groups=("p1"))
    public void Test_HomePageTabs_HR() throws Exception {
        driver.get(baseUrl + "hr/en/");
        HomePage.login.click();
        driver.navigate().back();
        HomePage.Book.click();
        driver.navigate().back();
        HomePage.DealsAndOffers.click();
        driver.navigate().back();
        HomePage.PrepareForTravel.click();
        driver.navigate().back();
        HomePage.DuringForFlight.click();
        driver.navigate().back();
        HomePage.CustomerService.click();
        driver.navigate().back();
    }





    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }

}
