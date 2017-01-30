package com.apollo.salesforceconnection;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Opportunity;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;



public class SalesforceConnect {

	public static final String AUTHENDPOINT = "https://test.salesforce.com/services/Soap/c/37.0/0DFe00000004Dvr";
	public static EnterpriseConnection connection;
	public static String username = null;
	public static String password = null;
	public static ConnectorConfig config =null;

	public static void connect(String irn) throws Exception{
		username = "gaurav.mittal@apollo.edu.test";
		password = "Apollo12#$CeQzWTE7NQvh8egaoRRCFrzzB";	
		
			try {
				config = new ConnectorConfig();
				config.setUsername(username);
				config.setPassword(password);
				config.setAuthEndpoint(AUTHENDPOINT);
				connection = new EnterpriseConnection(config);

				System.out.println(irn);
				
				/*Getting StudentprofileId*/
				QueryResult queryResults = connection.query("Select Student_Profile_ID__c FROM Account where person_IRN__C = '"+ irn + "'");
				if (queryResults.getSize() > 0) {
					for (int i = 0; i < queryResults.getRecords().length; i++) {
						Account account = (Account) queryResults.getRecords()[i];
						System.out.println("StudentprofileId-----: "+ account.getStudent_Profile_ID__c());
					}
				}
				/*End of Getting StudentprofileId*/
				/*Getting  WorkItemId*/
				QueryResult workItemId = connection.query("SELECT UCP_Work_Item_ID__c FROM Opportunity where irn__c = '"+ irn + "'");
				Opportunity opportunity_WorkItemID = (Opportunity) workItemId.getRecords()[0];
				System.out.println("workItemId-------------------: " + opportunity_WorkItemID.getUCP_Work_Item_ID__c());
				/*End of Getting  WorkItemId*/
				
				/*Getting opportunityOwner*/
				QueryResult oppurtunityOwner = connection.query("SELECT id, Owner_Alias__c FROM Opportunity where irn__c  = '"+ irn + "'");
				Opportunity opportunity = (Opportunity) oppurtunityOwner.getRecords()[0];
				Thread.sleep(1000);
				System.out.println("oppurtunityOwner-------------: " + opportunity.getOwner_Alias__c());
				/*End of Getting opportunityOwner*/
				
			} catch (ConnectionException ce) {
				ce.printStackTrace();
			
	}
}
}
