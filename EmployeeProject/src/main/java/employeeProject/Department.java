package employeeProject;

public class Department extends EmpDep {
	public Department() {
	}

	public Department(int deptId, String deptName, String deptLoc) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public Department(String deptName, String deptLoc) {
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public String toString() {
		return "Department[deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]\n";
	}
}
