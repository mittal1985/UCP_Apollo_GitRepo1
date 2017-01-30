package com.apollo.salesforceconnection;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.apollo.irnworkItemStatus.IRN_WorkItemStatus;
import com.apollo.reportgeneration.Generic_Functions;
import com.apollo.reportgeneration.HtmlReport;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Opportunity;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SalesforceConnect_163 {

	public static final String AUTHENDPOINT = "https://test.salesforce.com/services/Soap/c/38.0/0DF2900000000Dt";
	public static EnterpriseConnection connection;
	public static String username = null;
	public static String password = null;
	public static ConnectorConfig config =null;
	public static HtmlReport currentSuit = new HtmlReport();
	public static String folder;
	public static String screen_Header;
	public static String app_Name_Final;
	public static String proj_Name_Final;

	public static void salesforcePage() {
		try{
		app_Name_Final = "QA Automation";
		proj_Name_Final = "UCP QA Automation";
		screen_Header = currentSuit.writeReportHeader(proj_Name_Final,app_Name_Final, "Test_Release", "PC_Firefox", "UCP");
		folder = currentSuit.writeSubHeader("Test run result for " + "SalesforceConnection",screen_Header);
		currentSuit.writeSubHeaderForScripts("Salesforce Connection",folder);
	}catch(Exception exception){
		//exception.printStackTrace();
	}
	}
	
	
	public static void iwdPage() {
		try{
		app_Name_Final = "QA Automation";
		proj_Name_Final = "UCP QA Automation";
		screen_Header = currentSuit.writeReportHeader(proj_Name_Final,app_Name_Final, "Test_Release", "PC_Firefox", "UCP");
		folder = currentSuit.writeSubHeader("Test run result for " + "IWDConnection",screen_Header);
		currentSuit.writeSubHeaderForScripts("IWD Connection",folder);
	}catch(Exception exception){
		//exception.printStackTrace();
	}
	}
	
	
	@Test
	public static IRN_WorkItemStatus connect(String businessEmail,WebDriver driver, String folder) throws Exception{
		username = "gaurav.mittal@apollo.edu.test1";
		password = "Apollo12#$OhV3qQYBOcjHgxJJLEjz9dKvx";	
		IWDConnection iwdConnection=null;
		String irn = null;
		IRN_WorkItemStatus irn_workitemidStatus=null;
		String workItemIdStatus=null;
		
			try {
				salesforcePage();
				config = new ConnectorConfig();
				config.setUsername(username);
				config.setPassword(password);
				config.setAuthEndpoint(AUTHENDPOINT);
				connection = new EnterpriseConnection(config);
				irn_workitemidStatus=new IRN_WorkItemStatus();
				//System.out.println(businessEmail);
				
				iwdConnection= new IWDConnection();
				/*Getting lead irn*/
				//QueryResult queryResult = connection.query("Select id FROM Account where work_email__pc  = '"+ businessEmail + "' limit 1 ");
				System.out.println("================Salesforce Connection Starts===============");
				Thread.sleep(25000);
				QueryResult queryResult = connection.query("Select person_IRN__C FROM Account where work_email__pc  = '"+ businessEmail + "' limit 1 ");
				
				System.out.println("queryResult size from Salesforce is "+queryResult.getSize());
				if(queryResult.getSize()==0){
					System.out.println("No row could be fetched corresponding to email "+businessEmail+" so exiting the further flow");
					Generic_Functions.WriteFailSalesforceQuery(driver, currentSuit, folder, "Verify whether QueryList size is 0", "QueryList size is fetched correctly", "QueryList size is 0");
				}else{
					Generic_Functions.WritePassSalesforceQuery(driver, currentSuit, folder, "Verify whether QueryList size is not 0", "QueryList size is fetched correctly", "QueryList size is not 0");
					
					for (int i = 0; i < queryResult.getRecords().length; i++) {
						Account account = (Account)queryResult.getRecords()[0];
						System.out.println("irn value is -----"+account.getPerson_IRN__c());
						//iwdConnection.getAllTasks(account.getPerson_IRN__c());
						irn = account.getPerson_IRN__c();
						irn_workitemidStatus.setIrn(irn);
						
				
					}
				
				
				
				//List<List<SObject>> searchList = [FIND 'map*' IN ALL FIELDS RETURNING Account (Id, Name), Contact, Opportunity, Lead];

				
				
				
				/*End of lead irn*/
				
			
				/*Getting  WorkItemId*/
				Thread.sleep(25000);
				QueryResult workItemId = connection.query("SELECT UCP_Work_Item_ID__c FROM Opportunity where irn__c = '"+ irn + "'");
			
				Opportunity opportunity_WorkItemID = (Opportunity) workItemId.getRecords()[0];
				System.out.println("workItemId-------------------: " + opportunity_WorkItemID.getUCP_Work_Item_ID__c());
				System.out.println("================Salesforce Connection Ends===============");
				irn_workitemidStatus.setWorkItemId(opportunity_WorkItemID.getUCP_Work_Item_ID__c());
				workItemIdStatus=iwdConnection(opportunity_WorkItemID, driver,  folder);
				//workItemIdStatus=iwdConnection.getAllTasks_iwd(opportunity_WorkItemID.getUCP_Work_Item_ID__c());
				irn_workitemidStatus.setWorkItemStatus(workItemIdStatus);
				/*End of Getting  WorkItemId*/
			}
			} catch (ConnectionException ce) {
				ce.printStackTrace();
			
	}
			return irn_workitemidStatus;
}
	
	
	
	@Test
	public static String iwdConnection(Opportunity opportunity_WorkItemID,WebDriver driver, String folder) {
		IWDConnection iwdConnection= new IWDConnection();
		String workItemIdStatus=null;
		try{
			workItemIdStatus=iwdConnection.getAllTasks_iwd(opportunity_WorkItemID.getUCP_Work_Item_ID__c());
			
			if(workItemIdStatus!=null){
				Generic_Functions.WritePassIWDQuery(driver, currentSuit, folder, "Verify whether IWD QueryList size is not 0", "IWD QueryList size is fetched correctly", "IWD QueryList size is not 0");
			}else{
				Generic_Functions.WriteFailIWDQuery(driver, currentSuit, folder, "Verify whether IWD QueryList size is  0", "IWD QueryList size is fetched correctly", "IWD QueryList size is  0");
				
			}
			
	}catch(Exception exception){
		exception.printStackTrace();
	}
	return workItemIdStatus;
	}
	

}
