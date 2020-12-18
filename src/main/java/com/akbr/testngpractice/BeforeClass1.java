package com.akbr.testngpractice;

import org.testng.annotations.*;


public class BeforeClass1 {


	@AfterClass  
	public void after_class()  
	{  
		System.out.println("This method is executed after Class1");  
	} 
	@BeforeClass  
	public void before_class()  
	{  
		System.out.println("This method is executed before Class1");  
	}  
	@Test  
	public void testcase2()  
	{  
		System.out.println("Test case2");  
	}  
	@Test  
	public void testcase1()  
	{  
		System.out.println("Test case1");  
	}  

}
