package DataProvider.Classes;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream input = null ;

    public FileInputStream getFileInputStream()
    {
        String filePath = System.getProperty("user.dir")+PathReader.PathReader.getProperty("HomePage");
        File srcFile = new File(filePath);

        try {
            input = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found. terminating Process !! : Check file path of TestData");
            System.exit(0);
        }
        return input ;
    }

    public String getExcelData() throws IOException
    {
        input = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(input);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum()+1);
        int TotalNumberOfCols = 2 ;
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
        String URL = cell.toString();

        wb.close();
        return URL;
    }
}
