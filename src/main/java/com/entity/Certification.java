package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Certifications")
public class Certification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int certificationId;

	private String certificationName;

	private String certificationAuthority;

	private LocalDate issueDate;

	private LocalDate expriyDate;

	@ManyToOne
	private Employee employee;

	public Certification() {

	}

	public Certification(int certificationId, String certificationName, String certificationAuthority,
			LocalDate issueDate, LocalDate expriyDate, Employee employee) {

		this.certificationId = certificationId;
		this.certificationName = certificationName;
		this.certificationAuthority = certificationAuthority;
		this.issueDate = issueDate;
		this.expriyDate = expriyDate;
		this.employee = employee;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getCertificationAuthority() {
		return certificationAuthority;
	}

	public void setCertificationAuthority(String certificationAuthority) {
		this.certificationAuthority = certificationAuthority;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpriyDate() {
		return expriyDate;
	}

	public void setExpriyDate(LocalDate expriyDate) {
		this.expriyDate = expriyDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Certification [certificationId=" + certificationId + ", certificationName=" + certificationName
				+ ", certificationAuthority=" + certificationAuthority + ", issueDate=" + issueDate + ", expriyDate="
				+ expriyDate + ", employee=" + employee + "]";
	}

}
