package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.EducationDetails;
import com.entity.Employees;


public interface EducationDetailDAO {

	List<EducationDetails> getAllEducationDetail();

	void addEducationDetail(EducationDetails EducationDetail);
	
	void updateEducationDetail(EducationDetails EducationDetail);

	EducationDetails deleteEducationDetail(int educationDetailId);

	EducationDetails getEducationDetailById(int educationDetailId);
	
}
