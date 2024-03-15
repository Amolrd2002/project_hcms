package com.dao;

import java.util.List;

import com.entity.Employees;

public interface EmployeesDAO {

	List<Employees> getAllEmployees();

	void addEmployee(Employees employee);

	void updateEmployee(Employees employee);

	Employees deleteEmployee(int employeeId);

	Employees getEmployeeById(int employeeId);

}
