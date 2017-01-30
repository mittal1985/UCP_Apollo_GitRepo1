package com.apollo.iwdconnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

public class IWDConnection {
public static void main(String[] args) {
	try {
		
		//String soapRequest=readFile("C:\\Users\\gmittal\\workspace_juno\\IWDConnection\\SOAPReq.xml");
       
		
		// Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = "http://qlaxucwd001.qaapollogrp.edu:8080/iwd_node/services/webserviceCapturePoint";
       SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
       
       
      

        // Process the SOAP Response
       printSOAPResponse(soapResponse);

        soapConnection.close();
    } catch (Exception e) {
        System.err.println("Error occurred while sending SOAP Request to Server");
        e.printStackTrace();
    }
}

private static SOAPMessage createSOAPRequest() throws Exception {
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
    soapBodyElem1.addTextNode("060H1HTR14FAR1EA");
    

    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", serverURI  + "getTaskByTaskId");

    soapMessage.saveChanges();
    
    /* Print the request message */
    System.out.print("Request SOAP Message = ");
    soapMessage.writeTo(System.out);
    System.out.println();

    return soapMessage;

}

/**
 * Method used to print the SOAP Response
 */
private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    Source sourceContent = soapResponse.getSOAPPart().getContent();
    System.out.print("\nResponse SOAP Message = ");
    StreamResult result = new StreamResult(System.out);
    transformer.transform(sourceContent, result);
}

private static String readFile(String file) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader (file));
    String         line = null;
    StringBuilder  stringBuilder = new StringBuilder();
    String         ls = System.getProperty("line.separator");

    try {
        while((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    } finally {
        reader.close();
    }
}


}
