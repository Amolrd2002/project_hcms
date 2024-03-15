package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EmployeeManagersDAO;
import com.entity.EmployeeManagers;

@Service
public class EmployeeManagersServiceImpl implements EmployeeManagersService{

	
	@Autowired
	private EmployeeManagersDAO employeeManagersDAO;

	@Override
	public List<EmployeeManagers> getAllEmployeeManager() {
		// TODO Auto-generated method stub
		return employeeManagersDAO.getAllEmployeeManager();
	}

	@Override
	public void addEmployeeManager(EmployeeManagers employeeManager) {
		// TODO Auto-generated method stub
		employeeManagersDAO.addEmployeeManager(employeeManager);
	}

	@Override
	public void updateEmployeeManager(EmployeeManagers employeeManager) {
		// TODO Auto-generated method stub
		employeeManagersDAO.updateEmployeeManager(employeeManager);
	}

	@Override
	public EmployeeManagers deleteEmployeeManager(int employeeManagerId) {
		// TODO Auto-generated method stub
		return employeeManagersDAO.deleteEmployeeManager(employeeManagerId);
	}

	@Override
	public EmployeeManagers getEmployeeManagerById(int employeeManagerId) {
		// TODO Auto-generated method stub
		return employeeManagersDAO.getEmployeeManagerById(employeeManagerId);
	}



}
