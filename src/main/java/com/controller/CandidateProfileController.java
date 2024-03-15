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
import com.entity.CandidateProfiles;
import com.services.CandidateProfileService;

@RestController
public class CandidateProfileController {

	@Autowired
	private CandidateProfileService candidateProfileService;
	
	@GetMapping("/candidateProfiles")
	private ResponseEntity<List<CandidateProfiles>> getAllCandidateProfiles(){
		return new ResponseEntity<List<CandidateProfiles>>(candidateProfileService.getAllcandidateProfile(),HttpStatus.OK);
	}
	
	@PostMapping("/candidateProfiles")
	public ResponseEntity<Void> addCandidateProfile(@RequestBody CandidateProfiles candidateProfile,UriComponentsBuilder uriComponentsBuilder) {
		if(candidateProfile ==null) {
			throw new RuntimeException("CandidateProfiles Object Can't be null");
		}
		candidateProfileService.addCandidateProfile(candidateProfile);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/candidateProfiles/{id}")
	public ResponseEntity<CandidateProfiles> getCadidateProfilesById(@PathVariable("id") int id) {
		CandidateProfiles cp = candidateProfileService.getCandidateProfileById(id);	
		if(cp == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<CandidateProfiles>(cp, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/candidateProfiles/{id}")
	public ResponseEntity<CandidateProfiles> deleteCandidateProfilesById(@PathVariable("id") int id) {
		CandidateProfiles cp = candidateProfileService.getCandidateProfileById(id);
		
		if(cp==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CandidateProfiles candidateProfiles= candidateProfileService.deleteCandidateProfile(id);
		
		return new ResponseEntity<CandidateProfiles>(candidateProfiles,HttpStatus.OK);
	}
	

	@PutMapping("/candidateProfiles/{id}")
	public ResponseEntity<Void> updateCandidateProfile(@RequestBody CandidateProfiles updatedCandidateProfile,@PathVariable("id") int id) {
		
		if(updatedCandidateProfile==null) {
			throw new RuntimeException("CandidateProfiles Object Can't be null");
		}
		
		CandidateProfiles departmentSaved = candidateProfileService.getCandidateProfileById(id);
		
		if(departmentSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		candidateProfileService.updateCandidateProfile(updatedCandidateProfile);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
