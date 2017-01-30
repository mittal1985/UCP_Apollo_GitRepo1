package com.apollo.agenrscripting.googlehangout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GooglehangOut {

	
	
	WebDriver driver = null;
	
	
	@Test(priority=0)
	public void setUp(){
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driver = new FirefoxDriver(customProfile);
		
		//driver.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");
		
		driver.get("https://www.google.com/gmail/about/");
		driver.manage().window().maximize();
	}
	
	
	
	@Test(priority=1)
	public void clickSignIn(){
		

		WebElement webElement = (new WebDriverWait(driver, 8000)).until(ExpectedConditions.elementToBeClickable((By.xpath("html/body/nav/div/a[2]"))));
		webElement.click();
		
	}
	
	@Test(priority=2)
	public void clickUsername(){
		

		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("Email"))));
		
		webElement.sendKeys("uop.phoenix.11@gmail.com");
	}
	
	@Test(priority=3)
	public void clickNext(){
		

		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("next"))));
		webElement.click();
		
	}

	@Test(priority=4)
	public void clickPassword(){
		

		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("Passwd"))));
		webElement.sendKeys("Phoenix.11");
			
	}
	
	@Test(priority=5)
	public void clickSubmit(){
		

		WebElement webElement = (new WebDriverWait(driver, 2000)).until(ExpectedConditions.elementToBeClickable((By.id("signIn"))));
		webElement.click();
			
	}
	
	
	
}
