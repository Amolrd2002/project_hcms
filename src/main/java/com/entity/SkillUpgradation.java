package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SkillUpgradation")
public class SkillUpgradation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int upgradationId;

	private int skillName;

	private int previousSkillLevel;

	private int newSkillLevel;

	private LocalDate upgradationDate;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private Employee upgradedBy;

	public SkillUpgradation() {

	}

	public SkillUpgradation(int upgradationId, int skillName, int previousSkillLevel, int newSkillLevel,
			LocalDate upgradationDate, Employee employee, Employee upgradedBy) {
		super();
		this.upgradationId = upgradationId;
		this.skillName = skillName;
		this.previousSkillLevel = previousSkillLevel;
		this.newSkillLevel = newSkillLevel;
		this.upgradationDate = upgradationDate;
		this.employee = employee;
		this.upgradedBy = upgradedBy;
	}

	public int getUpgradationId() {
		return upgradationId;
	}

	public void setUpgradationId(int upgradationId) {
		this.upgradationId = upgradationId;
	}

	public int getSkillName() {
		return skillName;
	}

	public void setSkillName(int skillName) {
		this.skillName = skillName;
	}

	public int getPreviousSkillLevel() {
		return previousSkillLevel;
	}

	public void setPreviousSkillLevel(int previousSkillLevel) {
		this.previousSkillLevel = previousSkillLevel;
	}

	public int getNewSkillLevel() {
		return newSkillLevel;
	}

	public void setNewSkillLevel(int newSkillLevel) {
		this.newSkillLevel = newSkillLevel;
	}

	public LocalDate getUpgradationDate() {
		return upgradationDate;
	}

	public void setUpgradationDate(LocalDate upgradationDate) {
		this.upgradationDate = upgradationDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getUpgradedBy() {
		return upgradedBy;
	}

	public void setUpgradedBy(Employee upgradedBy) {
		this.upgradedBy = upgradedBy;
	}

	@Override
	public String toString() {
		return "SkillUpgradation [upgradationId=" + upgradationId + ", skillName=" + skillName + ", previousSkillLevel="
				+ previousSkillLevel + ", newSkillLevel=" + newSkillLevel + ", upgradationDate=" + upgradationDate
				+ ", employee=" + employee + ", upgradedBy=" + upgradedBy + "]";
	}

}
