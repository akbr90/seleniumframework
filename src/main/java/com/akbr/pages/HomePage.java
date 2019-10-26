package com.akbr.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.akbr.base.BaseTest;
import com.akbr.utils.TestUtil;

public class HomePage extends BaseTest{


	private By clickAccessButton;
	private By homeHeaderIcon_Link_Account=By.xpath("//a[contains(@data-auid,'Header_OdHeaderNavigationLink_SubNavAccount')]");
	private By GlobalSerachTextBox=By.xpath("//input[@class='od-header-search-input']|//input[@data-auid='homepage_field_mainSearchField']");
	private By globalSerachLenseIcon=By.xpath("//button[@data-auid='Header_OdHeaderSearchIcon_SearchIconMagnifyGlass']/span|//input[@data-auid='homepage_submit_search']");
	private By globalSerachLenseIcon1=By.cssSelector(".od-header-search-icon-magnifyGlass");
	private By global_link_ODlogo=By.xpath("//img[contains(@src,'od-omax-logo')]|//span[@class='od-header-logo-wrapper']");
	private By global_link_SBlogo=By.xpath("//div[@id='smb_logo']//img[@data-auid='head_image_brandLogo']");
	private By cart_link_continueShopping=By.xpath("//a[@data-auid='cartHeader_button_ContinueShopping']");
	private By home_CreateAccount_FlyOutLink=By.xpath("//a[contains(@data-auid,'CreateAccountLink') and text()='Create an Account']");
	private By getStarted_textBox_phone=By.xpath("//input[@data-auid='enrollmentFlow_field_phoneLookup']");
	private By getStarted_Button_Next=By.xpath("(//button[@data-auid='enrollmentFlow_button_continue'])[2]");
	private By getStarted_radio_Personal=By.xpath("//*[@id=\"lookupConfirmation\"]/div/div[2]/label[1]");
	private By SelectMemberType_Button_Next=By.xpath("//button[@data-auid='enrollmentFlow_button_next']");
	private By createAccount_textBox_email=By.xpath("//input[@id='regStep1Email']");
	private By createAccount_textBox_password=By.xpath("//input[@id='regStep1Password']");
	private By createAccount_textBox_confirmPassword=By.xpath("//input[@id='regStep2PasswordConfirm']");
	private By createAccount_Button_Next=By.xpath("(//button[@class='gw3 btn primary next allowMultipleClick'])");
	private By almostDone_textBox_FirstName=By.xpath("//input[@data-auid='loyaltyEnroll_text_firstName']");
	private By almostDone_textBox_LastName=By.xpath("//input[@data-auid='loyaltyEnroll_field_lastName']");
	private By almostDone_textBox_address=By.xpath("//input[@data-auid='loyaltyEnroll_text_address1']");
	private By almostDone_textBox_zipCode=By.xpath("//input[@id='postalCode']");
	private By almostDone_textBox_city=By.xpath("//input[@id='city']");
	private By almostDone_dropDown_selectState=By.xpath("//select[@id='bizState']");
	private By almostDone_dropDown_MonthDOB=By.xpath("//select[@id='bday_month']");
	private By almostDone_dropDown_DayDOB=By.xpath("//select[@id='bday_day']");
	private By almostDone_checkbox_TermAndCondition=By.xpath("//input[@id='acceptEnrollmentTC']//parent::label//span[@class='styled_checkbox_label med']");
	private By almostDone_Button_Next=By.xpath("(//button[@class='gw3 btn primary next allowMultipleClick'])[2]");
	private By regSuccess_link_MyAccount=By.xpath("//a[@data-auid='enrollmentflow_link_accountSummary']");






	public HomePage searchItem(String sku) {
		WaitForElementToAppear();
		clearAndSendKey(GlobalSerachTextBox, sku);
		paddedWait();
		doubleClick(globalSerachLenseIcon);

		return new HomePage();

	}

	public HomePage clickAccessAuthorization() {

		//addCookie("betaAccessCookie","false");
		String env=getCurrentEnv().toUpperCase();
		String clickAccess="WWW"+env;
		if(clickAccess.contains("SQ")||clickAccess.contains("SLN")) {
			clickAccessButton=(By.xpath("//a[contains(text(),'"+clickAccess+"')]"));
			click(clickAccessButton);
		}
		if(env.contains("SQ")||env.contains("SLN")) {

			consoleLogger().info("Test running on "+env+" environment");
			setCurrentURL("https://www"+env+".officedepot.com/?isHeaderResponsive=true");
			setCurrentURL("https://www"+env+".officedepot.com/cart/switchCart.do");

		}
		else
		{
			setCurrentURL("https://www.officedepot.com/?isHeaderResponsive=true");
		}
		getHomePage();
		return new HomePage();
	}

	public HomePage getHomePage(){
		WaitForElementToAppear();
		if(isPresentAndDisplayed(cart_link_continueShopping))
		{
			click(cart_link_continueShopping);
		}		

		return new HomePage();
	}

	public HomePage hoverMyAccountIcon() {

		hoverOver(homeHeaderIcon_Link_Account);
		return new HomePage();

	}
	
	public  By sendSelectStateLocator() {
		
		return almostDone_dropDown_selectState;
		
	}
	
	public void createNewAccount() {
		
		TestUtil utils=new TestUtil();
		hoverMyAccountIcon();
		click(home_CreateAccount_FlyOutLink);
		WaitForElementToAppear();
		clearAndSendKey(getStarted_textBox_phone,"5997"+utils.generateRandomNumbers(6));
		click(getStarted_Button_Next);
		WaitForElementToAppear();
		click(getStarted_radio_Personal);
		click(SelectMemberType_Button_Next);
		WaitForElementToAppear();
		clearAndSendKey(createAccount_textBox_email, "ECAUTO"+utils.generateRandomStrings(6)+"@yopmail.com");
		clearAndSendKey(createAccount_textBox_password, "Tester#123");
		clearAndSendKey(createAccount_textBox_confirmPassword, "Tester#123");
		click(createAccount_Button_Next);
		WaitForElementToAppear();
		clearAndSendKey(almostDone_textBox_FirstName, utils.generateRandomStrings(6));
		clearAndSendKey(almostDone_textBox_LastName, utils.generateRandomStrings(6));
		clearAndSendKey(almostDone_textBox_address, "6600 N MILITRY TRL");
		clearAndSendKey(almostDone_textBox_zipCode, "33496");
		clearAndSendKey(almostDone_textBox_city, "BOCA RATON");
		selectOptionFromDropDownByValue(almostDone_dropDown_selectState,"FL");
		selectOptionsFromDropDownByText(almostDone_dropDown_MonthDOB, "January");
		selectOptionsFromDropDown(almostDone_dropDown_DayDOB, 2);
		checkCheckBox(almostDone_checkbox_TermAndCondition);
		WaitForElementToAppear();
		click(almostDone_Button_Next);
		//WaitForElementToAppear();
		//click(regSuccess_link_MyAccount);
		
		
		
		
	}


}