package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ApplicationStatusDAO;
import com.entity.ApplicationStatus;

@Service
public class ApplicationStatusServicesImpl implements ApplicationStatusServices{

	
	@Autowired
	private ApplicationStatusDAO applicationStatusDAO;

	@Override
	public List<ApplicationStatus> getAllApplicationStatus() {
		// TODO Auto-generated method stub
		return applicationStatusDAO.getAllApplicationStatus();
	}

	@Override
	public void addApplicationStatus(ApplicationStatus applicationStatus) {
		// TODO Auto-generated method stub
		applicationStatusDAO.addApplicationStatus(applicationStatus);
	}

	@Override
	public void updateApplicationStatus(ApplicationStatus applicationStatus) {
		// TODO Auto-generated method stub
		applicationStatusDAO.updateApplicationStatus(applicationStatus);
	}

	@Override
	public ApplicationStatus deleteApplicationStatus(int applicationStatusId) {
		// TODO Auto-generated method stub
		return applicationStatusDAO.deleteApplicationStatus(applicationStatusId);
	}

	@Override
	public ApplicationStatus getApplicationStatusById(int applicationStatusId) {
		// TODO Auto-generated method stub
		return applicationStatusDAO.getApplicationStatusById(applicationStatusId);
	}
	
}
