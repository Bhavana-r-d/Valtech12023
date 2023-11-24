package com.valtech.training.patternchecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternCheckerServiceImpl implements PatternCheckerService {

	@Override
	public Map<String, Integer> checkPatterns(List<String> phoneNumbers) {
		Map<String, Integer> phoneNumberScores = new HashMap<String, Integer>();

		for (String phoneNumber : phoneNumbers) {
			int score = 0;

			if (isAllDigitsSame(phoneNumber)) {
				score += 10;
			}

			if (isPalindrome(phoneNumber)) {
				score += 6;
			}

			if (hasRepeatedDigit(phoneNumber)) {
				score += 1;
			}

			if (hasAscendingSequence(phoneNumber)) {
				score += 2;
			}

			if (hasDescendingSequence(phoneNumber)) {
				score += 2;
			}

			if (hasConsecutiveSequence(phoneNumber)) {
				score += 3;
			}
			
			if(sumOfNumbersisOddorEven(phoneNumber)) {
				score+=1;
			}
			
			else if(!sumOfNumbersisOddorEven(phoneNumber)) {
				score+=1;
			}
		
			//Multiple of 5 or 3 or both
			score+=sumOfNumbersIsaMultipleofFiveorThree(phoneNumber);
			
			if(allDigitsAreOdd(phoneNumber)) {
				score+=1;
			}
			
			if(allDigitsAreEven(phoneNumber)) {
				score+=1;
			}
			
			if(numberAtOddPlacesIsSame(phoneNumber)) {
				score+=3;
			}
			
			if(numbersAtOddAndEvenBothAreSame(phoneNumber)) {
//				System.out.println(phoneNumber);
				score+=3;
			}

			phoneNumberScores.put(phoneNumber, score);

			// Should be done in mobile ranking
//          PhoneNumberScore phoneScore = new PhoneNumberScore(phoneNumber, score);
//
//          if (score > 0) {
//              fancyNumbers.add(phoneScore);
//          } else {
//              nonFancyNumbers.add(phoneScore);
//          }
		}

		// Same here too
//      List<PhoneNumberScore> combinedList = new ArrayList<>();
//      combinedList.addAll(fancyNumbers);
//      combinedList.addAll(nonFancyNumbers);

		return phoneNumberScores;
	}

	private boolean numbersAtOddAndEvenBothAreSame(String phoneNumber) {
//		"^(\\d)(\\d)\\1\\2\\1\\2\\1\\2\\1\\2$"
		return phoneNumber.matches("^(\\d)(\\d)\\1\\2\\1\\2\\1\\2\\1\\2$");
	}

	private boolean numberAtOddPlacesIsSame(String phoneNumber) {
//		"(\d)\d\1\d\1\d\1\d\1\d"
		return phoneNumber.matches("(\\d)\\d\\1\\d\\1\\d\\1\\d\\1\\d");
	}

	private boolean allDigitsAreEven(String phoneNumber) {
		return phoneNumber.matches("^[13579]{10}$");
	}

	private boolean allDigitsAreOdd(String phoneNumber) {
		return phoneNumber.matches("^[02468]{10}$");
	}

	private int sumOfNumbersIsaMultipleofFiveorThree(String phoneNumber) {
		int sumOfNumbers=0;
		for (int i = 0; i < phoneNumber.length(); i++) {
			sumOfNumbers+=Character.getNumericValue(phoneNumber.charAt(i));
		}
		if(sumOfNumbers%5==0 && sumOfNumbers%3==0) {
			return 3;
		}
		else if(sumOfNumbers%3==0) {
			return 1;
		}
		else if(sumOfNumbers%5==0) {
			return 2;
		}
		return 0;
	}

	private boolean sumOfNumbersisOddorEven(String phoneNumber) {
		int oddOrEven=0;
		for (int i = 0; i < phoneNumber.length(); i++) {
			oddOrEven+=Character.getNumericValue(phoneNumber.charAt(i));
		}
		if(oddOrEven%2==0) {
			return true;
		}
		return false;
	}

	private static boolean isAllDigitsSame(String phoneNumber) {
		return phoneNumber.matches("^(.)\\1*$");
	}

	private static boolean isPalindrome(String phoneNumber) {
		String reversed = new StringBuilder(phoneNumber).reverse().toString();
		return phoneNumber.equals(reversed);
	}

	private static boolean hasRepeatedDigit(String phoneNumber) {
		return phoneNumber.matches(".*(\\d)\\1.*");
	}

	public static boolean hasAscendingSequence(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() < 10) {
			return false;
		}

		for (int i = 0; i <= phoneNumber.length() - 4; i++) {
			if (isAscending(phoneNumber.substring(i, i + 4))) {
				return true;
			}
		}

		return false;
	}

	private static boolean isAscending(String substring) {
		boolean isAscending = true;
		for (int i = 0; i < substring.length() - 1; i++) {
			if (substring.charAt(i + 1) <= substring.charAt(i)) {
				isAscending = false;
				break;
			}
		}
		return isAscending;
	}

	public static boolean hasDescendingSequence(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() < 4) {
			return false;
		}

		for (int i = 0; i <= phoneNumber.length() - 4; i++) {
			if (isDescending(phoneNumber.substring(i, i + 4))) {
				return true;
			}
		}

		return false;
	}

	private static boolean isDescending(String substring) {
		boolean isDescending = true;
		for (int i = 0; i < substring.length() - 1; i++) {
			if (substring.charAt(i + 1) >= substring.charAt(i)) {
				isDescending = false;
				break;
			}
		}
		return isDescending;
	}

	public static boolean hasConsecutiveSequence(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() < 4) {
			return false;
		}

		for (int i = 0; i <= phoneNumber.length() - 4; i++) {
			if (isConsecutive(phoneNumber.substring(i, i + 4))) {
				return true;
			}
		}

		return false;
	}

	private static boolean isConsecutive(String substring) {
		for (int i = 0; i < substring.length() - 1; i++) {
			if (substring.charAt(i + 1) - substring.charAt(i) != 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<String> phoneNumbers=Arrays.asList("9880928712","9916878237","9999999991","9915737911","8860244821","1111122222","1212121212","8317360584","9353891317");
	
		PatternCheckerServiceImpl checker=new PatternCheckerServiceImpl();
		Map<String,Integer> answer=checker.checkPatterns(phoneNumbers);
		System.out.println(answer);
	}

}


/*
 
 1. ^(.)\\1*$" [All Numbers are same]
 	-> ^: Asserts the start of the string.
	-> (.): Captures any single character (except for a newline character) and places it in a capturing group.
	-> \\1*: Matches zero or more occurrences of the same character captured in the first capturing group. The \\1 is a backreference to the first capturing group (i.e., it refers to the same character captured earlier).
	-> $: Asserts the end of the string. 
	
 2. .*(\\d)\\1.* [Repetitive Numbers]
 	-> .*: Matches any sequence of characters (except for a newline).
	-> (\\d): Captures a digit (0-9) and places it in a capturing group.
	-> \\1: Matches the same digit that was captured in the first capturing group. This is a backreference to the first capturing group.
	-> .*: Matches any sequence of characters (except for a newline).
*/

