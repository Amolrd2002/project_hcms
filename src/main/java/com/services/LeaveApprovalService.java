package com.services;

import java.util.List;
import com.entity.LeaveApprovals;
public interface LeaveApprovalService {

	List<LeaveApprovals> getAllLeaveApproval();

	void addLeaveApproval(LeaveApprovals leaveApproval);
	
	void updateLeaveApproval(LeaveApprovals leaveApproval);

	LeaveApprovals deleteLeaveApproval(int leaveApprovalId);

	LeaveApprovals getLeaveApprovalById(int leaveApprovalId);
	
}
