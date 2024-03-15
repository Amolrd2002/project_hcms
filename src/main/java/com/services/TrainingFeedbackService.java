package com.services;

import java.util.List;

import com.entity.TrainingFeedback;

public interface TrainingFeedbackService {

	List<TrainingFeedback> getAllTrainingFeedbacks();

	void addTrainingFeedback(TrainingFeedback trainingFeedback);

	void updateTrainingFeedback(TrainingFeedback trainingFeedback);

	TrainingFeedback deleteTrainingFeedback(int trainingFeedbackId);

	TrainingFeedback getTrainingFeedbackById(int trainingFeedbackId);

}
