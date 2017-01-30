package com.lms.restservice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.apollo.salesforceconnection.SalesforceConnect;
import com.lms.assertiongeneration.GenerateAssertion;

public class Test_Working_Old {

	
	public static String string = "";
	public static  String irnGenerated="";
	public static  DefaultHttpClient  httpClient = null;
	public static HttpPost postRequest =null;
	public static GenerateAssertion assertion=null;
	public static Header[] headerArray=null;
	public static InputStream inputStream =null;
	public static InputStreamReader inputStreamReader=null;
	public static BufferedReader bufferedReader=null;
	public static String line;
	public static StringEntity input =null;
	public static HttpResponse response =null;
	public static BufferedReader reader=null;
	public static String output;
	public static String[] arr=null;
	public static SalesforceConnect salesforceConnect =null;
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
		try{
			//CloseableHttpClient client = HttpClientBuilder.create().build();
			  httpClient = new DefaultHttpClient();
			 postRequest = new HttpPost("http://awhqsa30.qaapollogrp.edu:8080/process.action?SubmitForm=YES&salutation=Mr.&First_Name=Haa&Last_Name=PPP&Street_Address=1243&Street_Address=124351%2BSOAP%2BSt&City=Anchorage&ContactState=AK&ZipCode=99501&Contact_Country=US&cboAddressType=RES&Citizen=US&Work_Phone_Number_Area_Code=623&Work_Phone_Number=2016204&Email=haa.nnnn2018%40testqaapollo.com&Qualified=Y&Employer2=AT%26T&Program=EDD&AgeRange=21%20and%20over&CreditLevel=0%20to%2023&SourceCode=INET&DetailCode=AD&ForeignCredit=false&highschool=Y&Orga=31&ContactEa=Y&acRepUsername=SFCRISP&tribalFunding=N&contactNow=TRUE&submit=%2B%2B%2B%2B%2BSubmit%2B%2B%2B%2B%2B");
			
			
			
			
			// assertion = new GenerateAssertion();
			
		//	postRequest.setHeader("x-apollo-assertion", assertion.generateAssert());
			//HttpResponse response = httpClient.execute(postRequest);
			
			
			//headerArray  =postRequest.getAllHeaders();
			/*for (Header header : headerArray) {
				System.out.println(header.getName()+"---------------"+header.getValue());
			}*/
			
			
		//	inputStream = new FileInputStream("C:\\Users\\gmittal\\Desktop\\json1.txt");
		//	 inputStreamReader = new InputStreamReader(inputStream);
		//	 bufferedReader = new BufferedReader(inputStreamReader);
		
			//while ((line = bufferedReader.readLine()) != null) {
		//		string += line + "\n";
		//	}
		//	 input = new StringEntity(string);
			//input.setContentType("application/json");
		//	postRequest.setEntity(input);
			
			response = httpClient.execute(postRequest);
			reader = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

	
	System.out.println("Output from Server .... \n");
	while ((output = reader.readLine()) != null) {
		System.out.println(output);
		//int irnIndex = output.split("irn").length;
		//arr= output.split("irn");
		//irnGenerated=arr[1].substring(irnIndex+1, irnIndex+11);
		//System.out.println("irn------>"+arr[1].substring(irnIndex+1, irnIndex+11));
	}
	
	//Select STD_EN_HOLDING_TANK_OID, person_irn,Person_Names_First_Name, Person_Names_Last_Name,Address_home_state_prov, create_status, create_errors, create_date From GALAXY.student_leads	Where create_date > '02-JUN-15' 	order by create_date desc;	
		}catch(Exception exception){
    	exception.printStackTrace();
    }
		//salesforceConnect(irnGenerated);
}
	
	public static void salesforceConnect(String irn) {
		try {
			salesforceConnect = new SalesforceConnect();
			salesforceConnect.connect(irn);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	
	public static void galaxyConnect() {
		
		//http://www.tutorialspoint.com/jdbc/jdbc-db-connections.htm
		
		
		// JDBC driver name and database URL
		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   String DB_URL = "jdbc:mysql://localhost/EMP";

		   //  Database credentials
		   String USER = "username";
		   String PASS = "password";
		   
		   Connection conn = null;
		   Statement stmt = null;
		   
		try {
			//STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT id, first, last, age FROM Employees";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		    //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}


}
