package com.valtech.springemployeemanagement.service;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.entities.Employee;
import com.valtech.springemployeemanagement.repositories.DepartmentRepo;
import com.valtech.springemployeemanagement.repositories.EmployeeRepo;

@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	@PostConstruct
	public void populateEmployeeDepartment() {

		Department dept = new Department("HR", "Bangalore");
		Department dept1 = new Department("Marketing", "Bangalore");
		Department dept2 = new Department("Finance", "Bangalore");
		Department dept3 = new Department("IT", "Bangalore");
		Department dept4 = new Department("Operations", "Bangalore");
 
		Department dept5 = new Department("HR", "Pune");
		Department dept6 = new Department("Marketing", "Pune");
		Department dept7 = new Department("Finance", "Pune");
		Department dept8 = new Department("IT", "Pune");
		Department dept9 = new Department("Operations", "Pune");


		departmentRepo.save(dept);
		departmentRepo.save(dept1);
		departmentRepo.save(dept2);
		departmentRepo.save(dept3);
		departmentRepo.save(dept4);
		departmentRepo.save(dept5);
		departmentRepo.save(dept6);
		departmentRepo.save(dept7);
		departmentRepo.save(dept8);
		departmentRepo.save(dept9);

		Employee employee = new Employee("Bhavana", 22, 1, 1, 50000, dept);
		Employee employee1 = new Employee("Ruchitha", 23, 2, 1, 55000, dept1);
		Employee employee2 = new Employee("Amulya", 25, 4, 2, 60000, dept2);
		Employee employee3 = new Employee("Manu", 26, 5, 4, 100000, dept3);
		Employee employee4 = new Employee("sneha", 23, 2, 1, 54000, dept4);
		Employee employee5 = new Employee("Bharath", 42,20, 19, 190000, dept5);
		Employee employee6 = new Employee("Aksha", 53, 32, 31,220000, dept6);
		Employee employee7 = new Employee("Amogha", 49, 28, 9, 130000, dept7);
		Employee employee8 = new Employee("Manoj", 36, 10, 9, 90000, dept8);
		Employee employee9 = new Employee("Smaya", 42, 22, 21, 5004000, dept9);


		employeeRepo.save(employee);
		employeeRepo.save(employee1);
		employeeRepo.save(employee2);
		employeeRepo.save(employee3);
		employeeRepo.save(employee4);
		employeeRepo.save(employee5);
		employeeRepo.save(employee6);
		employeeRepo.save(employee7);
		employeeRepo.save(employee8);
		employeeRepo.save(employee9);

	}

	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println(employeeRepo.getClass().getName());
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeRepo.getReferenceById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public Department createDepartment(Department department) {
		System.out.println(departmentRepo.getClass().getName());
		return departmentRepo.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public Department getDepartmentById(int deptId) {
		return departmentRepo.getReferenceById(deptId);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepo.findAll();
	}

	@Override
	public void deleteDepartment(int deptId) {
		departmentRepo.deleteById(deptId);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);

	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepo.getReferenceById(id);	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public List<Employee> getAllEmployeesByDepartment(int id) {
		return employeeRepo.findEmployeeByDepartment(id) ;
	}

	@Override
	public int getFirstId() {
		return departmentRepo.findMinId();
	}

	@Override
	public int getLastId() {
		return departmentRepo.findMaxId();
	}

	@Override
	public int getPreviousId(int id) {
		int previousId =departmentRepo.findPreviousId(id);
		return (previousId==0)?getLastId():previousId;
	}

	@Override
	public int getNextId(int id) {
		int nextId=departmentRepo.findNextId(id);
		return (nextId==0)?getFirstId():nextId;
	}

}
