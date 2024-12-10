package utilities;

import base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

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
		LogUtils.info("Test Started: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LogUtils.info("Test Passed: " + result.getMethod().getMethodName());
	}


	@Override
	public void onTestFailure(ITestResult result) {

		// Retrieve WebDriver instance from the BaseTest or test class
		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseTest) currentClass).getDriver();

		// Initialize ScreenshotHelper and capture a screenshot
		ScreenshotHelper screenshotHelper = new ScreenshotHelper(driver);
		screenshotHelper.getScreenshot(result.getName());

		LogUtils.info("Test Failed: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LogUtils.info("Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		LogUtils.info("Test Partially Failed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {

		LogUtils.info("Test Suite Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		LogUtils.info("Test Suite Finished: " + context.getName());
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
