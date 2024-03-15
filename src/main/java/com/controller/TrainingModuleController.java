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
import com.entity.TrainingModules;
import com.services.TrainingModulesService;

@RestController
public class TrainingModuleController {

	@Autowired
	private TrainingModulesService trainingModulesService;
	
	@GetMapping("/trainingModules")
	private ResponseEntity<List<TrainingModules>> getAllTrainingModule(){
		return new ResponseEntity<List<TrainingModules>>(trainingModulesService.getAllTrainingModules(),HttpStatus.OK);
	}
	
	@PostMapping("/trainingModules")
	public ResponseEntity<Void> addTrainingModule(@RequestBody TrainingModules trainingModule,UriComponentsBuilder uriComponentsBuilder) {
		if(trainingModule ==null) {
			throw new RuntimeException("TrainingModules Object Can't be null");
		}
		trainingModulesService.addTrainingModule(trainingModule);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/trainingModules/{id}")
	public ResponseEntity<TrainingModules> getTrainingModuleById(@PathVariable("id") int id) {
		TrainingModules tm = trainingModulesService.getTrainingModuleById(id);	
		if(tm == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<TrainingModules>(tm, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/trainingModules/{id}")
	public ResponseEntity<TrainingModules> deleteTrainingModuleById(@PathVariable("id") int id) {
		TrainingModules tm = trainingModulesService.getTrainingModuleById(id);
		
		if(tm==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		TrainingModules trainingModule= trainingModulesService.deleteTrainingModule(id);
		
		return new ResponseEntity<TrainingModules>(trainingModule,HttpStatus.OK);
	}
	

	@PutMapping("/trainingModules/{id}")
	public ResponseEntity<Void> updateTrainingModule(@RequestBody TrainingModules updatedTrainingModule,@PathVariable("id") int id) {
		
		if(updatedTrainingModule==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		
		TrainingModules trainingModulesSaved = trainingModulesService.getTrainingModuleById(id);
		
		if(trainingModulesSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		trainingModulesService.updateTrainingModule(updatedTrainingModule);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
