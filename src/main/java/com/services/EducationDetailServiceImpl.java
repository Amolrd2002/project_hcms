package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EducationDetailDAO;
import com.entity.EducationDetails;

@Service
public class EducationDetailServiceImpl implements EducationDetailService{

	
	@Autowired
	private EducationDetailDAO educationDetailDAO;

	@Override
	public List<EducationDetails> getAllEducationDetail() {
		// TODO Auto-generated method stub
		return educationDetailDAO.getAllEducationDetail();
	}

	@Override
	public void addEducationDetail(EducationDetails EducationDetail) {
		// TODO Auto-generated method stub
		educationDetailDAO.addEducationDetail(EducationDetail);
	}

	@Override
	public void updateEducationDetail(EducationDetails EducationDetail) {
		// TODO Auto-generated method stub
		educationDetailDAO.updateEducationDetail(EducationDetail);
	}

	@Override
	public EducationDetails deleteEducationDetail(int educationDetailId) {
		// TODO Auto-generated method stub
		return educationDetailDAO.deleteEducationDetail(educationDetailId);
	}

	@Override
	public EducationDetails getEducationDetailById(int educationDetailId) {
		// TODO Auto-generated method stub
		return educationDetailDAO.getEducationDetailById(educationDetailId);
	}


}
