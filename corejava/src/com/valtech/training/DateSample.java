package com.valtech.training;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {
	public static void main(String[] args) {
		// index the year for 1900
		// Mon index with 0
		// index day with 1
		Date date = new Date(47, 7, 15);
		System.out.println(date);
//		

		LocalDate now = LocalDate.of(1947, 8, 15);
		System.out.println(now);
	}
}