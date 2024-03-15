package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.VacancieDAO;
import com.entity.Vacancies;

@Service
public class VacancieServiceImpl implements VacancieService {

	@Autowired
	private VacancieDAO VacancieDAO;

	@Override
	public List<Vacancies> getAllVacancies() {
		return VacancieDAO.getAllVacancies();
	}

	@Override
	public void addVacancie(Vacancies vacancies) {
		VacancieDAO.addVacancie(vacancies);

	}

	@Override
	public void updateVacancie(Vacancies vacancies) {
		VacancieDAO.updateVacancie(vacancies);
	}

	@Override
	public Vacancies deleteVacancie(int vacancieId) {
		return VacancieDAO.deleteVacancie(vacancieId);
	}

	@Override
	public Vacancies getVacancieById(int vacancieId) {
		return VacancieDAO.getVacancieById(vacancieId);
	}

}
