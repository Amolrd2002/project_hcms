package com.dao;

import java.util.List;

import com.entity.Employees;
import com.entity.Roles;

public interface RolesDAO {

	List<Roles> getAllRoles();

	void addRole(Roles role);

	Roles updateRole(Roles role);

	void deleteRole(int roleId);

	Roles getRoleById(int roleId);

}
