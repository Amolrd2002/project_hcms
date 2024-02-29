package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TrainingSchedules")
public class TrainingSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleId;

	private LocalDate startDate;

	private LocalDate endDate;

	private String location;

	private int maxParticipants;

	@ManyToOne
	private TrainingModule trainingModule;

	@ManyToOne
	private Trainer trainer;

	TrainingSchedule() {

	}

	public TrainingSchedule(int scheduleId, LocalDate startDate, LocalDate endDate, String location,
			int maxParticipants, TrainingModule trainingModule, Trainer trainer) {
		super();
		this.scheduleId = scheduleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.maxParticipants = maxParticipants;
		this.trainingModule = trainingModule;
		this.trainer = trainer;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public TrainingModule getTrainingModule() {
		return trainingModule;
	}

	public void setTrainingModule(TrainingModule trainingModule) {
		this.trainingModule = trainingModule;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "TrainingSchedule [scheduleId=" + scheduleId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", location=" + location + ", maxParticipants=" + maxParticipants + ", trainingModule="
				+ trainingModule + ", trainer=" + trainer + "]";
	}

}
