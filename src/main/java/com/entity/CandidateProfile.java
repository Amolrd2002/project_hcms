package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CandidateProfiles")
public class CandidateProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int candidateId;

	@ManyToOne
	private Employee employee;

	public CandidateProfile() {

	}

	public CandidateProfile(int candidateId, Employee employee) {

		this.candidateId = candidateId;
		this.employee = employee;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "CandidateProfile [candidateId=" + candidateId + ", employee=" + employee + "]";
	}

}
