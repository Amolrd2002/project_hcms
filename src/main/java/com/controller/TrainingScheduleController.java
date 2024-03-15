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
import com.entity.TrainingSchedules;
import com.services.TrainingScheduleService;

@RestController
public class TrainingScheduleController {

	@Autowired
	private TrainingScheduleService trainingScheduleService;
	
	@GetMapping("/trainingSchedules")
	private ResponseEntity<List<TrainingSchedules>> getAllTrainingSchedule(){
		return new ResponseEntity<List<TrainingSchedules>>(trainingScheduleService.getAllTrainingSchedule(),HttpStatus.OK);
	}
	
	@PostMapping("/trainingSchedules")
	public ResponseEntity<Void> addTrainingSchedules(@RequestBody TrainingSchedules trainingSchedules,UriComponentsBuilder uriComponentsBuilder) {
		if(trainingSchedules ==null) {
			throw new RuntimeException("TrainingSchedule Object Can't be null");
		}
		trainingScheduleService.addTrainingSchedule(trainingSchedules);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/trainingSchedules/{id}")
	public ResponseEntity<TrainingSchedules> getTrainingScheduleById(@PathVariable("id") int id) {
		TrainingSchedules ts = trainingScheduleService.getTrainingScheduleById(id);	
		if(ts == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<TrainingSchedules>(ts, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/trainingSchedules/{id}")
	public ResponseEntity<TrainingSchedules> deleteTrainingScheduleById(@PathVariable("id") int id) {
		TrainingSchedules ts = trainingScheduleService.getTrainingScheduleById(id);
		
		if(ts==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		TrainingSchedules trainingSchedules= trainingScheduleService.deleteTrainingSchedule(id);
		
		return new ResponseEntity<TrainingSchedules>(trainingSchedules,HttpStatus.OK);
	}
	

	@PutMapping("/trainingSchedules/{id}")
	public ResponseEntity<Void> updateTrainingSchedules(@RequestBody TrainingSchedules updatedTrainingSchedule,@PathVariable("id") int id) {
		
		if(updatedTrainingSchedule==null) {
			throw new RuntimeException("TrainingSchedule Object Can't be null");
		}
		
		TrainingSchedules trainingSchedulesSaved = trainingScheduleService.getTrainingScheduleById(id);
		
		if(trainingSchedulesSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		trainingScheduleService.updateTrainingSchedule(updatedTrainingSchedule);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
