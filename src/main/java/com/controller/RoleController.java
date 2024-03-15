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
import com.entity.Roles;
import com.services.RolesService;

@RestController
public class RoleController {

	@Autowired
	private RolesService rolesService;

	@GetMapping("/roles")
	private ResponseEntity<List<Roles>> getAlll() {
		return new ResponseEntity<List<Roles>>(rolesService.getAllRoles(), HttpStatus.OK);
	}

	@PostMapping("/roles")
	public ResponseEntity<Void> addRole(@RequestBody Roles role, UriComponentsBuilder uriComponentsBuilder) {
		if (role == null) {
			throw new RuntimeException("Role Object cant be null");
		}
		rolesService.addRole(role);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/roles/{id}")
	public ResponseEntity<Roles> getRoleById(@PathVariable("id") int id) {
		Roles role = rolesService.getRoleById(id);
		if (role == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Roles>(role, HttpStatus.OK);

		}
	}

	@DeleteMapping("/roles/{id}")
	public ResponseEntity<Roles> deleteRoleById(@PathVariable("id") int id) {
		Roles deletedrole = rolesService.getRoleById(id);
		if (deletedrole == null) {
			return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
		}
		Roles role = rolesService.deleteRole(id);
		return new ResponseEntity<Roles>(role, HttpStatus.OK);
	}

	@PutMapping("/roles/{id}")
	public ResponseEntity<Void> updateRole(@RequestBody Roles updatedRole,@PathVariable("id") int id) {
		if(updatedRole==null) {
			throw new RuntimeException("Role Object Can't be null");
		}

		Roles existingRole = rolesService.getRoleById(id);
		
		if(existingRole==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		rolesService.updateRole(updatedRole);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
