package edu.apollogrp.tests.UCPSmokeTests;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

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

//import com.aptimus.phxedu.seleniumbase.BasePage;

//import edu.apollogrp.logger.Logger;

public class EmailUtility {

	
	String REPORT_URL = "http://10.96.62.143:8080/job/UCP_Automation_SmokeTestSuite/";
	
	String SUBJECT = "Sprint 5 Chrome ";
	String BROWSER_TESTED = "Google Chrome 55.0.288";
	WebDriver driver= new FirefoxDriver();
	
	@Test
	public void runTesttOT( ) throws Exception{
		String browser = "FF";
		String suite = "regression";
		
		
		
	    if(suite.equalsIgnoreCase("sanity"))
		{
//	    	driver.get("http://10.96.52.54:8080/view/FPM/job/fima/");
		} else{
	    	driver.get(REPORT_URL);
	        Thread.sleep(2000);
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
			
       
        String build = driver.findElement(By.xpath(".//*[@id='buildHistory']/div[2]/table/tbody/tr[2]/td/div[1]/a")).getText();
        String build1 = build.trim();
        String build2 = build1.substring(1);
        String appUrl = "https://phoenix.edu";
        System.out.println("Build number = "+build2);
		
		try {
			String env = REPORT_URL+"ws/target/surefire-reports/emailable-report.html";
			
			String source = "";
			StringBuffer stringBuf = new StringBuffer(); 
			stringBuf.append("<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title>TestNG:  Unit Test</title><style type=\"text/css\">table caption,table.info_table,table.param,table.passed,table.failed {margin-bottom:10px;border:1px solid #000099;border-collapse:collapse;empty-cells:show;}table.info_table td,table.info_table th,table.param td,table.param th,table.passed td,table.passed th,table.failed td,table.failed th {border:1px solid #000099;padding:.25em .5em .25em .5em}table.param th {vertical-align:bottom}td.numi,th.numi,td.numi_attn {text-align:right}tr.total td {font-weight:bold}table caption {text-align:center;font-weight:bold;}table.passed tr.stripe td,table tr.passedodd td {background-color: #00AA00;}table.passed td,table tr.passedeven td {background-color: #33FF33;}table.passed tr.stripe td,table tr.skippedodd td {background-color: #cccccc;}table.passed td,table tr.skippedodd td {background-color: #dddddd;}table.failed tr.stripe td,table tr.failedodd td,table.param td.numi_attn {background-color: #FF3333;}table.failed td,table tr.failedeven td,table.param tr.stripe td.numi_attn {background-color: #DD0000;}tr.stripe td,tr.stripe th {background-color: #E6EBF9;}p.totop {font-size:85%;text-align:center;border-bottom:2px black solid}div.shootout {padding:2em;border:3px #4854A8 solid}</style></head><body>");


			stringBuf.append("Hi All,");
			stringBuf.append("<p>Please find the below reports</p>");
			
			stringBuf.append(drawPieChart(env));
			
			stringBuf.append(getEnvironmentDetails(build2, appUrl, browser));
			stringBuf.append(resultTable());
			System.out.println("Finished Resut Table");
			stringBuf.append("</body></html>"); 

			//stringBuf.append("</body></html>"); 
			source = stringBuf.toString();
		
				
				Thread.sleep(2000);
				sendEmail(source,SUBJECT+" - "+generateDateFormat());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	
	

	

	
	
	
	public String resultTable() throws Exception, URISyntaxException{
		
		
		StringBuffer sb = new StringBuffer();
		sb.append( "<br/>" );
		sb.append( "<br/>" );
		sb.append( "<br/>" );
		driver.get(REPORT_URL);
		Thread.sleep(2500);
		String build = driver.findElement(By.xpath(".//*[@id='buildHistory']/div[2]/table/tbody/tr[2]/td/div[1]/a")).getText();
	    String build1 = build.trim();
	    String build2 = build1.substring(1);
		driver.get(REPORT_URL+build2+"/testReport/"+"edu.apollogrp.tests.UCPSmokeTests");
		
		
		
		String header = "<tr bgcolor='99CCFF'><TH ALIGN='CENTER'>Test class</TH><TH ALIGN='CENTER'>Duration </TH><TH ALIGN='CENTER' bgcolor='66FF33'>Status</TH></tr>";
		
		String body = "";
		int allTotal = 0;
		int allPassed = 0;
		int allFailed = 0;
		int allSkipped = 0;
		
		String totalDuration = driver.findElement(By.xpath(".//*[@id='main-panel']/div[2]/a")).getText();
		totalDuration = totalDuration.replaceAll("Took ", "");

		
		
		String Total1 ="" ;
		String Failed1 ="" ;
		String Skipped1 ="" ;
		String Passed1  ="" ;
		String Time1 ="" ;
		String TestPackage1 ="" ;
		
		Thread.sleep(2000);
		
		
		
	
			
			 TestPackage1  = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr/td[1]/a/span")).getText();			 
			 Total1 	   = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+1+"]/td[9]")).getText();			
			 Failed1   	   = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+1+"]/td[3]")).getText();
			 Skipped1      = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+1+"]/td[5]")).getText();
			 Passed1       = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr/td[7]")).getText();			
			 Time1         = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+1+"]/td[2]")).getText();
			 
			 System.out.println(TestPackage1+""+Total1+""+Failed1+""+Skipped1);
			Thread.sleep(2000);
			int packageSize =0;
			
			System.out.println("going to click UCPSmokeTests_CallType");
			driver.findElement(By.xpath(".//*[@id='testresult']/tbody[2]/tr/td[1]/a/span")).click();
			
			
			System.out.println("after click packet size should be 2");
			 packageSize = driver.findElements(By.xpath("//*[@id='testresult']/tbody[2]/tr/td[1]/a/span")).size();
			
	
			 
			 if(packageSize>1){
					List<WebElement> resultTable1 = driver.findElements(By.xpath("//*[@id='testresult']/tbody[2]/tr"));
					for(int j=1;j<=resultTable1.size();j++)
					{
					
						String testName  = driver.findElement(By.xpath(".//*[@id='testresult']/tbody[2]/tr["+j+"]/td[1]/a/span")).getText();			 
						 String status 	   = driver.findElement(By.xpath(".//*[@id='testresult']/tbody[2]/tr["+j+"]/td[3]/span")).getText();			
						String duration         = driver.findElement(By.xpath(".//*[@id='testresult']/tbody[2]/tr["+j+"]/td[2]")).getText();
						 
						 
						body = body + "<b><tr ><td >"+testName+"</td><td ALIGN='CENTER'>"+duration+"</td><td ALIGN='CENTER'>"+status+"</td>"+"</tr></b>";
						
						
						
					}

				}
			 
			 
			driver.navigate().back();
			Thread.sleep(2000);
			
		//	body = body + "<tr bgcolor='#FFDAB9'><b><td >"+""+"</td><td ALIGN='CENTER'>"+allTotal+"</td><td ALIGN='CENTER'>"+allPassed+"</td><td ALIGN='CENTER'>"+allFailed+"</td><td ALIGN='CENTER'>"+allSkipped+"</td><td ALIGN='CENTER'>"+totalDuration+"</td>"+"</b></tr>";
			
			sb.append("<table BORDER='2'   WIDTH='70%' align='middle'  CELLPADDING='2' CELLSPACING='1'> ");
			sb.append("<th bgcolor='#5D7B9D'  colspan=6><font color='#fff' size=3> Detailed report table </font></th>");
			
			sb.append(header);
			sb.append(body);
			sb.append("</table>");
		
	
		
	
		

		return sb.toString();

	}

	
	
	public String drawPieChart(String EMAILABLE_REPORT) throws InterruptedException  {
        int passi,  skipi,  faili;
        driver.get(REPORT_URL);
		Thread.sleep(2500);
		String build = driver.findElement(By.xpath(".//*[@id='buildHistory']/div[2]/table/tbody/tr[2]/td/div[1]/a")).getText();
	    String build1 = build.trim();
	    String build2 = build1.substring(1);
		driver.get(REPORT_URL+build2+"/testReport/"+"edu.apollogrp.tests.UCPSmokeTests");
		
        
        int allTotal = 0;
		int allPassed = 0;
		int allFailed = 0;
		int allSkipped = 0;
		
		String Total ="" ;
		String Failed ="" ;
		String Skipped ="" ;
		String Passed  ="" ;
		
		Thread.sleep(2000);
		List<WebElement> resultTable = driver.findElements(By.xpath("//*[@id='testresult']/tbody[2]/tr"));
		for(int k=1;k<=resultTable.size();k++)
		{

						 
			 Total 	    = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+k+"]/td[9]")).getText();			
			 Failed     = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+k+"]/td[3]")).getText();
			 Skipped    = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+k+"]/td[5]")).getText();
			 Passed     = driver.findElement(By.xpath("//*[@id='testresult']/tbody[2]/tr["+k+"]/td[7]")).getText();			
			
			
			allTotal     = allTotal+ Integer.parseInt(Total);
			allPassed    = allPassed+ Integer.parseInt(Passed);
			allFailed    = allFailed+ Integer.parseInt(Failed);
			allSkipped   = allSkipped+ Integer.parseInt(Skipped);
		
		}
		
        
        passi = allPassed;
        skipi = allSkipped;
        faili = allFailed;
        
        int total = passi+skipi+faili;
        
        String pass=Integer.toString(passi*100/total);
        String skip=Integer.toString(skipi*100/total);
        String fail=Integer.toString(faili*100/total);
     
        String alt="\" alt=";
        String googlepiechart="\"Google Chart";
        String icon="\"/></center>";    
        String urlimg="\"http://chart.apis.google.com/chart?";
        String img="<center><img src="+urlimg+"chtt=Pie+Chart&amp;chts=000000,12&amp;chs=300x150&amp;chf=bg,s,ffffff&amp;cht=p3&amp;chd=t:passtest,failtest,skiptest&amp;chl=Passed|Failed|Skipped&amp;chco=006600,ff0000,ffff00"+alt+googlepiechart+icon; 
        img=img.replaceAll("passtest", pass);
        img=img.replaceAll("failtest", fail);
        img=img.replaceAll("skiptest", skip);
        return img;
 }

	public String getEnvironmentDetails(String build, String appUrl, String browserType) throws IOException, URISyntaxException{
		StringBuffer sb = new StringBuffer();
		
		sb.append( "<br/>" );
		sb.append( "<br/>" );
		sb.append( "<br/>" );

		sb.append("<table BORDER='2'   WIDTH='70%' align='middle'  CELLPADDING='2' CELLSPACING='1'> ");
		sb.append("<th bgcolor='#5D7B9D'  colspan=2><font color='#fff' size=3> Environment Details </font></th>");
		
		sb.append("<tr>");
		sb.append("<td ALIGN='CENTER'><font  size=2>APPICATION URL </font>	</td><td align='center' size=2> <a href="+ appUrl + "> " + appUrl + "</a></td></tr>");
		sb.append("<td ALIGN='CENTER'><font  size=2>BUILD NUMBER </td><td  align='center' size=2>  "
				+ build + " </td> </font></tr>");
		sb.append("<td ALIGN='CENTER'><font  size=2>BROWSER TESTED </td><td  align='center' size=2>  "
				+ BROWSER_TESTED + "</td> </font></tr>");
		sb.append("<td ALIGN='CENTER'><font  size=2>DATE OF EXECUTION  </td><td  align='center' size=2>  "
				+ generateDateFormat() + " </td> </font></tr>");

		sb.append("</table>");

		return sb.toString();

	}
	
	public String generateDateFormat(){

		String date="";
		Date dateNow = new Date();
//		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat formatter= new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		formatter.setTimeZone(TimeZone.getTimeZone("IST"));
		date = formatter.format(dateNow);
		return date;

	}

	public void sendEmail(String source,String subject) throws Exception {

		
		
			String to = "gaurav.mittal@apollo.edu";
			
			
            System.out.println("Enter sendMailViaExchnageService");

            ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);

            ExchangeCredentials credentials = new WebCredentials("gaurav.mittal@apollo.edu", "Education12#$");
            service.setCredentials(credentials);
            service.setUrl(new URI("https://outlook.office365.com/EWS/Exchange.asmx"));

            EmailMessage msg = new EmailMessage(service);
            msg.setSubject(subject);
            msg.setBody(MessageBody.getMessageBodyFromText(source.toString()));
            List<String> toAddressList = Arrays.asList(to.split("\\s*,\\s*"));
            Iterator<String> mailList = toAddressList.iterator();

            msg.getToRecipients().addSmtpAddressRange(mailList);
          
            msg.send();
					
			System.out.println("\nMail was sent successfully.");

			System.out.println("Exit sendMailViaExchnageService");



		}
	
}