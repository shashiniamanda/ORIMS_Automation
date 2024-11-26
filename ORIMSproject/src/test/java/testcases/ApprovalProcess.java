package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

import java.time.Duration;

public class ApprovalProcess extends BaseTest {

    @Test (priority = 2)
    public void RecommendationApproval() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Recommendation
            WebElement navigationMenu = driver
                    .findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/div[2]/span"));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement CompensationTile = driver.findElement(
                    By.xpath("//*[@id=\'root\']/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/button"));
            CompensationTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[8]/button"));
            MpTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[10]"));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000);");
            Thread.sleep(2000);

            WebElement recommendButton = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button[1]"));
            recommendButton.click();


            Thread.sleep(2000);


            WebElement okButton = driver.findElement(
                    By.id("confirmation-ok"));
            okButton.click();

            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 3)
    public void ApprovalStageApproval() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Approval
            WebElement navigationMenu = driver
                    .findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/div[3]/span"));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement CompensationTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/button"));
            CompensationTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[8]/button"));
            MpTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]"));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000);");
            Thread.sleep(2000);


            WebElement approveButton = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button[1]"));
            approveButton.click();


            Thread.sleep(2000);


            WebElement okButton = driver.findElement(
                    By.id("confirmation-ok"));
            okButton.click();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test (priority = 4)
    public void CertificationApproval() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Certification
            WebElement navigationMenu = driver
                    .findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/div[4]"));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement CompensationTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/button"));
            CompensationTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[8]/button"));
            MpTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[8]/button"));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000);");
            Thread.sleep(2000);


            WebElement approveButton = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/button[1]"));
            approveButton.click();


            Thread.sleep(2000);


            WebElement okButton = driver.findElement(
                    By.id("confirmation-ok"));
            okButton.click();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test (priority = 5, dataProvider = "chequeDetails", dataProviderClass = ReadXLSdata.class)
    public void ChequeApproval(String voucherNumber, String chequeNumber, String chequeIssuedDate) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Navigate to the necessary page
        try {
            //Cheque Print
            WebElement navigationMenu = driver
                    .findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/div[5]"));
            navigationMenu.click();

            Thread.sleep(2000);

            WebElement manageChequeTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/button/div[2]"));
            manageChequeTile.click();

            Thread.sleep(2000);

            WebElement MpTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[8]/button"));
            MpTile.click();

            Thread.sleep(2000);

            WebElement row = driver.findElement(By.xpath(
                    "//*[@id=\"left-tabs-example-tabpane-gpc\"]/div/div[2]/table/tbody/tr[1]"));
            row.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);


            WebElement voucherNo = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id("formVoucherNumber")));
            voucherNo.sendKeys(voucherNumber);

            Thread.sleep(2000);

            WebElement chequeNo = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id("formChequeNumber")));
            chequeNo.sendKeys(chequeNumber);

            Thread.sleep(2000);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
            Thread.sleep(2000);

            WebElement chequeDate = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[6]/div[1]/div/input")));
            chequeDate.click();

            WebElement chequeDateOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[@aria-label='"+ chequeIssuedDate +"']")));
            chequeDateOption.click();

            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800);");
            Thread.sleep(2000);


            WebElement addButton = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/form/div[2]/div[7]/div/button"));
            addButton.click();

            Thread.sleep(2000);

            WebElement okButton = driver.findElement(
                    By.id("confirmation-ok"));
            okButton.click();

            Thread.sleep(2000);

            WebElement approveButton = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/button[1]"));
            approveButton.click();

            Thread.sleep(2000);

            WebElement ok2Button = driver.findElement(
                    By.id("confirmation-ok"));
            ok2Button.click();

            Thread.sleep(3000);

            //cheque print

           navigationMenu.click();

            Thread.sleep(2000);

            WebElement chequeTile = driver.findElement(
                    By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/button"));
            chequeTile.click();

            Thread.sleep(2000);

            MpTile.click();

            Thread.sleep(2000);

            WebElement chequeButton = driver.findElement(By.xpath(
                    "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr[1]/td[12]/button"));
            chequeButton.click();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

