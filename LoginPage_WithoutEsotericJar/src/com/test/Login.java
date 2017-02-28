package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.test.*;
import com.test.htmlreport.Generic_Functions;
import com.test.htmlreport.TestBrowser;

public class Login extends TestBrowser {
	private WebDriver driver;
	public static  String SheetName = "Login";
	public static boolean validationRequired = false;
	public static boolean validationRequiredAssert = false;
	public static long test_step_unique_id;		
	public static String valid = "";
	
		/*****************************************************************************************
		 * Description			: Validation of MySetUps Mexico
		 * CREATED BY  			: Gaurav Mittal
		 * CREATED DATE 		: 05/17/2016
		 * validations COVERED
		 * 1. Launch the Application
		 * 2. Login to the Application with Username & Password
		 * 3. Post Login Verification
		 	 
		 *****************************************************************************************/	
		
	
	@Test(groups ={"launchApp"},enabled = true,priority = 0)
		public void launchingTheApplication() throws Exception {
			//driver = getDriver();
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("disable-popup-blocking");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 driver = new ChromeDriver(capabilities);*/
			driver = new FirefoxDriver();
			setTheTestForRun();
		}
		
		
		@Test(groups ="Login",enabled = true,priority = 1)
		  public void loginToApplication() throws Exception {	
			currentSuit.writeSubHeaderForScripts("Logging into the Application", folder);			
			boolean login = Login_Page.OpenApplication.loadApplicationURL(driver,currentSuit,folder,SheetName,1);
			if(!login){	
			Generic_Functions.WriteFail(driver, currentSuit, folder, "Verify the Browser launched Status", "Browser should be launched successfully", "Failed to launch successfully");
			driver.close();
			driver.quit();
			validationRequired = Login_Page.LoginToApp.loginWithUserNameAndPassword(driver,currentSuit,folder,SheetName,1);
			}else{
				if(validationRequired){
				AssertJUnit.assertEquals(validationRequired, true);
				Reporter.log("Application launched Successfully |");
				
			}	
		}
		
		}

}
