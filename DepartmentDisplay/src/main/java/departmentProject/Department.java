package departmentProject;

public class Department {
	private int deptId;
	private String deptName;
	private String deptLoc;
	private int listOfEmp;
	
	public Department() {}

	public Department(int deptId, String deptName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public Department(int deptId, String deptName, String deptLoc, int listOfEmp) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.listOfEmp = listOfEmp;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + ", listOfEmp="
				+ listOfEmp + "]";
	}

	
	public Department(String deptName, String deptLoc, int listOfEmp) {
		super();
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.listOfEmp = listOfEmp;
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

	public int getEmpList() {
		return listOfEmp;
	}

	public void setlistOfEmp(int listOfEmp) {
		this.listOfEmp = listOfEmp;
	}
	
	
	
	
}
