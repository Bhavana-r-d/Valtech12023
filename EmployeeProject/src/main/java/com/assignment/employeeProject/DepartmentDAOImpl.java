package com.assignment.employeeProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentDAOImpl implements DepartmentDAO{
	static Scanner scn = new Scanner(System.in);

	public void deleteDepartment(int deptId) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, deptId);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated:" + rowsUpdated);
		con.close();

	}

	public void updateDepartment(Department dep) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE EMPLOYEE SET DEPTNAME = ?, DEPTLOC = ? WHERE DEPTID = ?");
		populatePreparedStatmentFromDepartment(dep, ps);
		ps.setInt(3, dep.getDeptId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	public void createDepartment(Department dep) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO DEPARTMENT (DEPTID,DEPTNAME,DEPTLOCATION) VALUES(?,?,?)");
		populatePreparedStatmentFromDepartment(dep, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	private void populatePreparedStatmentFromDepartment(Department dep, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dep.getDeptId());
		ps.setString(2, dep.getDeptName());
		ps.setString(3, dep.getDeptLoc());
	
	}

	public List<Department> getAllDepartment() throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		List<Department> deps = new ArrayList<>();
		while (rs.next()) {

			deps.add(mapRowToDepartment(rs));
		
		}

		con.close();
		return deps;

	}

	public Department getDepartment(int deptId) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT DEPTID, DEPTNAME,DEPTLOC FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			Department d = mapRowToDepartment(rs);
			con.close();
			return d;

		} 
		else {

			System.out.println("No row with Id " + deptId + " found.");
			return null;

		}

	}
	
	public DepartmentJoin getEmployeeByDepartment(int deptId) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID, DEPTNAME,DEPTLOC FROM EMPLOYEE JOIN DEPARTMENT USING (DEPTID) WHERE DEPTID=?");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			DepartmentJoin dj = mapRowToDepartmentEmp(rs);
			con.close();
			return dj;

		} 
		else {

			System.out.println("No row with Id " + deptId + " found.");
			return null;

		}

	}
	
	public List<DepartmentJoin> getEmployeeByLocation(String deptLoc) throws SQLException {

		Connection con=getConnection();
		PreparedStatement ps=con
				.prepareStatement("SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID, DEPTNAME,DEPTLOC FROM EMPLOYEE JOIN DEPARTMENT USING (DEPTID) WHERE DEPTLOC=?");
		ps.setString(1, deptLoc);
		ResultSet rs=ps.executeQuery();
		List<DepartmentJoin> dj =new ArrayList<>();

		while(rs.next()) {
			dj.add(mapRowToDepartmentEmp(rs));
		}
		con.close();
		return dj;
	}
	


	private DepartmentJoin mapRowToDepartmentEmp(ResultSet rs) throws SQLException {

		DepartmentJoin dj = new DepartmentJoin();
		dj.setId(rs.getInt(1));
		dj.setName(rs.getString(2));
		dj.setAge(rs.getInt(3));
		dj.setExperience(rs.getInt(4));
		dj.setSeniority(rs.getInt(5));
		dj.setSalary(rs.getInt(6));
		dj.setDeptId(rs.getInt(7));
		dj.setDeptName(rs.getString(8));
		dj.setDeptLoc(rs.getString(9));
		return dj;

	}
	
	private Department mapRowToDepartment(ResultSet rs) throws SQLException {

		Department d = new Department();
		d.setDeptId(rs.getInt(1));
		d.setDeptName(rs.getString(2));
		d.setDeptLoc(rs.getString(3));
		return d;

	}

	static {

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "root");

	}

	public static void main(String[] args) throws SQLException {

		DepartmentDAO dao = new DepartmentDAOImpl();
		int ch;
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Update");
			System.out.println("4. Delete");
			System.out.println("5. Search");
			System.out.println("6. Get Employee By Department");
			System.out.println("7. Get Employee By Location");
			System.out.println("Enter your choice:");
			ch = scn.nextInt();
			System.out.println("------------------------------------------------------------------------------");
			switch (ch) {
			case 1:
				System.out.println("Enter the Department details");
				System.out.println("Department ID : ");
				int deptId = scn.nextInt();
				System.out.println("Department Names : ");
				scn.nextLine();
				String deptName = scn.nextLine();
				System.out.println("Department Location : ");
				String deptLoc = scn.nextLine();
				dao.createDepartment(new Department(deptId,deptName ,deptLoc));
				System.out.println(dao.getDepartment(deptId));
				break;
			case 2:
				System.out.println(dao.getAllDepartment());
				break;
			case 3:
				System.out.println("Enter the Department details");
				scn.nextLine();
				System.out.println("Department ID : ");
				int updatedeptId = scn.nextInt();
				System.out.println("Department Names : ");
				scn.nextLine();
				String updatedeptName = scn.nextLine();
				System.out.println("Department Location : ");
				scn.nextLine();
				String updatedeptLoc = scn.nextLine();
				dao.updateDepartment(new Department(updatedeptId,updatedeptName,updatedeptLoc));
				System.out.println(dao.getDepartment(updatedeptId));
				break;
			case 4:
				System.out.println("Enter the Department ID to delete");
				int de = scn.nextInt();
				dao.deleteDepartment(de);
				System.out.println("Department ID = "+de+" is been deleted");
				break;
			case 5:
				System.out.println("Enter the Department ID to search");
				int no = scn.nextInt();
				System.out.println(dao.getDepartment(no));
				break;
			case 6:
				System.out.println("Enter the Department ID to search for Employee details");
				int no1 = scn.nextInt();
				System.out.println(dao.getEmployeeByDepartment(no1));
				break;
			case 7:
				System.out.println("Enter the Department Loaction to search for Employee details");
				scn.nextLine();
				String deptloc = scn.nextLine();
				System.out.println(dao.getEmployeeByLocation(deptloc));
				break;
			default:
				System.out.println("Please enter a valid value");
				break;
			}
	}

}
