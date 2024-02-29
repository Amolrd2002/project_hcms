package com.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EducationDetails")
public class EducationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int educationId;

	private String degree;

	private String institute;

	private String major;

	private int graduationYear;

	private BigDecimal GPA;

	@ManyToOne
	private Employee employee;

	public EducationDetail() {

	}

	public EducationDetail(int educationId, String degree, String institute, String major, int graduationYear,
			BigDecimal gPA, Employee employee) {
		super();
		this.educationId = educationId;
		this.degree = degree;
		this.institute = institute;
		this.major = major;
		this.graduationYear = graduationYear;
		GPA = gPA;
		this.employee = employee;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	public BigDecimal getGPA() {
		return GPA;
	}

	public void setGPA(BigDecimal gPA) {
		GPA = gPA;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EducationDetail [educationId=" + educationId + ", degree=" + degree + ", institute=" + institute
				+ ", major=" + major + ", graduationYear=" + graduationYear + ", GPA=" + GPA + ", employee=" + employee
				+ "]";
	}

}
