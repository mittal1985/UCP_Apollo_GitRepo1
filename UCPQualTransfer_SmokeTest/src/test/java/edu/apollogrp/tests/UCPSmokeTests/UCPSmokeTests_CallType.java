package edu.apollogrp.tests.UCPSmokeTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.apollo.agentscripting.ac_inboundcall.ACInbound_CallType;
import com.apollo.agentscripting.er_inboundcall.ERInbound_CallType;
import com.apollo.agentscripting.fa_inboundcall.FAInbound_CallType;
import com.apollo.agentscripting.qcinboundcall.QCInbound_CallBack;

import edu.apollogrp.tests.InternalTransfer.InternalTransfer_ER_FA;

public class UCPSmokeTests_CallType {
	WebDriver driver = null;
	QualTransfer_CallType qualTransfer_AgentScript_QAEnv = null;
	ERInbound_CallType erInbound_AgentScript_QAEnv=null;
	ACInbound_CallType acInbound_AgentScript_QAEnv=null;
	FAInbound_CallType faInbound_AgentScript_QAEnv=null;
	QCInbound_CallBack qcInbound_AgentScript_QAEnv=null;
	InternalTransfer_ER_FA internalTransfer_ER_FA=null;
	
	@Test(priority=0)
	public void erInboundCall(){
		
		try{
			erInbound_AgentScript_QAEnv=new ERInbound_CallType();
			erInbound_AgentScript_QAEnv.ga_setUp();
		
	}catch(Exception exception){
		System.out.println("exception in erInboundCall ");
		
	}

	}
	
	
	@Test(priority=1)
	public void acInboundCall(){
		
		try{
			acInbound_AgentScript_QAEnv=new ACInbound_CallType();
			acInbound_AgentScript_QAEnv.ga_setUp();
		
	}catch(Exception exception){
		System.out.println("exception in acInboundCall ");
		
	}

	}
	
	@Test(priority=2)
	public void faInboundCall(){
		
		try{
			faInbound_AgentScript_QAEnv=new FAInbound_CallType();
			faInbound_AgentScript_QAEnv.ga_setUp();
		
	}catch(Exception exception){
		System.out.println("exception in acInboundCall ");
		
	}

	}
	
	
	@Test(priority=3)
	public void qcInboundCall(){
		
		try{
			qcInbound_AgentScript_QAEnv=new QCInbound_CallBack();
			qcInbound_AgentScript_QAEnv.setUp();
		
	}catch(Exception exception){
		System.out.println("exception in acInboundCall ");
		
	}

	}
	
	@Test(priority=4)
	public void internalTransferCall(){
		
		try{
			internalTransfer_ER_FA=new InternalTransfer_ER_FA();
			internalTransfer_ER_FA.setUp();
		
	}catch(Exception exception){
		System.out.println("exception in internal transfer Call ");
		
	}

	}
	
	@Test(priority=5)
	public void qualficationTransfer(){
		try{
			qualTransfer_AgentScript_QAEnv = new QualTransfer_CallType();
			qualTransfer_AgentScript_QAEnv.setUp();
	}catch(Exception exception){
		System.out.println("exception in qualficationTransfer");
	}
	}
	
	
	
	
	
	
	
}
