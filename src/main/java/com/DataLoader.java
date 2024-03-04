package com;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dao.DepartmentDAO;
import com.dao.EmployeesDAO;
import com.dao.RolesDAO;
import com.entity.Departments;
import com.entity.Employees;
import com.entity.Roles;
import com.services.DepartmentServices;
import com.services.EmployeeServices;
import com.services.RolesService;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private RolesService rolesService;

	@Autowired
	private EmployeeServices employeeService;

	@Autowired
	private DepartmentServices departmentService;

	@Override
	public void run(String... args) throws Exception {
		Roles role1 = new Roles();
		role1.setRoleName("Manager");
		role1.setDescription("Manager role desc");
		rolesService.addRole(role1);

		Roles role2 = new Roles();
		role2.setRoleName("Developer");
		role2.setDescription("Developer role desc");
		rolesService.addRole(role2);

		Departments d1 = new Departments();
		d1.setDepartmentName("IT");
		d1.setDescription("IT Desc");
		departmentService.addDepartment(d1);

		Departments d2 = new Departments();
		d2.setDepartmentName("HR");
		d2.setDescription("HR Desc");
		departmentService.addDepartment(d2);

		Employees manager = new Employees();
		manager.setFirstName("Rohit");
		manager.setLastName("Sharma");
		manager.setAddress("Mumbai");
		manager.setEmail("Rohit123@gmail.com");
		manager.setGender("M");
		manager.setDateOfBirth(LocalDate.of(1996, 9, 24));
		manager.setPhone("9876654432");
		manager.setNationalId("8654678");
		manager.setMaritalStatus("Married");
		manager.setEmergencyContactName("XYZ");
		manager.setEmergencyContactPhone("987655677");
		manager.setPosition("Software Manager");
		manager.setSkillSet("Java , Spring Boot,AWS,Microservices");
		manager.setEmploymentStartDate(LocalDate.of(2014, 7, 27));
		manager.setEmploymentEndDate(null);
		manager.setSalary(new BigDecimal("150000.0"));
		manager.setEmploymentStatus("Active");
		manager.setBankAccountNumber("7477479749733");
		manager.setManager(null);
		
		manager.setDepartment(d1);
		manager.setRole(role1);
		
		Employees emp1 = new Employees();
		emp1.setFirstName("Amol");
		emp1.setLastName("Dhawale");
		emp1.setAddress("Pune");
		emp1.setEmail("amol123@gmail.com");
		emp1.setGender("M");
		emp1.setDateOfBirth(LocalDate.of(2002, 9, 24));
		emp1.setPhone("1234567890");
		emp1.setNationalId("123453");
		emp1.setMaritalStatus("Single");
		emp1.setEmergencyContactName("ABC");
		emp1.setEmergencyContactPhone("1234567");
		emp1.setPosition("Software Developer");
		emp1.setSkillSet("Java , Spring Boot");
		emp1.setEmploymentStartDate(LocalDate.of(2020, 1, 1));
		emp1.setEmploymentEndDate(null);
		emp1.setSalary(new BigDecimal("80000.0"));
		emp1.setEmploymentStatus("Active");
		emp1.setBankAccountNumber("2432453242343");
		emp1.setManager(manager);
		emp1.setRole(role2);
		emp1.setDepartment(d1);

		
		
		employeeService.addEmployee(manager);
		employeeService.addEmployee(emp1);
		

	}

}
