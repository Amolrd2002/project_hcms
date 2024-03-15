package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.EmployeeManagers;
import com.entity.Employees;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeManagersDAOImpl implements EmployeeManagersDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EmployeeManagers> getAllEmployeeManager() {
		return entityManager.unwrap(Session.class).createQuery("from EmployeeManagers",EmployeeManagers.class).getResultList();
		 
	}

	@Override
	public void addEmployeeManager(EmployeeManagers employeeManager) {
		// TODO Auto-generated method stub
		entityManager.unwrap(Session.class).save(employeeManager);
	}

	@Override
	public void updateEmployeeManager(EmployeeManagers employeeManager) {
		// TODO Auto-generated method stub
		entityManager.unwrap(Session.class).merge(employeeManager);
	}

	@Override
	public EmployeeManagers deleteEmployeeManager(int employeeManagerId) {
		EmployeeManagers employeeManager = entityManager.unwrap(Session.class).find(EmployeeManagers.class, employeeManagerId);
		entityManager.remove(employeeManager);
		return employeeManager;
	}

	@Override
	public EmployeeManagers getEmployeeManagerById(int employeeManagerId) {
		// TODO Auto-generated method stub
		 return entityManager.unwrap(Session.class).find(EmployeeManagers.class, employeeManagerId);
	}


}
