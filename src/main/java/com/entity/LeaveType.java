package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="LeaveType")
public class LeaveType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveTypeId;
	
	private String leaveTypeName;
	
	private String description;
	
	public LeaveType() {
		
	}

	public LeaveType(int leaveTypeId, String leaveTypeName, String description) {
		
		this.leaveTypeId = leaveTypeId;
		this.leaveTypeName = leaveTypeName;
		this.description = description;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LeaveType [leaveTypeId=" + leaveTypeId + ", leaveTypeName=" + leaveTypeName + ", description="
				+ description + "]";
	}
	
}
