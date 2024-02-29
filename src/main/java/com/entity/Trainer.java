package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Trainers")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trainerId;

	private boolean isExternal;

	@ManyToOne
	private Employee employee;

	public Trainer() {

	}

	public Trainer(int trainerId, boolean isExternal, Employee employee) {
		super();
		this.trainerId = trainerId;
		this.isExternal = isExternal;
		this.employee = employee;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public boolean isExternal() {
		return isExternal;
	}

	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", isExternal=" + isExternal + ", employee=" + employee + "]";
	}

}
