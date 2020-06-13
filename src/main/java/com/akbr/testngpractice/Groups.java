package com.akbr.testngpractice;

import org.testng.annotations.Test;  
public class Groups {  
	@Test(groups= {"Group A"})  
	public void testcase1()   
	{  
		System.out.println("Test case belonging to Group A");  
	}  
	@Test(groups= {"Group A","Group B"})  
	public void testcase2()   
	{  
		System.out.println("Test case belonging to both Group A and Group B");  
	}  
	@Test(groups= {"Group B"})  
	public void testcase3()   
	{  
		System.out.println("Test case belonging to Group B");  
	}  
}  
