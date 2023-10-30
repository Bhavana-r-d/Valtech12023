package phoneNumber.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import phoneNumber.FancyPhoneNumber;

class FancyPhoneNumberTest {

	@Test
	public void testIsAllDigitsSame() {
		assertTrue(FancyPhoneNumber.isAllDigitsSame("1111111"));
		assertFalse(FancyPhoneNumber.isAllDigitsSame("1475756686"));
	}
	
	@Test
	public void testIsPalindrome() {
		assertTrue(FancyPhoneNumber.isPalindrome("123454321"));
		assertFalse(FancyPhoneNumber.isPalindrome("12341"));
	}
	
	
	@Test
	public void testHasRepeatedDigit() {
		assertTrue(FancyPhoneNumber.hasRepeatedDigit("2233445566"));
		assertFalse(FancyPhoneNumber.hasRepeatedDigit("1234567890"));
	}
	
	@Test
	public void testIsAscendingOrder() {
		assertTrue(FancyPhoneNumber.isAscendingOrder("123456789"));
		assertFalse(FancyPhoneNumber.isAscendingOrder("6543213456"));
	}
	@Test
	public void testIsDescendingOrder() {
		assertTrue(FancyPhoneNumber.isDescendingOrder("9877665543"));
		assertFalse(FancyPhoneNumber.isDescendingOrder("6543213456"));
	}
	
	@Test
	public void testHasConsecutiveSequence() {
		assertTrue(FancyPhoneNumber.hasConsecutiveSequence("0123456789"));
		assertFalse(FancyPhoneNumber.hasConsecutiveSequence("564327865"));
	}
	
	
	
	
	
@Test
public void testRankFancyPhoneNumbers() {
	List<String> phoneNumbers=new ArrayList<>();
	phoneNumbers.add("12345654321");
	phoneNumbers.add("999999999");
	phoneNumbers.add("987654321");
	phoneNumbers.add("123456789");
	phoneNumbers.add("1234512345");
	
	List<String> rankedPhoneNumbers=FancyPhoneNumber.rankFancyPhoneNumbers(phoneNumbers);
}

}
