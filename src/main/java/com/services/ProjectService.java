package com.services;

import java.util.List;
import com.entity.Projects;
public interface ProjectService {

	List<Projects> getAllProjects();

	void addProject(Projects project);
	
	void updateProject(Projects project);

	Projects deleteProject(int projectId);

	Projects getProjectById(int projectId);
	
}
