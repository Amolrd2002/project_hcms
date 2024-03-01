package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.EmployeesDAO;
import com.entity.Employees;

public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	private EmployeesDAO employeeDAO;
	@Override
	public List<Employees> getAllEmployees() {
		
		return null;
	}

}
