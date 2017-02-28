package com.generalprograms;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Fibonacci {
	
	 public static List<String> list = new ArrayList<String>();
	    
	    
	    public static void main(String args[]){
	    String input = "a l.b n.c k.";
	    String[] arr = input.split("\\.");// there should be any digits
	   
	    
	    
	    for(int i=0;i<arr.length;i++){
	    	
	    	list = reverse(arr[i]);
	    	

	    }
	    for ( String string : list) {
			System.out.println("========"+string);
		}
	}
	    
	    public static List<String> reverse(String str){
	    	String[] arr2 = str.split(" ");
	    	//System.out.println(arr2.length);
	    	
	    	
	    	for(int j =arr2.length;j>0;j--){
	    		//System.out.println(arr2[j-1]);
	    		//list.add(" ");
	    		list.add(arr2[j-1]);
	    		//System.out.println(list.get(j-1));
	    		
	    	}
	    	return list;
	    }
	
}

