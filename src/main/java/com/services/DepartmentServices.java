package com.services;

import java.util.List;

import com.entity.Departments;

public interface DepartmentServices {

	List<Departments> getAllDepartment();

	void addDepartment(Departments department);
	
	void updateDepartment(Departments department);

	Departments deleteDepartment(int departmentId);

	Departments getDepartmentById(int deparmentId);
}
