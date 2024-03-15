package com.dao;

import java.util.List;

import com.entity.Departments;
import com.entity.Employees;
import com.entity.Projects;


public interface ProjectDAO {

	List<Projects> getAllProjects();

	void addProject(Projects project);
	
	void updateProject(Projects project);

	Projects deleteProject(int projectId);

	Projects getProjectById(int projectId);
	
}
