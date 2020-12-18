package com.akbr.testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wb=new XSSFWorkbook();
		
		XSSFSheet sheet=wb.createSheet("MyDetails");
		
		Object empData[][]= {{"EmpId","Name","Job"},
				{101,"Akbar","Teaching"},
				{102,"Maham","Playing"}};
		
		int rows=empData.length;
		int cols=empData[0].length;
		
		for(int r=0;r<rows;r++) {
			XSSFRow row=sheet.createRow(r);
			
			for(int c=0;c<cols;c++) {
				XSSFCell cell=row.createCell(c);
				Object value=empData[r][c];
				
				if(value instanceof String) {
					cell.setCellValue((String)value);
				}
				
				if(value instanceof Integer) {
					cell.setCellValue((Integer)value);
				}
				
				if(value instanceof Boolean) {
					cell.setCellValue((Boolean)value);
				}
			}
		}
		
		String path=System.getProperty("user.dir")+"/src/main/TestData/Maham.xlsx";
		FileOutputStream os=new FileOutputStream(path);
		wb.write(os);
		os.close();
		wb.close();
		
		
		System.out.println("Employee data written successfull to excel sheet");
		
		

	}

}
