package com.akbr.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub.

		String path=System.getProperty("user.dir")+"/src/main/TestData/Maham.xlsx";

		FileInputStream is=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(is);
		XSSFSheet sheet=wb.getSheetAt(0);

		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();

		for(int r=0;r<=rows;r++) {

			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<cols;c++) {
				
				XSSFCell cell=row.getCell(c);
				
				switch(cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue()+"\t");
					break;
				case NUMERIC:
					System.out.print((int)cell.getNumericCellValue()+"\t");
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue()+"\t");
					break;
					
					default:
						System.out.print(cell.getDateCellValue()+"\t");
				
				}
				
				

			}
			System.out.println();
		}

		



	}

}