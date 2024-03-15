package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.Projects;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Projects> getAllProjects() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from Projects",Projects.class).getResultList();
	}

	@Override
	public void addProject(Projects project) {
		entityManager.unwrap(Session.class).save(project);
		
	}

	@Override
	public void updateProject(Projects project) {
		 entityManager.unwrap(Session.class).merge(project);
		
	}

	@Override
	public Projects deleteProject(int projectId) {
		Projects project = entityManager.unwrap(Session.class).find(Projects.class, projectId);
		entityManager.remove(project);
		return project;
	}

	@Override
	public Projects getProjectById(int projectId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(Projects.class, projectId);
	}
	
}
