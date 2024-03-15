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
import com.entity.LeaveTypes;
import com.services.LeaveTypeService;

@RestController
public class LeaveTypesController {

	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@GetMapping("/leaveTypes")
	private ResponseEntity<List<LeaveTypes>> getAllleaveTypes(){
		return new ResponseEntity<List<LeaveTypes>>(leaveTypeService.getAllLeaveType(),HttpStatus.OK);
	}
	
	@PostMapping("/leaveTypes")
	public ResponseEntity<Void> addLeaveType(@RequestBody LeaveTypes leaveType,UriComponentsBuilder uriComponentsBuilder) {
		if(leaveType ==null) {
			throw new RuntimeException("LeaveType Object Can't be null");
		}
		leaveTypeService.addLeaveType(leaveType);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/leaveTypes/{id}")
	public ResponseEntity<LeaveTypes> getDeptById(@PathVariable("id") int id) {
		LeaveTypes lt = leaveTypeService.getLeaveTypeById(id);	
		if(lt == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<LeaveTypes>(lt, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/leaveTypes/{id}")
	public ResponseEntity<LeaveTypes> deleteLeaveTypeById(@PathVariable("id") int id) {
		LeaveTypes lt = leaveTypeService.getLeaveTypeById(id);
		
		if(lt==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		LeaveTypes leaveTypes= leaveTypeService.deleteLeaveType(id);
		
		return new ResponseEntity<LeaveTypes>(leaveTypes,HttpStatus.OK);
	}
	

	@PutMapping("/leaveTypes/{id}")
	public ResponseEntity<Void> updateLeaveType(@RequestBody LeaveTypes updatedLeaveType,@PathVariable("id") int id) {
		
		if(updatedLeaveType==null) {
			throw new RuntimeException("LeaveType Object Can't be null");
		}
		
		LeaveTypes leaveTypeSaved = leaveTypeService.getLeaveTypeById(id);
		
		if(leaveTypeSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		leaveTypeService.updateLeaveType(updatedLeaveType);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
