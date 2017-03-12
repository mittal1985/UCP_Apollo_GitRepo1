package edu.apollogrp.tests.InternalTransfer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apollo.googlehangout.GoogleHangout_Chrome;
import com.apollo.googlehangout.GoogleHangout_FF;


public class InternalTransfer_ER_FA_TestNG {
	//4807548519
		WebDriver driverFA = null;
		WebDriver driverER = null;
		public String folder;
		public String screen_Header;
		public String app_Name_Final;
		public String proj_Name_Final;
		BufferedWriter bw = null;
		FileWriter fw = null;
		public String phoneNumber="4804944778";
		
		

		
		@Test(priority=0)
		public void setUp(){
			FirefoxProfile customProfile = new FirefoxProfile();
			customProfile.setPreference("dom.disable_beforeunload", true);
			driverFA = new FirefoxDriver(customProfile);
			
			
		      
			//driverFA.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
			
			//driverFA.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
			driverFA.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html");
			driverFA.manage().window().maximize();
		}
		
		@Test(priority=1)
		public void setUpER(){
			FirefoxProfile customProfile = new FirefoxProfile();
			customProfile.setPreference("dom.disable_beforeunload", true);
			driverER = new FirefoxDriver(customProfile);
			
			//driverER.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
			
			//driverER.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
			driverER.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html ");
					
			driverER.manage().window().maximize();
		}
		
		
		@Test(priority=2)
		public void clickUserNameER(){
			try{
			
			driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
			WebElement webElement = (new WebDriverWait(driverER, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
			
			
			if(webElement!=null){
			
				//webElement.sendKeys("ucp_acc1");
				
				webElement.sendKeys("ucpeawe2");
				
		
			}else{
				System.out.println("element is null");
				
			}
			
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
		}
		@Test(priority=3)
		public void clickPasswordER(){
			try{
			driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
			WebElement webElement = (new WebDriverWait(driverER, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
			
			//driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			if(webElement!=null){
			
				//webElement.sendKeys("ucp_acc1");
				
				webElement.sendKeys("ucpeawe2");
				
		
			}else{
				System.out.println("element is null");
				
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
		}
		
		
		@Test(priority=4)
		public void clickSubmitER(){
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
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		
		
		
		@Test(priority=5)
		public void clickUserName(){
			try{
			driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
			WebElement webElement = (new WebDriverWait(driverFA, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
			
			
			if(webElement!=null){
			
				//webElement.sendKeys("ucp_acc1");
				
				webElement.sendKeys("ucp_acc_wwe2");
				
		
			}else{
				System.out.println("element is null");
				
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
			}
		
		@Test(priority=6)
		public void clickPassword(){
			try{
			driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
			WebElement webElement = (new WebDriverWait(driverFA, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
			
			//driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			if(webElement!=null){
			
				//webElement.sendKeys("ucp_acc1");
				
				webElement.sendKeys("ucp_acc_wwe2");
				
		
			}else{
				System.out.println("element is null");
				
			}
		}catch(Exception exception){
		exception.printStackTrace();
		}
		}
		
		
		@Test(priority=7)
		public void clickSubmit() {
			try {
				// Alert alert = new Alert();

				WebElement webElement = (new WebDriverWait(driverFA, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
				
				webElement.click();
				
				/*drop down click working*/
				driverFA.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				System.out.println("going to click dropdown for FA");
				driverFA.findElement(By.id("wweAgentSwitchStateButton")).click();
				driverFA.findElement(By.xpath("//span[@class='presence-text']")).click();
				System.out.println("FA should be now in ready status");

			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		@Test(priority=8)
		public void getCall(){
			try{
				
				GoogleHangout_FF googleHangout= new GoogleHangout_FF();
				googleHangout.setUp(phoneNumber);
			int count = 0;
			WebElement webElement = (new WebDriverWait(driverER, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("agent-desktop-container-title"))));
			while(webElement==null){
				count = count++;
				driverER.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
		
			
			/*drop down click working*/
			System.out.println("going to click dropdown");
			driverER.findElement(By.id("wweAgentSwitchStateButton")).click();
			driverER.findElement(By.xpath("//span[@class='presence-text']")).click();
			//click on Ready using xpath , at present xpath not there in my system
			//i think once clicked ready button its in Ready status for quite long
			
			
			
			
			//after receiving call
			if(driverER.findElements(By.id("wweVoice1HangupButton")).size()!=0){
				System.out.println("done");
				
			}else{
				
			}
			
		
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
			/*to disconnect the call*/
			//driverFA.findElement(By.id("wweVoice1HangupButton")).click();
			
			
		@Test(priority=9)
		public void clickCaseInfo(){
			try{
			WebElement webElement = (new WebDriverWait(driverER, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweCaseData1Label"))));
			
			
			
			webElement.click();
			
			
			webElement.click();
			driverFA.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			//System.out.println("going out of clickagentscripting");
		}catch(Exception exception){
			exception.printStackTrace();
		}
		}

		
		
		@Test(priority=10)
			public void clickConsultButton(){
				try{
					driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					driverER.switchTo().defaultContent();
						System.out.println("in clickConsultButton");
						WebElement webelement = driverER.findElement(By.id("wweBundle1ConsultButton"));
						if(webelement!=null){
							}else{
								
							}
						webelement.click();
					
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			
			}
			
			@Test(priority=11)
			public void clickSearchMyFavButton(){
				try{
					driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
						//driverFA.switchTo().defaultContent();
						System.out.println("in clickSearchMyFavButton");
						WebElement webelement = driverER.findElement(By.id("wweTeamCommunicatorSearchFavoritesButton"));
						if(webelement!=null){
							}
						webelement.click();
					
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			
			}
			
			@Test(priority=12)
			public void clickFinancequaltransfer(){
				try{
					driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
						//driverFA.switchTo().defaultContent();
						System.out.println("in clickFinancequaltransfer");
						JavascriptExecutor jse = (JavascriptExecutor)driverER;
						jse.executeScript("window.scrollBy(0,250)", "");
						
						WebElement webelement = driverER.findElement(By.id("wweTeamCommunicatorItem14DefaultActionButton"));
						
						if(webelement!=null){
							
							webelement.click();
						}else{
							System.out.println("FinanceTransfer element is null");
							throw new Exception();
						}
						
					
						
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			
			}
			

			
			
			
			@Test(priority=13)
			public void checkCallEstablishing(){
				try{
					System.out.println("in checkCallEstablishing");
					driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
						
							Thread.sleep(20000);
						
					System.out.println("out of wait");
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			
			}
			
			
			
			
			
			
			
			@Test(priority=14)
			public void clickInstantCallTransfer(){
				try{
					System.out.println("in clickInstantCallTransfer");
					driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
						WebElement webelement = driverER.findElement(By.id("wweVoice1CompleteConferenceButton"));
						webelement.click();
					
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			
			}
			
			
			@Test(priority=15)
			public void clickInstantCallConference(){
				try{
					System.out.println("in clickInstantCallConference");
					driverER.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						//driverFA.switchTo().defaultContent();
						WebElement webelement = driverER.findElement(By.id("wweTeamCommunicatorActiveItem0DefaultActionButton"));
						Thread.sleep(400);
						webelement.click();
					
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			
			}
			
			
			
			
			
			@Test(priority=16)
			public void endACCCall(){
				try{
					System.out.println("in endACCCall");
				int count = 0;
				WebElement webElement = (new WebDriverWait(driverFA, 100)).until(ExpectedConditions.elementToBeClickable((By.className("wwe-sprite-end-call"))));
				
			System.out.println("going to click end button on ACC side");
			
			if(webElement!=null){
				//Generic_Functions.WritePass(driverFA, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
				webElement.click();
				}
			
			Thread.sleep(10);
			
		}catch(Exception exception){
				exception.printStackTrace();
			}
		}
			
			@Test(priority=17)
			public void markACCCallDone(){
				try{
					System.out.println("in markACCCallDone");
				int count = 0;
				WebElement webElement = (new WebDriverWait(driverER, 100)).until(ExpectedConditions.elementToBeClickable((By.id("wweVoice1HangupButton"))));
			
			System.out.println("going to click done button on ACC side");
			
			if(webElement!=null){
				//Generic_Functions.WritePass(driverFA, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
				webElement.click();
				}
				}catch(Exception exception){
				exception.printStackTrace();
			}
		}
			/*@Test(priority=18)
			public void checkDoNotMarket() throws Exception{
				try{
					System.out.println("in checkDoNotMarket");
					//WebElement webElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable((By.id("wweVoice1HangupButton"))));
					WebElement webElement = (new WebDriverWait(driverFA, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("j4_2_anchor"))));
					
					if(webElement!=null){
						
							
							if("Do Not Market".equalsIgnoreCase(webElement.getText())){
								System.out.println("text matched in checkDoNotMarket"+webElement.getText());
								webElement.click();
							}
						
					}else{
						System.out.println("text not matched in checkDoNotMarket");
						throw new Exception();
					}
					driverFA.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
				}catch(Exception exception){
					Assert.fail("exception in checkDoNotMarket");
				}
				}*/
			
			
			@Test(priority=18)
			public void endFACall(){
				System.out.println("in endFACall");
				System.out.println("going to click end button on FA side");
				int count =0;
				try{
					WebElement webElement = (new WebDriverWait(driverFA, 100)).until(ExpectedConditions.elementToBeClickable((By.id("wweBundle1CloseButton"))));
					
				System.out.println("going to click end button on FA side");
				
				if(webElement!=null){
					//Generic_Functions.WritePass(driverFA, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
					webElement.click();
					}
				}catch(Exception exception){
				exception.printStackTrace();
			}
		}
			
			
			@Test(priority=19)
			public void markERCallDone(){
				System.out.println("in markERCallDone");
				try{
				int count = 0;
				WebElement webElement = (new WebDriverWait(driverER, 100)).until(ExpectedConditions.elementToBeClickable((By.id("wweBundle1CloseButton"))));
				
			System.out.println("going to click done button on ER side");
			
			if(webElement!=null){
				//Generic_Functions.WritePass(driverFA, currentSuit, folder, "Verify whether ER has received the call", "ER should have received the call correctly", "ER has received the call correctly");
				webElement.click();
				}
				}catch(Exception exception){
				exception.printStackTrace();
			}
		}	
			
			
			
	public void tearDown(){
		driverFA.close();
		driverER.close();
		GoogleHangout_Chrome googleHangout_NoVoice = new GoogleHangout_Chrome();
		googleHangout_NoVoice.tearDown();
	}
		
			
}
