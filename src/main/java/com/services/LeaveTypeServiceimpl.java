package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.LeaveTypeDAO;
import com.entity.LeaveTypes;

@Service
public class LeaveTypeServiceimpl implements LeaveTypeService{

	
	@Autowired
	private LeaveTypeDAO leaveTypeDAO;

	@Override
	public List<LeaveTypes> getAllLeaveType() {
		// TODO Auto-generated method stub
		return leaveTypeDAO.getAllLeaveType();
	}

	@Override
	public void addLeaveType(LeaveTypes leaveType) {
		// TODO Auto-generated method stub
		leaveTypeDAO.addLeaveType(leaveType);
	}

	@Override
	public void updateLeaveType(LeaveTypes leaveType) {
		// TODO Auto-generated method stub
		leaveTypeDAO.updateLeaveType(leaveType);
	}

	@Override
	public LeaveTypes deleteLeaveType(int leaveTypeId) {
		// TODO Auto-generated method stub
		return leaveTypeDAO.deleteLeaveType(leaveTypeId);
	}

	@Override
	public LeaveTypes getLeaveTypeById(int leaveTypeId) {
		// TODO Auto-generated method stub
		return leaveTypeDAO.getLeaveTypeById(leaveTypeId);
	}

	


}
