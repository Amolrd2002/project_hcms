package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LeaveApprovals")
public class LeaveApproval {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int approvalId;

	private LocalDate ApproverDate;

	private String status;

	private String comments;

	@ManyToOne
	private LeaveRequest leaveRequest;

	public LeaveApproval() {

	}

	public LeaveApproval(int approvalId, LocalDate approverDate, String status, String comments,
			LeaveRequest leaveRequest) {

		this.approvalId = approvalId;
		ApproverDate = approverDate;
		this.status = status;
		this.comments = comments;
		this.leaveRequest = leaveRequest;
	}

	public int getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public LocalDate getApproverDate() {
		return ApproverDate;
	}

	public void setApproverDate(LocalDate approverDate) {
		ApproverDate = approverDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LeaveRequest getLeaveRequest() {
		return leaveRequest;
	}

	public void setLeaveRequest(LeaveRequest leaveRequest) {
		this.leaveRequest = leaveRequest;
	}

	@Override
	public String toString() {
		return "LeaveApproval [approvalId=" + approvalId + ", ApproverDate=" + ApproverDate + ", status=" + status
				+ ", comments=" + comments + ", leaveRequest=" + leaveRequest + "]";
	}

}
