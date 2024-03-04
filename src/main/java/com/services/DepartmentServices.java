package com.services;

import java.util.List;

import com.entity.Departments;

public interface DepartmentServices {

	List<Departments> getAllDepartment();

	void addDepartment(Departments department);
	
	Departments updateDepartment(Departments department);

	void deleteDepartment(int departmentId);

	Departments getDepartmentById(int deparmentId);
}
