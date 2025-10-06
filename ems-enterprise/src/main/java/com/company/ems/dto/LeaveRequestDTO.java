package com.company.ems.dto;

import java.time.LocalDate;

public class LeaveRequestDTO {
	  private EmployeeDTO employee;
	  private LocalDate fromDate;
	  private LocalDate toDate;
	  private String reason;
	  // getters setters
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	  
	  
	}

	

