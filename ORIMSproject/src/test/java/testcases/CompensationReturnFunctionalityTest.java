package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CompensationReturnFunctionalityTest extends BaseTest {

	@Test(priority = 2)
	public static void testReturnFunctionality() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Navigate to the Compensation Recommendation Tab
			WebElement compensationRecommendationTab = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("compensation-RecommendationTab"))));
			compensationRecommendationTab.click();

			// Navigate to the Compensation Tab
			WebElement compensationTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("compensation-Tab"))));
			compensationTab.click();

			// Navigate to the PD Application Tab
			WebElement pdTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("pd-Tab"))));
			pdTab.click();

			// Select the specific application row
			WebElement applicationRow = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("application-Row1"))));
			applicationRow.click();

			// Click on the Return button
			WebElement returnButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("return-Button"))));
			returnButton.click();

			// Select a reason from the dropdown
			WebElement reasonDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("Reason")));
			reasonDropdown.click();
			
			Select selectReason = new Select(reasonDropdown);
			selectReason.selectByVisibleText("Bank Account invalid");

//			// Click the "OK" button
//			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.modal-footer > button.save-button")));
//			okButton.click();

			// Log success message
			// System.out.println("Compensation return functionality executed
			// successfully!");

//			// Verify the success message "Application returned Successfully"
//			WebElement successMessage = wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.xpath("//div[text()='Application returned Successfully']")));
//
//			// Assert that the text matches the expected message
//			Assert.assertEquals(successMessage.getText(), "Application returned Successfully",
//					"The Application returned success message does not match!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
