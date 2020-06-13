package com.akbr.testngpractice;

import org.testng.annotations.Test;

public class TestNGAnnotationTest1 {

	@Test
	public void firstAnnotationTest() {		// First test case. 
		System.out.println("Welcome to TestNG annotaion Test");
	}

	@Test(enabled=false)  
	public void test1()                      // Second test case.  
	{  
		System.out.println("test1");   
	}   
	@Test  
	public  void test2()                     // Third test case.  
	{  
		System.out.println("test2");  
	}
	
	 @Test  
	  public void WebLoginCarLoan()  
	  {  
	      System.out.println("WebLoginCarLoan");  
	  }  
	  @Test  
	  public void MobileLoginCarLoan()  
	  {  
	      System.out.println("MobileLoginCarLoan");  
	  }  
	  @Test  
	  public void MobileLoginPersonalLoan()  
	  {  
	      System.out.println("MobileLoginPersonalLoan");  
	  }  
	  @Test  
	  public void MobileLoginHomeLoan()  
	  {  
	      System.out.println("MobileLoginHomeLoan");  
	  }  
	  @Test  
	  public void LoginAPICarLoan()  
	  {  
	      System.out.println("LoginAPICarLoan");  
	  }  

}
