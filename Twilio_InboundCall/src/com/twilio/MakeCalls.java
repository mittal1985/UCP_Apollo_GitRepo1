package com.twilio;

import java.net.URI;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.type.PhoneNumber;

import java.net.URI;

public class MakeCalls {
		/* Twilio REST API version */
		public static final String APIVERSION = "2010-04-01";
		public static void main(String[] args){
			try{
		/* Twilio AccountSid and AuthToken */
		String AccountSid = "ACe47663c56fddbbe9577e82130d8b028e";
		String AuthToken = "2aca7fd3f80a739ca5c25ccaa3149ccf";
		 TwilioRestClient client = new TwilioRestClient.Builder(AccountSid, AuthToken).build();

	        PhoneNumber to = new PhoneNumber("7145535675"); // Replace with your phone number
	        PhoneNumber from = new PhoneNumber("(714)312-1403"); // Replace with a Twilio number
	        URI uri = URI.create("http://demo.twilio.com/welcome/voice/");

	        // Make the call
	        Call call = new CallCreator(to, from, uri).create(client);
	        // Print the call SID (a 32 digit hex like CA123..)
	        System.out.println(call.getSid());
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
}
