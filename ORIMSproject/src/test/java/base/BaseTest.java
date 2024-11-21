package base;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
		
		if (driver==null) {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\\\test\\\\resources\\\\config\\\\config.properties");
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\\\test\\\\resources\\\\config\\\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		}	
		
	}
		
		@Test(dataProvider = "loginData", dataProviderClass = ReadXLSdata.class, priority =1)
		public void Login(String username,String password) throws InterruptedException {
			// Fill the username
			driver.findElement(By.id(loc.getProperty("user-name"))).sendKeys(username);
			// Fill the password
			driver.findElement(By.id(loc.getProperty("pass-word"))).sendKeys(password);
			// Interact with the Login button
			driver.findElement(By.className(loc.getProperty("loginbutton"))).click();
			Thread.sleep(6000);
	}

	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		
	}

}
