package com.apollo.old.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.apollo.irnworkItemStatus.IRN_WorkItemStatus;
import com.apollo.salesforceconnection.SalesforceConnect_163;



public class ReadExcel {

	/**
	 * @param args
	 */
	//public void inputData() {
		public static void main(String[] args) {
			
		
		LeadAutomation_163 automation_163=null;
		SalesforceConnect_163 salesforceConnect_163= null;
		IRN_WorkItemStatus irn_WorkItemStatus=null;
		try{
			//String excelFilePath = args[0];
			String excelFilePath = "C:\\Users\\gmittal\\Desktop\\UCP\\UCP\\16.3\\16.3_InputData_LeadCreationJava\\UCP_163Lead_Data.xlsx";
			
			//excelFilePath=excelFilePath.replace("\\", "\\\\");
			String formPath="file:///C:/Users/gmittal/Desktop/URL_16.3_qa.html";
			//String formPath= args[1];
			
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	        FileOutputStream outputStream = null;
	        String pagesource=null;
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	        automation_163= new LeadAutomation_163();
	        salesforceConnect_163= new SalesforceConnect_163();
	       System.out.println("Total number of rows in excel are "+firstSheet.getLastRowNum());
	        for(int count = 1;count<=firstSheet.getLastRowNum();count++){
	        	
	            Row row = firstSheet.getRow(count);
	            if(row.getCell(0)!=null && ((row.getCell(0).getCellType()!=Cell.CELL_TYPE_BLANK))){
	            automation_163.setUp(formPath);
	                      
	           
	            automation_163.clickFirstName(row.getCell(0).toString(),count);
	            
	          
	           automation_163.clickLastName(row.getCell(1).toString());
	            
	             automation_163.clickAddress(row.getCell(2).toString());
	            
	            automation_163.clickCity(row.getCell(3).toString());
	            
	            automation_163.clickState(row.getCell(4).toString());
	            
	            int zipCode = (int)(row.getCell(5).getNumericCellValue());
	            automation_163.clickZipCode(zipCode);
	            
	           if((row.getCell(6)!=null && ((row.getCell(6).getCellType()!=Cell.CELL_TYPE_BLANK))) && ((row.getCell(7)!=null && ((row.getCell(7).getCellType()!=Cell.CELL_TYPE_BLANK))))){
	            int areaCode = (int)(row.getCell(6).getNumericCellValue());
	            automation_163.clickAreaCode(areaCode);
	           
	            int phone = (int)(row.getCell(7).getNumericCellValue());
	            automation_163.clickPhone(phone);
	           }
	            
	            
	            
	            
	            automation_163.clickEmail(row.getCell(8).toString());
	           
	            automation_163.clickProgram(row.getCell(9).toString());
	            
	            automation_163.clickSource(row.getCell(10).toString());
		           
	            automation_163.clickCampaign(row.getCell(11).toString());
	            
	            automation_163.clickNotes(row.getCell(12).toString());
	            
	           
	            pagesource=automation_163.clickSubmit();
	            
	          WebDriver driver = automation_163.getDriver();
	          String folder = automation_163.getFolder();
	            
	            //calling salesforce to get irn
	           
	            irn_WorkItemStatus= salesforceConnect_163.connect(row.getCell(8).toString(),driver,folder);
	           
	            //end of calling salesforce
	            
	            System.out.println("irn_WorkItemStatus-------"+irn_WorkItemStatus.getIrn()+"------------"+irn_WorkItemStatus.getWorkItemStatus());
	            
	            automation_163.tearDown();
	            automation_163.writeInExcel( row , pagesource,irn_WorkItemStatus);
	            
	            inputStream.close();
	            outputStream= new FileOutputStream(excelFilePath);
	            workbook.write(outputStream);
	            outputStream.close();
	            }
	         
	        }
	    }catch(Exception exception){
	    	exception.printStackTrace();
	    }
	}
	

}
