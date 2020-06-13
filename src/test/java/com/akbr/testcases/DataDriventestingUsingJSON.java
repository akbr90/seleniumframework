package com.akbr.testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.akbr.base.BaseTest;

/**
 * TODO Put here a description of what this class does.
 *
 * @author AKBAR.
 *         Created May 17, 2020.
 */
public class DataDriventestingUsingJSON extends BaseTest{
	
	
	

		@BeforeTest
		public void setUp() {

			startBrowser();
			
		}
		
		@SuppressWarnings("javadoc")
		@Test
		public void DataDrivenTestingUsingJSON() throws IOException, ParseException{
			
			
			JSONParser jsonParser=new JSONParser();
			
			FileReader reader=new FileReader("C:\\Users\\AKBAR\\git\\seleniumframework\\jsonfiles\\userlogins.json");
			
			Object obj=jsonParser.parse(reader);
			
			JSONObject users=(JSONObject) obj;
			
			String user= users.get("user").toString();
			String pasw=  users.get("password").toString();
			
			System.out.println(user);
			System.out.println(pasw);
			
			driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click();
			driver.findElement(By.xpath("//*[@id='ap_email']")).isDisplayed();
			driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(user);
			driver.findElement(By.xpath("//*[@id='continue']")).click();
			driver.findElement(By.xpath("//*[@id='ap_password']")).isDisplayed();
			driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(pasw);
			driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
			//String userNmae=driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).getText();
			//System.out.println(userNmae);
			String pageTitle=driver.getTitle();
			System.out.println(pageTitle);
		}

}
