package com.services;

import java.util.List;
import com.entity.ApplicationStatus;

public interface ApplicationStatusServices {

	List<ApplicationStatus> getAllApplicationStatus();

	void addApplicationStatus(ApplicationStatus applicationStatus);
	
	void updateApplicationStatus(ApplicationStatus applicationStatus);

	ApplicationStatus deleteApplicationStatus(int applicationStatusId);

	ApplicationStatus getApplicationStatusById(int applicationStatusId);
	
}
