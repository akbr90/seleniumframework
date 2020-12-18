package com.akbr.testngpractice;

import org.testng.annotations.*;
public class Personal_loan  
{  
 @Test  
 public void personal_loan()  
 {  
     System.out.println("Personal Loan");  
 }  
 @BeforeSuite  
 public void before_suite()  
 {  
     System.out.println("First method");  
 }  
}  