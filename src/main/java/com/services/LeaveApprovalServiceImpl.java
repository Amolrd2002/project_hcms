package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.LeaveApprovalDAO;
import com.entity.LeaveApprovals;

@Service
public class LeaveApprovalServiceImpl implements LeaveApprovalService{

	
	@Autowired
	private LeaveApprovalDAO leaveApprovalDAO;

	@Override
	public List<LeaveApprovals> getAllLeaveApproval() {
		// TODO Auto-generated method stub
		return leaveApprovalDAO.getAllLeaveApproval();
	}

	@Override
	public void addLeaveApproval(LeaveApprovals leaveApproval) {
		// TODO Auto-generated method stub
		leaveApprovalDAO.addLeaveApproval(leaveApproval);
	}

	@Override
	public void updateLeaveApproval(LeaveApprovals leaveApproval) {
		// TODO Auto-generated method stub
		leaveApprovalDAO.updateLeaveApproval(leaveApproval);
	}

	@Override
	public LeaveApprovals deleteLeaveApproval(int leaveApprovalId) {
		// TODO Auto-generated method stub
		return leaveApprovalDAO.deleteLeaveApproval(leaveApprovalId);
	}

	@Override
	public LeaveApprovals getLeaveApprovalById(int leaveApprovalId) {
		// TODO Auto-generated method stub
		return leaveApprovalDAO.getLeaveApprovalById(leaveApprovalId);
	}

	

}
