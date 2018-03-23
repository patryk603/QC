package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Mati {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://fed.lot.pl";


    }

    @Test
    public void testLot() throws Exception {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl + "/adfs/ls/?client-request-id=c4bdc1a3-90a7-4757-baf8-d7dfea7adb70&username=&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=estsredirect%3d2%26estsrequest%3drQIIAY2Rv2_TQABGc3FqtRUSFQKJjQ6dkGyfff4tdXASN2miNqRJIY2QWtf2OSa5nOs4Dnjgb4gYM4IEUkYmVMGAxNSpG1IZWFFZEFMlFhqxsMEbnr75ffcZkRfNDfgHiVuYgxiLnOsv1l_Et1bXXn388OnN9FHl9Orz18vsSzQD7IAmfDSYg3u9JIlGpiDQcTKgtM9TjEPX511KBDpxhHcAnAMwz2sqUhUNQd1QVd1QEFJEHruy5yHscMeyonCyhxFnyL7PabJjOJqCZEVFF_mbDWuc9KSFaBxm_s_8CqYxOYzoKJkxSdlNa-UDK7Dt4h60tFGgd3as3rOd5GBSqk2yCtkNuequeogdaZ9QL4JVxS42HWKVZaJEwXaw1T1u65PuSRSUw2ZGSmG3V285Qc3q2y3rqZpup_FQe2LUvfo4xp0OGsPqnPmvdG8Z9joDocMzhqWRPwy98wK4LNyAjLm8zK6Bu7n13FUBvFy6TvwrP_v-3Hpcev_6aPPF6E7ubEl4KFYypdHYIr6epmooa1rcpQF50LJRKdMrfR0O29l-ca_dDDaRKU5ZMGXZbyz4weZOV_71y8XqbQmKOgcRJ0nr0DBlw5S07m81");
        driver.findElement(By.id("userNameInput")).sendKeys("30001236@lot.pl");
        driver.findElement(By.id("passwordInput")).sendKeys("zaq1ZAQ!");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.id("idBtn_Back")).click();
        driver.findElement(By.xpath("//*[@id=\"_ariaId_23\"]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[136]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[589]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[545]")).click();
        driver.findElement(By.xpath("//div[@id='primaryContainer']/div[4]/div/div/div/div[4]/div[3]/div/div[5]/div/div/div[3]/div[4]/div/div/div[2]/div[2]/div/div/div[2]/div[6]/div[2]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='primaryContainer']/div[4]/div/div/div/div[4]/div[3]/div/div[5]/div/div/div[3]/div[4]/div/div/div[2]/div[2]/div/div/div[2]/div[6]/div[2]/div/input")).sendKeys("Co dzis robilem");



    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();

        }

}
