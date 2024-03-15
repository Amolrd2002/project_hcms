package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.LeaveTypes;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveTypeDAOImpl implements LeaveTypeDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveTypes> getAllLeaveType() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from LeaveTypes",LeaveTypes.class).getResultList();
	}

	@Override
	public void addLeaveType(LeaveTypes leaveType) {
		entityManager.unwrap(Session.class).save(leaveType);
		
	}

	@Override
	public void updateLeaveType(LeaveTypes leaveType) {
		entityManager.unwrap(Session.class).merge(leaveType);
		
	}

	@Override
	public LeaveTypes deleteLeaveType(int leaveTypeId) {
		LeaveTypes leaveType = entityManager.unwrap(Session.class).find(LeaveTypes.class, leaveTypeId);
		entityManager.remove(leaveType);
		return leaveType;
	}

	@Override
	public LeaveTypes getLeaveTypeById(int leaveTypeId) {
		// TODO Auto-generated method stub
		 return entityManager.unwrap(Session.class).find(LeaveTypes.class, leaveTypeId);
	}


}
