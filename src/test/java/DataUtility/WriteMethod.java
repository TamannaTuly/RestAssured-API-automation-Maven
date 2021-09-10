package DataUtility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WriteMethod {
    public static Workbook workbook;
    public static Sheet sheet;
    public static FileInputStream fileInputStream;
    public static FileOutputStream fileOutputStream;
    public static Row row;
    public static Cell cell;

    public void writeIntoExcel(String excelPath, int rowNum, int colNum, String value) throws Exception {
        fileInputStream =new FileInputStream(excelPath);
        workbook= WorkbookFactory.create(fileInputStream);
        sheet=workbook.getSheet("Sheet1");

        row=sheet.getRow(rowNum);
        cell=row.createCell(colNum);
        cell.setCellValue(value);

        fileOutputStream = new FileOutputStream(excelPath);

        workbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }



}
