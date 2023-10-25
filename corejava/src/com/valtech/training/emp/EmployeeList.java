package com.valtech.training.emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeList {
	public static void main(String[] args) {
		List<Employee> employees =new ArrayList<>();
		
		employees.add(new Employee("Ram",10,2,45,300000));
		employees.add(new Employee("Ibbani",8,3,43,250000));
		employees.add(new Employee("Trilok",3,4,38,200000));
		employees.add(new Employee("Prashanth",30,15,52,600000));
		employees.add(new Employee("Shilpa",40,25,62,700000));
		employees.add(new Employee("Prashanth",30,15,52,600000));
		employees.add(new Employee("Rajeshwari",2,7,27,50000));
		employees.add(new Employee("Raju",2,8,27,50000));
		employees.add(new Employee("Arjun",2,9,27,50000));
		employees.add(new Employee("Arjun",4,10,26,50000));
		employees.add(new Employee("Adya",4,10,26,50000));
		employees.add(new Employee("Arun",2,10,26,500000));
		employees.add(new Employee("Arun",2,10,28,500000));

		
		Collections.sort(employees);
		
		for(Employee employee:employees) {
			System.out.println(employee);
		}
	}
}
