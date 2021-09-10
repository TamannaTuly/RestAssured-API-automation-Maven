package DataUtility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtilities {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public ExcelUtilities(String excelPath, String sheetName) {

        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet=workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getCelldata(int rowNum, int colNum){
        DataFormatter formatter = new DataFormatter();
        Object valueofCell = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        return valueofCell;
    }

    }

//    public Object setCelldata(int rowNum, int colNum){
//
//        Object createRow = sheet.createRow(rowNum).createCell(colNum);
//
//        return createRow;
//    }

//    public Object inputData(){
//        sheet.createRow(1).createCell(3).setCellType(CellType.STRING);
////        sheet.createRow(1).createCell(4).setCellType(CellType.NUMERIC);
////        sheet.createRow(1).createCell(5).setCellType(CellType.STRING);
//
//        sheet.getRow(1).getCell(3).setCellValue("PASS");
//
//
//        return 0;
//    }

////    public Object failedtoInput(){
//        sheet.createRow(1).createCell(3).setCellType(CellType.STRING);
//        sheet.getRow(1).getCell(3).setCellValue("Failed");
//
////        FileOutputStream outFile=new FileOutputStream();
////        workbook.write();
//        return 0;
//    }


//
//    public Object creatCell(int crow, int ccell){
//        sheet.getRow(crow).getCell(ccell);
//    }

