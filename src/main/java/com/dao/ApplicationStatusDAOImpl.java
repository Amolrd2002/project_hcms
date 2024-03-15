package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entity.ApplicationStatus;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ApplicationStatusDAOImpl implements ApplicationStatusDAO{

	
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<ApplicationStatus> getAllApplicationStatus() {
		
		return entityManager.unwrap(Session.class).createQuery("from ApplicationStatus",ApplicationStatus.class).getResultList();
	}

	@Override
	public void addApplicationStatus(ApplicationStatus applicationStatus) {
		entityManager.unwrap(Session.class).save(applicationStatus);
	}

	@Override
	public void updateApplicationStatus(ApplicationStatus applicationStatus) {
		
		 entityManager.unwrap(Session.class).merge(applicationStatus);
	}

	@Override
	public ApplicationStatus deleteApplicationStatus(int applicationStatusId) {
		ApplicationStatus applicationStatus = entityManager.unwrap(Session.class).find(ApplicationStatus.class, applicationStatusId);
		entityManager.remove(applicationStatus);
		return applicationStatus;
	}

	@Override
	public ApplicationStatus getApplicationStatusById(int applicationStatusId) {
		
		return entityManager.unwrap(Session.class).find(ApplicationStatus.class, applicationStatusId);
	}

}
