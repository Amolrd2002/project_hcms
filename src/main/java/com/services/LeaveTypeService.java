package com.services;

import java.util.List;


import com.entity.LeaveTypes;



public interface LeaveTypeService {

	List<LeaveTypes> getAllLeaveType();

	void addLeaveType(LeaveTypes leaveType);
	
	void updateLeaveType(LeaveTypes leaveType);

	LeaveTypes deleteLeaveType(int leaveTypeId);

	LeaveTypes getLeaveTypeById(int leaveTypeId);
	
}
