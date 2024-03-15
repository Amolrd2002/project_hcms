package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.SkillUpgradation;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillUpgradationDAOImpl implements SkillUpgradationDAO{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<SkillUpgradation> getAllSkillUpgradation() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from SkillUpgradation",SkillUpgradation.class).getResultList();
	}

	@Override
	public void addSkillUpgradation(SkillUpgradation skillUpgradation) {
		entityManager.unwrap(Session.class).save(skillUpgradation);
		
	}

	@Override
	public void updateSkillUpgradation(SkillUpgradation skillUpgradation) {
		entityManager.unwrap(Session.class).merge(skillUpgradation);
		
	}

	@Override
	public SkillUpgradation deleteSkillUpgradation(int skillUpgradationId) {
		SkillUpgradation skillUpgradation = entityManager.unwrap(Session.class).find(SkillUpgradation.class, skillUpgradationId);
		entityManager.remove(skillUpgradation);
		return skillUpgradation;
	}

	@Override
	public SkillUpgradation getSkillUpgradationById(int skillUpgradationId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(SkillUpgradation.class, skillUpgradationId);
	}
	
}
