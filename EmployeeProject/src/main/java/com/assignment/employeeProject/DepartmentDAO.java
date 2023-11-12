package com.assignment.employeeProject;

import java.sql.*;

import java.util.List;

public interface DepartmentDAO {

	void deleteDepartment(int deptId) throws SQLException;

	void updateDepartment(Department dep) throws SQLException;

	void createDepartment(Department dep) throws SQLException;

	List<Department> getAllDepartment() throws SQLException;

	Department getDepartment(int deptId) throws SQLException;
	
	DepartmentJoin getEmployeeByDepartment(int deptId) throws SQLException;

	

	List<DepartmentJoin> getEmployeeByLocation(String deptloc) throws SQLException;
	
	
}