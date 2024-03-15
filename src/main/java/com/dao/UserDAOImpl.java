package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UsersDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from Users",Users.class).getResultList();
	}

	@Override
	public void addUsers(Users user) {
		entityManager.unwrap(Session.class).save(user);
		
	}

	@Override
	public void updateUsers(Users user) {
		entityManager.unwrap(Session.class).merge(user);
		
	}

	@Override
	public Users deleteUsers(int userId) {
		Users user = entityManager.unwrap(Session.class).find(Users.class, userId);
		entityManager.remove(user);
		return user;
	}

	@Override
	public Users getUsersById(int userId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(Users.class, userId);
	}

}
