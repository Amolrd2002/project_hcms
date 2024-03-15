package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.LeaveRequests;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveRequestDAOImpl implements LeaveRequestDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveRequests> getAllLeaveRequests() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from LeaveRequests",LeaveRequests.class).getResultList();
	}

	@Override
	public void addLeaveRequests(LeaveRequests leaveRequest) {
		// TODO Auto-generated method stub
		entityManager.unwrap(Session.class).save(leaveRequest);
	}

	@Override
	public void updateLeaveRequests(LeaveRequests leaveRequest) {
		// TODO Auto-generated method stub
		entityManager.unwrap(Session.class).merge(leaveRequest);
	}

	@Override
	public LeaveRequests deleteLeaveRequest(int leaveRequestId) {
		// TODO Auto-generated method stub
		LeaveRequests leaveRequest = entityManager.unwrap(Session.class).find(LeaveRequests.class, leaveRequestId);
		entityManager.remove(leaveRequest);
		return leaveRequest;
		
	}

	@Override
	public LeaveRequests getLeaveRequestById(int leaveRequestId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(LeaveRequests.class, leaveRequestId);
	}

}
