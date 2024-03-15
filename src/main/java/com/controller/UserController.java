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
import com.entity.Users;
import com.services.UsersService;

@RestController
public class UserController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users")
	private ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(usersService.getAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> addUser(@RequestBody Users users,UriComponentsBuilder uriComponentsBuilder) {
		if(users ==null) {
			throw new RuntimeException("User Object Can't be null");
		}
		usersService.addUsers(users);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable("id") int id) {
		Users user = usersService.getUsersById(id);	
		if(user == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Users> deleteUserById(@PathVariable("id") int id) {
		Users u = usersService.getUsersById(id);
		
		if(u==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Users user= usersService.deleteUsers(id);
		
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	

	@PutMapping("/users/{id}")
	public ResponseEntity<Void> updateUser(@RequestBody Users updatedUser,@PathVariable("id") int id) {
		
		if(updatedUser==null) {
			throw new RuntimeException("Users Object Can't be null");
		}
		
		Users userSaved = usersService.getUsersById(id);
		
		if(userSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		 usersService.updateUsers(updatedUser);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
