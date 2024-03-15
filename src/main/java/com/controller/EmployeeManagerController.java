package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.entity.EmployeeManagers;
import com.services.EmployeeManagersService;

@RestController
public class EmployeeManagerController {

	@Autowired
	private EmployeeManagersService employeeManagerService;
	
	@GetMapping("/employeeManagers")
	private ResponseEntity<List<EmployeeManagers>> getAllEmployeeManager(){
		return new ResponseEntity<List<EmployeeManagers>>(employeeManagerService.getAllEmployeeManager(),HttpStatus.OK);
	}
	
	@PostMapping("/employeeManagers")
	public ResponseEntity<Void> addEmployeeManagers(@RequestBody EmployeeManagers employeeManager,UriComponentsBuilder uriComponentsBuilder) {
		if(employeeManager ==null) {
			throw new RuntimeException("EmployeeManager Object Can't be null");
		}
		employeeManagerService.addEmployeeManager(employeeManager);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/employeeManagers/{id}")
	public ResponseEntity<EmployeeManagers> getDeptById(@PathVariable("id") int id) {
		EmployeeManagers em = employeeManagerService.getEmployeeManagerById(id);	
		if(em == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<EmployeeManagers>(em, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/employeeManagers/{id}")
	public ResponseEntity<EmployeeManagers> deleteEmployeeManagerById(@PathVariable("id") int id) {
		EmployeeManagers em = employeeManagerService.getEmployeeManagerById(id);
		
		if(em==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		EmployeeManagers employeeManagers= employeeManagerService.deleteEmployeeManager(id);
		
		return new ResponseEntity<EmployeeManagers>(employeeManagers,HttpStatus.OK);
	}
	

	@PutMapping("/employeeManagers/{id}")
	public ResponseEntity<Void> updateEmployeeManager(@RequestBody EmployeeManagers updatedEmployeeManager,@PathVariable("id") int id) {
		if(updatedEmployeeManager==null) {
			throw new RuntimeException("EmployeeManagers Object Can't be null");
		}
		EmployeeManagers employeeManagersSaved = employeeManagerService.getEmployeeManagerById(id);
		
		if(employeeManagersSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		employeeManagerService.updateEmployeeManager(updatedEmployeeManager);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
