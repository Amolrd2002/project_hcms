package com.services;

import java.util.List;
import com.entity.SkillMatrix;
public interface SkillMatrixService {

	List<SkillMatrix> getAllSkillMatrixs();

	void addSkillMatrix(SkillMatrix skillMatrix);
	
	void updateSkillMatrix(SkillMatrix skillMatrix);

	SkillMatrix deleteSkillMatrix(int skillMatrixId);

	SkillMatrix getSkillMatrixById(int skillMatrixId);
	
}
