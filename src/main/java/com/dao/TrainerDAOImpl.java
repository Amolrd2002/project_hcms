package com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employees;
import com.entity.Roles;
import com.entity.Trainers;

import jakarta.persistence.EntityManager;



@Repository
@Transactional
public class TrainerDAOImpl implements TrainerDAO {


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Trainers> getAllTrainers() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from Trainers",Trainers.class).getResultList();
	}

	@Override
	public void addTrainer(Trainers trainer) {
		entityManager.unwrap(Session.class).save(trainer) ;
		
	}

	@Override
	public void updateTrainer(Trainers trainer) {
		entityManager.unwrap(Session.class).merge(trainer);
		
	}

	@Override
	public Trainers deleteTrainer(int trainerId) {
		Trainers trainer= entityManager.unwrap(Session.class).find(Trainers.class, trainerId);
		entityManager.remove(trainer);
		return trainer;
	}

	@Override
	public Trainers getTrainerById(int trainerId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(Trainers.class, trainerId);
	}

}
