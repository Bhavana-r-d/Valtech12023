package com.valtech.training.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.valtech.training.emp.Department;
import com.valtech.training.emp.EmployeeDAO;
import com.valtech.training.emp.EmployeeDAOImpl;

public class EDepartmentDAOImpl implements EDepartmentDAO {

	private EdeptDao mapRowToEDepartment(ResultSet rs) throws SQLException {
		EDepartment e = new EDepartment();

		e.setDepName(rs.getString(1));
		e.setManager(rs.getString(2));
		e.setLocation(rs.getString(3));
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
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/valtech2023?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
	}

	public static void main(String[] args) throws Exception {
		EDepartmentDAO edpt = new EDepartmentDAOImpl();
		edpt.creatEDepartment(new EDepartment("P&C", "Krishna", "Bengaluru"));
		System.out.println("department table");

	}

	@Override
	public void creatEDepartment(EDepartment edpt) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO EDEPARTMENT(DEPNAME,MANAGERID,LOCATION)VALUES(?,?,?)");
		populatepreparedStatementfromedepartment(edpt, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		conn.close();

	}

	private void populatepreparedStatementfromedepartment(EDepartment edpt, PreparedStatement ps) throws SQLException {
		ps.setString(1, edpt.getDepName());
		ps.setString(2, edpt.getManager());
		ps.setString(3, edpt.getLocation());

	}
}
