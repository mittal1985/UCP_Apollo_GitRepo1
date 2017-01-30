package com.lms.restservice;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test_HeadersinURL {
	public static void main(String[] args) {
		try{
		URL url = new URL("https://st-coreplatform.apollogrp.edu/servicegateway/rest/rm/v1/leadmanagement");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("x-apollo-assertion", "eyJpdiI6InlUSUhKalhFUHNHaitweEo1TkJxY1E9PSIsImVuY3J5cHRlZCI6Ijk3RDcwUThrZFowRGdQTDZpSVlMT3IvNy9WakpPcnorc3g0OFZoV25KczdiV0VCemVQT1JVTnFNTXVjVWxLdDJ3TUd1QkY3elJTWVJDQnc4TERmcFNDM1luaGl6bXhOM05wUXREd2J0Tjk5bVEyWnRlc2JmbU9lajNGNG5VSFVsT1llWlBDR1FGcjRORi85a2hlK2ZIakphUk45cTk2clQ5WlFMR29uRThFSTdJbHZUbWNGRkhweUxOYlFnbGl6clg3MXhoenVJRGJQS1gvdU1vMGZxMzExQWRicGFUM1hLNGQySHMxcWFIT0JxdXVmUVhZcm5TS2RCcytjbVBpa2lrdHN4blRTQ1B4eUpMb1pQZmFZeDNYQVdnM1QveFVBbFArdWtLdFF2WVBmaEl4Y3NFclY1N2R6QjMyak4ybExJbitoWlI2cm50emFNazdGOUtWQmtrV1VHOVlWTFJwSkpETzBMMExTaVlEYWdkejNXY3kySm5iUE5sWG1hcGl2cmxJYmVrVms0RjdUTFJKMmhnRWNNVDJvZGpQN0RWQlpvRjhIcU90T1JhRjVTdjNqbktKeGQyVEY5QUFQU21LamRMemxCM0pYQXM3blduQ1NVU0RHTjNKNW5Eemp6bEsvbWFZSFcyWkM2Y3FFd0ZMeHQ0RTdQbmJwWHN6dk44R0hxbmI0bVNsQXNHcTBGQ2VlWmZkeWlXSlZIRjFiZDBYL2t4dEFJSzloMUNJd2dRZUMzRXRVUlUrczlZYVBmUmFhSk5ZbkpRcjNkTnJHdzB5WlErY1VFRytOSVZFSVJ0NVAxaXF2NHAzeDNHUi80aVlCd3RrZ25jMmk1SjJaUnZISHk2SU1ubGhyYjVhYVZMTEZuQ2RyZUFmVTNOOXM5Nm41dEFKZDJZeE9tL2tFPSJ9");
        Map<String, List<String>> headers = urlConnection.getHeaderFields();
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            System.out.println("Header Name:" + headerName);
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                System.out.print("Header value:" + value);
            }
            System.out.println();
        }
    }catch(Exception exception){
    	exception.printStackTrace();
    }
	
}}
