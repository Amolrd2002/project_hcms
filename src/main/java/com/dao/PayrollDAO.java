package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.Payroll;


public interface PayrollDAO {

	List<Payroll> getAllPayroll();

	void addPayroll(Payroll payroll);
	
	void updatePayroll(Payroll payroll);

	Payroll deletePayroll(int payrollId);

	Payroll getPayrollById(int payrollId);
	
}
