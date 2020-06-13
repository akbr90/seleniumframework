package com.akbr.testngpractice;

import org.testng.annotations.Test;

public class PriorityTest {

	@Test(priority=15)  
	public void mango()  
	{  
		System.out.println("I am Mango");  
	}  
	@Test(priority=0)  
	public void apple()  
	{  
		System.out.println("I am Apple");  
	}  
	@Test(priority=-5000)  
	public void watermelon()  
	{  
		System.out.println("I am Watermelon");  
	}  
}
