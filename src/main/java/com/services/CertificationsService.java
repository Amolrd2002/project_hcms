package com.services;

import java.util.List;

import com.entity.Certifications;


public interface CertificationsService {

	List<Certifications> getAllCertification();

	void addCertification(Certifications certification);
	
	void updateCertification(Certifications certification);

	Certifications deleteCertification(int certificationId);

	Certifications getCertificationById(int certificationId);
	
}
