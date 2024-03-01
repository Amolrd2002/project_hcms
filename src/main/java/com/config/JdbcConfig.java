package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dao.EmployeesDAO;
import com.dao.EmployeesDAOImpl;

import jakarta.activation.DataSource;

public class JdbcConfig {

	@Bean(name = { "dataSourceObj" })
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/hcms");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("9503359529");
		return driverManagerDataSource;
	}

	@Bean(name = { "jdbcTemplate" })
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

	@Bean(name = { "employeesDAO" })
	public EmployeesDAO getEmployeesDAO() {
		EmployeesDAOImpl employeesDAO = new EmployeesDAOImpl();
		employeesDAO.setJdbcTemplate(getJdbcTemplate());
		return employeesDAO;
	}

}
