package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CandidateProfileDAO;
import com.entity.CandidateProfiles;

@Service
public class CandidateProfileServiceImpl implements CandidateProfileService {


	@Autowired
	private CandidateProfileDAO candidateProfileDAO;

	@Override
	public List<CandidateProfiles> getAllcandidateProfile() {
		// TODO Auto-generated method stub
		return candidateProfileDAO.getAllcandidateProfile();
	}

	@Override
	public void addCandidateProfile(CandidateProfiles candidateProfile) {
		// TODO Auto-generated method stub
		candidateProfileDAO.addCandidateProfile(candidateProfile);
	}

	@Override
	public void updateCandidateProfile(CandidateProfiles candidateProfile) {
		// TODO Auto-generated method stub
		candidateProfileDAO.updateCandidateProfile(candidateProfile);
	}

	@Override
	public CandidateProfiles deleteCandidateProfile(int candidateProfileId) {
		// TODO Auto-generated method stub
		return candidateProfileDAO.deleteCandidateProfile(candidateProfileId);
	}

	@Override
	public CandidateProfiles getCandidateProfileById(int candidateProfileId) {
		// TODO Auto-generated method stub
		return candidateProfileDAO.getCandidateProfileById(candidateProfileId);
	}

	


}
