package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.AppraisalFormDAO;
import com.entity.AppraisalForms;

@Service
public class AppraisalFormServicesImpl implements AppraisalFormServices{

	
	@Autowired
	private AppraisalFormDAO appraisalFormDAO;

	@Override
	public List<AppraisalForms> getAllAppraisalForm() {
		// TODO Auto-generated method stub
		return appraisalFormDAO.getAllAppraisalForm();
	}

	@Override
	public void addAppraisalForm(AppraisalForms appraisalForm) {
		// TODO Auto-generated method stub
		appraisalFormDAO.addAppraisalForm(appraisalForm);
	}

	@Override
	public void updateAppraisalForm(AppraisalForms appraisalForm) {
		// TODO Auto-generated method stub
		appraisalFormDAO.updateAppraisalForm(appraisalForm);
	}

	@Override
	public AppraisalForms deleteAppraisalForm(int appraisalFormId) {
		// TODO Auto-generated method stub
		return appraisalFormDAO.deleteAppraisalForm(appraisalFormId);
	}

	@Override
	public AppraisalForms getAppraisalFormById(int appraisalFormId) {
		// TODO Auto-generated method stub
		return appraisalFormDAO.getAppraisalFormById(appraisalFormId);
	}

	

}
