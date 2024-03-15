package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ExternalTrainersDAO;
import com.entity.ExternalTrainers;

@Service
public class ExternalTrainersServiceImpl implements ExternalTrainersService{

	
	@Autowired
	private ExternalTrainersDAO externalTrainersDAO;

	@Override
	public List<ExternalTrainers> getAllExternalTrainer() {
		// TODO Auto-generated method stub
		return externalTrainersDAO.getAllExternalTrainer();
	}

	@Override
	public void addExternalTrainer(ExternalTrainers externalTrainers) {
		// TODO Auto-generated method stub
		externalTrainersDAO.addExternalTrainer(externalTrainers);
	}

	@Override
	public void updateExternalTrainer(ExternalTrainers externalTrainers) {
		// TODO Auto-generated method stub
		externalTrainersDAO.updateExternalTrainer(externalTrainers);
	}

	@Override
	public ExternalTrainers deleteExternalTrainer(int externalTrainersId) {
		// TODO Auto-generated method stub
		return externalTrainersDAO.deleteExternalTrainer(externalTrainersId);
	}

	@Override
	public ExternalTrainers getExternalTrainerById(int externalTrainersId) {
		// TODO Auto-generated method stub
		return externalTrainersDAO.getExternalTrainerById(externalTrainersId);
	}

	
	
}
