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

import com.apollo.googlehangout.GoogleHangout_FF;


public class QCInbound_CallBack {

	WebDriver driver = null;
	public static String folder;
	public static String screen_Header;
	public static String app_Name_Final;
	public static String proj_Name_Final;
	public String phoneNumber = "4807548519";
	public GoogleHangout_FF googleHangout = null;

	public void setUp() throws Exception {
		FirefoxProfile customProfile = new FirefoxProfile();
		customProfile.setPreference("dom.disable_beforeunload", true);
		driver = new FirefoxDriver(customProfile);
		driver.get("http://genesyswwe.qaapollogrp.edu:8080/ui/ad/v1/index.html");

		driver.manage().window().maximize();
		clickUserName();
	}

	public void clickUserName() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

			WebElement webElement = (new WebDriverWait(driver, 2000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginUserNameField"))));

			if (webElement != null) {

				webElement.sendKeys("ucp_acc_wwe2");
				// JavascriptExecutor executor = (JavascriptExecutor)driver;
				// executor.executeScript("arguments[0].click();", webElement);
			} else {
				System.out.println("element is null");
			}
			clickPassword();
		} catch (Exception exception) {
			Assert.fail("exception in clickUserName");
		}
	}

	public void clickPassword() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

			WebElement webElement = (new WebDriverWait(driver, 2000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginPasswordField"))));

			if (webElement != null) {

				webElement.sendKeys("ucp_acc_wwe2");
			} else {

				System.out.println("element is null");
			}
			clickSubmit();
		} catch (Exception exception) {
			Assert.fail("exception in clickPassword");
		}
	}

	public void clickSubmit() throws Exception {
		try {

			WebElement webElement = (new WebDriverWait(driver, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweLoginSignInButton"))));
			if (webElement != null) {

				webElement.click();
			} else {

				System.out.println("element is null");
			}

			getAgentReady();
		} catch (Exception exception) {
			Assert.fail("exception in clickSubmit");
		}
	}

	public void getAgentReady() throws Exception {
		try {

			int count = 0;
			WebElement webElement = (new WebDriverWait(driver, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("agent-desktop-container-title"))));
			while (webElement == null) {
				System.out.println("in getagentReady , webelem is null");
				count = count++;
				driver.manage().timeouts()
						.implicitlyWait(100, TimeUnit.SECONDS);
			}

			/* drop down click working */
			System.out.println("going to click dropdown");
			driver.findElement(By.id("wweAgentSwitchStateButton")).click();
			System.out.println("after click dropdown");
			WebElement webElement2 = driver.findElement(By
					.xpath("//span[@class='presence-text']"));
			// click on Ready using xpath , at present xpath not there in my
			// system
			// i think once clicked ready button its in Ready status for quite
			// long

			if (webElement2 != null) {
				webElement2.click();

			} else {

				System.out.println("Agent Ready Status dropdown is null");
			}

			googleHangout = new GoogleHangout_FF();
			googleHangout.setUp(phoneNumber);

			clickCaseInfo();

		} catch (Exception exception) {
			Assert.fail("exception in getAgentReady");
		}
	}

	public void clickCaseInfo() throws Exception {
		System.out.println("in clickCaseInfo");
		try {
			WebElement webElement = (new WebDriverWait(driver, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("wweCaseData1Label"))));
			System.out.println("CaseInfo webElement--------->" + webElement);
			if (webElement != null) {
				System.out.println("webelement is not null");
				webElement.click();

			}

			webElement.click();
			clickCallType();
		} catch (Exception exception) {
			Assert.fail("exception in clickCaseInfo");
		}
	}

