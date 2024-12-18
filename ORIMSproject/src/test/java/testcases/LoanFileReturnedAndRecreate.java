package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSDataLoan;
import utilities.ReadXLSdata;

import java.time.Duration;

public class LoanFileReturnedAndRecreate extends BaseTest {

	@Test(priority = 16)
	public static void testReturnFunctionality() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Navigate to the application Registartion Tab
			WebElement applicationRegistartionTab = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("applicationRegistartion-tab"))));
			applicationRegistartionTab.click();

			// Navigate to the file loan Tab
			WebElement loanTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("loan-Tab"))));
			loanTab.click();

			// Navigate to the file se Tab
			WebElement seTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("se-Tab"))));
			seTab.click();

			// Navigate to the file SE Return Tab
			WebElement seReturnTab = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("seReturn-Tab"))));
			seReturnTab.click();

			Thread.sleep(2000);

			WebElement fRow = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("f-Row1"))));
			fRow.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			// Click the modify Button
			WebElement modifyButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("modify-Button"))));
			modifyButton.click();

			// Click the ok Button
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			okButton.click();

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Section 2 Return
	@Test(priority = 17, dataProvider = "Section2Return", dataProviderClass = ReadXLSDataLoan.class)
	public static void AppCreationSection2(String applicantTitle, String pAddress, String maritalStatus,
			String occupation) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		try {
			Thread.sleep(2000);

			WebElement applicanttitle = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("applicant-title"))));
			applicanttitle.click();

			WebElement applicanttitleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + applicantTitle + "']")));
			applicanttitleOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			WebElement permenantAddress = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("permenant-Address"))));

			// Ensure the field is cleared completely
			permenantAddress.click();
			permenantAddress.clear(); // Attempt to clear the field
			permenantAddress.sendKeys(Keys.CONTROL, "a"); // Select all text
			permenantAddress.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add new data
			permenantAddress.sendKeys(pAddress);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			WebElement mStatus = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("m-Status"))));
			mStatus.click();

			WebElement mStatusOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + maritalStatus + "']")));
			mStatusOption.click();

			WebElement Occupation = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("Occupation"))));
			Occupation.click();

			WebElement OccupationOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + occupation + "']")));
			OccupationOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			WebElement loanRadio = driver.findElement(By.id("formJointLoan-O"));
			loanRadio.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			Thread.sleep(2000);

			// Click the save Button
			WebElement saveButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("save-Button"))));
			saveButton.click();

			Thread.sleep(2000);

			// Click the ok Button
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			okButton.click();

			Thread.sleep(2000);

			// Click the next Button
			WebElement nextButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("next-Button"))));
			nextButton.click();

			Thread.sleep(2000);

			// Click the ok2 Button
			WebElement ok2Button = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			ok2Button.click();

		}

		catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Section 3 Return
	@Test(priority = 18, dataProvider = "Section3Return", dataProviderClass = ReadXLSDataLoan.class)
	public static void AppCreationSection3(String fmonthlyIncome) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		try {

//			WebElement fmemberRadio = driver.findElement(By.id("formAnyFamilyMember-O"));
//			fmemberRadio.click();
//
//			WebElement widowRadio = driver.findElement(By.id("formwidow-O"));
//			widowRadio.click();
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			Thread.sleep(2000);

			WebElement familyMIncome = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("familyM-Income"))));

			// Ensure the field is cleared completely
			familyMIncome.click(); // Click to focus on the field
			familyMIncome.clear(); // Attempt to clear the field
			familyMIncome.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			familyMIncome.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			familyMIncome.sendKeys(fmonthlyIncome);

			Thread.sleep(2000);

			// Click the save Button
			WebElement saveButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("save-Button"))));
			saveButton.click();

			Thread.sleep(2000);

			// Click the ok Button
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			okButton.click();

			Thread.sleep(2000);

			// Click the next Button
			WebElement nextButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("next-Button"))));
			nextButton.click();

			Thread.sleep(2000);

			// Click the ok2 Button
			WebElement ok2Button = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			ok2Button.click();

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Section 4 Return
	@Test(priority = 19, dataProvider = "Section4Return", dataProviderClass = ReadXLSDataLoan.class)
	public static void AppCreationSection4(String detailsApplication, String forHowyrs, String fortrainHowyrs,
			String requireLAmount, String requirePeriod, String gracePeriod, String approvedLAmount, String bName,
			String brName, String accountNo) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		try {

			Thread.sleep(2000);

			WebElement floansRadio = driver.findElement(By.id("formAnyRehabilitated-O"));
			floansRadio.click();

//			WebElement oAmount = wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("//input[@placeholder='Enter Outstanding Amount']")));
//			oAmount.sendKeys(outstandingAmount);
//			
//			WebElement bankName1 = wait
//					.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='formOutStandingBankName']")));
//			bankName1.click();
//
//			WebElement bankName1Option = wait
//					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + bankname + "']")));
//			bankName1Option.click();

			WebElement propertyCompensation = driver.findElement(By.id("formAnyPropertyCom-N"));
			propertyCompensation.click();

			WebElement dApplication = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("d-Application"))));

			// Ensure the field is cleared completely
			dApplication.click(); // Click to focus on the field
			dApplication.clear(); // Attempt to clear the field
			dApplication.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			dApplication.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			dApplication.sendKeys(detailsApplication);

			WebElement violenceActivity = driver.findElement(By.id("formAnyPropertyDamage-N"));
			violenceActivity.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			WebElement selfEmployee = driver.findElement(By.id("formPreviousExp-N"));
			selfEmployee.click();

			WebElement foryrs = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("for-yrs"))));

			// Ensure the field is cleared completely
			foryrs.click(); // Focus on the field
			foryrs.clear(); // Attempt to clear the field
			foryrs.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			foryrs.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			foryrs.sendKeys(forHowyrs);

			WebElement fortyrs = wait.until(ExpectedConditions.elementToBeClickable(By.id("formTrainedYears")));

			// Ensure the field is cleared completely
			fortyrs.click(); // Focus on the field
			fortyrs.clear(); // Attempt to clear the field
			fortyrs.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			fortyrs.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			fortyrs.sendKeys(fortrainHowyrs);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement rLoanAmount = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("rLoan-Amount"))));

			// Ensure the field is cleared completely
			rLoanAmount.click(); // Focus on the field
			rLoanAmount.clear(); // Attempt to clear the field
			rLoanAmount.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			rLoanAmount.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			rLoanAmount.sendKeys(requireLAmount);

			WebElement rPeriod = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("r-Period"))));

			// Ensure the field is cleared completely
			rPeriod.click(); // Focus on the field
			rPeriod.clear(); // Attempt to clear the field
			rPeriod.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			rPeriod.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			rPeriod.sendKeys(requirePeriod);

			WebElement GPeriod = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("G-Period"))));

			// Ensure the field is cleared completely
			GPeriod.click(); // Focus on the field
			GPeriod.clear(); // Attempt to clear the field
			GPeriod.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			GPeriod.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			GPeriod.sendKeys(gracePeriod);

			WebElement aLoanAmount = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("aLoan-Amount"))));

			// Ensure the field is cleared completely
			aLoanAmount.click(); // Focus on the field
			aLoanAmount.clear(); // Attempt to clear the field
			aLoanAmount.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			aLoanAmount.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			aLoanAmount.sendKeys(approvedLAmount);

			Thread.sleep(2000);

			WebElement bankName2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("bank-Name2"))));
			bankName2.click();

			WebElement bankName2Option = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + bName + "']")));
			bankName2Option.click();

			Thread.sleep(2000);

			WebElement branchName = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("branch-Name"))));
			branchName.click();

			WebElement branchNameOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + brName + "']")));
			branchNameOption.click();

			WebElement accNumber = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("acc-Number"))));

			// Ensure the field is cleared completely
			accNumber.click(); // Focus on the field
			accNumber.clear(); // Attempt to clear the field
			accNumber.sendKeys(Keys.CONTROL, "a"); // Select all text in the field
			accNumber.sendKeys(Keys.BACK_SPACE); // Delete the selected text

			// Add the new value
			accNumber.sendKeys(accountNo);

			// Click the save Button
			WebElement saveButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("save-Button"))));
			saveButton.click();

			Thread.sleep(2000);

			// Click the ok Button
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			okButton.click();

			Thread.sleep(2000);

			// Click the next Button
			WebElement nextButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("next-Button"))));
			nextButton.click();

			Thread.sleep(2000);

			// Click the ok2 Button
			WebElement ok2Button = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			ok2Button.click();

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Section 5 Return
	@Test(priority = 20)
	public static void AppCreationSection5() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		try {

			Thread.sleep(2000);

//			// Click the remove Button
//			WebElement removeButton = wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("//button[contains(@class, 'save-button') and text()='Remove']")));
//			removeButton.click();
//
//			Thread.sleep(2000);
//			
//			// Click the ok1 Button
//			WebElement ok1Button = wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("//button[contains(@class, 'save-button') and text()='Ok']")));
//			ok1Button.click();
//			
//			//Thread.sleep(2000);

//			// Verify the success message "File Removed Successfully"
//			WebElement successMessage = wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.xpath("//div[text()='File Removed Successfully']")));
//
//			// Assert that the text matches the expected message
//			Assert.assertEquals(successMessage.getText(), "File Removed Successfully",
//					"The File Removed success message does not match!");
//			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			// Locate the file input element (not the button) and send the file path
			WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
			fileInput.sendKeys("C:\\Users\\Kamal\\Downloads\\application_file_1885_acknowledgment.docx");

			Thread.sleep(2000);

			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			okButton.click();
			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
			Thread.sleep(2000);

			WebElement submitButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("submit-Button"))));
			submitButton.click();

			Thread.sleep(2000);

			WebElement ok2Button = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			ok2Button.click();

			Thread.sleep(2000);

			WebElement ok3Button = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			ok3Button.click();

			// Verify the success message "Application Created Successfully"
			WebElement successMessage = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[text()='Application Created Successfully']")));

			// Assert that the text matches the expected message
			Assert.assertEquals(successMessage.getText(), "Application Created Successfully",
					"The Application Created success message does not match!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
