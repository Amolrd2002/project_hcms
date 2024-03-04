package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employees;
import com.services.EmployeeServices;

@RestController()
public class EmployeesController {

	@Autowired
	private EmployeeServices employeeService;
	
	@GetMapping("/employees")
	private ResponseEntity<List<Employees>> getAlll(){
		return new ResponseEntity<List<Employees>>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Void> addEmployee(@RequestBody Employees employee) {
		 employeeService.addEmployee(employee);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employees> getEmpById(@PathVariable("employeeId") int employeeId) {
		Employees emp = employeeService.getEmployeeById(employeeId);

		return new ResponseEntity<Employees>(emp, HttpStatus.OK);
	}
	
	

	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<Void> deleteEmpAll(@PathVariable("employeeId") int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/employees")
	public ResponseEntity<Employees> updateEmployee(@RequestBody Employees employee) {

		Employees employeeSaved = employeeService.updateEmployee(employee);

		return new ResponseEntity<Employees>(employeeSaved, HttpStatus.CREATED);
	}

	
	
	
}
