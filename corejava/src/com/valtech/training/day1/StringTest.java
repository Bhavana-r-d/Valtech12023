package com.valtech.training.day1;

public class StringTest {

	public static void main(String[] args) {
		//creating string object
		String s="Hello World";
		String s1="Hello World";
		System.out.println(s==s1);
		final String s2="Hello";
		//final String s3=" World";
	    String s3=s2+" World";
		System.out.println(s==s3);
		System.out.println(s);
		System.out.println(s3 +" "+ s +" "+ s1 +" "+ s2);
		int a=10;
		char a1='a';
		System.out.println(a+" "+a1);

	}

}
