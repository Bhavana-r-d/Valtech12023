package com.valtech.training.day2.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.valtech.training.day2.Arithmetic;
import com.valtech.training.day2.ArithmeticImpl;
import com.valtech.training.day2.DivideByZeroException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	void aftereach() {
		System.out.println("destroy...");
	}

	@Test
	@DisplayName("Yo check if the +ve Nos,-ve Nos are added correctly")
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

		assertEquals(-1, arithmetic.sub(2, 3));
		assertEquals(1, arithmetic.sub(3, 2));
		assertEquals(5, arithmetic.sub(5, 0));
		assertEquals(-5, arithmetic.sub(-5, 0));
		assertEquals(1, arithmetic.sub(-2, -3));
		assertEquals(-11, arithmetic.sub(-8, 3));
	}

	@Test
	void testDivByZero() {
		assertThrows(DivideByZeroException.class, () -> arithmetic.div(5, 0));
	}

	@Test
	void testDiv() {
		assertEquals(1.666, 5.0 / 3, 0.001, "value not in range");// imp it show error assertEquals(1.666,5.0/3);
		assertEquals(2, arithmetic.div(4, 2));
		assertEquals(2, arithmetic.div(-6, -3));
		try {
			assertEquals(0, arithmetic.div(4, 0));
			fail("Should have throw ArithmeticException ");
		} catch (DivideByZeroException ex) {

		}

	}

	@Test
	void testMul() {
		assertEquals(10, arithmetic.mul(2, 5));
		assertEquals(10, arithmetic.mul(-2, -5));
		assertEquals(-10, arithmetic.mul(-2, 5));
		assertEquals(-10, arithmetic.mul(2,- 5));
		assertEquals(0, arithmetic.mul(2, 0));
		assertEquals(0, arithmetic.mul(0, 5));

	}

	static Stream<Arguments> addArgsGenerator() {
		return Stream.of(Arguments.of(1, 2, 3), Arguments.of(-1, 2, 1), Arguments.of(-1, -2, -3),
				Arguments.of(1, -2, -1)

		);
	}

	@ParameterizedTest(name = "add with csv {0}+{1}={2}")
	@MethodSource(value = { "addArgsGenerator" }) // this should be static
	void testWithMethod(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));

	}

	@ParameterizedTest(name = "add with csv {0}+{1}={2}")
	@CsvFileSource(files = { "add.csv" })
	void testWithCSVFile(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));

	}

	@ParameterizedTest(name = "add with csv {0}+{1}={2}")
	@CsvSource(value = { "2,3,5", "-2,3,1", "5,-3,2", "-5,-6,-11" })
	void testWithCSVParams(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));
	}

	@ParameterizedTest(name = "Add with {0}") // allows to pass arguments
	@ValueSource(strings = { "2,3,5", "-2,3,1", "5,-3,2", "-5,-6,-11" })
	void testAddWithParams(String value) {
		String[] parts = value.split(",");
		List<Integer> values = Arrays.asList(parts).stream().map(it -> Integer.parseInt(it))
				.collect(Collectors.toList());
		assertEquals(values.get(2), arithmetic.add(values.get(0), values.get(1)));

	}
}
