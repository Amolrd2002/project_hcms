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
import com.entity.TrainingFeedback;
import com.services.TrainingFeedbackService;

@RestController
public class TrainingFeedbackController {

	@Autowired
	private TrainingFeedbackService trainingFeedbackService;
	
	@GetMapping("/trainingFeedback")
	private ResponseEntity<List<TrainingFeedback>> getAllTrainingFeedback(){
		return new ResponseEntity<List<TrainingFeedback>>(trainingFeedbackService.getAllTrainingFeedbacks(),HttpStatus.OK);
	}
	
	@PostMapping("/trainingFeedback")
	public ResponseEntity<Void> addTrainingFeedback(@RequestBody TrainingFeedback trainingFeedback,UriComponentsBuilder uriComponentsBuilder) {
		if(trainingFeedback ==null) {
			throw new RuntimeException("trainingFeedback Object Can't be null");
		}
		trainingFeedbackService.addTrainingFeedback(trainingFeedback);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/trainingFeedback/{id}")
	public ResponseEntity<TrainingFeedback> getTrainingFeedbackById(@PathVariable("id") int id) {
		TrainingFeedback tf = trainingFeedbackService.getTrainingFeedbackById(id);	
		if(tf == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<TrainingFeedback>(tf, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/trainingFeedback/{id}")
	public ResponseEntity<TrainingFeedback> deleteTrainingFeedbackById(@PathVariable("id") int id) {
		TrainingFeedback tf = trainingFeedbackService.getTrainingFeedbackById(id);
		
		if(tf==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		TrainingFeedback trainingFeedback= trainingFeedbackService.deleteTrainingFeedback(id);
		
		return new ResponseEntity<TrainingFeedback>(trainingFeedback,HttpStatus.OK);
	}
	

	@PutMapping("/trainingFeedback/{id}")
	public ResponseEntity<Void> updateTrainingFeedback(@RequestBody TrainingFeedback updatedTrainingFeedback,@PathVariable("id") int id) {
		
		if(updatedTrainingFeedback==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		
		TrainingFeedback trainingFeedbackSaved = trainingFeedbackService.getTrainingFeedbackById(id);
		
		if(trainingFeedbackSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		trainingFeedbackService.updateTrainingFeedback(updatedTrainingFeedback);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
