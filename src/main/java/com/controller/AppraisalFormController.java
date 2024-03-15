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

import com.entity.AppraisalForms;
import com.services.AppraisalFormServices;

@RestController
public class AppraisalFormController {

	@Autowired
	private AppraisalFormServices appraisalFormServices;
	
	@GetMapping("/appraisalForms")
	private ResponseEntity<List<AppraisalForms>> getAllDepartment(){
		return new ResponseEntity<List<AppraisalForms>>(appraisalFormServices.getAllAppraisalForm(),HttpStatus.OK);
	}
	
	@PostMapping("/appraisalForms")
	public ResponseEntity<Void> addAppraisalForms(@RequestBody AppraisalForms appraisalForms,UriComponentsBuilder uriComponentsBuilder) {
		if(appraisalForms ==null) {
			throw new RuntimeException("AppraisalForms Object Can't be null");
		}
		appraisalFormServices.addAppraisalForm(appraisalForms);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/appraisalForms/{id}")
	public ResponseEntity<AppraisalForms> getAppraisalFormsById(@PathVariable("id") int appraisalFormsId) {
		AppraisalForms appraisalForms = appraisalFormServices.getAppraisalFormById(appraisalFormsId);	
		if(appraisalForms == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<AppraisalForms>(appraisalForms, HttpStatus.OK);
		}

	}

	@DeleteMapping("/appraisalForms/{id}")
	public ResponseEntity<AppraisalForms> deleteAppraisalFormsById(@PathVariable("id") int id) {
		AppraisalForms af = appraisalFormServices.getAppraisalFormById(id);
		if(af==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		AppraisalForms appraisalForms= appraisalFormServices.deleteAppraisalForm(id);
		return new ResponseEntity<AppraisalForms>(appraisalForms,HttpStatus.OK);
	}
	
	@PutMapping("/appraisalForms/{id}")
	public ResponseEntity<Void> AppraisalFormsDepartment(@RequestBody AppraisalForms updatedAppraisalForm,@PathVariable("id") int id) {
		if(updatedAppraisalForm==null) {
			throw new RuntimeException("AppraisalForm Object Can't be null");
		}
		AppraisalForms appraisalFormSaved = appraisalFormServices.getAppraisalFormById(id);
		if(appraisalFormSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		appraisalFormServices.updateAppraisalForm(updatedAppraisalForm);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
