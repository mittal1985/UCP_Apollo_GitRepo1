package com.apollo.reportgeneration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class HtmlReport {

	   public static int deffectCount = 0;
	  public static int passCount = 0;
	  public int stepno;
	  public static int step_no;
	   public static Date date = new Date();
	  public static String[] date_time = date.toString().split(" ");
	 public static String today = date_time[0] + " " + date_time[1] + " " + date_time[2];
	  public static String FILENAME = "result.html";
	  public static String pathCommon = new File("").getAbsolutePath();
	  public static String FOLDER_PATH = pathCommon + "//result//";
	  public static String folderName1 = Calendar.getInstance().getTime().toString() + "/";
	  public static String[] strArr = folderName1.split("IST");
	  public static String folderName2 = strArr[0].replace(":", "_");
	  public static String[] strArr1 = folderName2.split(" ");
	   public static String folderName = "Result_" + strArr1[3];
	  public static String DESTINATION = pathCommon + "//result//";
	  public static int val = 1;
	   public static String SOURCE_FOLDER = FOLDER_PATH + folderName;
	  public long test_step_unique_id;
	   public long screenshot_name = 0L; public long screenshot_html_name = 0L;
	  public String step_desc;
	   public String ExpectedRes; public String Actual; public static String txtDocLogs = "";
	   public static int countLogs = 0;

	  public String writeReportHeader(String project_name, String application_name, String release_name, String folder, String resultHead)
	    throws Exception
	  {
	     stepno = 0;
	     SOURCE_FOLDER = FOLDER_PATH + folderName + "_";
	     SOURCE_FOLDER = SOURCE_FOLDER + resultHead + "/";
	     val += 1;
	     String folder1 = folder;
	     folder = folder + "_";
	    txtDocLogs = resultHead;
	    try {
	      File stockdir = new File(SOURCE_FOLDER);
	       File stockFile = new File(SOURCE_FOLDER + folder + FILENAME);
	       if (!stockdir.exists()) {
	         stockdir.mkdir();
	         stockFile.createNewFile();
	      }
	      else
	      {
	        String copyFolder = SOURCE_FOLDER + folder;
	         File Sourcefolder1 = new File(copyFolder);
	         File Destnationfolder1 = new File(DESTINATION);
	        copyFolder(Sourcefolder1, Destnationfolder1);
	      }
	      

	       FileWriter fw = new FileWriter(stockFile.getAbsoluteFile());
	       BufferedWriter bw = new BufferedWriter(fw);
	      
	       bw.write("<html>");
	      
	       bw.write("<head>");
	      
	       bw.write("<meta http-equiv=Content-Languagecontent=en-us>");
	      
	      bw.write("<meta http-equiv=Content-Typecontent=text/html; charset=windows-1252>");
	      
	       bw.write("<title>" + project_name + "_" + application_name + "</title>");
	      
	       bw.write("<style type=text/css>");
	      bw.write("body {background-color:##D7DF01}");
	       bw.write("td {colspan=2;valign=top;border: 1pt solid rgb(120, 192, 212);border-style: none solid solid; border-color: -moz-use-text-color rgb(120, 192, 212) rgb(120, 192, 212); border-width: medium 1pt 1pt; padding: 0in 5.4pt; background: rgb(165, 213, 226) none repeat scroll 0% 0%;  -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous;font-size:9.0pt;color:#17365D}");
	       bw.write("hr{color:#17365D}");
	      bw.write("th{border: 1pt solid rgb(120, 192, 212); padding: 0in 5.4pt; background: rgb(210, 234, 241) none repeat scroll 0% 0%;  -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous;font-size:9.0pt;font-weight:bold}");
	       bw.write("table{border=1;cellspacing=0;cellpadding=0;border-collapse:collapse;border:none;mso-border-alt:solid #78C0D4 1.0pt;mso-border-themecolor:accent5;mso-border-themetint:191;mso-yfti-tbllook:1184; mso-padding-alt:0in 5.4pt 0in 5.4pt}");
	      bw.write("</style>");
	      
	       bw.write("</head>");
	      
	      bw.write("<body>");
	      
	       bw.write("<table width=100% border=1px><tr border=1><th>");
	      

	       bw.write("<h2><em  align=centre style='color:red;font-family:'Times new roman','serif';font-size:26pt;letter-spacing:0.25pt;'>Project Name :" + project_name + "</em></h2></th></tr></table>");
	      
	      bw.write("<hr / style='color:white;'><table width=100% border=1px> <tr height=50 border=1 style='color:#17365D;font-family:'Times new roman','serif';font-size:30pt;letter-spacing:0.25pt;'>");
	      
	       bw.write("<th border=1><b align=right  style='color:#17365D;font-family:'Times new roman','serif';font-size:15pt;letter-spacing:0.25pt;'>Application Name :" + application_name + "<br><b></th>");
	      
	      bw.write("<th border=1><b  align=right  style='color:#17365D;font-family:'Times new roman','serif';font-size:15pt;letter-spacing:0.25pt;'>Release Name :" + release_name + "<br></b></th>");
	      
	      bw.write("<th border=1><b style='color:#17365D;font-family:'Times new roman','serif';font-size:13pt;letter-spacing:0.25pt;align:right'>Test Run Date :" + today + "<br></b></th>");
	       bw.write("<th border=1><b style='color:#17365D;font-family:'Times new roman','serif';font-size:13pt;letter-spacing:0.25pt;align:right'>Test Run Time :" + strArr1[3] + "<br></b></th></tr></table>");
	       bw.write("<hr / style='color:white;'> ");
	      bw.newLine();
	       bw.close();
	       writeHtmlLinebreak(folder);
	       writeTestStepHeader(folder);

	    }
	    catch (Exception e)
	    {
	      // e.printStackTrace();
	    }
	    return folder1;
	  }
	  
	  public String getFolderName() {
	     return folderName.split("/")[0];
	  }
	  





	  public void writeHtmlLinebreak(String folder)
	    throws Exception
	  {
	     File stockFile = new File(SOURCE_FOLDER + folder + "/" + FILENAME);
	     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(SOURCE_FOLDER + folder + FILENAME, true), "UTF-8");
	    BufferedWriter bw = new BufferedWriter(writer);
	     bw.write("<br>");
	    bw.write("<br>");
	    bw.newLine();
	   bw.close();
	  }
	  




	  public void writeTestStepHeader(String folder)
	    throws Exception
	  {
	    File stockFile = new File(SOURCE_FOLDER + folder + FILENAME);
	     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(SOURCE_FOLDER + folder + FILENAME, true), "UTF-8");
	    BufferedWriter bw = new BufferedWriter(writer);
	     bw.write("<table width=100% border=1px>");
	     bw.write("<tr>");
	     bw.write("<th width=5%>Step No</th>");
	     bw.write("<th width=20%>Step Description</th>");
	     bw.write("<th width=20%>Expected Result</th>");
	     bw.write("<th width=20%>Actual Result</th>");
	     bw.write("<th width=5%>Result</th>");
	     bw.write("<th width=5%>Screenshot</th>");
	     bw.write("</tr>");
	     bw.write("</table>");
	     bw.newLine();
	     bw.close();
	  }
	  



















	  public void writeReportPass(String stepdesc, String Expected, String strActRslt, long test_step_unique_id, String folder)
	    throws Exception
	  {
		  try{
	     passCount += 1;
	     stepno += 1;
	     screenshot_name = test_step_unique_id;
	     step_no = stepno;
	     step_desc = stepdesc;
	     ExpectedRes = Expected;
	     Actual = strActRslt;
	     screenshot_html_name = test_step_unique_id;
	   //  System.out.println(step_no+step_desc+ExpectedRes+Actual+screenshot_html_name);
	     writeTestStepRowPass(step_no, step_desc, ExpectedRes, Actual, screenshot_html_name, folder);
	     writeScreenshotHtml(screenshot_name, folder);
	  }catch(Exception exception){
		exception.printStackTrace();  
	  }
	  }

	  public void writeReportPassSalesforce_IWDQuery(String stepdesc, String Expected, String strActRslt, long test_step_unique_id, String folder)
			    throws Exception
			  {
				  try{
			     passCount += 1;
			     stepno += 1;
			     screenshot_name = test_step_unique_id;
			     step_no = stepno;
			     step_desc = stepdesc;
			     ExpectedRes = Expected;
			     Actual = strActRslt;
			     screenshot_html_name = test_step_unique_id;
			   //  System.out.println(step_no+step_desc+ExpectedRes+Actual+screenshot_html_name);
			     writeTestStepRowPass_Salesforce(step_no, step_desc, ExpectedRes, Actual, screenshot_html_name, folder);
			   //  writeScreenshotHtml(screenshot_name, folder);
			  }catch(Exception exception){
				exception.printStackTrace();  
			  }
			  }






















	  public void writeTestStepRowPass(int step_no, String step_desc, String ExpectedRes, String Actual, long screenshot_html_name, String folder)
	    throws Exception
	  {
	     folder = folder.replaceAll("//", "/");
	     File stockFile = new File(folder + "_" + FILENAME);
	     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(folder + "_" + FILENAME, true), "UTF-8");
	    BufferedWriter bw = new BufferedWriter(writer);
	     bw.write("<table width=100% border=1px>");
	     bw.write("<tr>");
	     bw.write("<td width=5%>Step" + step_no + "</td>");
	     bw.write("<td width=20%>" + step_desc + "</td>");
	     bw.write("<td width=20%>" + ExpectedRes + "</td>");
	     bw.write("<td width=20%>" + Actual + "</td>");
	     bw.write("<td width=5% height=100 style=color:green;font-weight:bold>Pass</td>");
	     bw.write("<td width=5%><a href='" + folder + "/" + screenshot_html_name + ".png" + "'" + "target=_blank>Screenshot</a></td>");
	     bw.write("</tr>");
	     bw.write("</table>");
	    bw.close();
	  }
	  
	  public void writeTestStepRowPass_Salesforce(int step_no, String step_desc, String ExpectedRes, String Actual, long screenshot_html_name, String folder)
			    throws Exception
			  {
			     folder = folder.replaceAll("//", "/");
			     File stockFile = new File(folder + "_" + FILENAME);
			     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(folder + "_" + FILENAME, true), "UTF-8");
			    BufferedWriter bw = new BufferedWriter(writer);
			     bw.write("<table width=100% border=1px>");
			     bw.write("<tr>");
			     bw.write("<td width=5%>Step" + step_no + "</td>");
			     bw.write("<td width=20%>" + step_desc + "</td>");
			     bw.write("<td width=20%>" + ExpectedRes + "</td>");
			     bw.write("<td width=20%>" + Actual + "</td>");
			     bw.write("<td width=5% height=100 style=color:green;font-weight:bold>Pass</td>");
			     bw.write("<td width=5%></td>");
			     bw.write("</tr>");
			     bw.write("</table>");
			    bw.close();
			  }







	  public String writeSubHeader(String heading, String folder)
	    throws Exception
	  {
	     File stockFile = new File(SOURCE_FOLDER + folder + "_" + FILENAME);
	     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(SOURCE_FOLDER + folder + "_" + FILENAME, true), "UTF-8");
	     BufferedWriter bw = new BufferedWriter(writer);
	     bw.write("<br></br>");
	     bw.write("<table width=100% border=1px align=center>");
	     bw.write("<tr>");
	     bw.write("<td width=20% align=center><font size=3px color=blue>" + heading + "</font></td>");
	    bw.write("</tr>");
	     bw.write("</table>");
	     bw.close();
	     return SOURCE_FOLDER + folder;
	  }
	  










	  public String writeSubHeaderForScripts(String heading, String folder)
	    throws Exception
	  {
	     File stockFile = new File(folder + "_" + FILENAME);
	     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(folder + "_" + FILENAME, true), "UTF-8");
	     BufferedWriter bw = new BufferedWriter(writer);
	     bw.write("<br></br>");
	     bw.write("<table width=100% border=1px align=center>");
	     bw.write("<tr id='Test_Case'>");
	    bw.write("<td width=20% align=left><font size=3px color=blue>Test Case Name</font></td>");
	     bw.write("<td width=20% align=center><font size=3px color=blue>" + heading + "</font></td>");
	    bw.write("</tr>");
	     bw.write("</table>");
	     bw.close();
	     return SOURCE_FOLDER + folder;
	  }
	  




















	  public void writeReportFail(String stepdesc, String Expected, String strActRslt, long test_step_unique_id, String folder)
	    throws Exception
	  {
	     deffectCount += 1;
	    stepno += 1;
	     screenshot_name = test_step_unique_id;
	     step_no = stepno;
	     step_desc = stepdesc;
	     ExpectedRes = Expected;
	     Actual = strActRslt;
	    screenshot_html_name = test_step_unique_id;
	     writeTestStepRowFail(step_no, step_desc, ExpectedRes, Actual, screenshot_html_name, folder);
	  }
	  
	  public void writeReportFai_SalesforceIWD(String stepdesc, String Expected, String strActRslt, long test_step_unique_id, String folder)
			    throws Exception
			  {
			     deffectCount += 1;
			    stepno += 1;
			     screenshot_name = test_step_unique_id;
			     step_no = stepno;
			     step_desc = stepdesc;
			     ExpectedRes = Expected;
			     Actual = strActRslt;
			    screenshot_html_name = test_step_unique_id;
			    writeTestStepRowFail_SalesforceIWD(step_no, step_desc, ExpectedRes, Actual, screenshot_html_name, folder);
			  }























	  public void writeTestStepRowFail(int step_no, String step_desc, String ExpectedRes, String Actual, long screenshot_html_name, String folder)
	    throws Exception
	  {
	    folder = folder.replaceAll("//", "/");
	    File stockFile = new File(folder + "_" + FILENAME);
	     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(folder + "_" + FILENAME, true), "UTF-8");
	     BufferedWriter bw = new BufferedWriter(writer);
	     bw.write("<table width=100% border=1px>");
	     bw.write("<tr>");
	     bw.write("<td width=5%>Step" + step_no + "</td>");
	     bw.write("<td width=20%>" + step_desc + "</td>");
	     bw.write("<td width=20%>" + ExpectedRes + "</td>");
	    bw.write("<td width=20%>" + Actual + "</td>");
	     bw.write("<td width=5% height=100 style=color:red;font-weight:bold>Fail</td>");
	    bw.write("<td width=5%><a href='" + folder + "/" + screenshot_html_name + ".png" + "'" + "target=_blank>Screenshot</a></td>");
	     bw.write("</tr>");
	     bw.write("</table>");
	    bw.close();
	  }
	  

	  public void writeTestStepRowFail_SalesforceIWD(int step_no, String step_desc, String ExpectedRes, String Actual, long screenshot_html_name, String folder)
			    throws Exception
			  {
			    folder = folder.replaceAll("//", "/");
			    File stockFile = new File(folder + "_" + FILENAME);
			     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(folder + "_" + FILENAME, true), "UTF-8");
			     BufferedWriter bw = new BufferedWriter(writer);
			     bw.write("<table width=100% border=1px>");
			     bw.write("<tr>");
			     bw.write("<td width=5%>Step" + step_no + "</td>");
			     bw.write("<td width=20%>" + step_desc + "</td>");
			     bw.write("<td width=20%>" + ExpectedRes + "</td>");
			    bw.write("<td width=20%>" + Actual + "</td>");
			     bw.write("<td width=5% height=100 style=color:red;font-weight:bold>Fail</td>");
			    bw.write("<td width=5%></td>");
			     bw.write("</tr>");
			     bw.write("</table>");
			    bw.close();
			  }







	  public void writeScreenshotHtml(long screenshot_name, String folder)
	    throws Exception
	  {
	     folder = folder.replaceAll("//", "/");
	     File stockFile1 = new File(folder + "/" + screenshot_name + ".html");
	     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(folder + "/" + screenshot_name + ".html", true), "UTF-8");
	     BufferedWriter bw1 = new BufferedWriter(writer);
	     bw1.write("<html>");
	     bw1.write("<head>");
	     bw1.write("<meta http-equiv=Content-Languagecontent=en-us>");
	     bw1.write("<meta http-equiv=Content-Typecontent=text/html; charset=windows-1252>");
	     bw1.write("<title>" + screenshot_name + "</title>");
	     bw1.write("</head>");
	     bw1.write("<body>");
	     bw1.write("<p>Screen Shot</p>");
	     bw1.write("<img src='" + folder + "/" + screenshot_name + ".png'/>");
	     bw1.write("</body>");
	     bw1.close();
	  }
	  










	  private void copyFolder(File Sourcefolder1, File destnationfolder2)
	  {
	     String[] files = Sourcefolder1.list();
	     for (String file : files) {
	       copyFolder(Sourcefolder1, destnationfolder2);
	    }
	  }
	  




	  public long takeScreenshot(WebDriver driver, String folder)
	    throws Exception
	  {
	    File screenshot;
	    



	    try
	    {
	       screenshot = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    }
	    catch (Exception e)
	    {
	       driver = new Augmenter().augment(driver);
	       screenshot = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    }
	    
	    try
	    {
	       File f = null;
	       boolean a = screenshot.exists();
	     // if ((a = 1) != 0)
	       if (true)
	      {
	         test_step_unique_id = Calendar.getInstance().getTimeInMillis();
	        FileUtils.copyFile(screenshot, new File(folder + "/" + test_step_unique_id + ".png"));
	      }
	      

	    }
	    catch (IOException e)
	    {
	       e.printStackTrace();
	    }
	     return test_step_unique_id;
	  }
	  





	  public void appendToFile(Exception e)
	  {
	    try
	    {
	      if (countLogs == 0) {
	        FileWriter fstream = new FileWriter(DESTINATION + folderName + "_" + txtDocLogs + "/" + "LogsReport.txt", true);
	         BufferedWriter out = new BufferedWriter(fstream);
	         out.write("<Failure" + (countLogs + 1) + ">");
	         PrintWriter pWriter = new PrintWriter(out, true);
	         e.printStackTrace(pWriter);
	         countLogs += 1;
	      } else {
	         FileWriter fstream = new FileWriter(DESTINATION + folderName + "_" + txtDocLogs + "/" + "LogsReport.txt", true);
	        BufferedWriter out = new BufferedWriter(fstream);
	        out.write("</Failure" + countLogs + ">");
	         out.write("<Failure" + (countLogs + 1) + ">");
	        PrintWriter pWriter = new PrintWriter(out, true);
	         e.printStackTrace(pWriter);
	       countLogs += 1;
	      }
	    }
	    catch (Exception ie) {
	       throw new RuntimeException("Error on LogReport.xml generation", ie);
	    }
	  }
}
