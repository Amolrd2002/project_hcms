package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.EmployeeManagers;
import com.entity.Employees;


public interface EmployeeManagersDAO {

	List<EmployeeManagers> getAllEmployeeManager();

	void addEmployeeManager(EmployeeManagers employeeManager);
	
	void updateEmployeeManager(EmployeeManagers employeeManager);

	EmployeeManagers deleteEmployeeManager(int employeeManagerId);

	EmployeeManagers getEmployeeManagerById(int employeeManagerId);
	
}
