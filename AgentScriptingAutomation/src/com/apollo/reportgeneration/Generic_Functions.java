package com.apollo.reportgeneration;

	 
	 import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
	 
	 
	 
	 
	 
	 
	 public class Generic_Functions
	 {
	   public static long test_step_unique_id;
	   public static WebElement finalElement;
	   public static List<WebElement> finalElements;
	   public static String[][] data1 = (String[][])null;
	   public static String[][] data2 = (String[][])null;
	   
	 
	 
	 
	   public static boolean ElementLocatorVerification(By by, WebDriver driver)
	   {
	     try
	     {
	      if (driver.findElement(by) != null) {
	         return true;
	       }
	       
	       return false;
	     }
	     catch (Exception e) {}
	     return false;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	   public static WebElement RetrieveWebElementFromApplication(String locateID, String locateCSS, String locateXPath, WebDriver driver)
	   {
	    finalElement = null;
	     if (ElementLocatorVerification(By.id(locateID), driver)) {
	      finalElement = driver.findElement(By.id(locateID));
	     } else if (ElementLocatorVerification(By.cssSelector(locateCSS), driver)) {
	       finalElement = driver.findElement(By.cssSelector(locateCSS));
	    } else if (ElementLocatorVerification(By.xpath(locateXPath), driver)) {
	      finalElement = driver.findElement(By.xpath(locateXPath));
	     }
	     return finalElement;
	   }
	   
	 
	 
	 
	 
	 
	 
	   public static List<WebElement> RetrieveWebElementsFromApplication(String locateID, String locateCSS, String locateXPath, WebDriver driver)
	   {
	     if (ElementLocatorVerification(By.id(locateID), driver)) {
	       finalElements = driver.findElements(By.id(locateID));
	     } else if (ElementLocatorVerification(By.cssSelector(locateCSS), driver)) {
	       finalElements = driver.findElements(By.cssSelector(locateCSS));
	    } else if (ElementLocatorVerification(By.xpath(locateXPath), driver)) {
	       finalElements = driver.findElements(By.xpath(locateXPath));
	     }
	    return finalElements;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean LoadApplication(String URL, WebDriver driver, String verifyElement, int timeOut, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     boolean loginStatus = false;
	     driver.get(URL);
	     waitForLoad(driver, timeOut);
	     loginStatus = waitUntilConditionPresent(driver, verifyElement, timeOut);
	    if (!loginStatus) {
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       currentsuit.writeReportFail("Validate whether " + description + " is displayed", description + " should be displayed", description + " is not displayed", test_step_unique_id, folder);
	     } else {
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       currentsuit.writeReportPass("Validate whether " + description + " is displayed", description + " should be displayed", description + " is displayed", test_step_unique_id, folder);
	     }
	     return loginStatus;
	   }
	   
	 
	 
	 
	   public static void waitwhenWheel(WebDriver driver)
	     throws InterruptedException
	   {
	     try
	     {
	      WebElement loadingWheel = driver.findElement(By.cssSelector("[id='_progressOverlayWindow']"));
	      waitForJavaScriptLoad(loadingWheel, 30, driver);
	     } catch (Exception e) {
	       Thread.sleep(30000L);
	     }
	   }
	   
	 
	 
	 
	   public static void waitForLoad(WebDriver driver, int time)
	   {
	    boolean status = false;
	     Calendar startTime = Calendar.getInstance();
	     Calendar endTime = Calendar.getInstance();
	     
	     ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>()
	     {
	       public Boolean apply(WebDriver driver) {
	         return Boolean.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState", new Object[0]).equals("complete"));
	       }
	     };
	    WebDriverWait wait = new WebDriverWait(driver, time);
	     long timeTaken;
	     do {
	       try {
	         wait.until(pageLoadCondition);
	        if (((Boolean)wait.until(pageLoadCondition)).booleanValue() == true) {
	           status = true;
	         } else {
	          status = false;
	         }
	       } catch (NoSuchElementException e) {
	         status = false;
	       }
	      endTime = Calendar.getInstance();
	       timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000L;
	       if (timeTaken > time) {
	         timeTaken -= time;
	         startTime = Calendar.getInstance();
	       }
	     } while ((!status) && (timeTaken <= time));
	   }
	   
	 
	 
	 
	 
	   public static void waitForSpinnerLoad(WebElement locater, int timeOut, WebDriver driver)
	     throws InterruptedException
	   {
	     boolean status = false;
	     Calendar startTime = Calendar.getInstance();
	     Calendar endTime = Calendar.getInstance();
	     long timeTaken;
	     do {
	       try {
	         if (!locater.getAttribute("id").equals("appendSpinner")) {
	          status = true;
	         } else {
	           status = false;
	         }
	       } catch (NoSuchElementException e) {
	        status = false;
	       }
	      endTime = Calendar.getInstance();
	       timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000L;
	 
	     }
	     while ((!status) && (timeTaken <= timeOut));
	    System.out.println("Time taken is " + timeTaken);
	     if (timeTaken > timeOut) {
	       System.out.println("timeTaken > timeOut  case");
	      Thread.sleep(30000L);
	     }
	   }
	   
	 
	 
	 
	 
	 
	   public static boolean WaitUntilProgressBar(String ID, WebDriver driver)
	     throws InterruptedException
	   {
	    boolean status = false;
	     boolean WaitStatus1 = true;
	     while (WaitStatus1)
	     {
	       try
	       {
	         String GetText = "return arguments[0].innerText";
	         String Actual = "";
	         try
	         {
	          Actual = driver.findElement(By.id(ID)).getText();
	         }
	         catch (WebDriverException e1)
	         {
	           Actual = (String)((JavascriptExecutor)driver).executeScript(GetText, new Object[] { driver.findElement(By.id(ID)) });
	         }
	         System.out.println("Color " + driver.findElement(By.id(ID)).getCssValue("background-color"));
	        System.out.println("Actual1" + Actual);
	         if (Actual.equals("Updating Results ...")) {
	           Thread.sleep(100L);
	          continue;
	         }
	         System.out.println("done");
	         status = true;
	        WaitStatus1 = false;
	       } catch (Exception e) {
	         Thread.sleep(100L);  System.out.println(e);}
	     }
	    return status;
	   }
	   
	 
	 
	 
	 
	 
	   public static boolean waitUntilID(String ID, WebDriver driver)
	     throws InterruptedException
	   {
	     boolean status = false;
	     boolean WaitStatus1 = true;
	    while (WaitStatus1)
	     {
	       try
	       {
	        String GetText = "return arguments[0].innerText";
	        String Actual = (String)((JavascriptExecutor)driver).executeScript(GetText, new Object[] { driver.findElement(By.id(ID)) });
	         System.out.println("Actual1" + Actual);
	        if (Actual.equals("null")) {
	         Thread.sleep(100L);
	         continue;
	         }
	        System.out.println("done");
	        status = true;
	        WaitStatus1 = false;
	       } catch (Exception e) {}
	     Thread.sleep(100L);
	     }
	    return status;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean notDisplayedElement(String element, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     boolean returnStatus = false;
	     if (!description.equals("")) {
	       try {
	        boolean returnStatusNew = false;
	        if ((driver.findElement(By.id("element")).isDisplayed()) || (driver.findElement(By.cssSelector("element")).isDisplayed()) || (driver.findElement(By.xpath("element")).isDisplayed())) {
	          returnStatusNew = true;
	           test_step_unique_id = currentsuit.takeScreenshot(driver, folder);           currentsuit.writeReportFail("Validate whether " + description + " is not displayed in the Application", description + " should not be displayed in the page", description + " is displayed in the page", test_step_unique_id, folder);
	         }
	         returnStatus = returnStatusNew;
	       } catch (Exception e) {
	         test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	         currentsuit.writeReportPass("Validate whether " + description + " is not displayed in the Application", description + " should not be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	       }
	     }
	     return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	 
	   public static String returnUniqueProperty(String id, String css, String x_path)
	   {
	     try
	     {
	       if (id != "")
	       {
	         return id;
	       }
	      if ((id == "") && (css != ""))
	       {
	        return css;
	       }
	       
	      return x_path;
	     }
	     catch (Exception e) {
	       System.out.println("Exception in finding unique property"); }
	     return null;
	   }
	   
	 
	 
	 
	 
	 
	 
	   public static boolean waitUntilXpath(String XPATH, WebDriver driver)
	     throws InterruptedException
	   {
	    boolean status = false;
	     boolean WaitStatus1 = true;
	    while (WaitStatus1)
	     {
	       try
	       {
	         String GetText1 = "return arguments[0].innerText";
	         String Actual1 = (String)((JavascriptExecutor)driver).executeScript(GetText1, new Object[] { driver.findElement(By.xpath(XPATH)) });
	         System.out.println("Actual1" + Actual1);
	       if (Actual1.equals("null")) {
	          Thread.sleep(100L);
	          continue;
	         }
	        System.out.println("done");
	        status = true;
	         WaitStatus1 = false;
	       } catch (Exception e) {}
	      Thread.sleep(100L);
	     }
	     return status;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	   public static boolean isPropertyPresent(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder)
	     throws Exception
	   {
	    boolean returnStatus = false;
	    if (locator_Property != null)
	     {
	 
	       returnStatus = true;
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	     }
	     else
	     {
	       returnStatus = false;
	      test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	     }
	    return returnStatus;
	   }
	   
	 
	 
	 
	 
	   public static void waitForGraphLoad(WebElement locater, int timeOut, WebDriver driver)
	     throws InterruptedException
	   {
	     boolean status = false;
	     Calendar startTime = Calendar.getInstance();
	     Calendar endTime = Calendar.getInstance();
	     long timeTaken;
	     do {
	       try {
	        if (!locater.getAttribute("style").equals("opacity: 0.25;")) {
	           status = true;
	         } else {
	          status = false;
	         }
	       } catch (NoSuchElementException e) {
	        status = false;
	       }
	      endTime = Calendar.getInstance();
	      timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000L;
	 
	     }
	    while ((!status) && (timeTaken <= timeOut));
	    System.out.println("Time taken is " + timeTaken);
	    if (timeTaken > timeOut) {
	      System.out.println("timeTaken > timeOut  case");
	       Thread.sleep(30000L);
	     }
	   }
	   
	 
	 
	 
	 
	 
	   public static long waitForJavaScriptLoad(WebElement locater, int timeOut, WebDriver driver)
	     throws InterruptedException
	   {
	     boolean status = false;
	    Calendar startTime = Calendar.getInstance();
	     Calendar endTime = Calendar.getInstance();
	     long timeTaken;
	     do {
	       try {
	         if (locater.getText().equals("")) {
	           status = true;
	         } else {
	           status = false;
	         }
	       } catch (NoSuchElementException e) {
	         status = false;
	       }
	       endTime = Calendar.getInstance();
	      timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000L;
	 
	     }
	    while ((!status) && (timeTaken <= timeOut));
	     System.out.println("Time taken for Loading is " + timeTaken);
	     if (timeTaken > timeOut) {
	      System.out.println("timeTaken > timeOut  case");
	      Thread.sleep(30000L);
	     }
	     return timeTaken;
	   }
	   
	 
	 
	 
	   public static void waitUnitlrocDetailsLoad(int timeOut, WebDriver driver)
	     throws InterruptedException
	   {
	    boolean status = false;
	     Calendar startTime = Calendar.getInstance();
	     Calendar endTime = Calendar.getInstance();
	     long timeTaken;
	     do {
	       try {
	         if (!driver.findElement(By.tagName("title")).equals("loading")) {
	           status = true;
	         } else {
	           status = false;
	         }
	       } catch (NoSuchElementException e) {
	         status = false;
	       }
	      endTime = Calendar.getInstance();
	      timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000L;
	 
	     }
	    while ((!status) && (timeTaken <= timeOut));
	    System.out.println("Time taken for Tags got Loading is " + timeTaken);
	     if (timeTaken > timeOut) {
	       System.out.println("timeTaken > timeOut  case");
	      Thread.sleep(30000L);
	     }
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean isPropertyPresent(By byId, By byCss, By xPath, WebDriver driver, HtmlReport currentsuit, String folder)
	     throws Exception
	   {
	     boolean returnStatus = false;
	     if ((driver.findElements(byId).size() != 0) || (driver.findElements(byCss).size() != 0) || (driver.findElements(xPath).size() != 0))
	     {
	 
	       returnStatus = true;
	      test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	     }
	     else
	     {
	      returnStatus = false;
	      test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	     }
	     
	     return returnStatus;
	   }
	   
	 
	   public static boolean isDisplayed(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     boolean returnStatus = false;
	     if ((!description.equals("")) && (locator_Property != null)) {
	       try {
	        boolean returnStatusNew = false;
	         if (locator_Property.isDisplayed()) {
	          returnStatusNew = true;
	          JavascriptExecutor js = (JavascriptExecutor)driver;
	          js.executeScript("arguments[0].setAttribute('style', arguments[1]);", new Object[] { locator_Property, "border: 3px solid red;" });
	           test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	          js.executeScript("arguments[0].setAttribute('style', arguments[1]);", new Object[] { locator_Property, "border:'';" });
	           currentsuit.writeReportPass("Validate whether " + description + " is displayed in the Application", description + " should be displayed in the page", description + " is displayed in the page", test_step_unique_id, folder);
	         }
	        returnStatus = returnStatusNew;
	       } catch (Exception e) {
	        currentsuit.appendToFile(e);
	        test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	         currentsuit.writeReportFail("Validate whether " + description + " is displayed in the Application", description + " should be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	       }
	     } else {
	      test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	      currentsuit.writeReportFail("Validate whether " + description + " is displayed in the Application", description + " should be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	     }
	     return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean notDisplayed(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     boolean returnStatus = false;
	     if ((!description.equals("")) && (locator_Property != null)) {
	       try {
	        boolean returnStatusNew = false;
	         if (locator_Property.isDisplayed()) {
	          returnStatusNew = true;
	          test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	          currentsuit.writeReportFail("Validate whether " + description + " is not displayed in the Application", description + " should not be displayed in the page", description + " is displayed in the page", test_step_unique_id, folder);
	          returnStatus = returnStatusNew;
	         } else {
	           test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	           currentsuit.writeReportPass("Validate whether " + description + " is not displayed in the Application", description + " should not be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	         }
	       } catch (Exception e) {
	        currentsuit.appendToFile(e);
	         test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	         currentsuit.writeReportPass("Validate whether " + description + " is not displayed in the Application", description + " should not be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	       }
	     } else {
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       currentsuit.writeReportPass("Validate whether " + description + " is not displayed in the Application", description + " should not be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	     }
	     return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	   public static void notDisplayedWriteFail(WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	    test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	     currentsuit.writeReportPass("Validate whether " + description + " is not displayed in the Application", description + " should not be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	   public static void WritePass(WebDriver driver, HtmlReport currentsuit, String folder, String testCaseDescription, String expectedResult, String actualResult)
	     throws Exception
	   {
	    test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	  //  System.out.println("after test_step_unique_id"+test_step_unique_id);
	    currentsuit.writeReportPass(testCaseDescription, expectedResult, actualResult, test_step_unique_id, folder);
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	   public static void WriteFail(WebDriver driver, HtmlReport currentsuit, String folder, String testCaseDescription, String expectedResult, String actualResult)
	     throws Exception
	   {
	     test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	     currentsuit.writeReportFail(testCaseDescription, expectedResult, actualResult, test_step_unique_id, folder);
	   }
	   
	 
	 
	
	   
	   public static boolean EnterValues(String enterDetails, WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     boolean returnStatus = false;
	     try {
	       boolean returnStatusNew = false;
	       if (locator_Property.isDisplayed()) {
	         returnStatus = true;
	         locator_Property.clear();
	         locator_Property.sendKeys(new CharSequence[] { enterDetails });
	       }
	      returnStatus = returnStatusNew;
	     } catch (Exception e) {
	      currentsuit.appendToFile(e);
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       currentsuit.writeReportFail("Validate whether " + description + " is displayed in the Application", description + " should be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	     }
	    return returnStatus;
	   }
	   
	 
	   public static boolean Submit(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	    boolean returnStatus = false;
	     try {
	       boolean returnStatusNew = false;
	      if (locator_Property.isDisplayed()) {
	         returnStatus = true;
	         locator_Property.click();
	        Thread.sleep(300L);
	       }
	     returnStatus = returnStatusNew;
	     } catch (Exception e) {
	      currentsuit.appendToFile(e);
	      test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	      currentsuit.writeReportFail("Validate whether " + description + " is displayed in the Application", description + " should be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	       System.out.println(e);
	     }
	    return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean Click(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     boolean returnStatus = false;
	     try {
	      boolean returnStatusNew = false;
	      if (locator_Property.isDisplayed()) {
	         returnStatus = true;
	         locator_Property.submit();
	        Thread.sleep(3000L);
	       }
	     returnStatus = returnStatusNew;
	     } catch (Exception e) {
	       currentsuit.appendToFile(e);
	      test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       currentsuit.writeReportFail("Validate whether " + description + " is displayed in the Application", description + " should be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	     }
	     
	     return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean advancedClick(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder)
	     throws Exception
	   {
	     boolean returnStatus = false;
	     try {
	       boolean returnStatusNew = false;
	       if (locator_Property.isDisplayed()) {
	         returnStatus = true;
	         try {
	           locator_Property.click();
	         } catch (Exception ex) {
	           JavascriptExecutor executor = (JavascriptExecutor)driver;
	           executor.executeScript("arguments[0].click();", new Object[] { locator_Property });
	         }
	         
	         Thread.sleep(3000L);
	       }
	       returnStatus = returnStatusNew;
	     } catch (Exception e) {
	      currentsuit.appendToFile(e);
	       System.out.println(e);
	     }
	     
	    return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean CompareText(String locator_Text, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     boolean returnStatusCom = false;
	     if (!description.equals("")) {
	       try {
	        boolean returnStatusNewCom = false;
	        if (locator_Text.trim().equals(description.trim())) {
	           returnStatusNewCom = true;
	          test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	           currentsuit.writeReportPass("Validate whether " + description + " text is displayed and verified with the Reference parameter", description + " text should be displayed and verified as expected", description + " text is displayed & verified", test_step_unique_id, folder);
	         } else {
	           test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	           currentsuit.writeReportFail("Validate whether " + description + " text is displayed and verified with the Reference parameter", description + " text should be displayed and verified as expected", description + " text is displayed but verified as not the expected", test_step_unique_id, folder);
	         }
	        returnStatusCom = returnStatusNewCom;
	       } catch (Exception e) {
	        currentsuit.appendToFile(e);
	         test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	        currentsuit.writeReportFail("Validate whether " + description + " text is displayed and verified with the Reference parameter", description + " text should be displayed and verified as expected", description + " text is displayed but verified as not the expected", test_step_unique_id, folder);
	       }
	     }
	    System.out.println("returnStatusCom" + returnStatusCom);
	    return returnStatusCom;
	   }
	   
	 
	 
	 
	 
	 
	 
	   public static long highlightElement(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	     try
	     {
	       JavascriptExecutor js = (JavascriptExecutor)driver;
	       js.executeScript("arguments[0].setAttribute('style', arguments[1]);", new Object[] { locator_Property, "border: 3px solid red;" });
	      test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       js.executeScript("arguments[0].setAttribute('style', arguments[1]);", new Object[] { locator_Property, "border:'';" });
	       currentsuit.writeReportPass("Validate whether " + description + " is displayed in the Application", description + " should be highlighted in the page", description + " is highlighted in the page", test_step_unique_id, folder);
	     } catch (Exception e) {
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	      currentsuit.writeReportFail("Validate whether " + description + " is displayed in the Application", description + " should be displayed in the page", description + " is not displayed in the page", test_step_unique_id, folder);
	     }
	     return test_step_unique_id;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean VerifyTextDisplayed(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String textToBeVerified)
	     throws Exception
	   {
	    boolean returnStatus = false;
	     try {
	       boolean returnStatusNew = false;
	       if (locator_Property.getText().equals(textToBeVerified)) {
	         returnStatus = true;
	         test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	        currentsuit.writeReportPass("Validate whether " + textToBeVerified + " is displayed in the Application", textToBeVerified + " should be displayed in the page", textToBeVerified + " is displayed in the page", test_step_unique_id, folder);
	       }
	       returnStatus = returnStatusNew;
	     } catch (Exception e) {
	       currentsuit.appendToFile(e);
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	      currentsuit.writeReportFail("Validate whether " + textToBeVerified + " is displayed in the Application", textToBeVerified + " should be displayed in the page", textToBeVerified + " is not displayed in the page", test_step_unique_id, folder);
	     }
	     
	     return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	 
	   public static boolean waitUntilConditionPresent(WebDriver driver, String el, int timeOut)
	     throws InterruptedException
	   {
	     boolean status = false;
	     Calendar startTime = Calendar.getInstance();
	     Calendar endTime = Calendar.getInstance();
	     long timeTaken;
	     do {
	       try {
	         WebElement expected_ID = RetrieveWebElementFromApplication(el, el, el, driver);
	         if (expected_ID != null) {
	          status = true;
	         }
	       } catch (NoSuchElementException e) {
	        status = false;
	       }
	      endTime = Calendar.getInstance();
	timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000L;
	 
	     }
	while ((!status) && (timeTaken <= timeOut));
	if (timeTaken > timeOut) {
	      Thread.sleep(1000L);
	     }
	    return status;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean isPresent(By byId, By byCss, By xPath, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	   boolean returnStatus = false;
	  if (!description.equals("")) {
	   if ((driver.findElements(byId).size() != 0) || (driver.findElements(byCss).size() != 0) || (driver.findElements(xPath).size() != 0))
	       {
	        returnStatus = true;
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       currentsuit.writeReportPass("Validate whether " + description + " is present in the Application", description + " should be \tpresent in the page", description + " is present in the page", test_step_unique_id, folder);
	       }
	       else
	       {
	        returnStatus = false;
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	       currentsuit.writeReportFail("Validate whether" + description + " is present in the Application", description + " should be present in the page", description + " is not present in the page", test_step_unique_id, folder);
	       }
	     }
	   return returnStatus;
	   }
	   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   public static boolean isElementPresent(WebElement locator_Property, WebDriver driver, HtmlReport currentsuit, String folder, String description)
	     throws Exception
	   {
	    boolean returnStatus = false;
	    if (!description.equals("")) {
	     if (locator_Property != null)
	       {
	 
	       returnStatus = true;
	       test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	        currentsuit.writeReportPass("Validate whether " + description + " is present in the Application", description + " should be \tpresent in the page", description + " is present in the page", test_step_unique_id, folder);
	       }
	       else
	       {
	       returnStatus = false;
	        test_step_unique_id = currentsuit.takeScreenshot(driver, folder);
	        currentsuit.writeReportFail("Validate whether" + description + " is present in the Application", description + " should be present in the page", description + " is not present in the page", test_step_unique_id, folder);
	       }
	     }
	     
	    return returnStatus;
	   }
	 
}
