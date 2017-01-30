package com.lms.restservice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class RestCall {
	public static void main(String[] args) {
		String string = "";
		try {
 
			// Step1: Let's 1st read file from fileSystem
			// Change JSON.txt path here
			InputStream InputStream = new FileInputStream("C:\\Users\\gmittal\\Desktop\\json.txt");
			InputStreamReader Reader = new InputStreamReader(InputStream);
			BufferedReader br = new BufferedReader(Reader);
			String line;
			while ((line = br.readLine()) != null) {
				string += line + "\n";
			}
 
		//	JSONObject jsonObject = new JSONObject(string);
			//System.out.println(jsonObject);
 
			// Step2: Now pass JSON File Data to REST Service
			
			//https://docs.oracle.com/middleware/1212/wls/RESTF/develop-restful-client.htm#RESTF166
			try {
				/*Client client = Client.create();
				 WebResource webResource = 
                     client.resource("https://st-coreplatform.apollogrp.edu/servicegateway/rest/rm/v1/leadmanagement");
				 
				 webResource.header("x-apollo-assertion", "eyJpdiI6InlUSUhKalhFUHNHaitweEo1TkJxY1E9PSIsImVuY3J5cHRlZCI6Ijk3RDcwUThrZFowRGdQTDZpSVlMT3IvNy9WakpPcnorc3g0OFZoV25KczdiV0VCemVQT1JVTnFNTXVjVWxLdDJ3TUd1QkY3elJTWVJDQnc4TERmcFNDM1luaGl6bXhOM05wUXREd2J0Tjk5bVEyWnRlc2JmbU9lajNGNG5VSFVsT1llWlBDR1FGcjRORi85a2hlK2ZIakphUk45cTk2clQ5WlFMR29uRThFSTdJbHZUbWNGRkhweUxOYlFnbGl6clg3MXhoenVJRGJQS1gvdU1vMGZxMzExQWRicGFUM1hLNGQySHMxcWFIT0JxdXVmUVhZcm5TS2RCcytjbVBpa2lrdHN4blRTQ1B4eUpMb1pQZmFZeDNYQVdnM1QveFVBbFArdWtLdFF2WVBmaEl4Y3NFclY1N2R6QjMyak4ybExJbitoWlI2cm50emFNazdGOUtWQmtrV1VHOVlWTFJwSkpETzBMMExTaVlEYWdkejNXY3kySm5iUE5sWG1hcGl2cmxJYmVrVms0RjdUTFJKMmhnRWNNVDJvZGpQN0RWQlpvRjhIcU90T1JhRjVTdjNqbktKeGQyVEY5QUFQU21LamRMemxCM0pYQXM3blduQ1NVU0RHTjNKNW5Eemp6bEsvbWFZSFcyWkM2Y3FFd0ZMeHQ0RTdQbmJwWHN6dk44R0hxbmI0bVNsQXNHcTBGQ2VlWmZkeWlXSlZIRjFiZDBYL2t4dEFJSzloMUNJd2dRZUMzRXRVUlUrczlZYVBmUmFhSk5ZbkpRcjNkTnJHdzB5WlErY1VFRytOSVZFSVJ0NVAxaXF2NHAzeDNHUi80aVlCd3RrZ25jMmk1SjJaUnZISHk2SU1ubGhyYjVhYVZMTEZuQ2RyZUFmVTNOOXM5Nm41dEFKZDJZeE9tL2tFPSJ9"); 
				*/ 
			//	 Client cc = ClientBuilder.newClient();
				 
		       // cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		    //    cc.getProperties().put("x-apollo-assertion", "eyJpdiI6InlUSUhKalhFUHNHaitweEo1TkJxY1E9PSIsImVuY3J5cHRlZCI6Ijk3RDcwUThrZFowRGdQTDZpSVlMT3IvNy9WakpPcnorc3g0OFZoV25KczdiV0VCemVQT1JVTnFNTXVjVWxLdDJ3TUd1QkY3elJTWVJDQnc4TERmcFNDM1luaGl6bXhOM05wUXREd2J0Tjk5bVEyWnRlc2JmbU9lajNGNG5VSFVsT1llWlBDR1FGcjRORi85a2hlK2ZIakphUk45cTk2clQ5WlFMR29uRThFSTdJbHZUbWNGRkhweUxOYlFnbGl6clg3MXhoenVJRGJQS1gvdU1vMGZxMzExQWRicGFUM1hLNGQySHMxcWFIT0JxdXVmUVhZcm5TS2RCcytjbVBpa2lrdHN4blRTQ1B4eUpMb1pQZmFZeDNYQVdnM1QveFVBbFArdWtLdFF2WVBmaEl4Y3NFclY1N2R6QjMyak4ybExJbitoWlI2cm50emFNazdGOUtWQmtrV1VHOVlWTFJwSkpETzBMMExTaVlEYWdkejNXY3kySm5iUE5sWG1hcGl2cmxJYmVrVms0RjdUTFJKMmhnRWNNVDJvZGpQN0RWQlpvRjhIcU90T1JhRjVTdjNqbktKeGQyVEY5QUFQU21LamRMemxCM0pYQXM3blduQ1NVU0RHTjNKNW5Eemp6bEsvbWFZSFcyWkM2Y3FFd0ZMeHQ0RTdQbmJwWHN6dk44R0hxbmI0bVNsQXNHcTBGQ2VlWmZkeWlXSlZIRjFiZDBYL2t4dEFJSzloMUNJd2dRZUMzRXRVUlUrczlZYVBmUmFhSk5ZbkpRcjNkTnJHdzB5WlErY1VFRytOSVZFSVJ0NVAxaXF2NHAzeDNHUi80aVlCd3RrZ25jMmk1SjJaUnZISHk2SU1ubGhyYjVhYVZMTEZuQ2RyZUFmVTNOOXM5Nm41dEFKZDJZeE9tL2tFPSJ9");
		       
			//	 WebResource webResource = client.resource("https://st-coreplatform.apollogrp.edu/servicegateway/rest/rm/v1/leadmanagement");
				// webResource.
				 //String response = webResource.get(String.class);
				URL url = new URL("https://st-coreplatform.apollogrp.edu/servicegateway/rest/rm/v1/leadmanagement");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("x-apollo-transaction-id", "eyJpdiI6InlUSUhKalhFUHNHaitweEo1TkJxY1E9PSIsImVuY3J5cHRlZCI6Ijk3RDcwUThrZFowRGdQTDZpSVlMT3IvNy9WakpPcnorc3g0OFZoV25KczdiV0VCemVQT1JVTnFNTXVjVWxLdDJ3TUd1QkY3elJTWVJDQnc4TERmcFNDM1luaGl6bXhOM05wUXREd2J0Tjk5bVEyWnRlc2JmbU9lajNGNG5VSFVsT1llWlBDR1FGcjRORi85a2hlK2ZIakphUk45cTk2clQ5WlFMR29uRThFSTdJbHZUbWNGRkhweUxOYlFnbGl6clg3MXhoenVJRGJQS1gvdU1vMGZxMzExQWRicGFUM1hLNGQySHMxcWFIT0JxdXVmUVhZcm5TS2RCcytjbVBpa2lrdHN4blRTQ1B4eUpMb1pQZmFZeDNYQVdnM1QveFVBbFArdWtLdFF2WVBmaEl4Y3NFclY1N2R6QjMyak4ybExJbitoWlI2cm50emFNazdGOUtWQmtrV1VHOVlWTFJwSkpETzBMMExTaVlEYWdkejNXY3kySm5iUE5sWG1hcGl2cmxJYmVrVms0RjdUTFJKMmhnRWNNVDJvZGpQN0RWQlpvRjhIcU90T1JhRjVTdjNqbktKeGQyVEY5QUFQU21LamRMemxCM0pYQXM3blduQ1NVU0RHTjNKNW5Eemp6bEsvbWFZSFcyWkM2Y3FFd0ZMeHQ0RTdQbmJwWHN6dk44R0hxbmI0bVNsQXNHcTBGQ2VlWmZkeWlXSlZIRjFiZDBYL2t4dEFJSzloMUNJd2dRZUMzRXRVUlUrczlZYVBmUmFhSk5ZbkpRcjNkTnJHdzB5WlErY1VFRytOSVZFSVJ0NVAxaXF2NHAzeDNHUi80aVlCd3RrZ25jMmk1SjJaUnZISHk2SU1ubGhyYjVhYVZMTEZuQ2RyZUFmVTNOOXM5Nm41dEFKZDJZeE9tL2tFPSJ9");
		        
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
			
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				//con.set
				
				 OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				//out.write(jsonObject.toString());
				out.close();
 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
				while (in.readLine() != null) {
				}
				System.out.println("\n REST Service Invoked Successfully..");
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling  REST Service");
				System.out.println(e);
			}
 
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


