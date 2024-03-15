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
import com.entity.Vacancies;
import com.services.VacancieService;

@RestController
public class VacanciesController {

	@Autowired
	private VacancieService vacancieService;
	
	@GetMapping("/vacancies")
	private ResponseEntity<List<Vacancies>> getAllVacancies(){
		return new ResponseEntity<List<Vacancies>>(vacancieService.getAllVacancies(),HttpStatus.OK);
	}
	
	@PostMapping("/vacancies")
	public ResponseEntity<Void> addVacancie(@RequestBody Vacancies vacancie,UriComponentsBuilder uriComponentsBuilder) {
		if(vacancie ==null) {
			throw new RuntimeException("Vacancies Object Can't be null");
		}
		vacancieService.addVacancie(vacancie);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/vacancies/{id}")
	public ResponseEntity<Vacancies> getVacancieById(@PathVariable("id") int id) {
		Vacancies vc = vacancieService.getVacancieById(id);	
		if(vc == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<Vacancies>(vc, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/vacancies/{id}")
	public ResponseEntity<Vacancies> deleteVacancieById(@PathVariable("id") int id) {
		Vacancies vs = vacancieService.getVacancieById(id);
		
		if(vs==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Vacancies vacancie= vacancieService.deleteVacancie(id);
		
		return new ResponseEntity<Vacancies>(vacancie,HttpStatus.OK);
	}
	

	@PutMapping("/vacancies/{id}")
	public ResponseEntity<Void> updateVacancie(@RequestBody Vacancies updatedVacancie,@PathVariable("id") int id) {
		
		if(updatedVacancie==null) {
			throw new RuntimeException("Department Object Can't be null");
		}
		
		Vacancies vacanciesSaved = vacancieService.getVacancieById(id);
		
		if(vacanciesSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		vacancieService.updateVacancie(updatedVacancie);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
