package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateChequeCancellationFunction extends BaseTest {

	@Test(priority = 8)
	public static void testChequeCancellationFunctionality() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {

			// Navigate to the Cheque Payment Tab
			WebElement chequePaymentTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("chequePayment-Tab"))));
			chequePaymentTab.click();

			// Navigate to the Cheque Print Tab
			WebElement chequePrintTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("chequePrint-Tab"))));
			chequePrintTab.click();

			// Navigate to the PD Applications Tab
			WebElement pdTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("PD-Tab"))));
			pdTab.click();

			// Select the specific application row
			WebElement applicationRow = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("application-Row3"))));
			applicationRow.click();

			// Click on the Cheque Details button
			WebElement chequeDetailsButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("chequeDetails-Button"))));
			chequeDetailsButton.click();

			// Select the specific drawer row
			WebElement drawerRow = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("drawer-Row"))));
			drawerRow.click();

			// Click on the Cancel Cheque button
			WebElement cancelChequeButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(loc.getProperty("cancel-Button"))));
			cancelChequeButton.click();

			// Open the reason dropdown and select a reason
			WebElement reasonDropdown = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("reason-Dropdown"))));
			reasonDropdown.click();
			Thread.sleep(2000); // Added to ensure dropdown options are visible
			reasonDropdown.sendKeys("Cheque Damage" + Keys.ENTER);

			// Confirm the action by clicking OK
			WebElement confirmationButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			confirmationButton.click();


			// Verify the success message "Cheque canceled successfully"
			WebElement successMessage = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[text()='Cheque canceled successfully']")));

			// Assert that the text matches the expected message
			Assert.assertEquals(successMessage.getText(), "Cheque canceled successfully",
					"The cancellation success message does not match!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
