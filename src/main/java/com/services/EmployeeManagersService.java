package com.services;

import java.util.List;
import com.entity.EmployeeManagers;

public interface EmployeeManagersService {

	List<EmployeeManagers> getAllEmployeeManager();

	void addEmployeeManager(EmployeeManagers employeeManager);
	
	void updateEmployeeManager(EmployeeManagers employeeManager);

	EmployeeManagers deleteEmployeeManager(int employeeManagerId);

	EmployeeManagers getEmployeeManagerById(int employeeManagerId);
	
}
