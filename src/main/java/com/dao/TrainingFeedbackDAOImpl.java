package com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employees;
import com.entity.TrainingFeedback;

import jakarta.persistence.EntityManager;



@Repository
@Transactional
public class TrainingFeedbackDAOImpl implements TrainingFeedbackDAO {


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TrainingFeedback> getAllTrainingFeedbacks() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from TrainingFeedback",TrainingFeedback.class).getResultList();
	}

	@Override
	public void addTrainingFeedback(TrainingFeedback trainingFeedback) {
		entityManager.unwrap(Session.class).save(trainingFeedback) ;
		
	}

	@Override
	public void updateTrainingFeedback(TrainingFeedback trainingFeedback) {
		entityManager.unwrap(Session.class).merge(trainingFeedback);
		
	}

	@Override
	public TrainingFeedback deleteTrainingFeedback(int trainingFeedbackId) {
		TrainingFeedback trainingFeedback = entityManager.unwrap(Session.class).find(TrainingFeedback.class, trainingFeedbackId);
		 entityManager.remove(trainingFeedback);
		 return trainingFeedback;
	}

	@Override
	public TrainingFeedback getTrainingFeedbackById(int trainingFeedbackId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(TrainingFeedback.class, trainingFeedbackId);
	}

	


}
