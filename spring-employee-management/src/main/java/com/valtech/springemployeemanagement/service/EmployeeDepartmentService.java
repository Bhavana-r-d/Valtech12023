package com.valtech.springemployeemanagement.service;

import java.util.List;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.entities.Employee;

public interface EmployeeDepartmentService {
	
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee getEmployee(int id);
	List<Employee> getAllEmployee();
	void deleteEmployee(int id);
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployees();
	
	
	Department createDepartment(Department department) ;
	Department updateDepartment(Department department) ;
	Department getDepartmentById(int deptId) ;
	List<Department> getAllDepartments();
	void deleteDepartment(int deptId);
	List<Employee> getAllEmployeesByDepartment(int id);
	
	
	int getFirstId();
    int getLastId();
    int getPreviousId(int id);
    int getNextId(int id);

}

