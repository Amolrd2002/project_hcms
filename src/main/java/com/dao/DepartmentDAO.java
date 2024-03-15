package com.dao;

import java.util.List;
import com.entity.Departments;

public interface DepartmentDAO {

	List<Departments> getAllDepartment();

	void addDepartment(Departments department);

	void updateDepartment(Departments department);

	Departments deleteDepartment(int departmentId);

	Departments getDepartmentById(int deparmentId);

}
