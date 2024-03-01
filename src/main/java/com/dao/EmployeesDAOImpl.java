package com.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.config.JdbcConfig;
import com.entity.Employees;

public class EmployeesDAOImpl implements EmployeesDAO {

//	private HibernateTemplate hibernateTemplate;

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employees> getAllEmployees() {

//		return this.getJdbcTemplate().queryForList("select * from employees");
		System.out.println("running");
		return null;
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		EmployeesDAO employeeDAO = context.getBean("employeesDAO", EmployeesDAO.class);
		employeeDAO.getAllEmployees();
	}

}
