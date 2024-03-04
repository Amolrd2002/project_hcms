package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;


public interface DepartmentDAO {

	List<Departments> getAllDepartment();

	void addDepartment(Departments department);
	
	Departments updateDepartment(Departments department);

	void deleteDepartment(int departmentId);

	Departments getDepartmentById(int deparmentId);
	
}
