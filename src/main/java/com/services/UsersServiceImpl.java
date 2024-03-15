package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.UsersDAO;
import com.entity.Users;

@Service
public class UsersServiceImpl implements UsersService{

	
	@Autowired
	private UsersDAO UsersDAO;

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return UsersDAO.getAllUsers();
	}

	@Override
	public void addUsers(Users user) {
		// TODO Auto-generated method stub
		UsersDAO.addUsers(user);
	}

	@Override
	public void updateUsers(Users user) {
		// TODO Auto-generated method stub
		UsersDAO.updateUsers(user);
	}

	@Override
	public Users deleteUsers(int userId) {
		// TODO Auto-generated method stub
		return UsersDAO.deleteUsers(userId);
	}

	@Override
	public Users getUsersById(int userId) {
		// TODO Auto-generated method stub
		return UsersDAO.getUsersById(userId);
	}

	

}
