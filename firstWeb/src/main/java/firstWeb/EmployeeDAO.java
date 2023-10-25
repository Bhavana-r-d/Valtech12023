package firstWeb;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

	void deleteEmployee(int id) throws SQLException;
	
	int firstId() throws SQLException;
	int nextId(int id) throws SQLException;
	int previousId(int id) throws SQLException;
	int lastId() throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;
	
	
	Employee getEmployee(int id) throws SQLException;
	
	long count() throws SQLException;

	List<Employee> getEmployeeAgeBetween(int minAge, int maxAge) throws SQLException;

	Map<String, List<String>> getListOfEmployeesInEachDepartment() throws SQLException;

	List<Employee> getEmployeeSalaryLesser(int maxSalary) throws SQLException;

	List<Employee> getEmployeeSalaryGreater(int amount) throws SQLException;

	

	

	

}
