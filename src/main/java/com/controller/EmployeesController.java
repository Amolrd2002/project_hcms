package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.entity.Employees;
import com.services.EmployeeServices;

@CrossOrigin("*")
@RestController()
public class EmployeesController {

	@Autowired
	private EmployeeServices employeeService;
	
	@GetMapping("/employees")
	private ResponseEntity<List<Employees>> getAlll(){
		return new ResponseEntity<List<Employees>>(employeeService.getAllEmployees(),HttpStatus.OK);
	}

	@PostMapping("/employees")
	private ResponseEntity<Void> save(@RequestBody Employees employee,UriComponentsBuilder uriComponentsBuilder){
		if(employee == null) {
			throw new RuntimeException("Employee Object cant be null");
		}
		employeeService.addEmployee(employee);
		
		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(uriComponentsBuilder.path("employees/{id}").buildAndExpand(employee).toUri());
		return  new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employees> getEmpById(@PathVariable("id") int employeeId) {
		Employees emp = employeeService.getEmployeeById(employeeId);

		if(emp==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Employees>(emp, HttpStatus.OK);

		}
		
		
	}
	
	

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employees> deleteEmpAll(@PathVariable("id") int employeeId) {
		
		Employees deleteEmployee = employeeService.getEmployeeById(employeeId);
		
		if(deleteEmployee==null) {
			return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
		}
		Employees employee =  employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<Employees>(employee,HttpStatus.OK);
	}

	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employees updatedEmployee,@PathVariable("id") int id) {
		if(updatedEmployee==null) {
			throw new RuntimeException("Employee Object Can't be null");
		}

		Employees exitingEmp = employeeService.getEmployeeById(id);
		
		if(exitingEmp==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		employeeService.updateEmployee(updatedEmployee);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	
	
}
