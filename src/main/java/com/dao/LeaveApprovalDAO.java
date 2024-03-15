package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.LeaveApprovals;


public interface LeaveApprovalDAO {

	List<LeaveApprovals> getAllLeaveApproval();

	void addLeaveApproval(LeaveApprovals leaveApproval);
	
	void updateLeaveApproval(LeaveApprovals leaveApproval);

	LeaveApprovals deleteLeaveApproval(int leaveApprovalId);

	LeaveApprovals getLeaveApprovalById(int leaveApprovalId);
	
}
