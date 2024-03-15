package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.entity.CandidateProfiles;
import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CandidateProfileDAOImpl implements CandidateProfileDAO {


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<CandidateProfiles> getAllcandidateProfile() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from CandidateProfiles",CandidateProfiles.class).getResultList();
	}

	@Override
	public void addCandidateProfile(CandidateProfiles candidateProfile) {
		entityManager.unwrap(Session.class).save(candidateProfile) ;
		
	}

	@Override
	public void updateCandidateProfile(CandidateProfiles candidateProfile) {
		entityManager.unwrap(Session.class).merge(candidateProfile);
		
	}

	@Override
	public CandidateProfiles deleteCandidateProfile(int candidateProfileId) {
		CandidateProfiles candidateProfiles= entityManager.unwrap(Session.class).find(CandidateProfiles.class, candidateProfileId);
		entityManager.remove(candidateProfiles);
		return candidateProfiles;
	}

	@Override
	public CandidateProfiles getCandidateProfileById(int candidateProfileId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(CandidateProfiles.class, candidateProfileId);
	}



}
