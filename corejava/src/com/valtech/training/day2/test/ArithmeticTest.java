package com.valtech.training.day2.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.valtech.training.day2.Arithmetic;
import com.valtech.training.day2.ArithmeticImpl;
import com.valtech.training.day2.DivideByZeroException;

import org.junit.jupiter.api.Test;


@DisplayName(value = "")
class ArithmeticTest {

	private Arithmetic arithmetic;// = new ArithmeticImpl();
@BeforeAll
static void beforeAll() {
	System.out.println("beforeAll....");
}

@AfterAll
static void afterAll() {
	System.out.println("afterAll....");
}

	@BeforeEach
	void anything() {
		System.out.println("Init...");
		arithmetic = new ArithmeticImpl();
	}
	@AfterEach()
	void aftereach()
	{
		System.out.println("destroy...");
	}
	@Test @DisplayName("Yo check if the +ve Nos,-ve Nos are added correctly")
	void testAdd() {
		assertEquals(5, arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, 2));
		assertEquals(5, arithmetic.add(5, 0));
		assertEquals(5, arithmetic.add(5, -0));
		assertEquals(-5, arithmetic.add(-2, -3));
		assertEquals(-5, arithmetic.add(-8, 3));

	}

	@Test
	void testSub() {
//		fail("Not yet implemented");
	}
	@Test
	void testDivByZero() {
		assertThrows(DivideByZeroException.class,() ->arithmetic.div(5, 0));
	}

	@Test
	void testDiv() {
		assertEquals(1.666,5.0/3,0.001,"value not in range");//imp it show error assertEquals(1.666,5.0/3);
		assertEquals(2, arithmetic.div(4, 2));
		assertEquals(2, arithmetic.div(-6, -3));
		try {
			assertEquals(0, arithmetic.div(4, 0));
			fail("Should have throw ArithmeticException ");
		} catch (DivideByZeroException ex) {

		}
//		fail("Not yet implemented");
	}

	
	@Test
	void testMul() {

//		fail("Not yet implemented");
	}

}
