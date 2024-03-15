package com.services;

import java.util.List;

import com.entity.TrainingModules;

public interface TrainingModulesService {

	List<TrainingModules> getAllTrainingModules();

	void addTrainingModule(TrainingModules trainingModule);

	void updateTrainingModule(TrainingModules trainingModule);

	TrainingModules deleteTrainingModule(int trainingModuleId);

	TrainingModules getTrainingModuleById(int trainingModuleId);

}
