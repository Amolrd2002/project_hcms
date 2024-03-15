package com.dao;

import java.util.List;

import com.entity.Employees;
import com.entity.Vacancies;

public interface VacancieDAO {

	List<Vacancies> getAllVacancies();

	void addVacancie(Vacancies vacancies);

	void updateVacancie(Vacancies vacancies);

	Vacancies deleteVacancie(int vacancieId);

	Vacancies getVacancieById(int vacancieId);

}
