package com.services;

import java.util.List;

import com.entity.AppraisalForms;



public interface AppraisalFormServices {

	List<AppraisalForms> getAllAppraisalForm();

	void addAppraisalForm(AppraisalForms appraisalForm);
	
	void updateAppraisalForm(AppraisalForms appraisalForm);

	AppraisalForms deleteAppraisalForm(int appraisalFormId);

	AppraisalForms getAppraisalFormById(int appraisalFormId);
	
}
