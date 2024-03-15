package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.EducationDetails;
import com.entity.Employees;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EducationDetailDAOImpl implements EducationDetailDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EducationDetails> getAllEducationDetail() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from EducationDetails",EducationDetails.class).getResultList();
	}

	@Override
	public void addEducationDetail(EducationDetails EducationDetail) {
		entityManager.unwrap(Session.class).save(EducationDetail);
		
	}

	@Override
	public void updateEducationDetail(EducationDetails EducationDetail) {
		entityManager.unwrap(Session.class).merge(EducationDetail);
		
	}

	@Override
	public EducationDetails deleteEducationDetail(int educationDetailId) {
		EducationDetails educationDetails = entityManager.unwrap(Session.class).find(EducationDetails.class, educationDetailId);
		entityManager.remove(educationDetails);
		return educationDetails;
	}

	@Override
	public EducationDetails getEducationDetailById(int educationDetailId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(EducationDetails.class, educationDetailId);
	}


}
