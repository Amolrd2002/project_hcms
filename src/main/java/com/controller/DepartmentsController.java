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
	public ResponseEntity<Void> addDepartment(@RequestBody Departments department,UriComponentsBuilder uriComponentsBuilder) {
		if(department ==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		departmentServices.addDepartment(department);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Departments> getDeptById(@PathVariable("id") int departmentId) {
		Departments dept = departmentServices.getDepartmentById(departmentId);	
		if(dept == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<Departments>(dept, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<Departments> deleteDeptById(@PathVariable("id") int id) {
		Departments dept = departmentServices.getDepartmentById(id);
		
		if(dept==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Departments department= departmentServices.deleteDepartment(id);
		
		return new ResponseEntity<Departments>(department,HttpStatus.OK);
	}
	

	@PutMapping("/departments/{id}")
	public ResponseEntity<Void> updateDepartment(@RequestBody Departments updatedDepartment,@PathVariable("id") int id) {
		
		if(updatedDepartment==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		
		Departments departmentSaved = departmentServices.getDepartmentById(id);
		
		if(departmentSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		 departmentServices.updateDepartment(updatedDepartment);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
