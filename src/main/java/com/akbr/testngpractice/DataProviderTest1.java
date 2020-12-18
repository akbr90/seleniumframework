package com.akbr.testngpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {

	@DataProvider (name = "data-provider")
	public String[][] dpMethod(){		//object may be any data type
		
		String mydata[][]= {{"First-Name","Akbar"}, {"Second-Name","Maham"}};
		return mydata;
	}

	@Test (dataProvider = "data-provider")
	public void myTest (String val1, String val2) {
		System.out.println("Passed Parameter Is : " + val1+" "+val2);
	}
}

