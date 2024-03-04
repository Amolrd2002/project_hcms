package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO{

	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Departments> getAllDepartment() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from Departments",Departments.class).getResultList();
	}

	@Override
	public void addDepartment(Departments department) {
		entityManager.unwrap(Session.class).save(department);
	}

	@Override
	public Departments updateDepartment(Departments department) {
		
		return entityManager.unwrap(Session.class).merge(department);
	}

	@Override
	public void deleteDepartment(int departmentId) {
		Departments department = entityManager.unwrap(Session.class).find(Departments.class, departmentId);
		entityManager.remove(department);
	}

	@Override
	public Departments getDepartmentById(int departmentId) {
		
		return entityManager.unwrap(Session.class).find(Departments.class, departmentId);
	}

}
