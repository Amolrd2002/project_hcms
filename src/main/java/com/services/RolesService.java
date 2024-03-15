package com.services;

import java.util.List;

import com.entity.Roles;

public interface RolesService {

	List<Roles> getAllRoles();

	void addRole(Roles role);

	void updateRole(Roles role);

	Roles deleteRole(int roleId);

	Roles getRoleById(int roleId);
}
