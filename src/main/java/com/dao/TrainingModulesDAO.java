package com.dao;

import java.util.List;

import com.entity.Employees;
import com.entity.TrainingModules;

public interface TrainingModulesDAO {

	List<TrainingModules> getAllTrainingModules();

	void addTrainingModule(TrainingModules trainingModule);

	void updateEmployee(TrainingModules trainingModule);

	TrainingModules deleteTrainingModule(int trainingModuleId);

	TrainingModules getTrainingModuleById(int trainingModuleId);

}
