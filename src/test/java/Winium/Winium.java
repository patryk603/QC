package Winium;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Winium {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

     DesktopOptions options=new DesktopOptions();
     options.setApplicationPath("C:\\Windows\\system32\\calc.exe");

        Thread.sleep(5000);
        WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);


        driver.findElementByName("7").click();
        //driver.findElement(By.name("dodaj")).click();
        //driver.findElement(By.name("7")).click();
        //driver.findElement(By.name("Równa się")).click();

    }
}
