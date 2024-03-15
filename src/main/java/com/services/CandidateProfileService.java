package com.services;

import java.util.List;

import com.entity.CandidateProfiles;


public interface CandidateProfileService {

	List<CandidateProfiles> getAllcandidateProfile();

	void addCandidateProfile(CandidateProfiles candidateProfile);

	void updateCandidateProfile(CandidateProfiles candidateProfile);

	CandidateProfiles deleteCandidateProfile(int candidateProfileId);

	CandidateProfiles getCandidateProfileById(int candidateProfileId);

}
