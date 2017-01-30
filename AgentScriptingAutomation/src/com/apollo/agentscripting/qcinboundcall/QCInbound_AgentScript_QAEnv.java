package com.apollo.agentscripting.qcinboundcall;

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

import com.apollo.reportgeneration.Generic_Functions;
import com.apollo.reportgeneration.HtmlReport;

public class QCInbound_AgentScript_QAEnv {
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
	public static HtmlReport currentSuit = new HtmlReport();
	public static String folder;
	public static String screen_Header;
	public static String app_Name_Final;
	public static String proj_Name_Final;
	
	public void reportSetUp() {
		try{
		app_Name_Final = "QA Automation";
		proj_Name_Final = "UCP QA Automation";
		screen_Header = currentSuit.writeReportHeader(proj_Name_Final,app_Name_Final, "Test_Release", "PC_Firefox", "UCP");
		folder = currentSuit.writeSubHeader("Test run result for " + "Smoke Tests QCInbound Call",screen_Header);
		System.out.println("folder in reportsSetUp------>"+folder);
		currentSuit.writeSubHeaderForScripts("Smoke Tests",folder);
	}catch(Exception exception){
		//exception.printStackTrace();
	}
	}
	
	@Test(priority=0)
	public void setUp(){
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driver = new FirefoxDriver(customProfile);
		driver.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
		
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void clickUserName(){
		try{
			reportSetUp();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("wweLoginUserNameField"))));
		
		
		if(webElement!=null){
			System.out.println("folder------->"+folder+"------currentSuit-------"+currentSuit);
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether LoginUserName exists", "LoginUserName should be loaded correctly", "LoginUserName is loaded correctly");
			
			webElement.sendKeys("ucp_acc1");
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", webElement);
		}else{
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether LoginUserName exists", "LoginUserName should be loaded correctly", "LoginUserName is not loaded correctly");
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
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether LoginPassword exists", "LoginPassword should be loaded correctly", "LoginUserName is loaded correctly");
			
			webElement.sendKeys("ucp_acc1");
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", webElement);
		}else{
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether LoginPassword exists", "LoginPassword should be loaded correctly", "LoginUserName is not loaded correctly");
			
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
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether LoginSignIn exists", "LoginSignIn should be loaded correctly", "LoginUserName is loaded correctly");
			
			webElement.click();
		}else{
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether LoginSignIn exists", "LoginSignIn should be loaded correctly", "LoginUserName is not loaded correctly");
			
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
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Agent Ready Status dropdown exists", "Agent Ready Status dropdown should be loaded correctly", "LoginUserName is loaded correctly");
			
			
		}else{
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether Agent Ready Status dropdown exists", "Agent Ready Status dropdown should be loaded correctly", "LoginUserName is not loaded correctly");
			
			System.out.println("Agent Ready Status dropdown is null");
		}
		
		
		//after receiving call
		List<WebElement> webElement3= driver.findElements(By.id("wweVoice1HangupButton"));
		if(webElement3.size()!=0){
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Inbound Call is received", "Inbound Call should be received", "Inbound Call is received");
			//System.out.println("done");
		}
		
	
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
		/*to disconnect the call*/
		//driver.findElement(By.id("wweVoice1HangupButton")).click();
		
		
	@Test(priority=5)
	public void clickCaseInfo(){
		try{
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("wweCaseData1Label"))));
		System.out.println("CaseInfo webElement--------->"+webElement);
		if(webElement!=null){
			System.out.println("webelement is not null");
			webElement.click();
			Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Case Info is displayed", "Case Info should be displayed correctly", "Case Info is displayed correctly");
			
			
		}else{
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether Case Info is displayed", "Case Info should be displayed", "Case Info is displayed correctly");
			
			
		}
		
		
	
		webElement.click();
		
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	
	@Test(priority=6)
	public void clickCallType(){
		try{
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id='wweCaseData1callDescriptionValue']/div[1]/div[1]"))));
		
			System.out.println("Call Type is----->"+webElement.getText()+""+webElement.getClass());
			
			if(webElement.getText().equalsIgnoreCase("Inbound Callback")){
				webElement.click();
				Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether CallType is Inbound Callback", "CallType should be Inbound Callback", "CallType is Inbound Callback");
				
				
			}else{
				Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify whether CallType is Inbound Callback", "CallType should be Inbound Callback", "CallType is Inbound Callback");
				
				System.out.println("CallType is not Inbound Direct");
			}
		
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		//System.out.println("going out of clickagentscripting");
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}
	

	@Test(priority=7)
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
	
	@Test(priority=8)
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
	
	@Test(priority=9)
	public void checkHistoryTab(){
	
		WebElement webElement = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable((By.id("TabswweInteraction1ContactViewItem1"))));
		boolean bool = webElement.isDisplayed();
		System.out.println(""+bool);
		
		if(webElement.isDisplayed()){
			System.out.println("clicked on contact history tab is verified");
			webElement.click();
		}else{
			System.out.println("contact history tab not available");
			Assert.fail();
		}
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=10)
	public void clickAgentScritping(){
		try{
			System.out.println("in clickagentscripting");
				WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.id("CaseRightTabs1ItemExtUCPAgentScripting0"))));
				webElement.click();
				driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
				System.out.println("going out of clickagentscripting");
			
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}
	
	@Test(priority=11)
	public void clickHungups(){
		try{
				driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
				/*switch to iframe of IRN */
				driver.switchTo().frame(driver.findElement(By.className("wwe-web-extension-iframe")));
				
				
		
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				Thread.sleep(4000);
				 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
				 Thread.sleep(4000);
				System.out.println("going to click after wait");
				WebDriverWait wait = new WebDriverWait(driver, 500);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.id("hungup")))));
				driver.findElement((By.id("hungup"))).click();
			
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
	
	}
	
	
	@Test(priority=12)
	public void clickOnradioButton(){
		System.out.println("in radio button");
		
		WebElement webElement = (new WebDriverWait(driver, 300)).until(ExpectedConditions.elementToBeClickable((By.id("firstParty3"))));
		boolean bool = webElement.isDisplayed();
		System.out.println(""+bool);
		
		if(webElement.isDisplayed()){
			System.out.println("going to click on radio button");
			webElement.click();
		}else{
			System.out.println("radio button not available");
			Assert.fail();
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=13)
	public void clickOnSelectHungUp(){
		//Click on Select dropdown
	
	
		
		List<WebElement> webElements =driver.findElements(By.cssSelector("a[href='#']"));
		for (WebElement webElement2 : webElements) {
			//System.out.println(webElement2.getText());
			if(webElement2.getText().equalsIgnoreCase("Hung Up")){
				webElement2.click();
			}
		} 
	
}
	
	@Test(priority=14)
	public void clickOnEndCallTab(){
		System.out.println("in clickOnEndCallTab");
		driver.switchTo().defaultContent();
		System.out.println("after default content");
		WebElement element =driver.findElement(By.id("wweVoice1HangupButton"));
	
		    
		       element.click();
}
	
	@Test(priority=15)
	public void clickOnEndCall(){
		System.out.println("in clickOnEndCall");
		/*switch to iframe of IRN */
		driver.switchTo().frame(driver.findElement(By.className("wwe-web-extension-iframe")));
		WebElement element =driver.findElement(By.id("endCallButton"));
		if(element.isDisplayed()){
			System.out.println("element dispalyed");
		}
		       element.click();
		       driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
}	
	
	@Test(priority=16)
	public void clickDone(){
		System.out.println("in clickDone");
		/*switch to iframe of IRN */
		driver.switchTo().defaultContent();
		driver.findElement(By.id("wweBundle1CloseButton")).click();
	}
	
	
	
	
}
