package MP;

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
			WebElement applicationRegistrationMenu = driver
					.findElement(By.xpath(loc.getProperty("application-registration")));
			applicationRegistrationMenu.click();

			Thread.sleep(2000);

			WebElement CompensationTile = driver.findElement(
					By.xpath(loc.getProperty("compensation-tile-nav1")));
			CompensationTile.click();

			Thread.sleep(2000);

			WebElement MpTile = driver.findElement(
					By.xpath(loc.getProperty("mp-tile")));
			MpTile.click();

			Thread.sleep(2000);

			// Locate the 2nd row and click it
			WebElement row = driver.findElement(By.xpath(
					loc.getProperty("mp-section1-data-row")));
			row.click();

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000);");
			Thread.sleep(2000);

			WebElement proceedButton = driver.findElement(
					By.xpath(loc.getProperty("proceed-button")));
			proceedButton.click();

			Thread.sleep(3000);

			WebElement remark = wait.until(ExpectedConditions
					.elementToBeClickable(By.id(loc.getProperty("similar-record-remark"))));
			remark.sendKeys("Testing");

			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable((By
					.cssSelector(loc.getProperty("ok-button")))));
			okButton.click();

			Thread.sleep(2000);

			WebElement section2Button = driver.findElement(
					By.xpath(loc.getProperty("section2-button")));
			section2Button.click();

			Thread.sleep(2000);

			//Assertion

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "The application has been modified successfully";
			Assert.assertEquals(toastText, expectedMessage, "Application draft was unsuccessful in Section 1!");

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
					By.xpath(loc.getProperty("applicant-type"))));
			applicantType.click();

			WebElement applicantTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+appType+"']")));
			applicantTypeOption.click();

			Thread.sleep(2000);

			WebElement titleType = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("title-type"))));
			titleType.click();

			WebElement titleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+appTitle+"']")));
			titleOption.click();

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement addressField = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("addressField"))));
			addressField.sendKeys(address);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement relationshipType = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("relationshipType"))));
			relationshipType.click();

			Thread.sleep(2000);

			WebElement relationshipTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+relationship+"']")));
			relationshipTypeOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement nextButton = driver.findElement(
					By.xpath(loc.getProperty("nextButton")));
			nextButton.click();

			Thread.sleep(2000);

			WebElement okButton = driver.findElement(By.id(loc.getProperty("confirm-ok-button")));
			okButton.click();

			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Drafted Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Application draft was unsuccessful in Section 2!");

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
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("title-type"))));
			titleType.click();

			WebElement titleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" +title+ "']")));
			titleOption.click();

			Thread.sleep(2000);

			WebElement applicantName = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("applicant-name"))));
			applicantName.sendKeys(name);

			Thread.sleep(2000);

			WebElement idTypeRadioButton = driver.findElement(By.id(loc.getProperty("idRadio-button")));
			idTypeRadioButton.click();

			Thread.sleep(2000);

			WebElement nicRadio = driver.findElement(By.id(loc.getProperty("oldNIC-radio")));
			nicRadio.click();

			WebElement nicNumber = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("nicNumber"))));
			nicNumber.sendKeys(nic);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement maritalType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("maritalType"))));
			maritalType.click();

			WebElement maritalOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + marital + "']")));
			maritalOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement addressField = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("address-incident-occured"))));
			addressField.sendKeys(address);

			WebElement provinceType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("provinceType-agPerson"))));
			provinceType.click();

			Thread.sleep(2000);

			WebElement provinceOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + province + "']")));
			provinceOption.click();

			Thread.sleep(2000);

			WebElement districtType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("districtType-agPerson"))));
			districtType.click();

			WebElement districtOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + district + "']")));
			districtOption.click();

			Thread.sleep(2000);

			WebElement ds = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("dsDivision-agPerson"))));
			ds.click();

			WebElement dsOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + dsDivision + "']")));
			dsOption.click();

			Thread.sleep(2000);
			
			WebElement gn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("gnDivision-agPerson"))));
			gn.click();

			WebElement gnOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + gnDivision + "']")));
			gnOption.click();
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement placeField = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("place"))));
			placeField.sendKeys(place);


			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement complaintDate = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("complaintDate"))));
			complaintDate.click();

			WebElement complaintDateOption = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@aria-label='"+compDate+"']")));
			complaintDateOption.click();
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement compensationButton = driver.findElement(
					By.xpath(loc.getProperty("comp-button")));
			compensationButton.click();

			Thread.sleep(4000);

			WebElement nextButton = driver.findElement(
					By.xpath(loc.getProperty("next-button")));
			nextButton.click();

			Thread.sleep(3000);

			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable((By
					.cssSelector(loc.getProperty("ok-button")))));
			okButton.click();

			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Drafted Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Application draft was unsuccessful in Section 3!");

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
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("title-type"))));
			titleType.click();

			WebElement titleOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + title + "']")));
			titleOption.click();

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700);");
			Thread.sleep(2000);
			
			WebElement maritalType = wait.until(ExpectedConditions.elementToBeClickable(By.id(
					loc.getProperty("maritalStatusDp"))));
			maritalType.click();

			WebElement maritalOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + marital + "']")));
			maritalOption.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement addressField = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("address"))));
			addressField.sendKeys(address);
			
			WebElement  printCheckbox= driver.findElement(By.xpath(loc.getProperty("printCheckBox")));
			printCheckbox.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600);");
			Thread.sleep(3000);
			
			WebElement addButton = driver.findElement(
					By.xpath(loc.getProperty("addButtonSection4")));
			addButton.click();

			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
			Thread.sleep(3000);
			
			WebElement compensationButton = driver.findElement(
					By.xpath(loc.getProperty("compensation-button")));
			compensationButton.click();

			Thread.sleep(3000);
			
			WebElement compensationField = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("comp-field"))));
			compensationField.sendKeys(compValue);

			WebElement addButton2 = driver.findElement(
					By.xpath(loc.getProperty("add-button")));
			addButton2.click();

			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
			Thread.sleep(2000);


			WebElement nextButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("next-button"))));
			nextButton.click();
			
			Thread.sleep(2000);

			WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable((By
					.id(loc.getProperty("confirm-ok-button")))));
			okButton.click();

			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Drafted Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Application draft was unsuccessful in Section 4!");
			
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

			WebElement uploadElement = driver.findElement(By.xpath(loc.getProperty("upload-button")));
			uploadElement.click();

			Thread.sleep(2000);
			uploadElement.sendKeys("C:\\Users\\Sheli\\Downloads\\document1.pdf");


			Thread.sleep(2000);

			WebElement okButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("okButton"))));
			okButton.click();
			Thread.sleep(5000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
			Thread.sleep(2000);

			WebElement submitButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submit-button"))));
			submitButton.click();


			WebElement ok2Button = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("confirm-ok-button"))));
			ok2Button.click();

			Thread.sleep(5000);

			WebElement ok3Button = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("ok2Button"))));
			ok3Button.click();

			// Assertion
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

			String expectedMessage = "Application Created Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Application submission was unsuccessful!");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	



}
