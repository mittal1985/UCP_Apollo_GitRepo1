package edu.apollogrp.tests.UCPSmokeTests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.apollo.googlehangout.GoogleHangout_FF;

public class QualTransfer_CallType {
//4807548519
	WebDriver driver = null;
	WebDriver driverER = null;
	//Cell cell = null;
	public String folder;
	public String screen_Header;
	public String app_Name_Final;
	public String proj_Name_Final;
	BufferedWriter bw = null;
	FileWriter fw = null;
	public String phoneNumber="4807548519";
	public static GoogleHangout_FF googleHangout_FF= null;
	
	
	public void setUp() throws Exception {
		try {
			FirefoxProfile customProfile = new FirefoxProfile();
			customProfile.setPreference("dom.disable_beforeunload", true);
			driver = new FirefoxDriver(customProfile);

			googleHangout_FF = new GoogleHangout_FF();

			// driver.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");

			// driver.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
			driver.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html");
			driver.manage().window().maximize();
			setUpER();
		} catch (Exception exception) {
			Assert.fail("exception in setUp");
		}
	}
	
	public void setUpER() throws Exception{
		try{
			
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driverER = new FirefoxDriver(customProfile);
		
		//driverER.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
		
		//driverER.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driverER.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html ");
				
		driverER.manage().window().maximize();
		clickUserNameER();
	}catch(Exception exception) {
		Assert.fail("exception in setUpER");
	}
	}
	
	
	public void clickUserNameER() throws Exception{
		
		try{
		
		driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driverER, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucpeawe2");
			
	
		}else{
			Assert.fail("exception in clickUserNameER");
			
		}
		
		clickPasswordER();
	}catch(Exception exception){
		exception.printStackTrace();
	}
	
	}
	public void clickPasswordER() throws Exception{
		try{
		driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driverER, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucpeawe2");
			
	
		}else{
			System.out.println("element is null");
			
		}clickSubmitER();
	}catch(Exception exception){
		Assert.fail("exception in clickPasswordER");
	}
	
	}
	
	
	public void clickSubmitER() throws Exception{
		try{
		//Alert alert = new Alert();
		
		WebElement webElement = (new WebDriverWait(driverER, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
		
		if(webElement!=null){
			
			//webElement.sendKeys("ucp_acc1");
			
			
	
		}else{
			System.out.println("element is null");
			
		}
		
		webElement.click();
		
		
		driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		
		/*drop down click working*/
		System.out.println("going to click dropdown for ER");
		driverER.findElement(By.id("wweAgentSwitchStateButton")).click();
		driverER.findElement(By.xpath("//span[@class='presence-text']")).click();
		System.out.println("ER should be now in ready status");
		clickUserName();
	}catch(Exception exception){
		Assert.fail("exception in clickSubmitER");
	}
}
	
	
	
	public void clickUserName() throws Exception{
		try{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucp_acc_wwe2");
			
	
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
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucp_acc_wwe2");
			
	
		}else{
			System.out.println("element is null");
			
		}
		clickSubmit();
	}catch(Exception exception){
		Assert.fail("exception in clickPassword");
	}
	}
	
	
	public void clickSubmit()  throws Exception{
		try {
			// Alert alert = new Alert();

			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
			if(webElement!=null){
				
				//webElement.sendKeys("ucp_acc1");
				
				
		
			}else{
				
			}
			webElement.click();
			getCall();
		} catch (Exception exception) {
			Assert.fail("exception in clickSubmit");
		}
	}
	
	public void getCall() throws Exception{
		try{
			
		googleHangout_FF.setUp(phoneNumber);
		int count = 0;
		
		System.out.println("after getCall googlehangout---->");
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("agent-desktop-container-title"))));
		while(webElement==null){
			count = count++;
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
	
		if(webElement!=null){
			System.out.println("webElement is now not null");
		}
		
		/*drop down click working*/
		System.out.println("going to click dropdown");
		driver.findElement(By.id("wweAgentSwitchStateButton")).click();
		driver.findElement(By.xpath("//span[@class='presence-text']")).click();
		//click on Ready using xpath , at present xpath not there in my system
		//i think once clicked ready button its in Ready status for quite long
		
		
		
		
		
		
		clickCaseInfo();
		}catch(Exception exception){
			Assert.fail("exception in getCall");
		}
	}
		/*to disconnect the call*/
		//driver.findElement(By.id("wweVoice1HangupButton")).click();
		
		
	public void clickCaseInfo() throws Exception{
		try{
		
			System.out.println("in clickcaseinfo-----");
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(((By.xpath("//div[@class= 'wwe-data-text-value']"))));
			
			if(webElement!=null){
				System.out.println("not null");
			}
			
			WebElement webElement1 = driver.findElement(((By.xpath("//div[@class= 'wwe-data-text-value' and text()='Inbound Callback']"))));
			
			if(webElement1!=null){
				System.out.println("not null");
			}
			
			System.out.println("verifying text s"+webElement1.getText());
		
			Assert.assertEquals(webElement1.getText(), "Inbound Callback") ;
	
	//	webElement.click();
			clickAgentScritping();
		}catch(Exception exception){
		Assert.fail("exception in clickCaseInfo");
	}
	}
	public void clickAgentScritping() throws Exception{
		try{
			WebElement webElement = (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable((By.id("CaseRightTabs1ItemExtUCPAgentScripting0"))));
			
			
			
			
			webElement.click();
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			System.out.println("going out of clickagentscripting");
			//webElement.click();
			clickNameSearch();
		}catch(Exception exception){
			Assert.fail("exception in clickAgentScritping");
		}
	}
		
		
		public void clickNameSearch() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
					/*switch to iframe of IRN */
					driver.switchTo().frame(driver.findElement(By.className("wwe-web-extension-iframe")));
					
					WebElement firstNameElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("firstnamesearch"))));
					firstNameElement.sendKeys("uop");
					
					WebElement lastNameElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("lastnamesearch"))));
					lastNameElement.sendKeys("phoenix.11");
			
	
					Thread.sleep(4000);
					 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
					 Thread.sleep(4000);
					System.out.println("going to click after wait");
					
					WebDriverWait wait = new WebDriverWait(driver, 500);
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.id("inboudnSearch")))));
					WebElement webElement = driver.findElement((By.id("inboudnSearch")));
					if(webElement!=null){
						//webElement.sendKeys("ucp_acc1");
						webElement.click();
				
					}
					clickFirstRecord();
			}catch(Exception exception){
				Assert.fail("exception in clickNameSearch");
			}
			
		
		}
	
		
		public void clickFirstRecord() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					
					Thread.sleep(4000);
					 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
					 Thread.sleep(4000);
					 WebElement webElement = driver .findElement(By.id("prospect0"));
					
						if(webElement!=null){
							//webElement.sendKeys("ucp_acc1");
							 (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable(webElement)).click();
					
						
						}
					 Thread.sleep(4000);
					 ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
					 Thread.sleep(4000);
					 clickQualify();
			}catch(Exception exception){
				Assert.fail("exception in clickFirstRecord");
			}
			
		
		}
		
		
		public void clickQualify() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					
					WebElement webElement= driver.findElement((By.id("searchQualify")));
					
					
						if(webElement!=null){
							//webElement.sendKeys("ucp_acc1");
							 (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable(webElement)).click();
					
						}
						clickStartTransferButton();
			}catch(Exception exception){
				Assert.fail("exception in clickQualify");
			}
			
		
		}
		
		public void clickStartTransferButton() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(25000, TimeUnit.SECONDS);
					System.out.println("in clickStartTransferButton");
					
					WebElement webElement= (new WebDriverWait(driver, 35000)).until(ExpectedConditions.elementToBeClickable((By.id("startTransferButton"))));
					Thread.sleep(5000);
						if(webElement.isDisplayed()){
						System.out.println("webelement is displayed");
						
						webElement.click();
					}else{
						driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
						//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Start Transfer is clicked successfully", "Start Transfer should be clicked correctly", "Start Transfer is clicked correctly");
						
						webElement.click();
					}
						clickTransferDropdown();
			}catch(Exception exception){
				Assert.fail("exception in clickStartTransferButton");
			}
			
		
		}
		
		public void clickTransferDropdown() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					System.out.println("in clickTransferDropdown");
					WebElement webelement = driver.findElement(By.id("transfervalue"));
					
					Select select = new Select(webelement);
					 select.selectByValue("Transfer");
					 
					 clickConsultButton();
			}catch(Exception exception){
				Assert.fail("exception in clickTransferDropdown");
			}
			
		
		}
		
		public void clickConsultButton() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					System.out.println("in clickConsultButton");
					WebElement webelement = driver.findElement(By.id("wweBundle1ConsultButton"));
					
					webelement.click();
					clickSearchMyFavButton();
			}catch(Exception exception){
				Assert.fail("exception in clickConsultButton");
			}
			
		
		}
		
		public void clickSearchMyFavButton() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickSearchMyFavButton");
					WebElement webelement = driver.findElement(By.id("wweTeamCommunicatorSearchFavoritesButton"));
					
					webelement.click();
					clickEnrollmentqualtransfer();
			}catch(Exception exception){
				Assert.fail("exception in clickSearchMyFavButton");
			}
			
		
		}
		
		public void clickEnrollmentqualtransfer() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickEnrollmentqualtransfer");
					WebElement webelement = driver.findElement(By.id("wweTeamCommunicatorItem1DefaultActionButton"));
					
					webelement.click();
					clickInstantCallTransfer();
			}catch(Exception exception){
				Assert.fail("exception in clickEnrollmentqualtransfer");
			}
			
		
		}
		
		
		
		
		public void clickInstantCallTransfer() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickInstantCallTransfer");
					WebElement webelement = driver.findElement(By.id("wweVoice1CompleteConferenceButton"));
				
					webelement.click();
					clickInstantCallConference();
			}catch(Exception exception){
				Assert.fail("exception in clickInstantCallTransfer");
			}
			
		
		}
		
		
		public void clickInstantCallConference() throws Exception{
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickInstantCallTransfer");
					WebElement webelement = driver.findElement(By.id("wweTeamCommunicatorActiveItem0DefaultActionButton"));
					
					webelement.click();
					endACCCall();
			}catch(Exception exception){
				Assert.fail("exception in clickInstantCallConference");
			}
			
		
		}
		
		
		public void endACCCall() throws Exception{
			try{
			int count = 0;
			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.className("wwe-sprite-end-call"))));
			while(webElement==null){
				count = count++;
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
		System.out.println("going to click end button on ACC side");
		
		if(webElement!=null){
			//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
			webElement.click();
			}
		
		markACCCallDone();
		
	}catch(Exception exception){
		Assert.fail("exception in endACCCall");
		}
	}
		
		public void markACCCallDone() throws Exception{
			try{
			int count = 0;
			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.className("wwe-sprite-mark-done"))));
			while(webElement==null){
				count = count++;
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
		System.out.println("going to click done button on ACC side");
		
		if(webElement!=null){
			//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
			webElement.click();
			}
		endERCall();
			}catch(Exception exception){
				Assert.fail("exception in markACCCallDone");
		}
	}
		
		public void endERCall() throws Exception{
			System.out.println("going to click end button on ER side");
			int count =0;
			try{
				WebElement webElement = (new WebDriverWait(driverER, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweVoice1HangupButton"))));
				/*while(webElement==null){
					count = count++;
					driverER.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				}
			System.out.println("going to click end button on ER side after wait");*/
			
			if(webElement!=null){
				System.out.println("in if block endERCall");
				//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
				webElement.click();
				}
			System.out.println("going to call markERCallDone");
			markERCallDone();
			}catch(Exception exception){
				Assert.fail("exception in endERCall");
		}
	}
		
		
		public void markERCallDone() throws Exception{
			try{
			int count = 0;
			WebElement webElement = (new WebDriverWait(driverER, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweBundle1CloseButton"))));
			/*while(webElement==null){
				count = count++;
				driverER.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
		System.out.println("going to click done button on ER side");*/
		
		if(webElement!=null){
			//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
			webElement.click();
			}
		tearDown();
			}catch(Exception exception){
				Assert.fail("exception in markERCallDone");
		}
	}		
		
public void tearDown() throws Exception{
	try{
	driver.close();
	driverER.close();
	googleHangout_FF.tearDown();
}catch(Exception exception){
	Assert.fail("exception in tearDown");
}
		
}
}