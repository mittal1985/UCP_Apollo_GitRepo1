package com.apollo.ga_connection;



import java.net.URI;
import java.util.List;

import com.genesyslab.platform.applicationblocks.com.ConfServiceFactory;
import com.genesyslab.platform.applicationblocks.com.IConfService;
import com.genesyslab.platform.applicationblocks.com.objects.CfgPerson;
import com.genesyslab.platform.applicationblocks.com.objects.CfgSkill;
import com.genesyslab.platform.applicationblocks.com.objects.CfgSkillLevel;
import com.genesyslab.platform.applicationblocks.com.queries.CfgPersonQuery;
import com.genesyslab.platform.applicationblocks.com.queries.CfgSkillQuery;
import com.genesyslab.platform.commons.protocol.Endpoint;
import com.genesyslab.platform.configuration.protocol.ConfServerProtocol;
import com.genesyslab.platform.configuration.protocol.types.CfgAppType;


	public class Connect_GenesysAdmin { 

	   
	    public static CfgSkillLevel assignedSkill;
	    //private IConfService configService;


public static void main(String[] args) {
	try{
	createContact("DP_CSTAC","ucp_acc_wwe2");
	createContact("DP_TAC","ucp_acc_wwe2");
	createContact("TAC_West","ucp_acc_wwe2");
}catch(Exception exception){
	exception.printStackTrace();
}
}

	    public static void createContact(String skill, String username) throws Exception {
	    	
            URI confServerUri = new URI("tcp://qlaxucrf001.qaapollogrp.edu:2020");

            ConfServerProtocol confServerProtocol =  new ConfServerProtocol(new Endpoint(confServerUri));
           confServerProtocol.setClientApplicationType(CfgAppType.CFGSCE.asInteger());
                          
            confServerProtocol.setClientName("default");
            confServerProtocol.setUserName("SvcAccAutomation");
            confServerProtocol.setUserPassword("SvcAccAutomation");
            IConfService confService =  ConfServiceFactory.createConfService(confServerProtocol);
            confServerProtocol.open();


            CfgPersonQuery query = new CfgPersonQuery();
            query.setUserName(username);
            CfgPerson person = (CfgPerson) confService.retrieveObject(CfgPerson.class, query);
         
            
            CfgSkillQuery skillQuery = new CfgSkillQuery();
            skillQuery.setName(skill);
            CfgSkill cfgSkill = (CfgSkill) confService.retrieveObject(CfgSkill.class, skillQuery);

            List<CfgSkillLevel> skillList =  (List<CfgSkillLevel>)person.getAgentInfo().getSkillLevels();

            CfgSkillLevel cfgSkillLevelbkup = skillList.get(0);
            CfgSkillLevel cfgSkillLevel = new CfgSkillLevel(confService,cfgSkillLevelbkup.getParent()); 

            cfgSkillLevel.setSkill(cfgSkill);
            cfgSkillLevel.setLevel(5);
            cfgSkillLevel.setSkillDBID(cfgSkill.getDBID());
            
            skillList.add(cfgSkillLevel);
           
            person.save();
            confServerProtocol.close();
            ConfServiceFactory.releaseConfService(confService);

	    }
	   
	    

	


}
