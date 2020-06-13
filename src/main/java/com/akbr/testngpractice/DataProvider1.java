package com.akbr.testngpractice;

import org.testng.annotations.DataProvider;

public class DataProvider1 {

	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"First-Value"}, {"Second-Value"}};
	}
}
