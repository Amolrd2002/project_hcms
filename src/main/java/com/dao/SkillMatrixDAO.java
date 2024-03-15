package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.SkillMatrix;


public interface SkillMatrixDAO {

	List<SkillMatrix> getAllSkillMatrixs();

	void addSkillMatrix(SkillMatrix skillMatrix);
	
	void updateSkillMatrix(SkillMatrix skillMatrix);

	SkillMatrix deleteSkillMatrix(int skillMatrixId);

	SkillMatrix getSkillMatrixById(int skillMatrixId);
	
}
