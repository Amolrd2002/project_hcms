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
import com.entity.ExternalTrainers;
import com.services.ExternalTrainersService;

@RestController
public class ExternalTrainerController {

	@Autowired
	private ExternalTrainersService externalTrainersService;
	
	@GetMapping("/externalTrainers")
	private ResponseEntity<List<ExternalTrainers>> getAllExternalTrainers(){
		return new ResponseEntity<List<ExternalTrainers>>(externalTrainersService.getAllExternalTrainer(),HttpStatus.OK);
	}
	
	@PostMapping("/externalTrainers")
	public ResponseEntity<Void> addExternalTrainer(@RequestBody ExternalTrainers externalTrainer,UriComponentsBuilder uriComponentsBuilder) {
		if(externalTrainer ==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		externalTrainersService.addExternalTrainer(externalTrainer);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/externalTrainers/{id}")
	public ResponseEntity<ExternalTrainers> getExternalTrainerById(@PathVariable("id") int id) {
		ExternalTrainers et = externalTrainersService.getExternalTrainerById(id);	
		if(et == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<ExternalTrainers>(et, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/externalTrainers/{id}")
	public ResponseEntity<ExternalTrainers> deleteExternalTrainerById(@PathVariable("id") int id) {
		ExternalTrainers et = externalTrainersService.getExternalTrainerById(id);
		
		if(et==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ExternalTrainers externalTrainers= externalTrainersService.deleteExternalTrainer(id);
		
		return new ResponseEntity<ExternalTrainers>(externalTrainers,HttpStatus.OK);
	}
	

	@PutMapping("/externalTrainers/{id}")
	public ResponseEntity<Void> updateExternalTrainer(@RequestBody ExternalTrainers updatedExternalTrainer,@PathVariable("id") int id) {
		
		if(updatedExternalTrainer==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		
		ExternalTrainers externalTrainersSaved = externalTrainersService.getExternalTrainerById(id);
		
		if(externalTrainersSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		externalTrainersService.updateExternalTrainer(updatedExternalTrainer);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
