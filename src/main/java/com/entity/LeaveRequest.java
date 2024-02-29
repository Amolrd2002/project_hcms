package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LeaveRequests")
public class LeaveRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveRequestId;

	private LocalDate startDate;

	private LocalDate endDate;

	private String leaveReason;

	private String status;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private LeaveType LeaveType;

	public LeaveRequest() {

	}

	public LeaveRequest(int leaveRequestId, LocalDate startDate, LocalDate endDate, String leaveReason, String status,
			Employee employee, com.entity.LeaveType leaveType) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveReason = leaveReason;
		this.status = status;
		this.employee = employee;
		LeaveType = leaveType;
	}

	public int getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeaveType getLeaveType() {
		return LeaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		LeaveType = leaveType;
	}

	@Override
	public String toString() {
		return "LeaveRequest [leaveRequestId=" + leaveRequestId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", leaveReason=" + leaveReason + ", status=" + status + ", employee=" + employee + ", LeaveType="
				+ LeaveType + "]";
	}

}
