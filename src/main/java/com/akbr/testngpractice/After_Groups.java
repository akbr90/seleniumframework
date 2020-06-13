package com.akbr.testngpractice;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

public class After_Groups {

	@AfterGroups("IT Department")
	public void after_it()  
	{  
		System.out.println("This method will be executed after the execution of IT Department group");  
	}  
	@Test  
	public void testcase1()  
	{  
		System.out.println("HR");  
	}  
	@Test(groups= {"IT Department"})  
	public void testcase2()  
	{  
		System.out.println("Software Developer");  
	}  
	@Test(groups= {"IT Department"})  
	public void testcase3()  
	{  
		System.out.println("QA Analyst");  
	}  
}  
