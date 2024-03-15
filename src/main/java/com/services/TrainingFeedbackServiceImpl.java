package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TrainingFeedbackDAO;
import com.entity.TrainingFeedback;

@Service
public class TrainingFeedbackServiceImpl implements TrainingFeedbackService {


	@Autowired
	private TrainingFeedbackDAO trainingFeedbackDAO;

	@Override
	public List<TrainingFeedback> getAllTrainingFeedbacks() {
		// TODO Auto-generated method stub
		return trainingFeedbackDAO.getAllTrainingFeedbacks();
	}

	@Override
	public void addTrainingFeedback(TrainingFeedback trainingFeedback) {
		// TODO Auto-generated method stub
		trainingFeedbackDAO.addTrainingFeedback(trainingFeedback);
	}

	@Override
	public void updateTrainingFeedback(TrainingFeedback trainingFeedback) {
		// TODO Auto-generated method stub
		trainingFeedbackDAO.updateTrainingFeedback(trainingFeedback);
	}

	@Override
	public TrainingFeedback deleteTrainingFeedback(int trainingFeedbackId) {
		// TODO Auto-generated method stub
		return trainingFeedbackDAO.deleteTrainingFeedback(trainingFeedbackId);
	}

	@Override
	public TrainingFeedback getTrainingFeedbackById(int trainingFeedbackId) {
		// TODO Auto-generated method stub
		return trainingFeedbackDAO.getTrainingFeedbackById(trainingFeedbackId);
	}

	


}
