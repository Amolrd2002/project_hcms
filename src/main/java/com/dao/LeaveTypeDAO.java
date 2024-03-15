package com.dao;

import java.util.List;


import com.entity.LeaveTypes;



public interface LeaveTypeDAO {

	List<LeaveTypes> getAllLeaveType();

	void addLeaveType(LeaveTypes leaveType);
	
	void updateLeaveType(LeaveTypes leaveType);

	LeaveTypes deleteLeaveType(int leaveTypeId);

	LeaveTypes getLeaveTypeById(int leaveTypeId);
	
}
