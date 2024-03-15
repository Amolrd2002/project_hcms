package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TrainingScheduleDAO;
import com.entity.TrainingSchedules;

@Service
public class TrainingScheduleServiceImpl implements TrainingScheduleService {


	@Autowired
	private TrainingScheduleDAO trainingScheduleDAO;

	@Override
	public List<TrainingSchedules> getAllTrainingSchedule() {
		// TODO Auto-generated method stub
		return trainingScheduleDAO.getAllTrainingSchedule();
	}

	@Override
	public void addTrainingSchedule(TrainingSchedules trainingSchedule) {
		// TODO Auto-generated method stub
		trainingScheduleDAO.addTrainingSchedule(trainingSchedule);
	}

	@Override
	public void updateTrainingSchedule(TrainingSchedules trainingSchedule) {
		// TODO Auto-generated method stub
		trainingScheduleDAO.updateTrainingSchedule(trainingSchedule);
	}

	@Override
	public TrainingSchedules deleteTrainingSchedule(int trainingScheduleId) {
		// TODO Auto-generated method stub
		return trainingScheduleDAO.deleteTrainingSchedule(trainingScheduleId);
	}

	@Override
	public TrainingSchedules getTrainingScheduleById(int trainingScheduleId) {
		// TODO Auto-generated method stub
		return trainingScheduleDAO.getTrainingScheduleById(trainingScheduleId);
	}



}
