package com.assignment.employeeProject;



public class DepartmentJoin extends EmpDep {
	
	public DepartmentJoin() {
	}

	public DepartmentJoin(int id, String name, int age, int experience, int seniority, int salary, int deptId, String deptName, String deptLoc) {
		this.id = id;
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.deptId = deptId;
		this.deptName = deptName ;
		this.deptLoc = deptLoc;
	}
	
	public String toString(){
		return "Employee_Details[id=" + id + ", name=" + name+", age=" + age +", experience=" + experience +", seniority=" + seniority + ", salary=" + salary + ",deptId="+deptId+", deptName=" + deptName+", deptLoc=" + deptLoc +"]\n";
	}

}

