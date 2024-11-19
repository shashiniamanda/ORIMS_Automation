package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class ApplicationCreation extends BaseTest {
	
	@Test(priority=3)
	public static void AppCreation() throws InterruptedException {

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
			WebElement row = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]"));
			row.click();
			
			Thread.sleep(2000);
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000);");
			Thread.sleep(2000);
			
			WebElement proceedButton = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button[1]"));
			proceedButton.click();
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions
					.elementToBeClickable(By.id("remark")));

			WebElement okButton = wait.until(ExpectedConditions
					.elementToBeClickable((By.cssSelector("body > div.fade.modal.show > div > div > div.modal-footer > button.save-button"))));
			okButton.click();

			Thread.sleep(3000);
			
			WebElement section2Button = driver.findElement(
					By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/button"));
			section2Button.click();
			
			Thread.sleep(3000);
			
			//Section 2
			
			
			
			

			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
