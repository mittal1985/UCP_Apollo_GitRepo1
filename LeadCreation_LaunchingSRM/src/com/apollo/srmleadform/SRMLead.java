package com.apollo.srmleadform;

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

public class SRMLead {
	//public static WebDriver driver;
	public static void main(String args[]){
		try{
		String driverPath = "C:\\Users\\gmittal\\Desktop\\UCP\\Selenium\\ChromeBinary\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe";
		String iframeID =null;
		System.out.println("*******************");
		//System.out.println("launching chrome browser");
		System.setProperty("webdriver.ie.driver", driverPath);
		//WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://cas2.qaapollogrp.edu/cas/login?service=https%3A%2F%2Fapollogrp--TEST.cs15.my.salesforce.com%3Fcallback%3D%26x-apollo-transaction-id%3D6ba2914e-580a-4ca0-bf57-e2277bfe25a3");
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("lggreer");
		driver.findElement(By.name("password")).sendKeys("Welcome1");
		
		driver.findElement(By.className("lock-icon")).click();
		
		driver.manage().timeouts().implicitlyWait(110, TimeUnit.SECONDS);
		System.out.println("i m here1"+driver.getTitle());
		
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("size-------"+iframes.size());
		
		
	
			driver.switchTo().frame("ext-comp-1026");
			fillForm(driver);
	
		
		
		
	
		
		
		
		
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
	}
	
	
	public static void fillForm(WebDriver driver ){
		
		try{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'fname')]"))).sendKeys("Gaurav");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("lastnameinput"))).sendKeys("Mittal");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("streetInput"))).sendKeys("Modipuram");
		
		
		
		
		
		
		
		//country
		
		//Select select5 = new Select(driver.findElement(By.className("countryInput")));
	//	select5.selectByVisibleText("INDIA");
		
		
		//city
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cityInput"))).sendKeys("meerut");
		
		//state
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("stateInput"))).sendKeys("Uttar Pradesh");
		
		//postalcodeinput
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("postalCodeInput"))).sendKeys("250110");
		
		
		//phone area code
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("businessinput1"))).sendKeys("+91");
		
		//phone
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("businessinput2"))).sendKeys("250110");
		
		//email
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("emailinput"))).sendKeys("Mittal@test.com");
		
		//US Citizen
		boolean  oRadioButton = driver.findElement(By.xpath("//input[@value='Yes']")).isSelected();
		driver.findElement(By.xpath("//input[@value='No']")).click();
		
		//Military Branch
		WebElement webele= driver.findElement(By.xpath("//select[contains(@id,'mbranch')]"));
		Select select = new Select(webele);
		select.selectByVisibleText("Army");
		
		//Military Status
		Select select1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'mstatus')]")));
		select1.selectByVisibleText("Reserve");
		
		//Program Level Status
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@id,'deglevel')]")));
		Select select12 = new Select(driver.findElement(By.xpath("//select[contains(@id,'deglevel')]")));
		select12.selectByVisibleText("Associates Degree");
		
		
		//Area of interest Level Status
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@id,'areaOfInterest')]")));
		Select select123 = new Select(driver.findElement(By.xpath("//select[contains(@id,'areaOfInterest')]")));
		select123.selectByVisibleText("Arts and Sciences");
		
		//campus
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@id,'campus')]")));
		Select select1234 = new Select(driver.findElement(By.xpath("//select[contains(@id,'campus')]")));
		select1234.selectByVisibleText("ONLINE");
		
		
		//Source Input
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@id,'source')]")));
				Select select34 = new Select(driver.findElement(By.xpath("//select[contains(@id,'source')]")));
				select34.selectByVisibleText("ACRF");
				
		//thirdparty
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'thirdparty')]")));
				driver.findElement(By.xpath("//input[contains(@id,'thirdparty')]")).click();
				
				Thread.sleep(100);
				
				
				//Program of interest
		driver.manage().timeouts().implicitlyWait(140, TimeUnit.SECONDS);
		System.out.println("going to hit");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_id0:theform:j_id50:j_id116:j_id138:progofinterest")));
		System.out.println("after explicit wait-----");
		driver.manage().timeouts().implicitlyWait(110, TimeUnit.SECONDS);
		System.out.println("after implicit wait-----");
		WebElement progOfInterest= driver.findElement(By.id("j_id0:theform:j_id50:j_id116:j_id138:progofinterest"));
		if(progOfInterest!=null){
			System.out.println("object not null---->"+progOfInterest.getTagName());
		}else{
			System.out.println("object is null");
			Thread.sleep(1000L);
			progOfInterest= driver.findElement(By.id("j_id0:theform:j_id50:j_id116:j_id138:progofinterest"));
			System.out.println("created again--->"+progOfInterest);
			
		}
		Select select234 = new Select(progOfInterest);
		System.out.println("after making select object"+select234);
		System.out.println("==========="+select234.getOptions().size());
		List<WebElement> list = select234.getOptions();
		for (WebElement object : list) {
			System.out.println(object.getText());
		}
		select234.selectByIndex(2);	
		
		
		
				
		//Campaign Input
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='DEFAULT']")));
		System.out.println("after wait-----");
		
		WebElement campaign = (driver.findElement(By.xpath("//input[@value='DEFAULT']")));
		
		/*System.out.println("campaign.getText()---"+campaign.getText());
		if(campaign.getText()==""||campaign.getText().isEmpty()){
			System.out.println("gettext is empty"+campaign.getText());
			Thread.sleep(2000);
			System.out.println("after wait----"+campaign.getText());
			
		}
		
		System.out.println("----"+campaign.getText());
		
		campaign.sendKeys(Keys.CONTROL+ "a");
		campaign.sendKeys(Keys.DELETE);	
		Thread.sleep(1000);
		campaign.sendKeys("ACRF");
		
		System.out.println("trying second time-----");*/
	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		js.executeScript(scriptSetAttrValue, campaign, "value", "ACRF");
		    
			//tcpa consent
			driver.findElement(By.xpath("//span[contains(@id,'tcpaCheckBox')]")).click();
				
		
		
	}catch(Exception exception){
		exception.printStackTrace();
	}
	
	
	}
	
	
	
}
