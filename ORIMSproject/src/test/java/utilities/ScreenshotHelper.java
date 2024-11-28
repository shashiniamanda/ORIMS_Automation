package utilities;
import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper  extends BaseTest {
    // Method to capture a screenshot on test case failure

    public ScreenshotHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void getScreenshot(String testName) {
        try {
            // Generate a unique name for the screenshot using timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";

            // Define the path to save the screenshot
            String destinationPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + screenshotName;

            // Take the screenshot and save it to the specified path
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(destinationPath);
            FileUtils.copyFile(screenshot, destinationFile);

            System.out.println("Screenshot saved at: " + destinationPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
