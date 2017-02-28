package com.twilio;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import com.twilio.sdk.client.TwilioCapability;
import com.twilio.sdk.client.TwilioCapability.DomainException;

public class TwilioServlet extends HttpServlet {

 //   public static final String ACCOUNT_SID = "AC123";
    //public static final String AUTH_TOKEN = "456bef";

    public void service1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	String AccountSid = "ACe47663c56fddbbe9577e82130d8b028e";
		String AuthToken = "2aca7fd3f80a739ca5c25ccaa3149ccf";
		   // Find an application Sid from twilio.com/user/account/apps
        String applicationSid = "AP123456";
        TwilioCapability capability = new TwilioCapability(AccountSid, AuthToken);
        capability.allowClientOutgoing(applicationSid);
        capability.allowClientIncoming("jenny");

        String token = null;
        try {
            token = capability.generateToken();
        } catch (DomainException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        request.setAttribute("token", token);
        RequestDispatcher view = request.getRequestDispatcher("client.jsp");
        view.forward(request, response);
    }
}
