package Main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetScreenshot extends MainTest {

    public static String capture (String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String dest = System.getProperty("user.dir") + "/ErrorScreenshot/" + screenshotName + timeStamp +".jpg";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        Reporter.log("<a href='"+ destination.getAbsolutePath() + "'> <img src='"+ destination.getAbsolutePath() + "' height='1080' width='1920'/> </a><br>" + timeStamp);

        return dest;
    }
}
