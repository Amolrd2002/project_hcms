package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TrainingFeedback")
public class TrainingFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;

	private String feedbackComments;

	private int satisfactionRating;

	@ManyToOne
	private TrainingSchedule trainingSchedule;

	@ManyToOne
	private Employee employee;

	public TrainingFeedback() {

	}

	public TrainingFeedback(int feedbackId, String feedbackComments, int satisfactionRating,
			TrainingSchedule trainingSchedule, Employee employee) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackComments = feedbackComments;
		this.satisfactionRating = satisfactionRating;
		this.trainingSchedule = trainingSchedule;
		this.employee = employee;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackComments() {
		return feedbackComments;
	}

	public void setFeedbackComments(String feedbackComments) {
		this.feedbackComments = feedbackComments;
	}

	public int getSatisfactionRating() {
		return satisfactionRating;
	}

	public void setSatisfactionRating(int satisfactionRating) {
		this.satisfactionRating = satisfactionRating;
	}

	public TrainingSchedule getTrainingSchedule() {
		return trainingSchedule;
	}

	public void setTrainingSchedule(TrainingSchedule trainingSchedule) {
		this.trainingSchedule = trainingSchedule;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "TrainingFeedback [feedbackId=" + feedbackId + ", feedbackComments=" + feedbackComments
				+ ", satisfactionRating=" + satisfactionRating + ", trainingSchedule=" + trainingSchedule
				+ ", employee=" + employee + "]";
	}

}
