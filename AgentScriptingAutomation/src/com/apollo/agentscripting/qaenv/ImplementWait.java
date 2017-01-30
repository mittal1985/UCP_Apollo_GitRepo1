package com.apollo.agentscripting.qaenv;

public class ImplementWait {
public static void main(String[] args) {
	for(int i = 0; i< 10; i++) {
	    try {
	        //sending the actual Thread of execution to sleep X milliseconds
	        Thread.sleep(3000);
	    } catch(Exception e) {
	        System.out.println("Exception : "+e.getMessage());
	    }
	    System.out.println("Hello world!"+System.currentTimeMillis());
	}
}
}
