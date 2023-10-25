package com.valtech.training.emp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

	void deleteEmployee(int id) throws SQLException;
	
	
	void updateEmployee(Employee emp) throws SQLException;
	void createEmployee(Employee emp) throws SQLException;
	List<Employee> getAllEmployees() throws SQLException;
	List<Employee> getEmployeeAgeBetween(int minAge,int maxAge) throws SQLException;
	Employee getEmployee(int id) throws SQLException;
	long count() throws SQLException;

	
	List<Employee> getEmployeeByDeptLocation(String deptLoc) throws SQLException;
	List<Employee> getEmployeeByDeptName(String deptName) throws SQLException;
	List<Employee> getEmployeeBySeniority(int limitVal) throws SQLException;
	List<Employee> getEmployeeSalaryGreater(int amount) throws SQLException;
	List<Employee> getEmployeeSalaryLesser(int maxSalary) throws SQLException;


	Map<String, List<String>> getListOfEmployeesInEachDepartment() throws SQLException;


	


	


	
	

	

}