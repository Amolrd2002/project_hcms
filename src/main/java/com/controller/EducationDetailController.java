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
import com.entity.EducationDetails;
import com.services.EducationDetailService;

@RestController
public class EducationDetailController {

	@Autowired
	private EducationDetailService educationDetailService;
	
	@GetMapping("/educationDetails")
	private ResponseEntity<List<EducationDetails>> getAllEducationDetail(){
		return new ResponseEntity<List<EducationDetails>>(educationDetailService.getAllEducationDetail(),HttpStatus.OK);
	}
	
	@PostMapping("/educationDetails")
	public ResponseEntity<Void> addEducationDetail(@RequestBody EducationDetails educationDetail,UriComponentsBuilder uriComponentsBuilder) {
		if(educationDetail ==null) {
			throw new RuntimeException("EducationDetail Object Can't be null");
		}
		educationDetailService.addEducationDetail(educationDetail);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/educationDetails/{id}")
	public ResponseEntity<EducationDetails> getEducationDetailById(@PathVariable("id") int id) {
		EducationDetails ed = educationDetailService.getEducationDetailById(id);	
		if(ed == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<EducationDetails>(ed, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/educationDetails/{id}")
	public ResponseEntity<EducationDetails> deleteEducationDetailById(@PathVariable("id") int id) {
		EducationDetails ed = educationDetailService.getEducationDetailById(id);
		
		if(ed==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		EducationDetails educationDetails= educationDetailService.deleteEducationDetail(id);
		
		return new ResponseEntity<EducationDetails>(educationDetails,HttpStatus.OK);
	}
	

	@PutMapping("/educationDetails/{id}")
	public ResponseEntity<Void> updateEducationDetails(@RequestBody EducationDetails updatedEducationDetails,@PathVariable("id") int id) {
		
		if(updatedEducationDetails==null) {
			throw new RuntimeException("EducationDetail Object Can't be null");
		}
		
		EducationDetails educationDetailsSaved = educationDetailService.getEducationDetailById(id);
		
		if(educationDetailsSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		educationDetailService.updateEducationDetail(updatedEducationDetails);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
