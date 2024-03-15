package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SkillUpgradationDAO;
import com.entity.SkillUpgradation;

@Service
public class SkillUpgradationServiceImpl implements SkillUpgradationService{

	
	@Autowired
	private SkillUpgradationDAO SkillUpgradationDAO;

	@Override
	public List<SkillUpgradation> getAllSkillUpgradation() {
		// TODO Auto-generated method stub
		return SkillUpgradationDAO.getAllSkillUpgradation();
	}

	@Override
	public void addSkillUpgradation(SkillUpgradation skillUpgradation) {
		// TODO Auto-generated method stub
		SkillUpgradationDAO.addSkillUpgradation(skillUpgradation);
	}

	@Override
	public void updateSkillUpgradation(SkillUpgradation skillUpgradation) {
		// TODO Auto-generated method stub
		SkillUpgradationDAO.updateSkillUpgradation(skillUpgradation);
	}

	@Override
	public SkillUpgradation deleteSkillUpgradation(int skillUpgradationId) {
		// TODO Auto-generated method stub
		return SkillUpgradationDAO.deleteSkillUpgradation(skillUpgradationId);
	}

	@Override
	public SkillUpgradation getSkillUpgradationById(int skillUpgradationId) {
		// TODO Auto-generated method stub
		return SkillUpgradationDAO.deleteSkillUpgradation(skillUpgradationId);
	}

	
	
}
