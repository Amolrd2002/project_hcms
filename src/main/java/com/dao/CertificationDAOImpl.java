package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entity.Certifications;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CertificationDAOImpl implements CertificationsDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Certifications> getAllCertification() {

		return entityManager.unwrap(Session.class).createQuery("from Certifications", Certifications.class)
				.getResultList();
	}

	@Override
	public void addCertification(Certifications certification) {

		entityManager.unwrap(Session.class).save(certification);
	}

	@Override
	public void updateCertification(Certifications certification) {
		entityManager.unwrap(Session.class).merge(certification);

	}

	@Override
	public Certifications deleteCertification(int certificationId) {
		Certifications certifications = entityManager.unwrap(Session.class).find(Certifications.class, certificationId);
		entityManager.remove(certifications);
		return certifications;
	}

	@Override
	public Certifications getCertificationById(int certificationId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(Certifications.class, certificationId);
	}

}
