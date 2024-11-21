package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Listener implements ITestListener {

	private WebDriver driver;

	public void TestListener(WebDriver driver) {
	        this.driver = driver; // Pass driver instance to the listener
	    }

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getMethod().getMethodName());
		System.out.println("Error: " + result.getThrowable());

		// Capture Screenshot
		try {
			String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
			// Attach screenshot to ReportNG
			System.setProperty("org.uncommons.reporting.escape-output", "false");
			System.out.println("<a href=\"" + screenshotPath + "\">Test Results</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Partially Failed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished: " + context.getName());
	}

	// Helper method to capture screenshot
	private String captureScreenshot(String methodName) throws IOException {
		// Create screenshots directory if it doesn't exist
		String screenshotsDir = System.getProperty("user.dir") + "/screenshots/";
		Files.createDirectories(Paths.get(screenshotsDir));

		// Capture screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = screenshotsDir + methodName + ".png";
		Files.copy(screenshot.toPath(), Paths.get(screenshotPath));

		return screenshotPath;
	}
}
