package com.valtech.training.spring.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Arithmetic;

class AOPTest {
	private ClassPathXmlApplicationContext appCtx;

	@BeforeEach
	void initialize() {
		appCtx = new ClassPathXmlApplicationContext("aop.xml");

	}

	@AfterEach
	void closeall() {
		appCtx.close();
	}

	@Test
	void test() {
		Arithmetic arith = (Arithmetic) appCtx.getBean(Arithmetic.class);
		System.out.println(arith.getClass().getName());
		assertEquals(5, arith.add(2, 3));
		assertEquals(1, arith.sub(2, 3));
		assertEquals(6, arith.add(3, 3));
		assertEquals(6, arith.add(-3, -3));
	    try {
	    	arith.div(5, 0);
	    	fail("No exception occoured");
	    }catch(Exception e) {
	    	
	    }
	
	}

}
