package LOT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.FakeMails;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import java.util.concurrent.TimeUnit;

public class CreateAccount {
    private WebDriver driver;
    private String baseUrl;
    private String login = "Testerlot3";
    private String pass = "Qwas12345";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://www.lot.com/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        HomePage HomePage =PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage =PageFactory.initElements(driver, LoginPage.class);
        RegisterPage RegisterPage =PageFactory.initElements(driver, RegisterPage.class);
        FakeMails FakeMails =PageFactory.initElements(driver, FakeMails.class);
    }

    @Test(groups=("p1"))
    public void Test_RegistrationEmail_PL() throws Exception {
        driver.get(baseUrl + "pl/pl/");
        HomePage.login.click();
        LoginPage.register.click();
        RegisterPage.email.sendKeys(login + "@yopmail.com");
        RegisterPage.password.sendKeys(pass);
        RegisterPage.passwordConfirmation.sendKeys(pass);
        RegisterPage.confirm.click();

    }
    @Test(dependsOnMethods = { "Test_RegistrationEmail_PL" })
    public void Test_RegistrationEmailConfirm_PL() throws Exception {

        driver.get("http://www.yopmail.com/pl/");
        FakeMails.Yemail.sendKeys(login);
        FakeMails.Ypass.click();
        FakeMails.Yhrefconfirm.click();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();

    }

}
