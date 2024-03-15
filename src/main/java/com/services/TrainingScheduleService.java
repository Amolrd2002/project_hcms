package com.services;

import java.util.List;

import com.entity.TrainingSchedules;

public interface TrainingScheduleService {

	List<TrainingSchedules> getAllTrainingSchedule();

	void addTrainingSchedule(TrainingSchedules trainingSchedule);

	void updateTrainingSchedule(TrainingSchedules trainingSchedule);

	TrainingSchedules deleteTrainingSchedule(int trainingScheduleId);

	TrainingSchedules getTrainingScheduleById(int trainingScheduleId);

}
