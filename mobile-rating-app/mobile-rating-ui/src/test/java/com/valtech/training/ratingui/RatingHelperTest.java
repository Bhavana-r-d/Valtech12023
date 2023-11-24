package com.valtech.training.ratingui;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class RatingHelperTest extends TestCase {
	public void testGetRating() {
		RatingHelper ratingNumbers=new RatingHelper();
		
		List<String> phoneNumbers=Arrays.asList("1234567890", "2345678901", "3456789012", "4567890123", "5678901234",
				"6789054321", "7890123456", "8901234567", "9012345678", "0123456789");

		int phoneNumberScore=ratingNumbers.rankNumber(phoneNumbers, phoneNumbers.get(5));
		
		assertEquals(6, phoneNumberScore);
	}
}
