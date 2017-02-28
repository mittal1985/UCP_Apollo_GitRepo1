package com.generalprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	
	
	
public static void main(String[] args) {
	
	FileWriter output = null;
	try{
		
		String str = "C:\\Users\\gmittal\\workspace_juno\\UCPQualTransfer_SmokeTest\\result\\Result_13_39_25_UCP";
		int res =(str.indexOf("Result"));
		System.out.println(str.subSequence(res, res+19));
		
		
}catch(Exception exception){
	exception.printStackTrace();
}
}
}
