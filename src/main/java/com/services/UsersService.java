package com.services;

import java.util.List;

import com.entity.Users;


public interface UsersService {

	List<Users> getAllUsers();

	void addUsers( Users user);
	
	void updateUsers( Users user);

	Users deleteUsers(int userId);

	Users getUsersById(int userId);
	
}
