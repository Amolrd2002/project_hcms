package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PayrollDAO;
import com.entity.Payroll;

@Service
public class PayrollServiceImpl implements PayrollService{

	
	@Autowired
	private PayrollDAO payrollDAO;

	@Override
	public List<Payroll> getAllPayroll() {
		// TODO Auto-generated method stub
		return payrollDAO.getAllPayroll();
	}

	@Override
	public void addPayroll(Payroll payroll) {
		// TODO Auto-generated method stub
		payrollDAO.addPayroll(payroll);
	}

	@Override
	public void updatePayroll(Payroll payroll) {
		// TODO Auto-generated method stub
		payrollDAO.updatePayroll(payroll);
	}

	@Override
	public Payroll deletePayroll(int payrollId) {
		// TODO Auto-generated method stub
		return payrollDAO.deletePayroll(payrollId);
	}

	@Override
	public Payroll getPayrollById(int payrollId) {
		// TODO Auto-generated method stub
		return payrollDAO.getPayrollById(payrollId);
	}
	
	

	

}