	public void clickCallType() throws Exception {
		System.out.println("in clickCallType");
		try {
			WebElement webElement = (new WebDriverWait(driver, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.xpath("//*[@id='wweCaseData1callDescriptionValue']/div[1]/div[1]"))));

			System.out.println("Call Type is----->" + webElement.getText() + ""
					+ webElement.getClass());

			if (webElement.getText().equalsIgnoreCase("Inbound Callback")) {
				System.out.println("getText matched ---");
				// webElement.click();
				// System.out.println("after click");

			} else {

				System.out.println("getText not matched ---");
				Assert.fail();
			}

			checkContactTab();
		} catch (Exception exception) {
			Assert.fail("exception in clickCallType");
		}
	}

	public void checkContactTab() throws Exception {
		try {
			System.out.println("in checkContactTab");
			WebElement webElement = (new WebDriverWait(driver, 100))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("CaseRightTabs1Item0"))));
			boolean bool = webElement.isDisplayed();
			System.out.println("" + bool);

			if (webElement.isDisplayed()) {
				System.out.println("clicked on contact tab Header verified");
				// webElement.click();
			} else {
				System.out.println("contact tab not available");
				Assert.fail();
			}
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			checkContactInformation();
		} catch (Exception exception) {
			Assert.fail("exception in checkContactTab");
		}
	}

	public void checkContactInformation() throws Exception {
		try {
			System.out.println("in checkContactInformation");

			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			checkHistoryTab();
		} catch (Exception exception) {
			Assert.fail("exception in checkContactInformation");
		}
	}

	public void checkHistoryTab() throws Exception {
		try {
			System.out.println("in checkHistoryTab");
			WebElement webElement = (new WebDriverWait(driver, 100))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("TabswweInteraction1ContactViewItem1"))));
			boolean bool = webElement.isDisplayed();
			System.out.println("" + bool);

			if (webElement.isDisplayed()) {
				System.out
						.println("clicked on contact history tab is verified");
				webElement.click();
			} else {
				System.out.println("contact history tab not available");
				Assert.fail();
			}
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			clickAgentScritping();
		} catch (Exception exception) {
			Assert.fail("exception in checkHistoryTab");
		}
	}

	public void clickAgentScritping() throws Exception {
		try {
			System.out.println("in clickagentscripting");
			WebElement webElement = (new WebDriverWait(driver, 5000))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("CaseRightTabs1ItemExtUCPAgentScripting0"))));
			webElement.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			System.out.println("going out of clickagentscripting");
			clickHungups();

		} catch (Exception exception) {
			Assert.fail("exception in clickAgentScritping");
		}
	}

	public void clickHungups() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
			/* switch to iframe of IRN */
			driver.switchTo()
					.frame(driver.findElement(By
							.className("wwe-web-extension-iframe")));

			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,400)");
			Thread.sleep(4000);
			System.out.println("going to click after wait");
			WebDriverWait wait = new WebDriverWait(driver, 500);
			wait.until(ExpectedConditions.elementToBeClickable(driver
					.findElement((By.id("hungup")))));
			driver.findElement((By.id("hungup"))).click();
			clickOnradioButton();

		} catch (Exception exception) {
			Assert.fail("exception in clickHungups");
		}

	}

	public void clickOnradioButton() throws Exception {
		try {
			System.out.println("in radio button");

			WebElement webElement = (new WebDriverWait(driver, 300))
					.until(ExpectedConditions.elementToBeClickable((By
							.id("firstParty3"))));
			boolean bool = webElement.isDisplayed();
			System.out.println("" + bool);

			if (webElement.isDisplayed()) {
				System.out.println("going to click on radio button");
				webElement.click();
			} else {
				System.out.println("radio button not available");
				Assert.fail();
			}
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			clickOnSelectHungUp();
		} catch (Exception exception) {
			Assert.fail("exception in clickOnradioButton");
			;
		}
	}

	public void clickOnSelectHungUp() throws Exception {
		// Click on Select dropdown

		try {

			List<WebElement> webElements = driver.findElements(By
					.cssSelector("a[href='#']"));
			for (WebElement webElement2 : webElements) {
				// System.out.println(webElement2.getText());
				if (webElement2.getText().equalsIgnoreCase("Hung Up")) {
					webElement2.click();
				}
			}
			clickOnEndCallTab();

		} catch (Exception exception) {
			Assert.fail("exception in clickOnSelectHungUp");
			;
		}
	}

	public void clickOnEndCallTab() {
		try {
			System.out.println("in clickOnEndCallTab");
			driver.switchTo().defaultContent();
			System.out.println("after default content");
			WebElement element = driver.findElement(By
					.id("wweVoice1HangupButton"));
			element.click();
			clickOnEndCall();
		} catch (Exception exception) {
			Assert.fail("exception in clickOnEndCallTab");
		}
	}

	public void clickOnEndCall() throws Exception {
		try {
			System.out.println("in clickOnEndCall");
			/* switch to iframe of IRN */
			driver.switchTo()
					.frame(driver.findElement(By
							.className("wwe-web-extension-iframe")));
			WebElement element = driver.findElement(By.id("endCallButton"));
			if (element.isDisplayed()) {
				System.out.println("element dispalyed");
			}
			element.click();
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			clickDone();
		} catch (Exception exception) {
			Assert.fail("exception in clickOnEndCall");
		}
	}

	public void clickDone() throws Exception {
		try {
			System.out.println("in clickDone");
			/* switch to iframe of IRN */
			driver.switchTo().defaultContent();
			driver.findElement(By.id("wweBundle1CloseButton")).click();
			tearDown();
		} catch (Exception exception) {
			Assert.fail("exception in clickDone");
		}
	}

	public void tearDown() throws Exception {
		googleHangout.tearDown();
		driver.quit();
	}

}
