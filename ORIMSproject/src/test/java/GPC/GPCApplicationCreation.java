package GPC;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadDataForGPC;


import java.time.Duration;

public class GPCApplicationCreation  extends BaseTest {
    @Test(priority = 3)
    public static void AppCreationSection1_GPC() throws InterruptedException {

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

            WebElement GPCTile = driver.findElement(
                    By.xpath(loc.getProperty("gpc-tile")));
            GPCTile.click();

            Thread.sleep(4000);

            WebElement row = driver.findElement(By.xpath(
                    loc.getProperty("comp-gpc-firstRow")));
            row.click();

            Thread.sleep(5000);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3200);");
            Thread.sleep(3000);

            WebElement proceedButton = driver.findElement(
                    By.xpath(loc.getProperty("gpc-proceed")));
            proceedButton.click();

            Thread.sleep(3000);

            WebElement remark = wait.until(ExpectedConditions
                   .elementToBeClickable(By.id(loc.getProperty("similar-record-remark"))));
            remark.sendKeys("Testing");

            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable((By
                    .cssSelector(loc.getProperty("remark-ok")))));
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
    @Test(priority = 4, dataProvider = "Section2", dataProviderClass = ReadDataForGPC.class)
    public static void AppCreationSection2_GPC(String appTitle, String address)
            throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            Thread.sleep(2000);

            WebElement titleType = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("title-type"))));
            titleType.click();

            WebElement titleOption = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + appTitle + "']")));
            titleOption.click();

            Thread.sleep(2000);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement addressField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("addressField"))));
            addressField.sendKeys(address);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement nextButton = driver.findElement(
                    By.xpath(loc.getProperty("gpc-next-button")));
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

    // Section 3 - Affected Property Information
    @Test(priority = 5, dataProvider = "Section3", dataProviderClass = ReadDataForGPC.class)
    public static void AppCreationSection3_GPC(String affectedAddress, String place, String ownership,
                                           String amount, String compDate, String roof, String walls, String value, String doorsWindows, String approvedValue) throws InterruptedException {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            WebElement address = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("affected-address"))));
            address.sendKeys(affectedAddress);

            Thread.sleep(2000);

            WebElement placeField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("gpc-place"))));
            placeField.sendKeys(place);

            Thread.sleep(2000);

            WebElement ownershipType = wait.until(ExpectedConditions.elementToBeClickable(By.id(
                    loc.getProperty("ownership"))));
            ownershipType.click();

            Thread.sleep(2000);

            WebElement ownershipOption = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + ownership + "']")));
            ownershipOption.click();

            Thread.sleep(2000);

            WebElement amountField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("amount"))));
            amountField.sendKeys(amount);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement complaintDate = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath(loc.getProperty("complaint-date"))));
            complaintDate.click();

            WebElement complaintDateOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[@aria-label='" + compDate + "']")));
            complaintDateOption.click();

            Thread.sleep(2000);

            WebElement houseSection = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath(loc.getProperty("house-hover"))));
            houseSection.click();

            Thread.sleep(2000);

            WebElement roofField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("house-roof"))));
            roofField.sendKeys(roof);

            WebElement wallsField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("house-walls"))));
            wallsField.sendKeys(walls);

            WebElement valueField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("estimated-value"))));
            valueField.sendKeys(value);

            WebElement doorsField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("doors-windows"))));
            doorsField.sendKeys(doorsWindows);

            WebElement approvedValueField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("value-approved"))));
            approvedValueField.sendKeys(approvedValue);

            Thread.sleep(2000);

            WebElement valueAddButton = driver.findElement(
                    By.xpath(loc.getProperty("value-add-button")));
            valueAddButton.click();

            Thread.sleep(2000);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement compensationButton = driver.findElement(
                    By.xpath(loc.getProperty("calculate-button")));
            compensationButton.click();

            Thread.sleep(4000);

            WebElement nextButton = driver.findElement(
                    By.xpath(loc.getProperty("gpc-section3-next")));
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

    // Section 4 - Bank Details
    @Test(priority = 6, dataProvider = "Section4", dataProviderClass = ReadDataForGPC.class)
    public static void AppCreationSection4_GPC(String bankname, String brName, String accNo) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement bankType = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("bank-name"))));
            bankType.click();

            WebElement bankOption = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + bankname + "']")));
            bankOption.click();

            Thread.sleep(2000);

            WebElement branchName = wait.until(ExpectedConditions.elementToBeClickable(By.id(
                    loc.getProperty("branch-name"))));
            branchName.click();

            WebElement branchOption = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + brName + "']")));
            branchOption.click();

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement accnoField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("acc-no"))));
            accnoField.sendKeys(accNo);


            WebElement addButton = driver.findElement(
                    By.xpath(loc.getProperty("addButtonSection4")));
            addButton.click();

            Thread.sleep(3000);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
            Thread.sleep(3000);


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
    public static void AppCreationSection5_GPC() {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
