package com.dao;

import java.util.List;

import com.entity.Employees;
import com.entity.Roles;

public interface RolesDAO {

	List<Roles> getAllRoles();

	void addRole(Roles role);

	void updateRole(Roles role);

	Roles deleteRole(int roleId);

	Roles getRoleById(int roleId);

}
