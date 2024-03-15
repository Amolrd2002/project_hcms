package com.services;

import java.util.List;
import com.entity.ExternalTrainers;

public interface ExternalTrainersService {

	List<ExternalTrainers> getAllExternalTrainer();

	void addExternalTrainer(ExternalTrainers externalTrainers);
	
	void updateExternalTrainer(ExternalTrainers externalTrainers);

	ExternalTrainers deleteExternalTrainer(int externalTrainersId);

	ExternalTrainers getExternalTrainerById(int externalTrainersId);
	
}
