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
import com.entity.Trainers;
import com.services.TrainerService;

@RestController
public class TrainerController {

	@Autowired
	private TrainerService trainerService;

	@GetMapping("/trainers")
	private ResponseEntity<List<Trainers>> getAllTrainers() {
		return new ResponseEntity<List<Trainers>>(trainerService.getAllTrainers(), HttpStatus.OK);
	}

	@PostMapping("/trainers")
	public ResponseEntity<Void> addTrainer(@RequestBody Trainers trainers, UriComponentsBuilder uriComponentsBuilder) {
		if (trainers == null) {
			throw new RuntimeException("Trainers Object Can't be null");
		}
		trainerService.addTrainer(trainers);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/trainers/{id}")
	public ResponseEntity<Trainers> getTrainerById(@PathVariable("id") int id) {
		Trainers tr = trainerService.getTrainerById(id);
		if (tr == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Trainers>(tr, HttpStatus.OK);
		}

	}

	@DeleteMapping("/trainers/{id}")
	public ResponseEntity<Trainers> deleteTrainerById(@PathVariable("id") int id) {
		Trainers tr = trainerService.getTrainerById(id);

		if (tr == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Trainers trainers = trainerService.deleteTrainer(id);

		return new ResponseEntity<Trainers>(trainers, HttpStatus.OK);
	}

	@PutMapping("/trainers/{id}")
	public ResponseEntity<Void> updateTrainer(@RequestBody Trainers updatedTrainer, @PathVariable("id") int id) {

		if (updatedTrainer == null) {
			throw new RuntimeException("Trainer Object Can't be null");
		}

		Trainers departmentSaved = trainerService.getTrainerById(id);

		if (departmentSaved == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		trainerService.updateTrainer(updatedTrainer);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
