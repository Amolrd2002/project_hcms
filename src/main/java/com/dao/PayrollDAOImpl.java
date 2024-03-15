package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.Payroll;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PayrollDAOImpl implements PayrollDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Payroll> getAllPayroll() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from Payroll",Payroll.class).getResultList();
	}

	@Override
	public void addPayroll(Payroll payroll) {
		entityManager.unwrap(Session.class).save(payroll);
		
	}

	@Override
	public void updatePayroll(Payroll payroll) {
		entityManager.unwrap(Session.class).merge(payroll);
		
	}

	@Override
	public Payroll deletePayroll(int payrollId) {
		Payroll payroll = entityManager.unwrap(Session.class).find(Payroll.class, payrollId);
		entityManager.remove(payroll);
		return payroll;
	}

	@Override
	public Payroll getPayrollById(int payrollId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(Payroll.class, payrollId);
	}

}
