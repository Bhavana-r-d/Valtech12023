package com.valtech.training.emp;

import java.sql.SQLException;
import java.util.List;



public interface DepartmentDAO {
	void deleteDepartment(int deptId) throws SQLException;
	void updateDepartment(Department dept) throws SQLException;
	void createDepartment(Department dept) throws SQLException ;	
	
	Department getDepartment(int deptId) throws SQLException;

	List<Department> getAllDepartments() throws SQLException;
	

	
	
	
}
