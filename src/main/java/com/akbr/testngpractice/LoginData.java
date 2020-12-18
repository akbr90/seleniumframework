package com.akbr.testngpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginData {
	
	@Test(dataProvider = "logindata")
	public void getLoginData(String user, String pwd) {
		System.out.println("User "+user+"\n"+"Pass "+pwd);
	}
	
	@DataProvider(name="logindata")
	public String[][] loginData() {
		
		String data[][]= {{"Akbar", "akbr90"},{"Maham","maham19"}};
		return data;
	}

}
