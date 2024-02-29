package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeManagers")
public class EmployeeManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int relationshipId;

	private String relationshipType;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private Employee manager;

	public EmployeeManager() {

	}

	public EmployeeManager(int relationshipId, String relationshipType, Employee employee, Employee manager) {
		super();
		this.relationshipId = relationshipId;
		this.relationshipType = relationshipType;
		this.employee = employee;
		this.manager = manager;
	}

	public int getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "EmployeeManager [relationshipId=" + relationshipId + ", relationshipType=" + relationshipType
				+ ", employee=" + employee + ", manager=" + manager + "]";
	}

}
