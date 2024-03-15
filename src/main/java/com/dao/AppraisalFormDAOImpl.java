package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entity.AppraisalForms;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AppraisalFormDAOImpl implements AppraisalFormDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<AppraisalForms> getAllAppraisalForm() {
		
		return entityManager.unwrap(Session.class).createQuery("from AppraisalForms",AppraisalForms.class).getResultList();
	}

	@Override
	public void addAppraisalForm(AppraisalForms appraisalForm) {
		entityManager.unwrap(Session.class).save(appraisalForm);
		
	}

	@Override
	public void updateAppraisalForm(AppraisalForms appraisalForm) {
		 entityManager.unwrap(Session.class).merge(appraisalForm);
		
	}

	@Override
	public AppraisalForms deleteAppraisalForm(int appraisalFormId) {
		AppraisalForms appraisalForms = entityManager.unwrap(Session.class).find(AppraisalForms.class, appraisalFormId);
		entityManager.remove(appraisalForms);
		return appraisalForms;
	}

	@Override
	public AppraisalForms getAppraisalFormById(int appraisalFormId) {
		
		return entityManager.unwrap(Session.class).find(AppraisalForms.class, appraisalFormId);
	}

}
