package LOT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LotBilety3 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://www.lot.com/";
    }

    @Test(groups=("p1"))
    public void testLot() throws Exception {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl + "pl/pl/");
        driver.findElement(By.cssSelector("h3.h3.g-no-padding-b")).click();
        driver.findElement(By.cssSelector("span.darkBlueColorText")).click();
        driver.findElement(By.cssSelector("button.o-btn.submit")).submit();
        driver.findElement(By.cssSelector("img.img_responsive")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

        }

}
