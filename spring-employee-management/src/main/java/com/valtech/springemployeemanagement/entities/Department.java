package com.valtech.springemployeemanagement.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	private String deptName;
	private String deptLoc;

	@OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY, mappedBy = "department")
	private List<Employee> employee;

	public Department() {
	}

	public Department(String deptName, String deptLoc) {
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		
	}

	public Department(int deptId, String deptName, String deptLoc) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		
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
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	



}
