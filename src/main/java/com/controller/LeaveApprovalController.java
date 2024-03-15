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
import com.entity.LeaveApprovals;
import com.services.LeaveApprovalService;

@RestController
public class LeaveApprovalController {

	@Autowired
	private LeaveApprovalService leaveApprovalService;
	
	@GetMapping("/leaveApprovals")
	private ResponseEntity<List<LeaveApprovals>> getAllLeaveApproval(){
		return new ResponseEntity<List<LeaveApprovals>>(leaveApprovalService.getAllLeaveApproval(),HttpStatus.OK);
	}
	
	@PostMapping("/leaveApprovals")
	public ResponseEntity<Void> addLeaveApproval(@RequestBody LeaveApprovals leaveApproval,UriComponentsBuilder uriComponentsBuilder) {
		if(leaveApproval ==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		leaveApprovalService.addLeaveApproval(leaveApproval);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/leaveApprovals/{id}")
	public ResponseEntity<LeaveApprovals> getLeaveApprovalById(@PathVariable("id") int id) {
		LeaveApprovals ap = leaveApprovalService.getLeaveApprovalById(id);	
		if(ap == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<LeaveApprovals>(ap, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/leaveApprovals/{id}")
	public ResponseEntity<LeaveApprovals> deleteLeaveApprovalById(@PathVariable("id") int id) {
		LeaveApprovals la = leaveApprovalService.getLeaveApprovalById(id);
		
		if(la==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		LeaveApprovals leaveApproval= leaveApprovalService.deleteLeaveApproval(id);
		
		return new ResponseEntity<LeaveApprovals>(leaveApproval,HttpStatus.OK);
	}
	

	@PutMapping("/leaveApprovals/{id}")
	public ResponseEntity<Void> updateLeaveApproval(@RequestBody LeaveApprovals updatedLeaveApproval,@PathVariable("id") int id) {
		
		if(updatedLeaveApproval==null) {
			throw new RuntimeException("LeaveApproval Object Can't be null");
		}
		
		LeaveApprovals leaveApprovalSaved = leaveApprovalService.getLeaveApprovalById(id);
		
		if(leaveApprovalSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		leaveApprovalService.updateLeaveApproval(updatedLeaveApproval);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
