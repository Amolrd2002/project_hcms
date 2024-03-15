package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.LeaveRequestDAO;
import com.entity.LeaveRequests;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService{

	
	@Autowired
	private LeaveRequestDAO leaveRequestDAO;

	@Override
	public List<LeaveRequests> getAllLeaveRequests() {
		// TODO Auto-generated method stub
		return leaveRequestDAO.getAllLeaveRequests();
	}

	@Override
	public void addLeaveRequests(LeaveRequests leaveRequest) {
		// TODO Auto-generated method stub
		leaveRequestDAO.addLeaveRequests(leaveRequest);
	}

	@Override
	public void updateLeaveRequests(LeaveRequests leaveRequest) {
		// TODO Auto-generated method stub
		leaveRequestDAO.updateLeaveRequests(leaveRequest);
	}

	@Override
	public LeaveRequests deleteLeaveRequest(int leaveRequestId) {
		// TODO Auto-generated method stub
		return leaveRequestDAO.deleteLeaveRequest(leaveRequestId);
	}

	@Override
	public LeaveRequests getLeaveRequestById(int leaveRequestId) {
		// TODO Auto-generated method stub
		return leaveRequestDAO.getLeaveRequestById(leaveRequestId);
	}

}
