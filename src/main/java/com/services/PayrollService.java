package com.services;

import java.util.List;
import com.entity.Payroll;

public interface PayrollService {

	List<Payroll> getAllPayroll();

	void addPayroll(Payroll payroll);
	
	void updatePayroll(Payroll payroll);

	Payroll deletePayroll(int payrollId);

	Payroll getPayrollById(int payrollId);
	
}
