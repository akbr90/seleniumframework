package com.akbr.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.akbr.base.BaseTest;

public class TestBarCodeReader extends BaseTest{
	
	//barcode generator : https://barcode.tec-it.com/en
	String url="http://testautomationpractice.blogspot.com/";
	
	@BeforeTest
	public void setUp() {
		
		startBrowser();
		setCurrentURL(url);
		
	}
	
	@Test
	public void testBarCodeReader(){
		
		String result=testBarCodeReader(barcodeRedare);
		System.out.println(result);
		result=testBarCodeReader(qrCodeReader);
		System.out.println(result);
	}
	
	
	
	private By barcodeRedare=By.xpath("//*[@id='HTML12']/div[1]/img[1]");
	private By qrCodeReader=By.xpath("//*[@id='HTML4']/div[1]/img");
	
	

}


