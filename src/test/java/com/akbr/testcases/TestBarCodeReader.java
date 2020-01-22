package com.akbr.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.akbr.base.BaseTest;

public class TestBarCodeReader extends BaseTest{

	//barcode generator : https://barcode.tec-it.com/en
	String url="http://testautomationpractice.blogspot.com/";
	//String url="https://en.wikipedia.org/wiki/Barcode";

	@BeforeTest
	public void setUp() {

		startBrowser();
		setCurrentURL(url);

	}

	@Test
	public void testBarCodeReader(){


		String result=testBarAndQRCodeReader(barcodeRedare);
		System.out.println(result); result=testBarAndQRCodeReader(qrCodeReader);
		System.out.println(result);
		url="https://barcode.tec-it.com/barcode.ashx?data=%24%23%40%23%40%24EFW%25%23%24%40%23QCS%5E%24%25%23%24WEQ&code=&multiplebarcodes=true&translate-esc=false&unit=Fit&dpi=96&imagetype=Gif&rotation=0&color=%23000000&bgcolor=%23ffffff&qunit=Mm&quiet=0";
		setCurrentURL(url);
		result=testBarAndQRCodeReader(wikiBarcode);
		System.out.println(result);
		setCurrentURL("https://web.whatsapp.com/");
		result=testBarAndQRCodeReader(whatsApp);
		System.out.println(result);
	}

	@AfterTest
	public void tearDown(){

		//closeBrowser();

	}



	private By barcodeRedare=By.xpath("//*[@id='HTML12']/div[1]/img[1]");
	private By qrCodeReader=By.xpath("//*[@id='HTML4']/div[1]/img");
	private By wikiBarcode=By.xpath("/html/body/img");
	private By whatsApp=By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div/div[2]/div/img");



}


