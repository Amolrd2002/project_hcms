package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.ExternalTrainers;


public interface ExternalTrainersDAO {

	List<ExternalTrainers> getAllExternalTrainer();

	void addExternalTrainer(ExternalTrainers externalTrainers);
	
	void updateExternalTrainer(ExternalTrainers externalTrainers);

	ExternalTrainers deleteExternalTrainer(int externalTrainersId);

	ExternalTrainers getExternalTrainerById(int externalTrainersId);
	
}
