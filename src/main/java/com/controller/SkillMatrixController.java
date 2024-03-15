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
import com.entity.SkillMatrix;
import com.services.SkillMatrixService;

@RestController
public class SkillMatrixController {

	@Autowired
	private SkillMatrixService skillMatrixService;
	
	@GetMapping("/skillMatrix")
	private ResponseEntity<List<SkillMatrix>> getAllSkillMatrix(){
		return new ResponseEntity<List<SkillMatrix>>(skillMatrixService.getAllSkillMatrixs(),HttpStatus.OK);
	}
	
	@PostMapping("/skillMatrix")
	public ResponseEntity<Void> addSkillMatrix(@RequestBody SkillMatrix skillMatrix,UriComponentsBuilder uriComponentsBuilder) {
		if(skillMatrix ==null) {
			throw new RuntimeException("SkillMatrix Object Can't be null");
		}
		skillMatrixService.addSkillMatrix(skillMatrix);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/skillMatrix/{id}")
	public ResponseEntity<SkillMatrix> getSkillMatrixById(@PathVariable("id") int id) {
		SkillMatrix sm = skillMatrixService.getSkillMatrixById(id);	
		if(sm == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<SkillMatrix>(sm, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/skillMatrix/{id}")
	public ResponseEntity<SkillMatrix> deleteSkillMatrixById(@PathVariable("id") int id) {
		SkillMatrix sm = skillMatrixService.getSkillMatrixById(id);
		
		if(sm==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		SkillMatrix skillMatrix= skillMatrixService.deleteSkillMatrix(id);
		
		return new ResponseEntity<SkillMatrix>(skillMatrix,HttpStatus.OK);
	}
	

	@PutMapping("/skillMatrix/{id}")
	public ResponseEntity<Void> updateSkillMatrix(@RequestBody SkillMatrix updatedSkillMatrix,@PathVariable("id") int id) {
		
		if(updatedSkillMatrix==null) {
			throw new RuntimeException("SkillMatrix Object Can't be null");
		}
		
		SkillMatrix skillMatrixSaved = skillMatrixService.getSkillMatrixById(id);
		
		if(skillMatrixSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		skillMatrixService.updateSkillMatrix(updatedSkillMatrix);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
