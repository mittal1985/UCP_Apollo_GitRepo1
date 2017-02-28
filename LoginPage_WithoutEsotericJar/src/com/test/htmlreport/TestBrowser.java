package com.test.htmlreport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBrowser {
	public Date start;
	  public String browser_Specification;
	  public String run_Platform;
	  public String functionSuit;
	  public String folder_Screen;
	  public String browser_Target;
	  public String browser_Resolutn;
	  public String screen_Header;
	  public String folder;
	  public String app_Name_Final;
	  public String proj_Name_Final;
	  public String script_View;
	  public String status1;
	  public static String platform_Status;
	  public static String deviceID;
	public static HtmlReport currentSuit = new HtmlReport();
	  int x;
	  int y;
	 int stepCount; private Dimension size = null;
	  protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
	 protected static ThreadLocal<WebDriver> threadWebDriver = null;
	 
	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return the browser_Specification
	 */
	public String getBrowser_Specification() {
		return browser_Specification;
	}

	/**
	 * @param browser_Specification the browser_Specification to set
	 */
	public void setBrowser_Specification(String browser_Specification) {
		this.browser_Specification = browser_Specification;
	}

	/**
	 * @return the functionSuit
	 */
	public String getFunctionSuit() {
		return functionSuit;
	}

	/**
	 * @param functionSuit the functionSuit to set
	 */
	public void setFunctionSuit(String functionSuit) {
		this.functionSuit = functionSuit;
	}

	/**
	 * @return the folder_Screen
	 */
	public String getFolder_Screen() {
		return folder_Screen;
	}

	/**
	 * @param folder_Screen the folder_Screen to set
	 */
	public void setFolder_Screen(String folder_Screen) {
		this.folder_Screen = folder_Screen;
	}

	/**
	 * @return the browser_Target
	 */
	public String getBrowser_Target() {
		return browser_Target;
	}

	/**
	 * @param browser_Target the browser_Target to set
	 */
	public void setBrowser_Target(String browser_Target) {
		this.browser_Target = browser_Target;
	}

	/**
	 * @return the browser_Resolutn
	 */
	public String getBrowser_Resolutn() {
		return browser_Resolutn;
	}

	/**
	 * @param browser_Resolutn the browser_Resolutn to set
	 */
	public void setBrowser_Resolutn(String browser_Resolutn) {
		this.browser_Resolutn = browser_Resolutn;
	}

	/**
	 * @return the screen_Header
	 */
	public String getScreen_Header() {
		return screen_Header;
	}

	/**
	 * @param screen_Header the screen_Header to set
	 */
	public void setScreen_Header(String screen_Header) {
		this.screen_Header = screen_Header;
	}

	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}

	/**
	 * @return the app_Name_Final
	 */
	public String getApp_Name_Final() {
		return app_Name_Final;
	}

	/**
	 * @param app_Name_Final the app_Name_Final to set
	 */
	public void setApp_Name_Final(String app_Name_Final) {
		this.app_Name_Final = app_Name_Final;
	}

	/**
	 * @return the proj_Name_Final
	 */
	public String getProj_Name_Final() {
		return proj_Name_Final;
	}

	/**
	 * @param proj_Name_Final the proj_Name_Final to set
	 */
	public void setProj_Name_Final(String proj_Name_Final) {
		this.proj_Name_Final = proj_Name_Final;
	}

	/**
	 * @return the script_View
	 */
	public String getScript_View() {
		return script_View;
	}

	/**
	 * @param script_View the script_View to set
	 */
	public void setScript_View(String script_View) {
		this.script_View = script_View;
	}

	/**
	 * @return the status1
	 */
	public String getStatus1() {
		return status1;
	}

	/**
	 * @param status1 the status1 to set
	 */
	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	/**
	 * @return the platform_Status
	 */
	public static String getPlatform_Status() {
		return platform_Status;
	}

	/**
	 * @param platform_Status the platform_Status to set
	 */
	public static void setPlatform_Status(String platform_Status) {
		TestBrowser.platform_Status = platform_Status;
	}

	/**
	 * @return the deviceID
	 */
	public static String getDeviceID() {
		return deviceID;
	}

	/**
	 * @param deviceID the deviceID to set
	 */
	public static void setDeviceID(String deviceID) {
		TestBrowser.deviceID = deviceID;
	}

	/**
	 * @return the currentSuit
	 */
	public static HtmlReport getCurrentSuit() {
		return currentSuit;
	}

	/**
	 * @param currentSuit the currentSuit to set
	 */
	public static void setCurrentSuit(HtmlReport currentSuit) {
		TestBrowser.currentSuit = currentSuit;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the stepCount
	 */
	public int getStepCount() {
		return stepCount;
	}

	/**
	 * @param stepCount the stepCount to set
	 */
	public void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}

	/**
	 * @return the size
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Dimension size) {
		this.size = size;
	}

	/**
	 * @return the threadDriver
	 */
	public static ThreadLocal<RemoteWebDriver> getThreadDriver() {
		return threadDriver;
	}

	/**
	 * @param threadDriver the threadDriver to set
	 */
	public static void setThreadDriver(ThreadLocal<RemoteWebDriver> threadDriver) {
		TestBrowser.threadDriver = threadDriver;
	}

	/**
	 * @return the threadWebDriver
	 */
	public static ThreadLocal<WebDriver> getThreadWebDriver() {
		return threadWebDriver;
	}

	/**
	 * @param threadWebDriver the threadWebDriver to set
	 */
	public static void setThreadWebDriver(ThreadLocal<WebDriver> threadWebDriver) {
		TestBrowser.threadWebDriver = threadWebDriver;
	}

	/**
	 * @param run_Platform the run_Platform to set
	 */
	public void setRun_Platform(String run_Platform) {
		this.run_Platform = run_Platform;
	}

	@BeforeClass(alwaysRun=true)
	   @Parameters({"browser", "platform", "view", "suit", "Target", "Resolution"})
	  public void openBroswer(String browser, String platform, String view, String suit, String Target, String Resolution)
	     throws java.net.MalformedURLException
	  {
	     browser_Specification = browser;
	    run_Platform = platform;
	     script_View = view;
	    functionSuit = suit;
	     browser_Target = Target;
	     browser_Resolutn = Resolution;
	     if (browser_Target.equals("WebDriver")) {
	       browser_Target = "WebDriver";
	     }
	   }

	@BeforeClass(alwaysRun=true)
	   public void setUp()
	     throws IOException
	   {
	     DesiredCapabilities dc = new DesiredCapabilities();
	     threadWebDriver = new ThreadLocal();
	     threadDriver = new ThreadLocal();
	     if (run_Platform.equalsIgnoreCase("PC")) {
	       platform_Status = "PC";
	       if (browser_Specification.equalsIgnoreCase("Firefox")) {
	         System.out.println("Browser Selected : Firefox");
	         dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
	         
	         System.out.println("browser_Target is " + browser_Target);
	         if (browser_Target.equals("WebDriver")) {
	           threadWebDriver.set(new FirefoxDriver());
	         } else {
	           threadDriver.set(new RemoteWebDriver(new URL("http://" + browser_Target + "/wd/hub"), dc));
	         }
	       }
	      if (browser_Specification.equalsIgnoreCase("ie")) {
	         System.out.println("Browser Selected : ie");
	         dc.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
	       if (browser_Target.equals("WebDriver")) {
	           threadWebDriver.set(new InternetExplorerDriver());
	         } else {
	           threadDriver.set(new RemoteWebDriver(new URL("http://" + browser_Target + "/wd/hub"), dc));
	        }
	       }
	  if (browser_Specification.equalsIgnoreCase("chrome")) {
	         System.out.println("Browser Selected : chrome");
	         dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
	         if (browser_Target.equals("WebDriver")) {
	           threadWebDriver.set(new ChromeDriver());
	         } else {
	           threadDriver.set(new RemoteWebDriver(new URL("http://" + browser_Target + "/wd/hub"), dc));
	         }
	       }
	       
	       System.out.println("in PC " + functionSuit);
	       if (browser_Resolutn.equalsIgnoreCase("Default")) {
	         x = 1920;
	         y = 1080;
	       } else {
	        x = Integer.parseInt(browser_Resolutn.split("x")[0]);
	         y = Integer.parseInt(browser_Resolutn.split("x")[1]);
	      }
	      ManageWindowSize();
	    } 
	  }

	public void setTheTestForRun() {
	try {
	      try {
	        app_Name_Final = "American Express Test Applications";
	        proj_Name_Final = "QA Automation";
	      } catch (Exception newEx) {
	        app_Name_Final = "American Express Test Applications";
	        proj_Name_Final = "QA Automation";
	      }
	      start = new Date();
	       folder_Screen = (getRun_Platform() + "_" + getBrowser_Specification());
	     
	       Thread.sleep(50L);
	       screen_Header = currentSuit.writeReportHeader(proj_Name_Final, app_Name_Final, "Test_Release", folder_Screen, functionSuit);
	       folder = currentSuit.writeSubHeader("Test run result for " + functionSuit, screen_Header);
	     }
	    catch (Exception E) {
	    	E.printStackTrace();
	      calculateRunDuration(getBrowser_Specification(), getRun_Platform(), functionSuit, start, new Date());
	    }
	   }
	   
	   public String getRun_Platform()
	   {
	    return run_Platform;
	  }
	  
	  
	  public static WebDriver getDriver()
	   {
	     try
	     {
	       if (threadDriver != null) {
	        return (WebDriver)threadWebDriver.get();
	      }
	       return (WebDriver)threadDriver.get();
	     } catch (Exception e) {}
	     return (WebDriver)threadWebDriver.get();
	   } 
	   
	   public WebDriver ManageWindowSize()
	   {
	     size = new Dimension(x, y);
	     getDriver().manage().window().setSize(size);
	     return getDriver();
	   }
	   
	   protected String calculateRunDuration(String browser, String platform, String function, Date start, Date end)
	   {
	    String duration = "";
	    String time1 = start.toString().split(" ")[3];
	     String time2 = end.toString().split(" ")[3];
	     int sec1 = Integer.parseInt(time1.split(":")[2]);
	     int min1 = Integer.parseInt(time1.split(":")[1]);
	     int sec2 = Integer.parseInt(time2.split(":")[2]);
	     int min2 = Integer.parseInt(time2.split(":")[1]);
	    int secDuration = 60 - sec1 + sec2;
	     int minDuration = min2 - (min1 + 1);
	     if (secDuration < 0) {
	       secDuration *= -1;
	     } else if (secDuration > 60) {
	       minDuration += 1;
	      secDuration -= 60;
	     }
	     if (minDuration == -1) {
	       duration = " " + secDuration + " Seconds";
	     } else if (minDuration < 0) {
	       minDuration *= -1;
	    }
	     else {
	       duration = minDuration + " Min " + secDuration + " Seconds";
	    }
	     System.out.println("Duration " + browser + " is" + duration + " : " + platform + " : " + function);
	     
	   /*  TestUI.setPlatform_result_list(platform);
	     TestUI.setDuration_result_list(duration);
	     TestUI.setSuit_result_list(function);
	     TestUI.setBrowser_result_list(browser);*/
	     return duration;
	   }
	 
	//  @AfterClass
	/*   public void print()
	   {
	     for (int i = 0; i < TestUI.platform_result_list.size(); i++) {
	       System.out.println("Get Browser: " + (String)TestUI.getBrowser_result_list().get(i) + "  getDuration_result_list : " + (String)TestUI.getDuration_result_list().get(i));

	      System.out.println("Get platform: " + (String)TestUI.getPlatform_result_list().get(i) + "  getDuration_result_list : " + (String)TestUI.getSuit_result_list().get(i));
	      System.out.println();
	     }
	   }
	}*/
}
