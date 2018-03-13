package LOT;

import java.sql.Driver;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LotBilety {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(groups=("p1"))
    public void Test_Biletow() throws Exception {
        driver.get(baseUrl + "pl/pl/");
        driver.findElement(By.cssSelector("h3.h3.g-no-padding-b")).click();
        driver.findElement(By.cssSelector("span.darkBlueColorText")).click();
        driver.findElement(By.cssSelector("button.o-btn.submit")).submit();
        driver.findElement(By.cssSelector("img.img_responsive")).click();
    }

    @Test(groups=("p1"))
    public void Test_Zarezewuj() throws Exception {
        driver.get(baseUrl + "pl/pl/zarezerwuj-header");
    }

    @Test(groups=("p1"))
    public void Test_Promocji() throws Exception {
        driver.get(baseUrl + "pl/pl/promocje-header");
    }


    @Test(groups=("p1"))
    public void Bilet_WAW_LHR_Economy() throws Exception {

        driver.get(baseUrl + "pl/pl/");
        driver.findElement(By.cssSelector("h3.h3.g-no-padding-b")).click();
        driver.findElement(By.cssSelector("span.darkBlueColorText")).click();
        driver.findElement(By.cssSelector("button.o-btn.submit")).submit();
        driver.findElement(By.id("VAB__flight__rates__rate__header__content_-1-ECONOMY")).click();
        driver.findElement(By.id("_shoppingcartportlet_WAR_lotairwaysportlet_cart-btn-submit-tablet")).click();
        driver.findElement(By.cssSelector("#modal-warning-description > div > button")).click();
    }

    @Test(groups=("p1"))
    public void Bilet_WAW_LHR_PremiumEconomy() throws Exception {

        driver.get(baseUrl + "pl/pl/");
        driver.findElement(By.cssSelector("h3.h3.g-no-padding-b")).click();
        driver.findElement(By.cssSelector("span.darkBlueColorText")).click();
        driver.findElement(By.cssSelector("button.o-btn.submit")).submit();
        driver.findElement(By.id("VAB__flight__rates__rate__header__content_-1-PREMIUM_ECONOMY")).click();
        driver.findElement(By.id("_shoppingcartportlet_WAR_lotairwaysportlet_cart-btn-submit-tablet")).click();
    }

    @Test(groups=("p1"))
    public void Bilet_WAW_LHR_Business() throws Exception {

        driver.get(baseUrl + "pl/pl/");
        driver.findElement(By.cssSelector("h3.h3.g-no-padding-b")).click();
        driver.findElement(By.cssSelector("span.darkBlueColorText")).click();
        driver.findElement(By.cssSelector("button.o-btn.submit")).submit();
        driver.findElement(By.id("VAB__flight__rates__rate__header__content_-1-BUSINESS")).click();
        driver.findElement(By.id("_shoppingcartportlet_WAR_lotairwaysportlet_cart-btn-submit-tablet")).click();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

}
