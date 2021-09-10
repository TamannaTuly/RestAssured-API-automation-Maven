package DataReadWriteUtility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MethodofReadWrite {
    public Object ReadTestData(String excelPath, int row, int column) throws IOException {
        File excelFile = new File(excelPath);
        FileInputStream file = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheetAt(0);

        DataFormatter formatter = new DataFormatter();
        Object valueofCell = formatter.formatCellValue(sheet.getRow(row).getCell(column));

//        workbook.close();
//        file.close();
        return valueofCell;

    }



}
