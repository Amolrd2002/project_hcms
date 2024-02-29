package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SkillMatrix")
public class SkillMatrix {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int martrixId;

	private String skillName;

	private int skillLevel;

	private LocalDate date;

	public SkillMatrix() {

	}

	public SkillMatrix(int martrixId, String skillName, int skillLevel, LocalDate date, Employee employee) {

		this.martrixId = martrixId;
		this.skillName = skillName;
		this.skillLevel = skillLevel;
		this.date = date;
		this.employee = employee;
	}

	@ManyToOne
	private Employee employee;

	public int getMartrixId() {
		return martrixId;
	}

	public void setMartrixId(int martrixId) {
		this.martrixId = martrixId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "SkillMatrix [martrixId=" + martrixId + ", skillName=" + skillName + ", skillLevel=" + skillLevel
				+ ", date=" + date + ", employee=" + employee + "]";
	}

}
