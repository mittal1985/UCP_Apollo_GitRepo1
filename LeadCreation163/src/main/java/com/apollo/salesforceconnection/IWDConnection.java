package com.apollo.salesforceconnection;

import java.io.StringWriter;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.testng.annotations.Test;

public class IWDConnection {
	public static String[] queue=null;
	public static  String workItemStatus="";
	
@Test	
public static String getAllTasks_iwd(String workItemId) {
	 String workItemIdStatus=null;
	try {
		
		//String soapRequest=readFile("C:\\Users\\gmittal\\workspace_juno\\IWDConnection\\SOAPReq.xml");
       System.out.println("====================IWD Connection Starts====================");
		
		// Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = "http://qlaxucwd001.qaapollogrp.edu:8080/iwd_node/services/webserviceCapturePoint";
       SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(workItemId), url);
       
       
      

        // Process the SOAP Response
        workItemIdStatus=printSOAPResponse(soapResponse);
        System.out.println("===================IWD Connection Ends====================");

        soapConnection.close();
    } catch (Exception e) {
        System.err.println("Error occurred while sending SOAP Request to Server");
        e.printStackTrace();
    }
	return workItemIdStatus;
}

private static SOAPMessage createSOAPRequest(String workItemId) throws Exception {
	MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();
    SOAPPart soapPart = soapMessage.getSOAPPart();

    String serverURI = "http://webservice.capture.gtl.evo";

    // SOAP Envelope
    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.addNamespaceDeclaration("web", serverURI);
    
    
    
    
    SOAPBody soapBody = envelope.getBody();
    SOAPElement soapBodyElem = soapBody.addChildElement("getTaskByTaskId", "web");
    SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("taskId", "web");
   //soapBodyElem1.addTextNode("006290000035vdMAAQ");
    
    //Pass workitem id
    soapBodyElem1.addTextNode(workItemId);
    

    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", serverURI  + "getTaskByTaskId");

    soapMessage.saveChanges();
    
    /* Print the request message */
   // System.out.print("Request SOAP Message = ");
   // soapMessage.writeTo(System.out);
   // System.out.println();

    return soapMessage;

}

/**
 * Method used to print the SOAP Response
 */
private static String printSOAPResponse(SOAPMessage soapResponse) throws Exception {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    Source sourceContent = soapResponse.getSOAPPart().getContent();
   // System.out.print("\nResponse SOAP Message = "+sourceContent);
    StreamResult result = new StreamResult(System.out);
    StringWriter stringWriter = new StringWriter();
    transformer.transform(sourceContent, new StreamResult(stringWriter));
    
    String output = stringWriter.toString();
   // System.out.println(output);
    return queueStatus(output);
     
}


/**
 * Method used to get QueueStatus
 */
private static String queueStatus(String finalOutPut) throws Exception {
	
	int irnIndex = finalOutPut.split("<queue").length;
	queue=finalOutPut.split("<queue");
	workItemStatus=queue[1].substring(irnIndex+29, irnIndex+39);
	System.out.println("-------"+workItemStatus);
	return workItemStatus;
}

}
