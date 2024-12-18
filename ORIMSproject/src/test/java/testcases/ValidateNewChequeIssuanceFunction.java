package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateNewChequeIssuanceFunction extends BaseTest {

	@Test(dataProvider = "Cheque-details", dataProviderClass = utilities.ReadXLSDataLoan.class, priority = 9)
	public static void testReturnFunctionality(String voucherNumber, String chequeNumber, String stampType,
			String chequeIssueDate) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Navigate to the Cheque Payment Tab
			WebElement chequePaymentTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("chequePayment-Tab"))));
			chequePaymentTab.click();

			// Navigate to the Manage Cheque Details Tab
			WebElement manageChequeTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("manageCheque-Tab"))));
			manageChequeTab.click();

			// Navigate to the MP Applications Tab
			WebElement mpTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("mp-Tab"))));
			mpTab.click();

			Thread.sleep(2000);

			// Select the specific application row
			WebElement specificApplicationRow = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("specificApplication-Row"))));
			specificApplicationRow.click();

			// Scroll down again
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			// Enter the Voucher Number
			WebElement voucherNoField = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("voucherNo-Field"))));
			voucherNoField.sendKeys(voucherNumber);
			Thread.sleep(2000);

			// Enter the Cheque Number
			WebElement chequeNoField = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("chequeNo-Field"))));
			chequeNoField.sendKeys(chequeNumber);

			// Select the Stamp Charges Checkbox
			WebElement stampChargesCheckbox = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("stampCharges-Checkbox"))));
			stampChargesCheckbox.click();

			// Select the Stamp Type
			WebElement stampTypeDropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("stampType-Dropdown"))));
			stampTypeDropdown.click();

			Thread.sleep(2000);

			WebElement stampTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + stampType + "']")));
			stampTypeOption.click();

			Thread.sleep(2000);

			// Scroll further down
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			// Set the Cheque Issued Date
			WebElement chequeIssuedDateField = driver
					.findElement(By.cssSelector("div.react-datepicker-wrapper > div > input"));
			chequeIssuedDateField.click();

			WebElement chequeDateOption = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='" + chequeIssueDate + "']")));
			chequeDateOption.click();

			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800);");

			// Click the Add Button
			WebElement addButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("add-Button"))));
			addButton.click();

//            // Click the Ok Button
//            WebElement okButton = wait.until(ExpectedConditions
//                    .elementToBeClickable(By.xpath("//button[contains(@class, 'save-button') and text()='Ok']")));
//            okButton.click();

//          // Click the approve Button
//          WebElement approveButton = wait.until(ExpectedConditions
//                  .elementToBeClickable(By.xpath("//button[contains(@class, 'save-button') and text()='Approve']")));
//          approveButton.click();

//			// Verify the success message "Cheque payments approved successfully"
//			WebElement successMessage = wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.xpath("//div[text()='Cheque payments approved successfully']")));
//
//			// Assert that the text matches the expected message
//			Assert.assertEquals(successMessage.getText(), "Cheque payments approved successfully",
//					"The Cheque payments approved success message does not match!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
