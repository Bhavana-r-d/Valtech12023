package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//CRUD
//create,read,update,delete
import java.util.Map;

import com.mysql.cj.xdevapi.Statement;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static void main(String[] args) throws Exception {
		EmployeeDAO dao = new EmployeeDAOImpl();
//		System.out.println(dao.getEmployee(1));
//		System.out.println(dao.getEmployee(2));
//		dao.createEmployee(new Employee("priya", 39, 15, 3, 40000));
//		Employee e = dao.getEmployee(3);
//		e.setSeniority(5);
//		dao.updateEmployee(e);
//		dao.deleteEmployee(7);
//		dao.count();
//		System.out.println("no of employees are: "+dao.count());
//		System.out.println(dao.getAllEmployees());
//		System.out.println(dao.getEmployeeAgeBetween(1,2));

//// Call the getListOfEmployeeinEachDepartment method
//		        Map<String, List<String>> employeesByDepartment = dao.getListOfEmployeesInEachDepartment();
//// Iterate through the map and print the employees in each department
//		        for (Map.Entry<String, List<String>> entry : employeesByDepartment.entrySet()) {
//		            String departmentName = entry.getKey();
//		            List<String> employees = entry.getValue();
//		 
//		            System.out.println("Department: " + departmentName);
//		            System.out.println("Employees: " + employees);
//		        }

//		
//		int maxSalary = 50000;
//
//		List<Employee> employeesWithLowerSalary = dao.getEmployeeSalaryLesser(maxSalary);
//
//// Print the employees with salary less than maxSalary
//		for (Employee employee : employeesWithLowerSalary) {
//			System.out.println("Name: " + employee.getName() + ", Salary: " + employee.getSalary());
//		}

//		int amount = 100000;
//		
//				List<Employee> employeesWithSalaryGreater = dao.getEmployeeSalaryGreater(amount);
//		
//				for (Employee employee : employeesWithSalaryGreater) {
//					System.out.println("Name: " + employee.getName() + ", Salary: " + employee.getSalary());

//		List<Employee> empSeniority = dao.getEmployeeBySeniority();
//					for (Employee employee : empSeniority) {
//					System.out.println("Name: " + employee.getName() + ",Seniority: " + employee.getSeniority());

//		
//		    int limitVal = 5;
//	
//				List<Employee> limitSeniority= dao.getEmployeeBySeniority(limitVal);
//		
//				for (Employee employee : limitSeniority) {
//					System.out.println("Name: " + employee.getName() + ", Seniority: " + employee.getSeniority());

//		            String deptLoc = "Bengaluru";
//					List<Employee> empByDeptLoc= dao.getEmployeeByDeptLocation(deptLoc);
//					for (Employee employee : empByDeptLoc) {
//						System.out.println("Name: " + employee.getName() + ",Department Location: " + deptLoc);
//
//		String deptName = "Sales";
//		List<Employee> empByDeptName = dao.getEmployeeByDeptName(deptName);
//		for (Employee employee : empByDeptName) {
//			System.out.println("Name:" + employee.getName() + ",\nDepartment Location:" + deptName);
//			
		
		

		int minAge=10;
		int maxAge=29;
		List<Employee> empInAgeRange = dao.getEmployeeAgeBetween(minAge,maxAge);
		for (Employee employee : empInAgeRange) {
			System.out.println("Name:" + employee.getName() + ",Age:" + employee.getAge());
			
		}

	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rowUpdated = ps.executeUpdate();
		System.out.println("Rows updated" + rowUpdated);
		conn.close();

	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE EMPLOYEE SET NAME=?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=?,DEPTID=? WHERE ID=?");
		populatepreparedStatementfromemployee(emp, ps);
		ps.setInt(5, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		conn.close();

	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY)VALUES(?,?,?,?,?)");
		populatepreparedStatementfromemployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		conn.close();
	}

	private void populatepreparedStatementfromemployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			emps.add(mapRowToEmployee(rs));

		}
		conn.close();
		return emps;

	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = mapRowToEmployee(rs);
			conn.close();
			return e;
		} else {
			System.out.println("No Row with id= " + id + "found....");
			return null;
		}
	}
private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		return e;
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}

	@Override
	public long count() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		rs.next();
		long count = rs.getLong(1);
		conn.close();
		return count;
	}

	@Override
	public List<Employee> getEmployeeAgeBetween(int minAge, int maxAge) throws SQLException {
		

		List<Employee> emp = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
		ps.setInt(1, minAge);
		ps.setInt(2, maxAge);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employee e = mapRowtoEmployeeswithDeptID(rs);
			emp.add(e);
		}
		con.close();
		return emp;
	}


	@Override
	public Map<String, List<String>> getListOfEmployeesInEachDepartment() throws SQLException {
		Map<String, List<String>> employeesByDepartment = new HashMap<>();
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT d.deptName, e.name " + "FROM department d " + "JOIN employee e ON d.deptId = e.deptId");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String departmentName = rs.getString("deptName");
				String employeeName = rs.getString("name");
				List<String> employees = employeesByDepartment.getOrDefault(departmentName, new ArrayList<>());
				employees.add(employeeName);
				employeesByDepartment.put(departmentName, employees);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeesByDepartment;
	}

	@Override
	public List<Employee> getEmployeeSalaryLesser(int maxSalary) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM employee WHERE salary < ?");
			preparedStatement.setDouble(1, maxSalary);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Employee e = mapRowtoEmployeeswithDeptID(rs);
//		
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;

	}

	private Employee mapRowtoEmployeeswithDeptID(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setAge(rs.getInt("age"));
		employee.setExperience(rs.getInt("experience"));
		employee.setSeniority(rs.getInt("seniority"));
		employee.setSalary(rs.getInt("salary"));
		employee.setDeptId(rs.getInt("deptId"));
		return employee;

	}

	@Override
	public List<Employee> getEmployeeSalaryGreater(int amount) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE salary > ?");
			ps.setInt(1, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = mapRowtoEmployeeswithDeptID(rs);
//		
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;

	}

	public List<Employee> getEmployeeBySeniority(int limitVal) throws SQLException {
		List<Employee> emp = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE ORDER BY SENIORITY DESC LIMIT ?");
//		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE ORDER BY SENIORITY DESC");
			ps.setInt(1, limitVal);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = mapRowtoEmployeeswithDeptID(rs);
//	
				emp.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
//	
	}

	public List<Employee> getEmployeeByDeptLocation(String deptLoc) throws SQLException {
		List<Employee> emp = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTLOC=?)");
		ps.setString(1, deptLoc);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employee e = mapRowtoEmployeeswithDeptID(rs);
			emp.add(e);
		}
		con.close();
		return emp;

	}

	public List<Employee> getEmployeeByDeptName(String deptName) throws SQLException {
		List<Employee> emp = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTNAME=?)");
		ps.setString(1, deptName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employee e = mapRowtoEmployeeswithDeptID(rs);
			emp.add(e);
		}
		con.close();
		return emp;
	}

	@Override
	public int firstId() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastId() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
