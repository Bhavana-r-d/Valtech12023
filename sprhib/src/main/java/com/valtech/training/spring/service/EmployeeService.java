package com.valtech.training.spring.service;

import com.valtech.training.hibernate.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee e);

	Employee makeActiveEmployee(Employee e);

	Employee makeInactiveEmployee(Employee e);

	Employee incrementSalary(Employee e, float increment);

	void incrementSalaryAll(int increment);

}