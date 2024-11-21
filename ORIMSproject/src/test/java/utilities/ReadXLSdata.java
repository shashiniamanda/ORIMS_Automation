package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

    private String[][] readDataFromSheet(String sheetName) throws IOException {
        File excelfile = new File("./src/test/resources/testdata/testdata.xlsx");
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

    @DataProvider(name = "App-draft")
    public String[][] getAppDraftData() throws IOException {
        return readDataFromSheet("App-draft");
    }
    @DataProvider(name = "Section2")
    public String[][] getSection2Data() throws IOException {
        return readDataFromSheet("Section2");
    }
    @DataProvider(name = "Section3")
    public String[][] getSection3Data() throws IOException {
        return readDataFromSheet("Section3");
    }
    @DataProvider(name = "Section4")
    public String[][] getSection4Data() throws IOException {
        return readDataFromSheet("Section4");
    }

}
