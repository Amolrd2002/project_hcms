package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vacancies")
public class Vacancie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vacancyId;

	private String position;

	private String requiredSkillSet;

	private int numberOfOpenings;

	@ManyToOne
	private Department department;

	public Vacancie() {

	}

	public Vacancie(int vacancyId, String position, String requiredSkillSet, int numberOfOpenings,
			Department department) {

		this.vacancyId = vacancyId;
		this.position = position;
		this.requiredSkillSet = requiredSkillSet;
		this.numberOfOpenings = numberOfOpenings;
		this.department = department;
	}

	public int getVacancyId() {
		return vacancyId;
	}

	public void setVacancyId(int vacancyId) {
		this.vacancyId = vacancyId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRequiredSkillSet() {
		return requiredSkillSet;
	}

	public void setRequiredSkillSet(String requiredSkillSet) {
		this.requiredSkillSet = requiredSkillSet;
	}

	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}

	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Vacancie [vacancyId=" + vacancyId + ", position=" + position + ", requiredSkillSet=" + requiredSkillSet
				+ ", numberOfOpenings=" + numberOfOpenings + ", department=" + department + "]";
	}

}
