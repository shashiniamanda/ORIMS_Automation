package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXLSDataLoan {
    private String[][] readDataFromSheet(String sheetName) throws IOException {
        File excelfile = new File("./src/test/resources/testdata/testdata2.xlsx");
        FileInputStream fis = new FileInputStream(excelfile);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRows - 1][noOfColumns];
        DataFormatter df = new DataFormatter();

        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }

        wb.close();
        fis.close();
        return data;
    }

    @DataProvider(name = "loginData")
    public String[][] getLoginData() throws IOException {
        return readDataFromSheet("Login");
    }

    @DataProvider(name = "Cheque-details")
    public String[][] getChequeDetailstData() throws IOException {
        return readDataFromSheet("Cheque-details");
    }

    @DataProvider(name = "Loan-draft")
    public String[][] getLoanDraftData() throws IOException {
        return readDataFromSheet("Loan-draft");
    }

    @DataProvider(name = "Section2")
    public String[][] section2DraftData() throws IOException {
        return readDataFromSheet("Section2");
    }

    @DataProvider(name = "Section3")
    public String[][] section3DraftData() throws IOException {
        return readDataFromSheet("Section3");
    }

    @DataProvider(name = "Section4")
    public String[][] section4DraftData() throws IOException {
        return readDataFromSheet("Section4");
    }

    @DataProvider(name = "Section2Return")
    public String[][] Section2ReturnDraftData() throws IOException {
        return readDataFromSheet("Section2Return");
    }

    @DataProvider(name = "Section3Return")
    public String[][] Section3ReturnDraftData() throws IOException {
        return readDataFromSheet("Section3Return");
    }

    @DataProvider(name = "Section4Return")
    public String[][] Section4ReturnDraftData() throws IOException {
        return readDataFromSheet("Section4Return");
    }

}
