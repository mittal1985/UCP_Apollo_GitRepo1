package com.apollo.agentscripting.fa_inboundcall;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.apollo.ga_connection.Connect_GenesysAdmin;
import com.apollo.googlehangout.GoogleHangout_FF;

//4804944778
public class FAInbound_CallType {

	WebDriver driver = null;
	public String phoneNumber="4804944778";
	public GoogleHangout_FF googleHangout= null;
	
	
	public void ga_setUp() throws Exception{
		try{
			
			Connect_GenesysAdmin.createContact("DP_Finance","ucpeawe2");
			setUp();
		}catch(Exception exception){
			Assert.fail("exception in setUp");
		}
				
		}
	
	public void setUp() throws Exception{
		try{
			
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driver = new FirefoxDriver(customProfile);
		driver.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		
		driver.manage().window().maximize();
		clickUserName();
		}catch(Exception exception){
			Assert.fail("exception in setUp");
		}
				
		}
	
	
	public void clickUserName() throws Exception{
		try{
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
			
			webElement.sendKeys("ucpeawe2");
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", webElement);
		}else{
			System.out.println("element is null");
		}
		clickPassword();
		}catch(Exception exception){
			Assert.fail("exception in clickUserName");
		}
	}
	
	public void clickPassword() throws Exception{
		try{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(webElement!=null){
			
			webElement.sendKeys("ucpeawe2");
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", webElement);
		}else{
			
			System.out.println("element is null");
		}
		clickSubmit();
	}catch(Exception exception){
		Assert.fail("exception in clickPassword");
	}
	}
	
	
	public void clickSubmit() throws Exception{
		try{
		//Alert alert = new Alert();
		
		WebElement webElement = (new WebDriverWait(driver, 200)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
		if(webElement!=null){
			
			webElement.click();
		}else{
			
			System.out.println("element is null");
		}
		getAgentReady();
		
	}catch(Exception exception){
		Assert.fail("exception in clickSubmit");
	}
	}
	
	public void getAgentReady() throws Exception{
		try{
			
		int count = 0;
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("agent-desktop-container-title"))));
		while(webElement==null){
			System.out.println("in getagentReady , webelem is null");
			count = count++;
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
	
		
		/*drop down click working*/
		System.out.println("going to click dropdown");
		driver.findElement(By.id("wweAgentSwitchStateButton")).click();
		System.out.println("after click dropdown");
		WebElement webElement2=driver.findElement(By.xpath("//span[@class='presence-text']"));
		//click on Ready using xpath , at present xpath not there in my system
		//i think once clicked ready button its in Ready status for quite long
		
		if(webElement2!=null){
			webElement2.click();
			
			
		}else{
			
			System.out.println("Agent Ready Status dropdown is null");
		}
		
		getCall();
	
		}catch(Exception exception){
			Assert.fail("exception in getAgentReady");
		}
	}
		/*to disconnect the call*/
		//driver.findElement(By.id("wweVoice1HangupButton")).click();
		
	
	public void getCall() throws Exception{
		try{
			
			googleHangout= new GoogleHangout_FF();
			googleHangout.setUp(phoneNumber);
	
			clickCaseInfo();
		}catch(Exception exception){
			Assert.fail("exception in getCall");
		}
	}
	
	
	
	public void clickCaseInfo() throws Exception{
		try{
		
			System.out.println("in clickcaseinfo-----");
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(((By.xpath("//div[@class= 'wwe-data-text-value']"))));
			
			if(webElement!=null){
				System.out.println("not null");
			}
			
			WebElement webElement1 = driver.findElement(((By.xpath("//div[@class= 'wwe-data-text-value' and text()='Enrollment Inbound Direct']"))));
			
			if(webElement1!=null){
				System.out.println("not null");
			}
			
			System.out.println("verifying text s"+webElement1.getText());
		
			Assert.assertEquals(webElement1.getText(), "Enrollment Inbound Direct") ;
	
	//	webElement.click();
			checkContactTab();
		}catch(Exception exception){
			Assert.fail("exception in clickCaseInfo");
		}
	}
	
	
	
	public void checkContactTab() throws Exception{
	try{
		WebElement webElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable((By.id("CaseRightTabs1Item0"))));
		boolean bool = webElement.isDisplayed();
		System.out.println(""+bool);
		
		if(webElement.isDisplayed()){
			System.out.println("clicked on contact tab Header verified");
			//webElement.click();
		}else{
			System.out.println("contact tab not available");
			Assert.fail();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		checkContactInformation();
	}catch(Exception exception){
		Assert.fail("exception in checkContactTab");
	}
	}
	
	public void checkContactInformation() throws Exception{
	try{
		WebElement webElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable((By.className("no_contact_selected_information"))));
		boolean bool = webElement.isDisplayed();
		System.out.println(""+bool);
		
		if(webElement.isDisplayed()){
			System.out.println("clicked on contact tab Header verified"+webElement.getText());
			//webElement.click();
		}else{
			System.out.println("contact tab has no information");
			Assert.fail();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		clickEndCall();
	}catch(Exception exception){
		Assert.fail("exception in checkContactTab");
	}
	}
	
	public void clickEndCall() throws Exception{
	try{
		System.out.println("in clickEndCall");
		//WebElement webElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable((By.id("wweVoice1HangupButton"))));
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[starts-with(@class,'wwe-button-hangup')]"))));
		
		if(webElement!=null){
			webElement.click();
		}else{
			//WebElement webElement1 = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[starts-with(@class,'wwe-button-hangup')]"))));
			
			System.out.println("webelement is null");
		}
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		clickDoneButton();
	}catch(Exception exception){
		Assert.fail("exception in clickEndCall");
	}
	}
	

	public void clickDoneButton() throws Exception{
		try{
			System.out.println("in clickDoneButton");
				WebElement webElement = (new WebDriverWait(driver, 200)).until(ExpectedConditions.elementToBeClickable((By.id("wweBundle1CloseButton"))));
				if(webElement!=null){
					webElement.click();
				}else{
					System.out.println("webelement is null");
				}
				
				tearDown();
		
	}catch(Exception exception){
		Assert.fail("exception in clickDoneButton");
	}
	}
	
	
	
	public void tearDown() throws Exception{
		driver.close();
		googleHangout=new GoogleHangout_FF();
		googleHangout.tearDown();
	}
	
	
	
	
}
