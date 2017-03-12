package edu.apollogrp.tests.InternalTransfer;

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


public class InternalTransfer_ER_FA {
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

	public void clickUserName() throws Exception {
		try {
			driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

			WebElement webElement = (new WebDriverWait(driverFA, 2000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginUserNameField"))));

			if (webElement != null) {

				// webElement.sendKeys("ucp_acc1");

				webElement.sendKeys("ucp_acc_wwe2");

			} else {
				System.out.println("element is null");

			}
		} catch (Exception exception) {
			Assert.fail("exception in clickUserName");
		}
	}

	public void clickPassword() throws Exception {
		try {
			driverFA.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

			WebElement webElement = (new WebDriverWait(driverFA, 2000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginPasswordField"))));

			// driverFA.manage().timeouts().implicitlyWait(2000,
			// TimeUnit.SECONDS);
			if (webElement != null) {

				// webElement.sendKeys("ucp_acc1");

				webElement.sendKeys("ucp_acc_wwe2");

			} else {
				System.out.println("element is null");

			}
		} catch (Exception exception) {
			Assert.fail("exception in clickPassword");
		}
	}

	public void clickSubmit() throws Exception {
		try {
			// Alert alert = new Alert();

			WebElement webElement = (new WebDriverWait(driverFA, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginSignInButton"))));

			webElement.click();

			/* drop down click working */
			driverFA.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			System.out.println("going to click dropdown for FA");
			driverFA.findElement(By.id("wweAgentSwitchStateButton")).click();
			driverFA.findElement(By.xpath("//span[@class='presence-text']"))
					.click();
			System.out.println("FA should be now in ready status");

		} catch (Exception exception) {
			Assert.fail("exception in clickSubmit");
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
			// click on Ready using xpath , at present xpath not there in my
			// system
			// i think once clicked ready button its in Ready status for quite
			// long

			// after receiving call
			if (driverER.findElements(By.id("wweVoice1HangupButton")).size() != 0) {
				System.out.println("done");

			} 

		} catch (Exception exception) {
			Assert.fail("exception in getCall");
		}
	}

	/* to disconnect the call */
	// driverFA.findElement(By.id("wweVoice1HangupButton")).click();

	public void clickCaseInfo() throws Exception {
		try {
			WebElement webElement = (new WebDriverWait(driverER, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweCaseData1Label"))));

			webElement.click();

			webElement.click();
			driverFA.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			// System.out.println("going out of clickagentscripting");
		} catch (Exception exception) {
			Assert.fail("exception in clickCaseInfo");
		}
	}

	public void clickConsultButton() throws Exception {
		try {
			driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			driverER.switchTo().defaultContent();
			System.out.println("in clickConsultButton");
			WebElement webelement = driverER.findElement(By
					.id("wweBundle1ConsultButton"));
			if (webelement != null) {
			} else {

			}
			webelement.click();

		} catch (Exception exception) {
			Assert.fail("exception in clickConsultButton");
		}

	}

	public void clickSearchMyFavButton() throws Exception {
		try {
			driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			// driverFA.switchTo().defaultContent();
			System.out.println("in clickSearchMyFavButton");
			WebElement webelement = driverER.findElement(By
					.id("wweTeamCommunicatorSearchFavoritesButton"));
			if (webelement != null) {
			}
			webelement.click();

		} catch (Exception exception) {
			Assert.fail("exception in clickSearchMyFavButton");
		}

	}

	public void clickFinancequaltransfer() throws Exception {
		try {
			driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			// driverFA.switchTo().defaultContent();
			System.out.println("in clickFinancequaltransfer");
			JavascriptExecutor jse = (JavascriptExecutor) driverER;
			jse.executeScript("window.scrollBy(0,250)", "");

			WebElement webelement = driverER.findElement(By
					.id("wweTeamCommunicatorItem13PartyNameTxt"));

			if (webelement.getAttribute("title").equalsIgnoreCase(
					"Finance Transfer")) {
				System.out.println("title is matched going to click on it");
				WebElement webelement1 = driverER.findElement(By
						.id("wweTeamCommunicatorItem13DefaultActionButton"));

				webelement1.click();
			} else {
				System.out.println("check if scroll down to FinanceTransfer");
				throw new Exception();
			}

		} catch (Exception exception) {
			Assert.fail("exception in clickFinancequaltransfer");
		}

	}

	public void clickInstantCallTransfer() throws Exception {
		try {
			driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			// driverFA.switchTo().defaultContent();
			System.out.println("in clickInstantCallTransfer");
			WebElement webelement = driverER.findElement(By
					.id("wweVoice1CompleteConferenceButton"));
			Thread.sleep(200);
			webelement.click();

		} catch (Exception exception) {
			Assert.fail("exception in clickInstantCallTransfer");
		}

	}

	public void clickInstantCallConference() throws Exception {
		try {
			driverER.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			// driverFA.switchTo().defaultContent();
			System.out.println("in clickInstantCallTransfer");
			WebElement webelement = driverER.findElement(By
					.id("wweTeamCommunicatorActiveItem0DefaultActionButton"));
			Thread.sleep(200);
			webelement.click();

		} catch (Exception exception) {
			Assert.fail("exception in clickInstantCallConference");
		}

	}

	public void endER_Call() throws Exception {
		try {

			driverER.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement webElement1 = driverER.findElement(By
					.id("wweVoice1RetrieveButton"));

			System.out.println("going to click end button on ACC side");

		} catch (Exception exception) {
			Assert.fail("exception in endER_Call");
		}
	}

	public void endFACall() throws Exception {
		System.out.println("going to click end button on FA side");
		int count = 0;

		try {
			Thread.sleep(300);
			WebElement webElement = (new WebDriverWait(driverFA, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweVoice1HangupButton"))));
			while (webElement == null) {
				count = count++;
				driverFA.manage().timeouts()
						.implicitlyWait(100, TimeUnit.SECONDS);
			}
			System.out.println("going to click end button on FA side");

			if (webElement != null) {
				// Generic_Functions.WritePass(driverFA, currentSuit, folder,
				// "Verify whether ER has received the call",
				// "ER should have received the call correctly",
				// "ER has received the call correctly");
				webElement.click();
			}
		} catch (Exception exception) {
			Assert.fail("exception in endFACall");
		}
	}

	public void tearDown() throws Exception {
		driverFA.close();
		driverER.close();
		GoogleHangout_FF googleHangout_NoVoice = new GoogleHangout_FF();
		googleHangout_NoVoice.tearDown();
	}

}
