package com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employees;
import com.entity.TrainingSchedules;

import jakarta.persistence.EntityManager;



@Repository
@Transactional
public class TrainingScheduleDAOImpl implements TrainingScheduleDAO {


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TrainingSchedules> getAllTrainingSchedule() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from TrainingSchedules",TrainingSchedules.class).getResultList();
	}

	@Override
	public void addTrainingSchedule(TrainingSchedules trainingSchedule) {
		entityManager.unwrap(Session.class).save(trainingSchedule) ;
		
	}

	@Override
	public void updateTrainingSchedule(TrainingSchedules trainingSchedule) {
		entityManager.unwrap(Session.class).merge(trainingSchedule);
		
	}

	@Override
	public TrainingSchedules deleteTrainingSchedule(int trainingScheduleId) {
		TrainingSchedules trainingSchedules= entityManager.unwrap(Session.class).find(TrainingSchedules.class, trainingScheduleId);
		entityManager.remove(trainingSchedules);
		return trainingSchedules;
	}

	@Override
	public TrainingSchedules getTrainingScheduleById(int trainingScheduleId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(TrainingSchedules.class, trainingScheduleId);
	}
	


}
