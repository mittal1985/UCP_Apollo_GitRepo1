package com.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.test.*;
import com.test.htmlreport.Generic_Functions;
import com.test.htmlreport.TestBrowser;
import com.test.htmlreport.HtmlReport;


public class Login_Page  {
	public static  String SheetName = "InformationAtWorkCPC";

	public static String cardType,aamStatus,multiCardStatus,enrollStatus;
	public static String userNamE,passWorD,URL,rembrTextToBeVerified,urlTest;
	public static boolean postLoginVerify;
	public static class OpenApplication{
	//Load the Application URL
	public static boolean loadApplicationURL(WebDriver driver,HtmlReport currentSuit,String destination_Result,String sheetName,int i) throws Exception{
		boolean loginStatus = false;
		try
		{
		userNamE =  "dmysu1";
		System.out.println("userNamE------------"+userNamE);
		URL = "https://lpdcldwa00478.phx.aexp.com/GlobalmysuWeb/home.do";
		loginStatus = Generic_Functions.LoadApplication(URL, driver,LoginPage.getUserName_ID(),30,currentSuit,destination_Result,"Pre Login page");
		}
		catch(Exception e)
		{
			Generic_Functions.WriteFail(driver, currentSuit, destination_Result, "Verify whether url is loaded successfully", "URL should be loaded correctly", "URL is not loaded correctly");
		}
		return loginStatus;	
	}	
	
	}
	public static class UserName{
	//Verify the UserName field
 
	public static boolean verifyUserNameField(WebDriver driver,HtmlReport currentSuit,String destination_Result,String sheetName,int i) throws Exception{
				boolean userNameExists = false;
				userNamE =  "dmysu1";
		WebElement userName = Generic_Functions.RetrieveWebElementFromApplication(LoginPage.getUserName_ID(), LoginPage.getUserName_CSS(), LoginPage.getUserName_xPath(), driver);
		userNameExists = Generic_Functions.isDisplayed(userName, driver,currentSuit,destination_Result,"Username field");
		if(!userNameExists){			
		}else{
			Generic_Functions.EnterValues(userNamE,userName, driver,currentSuit,destination_Result,"Username field");
			Reporter.log("Username field is verified and value entered|");
			}
		return userNameExists;
		}
		}

	public static class PassWord{
	//Verify the Password field
	public static void verifyPasswordField(WebDriver driver,HtmlReport currentSuit,String destination_Result,String sheetName,int i) throws Exception{
		boolean passWordExists = false;
		passWorD = "P@$$W0rd";
		WebElement passWord = Generic_Functions.RetrieveWebElementFromApplication(LoginPage.getPassWord_ID(), LoginPage.getPassWord_CSS(), LoginPage.getPassWord_xPath(), driver);
		passWordExists = Generic_Functions.isDisplayed(passWord, driver,currentSuit,destination_Result,"Password field");
		if(!passWordExists){
			
		}else{
			Generic_Functions.EnterValues(passWorD,passWord, driver,currentSuit,destination_Result,"Password field");
			Reporter.log("Password field is verified and value entered|");
		}
	}
	}

	public static class SubmitButton{
	//Verify the Login Button
	public static boolean verifySubmitButton(WebDriver driver,HtmlReport currentSuit,String destination_Result) throws Exception{
		boolean submitButtonExists = false;
		postLoginVerify = false;
		WebElement submitButton = Generic_Functions.RetrieveWebElementFromApplication(LoginPage.getLoginBtn_ID(), LoginPage.getLoginBtn_CSS(), LoginPage.getLoginBtn_xPath(), driver);
		submitButtonExists = Generic_Functions.isDisplayed(submitButton, driver,currentSuit,destination_Result,"Login button");
		if(!submitButtonExists){
			return false;
		}else{
			Generic_Functions.Submit(submitButton, driver,currentSuit,destination_Result,"Login button");
			Generic_Functions.waitForLoad(driver,100000);
		//WebElement verify = Generic_Functions.RetrieveWebElementFromApplication(LoginPage.getConfirmTitle_ID(), LoginPage.getConfirmTitle_CSS(), LoginPage.getConfirmTitle_xPath(), driver);
		 //postLoginVerify=Generic_Functions.isDisplayed(verify, driver, currentSuit, destination_Result, "Post login Page ");
		 if(!postLoginVerify){
			 	Reporter.log("Logged in Failed |");
			 	return false;
			}else{
				Reporter.log("Logged in successfully |");
				return true;
			}

	}
	}
	
	}
	

	public static class LoginToApp{
		public static boolean loginWithUserNameAndPassword(WebDriver driver,HtmlReport currentSuit,String destination_Result,String sheetName, int row) throws Exception{		
			Login_Page.UserName.verifyUserNameField(driver,currentSuit,destination_Result,"Login",row);
			Login_Page.PassWord.verifyPasswordField(driver,currentSuit,destination_Result,"Login",row);
			boolean loggedStatus = Login_Page.SubmitButton.verifySubmitButton(driver,currentSuit,destination_Result);	
			return loggedStatus;
		}
	}	
	
	
	public static class LoginApp{
		public static boolean loginWithUserNameAndPassword(WebDriver driver,HtmlReport currentSuit,String destination_Result,String sheetName, int row) throws Exception{		
			Login_Page.UserName.verifyUserNameField(driver,currentSuit,destination_Result,"Login",row);
			Login_Page.PassWord.verifyPasswordField(driver,currentSuit,destination_Result,"Login",row);
			boolean loggedStatus = Login_Page.SubmitButton.verifySubmitButton(driver,currentSuit,destination_Result);	
			return loggedStatus;
		}
		
}
}

