package com.apollo.irnworkItemStatus;

public class IRN_WorkItemStatus {
	private String irn ="";
	private String workItemStatus="";
	private String workItemId="";
	
	
	public String getIrn() {
		return irn;
	}
	public String getWorkItemId() {
		return workItemId;
	}
	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}
	public void setIrn(String irn) {
		this.irn = irn;
	}
	public String getWorkItemStatus() {
		return workItemStatus;
	}
	public void setWorkItemStatus(String workItemStatus) {
		this.workItemStatus = workItemStatus;
	}

}
