package com.apollo.agentscripting_OLD;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AgentScriptPage {
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
	
	
	
	@Test(priority=0)
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://qa-ucpas-rp.qaapollogrp.edu/UCP_Agent_Scripts_Phase1/WWGStart.jsp?WWGProcessFlowName=Outbound_Campaign&G_Agent_ID=ucp_acc2&G_Interaction_ID=0095028C9F7FB9B8&G_Config_Place=QA_9902&G_Contact_ID=0002QaBYABPT1VFA&G_Script_ID=&G_Script_RelationshipID=&G_Script_Query_Relationship=1&G_OR_ID=9887&G_DispCode=False&G_IWS_MarkDoneSupport=False&wde_theme=Default&G_IWS_BrowserVersion=11");
		
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void clickQualify(){
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		System.out.println("1");
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("qualify"))));
		System.out.println("2");
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(webElement!=null){
		
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webElement);
		}else{
			System.out.println("element is null");
		}
	}
	
	
	@Test(priority=2)
	public void clickZipCode(){
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id='zipcode']"))));
		webElement.sendKeys("85260");
		
	}
	
	@Test(priority=3)
	public void clickState(){
		Select select = new Select(driver.findElement(By.name("state")));
		select.selectByVisibleText("Maine");
		
	}
	
	@Test(priority=4)
	public void clickCountry(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.name("country"))));
		Select select = new Select(webElement);
		select.selectByVisibleText("Zimbabwe");
		
	}
	
	@Test(priority=5)
	public void clickEducationLevel(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.name("educationlevel"))));
		Select select = new Select(webElement);
		select.selectByVisibleText("Have GED");
		
	}
	
	
	@Test(priority=6)
	public void clickModality(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id='modality1']"))));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webElement);
		
	}
	
	
	@Test(priority=7)
	public void clickPrimaryAreaOfInterest(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.name("primaryaois"))));
		Select select = new Select(webElement);
		select.selectByVisibleText("Nursing");
		
	}
	
	@Test(priority=8)
	public void clickSecondaryAreaOfInterest(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.name("secondaryaois"))));
		Select select = new Select(webElement);
		select.selectByVisibleText("Human Services");
		
	}
	
	
	@Test(priority=9)
	public void clickRN(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id='rn1']"))));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webElement);
		
	}
	
	
	@Test(priority=10)
	public void clickProgramLevel(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.name("programlevel"))));
		
		Select select = new Select(webElement);
		
		List<WebElement> list = select.getOptions();
		System.out.println(list.size());
		for (WebElement webElement2 : list) {
			System.out.println(webElement2.getText().toString());
		}
		select.selectByVisibleText("Bachelors");
		
	}
	
	@Test(priority=11)
	public void clickProgramPL1(){
		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.name("programapl1"))));
		Select select = new Select(webElement);
		
		select.selectByVisibleText("RN to Bachelor of Science in Nursing");
		
	}
}
