package com.valtech.training.firstspringboot.components;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

	void deleteEmployee(int id);
	void updateEmployee(Employee emp);
	void createEmployee(Employee emp) ;
	List<Employee> getAllEmployees();
	Employee getEmployee(int id) ;
	long count() ;
	
}