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
import com.entity.ApplicationStatus;
import com.services.ApplicationStatusServices;

@RestController
public class ApplicationStatusController {

	@Autowired
	private ApplicationStatusServices applicationStatusServices;
	
	@GetMapping("/applicationstatus")
	private ResponseEntity<List<ApplicationStatus>> getAllApplicationStatus(){
		return new ResponseEntity<List<ApplicationStatus>>(applicationStatusServices.getAllApplicationStatus(),HttpStatus.OK);
	}
	
	@PostMapping("/applicationstatus")
	public ResponseEntity<Void> addApplicationStatus(@RequestBody ApplicationStatus applicationStatus,UriComponentsBuilder uriComponentsBuilder) {
		if(applicationStatus ==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		applicationStatusServices.addApplicationStatus(applicationStatus);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/applicationstatus/{id}")
	public ResponseEntity<ApplicationStatus> getApplicationStatusById(@PathVariable("id") int id) {
		ApplicationStatus applicationStatus = applicationStatusServices.getApplicationStatusById(id);	
		if(applicationStatus == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<ApplicationStatus>(applicationStatus, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/applicationstatus/{id}")
	public ResponseEntity<ApplicationStatus> deleteApplicationStatusById(@PathVariable("id") int id) {
		ApplicationStatus applicationStatus = applicationStatusServices.getApplicationStatusById(id);
		
		if(applicationStatus==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ApplicationStatus deletedapplicationStatus= applicationStatusServices.deleteApplicationStatus(id);
		
		return new ResponseEntity<ApplicationStatus>(deletedapplicationStatus,HttpStatus.OK);
	}
	

	@PutMapping("/applicationstatus/{id}")
	public ResponseEntity<Void> updateApplicationStatus(@RequestBody ApplicationStatus updatedApplicationStatus,@PathVariable("id") int id) {
		
		if(updatedApplicationStatus==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		ApplicationStatus ApplicationStatusSaved = applicationStatusServices.getApplicationStatusById(id);
		if(ApplicationStatusSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		applicationStatusServices.updateApplicationStatus(updatedApplicationStatus);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
