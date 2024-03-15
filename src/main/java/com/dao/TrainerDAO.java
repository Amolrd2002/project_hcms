package com.dao;

import java.util.List;

import com.entity.Employees;
import com.entity.Trainers;

public interface TrainerDAO {

	List<Trainers> getAllTrainers();

	void addTrainer(Trainers trainer);

	void updateTrainer(Trainers trainer);

	Trainers deleteTrainer(int trainerId);

	Trainers getTrainerById(int trainerId);

}
