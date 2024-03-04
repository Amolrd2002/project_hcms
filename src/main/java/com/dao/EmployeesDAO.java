package com.dao;

import java.util.List;

import com.entity.Employees;

public interface EmployeesDAO {

	List<Employees> getAllEmployees();

	void addEmployee(Employees employee);

	Employees updateEmployee(Employees employee);

	void deleteEmployee(int employeeId);

	Employees getEmployeeById(int employeeId);

}
