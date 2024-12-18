package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoanFileRegistration extends BaseTest {

	@Test(dataProvider = "Loan-draft", dataProviderClass = utilities.ReadXLSDataLoan.class, priority = 10)
	public static void testReturnFunctionality(String programtype, String scheme, String applicantname, String nic,
			String province, String district, String dsDivision, String gnDivision, String applieddate,
			String receiveddate, String allocateType) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Navigate to the application Registartion Tab
			WebElement applicationRegistartionTab = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("applicationRegistartion-tab"))));
			applicationRegistartionTab.click();

			// Navigate to the file Registration Tab
			WebElement fileRegistrationTab = wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath(loc.getProperty("fileRegistration-Tab"))));
			fileRegistrationTab.click();

			// Navigate to the file Registration Tab 2
			WebElement fileRegistrationTab2 = wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath(loc.getProperty("fileRegistration-Tab2"))));
			fileRegistrationTab2.click();

			// Click add Button
			WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(loc.getProperty("add-Button1"))));
			addButton.click();

			WebElement programType = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(loc.getProperty("program-Type"))));
			programType.click();

			WebElement programTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + programtype + "']")));
			programTypeOption.click();

			WebElement schemeType = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(loc.getProperty("scheme-Type"))));
			schemeType.click();

			WebElement schemeTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + scheme + "']")));
			schemeTypeOption.click();

			// Enter the Applicant Name
			WebElement applicantName = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("applicant-Name"))));
			applicantName.sendKeys(applicantname);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement idTyperadioButton = driver.findElement(By.id("inline-selection-2"));
			idTyperadioButton.click();

			Thread.sleep(2000);

			WebElement nicRadio = driver.findElement(By.id("formNICNumberType-O"));
			nicRadio.click();

			Thread.sleep(2000);

			// Enter the nic Number
			WebElement nicNumber = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("nic-Number"))));
			nicNumber.sendKeys(nic);

			// scroll down
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			// click search button
			WebElement searchButton = driver
					.findElement(By.xpath(loc.getProperty("search-Button")));
			searchButton.click();

			Thread.sleep(2000);

			// scroll down
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800);");
			Thread.sleep(2000);

			// Verify the success message "Application Drafted Successfully"
			WebElement successMessage = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[text()='Application Drafted Successfully']")));

			// Assert that the text matches the expected message
			Assert.assertEquals(successMessage.getText(), "Application Drafted Successfully",
					"The Application Drafted success message does not match!");

			// select province
			WebElement provinceType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty(
					"province-Type"))));
			provinceType.click();

			Thread.sleep(2000);

			WebElement provinceOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + province + "']")));
			provinceOption.click();

			Thread.sleep(2000);

			// select district
			WebElement districtType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty(
					"district-Type"))));
			districtType.click();

			WebElement districtOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + district + "']")));
			districtOption.click();

			Thread.sleep(2000);

			// select DS division
			WebElement dsType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty(
					"ds-Type"))));
			dsType.click();

			WebElement dsOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + dsDivision + "']")));
			dsOption.click();

			Thread.sleep(2000);

			// select GN
			WebElement gnType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty(
					"gn-Type"))));
			gnType.click();

			WebElement gnOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + gnDivision + "']")));
			gnOption.click();

			Thread.sleep(2000);

			// provide applied Date
			WebElement appliedDate = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("applied-Date"))));
			appliedDate.click();

			WebElement appliedDateOption = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='" + applieddate + "']")));
			appliedDateOption.click();

			Thread.sleep(2000);

			// provide file received date
			WebElement filereceivedDate = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("filereceived-Date"))));
			filereceivedDate.click();

			WebElement filereceiveDateOption = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='" + receiveddate + "']")));
			filereceiveDateOption.click();

			// Select the allocate User Dropdown
			WebElement allocateUserDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty(
					"allocateUser-Dropdown"))));
			allocateUserDropdown.click();

			Thread.sleep(2000);

			WebElement allocateOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + allocateType + "']")));
			allocateOption.click();

			Thread.sleep(2000);

			// Click the proceed Button
			WebElement proceedButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("proceed-Button"))));
			proceedButton.click();

			// Enter remark
			WebElement remark = wait.until(ExpectedConditions.elementToBeClickable(By.id("remark")));
			remark.sendKeys("No");

			Thread.sleep(2000);

			// Click the ok Button
			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			okButton.click();

			// Click the ok2 Button
			WebElement ok2Button = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("ok-Button"))));
			ok2Button.click();

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
