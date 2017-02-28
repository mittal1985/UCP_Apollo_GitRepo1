package com.twilio;

import com.twilio.twiml.Play;
import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public class DirectInboundCall {
	
	public static void main(String[] args) {
		
	
	 HashMap<String, String> callers = new HashMap<String, String>();
     callers.put("+18473877567", "Shipra");
     callers.put("+14158675310", "Boots");
     callers.put("+14158675311", "Virgil");

    // String fromNumber = request.getParameter("From");
     String knownCaller = callers.get("7145535675");
     String message;
     if (knownCaller == null) {
         // Use a generic message
         message = "Hello Monkey";
     } else {
         // Use the caller's name
         message = "Hello " + knownCaller;
     }

     // Create a TwiML response and add our friendly message.
     VoiceResponse twiml = new VoiceResponse.Builder()
             .say(new Say.Builder(message).build())
             // Play an MP3 for incoming callers.
             .play(new Play.Builder("http://demo.twilio.com/hellomonkey/monkey.mp3").build())
             .build();

    
}
}
