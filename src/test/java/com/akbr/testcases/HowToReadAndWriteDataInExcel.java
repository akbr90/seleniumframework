package com.akbr.testcases;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.akbr.base.BaseTest;
import com.akbr.utils.XLUtils;

/**
 * TODO Put here a description of what this class does.
 *
 * @author AKBAR.
 *         Created Jan 22, 2020.
 */
public class HowToReadAndWriteDataInExcel extends BaseTest{

	@BeforeTest
	public void setUp() {

		//startBrowser();
		//setCurrentURL(url);

	}

	@Test
	public void readAndWriteDataInExcel() throws IOException{

		String path=System.getProperty("user.dir")+"/src/main/TestData/sagarTestFile.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String logindata[][]=getDataFromExcel();
		int LoginID=0;
		int pass=1;
		int Age=2;

		for(int i=1;i<rownum;i++)
		{
			String name= logindata[i][LoginID];
			String password= logindata[i][pass];
			String age= logindata[i][Age];


			System.out.println("Name : "+name+", password : "+password+", Age : "+age);



		}
		writeDataToExcel(logindata);


	}

	@AfterTest
	public void tearDown(){

		//closeBrowser();

	}


	String [][] getDataFromExcel() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/TestData/sagarTestFile.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0

			}

		}
		return logindata;
	}


	void writeDataToExcel(String[][] logindata) throws IOException
	{
		String path=System.getProperty("user.dir")+"/test-output/MyExcel.xlsx";

		FileOutputStream fo;
		fo=new FileOutputStream(path);
		XSSFWorkbook wb;
		wb=new XSSFWorkbook();
		XSSFSheet ws;
		ws=wb.createSheet("MyData");
		XSSFRow row;



		int rownum=3;
		int colcount=3;

		for(int i=0;i<rownum;i++)
		{
			row=ws.createRow(i);
			for(int j=0;j<colcount;j++)
			{
				System.out.println(logindata[i][j]);
				//XLUtils.setCellData(path,"Sheet1",i,j,logindata[i][j]);
				row.createCell(j).setCellValue(logindata[i][j]);

			}

		}
		
		XLUtils.closeFile(path);
	}



}
