package com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employees;
import com.entity.Vacancies;

import jakarta.persistence.EntityManager;



@Repository
@Transactional
public class VacancieDAOImpl implements VacancieDAO {


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Vacancies> getAllVacancies() {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).createQuery("from Vacancies",Vacancies.class).getResultList();
	}

	@Override
	public void addVacancie(Vacancies vacancies) {
		entityManager.unwrap(Session.class).save(vacancies) ;
		
	}

	@Override
	public void updateVacancie(Vacancies vacancies) {
		entityManager.unwrap(Session.class).merge(vacancies);
		
	}

	@Override
	public Vacancies deleteVacancie(int vacancieId) {
		Vacancies vacancie= entityManager.unwrap(Session.class).find(Vacancies.class, vacancieId);
		entityManager.remove(vacancie);
		return vacancie;
	}

	@Override
	public Vacancies getVacancieById(int vacancieId) {
		// TODO Auto-generated method stub
		return entityManager.unwrap(Session.class).find(Vacancies.class, vacancieId);
	}

}
