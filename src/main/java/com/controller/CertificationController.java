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
import com.entity.Certifications;
import com.services.CertificationsService;

@RestController
public class CertificationController {

	@Autowired
	private CertificationsService certificationsService;
	
	@GetMapping("/certifications")
	private ResponseEntity<List<Certifications>> getAllCertifications(){
		return new ResponseEntity<List<Certifications>>(certificationsService.getAllCertification(),HttpStatus.OK);
	}
	
	@PostMapping("/certifications")
	public ResponseEntity<Void> addCertifications(@RequestBody Certifications certifications,UriComponentsBuilder uriComponentsBuilder) {
		if(certifications ==null) {
			throw new RuntimeException("Certifications Object Can't be null");
		}
		certificationsService.addCertification(certifications);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/certifications/{id}")
	public ResponseEntity<Certifications> getCertificationsById(@PathVariable("id") int id) {
		Certifications certification = certificationsService.getCertificationById(id);	
		if(certification == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<Certifications>(certification, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/certifications/{id}")
	public ResponseEntity<Certifications> deleteCertificationsById(@PathVariable("id") int id) {
		Certifications cs = certificationsService.getCertificationById(id);
		
		if(cs==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Certifications certifications= certificationsService.deleteCertification(id);
		
		return new ResponseEntity<Certifications>(certifications,HttpStatus.OK);
	}
	

	@PutMapping("/certifications/{id}")
	public ResponseEntity<Void> updateCertifications(@RequestBody Certifications updatedCertifications,@PathVariable("id") int id) {
		
		if(updatedCertifications==null) {
			throw new RuntimeException("Certifications Object Can't be null");
		}
		
		Certifications certificationsSaved = certificationsService.getCertificationById(id);
		
		if(certificationsSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		certificationsService.updateCertification(certificationsSaved);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
