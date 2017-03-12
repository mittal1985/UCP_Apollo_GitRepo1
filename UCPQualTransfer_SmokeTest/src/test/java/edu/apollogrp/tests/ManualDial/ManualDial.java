package edu.apollogrp.tests.ManualDial;

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


public class ManualDial {
	// 4807548519
	WebDriver driverFA = null;
	WebDriver driverER = null;
	public String folder;
	public String screen_Header;
	public String app_Name_Final;
	public String proj_Name_Final;
	BufferedWriter bw = null;
	FileWriter fw = null;
	public String phoneNumber = "4804944778";

	public void setUp() throws Exception {
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driverFA = new FirefoxDriver(customProfile);

		// driverFA.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");

		// driverFA.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driverFA.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driverFA.manage().window().maximize();
	}

	public void setUpER() throws Exception {
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driverER = new FirefoxDriver(customProfile);

		// driverER.get("http://dlaxucww001.devapollogrp.edu:8080/ui/ad/v1/index.html");

		// driverER.get("http://qlaxucww001.qaapollogrp.edu:8080/ui/ad/v1/index.html");
		driverER.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html ");

		driverER.manage().window().maximize();
	}

	public void clickUserNameER() throws Exception {
		try {

			driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

			WebElement webElement = (new WebDriverWait(driverER, 2000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginUserNameField"))));

			if (webElement != null) {

				// webElement.sendKeys("ucp_acc1");

				webElement.sendKeys("ucpeawe2");

			} else {
				System.out.println("element is null");

			}

		} catch (Exception exception) {
			Assert.fail("exception in clickUserNameER");
		}

	}

	public void clickPasswordER() throws Exception {
		try {
			driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

			WebElement webElement = (new WebDriverWait(driverER, 2000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginPasswordField"))));

			// driverFA.manage().timeouts().implicitlyWait(2000,
			// TimeUnit.SECONDS);
			if (webElement != null) {

				// webElement.sendKeys("ucp_acc1");

				webElement.sendKeys("ucpeawe2");

			} else {
				System.out.println("element is null");

			}
		} catch (Exception exception) {
			Assert.fail("exception in clickPasswordER");
		}

	}

	public void clickSubmitER() throws Exception {
		try {
			// Alert alert = new Alert();

			WebElement webElement = (new WebDriverWait(driverER, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginSignInButton"))));

			if (webElement != null) {

				// webElement.sendKeys("ucp_acc1");

			} else {
				System.out.println("element is null");

			}

			webElement.click();

			driverER.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

			/* drop down click working */
			System.out.println("going to click dropdown for ER");
			driverER.findElement(By.id("wweAgentSwitchStateButton")).click();
			driverER.findElement(By.xpath("//span[@class='presence-text']"))
					.click();
			System.out.println("ER should be now in ready status");

		} catch (Exception exception) {
			Assert.fail("exception in clickSubmitER");
		}
	}

	

	public void getCall() throws Exception {
		try {

			GoogleHangout_FF googleHangout = new GoogleHangout_FF();
			googleHangout.setUp(phoneNumber);
			int count = 0;
			WebElement webElement = (new WebDriverWait(driverER, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("agent-desktop-container-title"))));
			while (webElement == null) {
				count = count++;
				driverER.manage().timeouts()
						.implicitlyWait(100, TimeUnit.SECONDS);
			}

			/* drop down click working */
			System.out.println("going to click dropdown");
			driverER.findElement(By.id("wweAgentSwitchStateButton")).click();
			driverER.findElement(By.xpath("//span[@class='presence-text']"))
					.click();
			
			// after receiving call
			if (driverER.findElements(By.id("wweVoice1HangupButton")).size() != 0) {
				System.out.println("done");

			} 

		} catch (Exception exception) {
			Assert.fail("exception in getCall");
		}
	}
	
	

	public void firstName() throws Exception {
		try{
			
			String firstName = driverER.findElement(By.id("wweInteraction1ContactViewInformationsGeneralFirstName0Field")).getText();
			if(firstName==null||firstName==""){
				throw new Exception();
			}else{
				System.out.println(firstName);
			}
			
		}catch(Exception exception){
			Assert.fail("exception in name search");
		}
	}

	

	public void tearDown() throws Exception {
		driverFA.close();
		driverER.close();
		GoogleHangout_FF googleHangout_NoVoice = new GoogleHangout_FF();
		googleHangout_NoVoice.tearDown();
	}

}
