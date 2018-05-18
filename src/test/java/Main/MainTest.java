package Main;


import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;


public class MainTest {
    public static WebDriver driver;


    public static void ImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
