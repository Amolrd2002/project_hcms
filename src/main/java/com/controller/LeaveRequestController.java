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
import com.entity.LeaveRequests;
import com.services.LeaveRequestService;

@RestController
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;
	
	@GetMapping("/leaveRequests")
	private ResponseEntity<List<LeaveRequests>> getAllLeaveRequests(){
		return new ResponseEntity<List<LeaveRequests>>(leaveRequestService.getAllLeaveRequests(),HttpStatus.OK);
	}
	
	@PostMapping("/leaveRequests")
	public ResponseEntity<Void> addLeaveRequest(@RequestBody LeaveRequests leaveRequests,UriComponentsBuilder uriComponentsBuilder) {
		if(leaveRequests ==null) {
			throw new RuntimeException("LeaveRequest Object Can't be null");
		}
		leaveRequestService.addLeaveRequests(leaveRequests);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/leaveRequests/{id}")
	public ResponseEntity<LeaveRequests> getLeaveRequestById(@PathVariable("id") int id) {
		LeaveRequests lr = leaveRequestService.getLeaveRequestById(id);	
		if(lr == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<LeaveRequests>(lr, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/leaveRequests/{id}")
	public ResponseEntity<LeaveRequests> deleteLeaveRequestById(@PathVariable("id") int id) {
		LeaveRequests lr = leaveRequestService.getLeaveRequestById(id);
		
		if(lr==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		LeaveRequests leaveRequests= leaveRequestService.deleteLeaveRequest(id);
		
		return new ResponseEntity<LeaveRequests>(leaveRequests,HttpStatus.OK);
	}
	

	@PutMapping("/leaveRequests/{id}")
	public ResponseEntity<Void> updateLeaveRequest(@RequestBody LeaveRequests updatedLeaveRequest,@PathVariable("id") int id) {
		
		if(updatedLeaveRequest==null) {
			throw new RuntimeException("LeaveRequest Object Can't be null");
		}
		
		LeaveRequests LeaveRequestsSaved = leaveRequestService.getLeaveRequestById(id);
		
		if(LeaveRequestsSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		leaveRequestService.updateLeaveRequests(updatedLeaveRequest);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
