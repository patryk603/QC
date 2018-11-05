package tests;


import Main.MainTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.CouponfollowPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CouponFollow extends MainTest {
    private String baseUrl;

    //All Static Data
    String name = "Test";


    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        baseUrl = "https://couponfollow.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        PageFactory.initElements(driver, CouponfollowPage.class);

    }

    @Test
    public void Couponfollow_TEST() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        //Main Page
        driver.get(baseUrl);
        ImplicitWait(driver);
        CouponfollowPage.searchField.sendKeys("domino's");
        wait.until(ExpectedConditions.visibilityOfAllElements(CouponfollowPage.dominospizza));
        CouponfollowPage.dominospizza.click();


        //Next Page
        wait.until(ExpectedConditions.elementToBeClickable(CouponfollowPage.coupon));
        CouponfollowPage.coupon.click();

        //Code
        String currentURL = driver.getTitle();
        System.out.println(currentURL);

        String parent=driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> I1= s1.iterator();
        while(I1.hasNext())
        {
            String child_window=I1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                String CC = CouponfollowPage.couponCode.getText();
                System.out.println("Coupon code is: "+CC);
                CouponfollowPage.copybutton.click();
            }
        }

    }


    @AfterTest(alwaysRun = true)
    public void tearDown1() throws Exception {
        //driver.manage().deleteAllCookies();
        //driver.quit();
    }

}
