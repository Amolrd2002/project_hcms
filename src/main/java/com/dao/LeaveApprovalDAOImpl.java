package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.LeaveApprovals;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveApprovalDAOImpl implements LeaveApprovalDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveApprovals> getAllLeaveApproval() {
		return entityManager.unwrap(Session.class).createQuery("from LeaveApprovals",LeaveApprovals.class).getResultList();
		
	}

	@Override
	public void addLeaveApproval(LeaveApprovals leaveApproval) {
		entityManager.unwrap(Session.class).save(leaveApproval);
		
	}

	@Override
	public void updateLeaveApproval(LeaveApprovals leaveApproval) {
		entityManager.unwrap(Session.class).merge(leaveApproval);
		
	}

	@Override
	public LeaveApprovals deleteLeaveApproval(int leaveApprovalId) {
		LeaveApprovals leaveApprovals = entityManager.unwrap(Session.class).find(LeaveApprovals.class, leaveApprovalId);
		entityManager.remove(leaveApprovals);
		return leaveApprovals;
	}

	@Override
	public LeaveApprovals getLeaveApprovalById(int leaveApprovalId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(LeaveApprovals.class, leaveApprovalId);
	}

}
