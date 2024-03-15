package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.LeaveRequests;


public interface LeaveRequestDAO {

	List<LeaveRequests> getAllLeaveRequests();

	void addLeaveRequests(LeaveRequests leaveRequest);
	
	void updateLeaveRequests(LeaveRequests leaveRequest);

	LeaveRequests deleteLeaveRequest(int leaveRequestId);

	LeaveRequests getLeaveRequestById(int leaveRequestId);
	
}
