package com.apollo.agentscripting.er_inboundcall;

import java.util.List;
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

import com.apollo.googlehangout.GoogleHangout_NoVoice;
import com.apollo.reportgeneration.Generic_Functions;
import com.apollo.reportgeneration.HtmlReport;

//4804944778
public class ERInbound_AgentScript_QAEnv {
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
	public String phoneNumber="4804944778";
	public GoogleHangout_NoVoice googleHangout= null;
	
	
	@Test(priority=0)
	public void setUp(){
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driver = new FirefoxDriver(customProfile);
		driver.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void clickUserName(){
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
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}
	
	@Test(priority=2)
	public void clickPassword(){
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
	}catch(Exception exception){
	exception.printStackTrace();
	}
	}
	
	
	@Test(priority=3)
	public void clickSubmit(){
		try{
		//Alert alert = new Alert();
		
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginSignInButton"))));
		if(webElement!=null){
			
			webElement.click();
		}else{
			
			System.out.println("element is null");
		}
		
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}
	
	@Test(priority=4)
	public void getAgentReady(){
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
		
		
	
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		/*to disconnect the call*/
		//driver.findElement(By.id("wweVoice1HangupButton")).click();
		
	
	@Test(priority=5)
	public void getCall(){
		try{
			
			googleHangout= new GoogleHangout_NoVoice();
			googleHangout.setUp(phoneNumber);
	
	
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	
	
	@Test(priority=6)
	public void clickCaseInfo(){
		try{
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweCaseData1Label"))));
		System.out.println("CaseInfo webElement--------->"+webElement);
		if(webElement!=null){
			System.out.println("webelement is not null");
			webElement.click();
			
			
		}else{
			
			
		}
		
		
	
		webElement.click();
		
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	
	@Test(priority=7)
	public void clickCallType(){
		try{
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id='wweCaseData1callDescriptionValue']/div[1]/div[1]"))));
		
			System.out.println("Call Type is----->"+webElement.getText()+""+webElement.getClass());
			
			if(webElement.getText().equalsIgnoreCase("Enrollment Inbound Direct")){
				webElement.click();
				
				
			}else{
				
				System.out.println("CallType is not Enrollment Inbound Direct");
			}
		
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		//System.out.println("going out of clickagentscripting");
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}
	

	@Test(priority=8)
	public void checkContactTab(){
	
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
		
	}
	
	@Test(priority=9)
	public void checkContactInformation(){
	
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
		
	}
	
	@Test(priority=10)
	public void clickEndCall(){
	try{
		System.out.println("in clickEndCall");
		WebElement webElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable((By.id("wweVoice1HangupButton"))));
		if(webElement!=null){
			webElement.click();
		}else{
			System.out.println("webelement is null");
		}
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		
	}catch(Exception exception){
	exception.printStackTrace();
	}
	}
	
	@Test(priority=11)
	public void clickDoneButton(){
		try{
			System.out.println("in clickDoneButton");
				WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweBundle1CloseButton"))));
				if(webElement!=null){
					webElement.click();
				}else{
					System.out.println("webelement is null");
				}
				
			
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}
	
	
	
	@Test(priority=12)
	public void tearDown(){
		driver.close();
		googleHangout=new GoogleHangout_NoVoice();
		googleHangout.tearDown();
	}
	
	
	
	
}
