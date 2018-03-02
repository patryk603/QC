package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Linkedin {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.linkedin.com/";


    }

    @Test(groups=("l1"))
    public void testLot() throws Exception {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys("patryk603@wp.pl");
        driver.findElement(By.id("login-password")).clear();
        driver.findElement(By.id("login-password")).sendKeys("P@kier1989r");
        driver.findElement(By.id("login-submit")).click();
        driver.findElement(By.id("messaging-nav-item")).click();
        driver.findElement(By.id("nav-settings__dropdown-trigger")).click();
        driver.findElement(By.xpath("//a[contains(@href,\"/m/logout/\")]")).click();
        //[alternative]driver.findElement(By.xpath("//*[contains(text(),\"Wyloguj się\")]")).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

        }

}
