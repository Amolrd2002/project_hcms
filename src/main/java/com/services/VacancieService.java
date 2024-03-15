package com.services;

import java.util.List;

import com.entity.Vacancies;

public interface VacancieService {

	List<Vacancies> getAllVacancies();

	void addVacancie(Vacancies vacancies);

	void updateVacancie(Vacancies vacancies);

	Vacancies deleteVacancie(int vacancieId);

	Vacancies getVacancieById(int vacancieId);

}
