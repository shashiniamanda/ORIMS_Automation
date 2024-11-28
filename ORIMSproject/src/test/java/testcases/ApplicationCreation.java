package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class ApplicationCreation extends BaseTest {

	@Test(priority = 3)
	public static void AppCreationSection1() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		// Navigate to the necessary page
		try {
			Thread.sleep(2000);
			WebElement navigationMenu = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/div[1]"));
			navigationMenu.click();

			Thread.sleep(2000);

			WebElement CompensationTile = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/button"));
			CompensationTile.click();

			Thread.sleep(2000);

			WebElement MpTile = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[8]/button"));
			MpTile.click();

			Thread.sleep(2000);

			// Locate the 2nd row and click it
			WebElement row = driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]"));
			row.click();

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000);");
			Thread.sleep(2000);

			WebElement proceedButton = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button[1]"));
			proceedButton.click();

			Thread.sleep(3000);

			WebElement remark = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("remark")));
			remark.sendKeys("Testing");

			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable((By
					.cssSelector("body > div.fade.modal.show > div > div > div.modal-footer > button.save-button"))));
			okButton.click();

			Thread.sleep(2000);

			WebElement section2Button = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/button"));
			section2Button.click();

			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "The application has been modified successfully";
			Assert.assertEquals(toastText, expectedMessage, "Toast message did not match!");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Section 2 - Applicant Details
	@Test(priority = 4, dataProvider = "Section2", dataProviderClass = ReadXLSdata.class)
	public static void AppCreationSection2(String appType, String appTitle, String address, String relationship)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			WebElement applicantType = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"file-applicant-details-form\"]/div[1]/div/div/div[1]/div[2]")));
			applicantType.click();

			WebElement applicantTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+appType+"']")));
			applicantTypeOption.click();

			Thread.sleep(2000);

			WebElement titleType = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formGroupTitle\"]")));
			titleType.click();

			WebElement titleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+appTitle+"']")));
			titleOption.click();

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement addressField = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formApplicantAddress\"]")));
			addressField.sendKeys(address);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement relationshipType = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formRelationshipAgPerson\"]")));
			relationshipType.click();

			Thread.sleep(2000);

			WebElement relationshipTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+relationship+"']")));
			relationshipTypeOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement nextButton = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/button[2]"));
			nextButton.click();

			Thread.sleep(2000);

			WebElement okButton = driver.findElement(By.xpath("//*[@id=\"confirmation-ok\"]"));
			okButton.click();

			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Drafted Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Toast message did not match!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Section 3 - Aggrieved Person Details
	@Test(priority = 5, dataProvider = "Section3", dataProviderClass = ReadXLSdata.class)
	public static void AppCreationSection3(String title, String name, String nic, String marital, String address, String province,
			String district, String dsDivision, String gnDivision, String place, String compDate) throws InterruptedException {
		WebDriverWait wait;
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			WebElement titleType = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formGroupTitle\"]")));
			titleType.click();

			WebElement titleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" +title+ "']")));
			titleOption.click();

			Thread.sleep(2000);

			WebElement applicantName = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formApplicantName\"]")));
			applicantName.sendKeys(name);

			Thread.sleep(2000);

			WebElement idTyperadioButton = driver.findElement(By.id("inline-selection-2"));
			idTyperadioButton.click();

			Thread.sleep(2000);

			WebElement nicRadio = driver.findElement(By.id("formNICNumberType-O"));
			nicRadio.click();

			WebElement nicNumber = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("formNICNumber")));
			nicNumber.sendKeys(nic);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement maritalType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/form/div[8]/div[3]/select")));
			maritalType.click();

			WebElement maritalOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + marital + "']")));
			maritalOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement addressField = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("formPermanentAddressWhenIncidentOccurred")));
			addressField.sendKeys(address);

			WebElement provinceType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"file-aggrieved-person-details-form\"]/div[10]/div[1]/div[1]/div/div[1]/div[2]")));
			provinceType.click();

			Thread.sleep(2000);

			WebElement provinceOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + province + "']")));
			provinceOption.click();

			Thread.sleep(2000);

			WebElement districtType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"file-aggrieved-person-details-form\"]/div[10]/div[2]/div[1]/div/div[1]/div[2]")));
			districtType.click();

			WebElement districtOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + district + "']")));
			districtOption.click();

			Thread.sleep(2000);

			WebElement ds = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id='file-aggrieved-person-details-form']/div[10]/div[3]/div[1]/div/div[1]/div[2]")));
			ds.click();

			WebElement dsOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + dsDivision + "']")));
			dsOption.click();

			Thread.sleep(2000);
			
			WebElement gn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"file-aggrieved-person-details-form\"]/div[10]/div[4]/div[1]/div/div[1]/div[2]")));
			gn.click();

			WebElement gnOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + gnDivision + "']")));
			gnOption.click();
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement placeField = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("formPlaceOfTheIncident")));
			placeField.sendKeys(place);


			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement complaintDate = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"file-aggrieved-person-details-form\"]/div[15]/div[2]/div[2]/div[1]/div/input")));
			complaintDate.click();

			WebElement complaintDateOption = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@aria-label='"+compDate+"']")));
			complaintDateOption.click();
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement compensationButton = driver.findElement(
					By.xpath("//*[@id=\"file-aggrieved-person-details-form\"]/div[17]/div/button"));
			compensationButton.click();

			Thread.sleep(4000);

			WebElement nextButton = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/button[1]"));
			nextButton.click();

			Thread.sleep(3000);

			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable((By
					.cssSelector("body > div.fade.modal.show > div > div > div.modal-footer > button.save-button"))));
			okButton.click();

			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Drafted Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Toast message did not match!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Section 4 - Dependent Details
	@Test(priority = 6, dataProvider = "Section4", dataProviderClass = ReadXLSdata.class)
	public static void AppCreationSection4(String title, String marital, String address, String compValue ) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			
			WebElement titleType = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formGroupTitle\"]")));
			titleType.click();

			WebElement titleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + title + "']")));
			titleOption.click();

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700);");
			Thread.sleep(2000);
			
			WebElement maritalType = wait.until(ExpectedConditions.elementToBeClickable(By.id(
					"formDpMaritalStatus")));
			maritalType.click();

			WebElement maritalOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + marital + "']")));
			maritalOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement addressField = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formDpCity\"]")));
			addressField.sendKeys(address);
			
			WebElement  printCheckbox= driver.findElement(By.xpath("//*[@id=\"file-dependent-details-form\"]/div[12]/div[2]/div[1]/div/input"));
			printCheckbox.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600);");
			Thread.sleep(3000);
			
			WebElement addButton = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div[2]/button"));
			addButton.click();

			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
			Thread.sleep(3000);
			
			WebElement compensationButton = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[4]/div[2]/button"));
			compensationButton.click();

			Thread.sleep(3000);
			
			WebElement compensationField = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[4]/div[2]/table/tbody/tr/td[3]/div/input")));
			compensationField.sendKeys(compValue);

			WebElement addButton2 = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[4]/div[3]/button"));
			addButton2.click();

			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
			Thread.sleep(2000);


			WebElement nextButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/button[1]")));
			nextButton.click();
			
			Thread.sleep(2000);

			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable((By
					.id("confirmation-ok"))));
			okButton.click();

			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Drafted Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Toast message did not match!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Section 5
	@Test(priority = 7)
	public static void AppCreationSection5() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-300);");
			Thread.sleep(3000);

			WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/button"));
			uploadElement.click();

			Thread.sleep(2000);
			uploadElement.sendKeys("C:\\Users\\Sheli\\Downloads\\document1.pdf");


			Thread.sleep(2000);

			WebElement okButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")));
			okButton.click();
			Thread.sleep(5000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
			Thread.sleep(2000);

			WebElement submitButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button[1]")));
			submitButton.click();


			WebElement ok2Button = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirmation-ok\"]")));
			ok2Button.click();

			Thread.sleep(5000);

			WebElement ok3Button = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div[3]/button")));
			ok3Button.click();

			// Assertion
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Created Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Toast message did not match!");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	



}
