package com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employees;
import com.entity.TrainingModules;

import jakarta.persistence.EntityManager;



@Repository
@Transactional
public class TrainingModuleDAOImpl implements TrainingModulesDAO {


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TrainingModules> getAllTrainingModules() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from TrainingModules",TrainingModules.class).getResultList();
	}

	@Override
	public void addTrainingModule(TrainingModules trainingModule) {
		entityManager.unwrap(Session.class).save(trainingModule) ;
		
	}

	@Override
	public void updateEmployee(TrainingModules trainingModule) {
		 entityManager.unwrap(Session.class).merge(trainingModule);
		
	}

	@Override
	public TrainingModules deleteTrainingModule(int trainingModuleId) {
		TrainingModules trainingModules= entityManager.unwrap(Session.class).find(TrainingModules.class, trainingModuleId);
		entityManager.remove(trainingModules);
		return trainingModules;
	}

	@Override
	public TrainingModules getTrainingModuleById(int trainingModuleId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(TrainingModules.class, trainingModuleId);
	}
	


}
