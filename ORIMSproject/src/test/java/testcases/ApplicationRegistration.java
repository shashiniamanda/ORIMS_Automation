package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class ApplicationRegistration extends BaseTest{
	
	@Test(dataProvider="loginData", dataProviderClass = ReadXLSdata.class, priority=1)
	public static void Login(String username, String password) throws InterruptedException {
		//Fill the username
		driver.findElement(By.id(loc.getProperty("user-name"))).sendKeys(username);
		//Fill the password
        driver.findElement(By.id(loc.getProperty("pass-word"))).sendKeys(password);
        // Interact with the Login button
        driver.findElement(By.className(loc.getProperty("loginbutton"))).click();
        Thread.sleep(8000);
	}
	
	@Test(dataProvider="App-draft", dataProviderClass = ReadXLSdata.class, priority=2)
	public static void ApplicationDraft(String programtype, String scheme, String incidentype, String incDate, String applicantName, String nic) throws InterruptedException {
	    // Navigate to the necessary page
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/div[1]")).click();
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/button/div[2]")).click();
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/button")).click();

	    // Interact with program type dropdown
	    WebElement programTypeDropdown = driver.findElement(By.cssSelector("#file-registration-form > div:nth-child(1) > div:nth-child(2) > div > div > div.css-1d8n9bt > div.css-1y2qbuw"));
	    programTypeDropdown.click();
	    WebElement programTypeOption = driver.findElement(By.xpath("//div[text()='" + programtype + "']"));
	    programTypeOption.click();

	    // Interact with scheme dropdown
	    WebElement schemeDropdown = driver.findElement(By.xpath("//*[@id=\"file-registration-form\"]/div[1]/div[3]/div/div/div[1]/div[2]")); 
	    schemeDropdown.click();
	    WebElement schemeOption = driver.findElement(By.xpath("//div[text()='" + scheme + "']"));
	    schemeOption.click();

	    // Interact with incident type dropdown
	    WebElement incidentTypeDropdown = driver.findElement(By.xpath("//*[@id=\"file-registration-form\"]/div[1]/div[4]/div/div/div[1]/div[2]")); 
	    incidentTypeDropdown.click();
	    WebElement incidentTypeOption = driver.findElement(By.xpath("//div[text()='" + incidentype + "']"));
	    incidentTypeOption.click();

	    // Interact with incident Date datepicker
	    WebElement incidentDateField = driver.findElement(By.xpath("//*[@id=\"file-registration-form\"]/div[1]/div[5]/div/div/input")); 
	    JavascriptExecutor js = null;
		js.executeScript("arguments[0].value='" + incDate + "';", incidentDateField);

	    // Interact with ID type radio button
	    WebElement idType = driver.findElement(By.xpath("//*[@id=\"inline-selection-2\"]"));
	    idType.click();

	    // Fill in applicant name
	    driver.findElement(By.id("formApplicantName")).sendKeys(applicantName);

	    // Interact with NIC type radio button
	    WebElement nicType = driver.findElement(By.id("formNICNumberType-O"));
	    nicType.click();

	    // Fill in NIC number
	    driver.findElement(By.id("formNICNumber")).sendKeys(nic);

	    // Submit the form
	    WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/button[2]"));
	    submitButton.click();
	}

}
