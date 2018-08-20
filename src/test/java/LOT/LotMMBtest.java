package LOT;

import DDT.ExcelDataConfig;
import Main.GetScreenshot;
import Main.GetScreenshotFullPage;
import Main.MainTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.FlightsPage;
import pageObjects.HomePage;
import pageObjects.PassengersPage;

import java.io.IOException;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class LotMMBtest extends MainTest {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();

        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1500, 1000));
        baseUrl = "http://www.lot.com/";

    }


    @Test
    public void MMB() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl + "/pl/pl");
        ImplicitWait(driver);


        //TestStart
        //Enter Surname



        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("jQuery"));
            GetScreenshotFullPage.capture(driver, "FullPageScreen");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

}
