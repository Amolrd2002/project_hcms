package com.services;

import java.util.List;
import com.entity.EducationDetails;

public interface EducationDetailService {

	List<EducationDetails> getAllEducationDetail();

	void addEducationDetail(EducationDetails EducationDetail);
	
	void updateEducationDetail(EducationDetails EducationDetail);

	EducationDetails deleteEducationDetail(int educationDetailId);

	EducationDetails getEducationDetailById(int educationDetailId);
	
}
