package com.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TrainingModulesDAO;
import com.entity.TrainingModules;

@Service
public class TrainingModulesServiceImpl implements TrainingModulesService {


	@Autowired
	private TrainingModulesDAO trainingModulesDAO;

	@Override
	public List<TrainingModules> getAllTrainingModules() {
		// TODO Auto-generated method stub
		return trainingModulesDAO.getAllTrainingModules();
	}

	@Override
	public void addTrainingModule(TrainingModules trainingModule) {
		// TODO Auto-generated method stub
		trainingModulesDAO.addTrainingModule(trainingModule);
	}

	@Override
	public void updateTrainingModule(TrainingModules trainingModule) {
		// TODO Auto-generated method stub
		trainingModulesDAO.updateEmployee(trainingModule);
	}

	@Override
	public TrainingModules deleteTrainingModule(int trainingModuleId) {
		// TODO Auto-generated method stub
		return trainingModulesDAO.deleteTrainingModule(trainingModuleId);
	}

	@Override
	public TrainingModules getTrainingModuleById(int trainingModuleId) {
		// TODO Auto-generated method stub
		return trainingModulesDAO.getTrainingModuleById(trainingModuleId);
	}

	

}
