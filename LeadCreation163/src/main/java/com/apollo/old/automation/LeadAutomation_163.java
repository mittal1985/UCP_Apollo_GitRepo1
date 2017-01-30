package com.apollo.old.automation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.apollo.irnworkItemStatus.IRN_WorkItemStatus;
import com.apollo.reportgeneration.Generic_Functions;
import com.apollo.reportgeneration.HtmlReport;

public class LeadAutomation_163 {
	//HtmlUnitDriver driver = null;
	WebDriver driver = null;
	Cell cell = null;
	public static HtmlReport currentSuit = new HtmlReport();
	public String folder;
	public String screen_Header;
	public String app_Name_Final;
	public String proj_Name_Final;
	
	public void leadCreationPage(int count) {
		try{
		app_Name_Final = "QA Automation";
		proj_Name_Final = "UCP QA Automation";
		screen_Header = currentSuit.writeReportHeader(proj_Name_Final,app_Name_Final, "Test_Release", "PC_Firefox", "UCP");
		folder = currentSuit.writeSubHeader("Test run result for " + "LeadCreation   "+count,screen_Header);
		currentSuit.writeSubHeaderForScripts("Lead Creation",folder);
	}catch(Exception exception){
		//exception.printStackTrace();
	}
	}
	
	@Test(priority=0)
	public void setUp(String formPath){
		driver = new FirefoxDriver();
		//driver =new HtmlUnitDriver();
		//driver.setJavascriptEnabled(true);
		driver.get(formPath);
		//driver.get("file:///C:/Users/gmittal/Desktop/URL_16.3_qa.html");
		
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void clickFirstName(String firstName,int count){
		try{
		leadCreationPage(count);
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("First_Name"))));
		webElement.sendKeys(firstName);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether FirstName is loaded successfully", "FirstName should be loaded correctly", "FirstName is loaded correctly");
		
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
	
	}
	@Test(priority=2)
	public void clickLastName(String lastName){
		try{
		//	htmlReportSetUp();	
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("Last_Name"))));
		webElement.sendKeys(lastName);
		System.out.println(driver +""+"--------"+currentSuit+"----------"+folder);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether LastName is loaded successfully", "LastName should be loaded correctly", "LastName is loaded correctly");
		
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=3)
	public void clickAddress(String address){
		try{
		//	htmlReportSetUp();
		WebElement addressElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("Street_Address"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		js.executeScript(scriptSetAttrValue, addressElement, "value", address);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Address is loaded successfully", "Address should be loaded correctly", "LastName is loaded correctly");
		    
		}catch(Exception exception){
			exception.printStackTrace();
		}}
	
	@Test(priority=4)
	public void clickCity(String city){
		try{
		//	htmlReportSetUp();
			WebElement cityElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("City"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		js.executeScript(scriptSetAttrValue, cityElement, "value", city);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether City is loaded successfully", "City should be loaded correctly", "LastName is loaded correctly");
		    
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=5)
	public void clickState(String state){
		try{
			
				//leadCreationPage();
			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("ContactState"))));
		webElement.sendKeys(state);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether State is loaded successfully", "State should be loaded correctly", "State is loaded correctly");
	    
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=6)
	public void clickZipCode(int zipCode){
		try{
			//leadCreationPage();
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("ZipCode"))));
		webElement.sendKeys(String.valueOf(zipCode));
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether ZipCode is loaded successfully", "State should be loaded correctly", "State is loaded correctly");
	    
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	
	
	@Test(priority=7)
	public void clickAreaCode(int areaCode){
		try{
		//	leadCreationPage();
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("Work_Phone_Number_Area_Code"))));
		webElement.sendKeys(String.valueOf(areaCode));
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether AreaCode is loaded successfully", "AreaCode should be loaded correctly", "State is loaded correctly");
	    
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=8)
	public void clickPhone(int phoneNumber){
		try{
		//	leadCreationPage();
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("Work_Phone_Number"))));
		webElement.sendKeys(String.valueOf(phoneNumber));
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Phone is loaded successfully", "Phone should be loaded correctly", "State is loaded correctly");
	    
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	
	
	
	
	@Test(priority=9)
	public void clickEmail(String email){
		try{
		//	leadCreationPage();
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("Email"))));
		webElement.sendKeys(email);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Email is loaded successfully", "Email should be loaded correctly", "Email is loaded correctly");
	    
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	
	@Test(priority=10)
	public void clickProgram(String programInput){
		try{
		//	leadCreationPage();
		WebElement program = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("Program"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		js.executeScript(scriptSetAttrValue, program, "value", programInput);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Program is loaded successfully", "Program should be loaded correctly", "State is loaded correctly");
	        
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=11)
	public void clickSource(String source){
		try{
		//	leadCreationPage();
		WebElement sourceElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("SourceCode"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		js.executeScript(scriptSetAttrValue, sourceElement, "value", source);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Source is loaded successfully", "Source should be loaded correctly", "State is loaded correctly");
	      
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=12)
	public void clickCampaign(String campaign){
		try{
		//	leadCreationPage();
		WebElement detailCode = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("DetailCode"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		js.executeScript(scriptSetAttrValue, detailCode, "value", campaign);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Campaign is loaded successfully", "Campaign should be loaded correctly", "State is loaded correctly");
	      
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=13)
	public void clickNotes(String notes){
		try{
		//	leadCreationPage();
		WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("Notes"))));
		webElement.sendKeys(notes);
		Generic_Functions.WritePass(driver, currentSuit, folder, "Verify whether Notes is loaded successfully", "Notes should be loaded correctly", "State is loaded correctly");
	    
	}catch(Exception exception){
		exception.printStackTrace();
	}}
	
	@Test(priority=14)
	public String clickSubmit(){
		String pagesource =null;
		try {
		//	WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable((By.name("submit"))));
			
			WebElement webElement = (new WebDriverWait(driver, 5000)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@name='submit']")));
			
			webElement.click();
			
			pagesource = driver.getPageSource();

			System.out.println("output after submitting lead is as below------>");
			System.out.println(pagesource);

		}catch(Exception ex){
		ex.printStackTrace();
	} return pagesource;
	
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public String getFolder(){
		return folder;
	}
	
	@Test(priority=15)
	public void tearDown(){
			driver.close();
	
	}
	
	
	@Test(priority=16)
	public void writeInExcel(Row row,String pagesource,IRN_WorkItemStatus irn_WorkItemStatus){
		 cell = row.createCell(13);
         cell.setCellValue(pagesource);
         
         cell = row.createCell(14);
         cell.setCellValue(irn_WorkItemStatus.getIrn());
         
         cell = row.createCell(15);
         cell.setCellValue(irn_WorkItemStatus.getWorkItemStatus());
         
         cell = row.createCell(16);
         cell.setCellValue(irn_WorkItemStatus.getWorkItemId());
	
	}
	
	
	
}
