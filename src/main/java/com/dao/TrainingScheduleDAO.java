package com.dao;

import java.util.List;

import com.entity.Employees;
import com.entity.TrainingSchedules;

public interface TrainingScheduleDAO {

	List<TrainingSchedules> getAllTrainingSchedule();

	void addTrainingSchedule(TrainingSchedules trainingSchedule);

	void updateTrainingSchedule(TrainingSchedules trainingSchedule);

	TrainingSchedules deleteTrainingSchedule(int trainingScheduleId);

	TrainingSchedules getTrainingScheduleById(int trainingScheduleId);

}
