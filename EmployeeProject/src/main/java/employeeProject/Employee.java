package employeeProject;

public class Employee extends EmpDep{
	

	public Employee() {
	}

	public Employee(String name, int age, int experience, int seniority, int salary) {

		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(int id, String name, int age, int experience, int seniority, int salary,int deptId) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.seniority = seniority;
		this.salary = salary;
		this.deptId=deptId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", experience=" + experience + ", seniority="
				+ seniority + ", salary=" + salary + ",deptId= "+deptId+"]\n";
	}

	
}
