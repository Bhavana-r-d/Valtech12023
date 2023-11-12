package com.assignment.employeeProject;

import java.sql.SQLException;
import java.util.List;



public interface EmployeeDAO {
	
	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;
	
	List<Employee> getEmployeeSeniority(int seniority) throws SQLException ;
	
	List<Employee> getEmployeeSalaryGreater(int salary) throws SQLException;
	
	List<Employee> getEmployeeSalaryLesser(int salary) throws SQLException;
	
	List<Employee> getEmployeeAgeBetween(int min, int max) throws SQLException;
	
	long count() throws SQLException;


	


	

	

	

}