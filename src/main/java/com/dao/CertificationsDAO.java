package com.dao;

import java.util.List;

import com.entity.Certifications;


public interface CertificationsDAO {

	List<Certifications> getAllCertification();

	void addCertification(Certifications certification);
	
	void updateCertification(Certifications certification);

	Certifications deleteCertification(int certificationId);

	Certifications getCertificationById(int certificationId);
	
}
