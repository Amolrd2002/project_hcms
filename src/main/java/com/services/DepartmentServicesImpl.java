package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.DepartmentDAO;
import com.entity.Departments;

@Repository
public class DepartmentServicesImpl implements DepartmentServices {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Override
	public List<Departments> getAllDepartment() {
		
		return departmentDAO.getAllDepartment();
	}

	@Override
	public void addDepartment(Departments department) {
		departmentDAO.addDepartment(department);
		
	}

	@Override
	public Departments updateDepartment(Departments department) {
		
		return departmentDAO.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(int departmentId) {
		departmentDAO.deleteDepartment(departmentId);
		
	}

	@Override
	public Departments getDepartmentById(int deparmentId) {
		
		return departmentDAO.getDepartmentById(deparmentId);
	}

}
