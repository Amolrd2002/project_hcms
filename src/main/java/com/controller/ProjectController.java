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
import com.entity.Projects;
import com.services.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	private ResponseEntity<List<Projects>> getAllDepartment(){
		return new ResponseEntity<List<Projects>>(projectService.getAllProjects(),HttpStatus.OK);
	}
	
	@PostMapping("/projects")
	public ResponseEntity<Void> addDepartment(@RequestBody Projects project,UriComponentsBuilder uriComponentsBuilder) {
		if(project ==null) {
			throw new RuntimeException("Project Object Can't be null");
		}
		projectService.addProject(project);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<Projects> getProjectById(@PathVariable("id") int id) {
		Projects pro = projectService.getProjectById(id);	
		if(pro == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<Projects>(pro, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/projects/{id}")
	public ResponseEntity<Projects> deleteProjectById(@PathVariable("id") int id) {
		Projects pro = projectService.getProjectById(id);
		
		if(pro==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Projects project= projectService.deleteProject(id);
		
		return new ResponseEntity<Projects>(project,HttpStatus.OK);
	}
	

	@PutMapping("/projects/{id}")
	public ResponseEntity<Void> updateProject(@RequestBody Projects updatedProject,@PathVariable("id") int id) {
		
		if(updatedProject==null) {
			throw new RuntimeException("Projects Object Can't be null");
		}
		
		Projects projectSaved = projectService.getProjectById(id);
		
		if(projectSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		projectService.updateProject(updatedProject);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
