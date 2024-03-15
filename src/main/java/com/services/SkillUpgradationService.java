package com.services;

import java.util.List;

import com.entity.SkillUpgradation;


public interface SkillUpgradationService {

	List<SkillUpgradation> getAllSkillUpgradation();

	void addSkillUpgradation(SkillUpgradation skillUpgradation);
	
	void updateSkillUpgradation(SkillUpgradation skillUpgradation);

	SkillUpgradation deleteSkillUpgradation(int skillUpgradationId);
	
	SkillUpgradation getSkillUpgradationById(int skillUpgradationId);
	
}
