package utilities.readers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    static String filePath = "0";
    static XSSFWorkbook wb;

    public static void setPath(String filePath) throws IOException{
        File InputsFile = new File(filePath);
        FileInputStream fip = new FileInputStream(InputsFile);
        wb = new XSSFWorkbook(fip); //HSSFWorkbook for xls format, XSSFWorkbook for xlsx format
    }

    public static String read(int rowNumber, int columnNumber) throws IOException{
        String cellData = "2";
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(columnNumber);
        if (cellData != null && cell != null) //for NullPoiterException
            cellData = cell.getStringCellValue().toString();
        return cellData;
    }
}
