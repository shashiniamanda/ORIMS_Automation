package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class VerifyChequePrintFunction extends BaseTest {

	@Test(priority = 6)
	public static void testChequePrintFunctionality() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		try {
			// Navigate to the Cheque Payment Tab
			WebElement chequePaymentTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("chequePayment-Tab"))));
			chequePaymentTab.click();

			// Navigate to the Cheque Print Tab
			WebElement chequePrintTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("chequePrint-Tab"))));
			chequePrintTab.click();

			// Navigate to the GPC Applications Tab
			WebElement gpcTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("gpc-Tab"))));
			gpcTab.click();

			// Select the specific application row
			WebElement applicationRow = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("application-Row4"))));
			applicationRow.click();

			// Click on the Cheque Details button
			WebElement chequeDetailsButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(loc.getProperty("cheque-Details-Button"))));
			chequeDetailsButton.click();

			// Select the drawer
			WebElement drawerRow = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("drawer-Row1"))));
			drawerRow.click();

			// Click on the Print Cheque button
			WebElement printChequeButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("printCheque-Button"))));
			printChequeButton.click();

//			WebElement confirmationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
//	confirmationButton.click();
//

			// Optional: Log success message
			// System.out.println("Cheque print functionality executed successfully!");

			// Wait for the PDF to open in a new tab or iframe
			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();

			String mainWindowHandle = driver.getWindowHandle();
			String pdfWindowHandle = null;

			while (iterator.hasNext()) {
				String handle = iterator.next();
				if (!handle.equals(mainWindowHandle)) {
					pdfWindowHandle = handle;
					break;
				}
			}

			if (pdfWindowHandle != null) {
				driver.switchTo().window(pdfWindowHandle);

				// Use JavaScript to fetch the PDF content from the blob URL
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				String pdfBase64 = (String) jsExecutor.executeScript(
						"return fetch(document.location.href)" + "  .then(response => response.arrayBuffer())"
								+ "  .then(buffer => btoa(String.fromCharCode(...new Uint8Array(buffer))))"
								+ "  .catch(error => { return null; });");

				if (pdfBase64 != null) {
					// Convert Base64 to InputStream
					byte[] pdfBytes = java.util.Base64.getDecoder().decode(pdfBase64);
					InputStream pdfStream = new ByteArrayInputStream(pdfBytes);

					// Use PDFBox to read the content
					//PDDocument document = PDDocument.load(pdfStream);
					//PDFTextStripper pdfStripper = new PDFTextStripper();
					//String pdfText = pdfStripper.getText(document);


					// Close the document and InputStream
					//document.close();
					//pdfStream.close();

					// Extracted text from the PDF
					String expectedText = "Yeheni";

					// Assert that the PDF contains the expected text
					//Assert.assertEquals(pdfText.contains(expectedText), true, "Text 'Yeheni' not found in the PDF!");

					//if (pdfText.contains(expectedText)) {
						System.out.println("Text 'Yeheni' found in the PDF!");
					//} else {
						System.out.println("Text 'Yeheni' NOT found in the PDF.");
					//}
				} else {
					System.out.println("Failed to retrieve PDF content from blob URL.");
				}

			} else {
				System.out.println("No new tab detected for PDF.");
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
