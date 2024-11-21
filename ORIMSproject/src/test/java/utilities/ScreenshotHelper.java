package utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {
    // Method to capture a screenshot on test case failure
    private WebDriver driver;

    public void getScreenshot(String testName) {
        // Get the current date and time for unique file naming
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";

        // Define the destination path for screenshots
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName;

        // Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Save the screenshot to the destination
            FileUtils.copyFile(screenshot, new File(destinationPath));
            System.out.println("Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }

    }
}
