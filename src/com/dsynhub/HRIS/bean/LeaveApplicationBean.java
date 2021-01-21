package com.dsynhub.HRIS.bean;

public class LeaveApplicationBean {

	private int leaveApplicationId;
	private int employeeId;
	private String employeeFirstName;
	private String leaveName;
	private int leaveId;
	private String leaveStartDate;
	private int leaveDays;
	private String discription;
	private int isActive;
	private String dateOfApplication;
	private String dateOfLastUpdate;
	
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getLeaveName() {
		return leaveName;
	}
	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}
	public int getLeaveApplicationId() {
		return leaveApplicationId;
	}
	public void setLeaveApplicationId(int leaveApplicationId) {
		this.leaveApplicationId = leaveApplicationId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public int getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getDateOfApplication() {
		return dateOfApplication;
	}
	public void setDateOfApplication(String dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}
	public String getDateOfLastUpdate() {
		return dateOfLastUpdate;
	}
	public void setDateOfLastUpdate(String dateOfLastUpdate) {
		this.dateOfLastUpdate = dateOfLastUpdate;
	}
	
	
	
	
	
	
}
