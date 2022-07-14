package com.nextbase.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    // Decelare all variables private so that they are only accessible by the public methods below.
    private static XSSFSheet excelSheet;
    private static XSSFWorkbook excelWBook;
    private static XSSFCell cell;
    private static XSSFRow Row;

    //Method to open and set the excel file
    public static void setExcelFile(String path, String sheetName)  {
        try{
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook =  new XSSFWorkbook(excelFile);
            excelSheet = excelWBook.getSheet(sheetName);
        }catch(IOException e){
            System.out.println("Issue with the excel file set up and opening");
            e.printStackTrace();
        }

    }

    //Method to read elements from the excel file by row and cell

    public  static String getCellData(int rowNum, int colNum){
        try{
            cell = excelSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        }catch (Exception e){
            System.out.println("Issue with getting the cell value");
            e.printStackTrace();
            return"";
        }
    }

    public  static void setCellData(String valueToInput, int rowNum, int colNum, String filePath){

        try{
            Row = excelSheet.getRow(rowNum);
            cell = Row.getCell(colNum);
            if(cell==null){// If the cell is empty I create one and the inout value.
                cell= Row.createCell(colNum);
                cell.setCellValue(valueToInput);
            }else {cell.setCellValue(valueToInput);}
            //Then save it  and close file
            FileOutputStream output = new FileOutputStream(filePath);
            excelWBook.write(output);
            output.flush();
            output.close();

        }catch(Exception e){
            System.out.println("Issue with setting a cell value");
            e.printStackTrace();
        }

    }

    public static int getLastRow(){
        return excelSheet.getLastRowNum();
    }
}
