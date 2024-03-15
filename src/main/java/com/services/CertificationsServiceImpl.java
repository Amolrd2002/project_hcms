package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CertificationsDAO;
import com.entity.Certifications;

@Service
public class CertificationsServiceImpl implements CertificationsService{

	
	@Autowired
	private CertificationsDAO certificationsDAO;

	@Override
	public List<Certifications> getAllCertification() {
		// TODO Auto-generated method stub
		return certificationsDAO.getAllCertification();
	}

	@Override
	public void addCertification(Certifications certification) {
		// TODO Auto-generated method stub
		certificationsDAO.addCertification(certification);
	}

	@Override
	public void updateCertification(Certifications certification) {
		// TODO Auto-generated method stub
		certificationsDAO.updateCertification(certification);
	}

	@Override
	public Certifications deleteCertification(int certificationId) {
		// TODO Auto-generated method stub
		return certificationsDAO.deleteCertification(certificationId);
	}

	@Override
	public Certifications getCertificationById(int certificationId) {
		// TODO Auto-generated method stub
		return certificationsDAO.getCertificationById(certificationId);
	}
	
	


}
