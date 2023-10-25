package firstWeb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
//1
	public List<Department> getAllDepartments() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM DEPARTMENT ");
		ResultSet rs = ps.executeQuery();
		List<Department> dept = new ArrayList<>();
		while (rs.next()) {
			dept.add(mapRowToDepartment(rs));
		}
		con.close();
		return dept;
	}

	private Department mapRowToDepartment(ResultSet rs) throws SQLException {
		Department e = new Department();
		e.setdeptId(rs.getInt(1));
		e.setdeptName(rs.getString(2));
		e.setdeptLoc(rs.getString(3));
		e.setlistOfEmp(rs.getInt(4));
		return e;
	}

//2.CreateDepartment
	@Override
	public void createDepartment(Department dept) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO DEPARTMENT(DEPTID,DEPTNAME,DEPTLOC,LISTOFEMP) VALUES(?,?,?,?)");
		PopulatePreparedStatement(dept, ps);
		int rowsUpdate = ps.executeUpdate();
		System.out.println("Rows Update: " + rowsUpdate);
		con.close();
	}

	private void PopulatePreparedStatement(Department dept, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dept.getdeptId());
		ps.setString(2, dept.getdeptName());
		ps.setString(3, dept.getdeptLoc());
		ps.setInt(4, dept.getlistOfEmp());

	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}

	public static void main(String[] args) throws SQLException {
		DepartmentDAO dept = new DepartmentDAOImpl();
//1.
		System.out.println(dept.getAllDepartments());
//2.	dept.createDepartment(new Department(105,"civil","davangere",30));
//		dept.createDepartment(new Department(106,"EEE","davangere",20));
//3 
		Department d1 = new Department();
//		dept.updateDepartment(d1);
		
//4.
		dept.deleteDepartment(101);
	
//5.
		System.out.println(dept.getDepartment(101));
		System.out.println(dept.getDepartment(103));
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE DEPARTMENT SET DEPTLOC='Bengaluru' WHERE DEPTID='105';");
//		PopulatePreparedStatement(dept, ps);
//		ps.setInt(1,dept.getdeptId());
		
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		con.close();

	}

	public void deleteDepartment(int deptId) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1,deptId);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows deleted" + rowsUpdated);
		con.close();
		
	}
	
	@Override

	public Department getDepartment(int deptId) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT DEPTID,DEPTNAME,DEPTLOC,LISTOFEMP FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Department dept= mapRowToDepartment(rs);
			con.close();
			return dept;
		} else {
			System.out.println("No Row with id= " + deptId + "found....");
			return null;
		}
		
	}

	@Override
	public int firstId() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					int id=rs.getInt(1);
					con.close();
					return id;
				}
	    
		return 0;
	}

	@Override
	public int nextId(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE WHERE ID>?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
				if(rs.next()) {
				    id=rs.getInt(1);
					con.close();
							}
				con.close();
				return id == 0 ? lastId(): id;
	}

	@Override
	public int previousId(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE WHERE ID<?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
				if(rs.next()) {
				    id=rs.getInt(1);
					con.close();
					
				}
				con.close();

		return id== 0 ? firstId():id;
	}

	@Override
	public int lastId() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					int id=rs.getInt(1);
					con.close();
			return id;
				}
				
		return 0;
		
	}

}