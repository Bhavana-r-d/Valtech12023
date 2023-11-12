package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;
@Repository //all DAO classes wil be defined using the Repository
//@Service for all classes that are service class.. they will need Tx support
//@Controller for all classes when we want them to be used for presentation logic
//@Component they are general classes which have to be registtered with beanFactory

public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void deleteEmployee(Employee emp) {
		Session ses = sessionfactory.openSession();
		ses.delete(emp);

	}

	@Override
	public Employee saveEmployee(Employee emp) {
		Session ses = sessionfactory.openSession();
		ses.persist(emp);
		return emp;

	}

	@Override
	public Employee loadEmployee(int empId) {
		Session ses = sessionfactory.openSession();
		Employee emp = (Employee) ses.load(Employee.class, empId);

		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Session ses = sessionfactory.openSession();
		emp = (Employee) ses.merge(emp);

		return emp;

	}

	@Override
	public List<Employee> getAllEmployee() {
		Session ses = sessionfactory.openSession();
		List<Employee> emps = ses.createQuery("from Employee e").list();
		
		return emps;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
}
