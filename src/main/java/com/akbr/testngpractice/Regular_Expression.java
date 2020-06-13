package com.akbr.testngpractice;

import org.testng.annotations.Test;  
public class Regular_Expression {  
	@Test(groups= {"Include test case1"})  
	public void test_case1()   
	{  
		System.out.println("This is test case 1");  
	}  
	@Test(groups= {"Include test case2"})  
	public void test_case2()   
	{  
		System.out.println("This is test case 2");  
	}  
	@Test(groups= {"Exclude test case3"})  
	public void test_case3()   
	{  
		System.out.println("This is test case 3");  
	}  
}  
