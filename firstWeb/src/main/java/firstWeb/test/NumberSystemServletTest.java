package firstWeb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import firstWeb.NumberSystemServlet;

class NumberSystemServletTest {

	@ParameterizedTest
	@CsvSource({
		"dec, 10, 20, 30",
		"oct, 10, 20, 36",
		"hex, 10, 20, 1E",
		"bin, 10, 20, 11110",
		"pow2, 0, 0, 100",
		"pow6, 0, 0, 1000000",
		"pow9, 0, 0, 1000000000",
		"pow-6, 0, 0,1E-06",
		"pow-9, 0, 0, 1E-09"
	})
	public void testConvert(String system,int input1,int input2,String expectedOutput) {
		NumberSystemServlet servlet = new NumberSystemServlet();
		String result=servlet.convert(system,input1,input2);
		assertEquals(expectedOutput,result);
	}
}
