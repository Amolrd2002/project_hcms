package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Employees;
import com.entity.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RolesDAOImpl implements RolesDAO {

	
	@Autowired
	private EntityManager entityManager;


	
	@Override
	public List<Roles> getAllRoles() {
		
		return entityManager.unwrap(Session.class).createQuery("from Roles",Roles.class).getResultList();
	}

	@Override
	public void addRole(Roles role) {
		entityManager.unwrap(Session.class).save(role);
		
	}

	@Override
	public Roles updateRole(Roles role) {
		
		return entityManager.unwrap(Session.class).merge(role);
	}

	@Override
	public void deleteRole(int roleId) {
		Roles role =  entityManager.unwrap(Session.class).find(Roles.class,roleId );
		entityManager.remove(role);
		
	}

	@Override
	public Roles getRoleById(int roleId) {
		
		return entityManager.unwrap(Session.class).find(Roles.class,roleId);
	}

}
