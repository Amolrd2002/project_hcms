package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RolesDAO;
import com.entity.Roles;

@Service
public class RoleServicesImpl implements RolesService {

	@Autowired
	private RolesDAO rolesDAO;
	
	@Override
	public List<Roles> getAllRoles() {
		return rolesDAO.getAllRoles();
	}

	@Override
	public void addRole(Roles role) {
		rolesDAO.addRole(role);
		
	}

	@Override
	public void updateRole(Roles role) {
		 rolesDAO.updateRole(role);
		
	}

	@Override
	public Roles deleteRole(int roleId) {
		return rolesDAO.deleteRole(roleId);
		
	}

	@Override
	public Roles getRoleById(int roleId) {
		
		return rolesDAO.getRoleById(roleId);
	}

}
