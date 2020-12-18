package com.akbr.json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.akbr.base.BaseTest;

/**
 * TODO Put here a description of what this class does.
 *
 * @author AKBAR.
 *         Created May 17, 2020.
 */
public class DataInputFromJson extends BaseTest {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 */
	
	@BeforeTest
	public void setUp() {

		startBrowser();
		
	}
	
	@Test(dataProvider="dp")
	public void verifyLogin(String data) {
		
		String userData[]=data.split(",");
		String user=userData[0];
		String pasw=userData[1];

		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.findElement(By.xpath("//input[@name='Email']")).isDisplayed();
		driver.findElement(By.xpath("//input[@name='Email']")).clear();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@name='Password']")).isDisplayed();
		driver.findElement(By.xpath("//input[@name='Password']")).clear();
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pasw);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		String actual=driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).getText();
		Assert.assertEquals("Log out",actual,"User logged out");
		System.out.println(actual);
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		
		
	}
	
	@AfterTest
	public void tearDown() {

		closeBrowser();
		
	}


	@SuppressWarnings("javadoc")
	@DataProvider(name="dp")
	public String[] readJson() throws IOException, ParseException {

		JSONParser jsonParser=new JSONParser();

		FileReader reader=new FileReader("C:\\Users\\AKBAR\\git\\seleniumframework\\jsonfiles\\userlogins.json");

		Object obj=jsonParser.parse(reader);

		JSONObject userslogin=(JSONObject) obj;
		JSONArray usersloginArray=(JSONArray) userslogin.get("userlogins");
		String arr_login[]=new String[usersloginArray.size()];

		for(int i=0;i<usersloginArray.size();i++)
		{

			JSONObject users=(JSONObject) usersloginArray.get(i);

			String user= users.get("user").toString();
			String pasw=  users.get("password").toString();
			
			arr_login[i]=user+","+pasw;
			
		}
		return arr_login;
	}
}
