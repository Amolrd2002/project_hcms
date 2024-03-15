package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ProjectDAO;
import com.entity.Projects;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public List<Projects> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDAO.getAllProjects();
	}

	@Override
	public void addProject(Projects project) {
		// TODO Auto-generated method stub
		projectDAO.addProject(project);
	}

	@Override
	public void updateProject(Projects project) {
		// TODO Auto-generated method stub
		projectDAO.updateProject(project);
	}

	@Override
	public Projects deleteProject(int projectId) {
		// TODO Auto-generated method stub
		return projectDAO.deleteProject(projectId);
	}

	@Override
	public Projects getProjectById(int projectId) {
		// TODO Auto-generated method stub
		return projectDAO.getProjectById(projectId);
	}

	
	
}
