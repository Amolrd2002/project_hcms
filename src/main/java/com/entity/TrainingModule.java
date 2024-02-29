package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TrainingModules")
public class TrainingModule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int moduleId;
	
	private String moduleName;
	
	private String description;
	
	private int duration;
	
	public TrainingModule() {

	}

	public TrainingModule(int moduleId, String moduleName, String description, int duration) {
		
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.description = description;
		this.duration = duration;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "TrainingModule [moduleId=" + moduleId + ", moduleName=" + moduleName + ", description=" + description
				+ ", duration=" + duration + "]";
	}
	
	
	
}
