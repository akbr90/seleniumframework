package com.akbr.testngpractice;

import org.testng.annotations.Test;  
public class Groups_in_Groups   
{  
	@Test(groups= {"Smoke"})  
	public void test1()  
	{  
		System.out.println("test1");  
	}  
	@Test(groups= {"Regression"})  
	public void test2()  
	{  
		System.out.println("test2");  
	}  
	@Test  
	public void test3()  
	{  
		System.out.println("test3");  
	}
} 
