package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SkillMatrixDAO;
import com.entity.SkillMatrix;

@Service
public class SkillMatrixServiceImpl implements SkillMatrixService{

	
	@Autowired
	private SkillMatrixDAO skillMatrixDAO;

	@Override
	public List<SkillMatrix> getAllSkillMatrixs() {
		// TODO Auto-generated method stub
		return skillMatrixDAO.getAllSkillMatrixs();
	}

	@Override
	public void addSkillMatrix(SkillMatrix skillMatrix) {
		// TODO Auto-generated method stub
		skillMatrixDAO.addSkillMatrix(skillMatrix);
	}

	@Override
	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		// TODO Auto-generated method stub
		skillMatrixDAO.updateSkillMatrix(skillMatrix);
	}

	@Override
	public SkillMatrix deleteSkillMatrix(int skillMatrixId) {
		// TODO Auto-generated method stub
		return skillMatrixDAO.deleteSkillMatrix(skillMatrixId);
	}

	@Override
	public SkillMatrix getSkillMatrixById(int skillMatrixId) {
		// TODO Auto-generated method stub
		return skillMatrixDAO.getSkillMatrixById(skillMatrixId);
	}

	
	

}
