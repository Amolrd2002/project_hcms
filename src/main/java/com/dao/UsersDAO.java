package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.Users;


public interface UsersDAO {

	List<Users> getAllUsers();

	void addUsers( Users user);
	
	void updateUsers( Users user);

	Users deleteUsers(int userId);

	Users getUsersById(int userId);
	
}
