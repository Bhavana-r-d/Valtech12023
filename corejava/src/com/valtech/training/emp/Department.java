package com.valtech.training.emp;

import java.util.List;

public class Department  implements Comparable<Employee>{
	private int deptId;
	private String deptName;
	private String deptLoc;
	private int listOfEmp;



public Department(){}
public Department(String deptName,String deptLoc,int listOfEmp){
	this.deptName=deptName;
	this.deptLoc=deptLoc;
	this.listOfEmp= listOfEmp;
	
}

public Department(int deptId,String deptName,String deptLoc,int listOfEmp){
	this.deptId=deptId;
	this.deptName=deptName;
	this.deptLoc=deptLoc;
	this.listOfEmp=listOfEmp;
	
}

@Override
public String toString() {
	return "Department [deptId=" + deptId  + ", deptName=" + deptName +", deptLoc="
			+ deptLoc + ", listOfEmp=" + listOfEmp+ "]";
}

public int getdeptId() {
	return deptId;
	
}

public void setdeptId(int deptId) {
	this.deptId=deptId;
}

public String getdeptName() {
	return deptName;
	
}

public void setdeptName(String deptName) {
	this.deptName=deptName;
}
public String getdeptLoc() {
		return deptLoc;
		
	}

public void setdeptLoc(String deptLoc) {
		this.deptLoc=deptLoc;
}

public int getlistOfEmp() {
			return listOfEmp;
			
		}

public void setlistOfEmp(int listOfEmp) {
			this.listOfEmp=listOfEmp;
}
@Override
public int compareTo(Employee o) {
	// TODO Auto-generated method stub
	return 0;
}


}


