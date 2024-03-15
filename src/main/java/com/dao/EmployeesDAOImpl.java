package com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employees;

import jakarta.persistence.EntityManager;



@Repository
@Transactional
public class EmployeesDAOImpl implements EmployeesDAO {


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employees> getAllEmployees() {
		return entityManager.unwrap(Session.class).createQuery("from Employees",Employees.class).getResultList();
	}

	@Override
	public void addEmployee(Employees employee) {
//		Employees emp1 = new Employees();
//		emp1.setFirstName(employee.getFirstName());
//		emp1.setLastName(employee.getLastName());
//		emp1.setAddress(employee.getAddress());
//		emp1.setEmail(employee.getEmail());
//		emp1.setGender(employee.getGender());
//		emp1.setDateOfBirth(employee.getDateOfBirth());
//		emp1.setPhone(employee.getPhone());
//		emp1.setNationalId(employee.getNationalId());
//		emp1.setMaritalStatus(employee.getMaritalStatus());
//		emp1.setEmergencyContactName(employee.getEmergencyContactName());
//		emp1.setEmergencyContactPhone(employee.getEmergencyContactPhone());
//		emp1.setPosition(employee.getPosition());
//		emp1.setSkillSet(employee.getSkillSet());
//		emp1.setEmploymentStartDate(employee.getEmploymentStartDate());
//		emp1.setEmploymentEndDate(employee.getEmploymentEndDate());
//		emp1.setSalary(employee.getSalary());
//		emp1.setEmploymentStatus(employee.getEmploymentStatus());
//		emp1.setBankAccountNumber(employee.getBankAccountNumber());
//		emp1.setManager(employee.getManager());
//		emp1.setRole(employee.getRole());
//		emp1.setDepartment(employee.getDepartment());
//		entityManager.unwrap(Session.class).persist(emp1);
		
		entityManager.unwrap(Session.class).save(employee) ;
		 
	}

	@Override
	public void updateEmployee(Employees employee) {
		  entityManager.unwrap(Session.class).merge(employee);
		
	}

	@Override
	public Employees deleteEmployee(int employeeId) {
		
		Employees employee= entityManager.unwrap(Session.class).find(Employees.class, employeeId);
		entityManager.remove(employee);
		return employee;
	}

	@Override
	public Employees getEmployeeById(int employeeId) {
		return entityManager.unwrap(Session.class).find(Employees.class, employeeId);
	}



}
