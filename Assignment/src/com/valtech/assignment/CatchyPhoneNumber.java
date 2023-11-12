package com.valtech.assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatchyPhoneNumber {
	public static String getMostCatchyPhoneNumber(String[] phoneNumbers) {
		String bestNumber = "";
		int bestScore = Integer.MIN_VALUE;

		for (String number : phoneNumbers) {
			int score = calculateScore(number);
			if (score > bestScore) {
				bestScore = score;
				bestNumber = number;
			}
		}

		return bestNumber;
	}

	public static int calculateScore(String number) {
		int score = 0;

		// Pattern for repetitive numbers
		Pattern repetitivePattern = Pattern.compile("(\\d)\\1+");
		Matcher repetitiveMatcher = repetitivePattern.matcher(number);
		while (repetitiveMatcher.find()) {
			int repetitions = repetitiveMatcher.group().length();
			score += repetitions * repetitions; 
		}

		// Pattern for equal first and second halves
		int length = number.length();
		int halfLength = length / 2;
		String firstHalf = number.substring(0, halfLength);
		String secondHalf = number.substring(halfLength);
		if (firstHalf.equals(secondHalf)) {
			score += halfLength;
		}

		

		// Consecutive Digits
		Pattern consecutivePattern = Pattern.compile("(\\d)\\1{2}");
		Matcher consecutiveMatcher = consecutivePattern.matcher(number);
		while (consecutiveMatcher.find()) {
			score += 5;
		}

		// Sequential Numbers
		if (number.matches("12345678|23456789|34567890")) {
			score += 10; 
		}

		// Symmetrical Patterns
		if (isSymmetrical(number)) {
			score += 15; 
		}

		// Palindrome Numbers
		if (isPalindrome(number)) {
			score += 20; 
		}

		// Prime Numbers
		if (isPrime(number)) {
			score += 25;
		}

		// Fibonacci Numbers
		if (isFibonacci(Integer.parseInt(number))) {
			score += 30; 
		}

		return score;
	}

	public static boolean isSymmetrical(String number) {
		return new StringBuilder(number).reverse().toString().equals(number);
	}

	public static boolean isPalindrome(String number) {
		return new StringBuilder(number).reverse().toString().equals(number);
	}

	public static boolean isPrime(String number) {
		int num = Integer.parseInt(number);
		if (num <= 1)
			return false;
		if (num == 2 || num == 3)
			return true;
		if (num % 2 == 0 || num % 3 == 0)
			return false;
		int sqrtN = (int) Math.sqrt(num) + 1;
		for (int i = 5; i <= sqrtN; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0)
				return false;
		}
		return true;
	}

	public static boolean isFibonacci(int n) {
		int a = 0, b = 1;
		while (b < n) {
			int temp = b;
			b = a + b;
			a = temp;
		}
		return b == n;
	}

	public static void main(String[] args) {
		String[] phoneNumbers = {"12345678","1112222","12321","111111","88888888","567890123"};
		String bestNumber = getMostCatchyPhoneNumber(phoneNumbers);
		System.out.println("Best Phone Number: " + bestNumber);
	}
}