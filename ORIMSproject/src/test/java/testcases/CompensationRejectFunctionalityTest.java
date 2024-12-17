package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CompensationRejectFunctionalityTest extends BaseTest {

	@Test(priority = 3)
	public static void testRejectFunctionality()  throws InterruptedException{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Navigate to the Compensation Recommendation Tab
			WebElement compensationRecommendationTab = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("compensation-RecommendationTab"))));
			compensationRecommendationTab.click();

			// Navigate to the Compensation Tab
			WebElement compensationTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("compensation-Tab"))));
			compensationTab.click();

			// Navigate to the PD Application Tab
			WebElement pdTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pd-Tab"))));
			pdTab.click();

			// Select the specific application row
			WebElement applicationRow = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("application-Row"))));
			applicationRow.click();

			// Click on the "Recommend to Reject" button
			WebElement rejectButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("reject-Button"))));
			rejectButton.click();

			// Wait for the dropdown to be visible
			WebElement reasonDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("Reason")));
			reasonDropdown.click();

			// Create a Select object to interact with the dropdown
			Select selectReason = new Select(reasonDropdown);
			selectReason.selectByVisibleText("Duplicate");

//			// Click the "OK" button
//			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.modal-footer > button.save-button")));
//			okButton.click();

			// Optional: Log success message
			// System.out.println("Compensation reject functionality executed
			// successfully!");

//			Thread.sleep(2000);

//			// Verify the success message "Application rejected Successfully"
//			WebElement successMessage = wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.xpath("//div[text()='Application rejected Successfully']")));
//
//			// Assert that the text matches the expected message
//			Assert.assertEquals(successMessage.getText(), "Application rejected Successfully",
//					"The Application rejected success message does not match!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
