package com.akbr.base;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.akbr.utils.TestUtil;
import com.akbr.utils.WebEventListener;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BaseTest {

	public static WebDriver driver;
	public static WebElement web;
	static Properties prop;
	static Actions action;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener e_listener;


	public BaseTest(){

		try {
			prop= new Properties();
			FileInputStream is;

			is = new FileInputStream("C:\\MyEclipseWorkSpace\\SeleniumFrameWork\\Configuration\\config.properties");
			try {
				prop.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

	public static void startBrowser() {

		String browserName=prop.getProperty("browser");
		System.out.println(browserName+" browser opened :");
		String url=prop.getProperty("testUrl");
		

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("please check chromedrive path : ");
		}



		e_driver=new EventFiringWebDriver(driver);
		//Now create object of EventListenerHandler() to register it with EventFiringWebDriver
		e_listener=new WebEventListener();
		e_driver.register(e_listener);
		driver=e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);




	}

	public static String getCurrentURL() {

		String url=driver.getCurrentUrl();

		return url;
	}

	public static void setCurrentURL(String url) {

		driver.get(url);

	}
	
	public static String getBarCodeUrl(By loc) {
		
		WebElement locator=driver.findElement(loc);
		String barcodeUrl=locator.getAttribute("src");
		
		return barcodeUrl;
	}

	public static void WaitForElementToAppear() {
		try {
			Thread.sleep(TestUtil.WAIT_MILLI_SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void paddedWait() {
		try {
			Thread.sleep(TestUtil.WAIT_PADDED_SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollTillObjectIsVisible(By loc) {

		WebElement locator=driver.findElement(loc);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", locator);

	}

	public static void closeBrowser() {

		driver.quit();

	}

	public static void jsClick(By loc) {

		WebElement locator=driver.findElement(loc);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locator);

	}

	public static void inputValueAndSendKey(By loc,String sku) {

		WebElement locator=driver.findElement(loc);

		locator.clear();
		locator.sendKeys(Keys.ENTER);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+sku+"';", locator);
		paddedWait();
		locator.sendKeys(Keys.ENTER);

	}

	public static void clearAndSendKey(By loc,String StrArg) {

		WebElement locator=driver.findElement(loc);
		locator.clear();
		locator.sendKeys(StrArg);
		locator.sendKeys(Keys.TAB);

	}

	public static void hoverOver(By loc) {

		WebElement locator=driver.findElement(loc);
		paddedWait();
		action=new Actions(driver);
		if(locator.isDisplayed())
			action.moveToElement(locator).build().perform();
	}


	public static void clickIfExists(By loc) {

		WebElement locator=driver.findElement(loc);
		WaitForElementToAppear();
		if(locator.isDisplayed())
			locator.click();

	}

	public static String getCurrentEnv() {
		String url=driver.getCurrentUrl();
		String env = "";
		url = url.split("//")[1].split("\\.")[0];
		env = url.substring(3);
		if (env.equalsIgnoreCase(""))
			env = "PROD";
		return env;

	}

	public static void selectCheckboxByJS(By loc) 
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById(driver.findElement(locator)).checked=false;");
	}

	public static void verifyElementPresentOnPage(By loc)
	{
		WebElement locator=driver.findElement(loc);

		if(locator.isDisplayed())
		{
			System.out.println(locator.toString()+" is present on page");
		}
	}

	public static void verifyTextExistsOnElement(By loc, String text)
	{
		WebElement locator=driver.findElement(loc);

		if(locator.isDisplayed())
		{
			String actualText=locator.getText();
			if(actualText.contains(text)){
				System.out.println(actualText +" contains "+text);
			}
			else {
				System.out.println(actualText +" does not contains "+text);
			}
		}
	}

	public static void checkCheckBox(By loc)
	{
		WebElement locator=driver.findElement(loc);
		if(locator.isDisplayed())
			jsClick(loc);
	}

	public static void doubleClick(By loc)
	{
		WebElement locator=driver.findElement(loc);
		action=new Actions(driver);
		if(locator.isDisplayed()) {
			action.doubleClick(locator).build().perform();
		}
	}

	public static void click(By loc)
	{
		WebElement locator=driver.findElement(loc);
		locator.click();
		consoleLogger().info(locator.toString()+" is clicked");
	}

	public static void click(By loc,int index)
	{
		driver.findElements(loc).get(index).click();
	}

	public static boolean isPresentAndDisplayed(By loc) {

		List<WebElement> locator=driver.findElements(loc);
		boolean flag=false;
		if(locator.size()!=0) {
			flag=true;
		}
		else {
			System.out.println("Element not present on page");
		}
		return flag;

	}

	public static Logger consoleLogger() {

		Logger logger=Logger.getLogger("WWW");
		PropertyConfigurator.configure("log4j.properties");

		return logger;

	}

	public static List<String> getValuesInDropDown(By loc) {

		List<String> originalList=new ArrayList<String>();

		WebElement locator=driver.findElement(loc);		
		Select se=new Select(locator);

		List <WebElement> options=se.getOptions();
		for(WebElement e:options) {
			originalList.add(e.getText());
		}

		return originalList;
	}

	public static String selectOptionFromDropDownByValue(By loc, String value) {

		WebElement locator=driver.findElement(loc);
		Select se=new Select(locator);
		se.selectByValue(value);
		String selected=se.getFirstSelectedOption().getText();

		return selected;

	}

	public static String selectOptionsFromDropDownByText(By loc, String text) {

		WebElement locator=driver.findElement(loc);
		Select se=new Select(locator);
		se.selectByVisibleText(text);
		String selected=se.getFirstSelectedOption().getText();

		return selected;

	}

	public static String selectOptionsFromDropDown(By loc, int index) {

		WebElement locator=driver.findElement(loc);
		Select se=new Select(locator);
		se.selectByIndex(index);
		String text=se.getFirstSelectedOption().getText();

		return text;

	}


	public static void addCookie(String cookieName, String coockieValue) {

		Cookie cookieobj=new Cookie(cookieName,coockieValue);
		driver.manage().addCookie(cookieobj);


	}

	public static void deleteCookieNamed(String cookieName) {

		driver.manage().deleteCookieNamed(cookieName);


	}

	public static WebElement getDynamicObject(WebElement loc, String string) {
		String locator = loc.toString();
		System.out.println(locator);
		if(locator.contains("$Dynamic"))
		{
			locator = locator.replace("$Dynamic", string);
			if (locator.contains("By.xpath")) {
				locator = locator.replace("By.xpath: ", "");
				System.out.println(locator);
				loc = (WebElement) By.xpath(locator);
				System.out.println(loc);
			}
		}
		return loc;
	}

	public static void refreshBrowserByJS() {

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("history.go(0)");

	}
	
	public static void remoteFileUpload(String fileName, By loc) {
		
		WebElement locator=driver.findElement(loc);
		WaitForElementToAppear();
		System.out.println(System.getProperty("user.dir"));
		String filePath=System.getProperty("user.dir")+"/src/main/TestData/"+fileName;
		locator.sendKeys(filePath);
	}
	
	
	public static String testBarCodeReader(By loc) {
		
		By qrCodeReader=loc;
		WaitForElementToAppear();
		scrollTillObjectIsVisible(qrCodeReader);
		String barcodeUrl=getBarCodeUrl(qrCodeReader);
		System.out.println(barcodeUrl);
		
		URL url = null;
		try {
			url = new URL(barcodeUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LuminanceSource luminanceSrc=new BufferedImageLuminanceSource(bufferedImage);
		
		BinaryBitmap  binMap=new BinaryBitmap(new HybridBinarizer(luminanceSrc));
		
		Result result = null;
		try {
			result = new MultiFormatReader().decode(binMap);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}









}
