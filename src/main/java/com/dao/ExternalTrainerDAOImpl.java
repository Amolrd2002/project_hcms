package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.ExternalTrainers;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExternalTrainerDAOImpl implements ExternalTrainersDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<ExternalTrainers> getAllExternalTrainer() {
		return entityManager.unwrap(Session.class).createQuery("from ExternalTrainers",ExternalTrainers.class).getResultList();
		
	}

	@Override
	public void addExternalTrainer(ExternalTrainers externalTrainers) {
		entityManager.unwrap(Session.class).save(externalTrainers);
		
	}

	@Override
	public void updateExternalTrainer(ExternalTrainers externalTrainers) {
		entityManager.unwrap(Session.class).merge(externalTrainers);
		
	}

	@Override
	public ExternalTrainers deleteExternalTrainer(int externalTrainersId) {
		ExternalTrainers externalTrainer = entityManager.unwrap(Session.class).find(ExternalTrainers.class, externalTrainersId);
		entityManager.remove(externalTrainer);
		return externalTrainer;
	}

	@Override
	public ExternalTrainers getExternalTrainerById(int externalTrainersId) {
		// TODO Auto-generated method stub
		 return entityManager.unwrap(Session.class).find(ExternalTrainers.class, externalTrainersId);
	}

}
