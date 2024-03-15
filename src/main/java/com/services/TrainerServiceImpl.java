package com.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TrainerDAO;
import com.entity.Trainers;

@Service
public class TrainerServiceImpl implements TrainerService {


	@Autowired
	private TrainerDAO trainerDAO;

	@Override
	public List<Trainers> getAllTrainers() {
		// TODO Auto-generated method stub
		return trainerDAO.getAllTrainers();
	}

	@Override
	public void addTrainer(Trainers trainer) {
		// TODO Auto-generated method stub
		trainerDAO.addTrainer(trainer);
	}

	@Override
	public void updateTrainer(Trainers trainer) {
		// TODO Auto-generated method stub
		trainerDAO.updateTrainer(trainer);
	}

	@Override
	public Trainers deleteTrainer(int trainerId) {
		// TODO Auto-generated method stub
		return trainerDAO.deleteTrainer(trainerId);
	}

	@Override
	public Trainers getTrainerById(int trainerId) {
		// TODO Auto-generated method stub
		return trainerDAO.getTrainerById(trainerId);
	}

	
	

}
