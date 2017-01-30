package com.apollo.ga_connection;



import com.genesyslab.platform.applicationblocks.com.ConfServiceFactory;
import com.genesyslab.platform.applicationblocks.com.IConfService;
import com.genesyslab.platform.applicationblocks.com.objects.CfgPerson;
import com.genesyslab.platform.applicationblocks.com.objects.CfgSkill;
import com.genesyslab.platform.applicationblocks.com.objects.CfgSkillLevel;
import com.genesyslab.platform.applicationblocks.com.queries.CfgPersonQuery;
import com.genesyslab.platform.applicationblocks.com.queries.CfgSkillQuery;
import com.genesyslab.platform.commons.collections.KeyValueCollection;
import com.genesyslab.platform.commons.protocol.Endpoint;
import com.genesyslab.platform.commons.protocol.Message;
import com.genesyslab.platform.configuration.protocol.ConfServerProtocol;
import com.genesyslab.platform.configuration.protocol.confserver.runtime.channel.RequestRegisterClient;
import com.genesyslab.platform.configuration.protocol.types.CfgAppType;
import com.genesyslab.platform.configuration.protocol.types.CfgFlag;
import com.genesyslab.platform.configuration.protocol.types.CfgObjectState;
import com.genesyslab.platform.contacts.protocol.UniversalContactServerProtocol;
import com.genesyslab.platform.contacts.protocol.contactserver.requests.RequestMergeContacts;

import com.genesyslab.platform.openmedia.protocol.InteractionServerProtocol;
import com.genesyslab.platform.openmedia.protocol.interactionserver.InteractionClient;
import com.genesyslab.platform.openmedia.protocol.interactionserver.events.EventPropertiesChanged;

import com.genesyslab.platform.openmedia.protocol.interactionserver.requests.interactionmanagement.RequestSubmit;

