package com.lms.restservice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.apollo.salesforceconnection.SalesforceConnect;
import com.lms.assertiongeneration.GenerateAssertion;



public class Test_Working {
	
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
			 postRequest = new HttpPost("https://st-coreplatform.apollogrp.edu/servicegateway/rest/rm/v1/leadmanagement");
			
			
			
			
			 assertion = new GenerateAssertion();
			
			postRequest.setHeader("x-apollo-assertion", assertion.generateAssert());
			//HttpResponse response = httpClient.execute(postRequest);
			
			
			headerArray  =postRequest.getAllHeaders();
			for (Header header : headerArray) {
				System.out.println(header.getName()+"---------------"+header.getValue());
			}
			
			
			inputStream = new FileInputStream("C:\\Users\\gmittal\\Desktop\\json1.txt");
			 inputStreamReader = new InputStreamReader(inputStream);
			 bufferedReader = new BufferedReader(inputStreamReader);
		
			while ((line = bufferedReader.readLine()) != null) {
				string += line + "\n";
			}
			 input = new StringEntity(string);
			input.setContentType("application/json");
			postRequest.setEntity(input);
			
			response = httpClient.execute(postRequest);
			reader = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

	
	System.out.println("Output from Server .... \n");
	while ((output = reader.readLine()) != null) {
		System.out.println(output);
		int irnIndex = output.split("irn").length;
		arr= output.split("irn");
		irnGenerated=arr[1].substring(irnIndex+1, irnIndex+11);
		System.out.println("irn------>"+arr[1].substring(irnIndex+1, irnIndex+11));
	}
	
		
		}catch(Exception exception){
    	exception.printStackTrace();
    }
		salesforceConnect(irnGenerated);
}
	
	public static void salesforceConnect(String irn) {
		try {
			salesforceConnect = new SalesforceConnect();
			salesforceConnect.connect(irn);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
