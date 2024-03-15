package com.services;

import java.util.List;


import com.entity.Trainers;

public interface TrainerService {

	List<Trainers> getAllTrainers();

	void addTrainer(Trainers trainer);

	void updateTrainer(Trainers trainer);

	Trainers deleteTrainer(int trainerId);

	Trainers getTrainerById(int trainerId);

}
