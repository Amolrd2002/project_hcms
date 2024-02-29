package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AppraisalForms")
public class AppraisalForms {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int formId;

	private LocalDate submissionDate;

	private int rating;

	private String comments;

	@ManyToOne
	private Employee reviewer;

	@ManyToOne
	private Employee employee;

	public AppraisalForms() {

	}

	public AppraisalForms(int formId, LocalDate submissionDate, int rating, String comments, Employee reviewer,
			Employee employee) {
		super();
		this.formId = formId;
		this.submissionDate = submissionDate;
		this.rating = rating;
		this.comments = comments;
		this.reviewer = reviewer;
		this.employee = employee;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Employee getReviewer() {
		return reviewer;
	}

	public void setReviewer(Employee reviewer) {
		this.reviewer = reviewer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AppraisalForms [formId=" + formId + ", submissionDate=" + submissionDate + ", rating=" + rating
				+ ", comments=" + comments + ", reviewer=" + reviewer + ", employee=" + employee + "]";
	}

}
