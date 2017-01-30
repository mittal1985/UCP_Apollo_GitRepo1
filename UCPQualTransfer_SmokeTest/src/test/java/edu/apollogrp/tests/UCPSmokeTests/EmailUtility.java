package edu.apollogrp.tests.UCPSmokeTests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.apollo.reportgeneration.HtmlReport;

public class EmailUtility {
	
	public static StringBuffer buffer = new StringBuffer();
	public static String content = "";
	public static HtmlReport htmlReport = null;
	BufferedReader br = null;
	FileReader fr = null;
	public static String folderName="";
	
	@Test(priority=0)	
public void setEmail() {
	try{
	
	WebDriver driver = new FirefoxDriver();
	driver.get("http://localhost:8080/job/UCPQualTransfer_SmokeTest/ws/result/");
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

 
	
	List<WebElement> webElement=driver.findElements(By.tagName("a"));
	boolean bool = true;
	for (WebElement webElement2 : webElement) {
		
		System.out.println("links available on "+webElement2.getText());
		
		if(webElement2.getText().contains("Result_")){
			webElement2.click();
			break;
	}	
		}
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			List<WebElement> webElement3=driver.findElements(By.tagName("a"));
			
			for (WebElement webElement4 : webElement3) {
				if(webElement4.getText().equalsIgnoreCase("PC_Firefox_result.html")){
					webElement4.click();
					buffer.append(driver.getPageSource());
					content=buffer.toString();
					//driver.close();
					break;
				}
		
	}
	
	
	//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	
	sendEmail(content);
	//System.out.println(buffer.toString());
}catch(Exception exception){
	exception.printStackTrace();
}
}
	
	@Test(priority=1)	
	public static void sendEmail(String content) throws Exception {
		
						
			String to = "gaurav.mittal@apollo.edu";
		
		    ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);

            ExchangeCredentials credentials = new WebCredentials("gaurav.mittal@apollo.edu", "Apollo12#$");
            service.setCredentials(credentials);
            service.setUrl(new URI("https://outlook.office365.com/EWS/Exchange.asmx"));

            EmailMessage msg = new EmailMessage(service);
            msg.setSubject("Qualification Transfer Smoke Test Cases");
            msg.setBody(MessageBody.getMessageBodyFromText(content));
           // msg.se
            List<String> toAddressList = Arrays.asList(to.split("\\s*,\\s*"));
            Iterator<String> mailList = toAddressList.iterator();

            msg.getToRecipients().addSmtpAddressRange(mailList);
          
            msg.send();
					
			System.out.println("\nMail was sent successfully.");


		}
	
	
}


