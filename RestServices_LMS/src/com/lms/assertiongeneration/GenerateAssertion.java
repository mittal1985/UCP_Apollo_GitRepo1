package com.lms.assertiongeneration;


import javax.net.ssl.TrustManager;

import org.apache.http.conn.ssl.SSLSocketFactory;

import edu.apollogrp.test.client.HttpsClientFactory;
import edu.apollogrp.test.client.cas.CasClient;
import edu.apollogrp.test.client.sso.ApolloSsoClient;

public class GenerateAssertion {
	String apolloAssertion =null;
	public String generateAssert() {
		String username = "lggreer" ;//context.expand( '${DataSource_metis#StUsername}' )
		String password = "Welcome1"; //context.expand( '${DataSource_metis#password}' )
		try{
	
	TrustManager[] trustManagers = HttpsClientFactory.createTautologicalTrustManagers();
	SSLSocketFactory sslSocketFactory = HttpsClientFactory.createHttpClientSslSocketFactory(null, trustManagers);
	
	CasClient casClient = new CasClient();
	casClient.setBaseUrl("https://cas2.qaapollogrp.edu/cas");
	casClient.setSslSocketFactory(sslSocketFactory);
	
	ApolloSsoClient ssoClient = new ApolloSsoClient();
	ssoClient.setBaseUrl("https://sso.qaapollogrp.edu/");
	ssoClient.setSslSocketFactory(sslSocketFactory);
	
	String casTGC = casClient.getTgtProgrammatically(username,password);
	apolloAssertion = ssoClient.createAssertionExternal(casTGC, "https://apollogrp--test.cs15.my.salesforce.com/");

	//System.out.println(apolloAssertion);	
	
	}catch(Exception exception){
		exception.printStackTrace();
		
	}return apolloAssertion ;
}
}
