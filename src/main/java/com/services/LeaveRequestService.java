package com.services;

import java.util.List;
import com.entity.LeaveRequests;
public interface LeaveRequestService {

	List<LeaveRequests> getAllLeaveRequests();

	void addLeaveRequests(LeaveRequests leaveRequest);
	
	void updateLeaveRequests(LeaveRequests leaveRequest);

	LeaveRequests deleteLeaveRequest(int leaveRequestId);

	LeaveRequests getLeaveRequestById(int leaveRequestId);
	
}
