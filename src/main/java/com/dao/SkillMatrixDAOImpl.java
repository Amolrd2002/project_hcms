package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.SkillMatrix;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillMatrixDAOImpl implements SkillMatrixDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<SkillMatrix> getAllSkillMatrixs() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from SkillMatrix",SkillMatrix.class).getResultList();
	}

	@Override
	public void addSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.unwrap(Session.class).save(skillMatrix);
		
	}

	@Override
	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.unwrap(Session.class).merge(skillMatrix);
		
	}

	@Override
	public SkillMatrix deleteSkillMatrix(int skillMatrixId) {
		SkillMatrix skillMatrix = entityManager.unwrap(Session.class).find(SkillMatrix.class, skillMatrixId);
		entityManager.remove(skillMatrix);
		return skillMatrix;
	}

	@Override
	public SkillMatrix getSkillMatrixById(int skillMatrixId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(SkillMatrix.class, skillMatrixId);
	}

}
