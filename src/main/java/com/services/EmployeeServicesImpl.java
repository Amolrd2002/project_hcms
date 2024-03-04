package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeesDAO;
import com.entity.Employees;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	private EmployeesDAO employeeDAO;
	@Override
	public List<Employees> getAllEmployees() {
		
		return employeeDAO.getAllEmployees();
	}

	@Override
	public void addEmployee(Employees employee) {
		  employeeDAO.addEmployee(employee);
		
	}

	@Override
	public Employees updateEmployee(Employees employee) {
		return employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		
		employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	public Employees getEmployeeById(int employeeId) {
	
		return employeeDAO.getEmployeeById(employeeId);
	}

	

}
