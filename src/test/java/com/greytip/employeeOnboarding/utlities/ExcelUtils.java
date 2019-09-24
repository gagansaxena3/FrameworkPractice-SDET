package com.greytip.employeeOnboarding.utlities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;



public class ExcelUtils {
		
		public static int getRowCount(String excelPath, String SheetName ) throws IOException {
	
		FileInputStream fis = new FileInputStream(excelPath);
		HSSFWorkbook	wb=new HSSFWorkbook(fis);
		HSSFSheet sheet= wb.getSheet(SheetName);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	
	}
	
		
		public static int getCellCount(String excelPath, String SheetName, int rowNumber ) throws IOException {
			FileInputStream fis = new FileInputStream(excelPath);
			HSSFWorkbook	wb=new HSSFWorkbook(fis);
			HSSFSheet sheet= wb.getSheet(SheetName);
			HSSFRow row = sheet.getRow(rowNumber);
			int cellCount = row.getLastCellNum();
			wb.close();
			fis.close();
			return cellCount;
			
		}
	
		public static String getCellData(String excelPath, String SheetName, int rowNumber, int cellNumber) throws IOException {
			FileInputStream fis = new FileInputStream(excelPath);
			HSSFWorkbook	wb=new HSSFWorkbook(fis);
			HSSFSheet sheet= (HSSFSheet) wb.getSheet(SheetName);
			HSSFRow row = sheet.getRow(rowNumber);
			HSSFCell cell = row.getCell(cellNumber);
			String data;
			
			try {
				 DataFormatter formatter = new DataFormatter();
				String cellData= formatter.formatCellValue(cell);
				return cellData; 
			}
			
			catch ( Exception e)  {
				data ="";	
			}
			
			wb.close();
			fis.close();
			
			return data;
			
		}
			
			public static void setCellData(String excelPath,String SheetName,int rowNumber,int colNumber,String data) throws IOException {
				FileInputStream fis = new FileInputStream(excelPath);
				HSSFWorkbook	wb=new HSSFWorkbook(fis);
				HSSFSheet sheet= wb.getSheet(SheetName);
				HSSFRow row = sheet.getRow(rowNumber);
				HSSFCell cell = row.createCell(colNumber);
				cell.setCellValue(data);
				FileOutputStream fos = new FileOutputStream(excelPath);
				wb.write(fos);
				wb.close();
				fis.close();
				fos.close();
				
		}
	
}
