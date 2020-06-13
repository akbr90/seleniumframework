package com.akbr.testngpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProvider2 {
	@Test (dataProvider = "data-provider", dataProviderClass = DataProvider1.class)
	public void myTest (String val) {
		System.out.println("Current Status : " + val);
	}

	@Test (dataProvider = "data-provider", dataProviderClass = DProvider.class)
	public void myTest (int a, int b, int result,boolean flag) {
		int sum = a + b;
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		System.out.println("sum= "+sum);
		System.out.println("result= "+result);
		System.out.println("flag= "+flag);
		Assert.assertEquals(result, sum);
	}
}
