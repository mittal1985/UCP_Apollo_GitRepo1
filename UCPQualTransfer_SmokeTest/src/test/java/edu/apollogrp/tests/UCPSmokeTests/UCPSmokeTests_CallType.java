package edu.apollogrp.tests.UCPSmokeTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.apollo.agentscripting.er_inboundcall.ERInbound_CallType;

public class UCPSmokeTests_CallType {
	WebDriver driver = null;
	QualTransfer_CallType qualTransfer_AgentScript_QAEnv = null;
	ERInbound_CallType erInbound_AgentScript_QAEnv=null;
	
	
	@Test(priority=0)
	public void erInboundCall(){
		
		try{
			erInbound_AgentScript_QAEnv=new ERInbound_CallType();
			erInbound_AgentScript_QAEnv.setUp();
		
	}catch(Exception exception){
		System.out.println("exception in erInboundCall ");
		
	}

	}
	
	@Test(priority=1)
	public void qualficationTransfer(){
		try{
			qualTransfer_AgentScript_QAEnv = new QualTransfer_CallType();
			qualTransfer_AgentScript_QAEnv.setUp();
	}catch(Exception exception){
		System.out.println("exception in qualficationTransfer");
	}
	}
	
	
	
	
	
	
	
}
