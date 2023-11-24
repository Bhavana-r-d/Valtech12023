package com.valtech.springemployeemanagement.model;

import java.util.List;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.entities.Employee;


public class DepartmentModel {

	private int deptId;
	private String deptName;
	private String deptLoc;
	private List<Employee> employees;

	public DepartmentModel() {
	}

	public DepartmentModel(Department department) {
		this.deptId = department.getDeptId();
		this.deptName =department .getDeptName();
		this.deptLoc = department.getDeptLoc();
		
	}
	
	public Department getDepartment() {
		return new Department(deptId,deptName,deptLoc);
	}

	

	public int getDeptId() {
		return deptId; 
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	

	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employee) {
		this.employees = employee;
	}

}
