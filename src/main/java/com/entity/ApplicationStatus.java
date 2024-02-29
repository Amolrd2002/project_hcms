package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ApplicationStatus")
public class ApplicationStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicationId;

	private String status;

	private LocalDate applicationDate;

	private String applicationNotes;

	@ManyToOne
	private CandidateProfile candidateProfile;

	@ManyToOne
	private Vacancie vacancie;

	public ApplicationStatus() {

	}

	public ApplicationStatus(int applicationId, String status, LocalDate applicationDate, String applicationNotes,
			CandidateProfile candidateProfile, Vacancie vacancie) {

		this.applicationId = applicationId;
		this.status = status;
		this.applicationDate = applicationDate;
		this.applicationNotes = applicationNotes;
		this.candidateProfile = candidateProfile;
		this.vacancie = vacancie;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getApplicationNotes() {
		return applicationNotes;
	}

	public void setApplicationNotes(String applicationNotes) {
		this.applicationNotes = applicationNotes;
	}

	public CandidateProfile getCandidateProfile() {
		return candidateProfile;
	}

	public void setCandidateProfile(CandidateProfile candidateProfile) {
		this.candidateProfile = candidateProfile;
	}

	public Vacancie getVacancie() {
		return vacancie;
	}

	public void setVacancie(Vacancie vacancie) {
		this.vacancie = vacancie;
	}

	@Override
	public String toString() {
		return "ApplicationStatus [applicationId=" + applicationId + ", status=" + status + ", applicationDate="
				+ applicationDate + ", applicationNotes=" + applicationNotes + ", candidateProfile=" + candidateProfile
				+ ", vacancie=" + vacancie + "]";
	}

}
