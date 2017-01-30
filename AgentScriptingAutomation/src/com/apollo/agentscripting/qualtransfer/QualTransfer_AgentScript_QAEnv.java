package com.apollo.agentscripting.qualtransfer;

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

public class QualTransfer_AgentScript_QAEnv {
/*public static void main(String[] args) {
	//http://qa-ucpas-rp.qaapollogrp.edu/UCP_Agent_Scripts_Phase1/WWGStart.jsp?WWGProcessFlowName=Outbound_Campaign&G_Agent_ID=ucp_acc2&G_Interaction_ID=0095028C9F7FB9B8&G_Config_Place=QA_9902&G_Contact_ID=0002QaBYABPT1VFA&G_Script_ID=&G_Script_RelationshipID=&G_Script_Query_Relationship=1&G_OR_ID=9887&G_DispCode=False&G_IWS_MarkDoneSupport=False&wde_theme=Default&G_IWS_BrowserVersion=11

	WebDriver driver = new FirefoxDriver();
	driver.get("http://qa-ucpas-rp.qaapollogrp.edu/UCP_Agen_Scripts_Phase1/WWGStart.jsp?WWGProcessFlowName=Outbound_Campaign&G_Agent_ID=ucp_acc2&G_Interaction_ID=0095028C9F7FB9B8&G_Config_Place=QA_9902&G_Contact_ID=0002QaBYABPT1VFA&G_Script_ID=&G_Script_RelationshipID=&G_Script_Query_Relationship=1&G_OR_ID=9887&G_DispCode=False&G_IWS_MarkDoneSupport=False&wde_theme=Default&G_IWS_BrowserVersion=11");
	
	driver.manage().window().maximize();

	
	//wait for page to load
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
	driver.findElement(By.id(("qualify"))).click();


}*/
	WebDriver driver = null;
	WebDriver driverER = null;
	
	
	@Test(priority=0)
	public void setUp(){
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driver = new FirefoxDriver(customProfile);
		
		//driver.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
		
		driver.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void setUpER(){
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driverER = new FirefoxDriver(customProfile);
		
		//driver.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
		
		driverER.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driverER.manage().window().maximize();
	}
	
	
	@Test(priority=2)
	public void clickUserNameER(){
		driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driverER, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucpeawe2");
	
		}else{
			System.out.println("element is null");
		}
	}
	
	
	@Test(priority=3)
	public void clickPasswordER(){
		driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driverER, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucpeawe2");
	
		}else{
			System.out.println("element is null");
		}
	}
	
	
	@Test(priority=4)
	public void clickSubmitER(){
		//Alert alert = new Alert();
		
		WebElement webElement = (new WebDriverWait(driverER, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
		webElement.click();
		
		driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		
		/*drop down click working*/
		System.out.println("going to click dropdown for ER");
		driverER.findElement(By.id("wweAgentSwitchStateButton")).click();
		driverER.findElement(By.xpath("//span[@class='presence-text']")).click();
		System.out.println("ER should be now in ready status");
		
	}
	
	
	
	@Test(priority=5)
	public void clickUserName(){
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucp_acc_wwe2");
	
		}else{
			System.out.println("element is null");
		}
	}
	
	@Test(priority=6)
	public void clickPassword(){
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginPasswordField"))));
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(webElement!=null){
		
			//webElement.sendKeys("ucp_acc1");
			
			webElement.sendKeys("ucp_acc_wwe2");
	
		}else{
			System.out.println("element is null");
		}
	}
	
	
	@Test(priority=7)
	public void clickSubmit(){
		//Alert alert = new Alert();
		
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
		webElement.click();
		
	}
	
	@Test(priority=8)
	public void getCall(){
		try{
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
		}
		
	
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		/*to disconnect the call*/
		//driver.findElement(By.id("wweVoice1HangupButton")).click();
		
		
	@Test(priority=9)
	public void clickCaseInfo(){
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweCaseData1Label"))));
		webElement.click();
		
		if(webElement.isDisplayed()){
			System.out.println("Case Info is displayed");
		}
		webElement.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		//System.out.println("going out of clickagentscripting");
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
			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("CaseRightTabs1ItemExtUCPAgentScripting0"))));
			webElement.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			System.out.println("going out of clickagentscripting");
			//webElement.click();
		}
		
		
		
		@Test(priority=11)
		public void clickNameSearch(){
			try{
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					/*switch to iframe of IRN */
					driver.switchTo().frame(driver.findElement(By.className("wwe-web-extension-iframe")));
					
					WebElement firstNameElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("firstnamesearch"))));
					firstNameElement.sendKeys("Anand");
					
					WebElement lastNameElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("lastnamesearch"))));
					lastNameElement.sendKeys("Nair");
			
	
					Thread.sleep(4000);
					 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
					 Thread.sleep(4000);
					System.out.println("going to click after wait");
					WebDriverWait wait = new WebDriverWait(driver, 500);
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.id("inboudnSearch")))));
					driver.findElement((By.id("inboudnSearch"))).click();
				
				
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
					 (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("prospect0")))).click();
					
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
					
					
					 (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("searchQualify")))).click();
					
					 
				
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
						webElement.click();
					}else{
						driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
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
					webelement.click();
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		
		}
		
		@Test(priority=21)
		public void getCallER(){
			try{
			int count = 0;
			WebElement webElement = (new WebDriverWait(driverER, 5000)).until(ExpectedConditions.elementToBeClickable((By.className("wwe-sprite-end-call"))));
			while(webElement==null){
				count = count++;
				driverER.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
		System.out.println("going to click end button on ER side");
		webElement.click();
		
		
	}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		
}
