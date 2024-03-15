package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.SkillUpgradation;


public interface SkillUpgradationDAO {

	List<SkillUpgradation> getAllSkillUpgradation();

	void addSkillUpgradation(SkillUpgradation skillUpgradation);
	
	void updateSkillUpgradation(SkillUpgradation skillUpgradation);

	SkillUpgradation deleteSkillUpgradation(int skillUpgradationId);
	
	SkillUpgradation getSkillUpgradationById(int skillUpgradationId);
	
}
