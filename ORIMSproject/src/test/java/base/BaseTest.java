package base;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ReadXLSDataLoan;
import utilities.ReadXLSdata;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr, fr1;

	public static WebElement dropdownElement;
	public static Select dropdown;


	@BeforeTest
	public void setup() throws IOException {

		if (driver == null) {
			fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\\\config.properties");
			fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\\\test\\\\resources\\\\config\\\\locators_file2.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		}

	}

	@Test(dataProvider = "loginData", dataProviderClass = ReadXLSDataLoan.class, priority = 1)
	public void Login(String username, String password) throws InterruptedException {
		// Fill the username
		driver.findElement(By.id(loc.getProperty("user-name"))).sendKeys(username);
		// Fill the password
		driver.findElement(By.id(loc.getProperty("pass-word"))).sendKeys(password);
		// Interact with the Login button
		driver.findElement(By.className(loc.getProperty("loginbutton"))).click();
		Thread.sleep(2000);



//		// Assertion for successful login
//		String currentUrl = driver.getCurrentUrl();
//
//		// Expected URL after successful login
//		String expectedUrl = "http://43.224.126.156:81/dashboard";
//
//		// Assert the current URL
//		Assert.assertEquals(currentUrl, expectedUrl, "The redirection URL after login is incorrect!");

	}


	
//	@AfterTest
//	public void tearDown() {
//
//		driver.close();
//
//	}

	public WebDriver getDriver() {
		return driver;
	}
}
