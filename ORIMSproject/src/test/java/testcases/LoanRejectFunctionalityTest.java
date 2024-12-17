package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoanRejectFunctionalityTest extends BaseTest {

	@Test(priority = 4)
	public static void testRejectFunctionality() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Navigate to the Compensation Recommendation Tab
			WebElement compensationRecommendationTab = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("compensation-RecommendationTab"))));
			compensationRecommendationTab.click();

			// Navigate to the Loan Tab
			WebElement loanTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("loan-Tab"))));
			loanTab.click();

			// Navigate to the SE Application Tab
			WebElement seTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("se-Tab"))));
			seTab.click();

			// Select the specific application row
			WebElement applicationRow = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("application-Row2"))));
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
