package PRE2LOT;

import DDT.ExcelDataConfig;
import PRE2_pageObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static Main.MainTest.ImplicitWait;

public class PRE2Short {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        //DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        //caps.setCapability("ignoreZoomSetting", true);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        baseUrl = "https://prodcopy-pre2:MHXozAuh4eeCgK4x6ww6@pre2.book.lot.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, HomePage.class);
    }


    @Test(dataProvider = "dataEU",groups=("BuyTickets"))
    public void Test_Pr2ShortEU(String from, String to) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl);
        ImplicitWait(driver);

        HomePage.Departure.click();

        //Selecting random Departure Data
        try {
            List<WebElement> listings = driver.findElements(By.cssSelector("a.ui-state-default"));
            Random r = new Random();
            int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
            listings.get(randomValue).click(); //Clicking on the random item in the list.
            //Click on add button
            wait.until(ExpectedConditions.elementToBeClickable(HomePage.DepartureData));
            HomePage.DepartureData.click();
        } catch (Exception e) {
            System.out.println("No Element additional TO : "+ e.getMessage());
        }

        HomePage.Return.click();

        //Selecting random Return Data
        try {
            List<WebElement> listings2 = driver.findElements(By.cssSelector("a.ui-state-default"));
            Random r = new Random();
            int randomValue = r.nextInt(listings2.size()); //Getting a random value that is between 0 and (list's size)-1
            listings2.get(randomValue).click(); //Clicking on the random item in the list.
            //Click on add button
            //wait.until(ExpectedConditions.elementToBeClickable(HomePage.DepartureData));
            driver.findElement(By.cssSelector("a.ui-state-default")).click();
            //HomePage.DepartureData.click();
        } catch (Exception e) {
            System.out.println("No Element additional TO : "+ e.getMessage());
        }

        HomePage.From.clear();
        HomePage.From.sendKeys(from);
        HomePage.ListFrom.click();
        HomePage.To.clear();
        HomePage.To.sendKeys(to,Keys.ARROW_DOWN,Keys.ENTER);
        //END OF TEST

    }

    @DataProvider(name ="dataEU")
    public Object[][] passDataEU() {
        ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Public\\LOT\\PRE2Short.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            data[i][0] = config.getData(0, i, 0);
            data[i][1] = config.getData(0, i, 1);

        }
        return data;
    }

    //Excel configuration

    //After and of Class test

    //After and of Class test
    @AfterTest(alwaysRun = true)
    public void tearDown1() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();

    }

}