package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateDataDisplayApplicationFileReturn extends BaseTest {

	@Test(priority = 5)
	public static void testReturnFunctionality() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {

			// Navigate to the Application Registration Tab
			WebElement applicationRegistrationTab = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("applicationRegistration-Tab"))));
			applicationRegistrationTab.click();

			// Navigate to the File Registration Tab
			WebElement fileRegistrationTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("file-Registration-Tab"))));
			fileRegistrationTab.click();

			// Navigate to the Application Files Tab
			WebElement applicationFilesTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("applicationFiles-Tab"))));
			applicationFilesTab.click();

			// Navigate to the Application Return Files Tab
			WebElement applicationReturnFilesTab = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("left-tabs-example-tab-application-file-return")));
			applicationReturnFilesTab.click();

			// Select the specific application file row
			WebElement fileRow = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("file-Row"))));
			fileRow.click();

			// Optional: Log success message
			// System.out.println("Data display and application file return functionality
			// executed successfully!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
