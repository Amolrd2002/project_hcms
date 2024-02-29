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
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeId;

	private String firstName;

	private String lastName;

	private String gender;

	private LocalDate dateOfBirth;

	private String email;

	private String phone;

	private String address;

	private String nationalId;

	private String martialStatus;

	private String emergencyContactName;

	private String emergencyContactPhone;

	// Code Incomplete
	@ManyToOne
	private Department department;

	private String position;

	private String skillSet;

	private LocalDate employmentStartDate;

	private LocalDate employmentEndDate;

	private BigDecimal salary;

	private String employmentStatus;

	private String bankAccountNumber;

	@ManyToOne
	private Employee manager;

	@ManyToOne
	private Role role;

	public Employee() {

	}

	public Employee(int employeId, String firstName, String lastName, String gender, LocalDate dateOfBirth,
			String email, String phone, String address, String nationalId, String martialStatus,
			String emergencyContactName, String emergencyContactPhone, Department department, String position,
			String skillSet, LocalDate employmentStartDate, LocalDate employmentEndDate, BigDecimal salary,
			String employmentStatus, String bankAccountNumber, Employee manager, Role role) {

		this.employeId = employeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.nationalId = nationalId;
		this.martialStatus = martialStatus;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhone = emergencyContactPhone;
		this.department = department;
		this.position = position;
		this.skillSet = skillSet;
		this.employmentStartDate = employmentStartDate;
		this.employmentEndDate = employmentEndDate;
		this.salary = salary;
		this.employmentStatus = employmentStatus;
		this.bankAccountNumber = bankAccountNumber;
		this.manager = manager;
		this.role = role;
	}

	public int getEmployeId() {
		return employeId;
	}

	public void setEmployeId(int employeId) {
		this.employeId = employeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public LocalDate getEmploymentStartDate() {
		return employmentStartDate;
	}

	public void setEmploymentStartDate(LocalDate employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public LocalDate getEmploymentEndDate() {
		return employmentEndDate;
	}

	public void setEmploymentEndDate(LocalDate employmentEndDate) {
		this.employmentEndDate = employmentEndDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeId=" + employeId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", nationalId=" + nationalId + ", martialStatus=" + martialStatus
				+ ", emergencyContactName=" + emergencyContactName + ", emergencyContactPhone=" + emergencyContactPhone
				+ ", department=" + department + ", position=" + position + ", skillSet=" + skillSet
				+ ", employmentStartDate=" + employmentStartDate + ", employmentEndDate=" + employmentEndDate
				+ ", salary=" + salary + ", employmentStatus=" + employmentStatus + ", bankAccountNumber="
				+ bankAccountNumber + ", manager=" + manager + ", role=" + role + "]";
	}

}
