package GPC;

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
import java.util.Set;

public class GPCApprovalProcess extends BaseTest {

    @Test(priority = 8)
    public void RecommendationApproval() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Recommendation
            WebElement navigationMenu = driver
                    .findElement(By.xpath(loc.getProperty("recommendation-tile")));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement CompensationTile = driver.findElement(
                    By.xpath(loc.getProperty("recommendation-compensation")));
            CompensationTile.click();

            Thread.sleep(2000);

            WebElement GPCTile = driver.findElement(
                    By.xpath(loc.getProperty("recommendation-gpc")));
            GPCTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    loc.getProperty("recommendation-gpc-firstRow")));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000);");
            Thread.sleep(2000);

            WebElement recommendButton = driver.findElement(
                    By.xpath(loc.getProperty("recommend-to-pay")));
            recommendButton.click();


            Thread.sleep(2000);


            WebElement okButton = driver.findElement(
                    By.id("confirmation-ok"));
            okButton.click();

            Thread.sleep(5000);

            //Assertion
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

            String expectedMessage = "Application Approved Successfully";
            Assert.assertEquals(toastText, expectedMessage, "Recommendation approval process was unsuccessful.");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test(priority = 9)
    public void ApprovalStageApproval() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Approval
            WebElement navigationMenu = driver
                    .findElement(By.xpath(loc.getProperty("comp-approval")));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement CompensationTile = driver.findElement(
                    By.xpath(loc.getProperty("approval-comp")));
            CompensationTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath(loc.getProperty("approval-gpc")));
            MpTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    loc.getProperty("approval-gpc-firstRow")));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000);");
            Thread.sleep(2000);


            WebElement approveButton = driver.findElement(
                    By.xpath(loc.getProperty("approval-approve")));
            approveButton.click();


            Thread.sleep(2000);


            WebElement okButton = driver.findElement(
                    By.id(loc.getProperty("confirm-ok-button")));
            okButton.click();

            Thread.sleep(5000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

            String expectedMessage = "Application Approved Successfully";
            Assert.assertEquals(toastText, expectedMessage, "Approval stage's approval process was unsuccessful.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 10)
    public void CertificationApproval() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Certification
            WebElement navigationMenu = driver
                    .findElement(By.xpath(loc.getProperty("certification-tile")));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement CompensationTile = driver.findElement(
                    By.xpath(loc.getProperty("certification-comp")));
            CompensationTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath(loc.getProperty("certification-gpc")));
            MpTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    loc.getProperty("certification-gpc-firstRow")));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000);");
            Thread.sleep(2000);


            WebElement approveButton = driver.findElement(
                    By.xpath(loc.getProperty("certification-approve")));
            approveButton.click();


            Thread.sleep(2000);


            WebElement okButton = driver.findElement(
                    By.id(loc.getProperty("confirm-ok-button")));
            okButton.click();

            Thread.sleep(5000);

            //Assertion
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

            String expectedMessage = "Application Approved Successfully";
            Assert.assertEquals(toastText, expectedMessage, "Certification approval process was unsuccessful.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 11, dataProvider = "chequeDetails", dataProviderClass = ReadXLSdata.class)
    public void ChequeApproval(String voucherNumber, String chequeNumber, String chequeIssuedDate) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Manage Cheque Details
            WebElement navigationMenu = driver
                    .findElement(By.xpath(loc.getProperty("cheque-payment-tile")));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement manageChequeTile = driver.findElement(
                    By.xpath(loc.getProperty("manage-cheque-tile")));
            manageChequeTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath(loc.getProperty("cheque-payment-gpc")));
            MpTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    loc.getProperty("cheque-payment-gpc-firstRow")));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);


            WebElement voucherNo = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("voucher-no"))));
            voucherNo.sendKeys(voucherNumber);

            Thread.sleep(2000);

            WebElement chequeNo = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id(loc.getProperty("cheque-no"))));
            chequeNo.sendKeys(chequeNumber);

            Thread.sleep(2000);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement chequeDate = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("cheque-date"))));
            chequeDate.click();

            WebElement chequeDateOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[@aria-label='" + chequeIssuedDate + "']")));
            chequeDateOption.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800);");
            Thread.sleep(2000);


            WebElement addButton = driver.findElement(
                    By.xpath(loc.getProperty("cheque-add-button")));
            addButton.click();

            Thread.sleep(2000);

            WebElement okButton = driver.findElement(
                    By.id("confirmation-ok"));
            okButton.click();

            Thread.sleep(2000);

            WebElement approveButton = driver.findElement(
                    By.xpath(loc.getProperty("cheque-approve")));
            approveButton.click();

            Thread.sleep(2000);

            WebElement ok2Button = driver.findElement(
                    By.id("confirmation-ok"));
            ok2Button.click();

            Thread.sleep(3000);

            //Assertion
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

            String expectedMessage = "Cheque payments approved successfully";
            Assert.assertEquals(toastText, expectedMessage, "Cheque approval process was unsuccessful.");

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 12, dataProvider = "chequePrint", dataProviderClass = ReadXLSdata.class)
    public void ChequePrint (String language, String paymentDate, String paymentReference, String officer){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            WebElement previousMenu = driver
                    .findElement(By.xpath(loc.getProperty("previous-menu")));
            previousMenu.click();

            Thread.sleep(2000);

            WebElement chequeTile = driver.findElement(
                    By.xpath(loc.getProperty("cheque-tile")));
            chequeTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath(loc.getProperty("cheque-print-gpc")));
            MpTile.click();

            Thread.sleep(2000);

            WebElement chequeButton = driver.findElement(By.xpath(
                    loc.getProperty("cheque-button")));
            chequeButton.click();

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(500,0);");
            Thread.sleep(2000);

            WebElement chequeDetailsButton = driver.findElement(
                    By.xpath(loc.getProperty("cheque-detail-button")));
            chequeDetailsButton.click();

            Thread.sleep(2000);

            WebElement chequeRow = driver.findElement(By.xpath(
                    loc.getProperty("cheque-row")));
            chequeRow.click();

            Thread.sleep(2000);

            String originalTab = driver.getWindowHandle();

            WebElement chequePrintButton = driver.findElement(
                    By.xpath(loc.getProperty("cheque-print-button")));
            chequePrintButton.click();

            Thread.sleep(2000);

            WebElement printChequeOk = driver.findElement(
                    By.id(loc.getProperty("confirm-ok-button")));
            printChequeOk.click();

            Thread.sleep(2000);

            Set<String> allTabs = driver.getWindowHandles();

            // Iterate through handles to find the new tab
            for (String tab : allTabs) {
                if (!tab.equals(originalTab)) {
                    // Switch to the new tab
                    driver.switchTo().window(tab);

                    // Perform any actions if needed, e.g., validate the cheque display
                    System.out.println("Cheque tab title: " + driver.getTitle());

                    // Close the cheque tab
                    driver.close();

                    // Break after closing the new tab
                    break;
                }
            }

            // Switch back to the original tab
            driver.switchTo().window(originalTab);

            // Verify redirection back to the original tab
            System.out.println("Back to original tab: " + driver.getTitle());

            // Continue with other actions or close the driver
            driver.quit();
            Thread.sleep(2000);


            //Assertion
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String toastText = (String) js.executeScript("return document.querySelector('.Toastify__toast-body').innerText");

            String expectedMessage = "Cheque printed successfully";
            Assert.assertEquals(toastText, expectedMessage, "Cheque print was unsuccessful.");

            WebElement printReportButton = driver.findElement(
                    By.xpath(loc.getProperty("print-report-button")));
            printReportButton.click();
            Thread.sleep(2000);

            WebElement reportCloseButton = driver.findElement(
                    By.xpath(loc.getProperty("report-close")));
            reportCloseButton.click();

            Thread.sleep(2000);

            WebElement coverLetterOk = driver.findElement(
                    By.id(loc.getProperty("confirm-ok-button")));
            coverLetterOk.click();

            WebElement coverLetterLang = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath(loc.getProperty("cover-letter-lan"))));
            coverLetterLang.click();

            WebElement coverletterLanOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[@aria-label='"+ language +"']")));
            coverletterLanOption.click();

            Thread.sleep(2000);

            WebElement coverLetterPrint = driver.findElement(
                    By.xpath(loc.getProperty("cover-letter-print")));
            coverLetterPrint.click();

            Thread.sleep(2000);

            WebElement paymentDetailsButton = driver.findElement(
                    By.xpath(loc.getProperty("payment-detail-button")));
            paymentDetailsButton.click();

            Thread.sleep(2000);

            WebElement paymentDateSelection = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath(loc.getProperty("payment-date-selection"))));
            paymentDateSelection.click();


            WebElement paymentDateOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[@aria-label='"+ paymentDate+"']")));
            paymentDateOption.click();

            Thread.sleep(2000);

            WebElement paymentReferenceField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id("formPostedReferenceNumber")));
            paymentReferenceField.sendKeys(paymentReference);

            Thread.sleep(2000);

            WebElement paymentOfficer = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id("formPostedBy")));
            paymentOfficer.sendKeys(officer);

            WebElement addButton = driver.findElement(
                    By.xpath(loc.getProperty("payment-details-add")));
            addButton.click();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
