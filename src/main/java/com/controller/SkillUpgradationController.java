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
import com.entity.SkillUpgradation;
import com.services.SkillUpgradationService;

@RestController
public class SkillUpgradationController {

	@Autowired
	private SkillUpgradationService skillUpgradationService;
	
	@GetMapping("/skillUpgradation")
	private ResponseEntity<List<SkillUpgradation>> getAllDepartment(){
		return new ResponseEntity<List<SkillUpgradation>>(skillUpgradationService.getAllSkillUpgradation(),HttpStatus.OK);
	}
	
	@PostMapping("/skillUpgradation")
	public ResponseEntity<Void> addSkillUpgradation(@RequestBody SkillUpgradation skillUpgradation,UriComponentsBuilder uriComponentsBuilder) {
		if(skillUpgradation ==null) {
			throw new RuntimeException("SkillUpgradation Object Can't be null");
		}
		skillUpgradationService.addSkillUpgradation(skillUpgradation);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/skillUpgradation/{id}")
	public ResponseEntity<SkillUpgradation> getSkillUpgradationById(@PathVariable("id") int id) {
		SkillUpgradation su = skillUpgradationService.getSkillUpgradationById(id);	
		if(su == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<SkillUpgradation>(su, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/skillUpgradation/{id}")
	public ResponseEntity<SkillUpgradation> deleteSkillUpgradationById(@PathVariable("id") int id) {
		SkillUpgradation su = skillUpgradationService.getSkillUpgradationById(id);
		
		if(su==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		SkillUpgradation skillUpgradation= skillUpgradationService.deleteSkillUpgradation(id);
		
		return new ResponseEntity<SkillUpgradation>(skillUpgradation,HttpStatus.OK);
	}
	

	@PutMapping("/skillUpgradation/{id}")
	public ResponseEntity<Void> updateSkillUpgradation(@RequestBody SkillUpgradation updatedSkillUpgradation,@PathVariable("id") int id) {
		
		if(updatedSkillUpgradation==null) {
			throw new RuntimeException("SkillUpgradation Object Can't be null");
		}
		
		SkillUpgradation skillUpgradationSaved = skillUpgradationService.getSkillUpgradationById(id);
		
		if(skillUpgradationSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		skillUpgradationService.updateSkillUpgradation(updatedSkillUpgradation);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
