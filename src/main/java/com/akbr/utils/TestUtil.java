package com.akbr.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.akbr.base.BaseTest;

public class TestUtil extends BaseTest{

	public static long PAGE_LOAD_TIMEOUT=10;
	public static long IMPLICIT_WAIT=5;
	public static long WAIT_MILLI_SECONDS=5000;
	public static long WAIT_PADDED_SECONDS=3000;

	public void takeScreenShotAtEndOfTest() throws IOException {
		String curDir=System.getProperty("user.dir");
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(curDir+"\\screenshot\\"+System.currentTimeMillis()+".png"));


	}

	public int generateRandomNumber(int length) {

		Random ran=new Random();
		return ran.ints(lowerRange(length), upperRange(length)).findFirst().getAsInt();
	}

	public int generateRandomNumber(int lowerRange,int upperRange) {

		Random ran=new Random();
		return ran.ints(lowerRange(lowerRange), upperRange(upperRange)).findFirst().getAsInt();
	}
	
	
	public String generateRandomNumbers(int length) {

		Random ran=new Random();
		int intNum=ran.ints(lowerRange(length), upperRange(length)).findFirst().getAsInt();
		
		return String.valueOf(intNum).toString();
	}

	public String generateRandomNumbers(int lowerRange,int upperRange) {

		Random ran=new Random();
		int intNum=ran.ints(lowerRange(lowerRange), upperRange(upperRange)).findFirst().getAsInt();
		return String.valueOf(intNum).toString();
	}
	

	public int upperRange(int num) {

		int range=1;
		for(int i=0;i<num;i++) {
			range=range*10;
		}
		return (range-1);

	}

	public int lowerRange(int num) {

		int range=1;
		for(int i=1;i<num;i++) {
			range=range*10;
		}
		return range;

	}
	
	public String generateRandomStrings(int length) {

		String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		char text[]=new char[length];
		String strVal="";
		Random ran=new Random();

		for(int i=0;i<length;i++) {

			text[i]=characters.charAt(ran.nextInt(characters.length()));
		}

		for (int i=0;i<text.length;i++) {
			strVal=strVal+text[i];
		}

		return strVal;
	}
	
	public String generateAlphanumericStrings(int length) {

		String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		char text[]=new char[length];
		String strVal="";
		Random ran=new Random();

		for(int i=0;i<length;i++) {

			text[i]=characters.charAt(ran.nextInt(characters.length()));
		}

		for (int i=0;i<text.length;i++) {
			strVal=strVal+text[i];
		}

		return strVal;
	}



}

