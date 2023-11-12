package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.Employee;
import com.valtech.training.firstspringboot.components.EmployeeDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;

import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.service.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {

	@Autowired
	private HelloWorld helloWorld;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private OrderService orderService;
	
//	@Autowired
//	private SimpleInterest simpleInterest;
//	
//	@Test
//	void testSI() {
//		simpleInterest.computeInterest(2000, 3, 3);
//	}

	@Test
	void testOrders() {
		Order o = orderService.createOrder(new Order("Macbook", 25, "For all emp", LocalDate.of(2023, 11, 8)));
		assertNotEquals(0, o.getId());
		assertTrue(orderService.getAllOrders().size() > 0);
	}


	@Test
	void testEmployeeDAO() {
//		assertEquals(13, employeeDAO.count());
//		assertEquals(13, employeeDAO.getAllEmployees().size());
		
		
		  //Create 
//		Employee emp=new Employee("Manu",22,1,1,20000);
//		 employeeDAO.createEmployee(emp); assertEquals(14,employeeDAO.count());
		 
//		//delete
		employeeDAO.deleteEmployee(10);
		assertEquals(13,employeeDAO.count());
	//update
	//	employeeDAO.updateEmployee();
		
		
	}

	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}

}
