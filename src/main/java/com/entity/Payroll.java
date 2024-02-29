package com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payrollId;

	private int salaryMonth;

	private int salaryYear;

	private BigDecimal basicSalary;

	private BigDecimal allowances;

	private BigDecimal Deductions;

	private BigDecimal netSalary;

	private LocalDate date;

	// Incomplete Code
	
	@ManyToOne
	private Employee employee;

	public Payroll() {

	}

	public Payroll(int payrollId, int salaryMonth, int salaryYear, BigDecimal basicSalary, BigDecimal allowances,
			BigDecimal deductions, BigDecimal netSalary, LocalDate date, Employee employee) {

		this.payrollId = payrollId;
		this.salaryMonth = salaryMonth;
		this.salaryYear = salaryYear;
		this.basicSalary = basicSalary;
		this.allowances = allowances;
		Deductions = deductions;
		this.netSalary = netSalary;
		this.date = date;
		this.employee = employee;
	}

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public int getSalaryMonth() {
		return salaryMonth;
	}

	public void setSalaryMonth(int salaryMonth) {
		this.salaryMonth = salaryMonth;
	}

	public int getSalaryYear() {
		return salaryYear;
	}

	public void setSalaryYear(int salaryYear) {
		this.salaryYear = salaryYear;
	}

	public BigDecimal getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(BigDecimal basicSalary) {
		this.basicSalary = basicSalary;
	}

	public BigDecimal getAllowances() {
		return allowances;
	}

	public void setAllowances(BigDecimal allowances) {
		this.allowances = allowances;
	}

	public BigDecimal getDeductions() {
		return Deductions;
	}

	public void setDeductions(BigDecimal deductions) {
		Deductions = deductions;
	}

	public BigDecimal getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(BigDecimal netSalary) {
		this.netSalary = netSalary;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employee getEmp() {
		return employee;
	}

	public void setEmp(Employee emp) {
		this.employee = emp;
	}

	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", salaryMonth=" + salaryMonth + ", salaryYear=" + salaryYear
				+ ", basicSalary=" + basicSalary + ", allowances=" + allowances + ", Deductions=" + Deductions
				+ ", netSalary=" + netSalary + ", date=" + date + ", employee=" + employee + "]";
	}

}
