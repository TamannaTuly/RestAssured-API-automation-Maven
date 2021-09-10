package DataUtility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelRW {

//    String excelPath ="./Data/TestData.xlsx";
    private static Workbook wb;
    private static Sheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;


//    public static void main(String[] args) {
//        writesomething("./Data/TestData.xlsx","Pass",1,4);
//    }
    public static void writesomething(String dataPath, String write, int r, int c){
//        String excelPath = "./Data/TestData.xlsx";
        try {
            fis = new FileInputStream(dataPath);
            try {
                wb = WorkbookFactory.create(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sh = wb.getSheet("Sheet1");
            int rows = sh.getLastRowNum();
            System.out.println(rows);
            row = sh.getRow(r);
            cell = row.createCell(c);
            cell.setCellValue(write);
            System.out.println(cell.getStringCellValue());
            fos = new FileOutputStream(dataPath);
            try {
                wb.write(fos);
                fos.flush();
                fos.close();
                System.out.println("DONE");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
