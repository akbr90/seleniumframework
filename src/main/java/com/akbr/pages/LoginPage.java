package com.akbr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.akbr.base.BaseTest;


public class LoginPage extends BaseTest{

	
	public By loginLink=By.xpath("//button[contains(@data-auid,'Header_OdButton_LogIn')]");
	public By emailTextBox=By.xpath("//input[@data-auid='loginDialog_field_loginID']");
	public By passwordTextBox=By.xpath("//input[@data-auid='loginDialog_field_password']");
	public By LoginButton=By.xpath("//input[@data-auid='loginDialog_button_login']");
	public By home_myAccount_header=By.xpath("//a[contains(@data-auid,'SubNavAccount')]");
	public By checkBox_autoLogin=By.xpath("//input[@name='autoLogin']");
	public By homeLogOut=By.xpath("//a[@data-auid='Header_OdMenuLink_Signout']");
	public By logInErrorModal=By.xpath("//h3[@class='errorHeader']");


	
	public HomePage LoginHomePage(String userName, String Password) {

		hoverOver(home_myAccount_header);
		paddedWait();
		click(loginLink);
		WaitForElementToAppear();
		clearAndSendKey(emailTextBox, userName);
		consoleLogger().info("entered userName : "+ userName);
		clearAndSendKey(passwordTextBox, Password);
		consoleLogger().info("Entered Password : "+Password);
		checkCheckBox(checkBox_autoLogin);
		click(LoginButton);

		return new HomePage();

	}
	
	public HomePage logOut() {
		
		hoverOver(home_myAccount_header);
		WaitForElementToAppear();
		jsClick(homeLogOut);
		
		return new HomePage();
		
	}
	
	public Boolean loginErrorModalDisplayed() {
		
		Boolean flag=true;
		if(isPresentAndDisplayed(logInErrorModal)) {
			flag =true;
		}
		else
		{
			flag=false;
		}
		
		return flag;
		
	}


}

