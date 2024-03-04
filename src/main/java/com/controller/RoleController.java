package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.RolesDAO;
import com.entity.Employees;
import com.entity.Roles;
import com.services.RolesService;

@RestController
public class RoleController {

	@Autowired
	private RolesService rolesService;
	
	@GetMapping("/roles")
	private ResponseEntity<List<Roles>> getAlll(){
		return new ResponseEntity<List<Roles>>(rolesService.getAllRoles(),HttpStatus.OK);
	}
	
	@PostMapping("/roles")
	public ResponseEntity<Void> addRole(@RequestBody Roles role) {
		rolesService.addRole(role);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/roles/{roleId}")
	public ResponseEntity<Roles> getRoleById(@PathVariable("roleId") int roleId) {
		Roles role = rolesService.getRoleById(roleId);

		return new ResponseEntity<Roles>(role, HttpStatus.OK);
	}
	
	

	@DeleteMapping("/roles/{roleId}")
	public ResponseEntity<Void> deleteRoleById(@PathVariable("roleId") int roleId) {
		rolesService.deleteRole(roleId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/roles")
	public ResponseEntity<Roles> updateRole(@RequestBody Roles role) {

		Roles roleSaved = rolesService.updateRole(role);

		return new ResponseEntity<Roles>(roleSaved, HttpStatus.CREATED);
	}
}
