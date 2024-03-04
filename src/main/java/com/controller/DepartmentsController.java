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

import com.entity.Departments;

import com.services.DepartmentServices;

@RestController
public class DepartmentsController {

	@Autowired
	private DepartmentServices departmentServices;
	
	@GetMapping("/departments")
	private ResponseEntity<List<Departments>> getAllDepartment(){
		return new ResponseEntity<List<Departments>>(departmentServices.getAllDepartment(),HttpStatus.OK);
	}
	
	@PostMapping("/departments")
	public ResponseEntity<Void> addDepartment(@RequestBody Departments department) {
		departmentServices.addDepartment(department);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/departments/{departmentId}")
	public ResponseEntity<Departments> getEmpById(@PathVariable("departmentId") int departmentId) {
		Departments department = departmentServices.getDepartmentById(departmentId);

		return new ResponseEntity<Departments>(department, HttpStatus.OK);
	}
	
	

	@DeleteMapping("/departments/{departmentId}")
	public ResponseEntity<Void> deleteEmpAll(@PathVariable("departmentId") int departmentId) {
		departmentServices.deleteDepartment(departmentId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/departments")
	public ResponseEntity<Departments> updateEmployee(@RequestBody Departments employee) {

		Departments departmentSaved = departmentServices.updateDepartment(employee);

		return new ResponseEntity<Departments>(departmentSaved, HttpStatus.CREATED);
	}
}
