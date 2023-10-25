package firstWeb;



import java.sql.SQLException;
import java.util.List;



public interface DepartmentDAO {
	

	int firstId() throws SQLException;
	int nextId(int id) throws SQLException;
	int previousId(int id) throws SQLException;
	int lastId() throws SQLException;
	
	void deleteDepartment(int deptId) throws SQLException;
	void updateDepartment(Department dept) throws SQLException;
	void createDepartment(Department dept) throws SQLException ;	
	
	Department getDepartment(int deptId) throws SQLException;

	List<Department> getAllDepartments() throws SQLException;
	

	
	
	
}
