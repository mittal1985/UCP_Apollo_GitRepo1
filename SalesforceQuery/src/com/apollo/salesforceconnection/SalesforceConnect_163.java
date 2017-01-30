package com.apollo.salesforceconnection;

import java.util.List;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Opportunity;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SalesforceConnect_163 {

	public static final String AUTHENDPOINT = "https://test.salesforce.com/services/Soap/c/38.0/0DF2900000000Dt";
	public static EnterpriseConnection connection;
	public static String username = null;
	public static String password = null;
	public static ConnectorConfig config =null;

	public static void connect(String businessEmail) throws Exception{
		username = "gaurav.mittal@apollo.edu.test1";
		password = "Apollo12#$OhV3qQYBOcjHgxJJLEjz9dKvx";	
		IWDConnection iwdConnection=null;
		String irn = null;
		
			try {
				config = new ConnectorConfig();
				config.setUsername(username);
				config.setPassword(password);
				config.setAuthEndpoint(AUTHENDPOINT);
				connection = new EnterpriseConnection(config);

				//System.out.println(businessEmail);
				
				iwdConnection= new IWDConnection();
				/*Getting lead irn*/
				//QueryResult queryResult = connection.query("Select id FROM Account where work_email__pc  = '"+ businessEmail + "' limit 1 ");
				QueryResult queryResult = connection.query("Select person_IRN__C FROM Account where work_email__pc  = '"+ businessEmail + "' limit 1 ");
				
				System.out.println("queryResult size is "+queryResult.getSize());
			
				if (queryResult.getSize() > 0) {
					for (int i = 0; i < queryResult.getRecords().length; i++) {
						Account account = (Account)queryResult.getRecords()[0];
						System.out.println("irn value is -----"+account.getPerson_IRN__c());
						//iwdConnection.getAllTasks(account.getPerson_IRN__c());
						irn = account.getPerson_IRN__c();
						
				
					}
				}
				
				
				//List<List<SObject>> searchList = [FIND 'map*' IN ALL FIELDS RETURNING Account (Id, Name), Contact, Opportunity, Lead];

				
				
				
				/*End of lead irn*/
				
				
				
				
				
				
				
				
				
				
				 
			
				
				/*Getting  WorkItemId*/
				QueryResult workItemId = connection.query("SELECT UCP_Work_Item_ID__c FROM Opportunity where irn__c = '"+ irn + "'");
				Opportunity opportunity_WorkItemID = (Opportunity) workItemId.getRecords()[0];
				System.out.println("workItemId-------------------: " + opportunity_WorkItemID.getUCP_Work_Item_ID__c());
				iwdConnection.getAllTasks(opportunity_WorkItemID.getUCP_Work_Item_ID__c());
				/*End of Getting  WorkItemId*/
				
			} catch (ConnectionException ce) {
				ce.printStackTrace();
			
	}
}
	public static void main(String[] args) {
		try{
		connect("samuel.parkertu20161025122938@testqaapollo.com");
	}catch(Exception exception){
		exception.printStackTrace();
	}
}
}
