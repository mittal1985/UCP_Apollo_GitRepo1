package com.twilio;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.Dial;
import com.twilio.sdk.verbs.Client;

public class TwilioVoiceServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        TwiMLResponse twiml = new TwiMLResponse();
        Dial dial = new Dial();
        Client client = new Client("jenny");
        try {
            dial.append(client);
            twiml.append(dial);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXML());
    }
}
