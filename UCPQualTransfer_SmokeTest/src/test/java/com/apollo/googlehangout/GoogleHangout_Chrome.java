package com.apollo.googlehangout;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleHangout_Chrome {

	
	//WebDriver driver = null;
	WebDriver driverGoogleHangout = null;
	//WebDriver driverGoogleVoice = null;
	
	
	@Test(priority=0)
	public void setUp(String phoneNumber){
		System.out.println("i am in setUp");
		 ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("test-type");
		 chromeOptions.addArguments("--use-fake-ui-for-media-stream");
         DesiredCapabilities capabilities = DesiredCapabilities.chrome();
         capabilities.setCapability("chrome.binary","C:\\ChromeDriverExe\\chromedriver.exe");
         capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        // driverGoogleHangout = new ChromeDriver(somewhere, chromeOptions);
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriverExe\\chromedriver.exe");
		driverGoogleHangout = new ChromeDriver(capabilities);
		
		driverGoogleHangout.get("http://www.gmail.com");
		
		driverGoogleHangout.manage().window().maximize();
		loginGmail(phoneNumber);
	}
	
	@Test(priority=1)
	public void loginGmail(String phoneNumber){
		try{
		//Thread.sleep(1000);
			WebDriverWait driverWait= new WebDriverWait(driverGoogleHangout, 100);
			driverWait.until(ExpectedConditions.elementToBeClickable(driverGoogleHangout.findElement(By.id("Email"))));
			
			
		driverGoogleHangout.findElement(By.id("Email")).sendKeys("uop.phoenix.11@gmail.com");
		driverGoogleHangout.findElement(By.id("next")).click();
		driverGoogleHangout.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driverGoogleHangout.findElement(By.id("Passwd")).sendKeys("Phoenix.11");
		driverGoogleHangout.findElement(By.id("signIn")).click();
		Thread.sleep(2000);
		loginHangouts(phoneNumber);
	
	}catch(Exception exception){
		//exception.printStackTrace();
	}
	}
	
	@Test(priority=2)
	public void loginHangouts(String phoneNumber){
		try{
			driverGoogleHangout.get("https://hangouts.google.com/");
			driverGoogleHangout.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			Thread.sleep(4000);
			
			//driverGoogleHangout.findElements(By.xpath("//iframe[@class"))
			System.out.println("going to check iframes after sleep");
			
			List<WebElement> frames = driverGoogleHangout.findElements(By.tagName("iframe"));
			System.out.println("size of frames"+frames.size());
			
			for (WebElement frame : frames) {
				
				if(frame.getAttribute("class").equalsIgnoreCase("Xyqxtc")){
					driverGoogleHangout.switchTo().frame(frame);
					
					Thread.sleep(1000);
					//System.out.println("going to click");
					List<WebElement> el =driverGoogleHangout.findElements(By.tagName("path"));
					//System.out.println(el.size());
					for (WebElement webElement : el) {
						//System.out.println("going to check it -----");
						if(webElement.getAttribute("d").equalsIgnoreCase("M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z")){
							//System.out.println("found element-----");
							webElement.click();
							break;
						}
					}
					System.out.println("going to type cell number");
					//a[starts-with(@href, "mylink")]
					driverGoogleHangout.findElement(By.xpath("//input[starts-with(@class,'tF')]")).sendKeys(phoneNumber);
					Thread.sleep(10);
					driverGoogleHangout.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driverGoogleHangout.findElement(By.xpath("//li[starts-with(@class,'eh')]")).click();
					
				}
				
			
			}
			
	
		
	
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}

	public void tearDown(){
		//driverGoogleHangout.findElement(By.className("U1K4Bb aqZaad")).click();
		if(driverGoogleHangout!=null){
			driverGoogleHangout.findElement(By.xpath("//span[starts-with(@class,'gb_9a')]"));
			driverGoogleHangout.findElement(By.id("gb_71")).click();
		}else{
			System.out.println("driverGoogleHangout is null");
		}
		//driverGoogleHangout.close();
	}
	
	

}
