package MP;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

@Listeners(utilities.Listener.class)
public class ApplicationRegistration extends BaseTest {


	@Test(dataProvider = "App-draft", dataProviderClass = ReadXLSdata.class, priority = 2)
	public static void ApplicationDraft(String programtype, String scheme, String incidentype, String incDate,
			String applicantName, String nic, String province, String district, String dsDivision, String gnDivision,
			String appliedD, String receivedD, String allocation) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		// Navigate to the necessary page
		try {
			Thread.sleep(2000);
			WebElement navigationMenu = driver
					.findElement(By.xpath(loc.getProperty("application-registration")));
			navigationMenu.click();

			Thread.sleep(2000);

			WebElement fileRegisterTile = driver.findElement(
					By.xpath(loc.getProperty("fileRegistration-tile")));
			fileRegisterTile.click();

			Thread.sleep(2000);

			WebElement fileRegisterTile02 = driver.findElement(
					By.xpath(loc.getProperty("fileRegistration-tile")));
			fileRegisterTile02.click();

			Thread.sleep(2000);

			WebElement addButton = driver.findElement(
					By.xpath(loc.getProperty("addButton")));
			addButton.click();

			Thread.sleep(2000);

			WebElement programType = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("program-type"))));
			programType.click();

			WebElement programTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+ programtype +"']")));
			programTypeOption.click();

			WebElement schemeType = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("scheme-type"))));
			schemeType.click();

			Thread.sleep(2000);

			WebElement schemeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+scheme+"']")));
			schemeOption.click();

			Thread.sleep(2000);

			WebElement incidentType = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("incident-type"))));
			incidentType.click();

			Thread.sleep(2000);

			WebElement incidentTypeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+incidentype+"']")));
			incidentTypeOption.click();

			Thread.sleep(2000);

			WebElement incidentDate = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(loc.getProperty("incident-date"))));
			incidentDate.click();

			WebElement incidentDateOption = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@aria-label='"+incDate+"']")));
			incidentDateOption.click();

			WebElement appName = wait
					.until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("applicant-name"))));
			appName.sendKeys(applicantName);

			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);

			WebElement idTyperadioButton = driver.findElement(By.id(loc.getProperty("idRadio-button")));
			idTyperadioButton.click();

			Thread.sleep(2000);

			WebElement nicRadio = driver.findElement(By.id(loc.getProperty("oldNIC-radio")));
			nicRadio.click();
			

			WebElement nicNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id(
					loc.getProperty("nicNumber"))));
			nicNumber.sendKeys(nic);
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
			Thread.sleep(2000);
			
			WebElement searchButton = driver.findElement(
					By.xpath(loc.getProperty("search-button")));
			searchButton.click();

			Thread.sleep(5000);

			//Assertion

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");


			System.out.println(toastText);

			String expectedMessage = "Application Drafted Successfully";
			Assert.assertEquals(toastText, expectedMessage, "Application initial draft was unsuccessful!");

			//Scroll down

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800);");
			Thread.sleep(2000);


			WebElement provinceType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("province-type"))));
			provinceType.click();
			
			Thread.sleep(2000);

			WebElement provinceOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + province + "']")));
			provinceOption.click();
			
			Thread.sleep(2000);

			WebElement districtType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("district-type"))));
			districtType.click();

			WebElement districtOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+ district +"']")));
			districtOption.click();
			
			Thread.sleep(2000);

			WebElement ds = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("ds-division"))));
			ds.click();

			WebElement dsOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+ dsDivision +"']")));
			dsOption.click();
			
			Thread.sleep(2000);

			WebElement gn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("gn-division"))));
			gn.click();

			WebElement gnOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+ gnDivision +"']")));
			gnOption.click();
			
			Thread.sleep(2000);

			WebElement appliedDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("applied-date"))));
			appliedDate.click();

			WebElement appliedDateOption = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@aria-label='"+ appliedD +"']")));
			appliedDateOption.click();
			
			Thread.sleep(2000);

			WebElement frDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("fr-date"))));
			frDate.click();

			WebElement frDateOption = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@aria-label='"+ receivedD +"']")));
			frDateOption.click();
			
			Thread.sleep(2000);

			WebElement allocated = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					loc.getProperty("allocated-user"))));
			allocated.click();

			WebElement allocatedOption = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[text()='Amanda User']")));
			allocatedOption.click();

			WebElement proceedButton = driver.findElement(
					By.xpath(loc.getProperty("proceed-button")));
			proceedButton.click();

			Thread.sleep(3000);

			WebElement remark = wait.until(ExpectedConditions
					.elementToBeClickable(By.id(loc.getProperty("similar-record-remark"))));
			remark.sendKeys("Testing");

			Thread.sleep(3000);

			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable((By.cssSelector(loc.getProperty("ok-button")))));
			okButton.click();

			Thread.sleep(2000);
			
		    WebElement ok2Button = wait.until(ExpectedConditions
							.elementToBeClickable((By.xpath(loc.getProperty("ok2button")))));
					ok2Button.click();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
