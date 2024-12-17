package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

import java.time.Duration;

public class LoanFileCreation extends BaseTest {

	@Test(priority = 11)
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

			WebElement fRow = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("fRow"))));
			fRow.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			// Click the proceed Button
			WebElement proceedButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("proceed-Button"))));
			proceedButton.click();

			// Click the ok Button
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			okButton.click();

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Section 2 - Applicant Details
	@Test(priority = 12, dataProvider = "Section2", dataProviderClass = ReadXLSdata.class)
	public static void AppCreationSection2(String applicantTitle, String pAddress, String maritalStatus,
			String occupation) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		try {

			Thread.sleep(5000);

			WebElement applicanttitle = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("applicant-title"))));
			applicanttitle.click();

			WebElement applicanttitleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + applicantTitle + "']")));
			applicanttitleOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			
			Thread.sleep(2000);
			
			WebElement permenantAddress = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("permenant-Address"))));
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

			Thread.sleep(5000);

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

	// Section 3 - Applicant Details
	@Test(priority = 13, dataProvider = "Section3", dataProviderClass = ReadXLSdata.class)
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

	// Section 4 - Applicant Details
	@Test(priority = 14, dataProvider = "Section4", dataProviderClass = ReadXLSdata.class)
	public static void AppCreationSection4(String outstandingAmount, String bankname, String detailsApplication,
			String forHowyrs, String fortrainHowyrs, String requireLAmount, String requirePeriod, String gracePeriod,
			String approvedLAmount, String bName, String brName, String accountNo) throws InterruptedException {

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
			dApplication.sendKeys(detailsApplication);

			WebElement violenceActivity = driver.findElement(By.id("formAnyPropertyDamage-N"));
			violenceActivity.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

			WebElement selfEmployee = driver.findElement(By.id("formPreviousExp-N"));
			selfEmployee.click();

			WebElement foryrs = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("for-yrs"))));
			foryrs.sendKeys(forHowyrs);

			WebElement fortyrs = wait.until(ExpectedConditions.elementToBeClickable(By.id("formTrainedYears")));
			fortyrs.sendKeys(fortrainHowyrs);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement rLoanAmount = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("rLoan-Amount"))));
			rLoanAmount.sendKeys(requireLAmount);

			WebElement rPeriod = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("r-Period"))));
			rPeriod.sendKeys(requirePeriod);

			WebElement GPeriod = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("G-Period"))));
			GPeriod.sendKeys(gracePeriod);

			WebElement aLoanAmount = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("aLoan-Amount"))));
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

	// Section 5
	@Test(priority = 15)
	public static void AppCreationSection5() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-300);");
			Thread.sleep(5000);

//				WebElement uploadbutton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/button"));
//				uploadbutton.click();

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
