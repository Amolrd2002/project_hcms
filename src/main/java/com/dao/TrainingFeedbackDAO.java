package com.dao;

import java.util.List;

import com.entity.Employees;
import com.entity.TrainingFeedback;

public interface TrainingFeedbackDAO {

	List<TrainingFeedback> getAllTrainingFeedbacks();

	void addTrainingFeedback(TrainingFeedback trainingFeedback);

	void updateTrainingFeedback(TrainingFeedback trainingFeedback);

	TrainingFeedback deleteTrainingFeedback(int trainingFeedbackId);

	TrainingFeedback getTrainingFeedbackById(int trainingFeedbackId);

}
