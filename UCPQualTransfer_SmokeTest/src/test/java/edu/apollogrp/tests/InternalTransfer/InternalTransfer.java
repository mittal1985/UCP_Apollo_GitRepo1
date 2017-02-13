package edu.apollogrp.tests.InternalTransfer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

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

import com.apollo.googlehangout.GoogleHangout_NoVoice;
import com.apollo.reportgeneration.Generic_Functions;
import com.apollo.reportgeneration.HtmlReport;

public class InternalTransfer {
//4807548519
	WebDriver driver = null;
	WebDriver driverFA = null;
	public static HtmlReport currentSuit = new HtmlReport();
	public String folder;
	public String screen_Header;
	public String app_Name_Final;
	public String proj_Name_Final;
	BufferedWriter bw = null;
	FileWriter fw = null;
	public String phoneNumber="4807548519";
	
	

	
	@Test(priority=0)
	public void setUp(){
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driver = new FirefoxDriver(customProfile);
		
		
	      
		//driver.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
		
		//driver.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driver.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void setUpER(){
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driverFA = new FirefoxDriver(customProfile);
		
		//driverFA.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
		
		//driverFA.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driverFA.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html ");
				
		driverFA.manage().window().maximize();
	}
	
	
	@Test(priority=2)
	public void clickUserNameER(){
		try{
		
		driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driverFA, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucpeawe2");
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER Username is loaded successfully", "ER Username should be loaded correctly", "ER Username is loaded correctly");
			
	
		}else{
			System.out.println("element is null");
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether ER Username is loaded successfully", "ER Username should be loaded correctly", "ER Username is not loaded correctly");
			
		}
		
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
	
	}
	@Test(priority=3)
	public void clickPasswordER(){
		try{
		driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driverFA, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucpeawe2");
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER Password is loaded successfully", "ER Password should be loaded correctly", "ER Password is loaded correctly");
			
	
		}else{
			System.out.println("element is null");
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether ER Password is loaded successfully", "ER Password should be loaded correctly", "ER Password is not loaded correctly");
			
		}
	}catch(Exception exception){
		exception.printStackTrace();
	}
	
	}
	
	
	@Test(priority=4)
	public void clickSubmitER(){
		try{
		//Alert alert = new Alert();
		
		WebElement webElement = (new WebDriverWait(driverFA, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
		
		if(webElement!=null){
			
			//webElement.sendKeys("ucp_acc1");
			
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER Submit button is loaded successfully", "ER Submit button should be loaded correctly", "ER Submit button is loaded correctly");
			
	
		}else{
			System.out.println("element is null");
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether ER Submit button is loaded successfully", "ER Submit button should be loaded correctly", "ER Submit button is not loaded correctly");
			
		}
		
		webElement.click();
		
		
		driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		
		/*drop down click working*/
		System.out.println("going to click dropdown for ER");
		driverFA.findElement(By.id("wweAgentSwitchStateButton")).click();
		driverFA.findElement(By.xpath("//span[@class='presence-text']")).click();
		System.out.println("ER should be now in ready status");
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
}
	
	
	
	@Test(priority=5)
	public void clickUserName(){
		try{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucp_acc_wwe2");
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ACC Username button is loaded successfully", "ACC Username button should be loaded correctly", "ACC Username button is loaded correctly");
			
	
		}else{
			System.out.println("element is null");
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether ACC Username button is loaded successfully", "ACC Username button should be loaded correctly", "ACC Username button is not loaded correctly");
			
		}
	}catch(Exception exception){
		exception.printStackTrace();
	}
		}
	
	@Test(priority=6)
	public void clickPassword(){
		try{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucp_acc_wwe2");
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ACC Password button is loaded successfully", "ACC Password button should be loaded correctly", "ACC Password button is loaded correctly");
			
	
		}else{
			System.out.println("element is null");
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether ACC Password button is loaded successfully", "ACC Password button should be loaded correctly", "ACC Password button is not loaded correctly");
			
		}
	}catch(Exception exception){
	exception.printStackTrace();
	}
	}
	
	
	@Test(priority=7)
	public void clickSubmit() {
		try {
			// Alert alert = new Alert();

			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
			if(webElement!=null){
				
				//webElement.sendKeys("ucp_acc1");
				
				Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ACC Submit button is loaded successfully", "ACC Submit button should be loaded correctly", "ACC Submit button is loaded correctly");
				
		
			}else{
				Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether ACC Submit button is loaded successfully", "ACC Submit button should be loaded correctly", "ACC Submit button is not loaded correctly");
				
			}
			webElement.click();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	@Test(priority=8)
	public void getCall(){
		try{
			
			GoogleHangout_NoVoice googleHangout= new GoogleHangout_NoVoice();
			googleHangout.setUp(phoneNumber);
		int count = 0;
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("agent-desktop-container-title"))));
		while(webElement==null){
			count = count++;
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
	
		
		/*drop down click working*/
		System.out.println("going to click dropdown");
		driver.findElement(By.id("wweAgentSwitchStateButton")).click();
		driver.findElement(By.xpath("//span[@class='presence-text']")).click();
		//click on Ready using xpath , at present xpath not there in my system
		//i think once clicked ready button its in Ready status for quite long
		
		
		
		
		//after receiving call
		if(driver.findElements(By.id("wweVoice1HangupButton")).size()!=0){
			System.out.println("done");
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Call is received successfully", "Call is received should be loaded correctly", "Call is received correctly");
			
		}else{
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether Call is received successfully", "Call is received should be loaded correctly", "Call is not received correctly");
			
		}
		
	
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		/*to disconnect the call*/
		//driver.findElement(By.id("wweVoice1HangupButton")).click();
		
		
	@Test(priority=9)
	public void clickCaseInfo(){
		try{
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweCaseData1Label"))));
		
		if(webElement!=null){
			
			//webElement.sendKeys("ucp_acc1");
			
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Case Info is displayed successfully", "Case Info should be  displayed correctly", "Case Info is displayed correctly");
			
	
		}else{
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether Case Info is displayed successfully", "Case Info should be  displayed correctly", "Case Info is not displayed correctly");
			
		}
		
		webElement.click();
		
		
		webElement.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		//System.out.println("going out of clickagentscripting");
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}
/*	@Test(priority=5)
	public void clickCallerType(){
		
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@class= 'wwe-data-text-value' and text()='Inbound Direct']"))));
		System.out.println("verifying text s"+webElement.getText());
		
		
		WebElement webElement1 = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.className("//div[@id= 'wweCaseData1callDescriptionValue'"))));
		
		System.out.println("verifying text 2"+webElement1.findElement(By.className("wwe-data-text-read-only-part")).findElement(By.className("wwe-data-text-value")).getText());
		
		
		Assert.assertEquals(webElement.getText(), "Inbound Direct") ;
		
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}*/
	
	
	@Test(priority=10)
		public void clickAgentScritping(){
		try{
			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("CaseRightTabs1ItemExtUCPAgentScripting0"))));
			
			
			if(webElement!=null){
				
				//webElement.sendKeys("ucp_acc1");
				
				Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether AgentScritping is displayed successfully", "AgentScritping should be  displayed correctly", "AgentScritping is displayed correctly");
				
		
			}else{
				Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether AgentScritping is displayed successfully", "AgentScritping should be  displayed correctly", "AgentScritping is displayed correctly");
				
			}
			
			
			webElement.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			System.out.println("going out of clickagentscripting");
			//webElement.click();
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		
		
		@Test(priority=11)
		public void clickNameSearch(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
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
						Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether AgentScritping Search is displayed successfully", "AgentScritping Search should be  displayed correctly", "AgentScritping Search is displayed correctly");
				
					}else{
						Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether AgentScritping Search is displayed successfully", "AgentScritping Search should be  displayed correctly", "AgentScritping Search is not displayed correctly");
						
					}
				
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
	
		
		@Test(priority=12)
		public void clickFirstRecord(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					
					Thread.sleep(4000);
					 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
					 Thread.sleep(4000);
					 WebElement webElement = driver .findElement(By.id("prospect0"));
					
						if(webElement!=null){
							//webElement.sendKeys("ucp_acc1");
							 (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable(webElement)).click();
							Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether FirstRecord is clicked successfully", "FirstRecord should be clicked correctly", "FirstRecord is displayed correctly");
					
						}else{
							Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether FirstRecord is clicked successfully", "FirstRecord should be clicked correctly", "FirstRecord is not  displayed correctly");
							
						}
					 Thread.sleep(4000);
					 ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
					 Thread.sleep(4000);
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		
		@Test(priority=13)
		public void clickQualify(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					
					WebElement webElement= driver.findElement((By.id("searchQualify")));
					
					
						if(webElement!=null){
							//webElement.sendKeys("ucp_acc1");
							 (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable(webElement)).click();
							Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Qualify is clicked successfully", "Qualify should be clicked correctly", "Qualify is clicked correctly");
					
						}else{
							Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether Qualify is clicked successfully", "Qualify should be clicked correctly", "Qualify is not  clicked correctly");
							
						}
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		@Test(priority=14)
		public void clickStartTransferButton(){
			try{
					driver.manage().timeouts().implicitlyWait(25000, TimeUnit.SECONDS);
					System.out.println("in clickStartTransferButton");
					
					WebElement webElement= (new WebDriverWait(driver, 35000)).until(ExpectedConditions.elementToBeClickable((By.id("startTransferButton"))));
					Thread.sleep(5000);
						if(webElement.isDisplayed()){
						System.out.println("webelement is displayed");
						Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Start Transfer is clicked successfully", "Start Transfer should be clicked correctly", "Start Transfer is clicked correctly");
						
						webElement.click();
					}else{
						driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
						//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Start Transfer is clicked successfully", "Start Transfer should be clicked correctly", "Start Transfer is clicked correctly");
						
						webElement.click();
					}
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		@Test(priority=15)
		public void clickTransferDropdown(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					System.out.println("in clickTransferDropdown");
					WebElement webelement = driver.findElement(By.id("transfervalue"));
					if(webelement!=null){
					Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether TransferDropdown is clicked successfully", "TransferDropdown should be clicked correctly", "TransferDropdown is clicked correctly");
					}else{
						Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether TransferDropdown is clicked successfully", "TransferDropdown should be clicked correctly", "TransferDropdown is not clicked correctly");
						
					}
					Select select = new Select(webelement);
					 select.selectByValue("Transfer");
					 
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		@Test(priority=16)
		public void clickConsultButton(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					System.out.println("in clickConsultButton");
					WebElement webelement = driver.findElement(By.id("wweBundle1ConsultButton"));
					if(webelement!=null){
						Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ConsultButton is clicked successfully", "ConsultButton should be clicked correctly", "ConsultButton is clicked correctly");
						}else{
							Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether ConsultButton is clicked successfully", "ConsultButton should be clicked correctly", "ConsultButton is not clicked correctly");
							
						}
					webelement.click();
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		@Test(priority=17)
		public void clickSearchMyFavButton(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickSearchMyFavButton");
					WebElement webelement = driver.findElement(By.id("wweTeamCommunicatorSearchFavoritesButton"));
					if(webelement!=null){
						Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether SearchMyFavButton is clicked successfully", "SearchMyFavButton should be clicked correctly", "SearchMyFavButton is clicked correctly");
						}else{
							Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether SearchMyFavButton is clicked successfully", "SearchMyFavButton should be clicked correctly", "SearchMyFavButton is not clicked correctly");
							
						}
					webelement.click();
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		@Test(priority=18)
		public void clickEnrollmentqualtransfer(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickEnrollmentqualtransfer");
					WebElement webelement = driver.findElement(By.id("wweTeamCommunicatorItem1DefaultActionButton"));
					if(webelement!=null){
						Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Enrollmentqualtransfer is clicked successfully", "Enrollmentqualtransfer should be clicked correctly", "Enrollmentqualtransfer is clicked correctly");
						}else{
							Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether Enrollmentqualtransfer is clicked successfully", "Enrollmentqualtransfer should be clicked correctly", "Enrollmentqualtransfer is not clicked correctly");
							
						}
					webelement.click();
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		
		
		
		@Test(priority=19)
		public void clickInstantCallTransfer(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickInstantCallTransfer");
					WebElement webelement = driver.findElement(By.id("wweVoice1CompleteConferenceButton"));
					if(webelement!=null){
						Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether InstantCallTransfer is clicked successfully", "InstantCallTransfer should be clicked correctly", "InstantCallTransfer is clicked correctly");
						}else{
							Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether InstantCallTransfer is clicked successfully", "InstantCallTransfer should be clicked correctly", "InstantCallTransfer is not clicked correctly");
							
						}
					webelement.click();
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		
		@Test(priority=20)
		public void clickInstantCallConference(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					//driver.switchTo().defaultContent();
					System.out.println("in clickInstantCallTransfer");
					WebElement webelement = driver.findElement(By.id("wweTeamCommunicatorActiveItem0DefaultActionButton"));
					if(webelement!=null){
						Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether InstantCallConference is clicked successfully", "InstantCallConference should be clicked correctly", "InstantCallConference is clicked correctly");
						}else{
							Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether InstantCallConference is clicked successfully", "InstantCallConference should be clicked correctly", "InstantCallConference is not clicked correctly");
							
						}
					webelement.click();
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		
		
		
		
		@Test(priority=21)
		public void endACCCall(){
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
		
		
		
	}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		
		@Test(priority=22)
		public void markACCCallDone(){
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
			}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		
		@Test(priority=23)
		public void endERCall(){
			System.out.println("going to click end button on ER side");
			int count =0;
			try{
				WebElement webElement = (new WebDriverWait(driverFA, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweVoice1HangupButton"))));
				while(webElement==null){
					count = count++;
					driverFA.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				}
			System.out.println("going to click end button on ER side");
			
			if(webElement!=null){
				//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
				webElement.click();
				}
			}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		
		
		@Test(priority=24)
		public void markERCallDone(){
			try{
			int count = 0;
			WebElement webElement = (new WebDriverWait(driverFA, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweBundle1CloseButton"))));
			while(webElement==null){
				count = count++;
				driverFA.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
		System.out.println("going to click done button on ER side");
		
		if(webElement!=null){
			//Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
			webElement.click();
			}
			}catch(Exception exception){
			exception.printStackTrace();
		}
	}	
		
		
		
public void tearDown(){
	driver.close();
	driverFA.close();
	GoogleHangout_NoVoice googleHangout_NoVoice = new GoogleHangout_NoVoice();
	googleHangout_NoVoice.tearDown();
}
		
}