import java.net.URI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import javax.xml.bind.JAXBElement;

	import com.genesyslab.platform.configuration.protocol.types.CfgAppType;


	public class Connect_GenesysAdmin { 

	    private String host;
	    private int port;
	    private String userName;
	    private String password;
	    private String clientName;
	    private CfgAppType clientType;
	    public static CfgSkillLevel assignedSkill;
	    //private IConfService configService;


public static void main(String[] args) {
	try{
	createContact();
}catch(Exception exception){
	exception.printStackTrace();
}
}

	    public static String createContact() throws Exception {

	     //   TestConfig testConfig = new TestConfig();
	        URI confServerUri = new URI("tcp://qlaxucrf001.qaapollogrp.edu:2020");

	        ConfServerProtocol confServerProtocol =  new ConfServerProtocol(new Endpoint(confServerUri));
	       confServerProtocol.setClientApplicationType(CfgAppType.CFGSCE.asInteger());
	      //  confServerProtocol.setClientApplicationType();
		      
	        confServerProtocol.setClientName("default");
	        confServerProtocol.setUserName("SvcAccAutomation");
	        confServerProtocol.setUserPassword("SvcAccAutomation");
	        IConfService confService =  ConfServiceFactory.createConfService(confServerProtocol);
	        confServerProtocol.open();


	        //configService.getProtocol().open();
	        //retrieve an agent that has a single skill, with skill level set to 5
	        CfgPersonQuery query = new CfgPersonQuery();
	        //query.setUserName("ucp_ea1");
	        query.setUserName("lggreer");
	        CfgPerson person = (CfgPerson) confService.retrieveObject(CfgPerson.class, query);
	      
	        
	       List<CfgSkillLevel> skillList =      (List<CfgSkillLevel>)person.getAgentInfo().getSkillLevels();
	      
	       for (ListIterator<CfgSkillLevel> iterator = skillList.listIterator(); iterator.hasNext(); ) {

	            assignedSkill = iterator.next();
	            System.out.println(assignedSkill.getSkill().getName());
	            System.out.println(assignedSkill.getLevel());
	          
	         
	            
	        }
	        
	        ListIterator<CfgSkillLevel> iterator = skillList.listIterator();
	        CfgSkill cfgSkill = null;
	        while(iterator.hasNext()){
	        	assignedSkill = iterator.next();
	        	if(assignedSkill.getSkill().getName().toString().equalsIgnoreCase("PA_Business")){
	        	// cfgSkill = new CfgSkill(confService);
	        	// cfgSkill.setName("PA_Education");
	        	 //System.out.println(cfgSkill.getName());
	        	 System.out.println("after");
	             assignedSkill.setLevel(4);
	             //assignedSkill.setSkill(cfgSkill);
	        }
	        }
	       
	       
            
	        person.save();
	        System.out.println(person.getFirstName());

	        confServerProtocol.close();
	        ConfServiceFactory.releaseConfService(confService);
	        //confServerProtocol.close();
	        return "Updated the quota balance successfully.";
	    }
	  /*  
	    @PUT
	        @Path("/UpdateAttachedData")
	        @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	        public String updateAttachedDataContact(JAXBElement<UpdateSkillRequest> skillRequest) throws Exception {

	            TestConfig testConfig = new TestConfig();
	            URI confServerUri = new URI("tcp://deaxcim201.devapollogrp.edu:2020");

	            InteractionServerProtocol interactionServerProtocol =  new InteractionServerProtocol(new Endpoint("InteractionServer", host, port));

	                    interactionServerProtocol.setClientName("EntityListener");
	                    interactionServerProtocol.setClientType(InteractionClient.MediaServer);

	                    KeyValueCollection userData = new KeyValueCollection();
	                    userData.addObject("crmactivityid", activityid);
	                    userData.addObject("crmactivitytype", activitytype);

	                    try
	                    {
	                    interactionServerProtocol.open();
	                    

	                      RequestSubmit requestSubmit = RequestSubmit.Create(
	                       interactionServerProtocol.getProxyId,
	                       null,
	                       null,
	                       inboundQueue,
	                       tenantID,
	                       "crmemail",
	                       "Inbound",
	                       "InboundNew",
	                       true,
	                       new Date(),
	                       userData,
	                       null,
	                       inQueues,
	                       outQueues);

	                      IMessage response = 
	                       interactionServerProtocol.request(requestSubmit);
	                      writeToLog("Response: " + response.Name);
	                    }
	                    catch(Exception exception)
	                    {
	                      writeToLog(
	                       "Exception while sending request to interaction server: "
	                       + exception.Message);
	                    }
	        }
	    
	    
	    
	  private static IConfService getInitialFactory() throws NamingException,
	                                                           URISyntaxException,
	                                                           RegistrationException,
	                                                           ProtocolException,
	                                                           InterruptedException {

	    TestConfig testConfig = new TestConfig();
	    URI confServerUri = new URI("tcp://deaxcim201.devapollogrp.edu:2020");

	    ConfServerProtocol confServerProtocol =
	        new ConfServerProtocol(new Endpoint(confServerUri));
	    confServerProtocol.setClientApplicationType(CfgAppType.CFGSCE.asInteger());
	    confServerProtocol.setClientName("default");
	    confServerProtocol.setUserName("default");
	    confServerProtocol.setUserPassword("password");
	    IConfService confService =
	        ConfServiceFactory.createConfService(confServerProtocol);
	      //confServerProtocol.open();

	      return confService;
	  }
	

	    @GET
	    @Path("/GetPersonSkills")
	    @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public List<AgentSkills> getPersonSkills() throws Exception {

	        TestConfig testConfig = new TestConfig();
	        URI confServerUri = new URI("tcp://deaxcim201.devapollogrp.edu:2020");

	        ConfServerProtocol confServerProtocol =
	            new ConfServerProtocol(new Endpoint(confServerUri));
	        confServerProtocol.setClientApplicationType(CfgAppType.CFGSCE.asInteger());
	        confServerProtocol.setClientName("default");
	        confServerProtocol.setUserName("default");
	        confServerProtocol.setUserPassword("password");
	        IConfService confService =
	            ConfServiceFactory.createConfService(confServerProtocol);
	        confServerProtocol.open();

	        CfgSkillQuery skillQuery = new CfgSkillQuery();
	        skillQuery.setName("XFER_QuotaBalance");
	        CfgSkill skill =
	            confService.retrieveObject(CfgSkill.class, skillQuery);


	        //retrieve an agent that has a single skill, with skill level set to 5
	        CfgPersonQuery query = new CfgPersonQuery();
	        query.setSkillDbid(skill.getDBID());
	        //List<CfgPerson> agentList = (List<CfgPerson>)query.execute();
	        List<CfgPerson> agentList =
	            (List<CfgPerson>)confService.retrieveMultipleObjects(CfgPerson.class,
	                                                                 query);
	        List<AgentSkills> agentSkillList = new ArrayList<AgentSkills>();
	        System.out.println(agentList.size());
	        for (ListIterator<CfgPerson> personIterator = agentList.listIterator();
	             personIterator.hasNext(); ) {

	            CfgPerson assignedAgent = personIterator.next();
	            AgentSkills agentInfo = new AgentSkills();
	            agentInfo.setAgentId(assignedAgent.getUserName());
	            agentInfo.setAgentFirstName(assignedAgent.getFirstName());
	            agentInfo.setAgentLastName(assignedAgent.getLastName());
	            List<CfgSkillLevel> skillList =
	                (List<CfgSkillLevel>)assignedAgent.getAgentInfo().getSkillLevels();

	            Integer agentQuota = 0;

	            for (ListIterator<CfgSkillLevel> iterator =
	                 skillList.listIterator(); iterator.hasNext(); ) {

	                CfgSkillLevel assignedSkill = iterator.next();
	                //String skillName = assignedSkill.getSkill().getName().toString();
	                if(assignedSkill.getSkill().getName().equalsIgnoreCase("XFER_Quota")){
	                  agentInfo.setTransferQuota(assignedSkill.getLevel());
	                } else if
	                (assignedSkill.getSkill().getName().equalsIgnoreCase("XFER_QuotaBalance")){
	                  agentInfo.setTransferQuotaBalance(assignedSkill.getLevel());
	                }else if
	                (assignedSkill.getSkill().getName().equalsIgnoreCase("XFER_Proficiency")){
	                  agentInfo.setProficiency(assignedSkill.getLevel());
	                }
	                
	            }
	          agentSkillList.add(agentInfo);
	            //assignedAgent.save();
	        }
	        confServerProtocol.close();
	      ConfServiceFactory.releaseConfService(confService);
	        return agentSkillList;
	    }

	  @PUT
	  @Path("/UpdateAgentSkills")
	  @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public String updateAgentSkills(JAXBElement<AgentSkillsList> agentSkillsRequest) throws Exception {

	      TestConfig testConfig = new TestConfig();
	      URI confServerUri = new URI("tcp://deaxcim201.devapollogrp.edu:2020");

	      ConfServerProtocol confServerProtocol =
	          new ConfServerProtocol(new Endpoint(confServerUri));
	      confServerProtocol.setClientApplicationType(CfgAppType.CFGSCE.asInteger());
	      confServerProtocol.setClientName("default");
	      confServerProtocol.setUserName("default");
	      confServerProtocol.setUserPassword("password");
	      IConfService confService =
	          ConfServiceFactory.createConfService(confServerProtocol);
	      confServerProtocol.open();

	      List<AgentSkills> agentList =   agentSkillsRequest.getValue().getAgentSkills();
	    for (ListIterator<AgentSkills> agentIterator = agentList.listIterator();
	         agentIterator.hasNext(); )
	      {
	        AgentSkills agentSkill = agentIterator.next();
	        
	        CfgPersonQuery query = new CfgPersonQuery();
	        //query.setUserName("ucp_ea1");
	        query.setUserName(agentSkill.getAgentId());
	        CfgPerson person = confService.retrieveObject(CfgPerson.class, query);
	        List<CfgSkillLevel> skillList =
	            (List<CfgSkillLevel>)person.getAgentInfo().getSkillLevels();
	        for (ListIterator<CfgSkillLevel> iterator = skillList.listIterator();
	             iterator.hasNext(); ) {
	  
	            CfgSkillLevel assignedSkill = iterator.next();
	          if(assignedSkill.getSkill().getName().equalsIgnoreCase("XFER_Quota")){
	            assignedSkill.setLevel(agentSkill.getTransferQuota());
	          } else if
	          (assignedSkill.getSkill().getName().equalsIgnoreCase("XFER_QuotaBalance")){
	            assignedSkill.setLevel(agentSkill.getTransferQuotaBalance());
	          }else if
	          (assignedSkill.getSkill().getName().equalsIgnoreCase("XFER_Proficiency")){
	            assignedSkill.setLevel(agentSkill.getProficiency());
	          }
	            
	        }
	        person.save();
	        System.out.println(person.getFirstName());
	      }
	      confServerProtocol.close();
	      ConfServiceFactory.releaseConfService(confService);
	      //confServerProtocol.close();
	      return "The agent Skills have been updated successfully.";
	  }

	    @PUT
	    @Path("/CreateAgentAccount")
	    @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public String createAgentAccount(JAXBElement<Person> createPersonRequest) throws Exception {

	        TestConfig testConfig = new TestConfig();
	        URI confServerUri = new URI("tcp://deaxcim201.devapollogrp.edu:2020");

	        ConfServerProtocol confServerProtocol =
	            new ConfServerProtocol(new Endpoint(confServerUri));
	        confServerProtocol.setClientApplicationType(CfgAppType.CFGSCE.asInteger());
	        confServerProtocol.setClientName("default");
	        confServerProtocol.setUserName("default");
	        confServerProtocol.setUserPassword("Apollo2014");
	        IConfService confService =
	            ConfServiceFactory.createConfService(confServerProtocol);
	        confServerProtocol.open();
	        
	        try{
	        System.out.println("Starting user creation");
	        CfgPerson personNew = new CfgPerson(confService);
	        //CfgPersonQuery query = new CfgPersonQuery();
	        
	        //query.setUserName("ademo1");
	        //CfgPerson person = confService.retrieveObject(CfgPerson.class, query);
	        //person.getRawObjectData();
	        //personNew.getConfigurationService().createObject(person.getRawObjectData(), true);
	        //CfgPerson personNew = (CfgPerson)confService.createObject(person.getRawObjectData(), true);
	        System.out.println("Initialized");
	        //CfgPerson personNew = (CfgPerson)person.clone();
	        //CfgID cID = new CfgID(confService, personNew);
	        //System.out.println("New DBID is"+cID.getDBID());
	        //personNew.setDBID(cID.getDBID());
	       
	        System.out.println("Username is"+createPersonRequest.getValue().getAgentUserName());
	        
	          
	          //CfgPerson(confService,Person.class,true);
	          //personNew.getProperty(arg0);
	          //person.setDBID(101);
	          //personNew.setTenantDBID(101);
	         CfgObjectState configState = CfgObjectState.CFGEnabled;
	          
	          personNew.setState(configState);
	          personNew.setUserName(createPersonRequest.getValue().getAgentUserName());
	          personNew.setEmployeeID(createPersonRequest.getValue().getAgentUserName());
	          personNew.setExternalID(createPersonRequest.getValue().getAgentUserName());
	          personNew.setEmailAddress(createPersonRequest.getValue().getAgentEmailAddress());
	          personNew.setFirstName(createPersonRequest.getValue().getAgentFirstName());
	          personNew.setLastName(createPersonRequest.getValue().getAgentLastName());
	          
	          
	        personNew.setUserName("agnair");
	        personNew.setEmployeeID("agnair");
	        personNew.setExternalID("agnair");
	        personNew.setEmailAddress("agnair@apollo.edu");
	        personNew.setFirstName("Anand");
	        personNew.setLastName("Nair");
	        personNew.setIsAgent(CfgFlag.CFGTrue);
	        personNew.save();
	        }
	        catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	        confServerProtocol.close();
	        ConfServiceFactory.releaseConfService(confService);
	        //confServerProtocol.close();
	        return "The agent was created successfully.";
	    }
	    
	    @PUT
	    @Path("/MergeContacts")
	    @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public String mergeContacts(JAXBElement<ContactMerge> mergeContactRequest) throws Exception {


	        String responseMessage = "";
	       
	        UniversalContactServerProtocol ucsProtocol =
	           new UniversalContactServerProtocol(
	             new Endpoint(
	               "UCS_Dev",
	               "deaxema201.devapollogrp.edu",
	               7020));
	        
	        UniversalContactServerProtocol ucsProtocol =
	           new UniversalContactServerProtocol(
	             new Endpoint(
	               "rp_ucs_con_2",
	               "plaxucss032.apollogrp.edu",
	               7205));
	        
	         ucsProtocol.setClientName(clientName);
	         ucsProtocol.open();
	        
	        try{
	        
	            RequestMergeContacts contactMergeReq = new RequestMergeContacts();
	            contactMergeReq.setDestinationContactId(mergeContactRequest.getValue().getContactDestination());
	            contactMergeReq.setSourceContactId(mergeContactRequest.getValue().getContactSource());
	            contactMergeReq.setTenantId(101);
	            contactMergeReq.create();
	            Message respMessage = ucsProtocol.request(contactMergeReq);
	            responseMessage = "The records were merged successfully."+ respMessage.messageId();
	        }
	        catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	        ucsProtocol.close();
	        //ConfServiceFactory.releaseConfService(confService);
	        //confServerProtocol.close();
	        return responseMessage;
	    }


	}

	*/


}
